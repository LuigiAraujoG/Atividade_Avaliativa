package Questao10_11_12_13_14;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ListaSimpEnc<T> implements Iterable<T>{

    private NoSimpEnc<T> inicio;
    private NoSimpEnc<T> fim;
    private int tamanho;

    public ListaSimpEnc() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public boolean isEmpty() {
        return inicio == null || fim == null;
    }

    public int size() {
        return tamanho;
    }

    // Inserir no início
    public void addFirst(T obj) {

        NoSimpEnc<T> novo = new NoSimpEnc<>(obj, inicio);

        if (isEmpty()) {
            fim = novo;
        }
        inicio = novo;
        tamanho++;

    }

    // Inserir no final
    public void addLast(T obj) {
        NoSimpEnc<T> novo = new NoSimpEnc<>(obj);

        if (isEmpty()) {
            fim = novo;
            inicio = novo;
        } else {
            fim.setProx(novo);
            fim = fim.getProx();
        }
        tamanho++;
    }


    // Inserir por index
    public void addByIndex(int pos, T obj) {
        if (pos < 0 || pos > tamanho) {
            throw new IndexOutOfBoundsException("Posição inexistente");
        }

        if (pos == 0) {
            addFirst(obj);
            return;
        }
        if (pos == tamanho) {
            addLast(obj);
            return;
        }

        NoSimpEnc<T> atual = inicio;
        for (int i = 1; i < pos; i++) {
            atual = atual.getProx();
        }

        NoSimpEnc<T> novo = new NoSimpEnc<>(obj, atual.getProx());
        atual.setProx(novo);
        tamanho++;
    }

    public void addOrdered(T obj, Comparator<T> comparator){
        if (isEmpty()){
            addFirst(obj);
            return;
        }

        NoSimpEnc<T> atual = inicio;

        while (atual.getProx() != null && comparator.compare(atual.getProx().getObj(), obj) < 0){
            atual = atual.getProx();
        }

        if (atual.getProx() == null){
            addLast(obj);
            return;
        }

        NoSimpEnc<T> novo = new NoSimpEnc<>(obj, atual.getProx());
        atual.setProx(novo);
        tamanho++;

    }

    public boolean addUniqueAtEnd(T obj){
        if (isEmpty()){
            addFirst(obj);
            return true;
        }

        if (!Objects.equals(inicio.getObj(), obj)){
            addLast(obj);
            return true;
        }

        NoSimpEnc<T> atual = inicio;

        while (atual.getProx() != null){
            if (!Objects.equals(atual.getProx().getObj(), obj)){
                addLast(obj);
                return true;
            }
            atual = atual.getProx();
        }

        return false;
    }

    // Buscar elemento
    public T search(T obj, Comparator<T> comp) {
        NoSimpEnc<T> atual = inicio;

        while (atual != null) {
            if (comp.compare(atual.getObj(), obj) == 0) {
                return atual.getObj();
            }
            atual = atual.getProx();
        }
        return null;
    }

    public int contarOcorrencias(T elemento) {
        NoSimpEnc<T> atual = inicio;
        int qtdRepetida = 0;

        while (atual != null) {
            if (Objects.equals(atual.getObj(), elemento)) {
                qtdRepetida += 1;
            }
            atual = atual.getProx();
        }
        return qtdRepetida;
    }

    // Remover do início
    public T removeFirst() {
        if (isEmpty()) return null;

        T removido = inicio.getObj();
        inicio = inicio.getProx();
        if (isEmpty()) fim = null;
        tamanho--;

        return removido;
    }

    // Remover do final
    public T removeLast() {
        if (isEmpty()) return null;

        if (inicio.getProx() == null) {
            return removeFirst();
        }

        NoSimpEnc<T> atual = inicio;
        while (atual.getProx().getProx() != null) {
            atual = atual.getProx();
        }

        T removido = atual.getProx().getObj();
        atual.setProx(null);
        fim = atual;
        tamanho--;

        return removido;
    }

    // Remover por valor (nome como exemplo)
    public boolean remove(T obj, Comparator<T> comp) {
        if (isEmpty()) return false;

        if (comp.compare(inicio.getObj(), obj) == 0) {
            removeFirst();
            return true;
        }

        NoSimpEnc<T> atual = inicio;

        while (atual.getProx() != null) {
            if (comp.compare(atual.getProx().getObj(), obj) == 0) {
                atual.setProx(atual.getProx().getProx());
                if (atual.getProx() == null) fim = atual;
                tamanho--;
                return true;
            }
            atual = atual.getProx();
        }

        return false;
    }

    // Remove por index
    public T removeByIndex(int pos) {
        if (pos < 0 || pos > tamanho - 1) {
            throw new IndexOutOfBoundsException("Posição inexistente");
        }

        if (pos == 0) {
            return removeFirst();
        }
        if (pos == tamanho - 1) {
            return removeLast();
        }

        NoSimpEnc<T> atual = inicio;
        for (int i = 1; i < pos; i++) {
            atual = atual.getProx();
        }

        T removido = atual.getProx().getObj();
        atual.setProx(atual.getProx().getProx());
        tamanho--;
        return removido;
    }

    // Percorrer lista (traversal)
    public void print() {
        NoSimpEnc<T> atual = inicio;

        while (atual != null) {
            System.out.println(atual.getObj());
            atual = atual.getProx();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new MeuIterator();
    }

    private class MeuIterator implements Iterator<T> {
        private NoSimpEnc<T> atual = inicio;

        @Override
        public boolean hasNext() {
            return atual != null;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T obj = atual.getObj();
            atual = atual.getProx();
            return obj;
        }
    }
}
