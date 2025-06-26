package fundamentosJava.estruturasCondicionais;

/**
 * Esta classe demonstra o uso prático das estruturas condicionais em Java:
 * if, if-else, if-else-if, switch e o operador ternário.
 */
public class ExemplosEstruturasCondicionais {

    public static void main(String[] args) {
        System.out.println("--- Exemplo com 'if' ---");
        verificarMaioridade(21);
        verificarMaioridade(16);

        System.out.println("\n--- Exemplo com 'if-else' ---");
        verificarAprovacao(7.5);
        verificarAprovacao(4.0);

        System.out.println("\n--- Exemplo com 'if-else-if' ---");
        categorizarNadador(8);
        categorizarNadador(15);
        categorizarNadador(20);

        System.out.println("\n--- Exemplo com 'switch' ---");
        descreverPlanoDeTelefonia("Turbo");
        descreverPlanoDeTelefonia("Básico");
        descreverPlanoDeTelefonia("Premium");

        System.out.println("\n--- Exemplo com Operador Ternário ---");
        verificarParOuImpar(10);
        verificarParOuImpar(7);
    }

    /**
     * Demonstra o uso do 'if' simples.
     */
    public static void verificarMaioridade(int idade) {
        System.out.print("Idade: " + idade + ". ");
        if (idade >= 18) {
            System.out.println("Resultado: Pode dirigir.");
        }
    }

    /**
     * Demonstra o uso do 'if-else'.
     */
    public static void verificarAprovacao(double nota) {
        System.out.print("Nota: " + nota + ". ");
        if (nota >= 6.0) {
            System.out.println("Situação: Aprovado!");
        } else {
            System.out.println("Situação: Reprovado.");
        }
    }

    /**
     * Demonstra o uso da cadeia 'if-else-if'.
     */
    public static void categorizarNadador(int idade) {
        System.out.print("Idade do nadador: " + idade + ". ");
        if (idade >= 5 && idade <= 10) {
            System.out.println("Categoria: Infantil");
        } else if (idade >= 11 && idade <= 17) {
            System.out.println("Categoria: Juvenil");
        } else if (idade >= 18) {
            System.out.println("Categoria: Adulto");
        } else {
            System.out.println("Idade fora da faixa para competição.");
        }
    }

    /**
     * Demonstra o uso do 'switch' com String.
     */
    public static void descreverPlanoDeTelefonia(String plano) {
        System.out.print("Plano selecionado: " + plano + ". ");
        switch (plano) {
            case "Básico":
                System.out.println("Descrição: 100 minutos de ligação.");
                break;
            case "Mídia":
                System.out.println("Descrição: 100 minutos + WhatsApp e Instagram grátis.");
                break;
            case "Turbo":
                System.out.println("Descrição: 100 minutos + WhatsApp e Instagram grátis + 5GB de YouTube.");
                break;
            default:
                System.out.println("Descrição: Plano não reconhecido.");
        }
    }

    /**
     * Demonstra o uso do operador ternário para verificar se um número é par ou
     * ímpar.
     */
    public static void verificarParOuImpar(int numero) {
        String resultado = (numero % 2 == 0) ? "Par" : "Ímpar";
        System.out.println("O número " + numero + " é " + resultado + ".");
    }
}