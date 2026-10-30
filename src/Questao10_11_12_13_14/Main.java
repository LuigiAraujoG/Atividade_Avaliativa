package Questao10_11_12_13_14;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        ListaSimpEnc<Aluno> lista = new ListaSimpEnc<>();
        ListaSimpEnc<Aluno> lista2 = new ListaSimpEnc<>();
        ListaSimpEnc<Aluno> lista3 = new ListaSimpEnc<>();
        ListaSimpEnc<Aluno> lista4 = new ListaSimpEnc<>();
        ListaSimpEnc<Aluno> lista5 = new ListaSimpEnc<>();
        ListaSimpEnc<Aluno> lista6 = new ListaSimpEnc<>();
        ListaSimpEnc<Aluno> lista7 = new ListaSimpEnc<>();
        Comparator<Aluno> porNome = Comparator.comparing(Aluno::getNome);
        Comparator<Aluno> porMatricula = Comparator.comparing(Aluno::getMatricula);

        // Criando alguns alunos
        Aluno a1 = new Aluno("Ana", 21312121);
        Aluno a2 = new Aluno("Bruno", 21312122);
        Aluno a3 = new Aluno("Carlos", 43335332);
        Aluno a4 = new Aluno("Diana", 453334343);

        System.out.println("Lista está vazia? " + lista.isEmpty());

        // Inserções
        System.out.println("\n--- Inserindo no início ---");
        lista.addFirst(a1);
        lista.addFirst(a2);
        lista.print();

        System.out.println("\n--- Inserindo no final ---");
        lista.addLast(a3);
        lista.addLast(a4);
        lista.print();

        System.out.println("\nTamanho da lista: " + lista.size());
        lista.print();

        System.out.println("\n--- Inserindo por index: meio ---");
        lista2.addLast(a1);
        lista2.addLast(a2);
        lista2.addLast(a4);
        lista2.addByIndex(2, a3);
        lista2.print();

        System.out.println("\n--- Inserindo na ordem por nome ---");
        lista4.addOrdered(a4, porNome);
        lista4.addOrdered(a1, porNome);
        lista4.addOrdered(a3, porNome);
        lista4.addOrdered(a2, porNome);
        lista4.print();

        System.out.println("\n--- Inserindo na ordem por matrícula ---");
        lista5.addOrdered(a4, porMatricula);
        lista5.addOrdered(a1, porMatricula);
        lista5.addOrdered(a3, porMatricula);
        lista5.addOrdered(a2, porMatricula);
        lista5.print();

        // Inserindo no final caso não exista
        System.out.println("\n--- Inserindo no final caso não exista ---");
        System.out.println(lista6.addLastSeCasoNaoExista(a1));
        System.out.println(lista6.addLastSeCasoNaoExista(a2));
        System.out.println(lista6.addLastSeCasoNaoExista(a1));
        lista6.print();

        // Busca
        System.out.println("\n--- Buscando aluno ---");
        Aluno buscado = lista.search(new Aluno("Carlos", 0), porNome);
        if (buscado != null) {
            System.out.println("Encontrado: " + buscado);
        } else {
            System.out.println("Aluno não encontrado");
        }

        // Contar ocorrências
        System.out.println("\n--- Contando ocorrências ---");
        lista7.addLast(a1);
        lista7.addLast(a2);
        lista7.addLast(a1);
        lista7.print();
        System.out.println("Ocorrências de "+ a1 + ": " + lista7.contarOcorrencias(a1));

        System.out.println("Ocorrências de " + a2 + ": " + lista7.contarOcorrencias(a2));
        System.out.println("Ocorrências de " + a3 + ": " + lista7.contarOcorrencias(a3));
        System.out.println("Ocorrências de " + a4 + ": " + lista7.contarOcorrencias(a4));

        ListaSimpEnc<Aluno> listaVazia = new ListaSimpEnc<>();
        System.out.println("Lista vazia: " + listaVazia.contarOcorrencias(a1));

        ListaSimpEnc<Aluno> ListaUmNo = new ListaSimpEnc<>();
        ListaUmNo.addLast(a1);
        System.out.println("Um nó, igual: " + ListaUmNo.contarOcorrencias(a1));
        System.out.println("Um nó, diferente: " + ListaUmNo.contarOcorrencias(a2));

        // Remover do início
        System.out.println("\n--- Removendo do início ---");
        Aluno removidoInicio = lista.removeFirst();
        System.out.println("Removido: " + removidoInicio);
        lista.print();

        // Remover do final
        System.out.println("\n--- Removendo do final ---");
        Aluno removidoFinal = lista.removeLast();
        System.out.println("Removido: " + removidoFinal);
        lista.print();

        // Remover por nome
        System.out.println("\n--- Removendo por nome (Bruno) ---");
        boolean removeu = lista.remove(new Aluno("Bruno", 0), porNome);
        System.out.println("Removeu? " + removeu);
        lista.print();

        // RemoveByIndex
        System.out.println("\n--- Removendo por index ---");
        lista3.addLast(a1);
        lista3.addLast(a2);
        lista3.addLast(a3);
        lista3.addLast(a4);
        System.out.println(lista3.removeByIndex(2));
        lista3.print();


        // Tentando remover algo que não existe
        System.out.println("\n--- Removendo inexistente (Xavier) ---");
        System.out.println("Removeu? " + lista.remove(new Aluno("Xavier", 0), porNome));

        // Iterator
        System.out.println("\n--- Iterator ---");
        for (Aluno a : lista) {
            System.out.println(a);
        }

        System.out.println("\nLista vazia:");
        for (Aluno a : new ListaSimpEnc<Aluno>()) {
            System.out.println(a);
        }

        System.out.println("\nUm nó:");
        for (Aluno a : ListaUmNo) {
            System.out.println(a);
        }

        System.out.println("\nNão modifica a lista:");
        System.out.println("Tamanho antes: " + lista.size());
        for (Aluno a : lista) { }
        System.out.println("Tamanho depois: " + lista.size());
        lista.print();
    }
}
