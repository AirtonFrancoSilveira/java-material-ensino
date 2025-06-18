# 📊 Guia de Estudo: Apache Beam e Google Cloud Dataflow

**Laboratório:** Serverless Data Processing with Dataflow - Writing an ETL pipeline using Apache Beam and Dataflow (Java)  
**Link:** https://www.cloudskillsboost.google/focuses/64779

---

## 🎯 Conceitos Fundamentais

### Apache Beam
- **Modelo unificado** para processamento de dados em batch e streaming
- **Portável**: pode executar em diferentes runners (Dataflow, Flink, Spark)
- **Linguagens**: Java, Python, Go
- **Open Source** com amplo suporte da comunidade

### Google Cloud Dataflow
- **Serviço gerenciado** para executar pipelines Apache Beam
- **Escalabilidade automática** de recursos computacionais
- **Serverless**: sem necessidade de gerenciar infraestrutura
- **Integração nativa** com outros serviços GCP

---

## 🏗️ Arquitetura do Pipeline

### Fluxo ETL Implementado
```
[Google Cloud Storage] → [Apache Beam Pipeline] → [BigQuery]
     events.json       →   Read → Transform → Write  →   logs.logs
```

### Transformações
```java
// 1. Leitura
PCollection<String> events = pipeline.apply("ReadLines", TextIO.read().from(input));

// 2. Transformação
PCollection<CommonLog> commonLogs = events.apply("JsonToCommonLog", ParDo.of(new JsonToCommonLog()));

// 3. Escrita
commonLogs.apply("WriteToBigQuery", BigQueryIO.<CommonLog>write().to(output).useBeamSchema());
```

---

## 💻 Código Completo Desenvolvido

### Classe Principal (MyPipeline.java)
```java
package com.mypackage.pipeline;

import com.google.gson.Gson;
import org.apache.beam.runners.dataflow.options.DataflowPipelineOptions;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.PipelineResult;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.io.gcp.bigquery.BigQueryIO;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.schemas.JavaFieldSchema;
import org.apache.beam.sdk.schemas.annotations.DefaultSchema;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyPipeline {
    private static final Logger LOG = LoggerFactory.getLogger(MyPipeline.class);

    public interface Options extends DataflowPipelineOptions {
    }

    public static void main(String[] args) {
        Options options = PipelineOptionsFactory.fromArgs(args).as(Options.class);
        run(options);
    }

    // Classe para representar os dados
    @DefaultSchema(JavaFieldSchema.class)
    public static class CommonLog {
        public String timestamp;
        public String user_id;
        public String http_request;
        public Long http_response;
        public String user_agent;
        public Double lat;
        public Double lng;
        public String ip;
        public Long num_bytes;
        
        public CommonLog() {}
    }

    // Transformação para converter JSON em CommonLog
    public static class JsonToCommonLog extends DoFn<String, CommonLog> {
        @ProcessElement
        public void processElement(@Element String json, OutputReceiver<CommonLog> receiver) {
            try {
                Gson gson = new Gson();
                CommonLog commonLog = gson.fromJson(json, CommonLog.class);
                receiver.output(commonLog);
            } catch (Exception e) {
                LOG.error("Erro ao processar JSON: " + json, e);
            }
        }
    }

    // Método principal do pipeline
    public static PipelineResult run(Options options) {
        Pipeline pipeline = Pipeline.create(options);
        options.setJobName("my-pipeline-" + System.currentTimeMillis());

        final String input = "gs://qwiklabs-gcp-00-be3eebd5bbbf/events.json";
        final String output = "qwiklabs-gcp-00-be3eebd5bbbf:logs.logs";

        // Pipeline ETL
        PCollection<String> events = pipeline
            .apply("ReadLines", TextIO.read().from(input));

        PCollection<CommonLog> commonLogs = events
            .apply("JsonToCommonLog", ParDo.of(new JsonToCommonLog()));

        commonLogs.apply("WriteToBigQuery", 
            BigQueryIO.<CommonLog>write()
                .to(output)
                .useBeamSchema()
                .withWriteDisposition(BigQueryIO.Write.WriteDisposition.WRITE_TRUNCATE)
        );

        LOG.info("Building pipeline...");
        return pipeline.run();
    }
}
```

