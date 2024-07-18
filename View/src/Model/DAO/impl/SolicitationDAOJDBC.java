package Model.DAO.impl;

import Factory.ConnectionFactory;
import Model.DAO.SolicitationDAO;
import Model.Entities.Patient;
import Model.Entities.Solicitation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class SolicitationDAOJDBC implements SolicitationDAO {
    private Connection conn;

    @Override
    public void insert(Solicitation solicitation) {
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.getConnection();
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
            ConnectionFactory.closeConnection(conn);
            ConnectionFactory.closeStatement(pstm);
        }
    }

    @Override
    public Solicitation findById(Integer idSolicitation) {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(
                    "SELECT f.* FROM SOLICITATION f INNER JOIN PATIENT p ON f.idPatient = p.idPatient WHERE f.idSolicitation = ?"
            );
            pstm.setInt(1, idSolicitation);
            rs = pstm.executeQuery();

            if (rs.next()) {
                Solicitation solicitation = new Solicitation();
                Patient patient = new Patient();
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
            ConnectionFactory.closeConnection(conn);
            ConnectionFactory.closeStatement(pstm);
            ConnectionFactory.closeResultSet(rs);
        }
        return null;
    }

    @Override
    public List<Solicitation> findAll() {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(
                    "SELECT f.* FROM SOLICITATION f INNER JOIN PATIENT p ON f.idPatient = p.idPatient"
            );
            rs = pstm.executeQuery();

            List<Solicitation> listSolicitation = new ArrayList<>();

            while (rs.next()) {
                Solicitation solicitation = new Solicitation();
                Patient patient = new Patient();
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
            ConnectionFactory.closeConnection(conn);
            ConnectionFactory.closeStatement(pstm);
            ConnectionFactory.closeResultSet(rs);
        }
        return null;
    }
}
