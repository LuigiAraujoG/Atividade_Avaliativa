public class Questao_3 {
    static void main() {
        System.out.println(ordemInversa("caio", 4));
    }

    public static String ordemInversa(String palavra, int acumulador){
        if(acumulador == 0) return "";

        return palavra.charAt(acumulador - 1) + ordemInversa(palavra, acumulador - 1);
    }
}