### Dependências Maven (pom.xml)
```xml
<dependencies>
    <!-- Apache Beam Core -->
    <dependency>
        <groupId>org.apache.beam</groupId>
        <artifactId>beam-sdks-java-core</artifactId>
        <version>2.63.0</version>
    </dependency>
    
    <!-- Runners -->
    <dependency>
        <groupId>org.apache.beam</groupId>
        <artifactId>beam-runners-direct-java</artifactId>
        <version>2.63.0</version>
    </dependency>
    <dependency>
        <groupId>org.apache.beam</groupId>
        <artifactId>beam-runners-google-cloud-dataflow-java</artifactId>
        <version>2.63.0</version>
    </dependency>
    
    <!-- GCP Integration -->
    <dependency>
        <groupId>org.apache.beam</groupId>
        <artifactId>beam-sdks-java-io-google-cloud-platform</artifactId>
        <version>2.63.0</version>
    </dependency>
    
    <!-- Extensions -->
    <dependency>
        <groupId>org.apache.beam</groupId>
        <artifactId>beam-sdks-java-extensions-google-cloud-platform-core</artifactId>
        <version>2.63.0</version>
    </dependency>
    
    <!-- Logging -->
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-api</artifactId>
        <version>1.7.25</version>
    </dependency>
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-simple</artifactId>
        <version>1.7.25</version>
    </dependency>
</dependencies>
```

---

## 🚨 Problemas Encontrados e Soluções

### 1. Erro de Mapeamento JSON
**Problema:**
```
RuntimeException: Null value set on non-nullable field Field{name=event}
```

**Causa:** Schema da classe `CommonLog` não correspondia aos dados reais.

**Solução:** Adaptar classe aos dados reais:
```java
// Dados reais tinham campos diferentes
public String http_request;    // em vez de "event"
public Long http_response;     // em vez de "session_id"  
public String user_agent;     // campo adicional
public Double lat, lng;       // coordenadas
public String ip;             // IP do usuário
public Long num_bytes;        // bytes transferidos
```

### 2. Erro de Localização no Dataflow
**Problema:**
```
'us-central1' violates constraint 'constraints/gcp.resourceLocations'
```

**Soluções:**
- Tentar região diferente: `us-east1`
- Voltar para DirectRunner para desenvolvimento local
- Verificar regiões: `gcloud dataflow regions list`

### 3. Erro de TempLocation
**Problema:**
```
BigQueryIO.Write needs a GCS temp location to store temp files
```

**Solução:**
```bash
--tempLocation=gs://bucket-name/temp
```

---

## ⚡ Comandos Importantes

### Configuração do Ambiente
```bash
export PROJECT_ID=$(gcloud config get-value project)
export REGION='us-central1'
export PIPELINE_FOLDER=gs://${PROJECT_ID}
export MAIN_CLASS_NAME=com.mypackage.pipeline.MyPipeline
export RUNNER=DataflowRunner
```

### Execução Local (DirectRunner)
```bash
export RUNNER=DirectRunner
mvn compile exec:java \
-Dexec.mainClass=${MAIN_CLASS_NAME} \
-Dexec.args="--tempLocation=gs://bucket-name/temp"
```

### Execução na Nuvem (DataflowRunner)
```bash
export RUNNER=DataflowRunner
mvn compile exec:java \
-Dexec.mainClass=${MAIN_CLASS_NAME} \
-Dexec.cleanupDaemonThreads=false \
-Dexec.args=" \
--project=${PROJECT_ID} \
--region=${REGION} \
--stagingLocation=${PIPELINE_FOLDER}/staging \
--tempLocation=${PIPELINE_FOLDER}/temp \
--runner=${RUNNER}"
```

### BigQuery Operations
```bash
# Listar datasets
bq ls

# Listar tabelas
bq ls logs

# Consultar dados
bq query --use_legacy_sql=false \
'SELECT COUNT(*) as total FROM logs.logs'

# Ver schema
bq show --schema logs.logs

# Amostra de dados
bq query --use_legacy_sql=false \
'SELECT * FROM logs.logs LIMIT 10'
```

---

## 📊 Estruturas de Dados

### Exemplo de Dados de Entrada (JSON)
```json
{
  "timestamp": "2025-06-18T19:43:26.971204Z",
  "user_id": "7739795499273709612",
  "http_request": "\"GET coniferophyta.html HTTP/1.0\"",
  "http_response": 200,
  "user_agent": "Mozilla/5.0 (Windows NT 4.0) AppleWebKit/536.1",
  "lat": 39.969,
  "lng": -83.0114,
  "ip": "21.68.16.223",
  "num_bytes": 387
}
```

### Schema BigQuery Resultante
| Campo         | Tipo    | Modo     |
|---------------|---------|----------|
| timestamp     | STRING  | REQUIRED |
| user_id       | STRING  | REQUIRED |
| http_request  | STRING  | REQUIRED |
| http_response | INTEGER | REQUIRED |
| user_agent    | STRING  | REQUIRED |
| lat           | FLOAT   | REQUIRED |
| lng           | FLOAT   | REQUIRED |
| ip            | STRING  | REQUIRED |
| num_bytes     | INTEGER | REQUIRED |

---

## 🏃‍♂️ Runners: DirectRunner vs DataflowRunner

### DirectRunner
**Características:**
- ✅ Execução local
- ✅ Debugging rápido
- ✅ Ideal para desenvolvimento
- ❌ Não escalável
- ❌ Limitado pelos recursos da máquina

