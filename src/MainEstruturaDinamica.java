public class MainEstruturaDinamica {
    public static void main(String[] args) {
        EstruturaDinamica lista = new EstruturaDinamica();

        lista.inserirElemento("Maçã");
        lista.inserirElemento("Banana");
        lista.inserirElemento("Cenoura");

        System.out.println("Elementos na lista:");
        lista.imprimirLista();

        lista.removerElemento("Banana");

        System.out.println("remover 'Banana':");
        lista.imprimirLista();

        System.out.println("Contem 'Cenoura' " + lista.buscarElemento("Cenora"));
        System.out.println("Contém 'Banana' " + lista.buscarElemento("Banana"));

        lista.inserirElemento("Abacaxi");
        lista.inserirElemento("Uva");

        lista.ordenarCrescente();

        System.out.println("Lista em ordem alfabetica:");
        lista.imprimirLista();

        System.out.println("Total de itens: " + lista.quantidadeElementos());

        boolean vazia = lista.estaVazia();
        boolean cheia = lista.estaCheia();

        System.out.println("Está vazia " + vazia);
        System.out.println("Está cheia " + cheia);
    }
}
