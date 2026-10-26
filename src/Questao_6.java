import java.util.ArrayList;
import java.util.List;

public class Questao_6 {
    static void main() {
        ArrayList<String> nomes1 = new ArrayList<>();
        nomes1.add("Luigi");
        nomes1.add("Matheus");
        nomes1.add("Ana");
        nomes1.add("rodrigo");

        ArrayList<String> nomes2 = new ArrayList<>();
        nomes2.add("Luigi");
        nomes2.add("Matheus");
        nomes2.add("caio");
        nomes2.add("rodrigo");

        List<String> novaLista = elementosPresentesAmbasListas(nomes1, nomes2);

        for (String nome : novaLista){
            System.out.println("Nome: " + nome);
        }

    }

    public static List<String> elementosPresentesAmbasListas(ArrayList<String> lista1, ArrayList<String> lista2) {

        return lista1.stream().filter(nome1 -> lista2.contains(nome1)).toList();
    }
}
