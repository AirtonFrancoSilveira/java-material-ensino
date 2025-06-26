# Guia de Estudo: Arrays (Vetores) em Java

## O que é um Array (Vetor)?

Um **array** (ou vetor, em português) é a estrutura de dados mais fundamental em programação. Ele representa uma coleção de elementos de **mesmo tipo**, armazenados em um bloco **contíguo** de memória. A principal característica de um array em Java é seu **tamanho fixo**, que é definido no momento da sua criação e não pode ser alterado depois.

Cada elemento no array é acessado através de um **índice**, que é um número inteiro começando do zero.

`[ elemento 0 | elemento 1 | elemento 2 | ... | elemento N-1 ]`

## Principais Características

- **Tamanho Fixo:** Uma vez criado com um determinado tamanho, um array não pode crescer ou encolher. Para isso, seria necessário criar um novo array e copiar os elementos.
- **Acesso Rápido por Índice:** Acessar qualquer elemento pelo seu índice (ex: `meuArray[5]`) é uma operação extremamente rápida (complexidade O(1)), pois a posição na memória é calculada diretamente.
- **Tipo de Dados Homogêneo:** Um array só pode armazenar elementos do mesmo tipo (todos `int`, todos `String`, etc.).
- **Propriedade `length`:** Todo array possui um atributo público chamado `length` que retorna o seu tamanho (capacidade total). Note que é `length`, e não `length()` como em `String`.

## Declaração e Inicialização

Existem algumas maneiras de declarar e inicializar arrays em Java.

**1. Declarar e depois instanciar:**
```java
// Declara uma referência para um array de inteiros
int[] numeros;

// Aloca memória para 5 inteiros (inicializados com o valor padrão, que para int é 0)
numeros = new int[5];
```

**2. Declarar e instanciar na mesma linha (mais comum):**
```java
// Cria um array de Strings com capacidade para 10 elementos (inicializados com null)
String[] nomes = new String[10];
```

**3. Declarar e inicializar com valores (tamanho implícito):**
```java
// Cria um array de doubles com 3 elementos
double[] precos = {19.99, 25.50, 12.75};

// Cria um array de caracteres
char[] vogais = {'a', 'e', 'i', 'o', 'u'};
```

## Como Acessar e Modificar Elementos

O acesso é feito usando o nome do array seguido por colchetes `[]` contendo o índice desejado. Lembre-se que os índices começam em **zero**.

```java
int[] notas = new int[4]; // Array com 4 posições, índices de 0 a 3

// Modificando (atribuindo valores)
notas[0] = 8;
notas[1] = 9;
notas[2] = 7;
notas[3] = 10;
// notas[4] = 5; // ERRO! Lançaria uma ArrayIndexOutOfBoundsException

// Acessando (lendo valores)
System.out.println("A primeira nota é: " + notas[0]); // Saída: 8
System.out.println("A última nota é: " + notas[3]);   // Saída: 10
```

## Percorrendo um Array (Iteração)

A forma mais comum de passar por todos os elementos de um array é usando um laço de repetição.

**1. Usando um laço `for` clássico (permite acesso ao índice):**
```java
for (int i = 0; i < notas.length; i++) {
    System.out.println("Elemento no índice " + i + ": " + notas[i]);
}
```

**2. Usando um laço `for-each` (mais simples, sem acesso direto ao índice):**
```java
for (int nota : notas) {
    System.out.println("Nota: " + nota);
}
```

## Arrays Multidimensionais

Java também suporta arrays de arrays, conhecidos como arrays multidimensionais. O mais comum é o array de duas dimensões (2D), que pode ser visualizado como uma matriz ou tabela.

```java
// Cria uma matriz 2x3 (2 linhas e 3 colunas)
int[][] matriz = {
    {1, 2, 3},
    {4, 5, 6}
};

// Acessando o elemento na linha 1, coluna 2 (valor 6)
int elemento = matriz[1][2];
System.out.println(elemento);
```

## Erro Comum: `ArrayIndexOutOfBoundsException`

Este é um dos erros mais comuns ao trabalhar com arrays. Ele ocorre quando você tenta acessar um índice que não existe.

- **Índice negativo:** `meuArray[-1]`
- **Índice igual ou maior que o tamanho:** `meuArray[meuArray.length]`

Sempre garanta que seus acessos estejam dentro do intervalo `0` a `array.length - 1`. 