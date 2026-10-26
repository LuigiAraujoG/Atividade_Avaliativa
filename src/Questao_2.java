public class Questao_2 {
    static void main() {
        System.out.println(potencia(2, 10));
    }

    public static int potencia(int base, int exp){
        if (exp == 0){
            return 1;
        }
        return base * potencia( base, exp - 1);
    }
}
