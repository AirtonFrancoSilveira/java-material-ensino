# Guia de Estudo: Tipos Primitivos em Java

Os tipos primitivos são os blocos de construção fundamentais para a manipulação de dados em Java. Eles são chamados de "primitivos" porque não são objetos e armazenam diretamente o valor na memória, o que os torna muito eficientes.

Existem 8 tipos de dados primitivos em Java, divididos em quatro categorias:

1.  **Tipos Inteiros**: `byte`, `short`, `int`, `long`
2.  **Tipos de Ponto Flutuante (Decimais)**: `float`, `double`
3.  **Tipo Lógico**: `boolean`
4.  **Tipo de Caractere**: `char`

---

## 1. Tipos Inteiros

Esses tipos são usados para armazenar números inteiros (sem casas decimais), positivos ou negativos.

### `byte`

-   **Descrição**: O menor tipo de dado inteiro. Útil para economizar memória em arrays grandes, onde a economia de espaço é importante.
-   **Tamanho**: 8 bits (1 byte)
-   **Faixa de Valores**: -128 a 127
-   **Exemplo**:
    ```java
    byte temperaturaMinima = -10;
    byte idade = 25;
    System.out.println("Idade (byte): " + idade);
    ```

### `short`

-   **Descrição**: Duas vezes maior que um `byte`. Também pode ser usado para economizar memória quando os valores não excedem sua faixa.
-   **Tamanho**: 16 bits (2 bytes)
-   **Faixa de Valores**: -32.768 a 32.767
-   **Exemplo**:
    ```java
    short populacaoDeUmaVila = 15000;
    short anoDeFabricacao = 2023;
    System.out.println("Ano (short): " + anoDeFabricacao);
    ```

### `int`

-   **Descrição**: O tipo de dado inteiro mais comum e geralmente a escolha padrão para valores numéricos inteiros.
-   **Tamanho**: 32 bits (4 bytes)
-   **Faixa de Valores**: -2.147.483.648 a 2.147.483.647
-   **Exemplo**:
    ```java
    int salarioAnual = 60000;
    int numeroDeAlunos = 500;
    System.out.println("Salário Anual (int): " + salarioAnual);
    ```

### `long`

-   **Descrição**: Usado quando um `int` não é grande o suficiente para armazenar o valor. É necessário adicionar um `L` (maiúsculo ou minúsculo) ao final do número.
-   **Tamanho**: 64 bits (8 bytes)
-   **Faixa de Valores**: -9.223.372.036.854.775.808 a 9.223.372.036.854.775.807
-   **Exemplo**:
    ```java
    long populacaoMundial = 7800000000L;
    long distanciaAnosLuz = 100000000000000L;
    System.out.println("População Mundial (long): " + populacaoMundial);
    ```

---

## 2. Tipos de Ponto Flutuante

Usados para números que contêm uma parte fracionária (casas decimais).

### `float`

-   **Descrição**: Tipo de precisão simples. Requer um `f` (maiúsculo ou minúsculo) no final do valor. É menos preciso que o `double`.
-   **Tamanho**: 32 bits (4 bytes)
-   **Exemplo**:
    ```java
    float cotacaoDolar = 5.25f;
    float alturaEmMetros = 1.75f;
    System.out.println("Cotação do Dólar (float): " + cotacaoDolar);
    ```

### `double`

-   **Descrição**: Tipo de precisão dupla e a escolha padrão para valores decimais em Java. Oferece maior precisão que o `float`.
-   **Tamanho**: 64 bits (8 bytes)
-   **Exemplo**:
    ```java
    double precoDoProduto = 19.99;
    double pi = 3.14159265359;
    System.out.println("Preço (double): " + precoDoProduto);
    ```

---

## 3. Tipo Lógico

### `boolean`

-   **Descrição**: Representa apenas dois valores possíveis: `true` (verdadeiro) ou `false` (falso). É fundamental para o controle de fluxo (condições `if`, laços `while`, etc.).
-   **Tamanho**: Varia conforme a JVM, mas representa logicamente 1 bit.
-   **Exemplo**:
    ```java
    boolean isJavaFun = true;
    boolean temCafe = false;
    System.out.println("Java é divertido? " + isJavaFun);
    ```

---

## 4. Tipo de Caractere

### `char`

-   **Descrição**: Usado para armazenar um único caractere Unicode. O valor deve estar entre aspas simples (`'`).
-   **Tamanho**: 16 bits (2 bytes)
-   **Exemplo**:
    ```java
    char letraInicial = 'A';
    char simbolo = '@';
    char digito = '7';
    System.out.println("Letra Inicial (char): " + letraInicial);
    ```

---

## Tabela Resumo

| Tipo      | Tamanho   | Faixa de Valores / Descrição                           | Valor Padrão |
|-----------|-----------|--------------------------------------------------------|--------------|
| `byte`    | 8 bits    | -128 a 127                                             | 0            |
| `short`   | 16 bits   | -32.768 a 32.767                                       | 0            |
| `int`     | 32 bits   | -2³¹ a 2³¹-1                                           | 0            |
| `long`    | 64 bits   | -2⁶³ a 2⁶³-1                                           | 0L           |
| `float`   | 32 bits   | Números decimais (precisão simples)                    | 0.0f         |
| `double`  | 64 bits   | Números decimais (precisão dupla)                      | 0.0d         |
| `boolean` | 1 bit     | `true` ou `false`                                      | `false`      |
| `char`    | 16 bits   | Caracteres Unicode (ex: 'a', '@', '7')                 | '\u0000'     |

**Observação sobre Valor Padrão**: Os valores padrão são atribuídos automaticamente a variáveis de instância se elas não forem inicializadas explicitamente. Variáveis locais (declaradas dentro de métodos) não têm valor padrão e precisam ser inicializadas antes do uso. 