package Modelo.DAO.impl;

import Fabrica.FabricaDeConexao;
import Modelo.Entidades.Paciente;
import Modelo.Entidades.Solicitacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Modelo.DAO.SolicitacaoDAO;
import java.sql.Statement;
        
public class SolicitacaoDAOJDBC implements SolicitacaoDAO {
    private Connection conn;
    
    @Override
    public Solicitacao insert(Solicitacao solicitation) {
        String sql = "INSERT INTO SOLICITATION(CRM, request, nameOfRequestDoctor, idPatient) VALUES (?, ?, ?, ?)";
        PreparedStatement pstm = null;
        Connection conn = null;

        try {
            conn = FabricaDeConexao.getConnection();
            pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstm.setString(1, solicitation.getCRM());
            pstm.setString(2, solicitation.getRequest());
            pstm.setString(3, solicitation.getNameOfRequestDoctor());
            pstm.setInt(4, solicitation.getPatient().getIdPatient());

            int affectedRows = pstm.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Falha ao inserir a solicitação, nenhuma linha afetada.");
            }

            try (ResultSet generatedKeys = pstm.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    solicitation.setIdSolicitation(generatedKeys.getInt(1)); // supondo que a classe Solicitacao tenha um método setId
                } else {
                    throw new SQLException("Falha ao inserir a solicitação, nenhum ID obtido.");
                }
            }
            return solicitation;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            FabricaDeConexao.closeStatement(pstm);
            FabricaDeConexao.closeConnection(conn);
        }
        return null;
    }
    
    @Override
    public Solicitacao findById(Integer idSolicitation) {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = FabricaDeConexao.getConnection();
            pstm = conn.prepareStatement(
                    "SELECT f.* FROM SOLICITATION f INNER JOIN PATIENT p ON f.idPatient = p.idPatient WHERE f.idSolicitation = ?"
            );
            pstm.setInt(1, idSolicitation);
            rs = pstm.executeQuery();

            if (rs.next()) {
                Solicitacao solicitation = new Solicitacao();
                Paciente patient = new Paciente();
                patient.setIdPatient(rs.getInt("idPatient"));

                solicitation.setIdSolicitation(rs.getInt("idSolicitation"));
                solicitation.setCRM(rs.getString("CRM"));
                solicitation.setRequest(rs.getString("request"));
                solicitation.setNameOfRequestDoctor(rs.getString("nameOfRequestDoctor"));
                solicitation.setPatient(patient);

                return solicitation;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            FabricaDeConexao.closeConnection(conn);
            FabricaDeConexao.closeStatement(pstm);
            FabricaDeConexao.closeResultSet(rs);
        }
        return null;
    }

    @Override
    public List<Solicitacao> findAll() {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = FabricaDeConexao.getConnection();
            pstm = conn.prepareStatement(
                    "SELECT f.* FROM SOLICITATION f INNER JOIN PATIENT p ON f.idPatient = p.idPatient"
            );
            rs = pstm.executeQuery();

            List<Solicitacao> listSolicitation = new ArrayList<>();

            while (rs.next()) {
                Solicitacao solicitation = new Solicitacao();
                Paciente patient = new Paciente();
                patient.setIdPatient(rs.getInt("idPatient"));

                solicitation.setIdSolicitation(rs.getInt("idSolicitation"));
                solicitation.setCRM(rs.getString("CRM"));
                solicitation.setRequest(rs.getString("request"));
                solicitation.setNameOfRequestDoctor(rs.getString("nameOfRequestDoctor"));
                solicitation.setPatient(patient);

                listSolicitation.add(solicitation);
            }
            return listSolicitation;
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            FabricaDeConexao.closeConnection(conn);
            FabricaDeConexao.closeStatement(pstm);
            FabricaDeConexao.closeResultSet(rs);
        }
        return null;
    }
}
