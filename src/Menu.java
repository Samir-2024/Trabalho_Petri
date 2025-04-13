import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            EstruturaDinamica lista = new EstruturaDinamica();
            int opcao = -1; // inicia com valor diferente de 0 para entrar no loop
            
            while (opcao != 0) {
                System.out.println("1. Inserir elemento");
                System.out.println("2. Inserir sequência de elementos");
                System.out.println("3. Remover elemento");
                System.out.println("4. Remover todas as ocorrências de um elemento");
                System.out.println("5. Buscar elemento");
                System.out.println("6. Ordenar crescente");
                System.out.println("7. Ordenar decrescente");
                System.out.println("8. Exibir lista");
                System.out.println("9. Imprimir lista (linha por linha)");
                System.out.println("10. Limpar lista");
                System.out.println("11. Ver quantidade de elementos");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");
                
                if (scanner.hasNextInt()) {
                    opcao = scanner.nextInt();
                    scanner.nextLine(); // limpar buffer
                } else {
                    System.out.println("Entrada inválida. Digite um número.");
                    scanner.nextLine(); // descarta entrada inválida
                    continue;
                }
                
                switch (opcao) {
                    case 1 -> {
                        System.out.print("Digite o elemento: ");
                        String elemento = scanner.nextLine();
                        lista.inserirElemento(elemento);
                        System.out.println("Elemento inserido.");
                    }
                        
                    case 2 -> {
                        System.out.print("Digite os elementos separados por vírgula: ");
                        String[] elementos = scanner.nextLine().split(",");
                        for (int i = 0; i < elementos.length; i++) {
                            elementos[i] = elementos[i].trim();
                        }
                        lista.inserirSequencia(elementos);
                        System.out.println("Elementos inseridos.");
                    }
                        
                    case 3 -> {
                        System.out.print("Digite o elemento a remover: ");
                        String elemRemover = scanner.nextLine();
                        if (lista.removerElemento(elemRemover)) {
                            System.out.println("Elemento removido.");
                        } else {
                            System.out.println("Elemento não encontrado.");
                        }
                    }
                        
                    case 4 -> {
                        System.out.print("Digite o elemento para remover todas as ocorrências: ");
                        String elemTodos = scanner.nextLine();
                        lista.removerTodasOcorrencias(elemTodos);
                        System.out.println("Ocorrências removidas.");
                    }
                        
                    case 5 -> {
                        System.out.print("Digite o elemento a buscar: ");
                        String elemBuscar = scanner.nextLine();
                        if (lista.buscarElemento(elemBuscar)) {
                            System.out.println("Elemento encontrado.");
                        } else {
                            System.out.println("Elemento não está na lista.");
                        }
                    }
                        
                    case 6 -> {
                        lista.ordenarCrescente();
                        System.out.println("Lista ordenada em ordem crescente.");
                    }
                        
                    case 7 -> {
                        lista.ordenarDecrescente();
                        System.out.println("Lista ordenada em ordem decrescente.");
                    }
                        
                    case 8 -> {
                        System.out.println("Lista atual:");
                        lista.exibir();
                    }
                        
                    case 9 -> {
                        System.out.println("Lista (linha por linha):");
                        lista.imprimirLista();
                    }
                        
                    case 10 -> {
                        lista.limpar();
                        System.out.println("Lista limpa.");
                    }
                        
                    case 11 -> System.out.println("Quantidade de elementos: " + lista.quantidadeElementos());
                        
                    case 0 -> System.out.println("Saindo...");
                        
                    default -> System.out.println("Opção inválida. Tente novamente.");
                }
            }
        }
    }
}
