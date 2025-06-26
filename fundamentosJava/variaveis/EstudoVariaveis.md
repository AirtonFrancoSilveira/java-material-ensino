# 📊 Guia de Estudo: Variáveis em Java

---

## 📚 Índice

1. [O que são Variáveis?](#o-que-sao-variaveis)
2. [Declarando e Inicializando Variáveis](#declarando-e-inicializando)
3. [Tipos de Variáveis em Java](#tipos-de-variaveis)
    - [Tipos Primitivos](#tipos-primitivos)
    - [Tipos de Referência](#tipos-de-referencia)
4. [Nomenclatura de Variáveis (Convenções)](#nomenclatura)
5. [Escopo de Variáveis](#escopo)
6. [Constantes](#constantes)

---

## 🎯 1. O que são Variáveis?

Em programação, uma **variável** é um contêiner que armazena um valor. Pense nela como uma "caixa" na memória do computador que possui um nome e guarda um dado que pode ser utilizado e modificado ao longo da execução do programa.

Cada variável em Java possui um **tipo** específico, que determina o tipo de dado que ela pode armazenar (números, texto, etc.) e a quantidade de memória que será alocada.

**Analogia:**
- **Nome da Variável:** A etiqueta na caixa (ex: `idadeDoUsuario`)
- **Tipo da Variável:** O que a caixa pode conter (ex: `números inteiros`)
- **Valor da Variável:** O conteúdo dentro da caixa (ex: `25`)

---

## 📝 2. Declarando e Inicializando Variáveis

**Declaração:** É o ato de "criar" a variável, definindo seu tipo e nome.
```java
// Sintaxe: tipo nomeDaVariavel;
int idade;
String nome;
double salario;
```

**Inicialização:** É o ato de atribuir um valor inicial à variável pela primeira vez.
```java
// Sintaxe: nomeDaVariavel = valor;
idade = 30;
nome = "Maria";
salario = 5500.50;
```

**Declaração e Inicialização na mesma linha (mais comum):**
```java
// Sintaxe: tipo nomeDaVariavel = valor;
int idade = 30;
String nome = "Maria";
double salario = 5500.50;
```

---

## 🏷️ 3. Tipos de Variáveis em Java

Existem dois tipos principais de variáveis em Java: **Primitivos** e de **Referência**.

### Tipos Primitivos

São os tipos de dados mais básicos, fornecidos diretamente pela linguagem. Eles armazenam valores simples e diretos.

| Tipo      | O que armazena         | Tamanho  | Exemplo de Valor      |
|-----------|------------------------|----------|-----------------------|
| `int`     | Números inteiros       | 4 bytes  | `10`, `-5`, `1000`    |
| `double`  | Números com casas decimais| 8 bytes  | `19.99`, `-0.5`, `3.14`|
| `char`    | Um único caractere     | 2 bytes  | `'A'`, `'!'`, `'c'`     |
| `boolean` | Valor verdadeiro ou falso| 1 bit    | `true`, `false`       |
| `long`    | Inteiros muito grandes | 8 bytes  | `9223372036854775807L`|
| `float`   | Decimais (menor precisão)| 4 bytes  | `3.14f`, `-2.5f`      |
| `short`   | Inteiros curtos        | 2 bytes  | `32000`, `-150`       |
| `byte`    | Inteiros muito curtos  | 1 byte   | `127`, `-128`         |

**Exemplos de código:**
```java
public class ExemploPrimitivos {
    public static void main(String[] args) {
        // Numéricos
        int quantidadeProdutos = 50;
        double precoProduto = 49.95;
        long populacaoMundial = 7800000000L; // Note o 'L' no final para long

        // Texto (caractere único)
        char primeiraLetra = 'J';
        char simbolo = '@';

        // Lógico
        boolean clienteAtivo = true;
        boolean pagamentoAprovado = false;

        System.out.println("Quantidade: " + quantidadeProdutos);
        System.out.println("Preço: " + precoProduto);
        System.out.println("Cliente está ativo? " + clienteAtivo);
        System.out.println("Primeira letra do nome: " + primeiraLetra);
    }
}
```

### Tipos de Referência (ou de Objeto)

Esses tipos não armazenam o valor diretamente. Em vez disso, eles guardam uma **referência** (um endereço de memória) que "aponta" para o local onde o objeto (o valor real) está armazenado.

Qualquer variável de uma **Classe** é um tipo de referência.

**`String` é o tipo de referência mais comum:**
- Usada para armazenar sequências de caracteres (texto).
- Embora pareça primitivo, `String` é uma classe em Java.

**Exemplos de código:**
```java
import java.util.ArrayList;
import java.util.List;

public class ExemploReferencias {
    public static void main(String[] args) {
        // String: armazena uma referência para o texto "Olá, Mundo!"
        String saudacao = "Olá, Mundo!";

        // List: armazena uma referência para um objeto ArrayList
        List<String> nomes = new ArrayList<>();
        nomes.add("Ana");
        nomes.add("Carlos");

        // Qualquer objeto de uma classe que você criar
        // Carro meuCarro = new Carro("Ford", "Mustang"); // (supondo que a classe Carro exista)

        System.out.println(saudacao.toUpperCase()); // Métodos podem ser chamados em objetos
        System.out.println("Primeiro nome da lista: " + nomes.get(0));
    }
}
```

**Diferença Chave:**
- **Primitivos:** `int a = 10; int b = a;` -> `b` recebe uma cópia do valor `10`. Mudar `b` não afeta `a`.
- **Referência:** `List<Integer> listaA = new ArrayList<>(); List<Integer> listaB = listaA;` -> `listaB` aponta para o **mesmo objeto** que `listaA`. Adicionar um item em `listaB` também adiciona em `listaA`.

---

## 📜 4. Nomenclatura de Variáveis (Convenções)

Seguir convenções torna seu código mais legível e profissional.

- **Use `camelCase`:** A primeira palavra começa com letra minúscula e as subsequentes com maiúscula.
  - ✅ `nomeCompleto`, `valorTotal`, `idadeDoAluno`
  - ❌ `nomecompleto`, `ValorTotal`, `idade_do_aluno`

- **Nomes devem ser descritivos:** O nome deve deixar claro o que a variável armazena.
  - ✅ `double precoFinal`
  - ❌ `double p`, `double val`

- **Não use abreviações** (a menos que sejam amplamente conhecidas, como `URL`).
  - ✅ `String nomeDoUsuario`
  - ❌ `String nmUsr`

- **Nomes não podem começar com números** nem conter a maioria dos símbolos especiais (exceto `$` e `_`, mas seu uso não é comum).

---

## 🎯 5. Escopo de Variáveis

O **escopo** define onde uma variável pode ser acessada no código.

- **Variáveis Locais:** Declaradas dentro de um método. Elas só existem e podem ser usadas dentro daquele método.
- **Parâmetros de Método:** Variáveis recebidas por um método. Também são locais àquele método.
- **Variáveis de Instância (ou de Classe):** Declaradas dentro de uma classe, mas fora de qualquer método. Elas pertencem a um objeto (instância) da classe e podem ser acessadas por todos os métodos daquele objeto.

**Exemplo de escopo:**
```java
public class EscopoExemplo {

    String variavelDeInstancia = "Eu sou visível em toda a classe"; // Variável de Instância

    public void meuMetodo(String parametro) { // Parâmetro
        String variavelLocal = "Eu só existo dentro deste método"; // Variável Local

        System.out.println(variavelDeInstancia); // OK
        System.out.println(parametro);           // OK
        System.out.println(variavelLocal);       // OK
    }

    public void outroMetodo() {
        System.out.println(variavelDeInstancia); // OK
        // System.out.println(parametro);        // ERRO! Fora do escopo
        // System.out.println(variavelLocal);    // ERRO! Fora do escopo
    }
}
```

---

## 🔒 6. Constantes

Uma **constante** é uma variável cujo valor não pode ser alterado após sua inicialização. Em Java, criamos constantes usando a palavra-chave `final`.

- **Convenção de Nomenclatura:** Use `SCREAMING_SNAKE_CASE` (todas as letras maiúsculas, separadas por `_`).

**Exemplo:**
```java
public class ExemploConstantes {
    // Declara uma constante para o número PI
    public static final double PI = 3.14159;
    
    // Constante para o número máximo de tentativas
    public static final int MAX_TENTATIVAS = 3;

    public static void main(String[] args) {
        System.out.println("O valor de PI é: " + PI);
        
        // A linha abaixo causaria um erro de compilação, pois o valor de uma constante não pode ser alterado.
        // PI = 3.14; // ERRO: cannot assign a value to final variable PI
    }
}
```
A palavra-chave `static` é frequentemente usada com `final` para que a constante pertença à classe, e não a cada objeto individual, economizando memória. 