package Questao10_11_12_13_14;

public class NoSimpEnc<T>{

    private T obj;

    private NoSimpEnc<T> prox;

    public NoSimpEnc(T obj) {

        this.obj = obj;
        this.prox = null;

    }

    public NoSimpEnc(T obj, NoSimpEnc<T> prox) {

        this.obj = obj;
        this.prox = prox;

    }

    public T getObj() {

        return obj;

    }

    public void setObj(T obj) {

        this.obj = obj;

    }

    public NoSimpEnc<T> getProx() {

        return prox;

    }

    public void setProx(NoSimpEnc<T> prox) {

        this.prox = prox;
        
    }



}



