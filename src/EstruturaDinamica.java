public class EstruturaDinamica {
    private No primeiroElemento;
    private No ultimoElemento;
    private int qtdElementos;

    public EstruturaDinamica() {
        primeiroElemento = null;
        ultimoElemento = null;
        qtdElementos = 0;
    }

    public void inserirElemento(Object elemento) {
        No novo = new No(elemento);
        if (estaVazia()) {
            primeiroElemento = ultimoElemento = novo;
        } else {
            ultimoElemento.setProximoNo(novo);
            novo.setAnteriorNo(ultimoElemento);
            ultimoElemento = novo;
        }
        qtdElementos++;
    }

    public void inserirSequencia(Object elementos) {
        if (elementos instanceof Object[] objects) {
            for (Object obj : objects) {
                inserirElemento(obj);
            }
        }
    }

    public boolean removerElemento(Object elemento) {
        if (estaVazia()) {
            System.out.println("A lista está vazia");
            return false;
        }

        No atual = primeiroElemento;

        while (atual != null) {
            if (atual.getElemento().equals(elemento)) {
                if (atual == primeiroElemento) {
                    primeiroElemento = atual.getProximoNo();
                    if (primeiroElemento != null) {
                        primeiroElemento.setAnteriorNo(null);
                    } else {
                        ultimoElemento = null;
                    }
                } else if (atual == ultimoElemento) {
                    ultimoElemento = atual.getAnteriorNo();
                    if (ultimoElemento != null) {
                        ultimoElemento.setProximoNo(null);
                    }
                } else {
                    atual.getAnteriorNo().setProximoNo(atual.getProximoNo());
                    atual.getProximoNo().setAnteriorNo(atual.getAnteriorNo());
                }
                qtdElementos--;
                return true;
            }
            atual = atual.getProximoNo();
        }

        return false;
    }

    public void removerSequencia(Object elementos) {
        if (elementos instanceof Object[] objects) {
            for (Object obj : objects) {
                removerElemento(obj);
            }
        }
    }

    public void removerTodasOcorrencias(Object elemento) {
        while (removerElemento(elemento)) {}
    }

    public boolean estaVazia() {
        return qtdElementos == 0;
    }

    public boolean estaCheia() {
        return qtdElementos > 0;
    }

    public boolean buscarElemento(Object elemento) {
        No atual = primeiroElemento;
        while (atual != null) {
            if (atual.getElemento().equals(elemento)) return true;
            atual = atual.getProximoNo();
        }
        return false;
    }

    public int quantidadeElementos() {
        return qtdElementos;
    }

    @SuppressWarnings("unchecked")
    public void ordenarCrescente() {
        if (qtdElementos <= 1) return;

        for (No i = primeiroElemento; i != null; i = i.getProximoNo()) {
            for (No j = i.getProximoNo(); j != null; j = j.getProximoNo()) {
                Comparable<Object> a = (Comparable<Object>) i.getElemento();
                Object b = j.getElemento();
                if (a.compareTo(b) > 0) {
                    i.setElemento(b);
                    j.setElemento(a);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    public void ordenarDecrescente() {
        if (qtdElementos <= 1) return;

        for (No i = primeiroElemento; i != null; i = i.getProximoNo()) {
            for (No j = i.getProximoNo(); j != null; j = j.getProximoNo()) {
                Comparable<Object> a = (Comparable<Object>) i.getElemento();
                Object b = j.getElemento();
                if (a.compareTo(b) < 0) {
                    i.setElemento(b);
                    j.setElemento(a);
                }
            }
        }
    }

    public void imprimirLista() {
        No atual = primeiroElemento;
        while (atual != null) {
            System.out.println(atual.getElemento());
            atual = atual.getProximoNo();
        }
    }

    public void exibir() {
        No atual = primeiroElemento;
        while (atual != null) {
            System.out.print(atual.getElemento() + " ");
            atual = atual.getProximoNo();
        }
        System.out.println();
    }

    public void limpar() {
        primeiroElemento = null;
        ultimoElemento = null;
        qtdElementos = 0;
    }

    public No obterPrimeiroElemento() {
        return primeiroElemento;
    }

    public No obterUltimoElemento() {
        return ultimoElemento;
    }
}
