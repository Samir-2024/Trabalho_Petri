public class EstruturaDinamica {
    private No primeiroElemento;
    private No ultimoElemento;
    private int qtdElementos;

    public EstruturaDinamica() {
        this.primeiroElemento = null;
        this.ultimoElemento = null;
        this.qtdElementos = 0;
    }

    public void inserirElemento(No elemento) {
        No novoNo = new No(elemento);
        if (estaVazia()) {
            primeiroElemento = novoNo;
            ultimoElemento = novoNo;
        } else {
            ultimoElemento.setProximoNo(novoNo);
            novoNo.setAnteriorNo(novoNo);
            ultimoElemento = novoNo;
        }
        qtdElementos++;

    }

    public boolean estaVazia() {
       if (qtdElementos == 0) {
            System.out.println("A lista contém elementos");
            return true;
       } else {
            System.out.println("A lista está vazia");
            return false;
       }

    }

    public boolean estaCheia() {
        if (qtdElementos > 0) {
            return true;

        } else {
            return estaVazia();
        }
    }

    public void imprimirLista() {
        No atual = primeiroElemento;
        while (atual != null) {
            System.out.println(atual.getElemento());
            atual = atual.getProximoNo();
        }
    }

    public void removerElemento(Object elemento) {
        if(estaVazia()) {
            System.out.println("A lista está vazia");
        }
    }
}
