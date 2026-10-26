import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Questao_5 {
    static void main() {
        ArrayList<String> nomes = new ArrayList<>();
        nomes.add("Luigi");
        nomes.add("Matheus");
        nomes.add("Ana");
        nomes.add("rodrigo");
        nomes.add("ricardo");
        nomes.add("bruna");

        List<String> nomesCincosCharacters = nomes.stream().filter(nome -> nome.length()  <= 5).toList();

        for (String nome : nomesCincosCharacters){
            System.out.println("Nome: " + nome);
        }
    }
}
