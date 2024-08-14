package Modelo.DAO.impl;

import Fabrica.FabricaDeConexao;
import Modelo.Entidades.AgentePublico;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.jasypt.util.password.BasicPasswordEncryptor;
import Modelo.DAO.AgentePublicoDAO;

public class AgentePublicoDAOJDBC implements AgentePublicoDAO {
    private Connection conn;

    @Override
    public void insert(AgentePublico publicAgent) {
        String sql = "INSERT INTO PUBLIC_AGENT(name, CPF, RG, phoneNumber1, phoneNumber2, dateOfBirth, createdAt, address, email, userr, password, typeUser) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstm =  null;

        try {
            conn = FabricaDeConexao.getConnection();
            pstm = conn.prepareStatement(sql);
            
            BasicPasswordEncryptor criptografador = new BasicPasswordEncryptor();
            String senhaCriptografada = criptografador
                    .encryptPassword(publicAgent.getPassword());
            
            pstm.setString(1, publicAgent.getName());
            pstm.setString(2, publicAgent.getCPF());
            pstm.setString(3, publicAgent.getRG());
            pstm.setString(4, publicAgent.getPhoneNumber1());
            pstm.setString(5, publicAgent.getPhoneNumber2());
            pstm.setDate(6, Date.valueOf(publicAgent.getDateOfBirth()));
            pstm.setTimestamp(7, Timestamp.valueOf(publicAgent.getCreatedAt()));
            pstm.setString(8, publicAgent.getAddress());
            pstm.setString(9, publicAgent.getEmail());
            pstm.setString(10, publicAgent.getUser());
            pstm.setString(11, senhaCriptografada);
            pstm.setString(12, publicAgent.getTypeUser());

            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            FabricaDeConexao.closeStatement(pstm);
            FabricaDeConexao.closeConnection(conn);
        }
    }
 
    public void updateAgente(Integer idPublicAgent, String email, String user, String password) {
        PreparedStatement pstm =  null;

        try {
            conn = FabricaDeConexao.getConnection();
            pstm = conn.prepareStatement(
                    "UPDATE PUBLIC_AGENT SET idpublicagent = ?, email = ?, userr = ?, password =? WHERE idpublicagent = ?"
            );
            pstm.setInt(1, idPublicAgent);
            pstm.setString(2, email);
            pstm.setString(3, user);
            pstm.setString(4, password);
            pstm.setInt(5,idPublicAgent);
            pstm.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            FabricaDeConexao.closeStatement(pstm);
            FabricaDeConexao.closeConnection(conn);
        }
    }

    @Override
    public AgentePublico findById(Integer idPublicAgent) {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = FabricaDeConexao.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM PUBLIC_AGENT WHERE idPublicAgent = ?");

            pstm.setInt(1, idPublicAgent);

            rs = pstm.executeQuery();

            if (rs.next()) {
                return new AgentePublico(
                        rs.getInt("idPublicAgent"),
                        rs.getString("name"),
                        rs.getString("CPF"),
                        rs.getString("RG"),
                        rs.getString("phoneNumber1"),
                        rs.getString("phoneNumber2"),
                        rs.getDate("dateOfBirth").toLocalDate(),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getString("typeuser"),
                        rs.getString("userr"),
                        rs.getString("password")
                );
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            FabricaDeConexao.closeConnection(conn);
            FabricaDeConexao.closeStatement(pstm);
            FabricaDeConexao.closeResultSet(rs);
        }
        return null;
    }

    @Override
    public List<AgentePublico> findAll() {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = FabricaDeConexao.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM PUBLIC_AGENT");
            rs = pstm.executeQuery();

            List<AgentePublico> listPublicAgent = new ArrayList<>();

            while (rs.next()) {
                AgentePublico publicAgent = new AgentePublico(
                        rs.getInt("idPublicAgent"),
                        rs.getString("name"),
                        rs.getString("CPF"),
                        rs.getString("RG"),
                        rs.getString("phoneNumber1"),
                        rs.getString("phoneNumber2"),
                        rs.getDate("dateOfBirth").toLocalDate(),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getString("typeUser")
                );
                listPublicAgent.add(publicAgent);
            }
            return listPublicAgent;
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            FabricaDeConexao.closeConnection(conn);
            FabricaDeConexao.closeStatement(pstm);
            FabricaDeConexao.closeResultSet(rs);
        }
        return null;
    }

    @Override
    public AgentePublico containsUser(String user, String password) {
        PreparedStatement pstm =  null;
        ResultSet rs = null;

        try {
            conn = FabricaDeConexao.getConnection();
            pstm = conn.prepareStatement(
                    "SELECT * FROM PUBLIC_AGENT WHERE userr = ? AND password = ?"
            );
            pstm.setString(1, user);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
            
            if(rs.next()){
                return new AgentePublico(
                        rs.getInt("idPublicAgent"),
                        rs.getString("name"),
                        rs.getString("CPF"),
                        rs.getString("RG"),
                        rs.getString("phoneNumber1"),
                        rs.getString("phoneNumber2"),
                        rs.getDate("dateOfBirth").toLocalDate(),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getString("typeUser")
                );
            } 
            
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            FabricaDeConexao.closeConnection(conn);
            FabricaDeConexao.closeStatement(pstm);
            FabricaDeConexao.closeResultSet(rs);
        }
        return null;
    }
    
    @Override
    public void disable(Integer idPublicAgent) {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = FabricaDeConexao.getConnection();
            pstm = conn.prepareStatement(
                    "UPDATE PUBLIC_AGENT SET status = ? WHERE idClinic = ?"
            );
            pstm.setString(1, "desativado");
            pstm.setInt(2, idPublicAgent);
            pstm.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            FabricaDeConexao.closeStatement(pstm);
            FabricaDeConexao.closeConnection(conn);
        }
    }

    @Override
    public void update(String phoneNumber1, String address, String email, Integer idPublicAgent) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
