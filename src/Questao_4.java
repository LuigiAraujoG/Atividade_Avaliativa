import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Questao_4 {
    static void main() {


        ArrayList<Produto> produtos=  new ArrayList<>();
        produtos.add(new Produto("Pastel", 7.5));
        produtos.add(new Produto("Coxinha", 5.5));
        produtos.add(new Produto("Doce de leite", 2.5));
        produtos.add(new Produto("Coca", 1.5));
        produtos.add(new Produto("Biscoito", 12.5));

        produtos.sort(Comparator.comparingDouble(Produto::getPreco).reversed());

        for(Produto produto : produtos){
            System.out.println(produto.nome + ", R$" + produto.preco);
        }

    }

    public static class Produto{
        private String nome;
        private double preco;

        public  Produto(String nome, double preco){
            this.nome = nome;
            this.preco = preco;
        }
        public double getPreco() {
            return preco;
        }

        public String getNome() {
            return nome;
        }
    }

}
