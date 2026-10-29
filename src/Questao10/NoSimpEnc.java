package Questao10;

public class NoSimpEnc{

    private Aluno obj;

    private NoSimpEnc prox;

    public NoSimpEnc(Aluno obj) {

        this.obj = obj;
        this.prox = null;

    }

    public NoSimpEnc(Aluno obj, NoSimpEnc prox) {

        this.obj = obj;
        this.prox = prox;

    }

    public Aluno getObj() {

        return obj;

    }

    public void setObj(Aluno obj) {

        this.obj = obj;

    }

    public NoSimpEnc getProx() {

        return prox;

    }

    public void setProx(NoSimpEnc prox) {

        this.prox = prox;
        
    }



}



