import java.util.Objects;

public class Questao08 <T>{
    static void main() {
        Double[] vetor1 = new Double[] {5.4, 5.8, 9.4, 3.4, 1.9};
        System.out.println(verificarElemento(vetor1, 5.8));

        String[] vetor2 = new String[] {"Luigi", "Junior", "Caio"};
        System.out.println(verificarElemento(vetor2, "Junior"));
    }

    public static <T> boolean verificarElemento(T[] vetor, T elemento){
        for(T n : vetor){
            if (Objects.equals(n, elemento)){
                return true;
            }
        }
        return false;
    }
}
