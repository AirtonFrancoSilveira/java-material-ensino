package fundamentosJava.estruturaDeDados;

import java.util.Arrays;

/**
 * Esta classe demonstra o uso prático de Arrays (vetores) em Java.
 * Aborda declaração, inicialização, acesso, iteração e erros comuns.
 */
public class ExemplosArrays {

    public static void main(String[] args) {
        System.out.println("--- 1. Declaração e Inicialização ---");
        declaracaoEInicializacao();

        System.out.println("\n--- 2. Acesso e Modificação de Elementos ---");
        acessoEModificacao();

        System.out.println("\n--- 3. Iterando sobre um Array ---");
        iteracao();

        System.out.println("\n--- 4. Lidando com Erros Comuns ---");
        erroComum();

        System.out.println("\n--- 5. Exemplo de Array Multidimensional ---");
        arrayMultidimensional();

        System.out.println("\n--- 6. Usando a classe de utilidade Arrays ---");
        utilidadeArrays();
    }

    public static void declaracaoEInicializacao() {
        // Forma 1: Declara e depois aloca memória.
        // Os elementos são inicializados com valores padrão (0 para int).
        int[] arrayDeInteiros = new int[5];
        System.out.println("Array de inteiros inicializado: " + Arrays.toString(arrayDeInteiros));

        // Forma 2: Declara e inicializa com valores.
        // O tamanho do array é definido pela quantidade de elementos.
        String[] diasDaSemana = { "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado", "Domingo" };
        System.out.println("Array de Strings com dias da semana. Tamanho: " + diasDaSemana.length);
        System.out.println("O terceiro dia da semana é: " + diasDaSemana[2]); // Índices começam em 0
    }

    public static void acessoEModificacao() {
        double[] notas = new double[4];
        System.out.println("Array de notas inicial: " + Arrays.toString(notas));

        // Modificando os valores do array usando o índice
        notas[0] = 7.5;
        notas[1] = 8.0;
        notas[2] = 9.2;
        notas[3] = 6.8;
        // notas[4] = 10.0; // Isso causaria um erro (ArrayIndexOutOfBoundsException)

        System.out.println("Array de notas após modificação: " + Arrays.toString(notas));

        // Acessando um valor específico
        System.out.println("A segunda nota do aluno foi: " + notas[1]);

        // Alterando um valor existente
        notas[1] = 8.5;
        System.out.println("A segunda nota foi corrigida para: " + notas[1]);
    }

    public static void iteracao() {
        char[] vogais = { 'a', 'e', 'i', 'o', 'u' };
        System.out.println("Iterando com o laço 'for' tradicional:");

        // Laço "for" clássico: útil quando você precisa do índice.
        for (int i = 0; i < vogais.length; i++) {
            System.out.println("Índice " + i + " - Vogal: " + vogais[i]);
        }

        System.out.println("\nIterando com o laço 'for-each':");
        // Laço "for-each": mais simples e legível, usado quando o índice não é
        // necessário.
        for (char vogal : vogais) {
            System.out.println("Vogal: " + vogal);
        }
    }

    public static void erroComum() {
        int[] numeros = { 10, 20, 30 }; // Array de tamanho 3 (índices 0, 1, 2)

        try {
            // Tentando acessar um índice que não existe
            System.out.println("Tentando acessar o índice 3...");
            int numeroInexistente = numeros[3];
            System.out.println("Valor encontrado: " + numeroInexistente);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ERRO CAPTURADO! Mensagem: " + e.getMessage());
            System.out.println(
                    "Não é possível acessar um índice fora dos limites do array (0 a " + (numeros.length - 1) + ").");
        }
    }

    public static void arrayMultidimensional() {
        // Um array 2D para representar um tabuleiro de jogo da velha
        char[][] tabuleiro = new char[3][3];

        // Preenchendo o tabuleiro
        tabuleiro[0][0] = 'X';
        tabuleiro[0][1] = 'O';
        tabuleiro[0][2] = 'X';
        tabuleiro[1][0] = ' ';
        tabuleiro[1][1] = 'X';
        tabuleiro[1][2] = 'O';
        tabuleiro[2][0] = 'O';
        tabuleiro[2][1] = ' ';
        tabuleiro[2][2] = 'X';

        System.out.println("Exibindo o tabuleiro de Jogo da Velha (array 2D):");
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print(tabuleiro[i][j] + " | ");
            }
            System.out.println("\n-----------");
        }
    }

    public static void utilidadeArrays() {
        int[] numeros = { 5, 2, 8, 1, 9 };
        System.out.println("Array original: " + Arrays.toString(numeros));

        // Ordenando o array
        Arrays.sort(numeros);
        System.out.println("Array ordenado: " + Arrays.toString(numeros));

        // Buscando por um elemento (requer que o array esteja ordenado)
        int indice = Arrays.binarySearch(numeros, 8);
        System.out.println("O elemento 8 está no índice: " + indice);

        // Preenchendo um array com um valor
        int[] outrosNumeros = new int[5];
        Arrays.fill(outrosNumeros, 100);
        System.out.println("Array preenchido com o valor 100: " + Arrays.toString(outrosNumeros));
    }
}