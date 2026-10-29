package Questao10;

public class Main {
    public static void main(String[] args) {

        ListaSimpEnc lista = new ListaSimpEnc();

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

        // Busca
        System.out.println("\n--- Buscando aluno ---");
        Aluno buscado = lista.search("Carlos");
        if (buscado != null) {
            System.out.println("Encontrado: " + buscado);
        } else {
            System.out.println("Aluno não encontrado");
        }

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
        boolean removeu = lista.remove("Bruno");
        System.out.println("Removeu? " + removeu);
        lista.print();

        // Tentando remover algo que não existe
        System.out.println("\n--- Removendo inexistente (Xavier) ---");
        System.out.println("Removeu? " + lista.remove("Xavier"));
    
    }
}
