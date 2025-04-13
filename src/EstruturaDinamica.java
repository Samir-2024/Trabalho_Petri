public class EstruturaDinamica{
    private No primeiroElemento;
    private No ultimoElemento;
    private int qtdElementos;

    public EstruturaDinamica(){
        this.primeiroElemento = null;
        this.ultimoElemento = null;
        this.qtdElementos = 0;
    }

    public void inserirElemento(No elemento){
        No novoNo = new No(elemento);
        if(estaVazia()){
            primeiroElemento = novoNo;
            ultimoElemento = novoNo;
        }else{
            ultimoElemento.setProximoNo(novoNo);
            novoNo.setAnteriorNo(novoNo);
            ultimoElemento = novoNo;
        }
        qtdElementos++;
    }

    public void inserirSequencia(Object elementos){
        if(elementos instanceof Object[]){
            for(Object valor : (Object[])elementos){
                inserirElemento(valor);
            }
        }
    }

    public boolean removerElemento(Object elemento){
        if(estaVazia()){
            System.out.println("A lista está vazia");
        }
        No atual = primeiroElemento;
        while(atual != null){
            if(atual.getElemento().equals(elemento)){
                if(atual == primeiroElemento){
                    primeiroElemento = atual.getProximoNo();
                    if(primeiroElemento != null){
                        primeiroElemento.setAnteriorNo(null);
                    }else{
                        ultimoElemento = null;
                    }
                }else if(atual == ultimoElemento){
                    ultimoElemento = atual.getAnteriorNo();
                    ultimoElemento.setProximoNo(null);
                }else{
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

    public void removerSequencia(Object elementos){
        if(elementos instanceof Object[]){
            for(Object valor : (Object[]) elementos){
                removerElemento(valor);
            }
        }
    }

    public void removerTodasOcorrencias(Object elemento){
        while(removerElemento(elemento)){
        }
    }

    public boolean estaVazia(){
       if(qtdElementos == 0){
            System.out.println("A lista contém elementos");
            return true;
       }else{
            System.out.println("A lista está vazia");
            return false;
       }
    }

    public boolean estaCheia(){
        if(qtdElementos > 0){
            return true;

        }else{
            return estaVazia();
        }
    }

    public boolean buscarElemento(Object elemento){
        No atual = primeiroElemento;
        while(atual != null){
            if(atual.getElemento().equals(elemento)){
                return true;
            }
            atual = atual.getProximoNo();
        }
        return false;
    }

    public int quantidadeElementos(){
        return qtdElementos;
    }

    public void ordenarCrescente(){
        if(qtdElementos <= 1) return;
        for(No i = primeiroElemento; i != null; i = i.getProximoNo()){
            for(No j = i.getProximoNo(); j != null; j = j.getProximoNo()){
                if(((Comparable) i.getElemento()).compareTo(j.getElemento()) > 0){
                    Object valor = i.getElemento();
                    i.setElemento(j.getElemento());
                    j.setElemento(valor);
                }
            }
        }
    }

    public void ordenarDecrescente(){
        if(qtdElementos <= 1) return;
        for(No i = primeiroElemento; i != null; i = i.getProximoNo()){
            for(No j = i.getProximoNo(); j != null; j = j.getProximoNo()){
                if(((Comparable) i.getElemento()).compareTo(j.getElemento()) < 0){
                    Object valor = i.getElemento();
                    i.setElemento(j.getElemento());
                    j.setElemento(valor);
                }
            }
        }
    }

    public void imprimirLista(){
        No atual = primeiroElemento;
        while(atual != null) {
            System.out.println(atual.getElemento());
            atual = atual.getProximoNo();
        }
    }
}
