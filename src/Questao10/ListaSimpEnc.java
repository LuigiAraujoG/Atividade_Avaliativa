package Questao10;

public class ListaSimpEnc {

    private NoSimpEnc inicio;
    private int tamanho;

    public ListaSimpEnc() {
        this.inicio = null;
        this.tamanho = 0;
    }

    public boolean isEmpty() {
        return inicio == null;
    }

    public int size() {
        return tamanho;
    }

    // Inserir no início
    public void addFirst(Aluno obj) {

        NoSimpEnc novo = new NoSimpEnc(obj, inicio);
        inicio = novo;
        tamanho++;
        
    }

    // Inserir no final
    public void addLast(Aluno obj) {
        NoSimpEnc novo = new NoSimpEnc(obj);

        if (isEmpty()) {
            inicio = novo;
        } else {
            NoSimpEnc atual = inicio;
            while (atual.getProx() != null) {
                atual = atual.getProx();
            }
            atual.setProx(novo);
        }
        tamanho++;
    }

    public void addByIndex(int index, Aluno obj){
        if (index < 0 || index > tamanho){
            throw new IndexOutOfBoundsException("Índice inválido: " + index);
        }

        if (index == 0) {
            addFirst(obj);
            return;
        }

        if (index == tamanho){
            addLast(obj);
            return;
        }

        NoSimpEnc atual = inicio;
        for (int i =0; i < index - 1; i++){
            atual.getProx();
        }

        NoSimpEnc novo = new NoSimpEnc(obj, atual.getProx());
        atual.setProx(novo);
        tamanho++;
    }

    // Buscar elemento
    public Aluno search(String nome) {
        NoSimpEnc atual = inicio;

        while (atual != null) {
            if (atual.getObj().getNome().equals(nome)) {
                return atual.getObj();
            }
            atual = atual.getProx();
        }
        return null;
    }

    // Remover do início
    public Aluno removeFirst() {
        if (isEmpty()) return null;

        Aluno removido = inicio.getObj();
        inicio = inicio.getProx();
        tamanho--;

        return removido;
    }

    // Remover do final
    public Aluno removeLast() {
        if (isEmpty()) return null;

        if (inicio.getProx() == null) {
            return removeFirst();
        }

        NoSimpEnc atual = inicio;
        while (atual.getProx().getProx() != null) {
            atual = atual.getProx();
        }

        Aluno removido = atual.getProx().getObj();
        atual.setProx(null);
        tamanho--;

        return removido;
    }

    // Remover por valor (nome como exemplo)
    public boolean remove(String nome) {
        if (isEmpty()) return false;

        if (inicio.getObj().getNome().equals(nome)) {
            removeFirst();
            return true;
        }

        NoSimpEnc atual = inicio;

        while (atual.getProx() != null) {
            if (atual.getProx().getObj().getNome().equals(nome)) {
                atual.setProx(atual.getProx().getProx());
                tamanho--;
                return true;
            }
            atual = atual.getProx();
        }

        return false;
    }

    // Percorrer lista (traversal)
    public void print() {
        NoSimpEnc atual = inicio;

        while (atual != null) {
            System.out.println(atual.getObj());
            atual = atual.getProx();
        }
    }
}
