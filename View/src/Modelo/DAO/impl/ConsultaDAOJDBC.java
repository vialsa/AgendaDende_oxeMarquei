package Modelo.DAO.impl;

import Fabrica.FabricaDeConexao;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import Modelo.DAO.ConsultaDAO;
import Modelo.Entidades.AgentePublico;
import Modelo.Entidades.Clinica;
import Modelo.Entidades.Consulta;
import Modelo.Entidades.Medico;
import Modelo.Entidades.Solicitacao;

public class ConsultaDAOJDBC implements ConsultaDAO {

    private Connection conn;

    @Override
    public void insert(Consulta query) {
        String sql = "INSERT INTO QUERY(dateAndTimeConsultation, idPublicAgent, idSolicitation, idDoctor, idClinic) " +
                "VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstm =  null;

        try {
            conn = FabricaDeConexao.getConnection();
            pstm = conn.prepareStatement(sql);

            pstm.setTimestamp(1, Timestamp.valueOf(query.getDateAndTimeConsultation()));
            pstm.setInt(2, query.getPublicAgent().getIdPublicAgent());
            pstm.setInt(3, query.getSolicitation().getIdSolicitation());
            pstm.setInt(4, query.getDoctor().getIdDoctor());
            pstm.setInt(5, query.getClinic().getIdClinic());
            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            FabricaDeConexao.closeStatement(pstm);
            FabricaDeConexao.closeConnection(conn);
        }
    }

    @Override
    public void update(LocalDateTime dateAndTimeOfConsultation, Integer idQuery){
        PreparedStatement pstm = null;

        try {
            conn = FabricaDeConexao.getConnection();
            pstm = conn.prepareStatement(
                    "UPDATE QUERY SET dateAndTimeConsultation = ? WHERE idQuery = ?"
            );
            pstm.setTimestamp(1, Timestamp.valueOf(dateAndTimeOfConsultation));
            pstm.setInt(2, idQuery);
            pstm.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            FabricaDeConexao.closeStatement(pstm);
            FabricaDeConexao.closeConnection(conn);
        }
    }
    @Override
    public Consulta findById(Integer idQuery) {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = FabricaDeConexao.getConnection();
            pstm = conn.prepareStatement(
                        "SELECT q.* FROM QUERY q " +
                            "INNER JOIN PUBLIC_AGENT p ON p.idPublicAgent = q.idPublicAgent " +
                            "INNER JOIN SOLICITATION s ON s.idSolicitation = q.idSolicitation " +
                            "INNER JOIN DOCTOR d ON d.idDoctor = q.idDoctor " +
                            "INNER JOIN CLINIC c ON c.idClinic = q.idClinic " +
                            "WHERE q.idQuery = ?"
            );

            pstm.setInt(1, idQuery);
            rs = pstm.executeQuery();

            if (rs.next()) {

                AgentePublico publicAgent = new AgentePublico();
                publicAgent.setIdPublicAgent(rs.getInt("idPublicAgent"));

                Solicitacao solicitation = new Solicitacao();
                solicitation.setIdSolicitation(rs.getInt("idSolicitation"));

                Medico doctor = new Medico();
                doctor.setIdDoctor(rs.getInt("idDoctor"));

                Clinica clinic = new Clinica();
                clinic.setIdClinic(rs.getInt("idClinic"));

                return new Consulta(
                        rs.getInt("idQuery"),
                        solicitation,
                        publicAgent,
                        clinic,
                        doctor,
                        rs.getTimestamp("dateAndTimeConsultation").toLocalDateTime()
                );

            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            FabricaDeConexao.closeConnection(conn);
            FabricaDeConexao.closeStatement(pstm);
            FabricaDeConexao.closeResultSet(rs);
        }
        return null;
    }
    @Override
    public List<Consulta> findAll() {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = FabricaDeConexao.getConnection();
            pstm = conn.prepareStatement(
                        "SELECT q.* FROM QUERY q " +
                            "INNER JOIN PUBLIC_AGENT p ON p.idPublicAgent = q.idPublicAgent " +
                            "INNER JOIN SOLICITATION s ON s.idSolicitation = q.idSolicitation " +
                            "INNER JOIN DOCTOR d ON d.idDoctor = q.idDoctor " +
                            "INNER JOIN CLINIC c ON c.idClinic = q.idClinic"
            );
            rs = pstm.executeQuery();
            List<Consulta> listQuery = new ArrayList<>();

            while (rs.next()) {
                AgentePublico publicAgent = new AgentePublico();
                publicAgent.setIdPublicAgent(rs.getInt("idPublicAgent"));

                Solicitacao solicitation = new Solicitacao();
                solicitation.setIdSolicitation(rs.getInt("idSolicitation"));

                Medico doctor = new Medico();
                doctor.setIdDoctor(rs.getInt("idDoctor"));

                Clinica clinic = new Clinica();
                clinic.setIdClinic(rs.getInt("idClinic"));

                Consulta query = new Consulta(
                        rs.getInt("idQuery"),
                        solicitation,
                        publicAgent,
                        clinic,
                        doctor,
                        rs.getTimestamp("dateAndTimeConsultation").toLocalDateTime()
                );
                listQuery.add(query);
            }
            return listQuery;
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
