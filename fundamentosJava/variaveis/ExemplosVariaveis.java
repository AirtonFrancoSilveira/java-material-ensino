package fundamentosJava.variaveis;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta classe demonstra a declaração, inicialização e uso de diferentes
 * tipos de variáveis, escopos e constantes em Java.
 */
public class ExemplosVariaveis {

    // --- 1. VARIÁVEIS DE INSTÂNCIA ---
    // Estas variáveis pertencem a cada objeto (instância) da classe.
    // Elas são acessíveis a partir de qualquer método não-estático da classe.
    String nomeDoCarro = "Mustang";
    int anoDoCarro = 1969;

    // --- 2. CONSTANTES DE CLASSE ---
    // `static final` cria uma constante que pertence à classe, não a um objeto.
    // O valor não pode ser alterado.
    public static final String PAIS_DE_ORIGEM = "EUA";
    public static final int VELOCIDADE_MAXIMA_LEGAL = 120; // km/h

    /**
     * O método main é o ponto de entrada para a execução do programa.
     */
    public static void main(String[] args) {

        System.out.println("--- Exemplos de Variáveis Primitivas ---");
        demonstrarPrimitivos();

        System.out.println("\n--- Exemplos de Variáveis de Referência ---");
        demonstrarReferencias();

        System.out.println("\n--- Exemplo de Escopo de Variável ---");
        // Para acessar variáveis de instância, precisamos criar um objeto da classe.
        ExemplosVariaveis meuExemplo = new ExemplosVariaveis();
        meuExemplo.demonstrarEscopo();

        System.out.println("\n--- Exemplo de Constantes ---");
        System.out.println("País de Origem do Carro: " + PAIS_DE_ORIGEM);
        System.out.println("Velocidade Máxima Permitida: " + VELOCIDADE_MAXIMA_LEGAL + " km/h");
    }

    /**
     * Demonstra o uso de tipos de dados primitivos.
     */
    public static void demonstrarPrimitivos() {
        // --- VARIÁVEIS LOCAIS (dentro de um método) ---

        // Tipo int: para números inteiros
        int idade = 30;
        System.out.println("Idade (int): " + idade);

        // Tipo double: para números com casas decimais (maior precisão)
        double salario = 4580.75;
        System.out.println("Salário (double): " + salario);

        // Tipo float: também para decimais, mas requer o sufixo 'f'
        float cotacaoDolar = 5.25f;
        System.out.println("Cotação do Dólar (float): " + cotacaoDolar);

        // Tipo long: para números inteiros muito grandes, requer o sufixo 'L'
        long populacaoPlaneta = 7800000000L;
        System.out.println("População do Planeta (long): " + populacaoPlaneta);

        // Tipo char: para um único caractere (use aspas simples)
        char letraInicial = 'B';
        System.out.println("Letra Inicial (char): " + letraInicial);

        // Tipo boolean: para valores lógicos (verdadeiro ou falso)
        boolean estaChovendo = false;
        System.out.println("Está chovendo? (boolean): " + estaChovendo);

        // Tipo byte: para números inteiros muito pequenos (-128 a 127)
        byte idadeEmMeses = 120;
        System.out.println("Idade em Meses (byte): " + idadeEmMeses);
    }

    /**
     * Demonstra o uso de tipos de dados de referência.
     */
    public static void demonstrarReferencias() {
        // String: o tipo de referência mais comum, para textos.
        String nomeCompleto = "Carlos da Silva";
        System.out.println("Nome Completo (String): " + nomeCompleto);
        System.out.println("Nome em maiúsculas: " + nomeCompleto.toUpperCase());

        // List (ArrayList): uma lista dinâmica de objetos.
        List<String> listaDeCompras = new ArrayList<>();
        listaDeCompras.add("Maçã");
        listaDeCompras.add("Leite");
        listaDeCompras.add("Pão");
        System.out.println("Lista de Compras (List<String>): " + listaDeCompras);
        System.out.println("Primeiro item da lista: " + listaDeCompras.get(0));
    }

    /**
     * Demonstra a diferença entre escopo de instância e local.
     */
    public void demonstrarEscopo() {
        // Variável local a este método
        String status = "Revisado";

        // Acessando a variável de instância da classe
        System.out.println("Nome do carro (variável de instância): " + nomeDoCarro);
        System.out.println("Ano do carro (variável de instância): " + anoDoCarro);

        // Acessando a variável local
        System.out.println("Status do carro (variável local): " + status);
    }
}