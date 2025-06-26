package fundamentosJava.tiposPrimitivos;

/**
 * Esta classe contém exemplos práticos de declaração e inicialização
 * de todos os 8 tipos de dados primitivos em Java.
 */
public class ExemplosTiposPrimitivos {

    public static void main(String[] args) {

        System.out.println("--- Exemplos Práticos com Tipos Primitivos ---");

        // 1. byte: para números inteiros muito pequenos.
        byte temperaturaExterna = 28;
        System.out.println("Temperatura externa (byte): " + temperaturaExterna + "°C");

        // 2. short: para números inteiros curtos.
        short anoAtual = 2024;
        System.out.println("Ano atual (short): " + anoAtual);

        // 3. int: o tipo padrão para números inteiros.
        int populacaoDaCidade = 1250000;
        System.out.println("População da cidade (int): " + populacaoDaCidade);

        // 4. long: para números inteiros muito grandes (requer 'L' no final).
        long numeroDeEstrelasNaGalaxia = 200000000000L;
        System.out.println("Número de estrelas na galáxia (long): " + numeroDeEstrelasNaGalaxia);

        // 5. float: para números decimais (requer 'f' no final).
        float precoDoCafe = 8.50f;
        System.out.println("Preço do café (float): R$ " + precoDoCafe);

        // 6. double: o tipo padrão para números decimais, com maior precisão.
        double distanciaEntrePlanetas = 54.6e6; // 54.6 milhões de km
        System.out.println("Distância entre planetas (double): " + distanciaEntrePlanetas + " km");

        // 7. boolean: para valores lógicos de verdadeiro ou falso.
        boolean diaDeTrabalho = true;
        boolean temSol = false;
        System.out.println("Hoje é dia de trabalho? (boolean): " + diaDeTrabalho);
        System.out.println("Está ensolarado? (boolean): " + temSol);

        // 8. char: para um único caractere (use aspas simples).
        char primeiraLetraDoNome = 'J';
        char tipoSanguineo = 'O';
        char simboloConfirmacao = '+';
        System.out.println("Primeira letra do nome (char): " + primeiraLetraDoNome);
        System.out.println("Tipo Sanguíneo (char): " + tipoSanguineo + simboloConfirmacao);

        System.out.println("\n--- Operações Simples com Tipos Primitivos ---");

        int a = 10;
        int b = 5;
        int soma = a + b;
        double c = 7.5;
        double d = 2.5;
        double multiplicacao = c * d;

        System.out.println("Soma de " + a + " + " + b + " = " + soma);
        System.out.println("Multiplicação de " + c + " * " + d + " = " + multiplicacao);
    }
}