package fundamentosJava.estruturasDeRepeticao;

import java.util.Scanner;

/**
 * Esta classe demonstra o uso prático das estruturas de repetição em Java:
 * for, while, e do-while.
 */
public class ExemplosEstruturasDeRepeticao {

    public static void main(String[] args) {
        System.out.println("--- 1. Exemplo de Laço 'for' ---");
        exemploFor();

        System.out.println("\n--- 2. Exemplo de Laço 'for-each' (Enhanced for) ---");
        exemploForEach();

        System.out.println("\n--- 3. Exemplo de Laço 'while' ---");
        exemploWhile();

        System.out.println("\n--- 4. Exemplo de Laço 'do-while' ---");
        exemploDoWhile();

        System.out.println("\n--- 5. Exemplo de 'break' e 'continue' ---");
        exemploBreakContinue();
    }

    /**
     * Demonstra o laço 'for', ideal para quando o número de iterações é conhecido.
     */
    public static void exemploFor() {
        System.out.println("Contagem regressiva para o lançamento:");
        for (int i = 5; i > 0; i--) {
            System.out.println(i);
        }
        System.out.println("Lançar!");
    }

    /**
     * Demonstra o laço 'for-each', usado para iterar sobre todos os elementos de
     * um array ou coleção.
     */
    public static void exemploForEach() {
        String[] planetas = { "Mercúrio", "Vênus", "Terra", "Marte" };
        System.out.println("Planetas do sistema solar interior:");
        for (String planeta : planetas) {
            System.out.println("- " + planeta);
        }
    }

    /**
     * Demonstra o laço 'while', ideal para quando a condição de parada é
     * variável.
     */
    public static void exemploWhile() {
        int moedas = 0;
        int moedasNecessarias = 4;
        System.out.println("Coletando moedas para abrir a porta...");

        while (moedas < moedasNecessarias) {
            moedas++;
            System.out.println("Moeda coletada! Total: " + moedas);
        }
        System.out.println("Porta aberta!");
    }

    /**
     * Demonstra o laço 'do-while', que garante a execução do bloco ao menos uma
     * vez.
     * Útil para validação de entrada de usuário.
     */
    public static void exemploDoWhile() {
        Scanner scanner = new Scanner(System.in);
        String senha;

        do {
            System.out.print("Digite a senha (a senha é 'java'): ");
            senha = scanner.nextLine();
        } while (!senha.equals("java"));

        System.out.println("Acesso concedido!");
        scanner.close(); // É uma boa prática fechar o scanner quando não for mais usá-lo.
    }

    /**
     * Demonstra como 'break' pode sair de um loop e 'continue' pode pular uma
     * iteração.
     */
    public static void exemploBreakContinue() {
        System.out.println("Procurando o número 7 no laço (com break):");
        for (int i = 1; i <= 10; i++) {
            System.out.println("Verificando número " + i);
            if (i == 7) {
                System.out.println("Número 7 encontrado! Parando a busca.");
                break; // Sai do laço for
            }
        }

        System.out.println("\nImprimindo números ímpares de 1 a 10 (com continue):");
        for (int i = 1; i <= 10; i++) {
            // Se o número for par, pula para a próxima iteração
            if (i % 2 == 0) {
                continue; // Pula o resto do código desta iteração
            }
            System.out.println(i);
        }
    }
}