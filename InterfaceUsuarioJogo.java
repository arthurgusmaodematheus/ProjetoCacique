package org.example;
import org.example.entidades.Jogo;
import org.example.persistencia.JogoDAO;
import org.example.persistencia.JogoDAOMySQL;
import java.util.*;
public class InterfaceUsuarioJogo {
    JogoDAO dao;
    Scanner in;

    public InterfaceUsuarioJogo(JogoDAO dao) {
        this.dao = dao;
        this.in = new Scanner(System.in);
    }

    public void comecar() {
        mostra();
    }

    private void mostra() {
        int o = 0;
        do {
            System.out.println("\n°°°°°°°°°°°°°°°°°°°°°°°° DEFININDO JOGADA °°°°°°°°°°°°°°°°°°°°°°°°°");
            System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
            System.out.println("° Digite 1 Para Definir Uma Nova Jogada Na Tabela                 °");
            System.out.println("° Digite 2 Para Ler Os Atuais Dados Da Tabela                     °");
            System.out.println("° Digite 3 Para Atualizar Os Dados Da Tabela                      °");
            System.out.println("° Digite 4 Para Deletar Algum Jogo                                °");
            System.out.println("° Digite 5 Voltar Ao Menu Principal                               °");
            System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
            o = in.nextInt();
            in.nextLine();

            switch (o) {
                case 1:
                    this.createjogo();
                    break;
                case 2:
                    this.readjogo();
                    break;
                case 3:
                    this.updatejogo();
                    break;
                case 4:
                    this.deletejogo();
                    break;
                case 5:
                    System.out.println("Processo Finalizado");
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }

        } while (o != 5);
    }


    private void createjogo() {
        Jogo jogo = new Jogo();

        System.out.println("\n-> Adicinar Novo Jogo");
        System.out.println("\n Nome - Time A: ");
        jogo.setNome_time_a(in.next());
        in.nextLine();

        System.out.println(" Nome - Time B: ");
        jogo.setNome_time_b(in.next());

        System.out.println(" Gols - Time A: ");
        jogo.setGols_time_a(in.nextInt());

        System.out.println(" Gols - Time B: ");
        jogo.setGols_time_b(in.nextInt());

        if (dao.create(jogo)) {
            System.out.println(" Jogo Adicionado!");
        } else {
            System.out.println("Erro Ao Tentar Adicionar o Jogo :/");
        }
    }

    private void readjogo() {
        List<Jogo> jogos = dao.read();

        System.out.println("\n°°°°°°°° Relatório De Jogadas Cadastradas °°°°°°°°");
        for (Jogo jogo : jogos) {
            System.out.println(jogo);
        }

    }

    private void updatejogo() {
        Jogo jogos = new Jogo();
        System.out.println("\n -> Atualizar Jogos ");
        System.out.println("\nInsira O ID Do Jogo A Ser Alterado: ");
        jogos.setId(in.nextLong());
        in.nextLine();

        System.out.println("Alterar O Nome Do Time A Para: ");
        jogos.setNome_time_a(in.nextLine());


        System.out.println("Alterar O Nome Do Time B Para: ");
        jogos.setNome_time_b(in.nextLine());

        System.out.println("Alterar O Número De Gols Do Time A Para: ");
        jogos.setGols_time_a(in.nextInt());
        in.nextLine();

        System.out.println("Alterar O Número De Gols Do Time B Para: ");
        jogos.setGols_time_b(in.nextInt());
        in.nextLine();

        if (dao.update(jogos)) {
            System.out.println("Jogo Atualizado No Banco De Dados Com Sucesso!");
        } else {
            System.out.println("Erro Ao Tentar Atualizar O Jogo :/");
        }
    }

    private void deletejogo() {
        List<Jogo> jogos = dao.read();
        while (true) {
            System.out.println("\n°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
            System.out.println("°°°°°°°°° Lista De Jogos Cadastrados °°°°°°°°°");
            int i = 0;
            for (Jogo jogo : jogos) {
                System.out.println(i + " - " + jogos);
                i++;
            }
            System.out.println(i + " - Cancelar Processo");
            System.out.println("Qual Jogo Da Lista Deseja Remover?\n");
            int o = in.nextInt();
            in.nextLine();
            if (o == i) {
                break;
            }
            if (o >= jogos.size() || o < 0) {
                System.out.println("Essa Opção Não Existe");
            } else {
                if (dao.delete(jogos.get(o))) {
                    System.out.println("Erro Ao Tentar Remover O Jogo Da Lista :/");
                } else {
                    System.out.println("Partida " + jogos.get(o).getNome_time_a() + " Contra " + jogos.get(o).getNome_time_b() + " Removida Do Banco De Dados Com Sucesso!");

                }
                break;

            }
            for (Jogo jogo : jogos) {
                System.out.println(jogo);
            }
        }

    }
}
