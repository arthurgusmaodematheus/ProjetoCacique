package org.example;
import org.example.entidades.Carro;
import org.example.persistencia.CarroDAO;
import org.example.persistencia.CarroDAOMySQL;

import java.util.*;
public class InterfaceUsuarioCarro {
    CarroDAO dao;
    Scanner in;

    public InterfaceUsuarioCarro(CarroDAO dao) {
        this.dao = dao;
        this.in = new Scanner(System.in);
    }

    public void comecar() {
        mostra();
    }

    private void mostra() {
        int o = 0;
        do {
            System.out.println("\n°°°°°°°°°°°°°°°°°°° DEFININDO VEÍCULO °°°°°°°°°°°°°°°°°°");
            System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
            System.out.println("° Digite 1 Para Definir Um Novo Veículo Na Tabela      °");
            System.out.println("° Digite 2 Para Ler Os Atuais Dados Da Tabela          °");
            System.out.println("° Digite 3 Para Atualizar Os Dados Da Tabela           °");
            System.out.println("° Digite 4 Para Deletar Algum Veículo                  °");
            System.out.println("° Digite 5 Para Voltar Ao Menu Principal               °");
            System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
            o = in.nextInt();
            in.nextLine();

            switch (o) {
                case 1:
                    this.createvei();
                    break;
                case 2:
                    this.readvei();
                    break;
                case 3:
                    this.updatevei();
                    break;
                case 4:
                    this.deletevei();
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

    private void createvei(){
        Carro carro = new Carro();

        System.out.println("\n-> Adicionar Novo Veículo");
        System.out.println("\n Digite O Modelo:                                       °");
        carro.setModelo(in.next());
        in.nextLine();

        System.out.println("° Digite A Marca:                                        °");
        carro.setMarca(in.next());

        System.out.println("° Digite O Ano:                                          °");
        carro.setAno(in.nextInt());

        System.out.println("° Digite A Categoria:                                    °");
        carro.setCategoria(in.next());

        if (dao.create(carro)) {
            System.out.println("° Veículo Adicionado Ao Banco De Dados Com Sucesso!  °");
        } else {
            System.out.println("° Erro Ao Tentar Adicionar O Veículo :/              °");
        }
    }

    private void readvei() {
        List<Carro> carros = dao.read();

        System.out.println("\n°°°°°°°°° Lista De Veículos Cadastrados °°°°°°°°°");
        for (Carro carro : carros) {
            System.out.println(carro);
        }

    }

    private void updatevei() {
        Carro carros = new Carro();
        System.out.println("\n-> Atualizar Veículos ");
        System.out.println("\nInsira O ID Do Carro A Ser Alterado: ");
        carros.setId(in.nextLong());
        in.nextLine();

        System.out.println("Alterar A Marca Do Veículo Para: ");
        carros.setMarca(in.nextLine());


        System.out.println("Alterar O Modelo Do Veículo Para: ");
        carros.setModelo(in.nextLine());


        System.out.println("Alterar A Categoria Do Veículo Para:");
        carros.setCategoria(in.nextLine());


        System.out.println("Alterar O Ano Do Veículo Para:");
        carros.setAno(in.nextInt());


        if (dao.update(carros)) {
            System.out.println("Veículo Atualizado No Banco De Dados Com Sucesso!");
        } else {
            System.out.println("Erro Ao Tentar Atualizar O Veículo :/");
        }
    }

    private void deletevei() {
        List<Carro> carros = dao.read();

        while (true) {
            System.out.println("\n°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
            System.out.println("°°°°°°°°° Lista De Veículos Cadastrados °°°°°°°°°");
            int i = 0;
            for (Carro carro : carros) {
                System.out.println(i + " - " + carros);
                i++;
            }
            System.out.println(i + " - Cancelar Processo");
            System.out.println("Qual Carro Da Lista Deseja Remover?\n");
            int o = in.nextInt();
            in.nextLine();
            if (o == i) {
                break;
            }
            if (o >= carros.size() || o < 0) {
                System.out.println("Essa Opção Não Existe");
            } else {
                if (dao.delete(carros.get(o))) {
                    System.out.println("Erro Ao Tentar Remover O Veículo Da Lista :/");
                } else {
                    System.out.println(carros.get(o).getMarca() + " " + carros.get(o).getModelo() + " " + carros.get(o).getAno() + " Removido Do Banco De Dados Com Sucesso!");

                }
                break;

            }
            for (Carro carro : carros) {
                System.out.println(carro);
            }
        }
    }


}
