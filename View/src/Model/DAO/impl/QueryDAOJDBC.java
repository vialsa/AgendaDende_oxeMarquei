package Model.DAO.impl;

import Factory.ConnectionFactory;
import Model.DAO.QueryDAO;
import Model.Entities.*;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class QueryDAOJDBC implements QueryDAO {

    private Connection conn;

    @Override
    public void insert(Query query) {
        String sql = "INSERT INTO QUERY(dateAndTimeConsultation, idPublicAgent, idSolicitation, idDoctor, idClinic) " +
                "VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstm =  null;

        try {
            conn = ConnectionFactory.getConnection();
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
            ConnectionFactory.closeStatement(pstm);
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public void update(LocalDateTime dateAndTimeOfConsultation, Integer idQuery){
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(
                    "UPDATE QUERY SET dateAndTimeConsultation = ? WHERE idQuery = ?"
            );
            pstm.setTimestamp(1, Timestamp.valueOf(dateAndTimeOfConsultation));
            pstm.setInt(2, idQuery);
            pstm.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.closeStatement(pstm);
            ConnectionFactory.closeConnection(conn);
        }
    }
    @Override
    public Query findById(Integer idQuery) {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();
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

                PublicAgent publicAgent = new PublicAgent();
                publicAgent.setIdPublicAgent(rs.getInt("idPublicAgent"));

                Solicitation solicitation = new Solicitation();
                solicitation.setIdSolicitation(rs.getInt("idSolicitation"));

                Doctor doctor = new Doctor();
                doctor.setIdDoctor(rs.getInt("idDoctor"));

                Clinic clinic = new Clinic();
                clinic.setIdClinic(rs.getInt("idClinic"));

                return new Query(
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
            ConnectionFactory.closeConnection(conn);
            ConnectionFactory.closeStatement(pstm);
            ConnectionFactory.closeResultSet(rs);
        }
        return null;
    }
    @Override
    public List<Query> findAll() {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(
                        "SELECT q.* FROM QUERY q " +
                            "INNER JOIN PUBLIC_AGENT p ON p.idPublicAgent = q.idPublicAgent " +
                            "INNER JOIN SOLICITATION s ON s.idSolicitation = q.idSolicitation " +
                            "INNER JOIN DOCTOR d ON d.idDoctor = q.idDoctor " +
                            "INNER JOIN CLINIC c ON c.idClinic = q.idClinic"
            );
            rs = pstm.executeQuery();
            List<Query> listQuery = new ArrayList<>();

            while (rs.next()) {
                PublicAgent publicAgent = new PublicAgent();
                publicAgent.setIdPublicAgent(rs.getInt("idPublicAgent"));

                Solicitation solicitation = new Solicitation();
                solicitation.setIdSolicitation(rs.getInt("idSolicitation"));

                Doctor doctor = new Doctor();
                doctor.setIdDoctor(rs.getInt("idDoctor"));

                Clinic clinic = new Clinic();
                clinic.setIdClinic(rs.getInt("idClinic"));

                Query query = new Query(
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
            ConnectionFactory.closeConnection(conn);
            ConnectionFactory.closeStatement(pstm);
            ConnectionFactory.closeResultSet(rs);
        }
        return null;
    }
}
