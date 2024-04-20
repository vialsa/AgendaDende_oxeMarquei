package Model.DAO.impl;

import Factory.ConnectionFactory;
import Model.DAO.PatientDAO;
import Model.Entities.Patient;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAOJDBC implements PatientDAO {
    private Connection conn;

    @Override
    public void insert(Patient patient) {
        String sql = "INSERT INTO PATIENT(name, CPF, RG, phoneNumber1, phoneNumber2, dateOfBirth, createdAt, address, email, SIGTAP) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstm =  null;

        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, patient.getName());
            pstm.setString(2, patient.getCPF());
            pstm.setString(3, patient.getRG());
            pstm.setString(4, patient.getPhoneNumber1());
            pstm.setString(5, patient.getPhoneNumber2());
            pstm.setDate(6, Date.valueOf(patient.getDateOfBirth()));
            pstm.setTimestamp(7, Timestamp.valueOf(patient.getCreatedAt()));
            pstm.setString(8, patient.getAddress());
            pstm.setString(9, patient.getEmail());
            pstm.setString(10, patient.getSIGTAP());

            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeStatement(pstm);
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public void update(String phoneNumber1, String phoneNumber2, String address, String email, Integer idPatient) {
        PreparedStatement pstm =  null;

        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(
                    "UPDATE PATIENT SET phoneNumber1 = ?, phoneNumber2 = ?, address = ?, email = ? WHERE idPatient = ?"
            );

            pstm.setString(1, phoneNumber1);
            pstm.setString(2, phoneNumber2);
            pstm.setString(3, address);
            pstm.setString(4, email);
            pstm.setInt(5, idPatient);
            pstm.executeUpdate();
            System.out.println("FUNCIONOUUUU");
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeStatement(pstm);
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public Patient findById(Integer idPatient) {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM PATIENT WHERE idPatient = ?");

            pstm.setInt(1, idPatient);

            rs = pstm.executeQuery();

            if (rs.next()) {
                Patient patient = new Patient(
                        rs.getInt("idPatient"),
                        rs.getString("name"),
                        rs.getString("CPF"),
                        rs.getString("RG"),
                        rs.getString("phoneNumber1"),
                        rs.getString("phoneNumber2"),
                        rs.getDate("dateOfBirth").toLocalDate(),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getString("SIGTAP")
                );
                return patient;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conn);
            ConnectionFactory.closeStatement(pstm);
            ConnectionFactory.closeResultSet(rs);
        }
        return null;
    }

    @Override
    public List<Patient> findAll() {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM PATIENT");
            rs = pstm.executeQuery();

            List<Patient> listPatient = new ArrayList<>();

            while (rs.next()) {
                Patient patient = new Patient(
                        rs.getInt("idPatient"),
                        rs.getString("name"),
                        rs.getString("CPF"),
                        rs.getString("RG"),
                        rs.getString("phoneNumber1"),
                        rs.getString("phoneNumber2"),
                        rs.getDate("dateOfBirth").toLocalDate(),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getString("SIGTAP")
                );
                listPatient.add(patient);
            }
            return listPatient;
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(conn);
            ConnectionFactory.closeStatement(pstm);
            ConnectionFactory.closeResultSet(rs);
        }
        return null;
    }
}