package org.example.persistencia;

import org.example.entidades.Carro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarroDAOMySQL implements CarroDAO {
    private String createSQL = "INSERT INTO carro (modelo, marca, ano, categoria) VALUES(?,?,?,?)";
    private String readSQL = "SELECT * FROM carro";
    private String updateSQL = "UPDATE carro SET modelo = ?, marca = ?, ano = ?, categoria = ? WHERE id = ?";
    private String deleteSQL = "DELETE FROM carro WHERE id = ?";
    private final MySQLConnection mysql = new MySQLConnection();

    @Override
    public boolean create(Carro carro) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(createSQL);
            stm.setString(1,carro.getModelo());
            stm.setString(2,carro.getMarca());
            stm.setInt(3,carro.getAno());
            stm.setString(4,carro.getCategoria());
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
    public List<Carro> read() {
      Connection conexao = mysql.getConnection();
      List<Carro> veiculo = new ArrayList();
      try{
          PreparedStatement pstm = conexao.prepareStatement(readSQL);
          ResultSet rs = pstm.executeQuery();
          while (rs.next()){
              Carro carro = new Carro();
              carro.setId(rs.getLong("id"));
              carro.setModelo(rs.getString("modelo"));
              carro.setMarca(rs.getString("marca"));
              carro.setAno(rs.getInt("ano"));
              carro.setCategoria(rs.getString("categoria"));
              veiculo.add(carro);
          }
          return veiculo;
      } catch (final SQLException ex){
          System.out.println("Houve Erro Na Conexão Com A Base De Dados");
          ex.printStackTrace();
      } catch (final Exception ex){
          ex.printStackTrace();
      }
      return veiculo;
    }

    @Override
    public boolean update(Carro carro) {
       Connection conexao = mysql.getConnection();
       int resultado = -1;

       try {
           PreparedStatement stm = conexao.prepareStatement(updateSQL);
           stm.setString(1, carro.getModelo());
           stm.setString(2, carro.getMarca());
           stm.setInt(3, carro.getAno());
           stm.setString(4, carro.getCategoria());
           stm.setLong(5, carro.getId());
           stm.executeUpdate();

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
        return (resultado >= 0);
    }

    @Override
    public boolean delete(Carro carro) {
        Connection conexao = mysql.getConnection();
        int resultado = -1;
        try{
            PreparedStatement stm = conexao.prepareStatement(deleteSQL);
            stm.setLong(1,carro.getId());
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
