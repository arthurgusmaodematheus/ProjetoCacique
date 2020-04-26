package org.example;
import org.example.persistencia.JogoDAOMySQL;
import org.example.persistencia.CarroDAOMySQL;

import java.util.*;

public class App {


    public static void main(String[] args) {
        int o = 0;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("\n°°°°°°°° MENU °°°°°°°°°°");
            System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°");
            System.out.println("° Digite 1 Para Carros °");
            System.out.println("° Digite 2 Para Jogos  °");
            System.out.println("° Digite 3 Para Sair   °");
            System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°");
            o = in.nextInt();
            in.nextLine();

            switch (o) {
                case 1:
                    CarroDAOMySQL cardaomy = new CarroDAOMySQL();
                    InterfaceUsuarioCarro interfaceUsuarioCar = new InterfaceUsuarioCarro(cardaomy);
                    interfaceUsuarioCar.comecar();
                    break;
                case 2:
                    JogoDAOMySQL jogdaomy = new JogoDAOMySQL();
                    InterfaceUsuarioJogo interfaceUsuarioJog = new InterfaceUsuarioJogo(jogdaomy);
                    interfaceUsuarioJog.comecar();
                    break;
                case 3:
                    System.out.println("Operação Finalizada");
                    break;
                default:
                    System.out.println("Esta Opção É Inválida");
                    break;
            }
        } while (o != 3);
    }

}