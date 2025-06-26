# Guia de Estudo: Estruturas Condicionais em Java

Estruturas condicionais permitem que um programa execute diferentes ações com base em diferentes condições. Elas são a base para a tomada de decisões na lógica de programação.

As principais estruturas condicionais em Java são: `if`, `if-else`, `if-else-if` e `switch`.

---

## 1. A Estrutura `if`

A instrução `if` é a mais simples. Ela executa um bloco de código **se, e somente se, uma condição for verdadeira (`true`)**.

### Sintaxe:
```java
if (condicao) {
    // Bloco de código a ser executado se a condição for verdadeira
}
```
- `condicao`: Uma expressão que resulta em um valor booleano (`true` or `false`).

### Exemplo:
```java
int idade = 20;

if (idade >= 18) {
    System.out.println("Você é maior de idade.");
}
```
Neste caso, como `idade` é 20, a condição `20 >= 18` é verdadeira, e a mensagem será impressa.

---

## 2. A Estrutura `if-else`

A instrução `if-else` oferece um caminho alternativo. Ela executa o bloco `if` se a condição for verdadeira, e o bloco `else` se a condição for falsa.

### Sintaxe:
```java
if (condicao) {
    // Bloco executado se a condição for verdadeira
} else {
    // Bloco executado se a condição for falsa
}
```

### Exemplo:
```java
int temperatura = 15;

if (temperatura > 25) {
    System.out.println("Está um dia quente.");
} else {
    System.out.println("Não está quente hoje.");
}
```
Como `15 > 25` é falso, o código dentro do bloco `else` será executado.

---

## 3. A Estrutura `if-else-if`

Para testar múltiplas condições em sequência, usamos a estrutura `if-else-if`. Java avalia cada condição de cima para baixo e executa o bloco de código da **primeira condição verdadeira** que encontrar. Se nenhuma for verdadeira, o bloco `else` final (se existir) é executado.

### Sintaxe:
```java
if (condicao1) {
    // Executado se a condicao1 for verdadeira
} else if (condicao2) {
    // Executado se a condicao1 for falsa e a condicao2 for verdadeira
} else if (condicao3) {
    // Executado se as duas primeiras forem falsas e a condicao3 for verdadeira
} else {
    // Executado se nenhuma das condições anteriores for verdadeira
}
```

### Exemplo:
```java
int nota = 85;

if (nota >= 90) {
    System.out.println("Conceito: A");
} else if (nota >= 80) {
    System.out.println("Conceito: B");
} else if (nota >= 70) {
    System.out.println("Conceito: C");
} else {
    System.out.println("Conceito: D (Reprovado)");
}
// Saída será "Conceito: B"
```

---

## 4. A Estrutura `switch`

A instrução `switch` é uma alternativa ao `if-else-if` para comparar o valor de uma variável com uma lista de valores possíveis (casos). É frequentemente mais legível quando há muitos casos a serem verificados.

### Principais características:
- **`case`**: Define um valor específico para comparar com a variável do `switch`.
- **`break`**: É crucial! Ele encerra a execução do `switch` assim que um caso correspondente é encontrado e executado. Sem o `break`, a execução "cairia" para os casos seguintes (fall-through).
- **`default`**: É opcional e funciona como o `else` final. É executado se nenhum dos `case` corresponder.

### Sintaxe:
```java
switch (variavel) {
    case valor1:
        // Código a ser executado se variavel == valor1
        break;
    case valor2:
        // Código a ser executado se variavel == valor2
        break;
    // ...outros casos...
    default:
        // Código a ser executado se nenhum caso corresponder
}
```
O `switch` funciona com os tipos `byte`, `short`, `char`, `int`, `String`, `enum` e wrappers correspondentes.

### Exemplo:
```java
int diaDaSemana = 4;
String nomeDoDia;

switch (diaDaSemana) {
    case 1: nomeDoDia = "Domingo"; break;
    case 2: nomeDoDia = "Segunda"; break;
    case 3: nomeDoDia = "Terça";   break;
    case 4: nomeDoDia = "Quarta";  break;
    case 5: nomeDoDia = "Quinta";  break;
    case 6: nomeDoDia = "Sexta";   break;
    case 7: nomeDoDia = "Sábado";  break;
    default: nomeDoDia = "Dia inválido";
}
System.out.println("Hoje é: " + nomeDoDia); // Saída: Hoje é: Quarta
```

---

## 5. Operador Ternário `? :`

O operador ternário é uma forma compacta de escrever uma instrução `if-else`. Ele é usado para atribuir um de dois valores a uma variável com base em uma condição.

### Sintaxe:
```java
variavel = (condicao) ? valor_se_verdadeiro : valor_se_falso;
```

### Exemplo:
```java
int idade = 18;
String status;

// Usando if-else tradicional
if (idade >= 18) {
    status = "Maior de idade";
} else {
    status = "Menor de idade";
}

// Usando operador ternário (resultado é o mesmo)
status = (idade >= 18) ? "Maior de idade" : "Menor de idade";

System.out.println(status);
```
O operador ternário é ótimo para atribuições condicionais simples, tornando o código mais conciso.
