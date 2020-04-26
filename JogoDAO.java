package org.example.persistencia;

import org.example.entidades.Jogo;

import java.util.*;

public interface JogoDAO {
    boolean create (Jogo jogo);
    List<Jogo> read();
    boolean update (Jogo jogo);
    boolean delete (Jogo jogo);

}