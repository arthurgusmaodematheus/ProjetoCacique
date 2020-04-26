package org.example.persistencia;

import org.example.entidades.Carro;

import java.util.*;

public interface CarroDAO {
    boolean create (Carro carro);
    List<Carro> read();
    boolean update (Carro carro);
    boolean delete (Carro carro);

}
