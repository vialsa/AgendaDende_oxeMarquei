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
public class SolicitacaoDAOJDBC implements SolicitacaoDAO {
    private Connection conn;

    @Override
    public void insert(Solicitacao solicitation) {
        PreparedStatement pstm = null;

        try {
            conn = FabricaDeConexao.getConnection();
            pstm = conn.prepareStatement(
                    "INSERT INTO SOLICITATION(CRM, request, nameOfRequestDoctor, idPatient) VALUES (?, ?, ?, ?)"
            );

            pstm.setString(1, solicitation.getCRM());
            pstm.setString(2, solicitation.getRequest());
            pstm.setString(3, solicitation.getNameOfRequestDoctor());
            pstm.setInt(4, solicitation.getPatient().getIdPatient());

            pstm.execute();

        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            FabricaDeConexao.closeConnection(conn);
            FabricaDeConexao.closeStatement(pstm);
        }
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
