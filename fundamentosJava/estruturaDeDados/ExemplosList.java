package fundamentosJava.estruturaDeDados;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Esta classe demonstra o uso prático de List, ArrayList e LinkedList em Java.
 * Contém explicações e exemplos para cada um.
 */
public class ExemplosList {

    public static void main(String[] args) {
        System.out.println("--- Exemplo com ArrayList ---");
        exemploArrayList();

        System.out.println("\n\n--- Exemplo com LinkedList ---");
        exemploLinkedList();
    }

    /**
     * Demonstra o uso de ArrayList.
     *
     * O QUE É ARRAYLIST?
     * - É uma implementação da interface List que usa um array dinâmico por baixo
     * dos panos.
     * - "Dinâmico" significa que ele cresce automaticamente quando necessário.
     *
     * PRINCIPAIS CARACTERÍSTICAS:
     * - Rápido para acesso aleatório: Acessar um elemento pelo seu índice (ex:
     * lista.get(5)) é muito rápido (operação O(1)).
     * - Lento para inserções/remoções no meio: Adicionar ou remover um elemento do
     * início ou do meio da lista é lento,
     * pois todos os elementos subsequentes precisam ser deslocados (operação O(n)).
     *
     * QUANDO USAR?
     * - Quando você precisa de acesso rápido aos elementos por sua posição.
     * - Quando a principal operação é a leitura de dados ou a adição/remoção de
     * elementos apenas no final da lista.
     */
    public static void exemploArrayList() {
        // Criando uma ArrayList de Strings
        List<String> nomes = new ArrayList<>();

        // 1. Adicionando elementos
        nomes.add("Alice");
        nomes.add("Bob");
        nomes.add("Charlie");
        nomes.add("Diana");
        System.out.println("Lista inicial: " + nomes);

        // 2. Acessando um elemento pelo índice (acesso rápido)
        String segundoNome = nomes.get(1); // Índices começam em 0
        System.out.println("O segundo nome na lista é: " + segundoNome);

        // 3. Adicionando um elemento em um índice específico (operação mais lenta)
        nomes.add(2, "Carol"); // Adiciona "Carol" no índice 2
        System.out.println("Lista após adicionar 'Carol' no meio: " + nomes);

        // 4. Removendo um elemento pelo índice (operação mais lenta)
        nomes.remove(0); // Remove "Alice"
        System.out.println("Lista após remover o primeiro elemento: " + nomes);

        // 5. Iterando sobre a lista
        System.out.print("Iterando sobre a lista final: ");
        for (String nome : nomes) {
            System.out.print(nome + " ");
        }
        System.out.println();

        // 6. Verificando o tamanho
        System.out.println("Tamanho atual da lista: " + nomes.size());
    }

    /**
     * Demonstra o uso de LinkedList.
     *
     * O QUE É LINKEDLIST?
     * - É uma implementação da interface List que usa uma estrutura de "lista
     * duplamente ligada".
     * - Cada elemento (ou "nó") armazena o dado e uma referência (um "link") para o
     * elemento anterior e o próximo.
     *
     * PRINCIPAIS CARACTERÍSTICAS:
     * - Rápida para inserções/remoções: Adicionar ou remover elementos,
     * especialmente no início ou no fim, é muito rápido (O(1)),
     * pois apenas os "links" dos nós vizinhos precisam ser atualizados.
     * - Lenta para acesso aleatório: Para acessar um elemento no meio (ex:
     * lista.get(5)), a lista precisa ser percorrida
     * desde o início (ou do fim) até a posição desejada (operação O(n)).
     *
     * QUANDO USAR?
     * - Quando você realiza muitas operações de inserção e remoção de elementos em
     * qualquer parte da lista.
     * - Quando você a utiliza como uma Fila (Queue) ou Pilha (Stack), pois ela
     * implementa a interface Deque.
     */
    public static void exemploLinkedList() {
        // Criando uma LinkedList de Inteiros
        LinkedList<Integer> numeros = new LinkedList<>();

        // 1. Adicionando elementos
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);
        System.out.println("Lista inicial: " + numeros);

        // 2. Adicionando elementos no início e no fim (operações rápidas)
        numeros.addFirst(5); // Método específico da LinkedList
        numeros.addLast(40); // Método específico da LinkedList
        System.out.println("Lista após adicionar no início e no fim: " + numeros);

        // 3. Acessando o primeiro e o último elemento
        System.out.println("Primeiro elemento: " + numeros.getFirst());
        System.out.println("Último elemento: " + numeros.getLast());

        // 4. Removendo o primeiro e o último elemento (operações rápidas)
        numeros.removeFirst();
        numeros.removeLast();
        System.out.println("Lista após remover do início e do fim: " + numeros);

        // 5. Iterando sobre a lista
        System.out.print("Iterando sobre a lista final: ");
        for (Integer numero : numeros) {
            System.out.print(numero + " ");
        }
        System.out.println();

        // 6. Acessar um elemento no meio (operação mais lenta)
        System.out.println("Elemento no índice 1: " + numeros.get(1));
    }
}