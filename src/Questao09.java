public class Questao09 {
    static void main() {
        Double n1 = 2.4;
        Double n2 = 2.4;

        System.out.println("Qual é o maior " +  n1 + " ou "+ n2 + " | "+ maiorNumero(n1, n2));
    }

    public static <T extends Number & Comparable<T>> T maiorNumero(T n1, T n2){
        if (n1.compareTo(n2) >= 0){
            return n1;
        }
        return n2;
    }
}
