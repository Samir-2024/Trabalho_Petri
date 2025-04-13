public class No {
    private Object elemento;
    private No proximoNo;
    private No anteriorNo;

    public No(Object elemento) {
        this.elemento = elemento;
        this.proximoNo = null;
        this.anteriorNo = null;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public No getProximoNo() {
        return proximoNo;
    }

    public void setProximoNo(No proximoNo) {
        this.proximoNo = proximoNo;
    }

    public No getAnteriorNo() {
        return anteriorNo;
    }

    public void setAnteriorNo(No anteriorNo) {
        this.anteriorNo = anteriorNo;
    }
}