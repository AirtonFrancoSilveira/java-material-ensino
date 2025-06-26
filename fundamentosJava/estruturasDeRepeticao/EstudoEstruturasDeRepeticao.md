# Guia de Estudo: Estruturas de Repetição em Java

Em programação, muitas vezes precisamos executar o mesmo bloco de código várias vezes. Em vez de repetir o código manualmente, usamos **estruturas de repetição**, também conhecidas como **laços** ou **loops**. As principais em Java são `for`, `while` e `do-while`.

---

## 1. O Laço `for`

O laço `for` é ideal quando você **sabe de antemão quantas vezes** deseja repetir um bloco de código. Ele é compacto e agrupa a inicialização, a condição de término e o passo de incremento/decremento em uma única linha.

### Sintaxe

A estrutura do `for` é composta por três partes, separadas por ponto e vírgula:
1.  **Inicialização:** Executada apenas uma vez, no início. Geralmente, declara-se e inicializa-se uma variável de controle (contador).
2.  **Condição:** Verificada antes de cada iteração. Se for `true`, o bloco de código é executado. Se for `false`, o laço termina.
3.  **Incremento/Decremento:** Executado ao final de cada iteração. Geralmente, atualiza a variável de controle.

```java
for (inicialização; condição; incremento/decremento) {
    // Bloco de código a ser repetido
}
```

### Exemplo Prático
```java
// Imprime os números de 0 a 4
for (int i = 0; i < 5; i++) {
    System.out.println("O valor de i é: " + i);
}
```
**Como funciona:**
1.  `int i = 0;`: A variável `i` é criada e inicializada com 0.
2.  `i < 5;`: A condição é verificada (0 < 5 é `true`). O bloco é executado.
3.  `System.out.println(...)`: Imprime "O valor de i é: 0".
4.  `i++`: `i` é incrementado para 1.
5.  `i < 5;`: A condição é verificada (1 < 5 é `true`). O bloco é executado.
6.  ...O processo se repete até que `i` seja 5.
7.  `i < 5;`: A condição é verificada (5 < 5 é `false`). O laço termina.

### Laço "For-Each" (Enhanced For)
Existe uma variação do `for` para percorrer todos os elementos de um **array** ou **coleção** de forma mais simples e legível.

```java
String[] nomes = {"Ana", "João", "Maria"};

for (String nome : nomes) {
    System.out.println("Olá, " + nome);
}
```
---

## 2. O Laço `while`

O laço `while` (enquanto) é usado quando você quer repetir um bloco de código **enquanto uma condição for verdadeira**. Diferente do `for`, ele não tem uma estrutura fixa para inicialização e incremento, o que o torna ideal para situações onde o número de iterações não é conhecido de antemão.

### Sintaxe
```java
while (condição) {
    // Bloco de código a ser repetido
    // É crucial que algo dentro do bloco altere a condição para evitar um loop infinito!
}
```
A condição é verificada **antes** de cada iteração. Se for `false` na primeira vez, o bloco de código nunca é executado.

### Exemplo Prático
```java
int contador = 0;

while (contador < 3) {
    System.out.println("Contador: " + contador);
    contador++; // Se esquecer esta linha, o loop será infinito!
}
```

---

## 3. O Laço `do-while`

O `do-while` é uma variação do `while`. A principal diferença é que a condição é verificada **após** a execução do bloco de código. Isso garante que o bloco seja executado **pelo menos uma vez**, mesmo que a condição seja inicialmente falsa.

### Sintaxe
```java
do {
    // Bloco de código a ser repetido
} while (condição); // Note o ponto e vírgula no final
```

### Exemplo Prático
Usado com frequência para validar a entrada do usuário.

```java
import java.util.Scanner;

Scanner scanner = new Scanner(System.in);
int numero;

do {
    System.out.print("Digite um número positivo: ");
    numero = scanner.nextInt();
} while (numero <= 0);

System.out.println("Você digitou: " + numero);
```

---

## Palavras-chave `break` e `continue`

-   `break`: Interrompe e sai imediatamente do laço (seja `for`, `while` ou `do-while`).
-   `continue`: Pula a iteração atual e vai para a próxima.

### Exemplo com `break`
```java
for (int i = 0; i < 10; i++) {
    if (i == 5) {
        break; // Para o laço quando i for 5
    }
    System.out.println(i); // Imprime de 0 a 4
}
```

### Exemplo com `continue`
```java
for (int i = 0; i < 5; i++) {
    if (i == 2) {
        continue; // Pula a impressão quando i for 2
    }
    System.out.println(i); // Imprime 0, 1, 3, 4
}
``` 