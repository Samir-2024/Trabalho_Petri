public class MainIno {
    public static void main(String[] args) {
        EstruturaDinamica lista = new EstruturaDinamica();
        No elemento1 = new No("Elemento 1");
        No elemento2 = new No("Elemento 2");
        No elemento3 = new No("Elemento 3");

        lista.inserirElemento(elemento1);
        lista.inserirElemento(elemento2);
        lista.inserirElemento(elemento3);

        lista.imprimirLista();

        System.out.println("A lista está vazia? " + lista.estaVazia());
        System.out.println("A lista está cheia? " + lista.estaCheia());
    }
}