### DataflowRunner  
**Características:**
- ✅ Execução distribuída na nuvem
- ✅ Escalabilidade automática
- ✅ Monitoramento em tempo real
- ❌ Mais lento para iniciar
- ❌ Custos de computação

### Quando Usar Cada Um
| Cenário              | Runner Recomendado |
|----------------------|-------------------|
| Desenvolvimento      | DirectRunner      |
| Testes              | DirectRunner      |
| Debugging           | DirectRunner      |
| Produção            | DataflowRunner    |
| Datasets grandes    | DataflowRunner    |
| Processamento crítico| DataflowRunner   |

---

## 🔌 BigQuery Integration

### Write Dispositions
```java
// Recriar tabela (desenvolvimento)
.withWriteDisposition(BigQueryIO.Write.WriteDisposition.WRITE_TRUNCATE)

// Adicionar dados (produção)
.withWriteDisposition(BigQueryIO.Write.WriteDisposition.WRITE_APPEND)

// Apenas se vazia (segurança)
.withWriteDisposition(BigQueryIO.Write.WriteDisposition.WRITE_EMPTY)
```

### Schema Automático vs Manual
```java
// Automático com @DefaultSchema
.useBeamSchema()

// Manual
TableSchema schema = new TableSchema().setFields(Arrays.asList(
    new TableFieldSchema().setName("timestamp").setType("STRING").setMode("REQUIRED")
));
.withSchema(schema)
```

---

## 🎯 Melhores Práticas

### 1. Estrutura do Código
- Separar transformações em classes próprias
- Usar nomes descritivos para transformações
- Implementar tratamento de erros robusto
- Logging adequado para debugging

### 2. Gestão de Schema
- Validar dados de entrada antes do processamento
- Usar tipos apropriados (Long para IDs, Double para coordenadas)
- Considerar campos opcionais quando apropriado
- Documentar mudanças de schema

### 3. Performance
- Evitar operações custosas dentro de DoFn
- Usar PipelineOptions para configurações
- Considerar paralelização adequada
- Monitorar métricas de execução

### 4. Desenvolvimento
- Testar localmente com DirectRunner primeiro
- Usar datasets pequenos para desenvolvimento
- Implementar testes unitários para DoFn
- Versionamento de código adequado

---

## 🚀 Próximos Passos de Estudo

### 1. Conceitos Avançados
- **Windowing** para dados streaming
- **Triggers** para processamento temporal
- **Side Inputs** para dados auxiliares
- **State e Timers** para casos complexos

### 2. Padrões de Pipeline
- **Branching**: dividir pipeline em múltiplos caminhos
- **Joining**: combinar diferentes PCollections
- **Aggregations**: operações de soma, média, contagem
- **Error Handling**: dead letter queues

### 3. Integrações
- **Apache Kafka** para streaming
- **Cloud Pub/Sub** para mensagens
- **Cloud Spanner** para dados relacionais
- **Cloud ML** para machine learning

### 4. Templates e Parametrização
- **Dataflow Templates** para reutilização
- **Flex Templates** para maior flexibilidade
- **Pipeline Options** personalizadas
- **Configuração externa** via arquivos

---

## 📚 Recursos Adicionais

### Documentação Oficial
- [Apache Beam Programming Guide](https://beam.apache.org/documentation/programming-guide/)
- [Google Cloud Dataflow Documentation](https://cloud.google.com/dataflow/docs)
- [BigQuery Documentation](https://cloud.google.com/bigquery/docs)

### Exemplos Práticos
- [Apache Beam Examples](https://github.com/apache/beam/tree/master/examples/java)
- [Google Cloud Dataflow Templates](https://github.com/GoogleCloudPlatform/DataflowTemplates)

---

## 🎓 Resumo do Aprendizado

### O que Desenvolvemos
1. ✅ **Pipeline ETL completo** de GCS para BigQuery
2. ✅ **Transformação JSON** com Gson
3. ✅ **Schema automático** com Beam annotations
4. ✅ **Execução local e na nuvem**
5. ✅ **Tratamento de erros** e debugging

### Competências Adquiridas
- **Apache Beam**: conceitos fundamentais e desenvolvimento
- **Google Cloud Dataflow**: execução e monitoramento
- **BigQuery**: integração e schema management
- **Java**: programação com frameworks de big data
- **DevOps**: deployment e troubleshooting

### Aplicações Práticas
- **ETL pipelines** para data warehouses
- **Data lake processing** para analytics
- **Real-time streaming** para dashboards
- **ML data preparation** para modelos
- **Log processing** para observabilidade

---

**📝 Documento criado:** Junho 2025  
**🔗 Laboratório base:** [Cloud Skills Boost - Apache Beam ETL](https://www.cloudskillsboost.google/focuses/64779)  
**💡 Objetivo:** Referência de estudo para Apache Beam e Dataflow 