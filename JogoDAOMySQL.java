package org.example.persistencia;

import org.example.entidades.Carro;
import org.example.entidades.Jogo;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class JogoDAOMySQL implements JogoDAO {
    private String createSQL = "INSERT INTO jogo (nome_time_a, nome_time_b, gols_time_a, gols_time_b) VALUES(?,?,?,?)";
    private String readSQL = "SELECT * FROM jogo";
    private String updateSQL = "UPDATE jogo SET nome_time_a = ?, nome_time_b = ?, gols_time_a = ?, gols_time_b = ? WHERE id = ?";
    private String deleteSQL = "DELETE FROM jogo WHERE id = ?";
    private final MySQLConnection mysql = new MySQLConnection();

    @Override
    public boolean create(Jogo jogo) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(createSQL);
            stm.setString(1,jogo.getNome_time_a());
            stm.setString(2,jogo.getNome_time_b());
            stm.setInt(3,jogo.getGols_time_a());
            stm.setInt(4,jogo.getGols_time_b());
            int registro = stm.executeUpdate();
            return (registro > 0);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally{
            try {
                conexao.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<Jogo> read() {
        Connection conexao = mysql.getConnection();
        List<Jogo> jogada = new ArrayList();
        try{
            PreparedStatement pstm = conexao.prepareStatement(readSQL);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                Jogo jogo = new Jogo();
                jogo.setId(rs.getLong("id"));
                jogo.setNome_time_a(rs.getString("nome_time_a"));
                jogo.setGols_time_a(rs.getInt("gols_time_a"));
                jogo.setNome_time_b(rs.getString("nome_time_b"));
                jogo.setGols_time_b(rs.getInt("gols_time_b"));
                jogada.add(jogo);
            }
            return jogada;
        } catch (final SQLException ex){
            System.out.println("Houve Erro Na Conexão Com A Base De Dados");
            ex.printStackTrace();
        } catch (final Exception ex){
            ex.printStackTrace();
        }
        return jogada;
    }

    @Override
    public boolean update(Jogo jogo) {
        Connection conexao = mysql.getConnection();
        int resultado = -1;
        try {
            PreparedStatement stm = conexao.prepareStatement(updateSQL);
            stm.setString(1, jogo.getNome_time_a());
            stm.setString(2, jogo.getNome_time_b());
            stm.setInt(3, jogo.getGols_time_a());
            stm.setInt(4, jogo.getGols_time_b());
            stm.setLong(5, jogo.getId());
            resultado = stm.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try {
                conexao.close();
            } catch (SQLException e){
                e.printStackTrace();
            }

        }
        return (resultado>0);
    }

    @Override
    public boolean delete(Jogo jogo) {
        Connection conexao = mysql.getConnection();
        int resultado = -1;
        try{
            PreparedStatement stm = conexao.prepareStatement(deleteSQL);
            stm.setLong(1,jogo.getId());
            stm.execute();
            stm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally{
            try{
                conexao.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return (resultado>0);
    }
    }


