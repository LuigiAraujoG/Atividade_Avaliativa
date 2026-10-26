import java.util.ArrayList;

public class Questao_7 {
    static void main() {
        GerenciarEvento gerenciarEvento = new GerenciarEvento(4, 3);

        gerenciarEvento.AdicionarAtividade(1,2, "Palestra de Java");
        gerenciarEvento.AdicionarAtividade(1,1, "Workshop de IA");

        gerenciarEvento.listarEvento();



    }

    public static class GerenciarEvento {
        private ArrayList<ArrayList<ArrayList<String>>> evento;

        public GerenciarEvento(int qtdDias, int qtdSalas) {
            this.evento = new ArrayList<>();
            for (int i = 0; i < qtdDias; i++){
                ArrayList<ArrayList<String>> dia = new ArrayList<>();

                for (int j = 0; j < qtdSalas; j++){
                    ArrayList<String> sala = new ArrayList<>();
                    dia.add(sala);
                }
                this.evento.add(dia);
            }
        }

        public void AdicionarAtividade(int dia, int sala, String atividade){
            this.evento.get(dia - 1).get(sala - 1 ).add(atividade);
        }

        public void removerAtividade(int dia, int sala, String atividade){
            this.evento.get(dia - 1).get(sala - 1).remove(atividade);
        }

        public void listarEvento(){
            int qtdDia = 1;
            for (ArrayList<ArrayList<String>> dia : this.evento){
                System.out.println("Dia " + qtdDia);

                int qtdSala = 1;
                for (ArrayList<String> sala : dia){
                    System.out.println("Sala " + qtdSala);

                    if (sala.isEmpty()){
                        System.out.println("Sem Atividade!");
                    } else {
                        System.out.println("Atividade: " + sala);
                    }
                    qtdSala++;
                }
                qtdDia++;
                System.out.println();
            }
        }
    }
}
