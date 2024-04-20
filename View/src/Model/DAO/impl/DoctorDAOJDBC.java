package Model.DAO.impl;

import Factory.ConnectionFactory;
import Model.DAO.DoctorDAO;
import Model.Entities.Clinic;
import Model.Entities.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAOJDBC implements DoctorDAO {
    private Connection conn;
    @Override
    public void insert(Doctor doctor) {
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(
                        "INSERT INTO DOCTOR(name, CPF, RG, phoneNumber1, phoneNumber2, dateOfBirth, " +
                            "createdAt, address, email, CRM, speciality, status, idClinic) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );
            pstm.setString(1, doctor.getName());
            pstm.setString(2, doctor.getCPF());
            pstm.setString(3, doctor.getRG());
            pstm.setString(4, doctor.getPhoneNumber1());
            pstm.setString(5, doctor.getPhoneNumber2());
            pstm.setDate(6, Date.valueOf(doctor.getDateOfBirth()));
            pstm.setTimestamp(7, Timestamp.valueOf(doctor.getCreatedAt()));
            pstm.setString(8, doctor.getAddress());
            pstm.setString(9, doctor.getEmail());
            pstm.setString(10, doctor.getCRM());
            pstm.setString(11, doctor.getSpeciality());
            pstm.setString(12, doctor.getStatus());
            pstm.setInt(13, doctor.getClinic().getIdClinic());

            pstm.execute();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.closeStatement(pstm);
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public void update(String phoneNumber1, String phoneNumber2, String address, String email, String status, Integer idDoctor) {
        PreparedStatement pstm =  null;

        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(
                    "UPDATE DOCTOR SET phoneNumber1 = ?, phoneNumber2 = ?, address = ?, email = ? WHERE idDoctor = ?"
            );

            pstm.setString(1, phoneNumber1);
            pstm.setString(2, phoneNumber2);
            pstm.setString(3, address);
            pstm.setString(4, email);
            pstm.setInt(5, idDoctor);
            pstm.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeStatement(pstm);
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public void update(String phoneNumber2, String address, String email, Integer idDoctor) {
        PreparedStatement pstm =  null;

        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(
                    "UPDATE DOCTOR SET phoneNumber2 = ?, address = ?, email = ? WHERE idDoctor = ?"
            );

            pstm.setString(1, phoneNumber2);
            pstm.setString(2, address);
            pstm.setString(3, email);
            pstm.setInt(4, idDoctor);
            pstm.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeStatement(pstm);
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public void update(String address, String email, Integer idDoctor) {
        PreparedStatement pstm =  null;

        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(
                    "UPDATE DOCTOR SET address = ?, email = ? WHERE idDoctor = ?"
            );

            pstm.setString(1, address);
            pstm.setString(2, email);
            pstm.setInt(3, idDoctor);
            pstm.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeStatement(pstm);
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public void update(String email, Integer idDoctor) {
        PreparedStatement pstm =  null;

        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(
                    "UPDATE DOCTOR SET email = ? WHERE idDoctor = ?"
            );

            pstm.setString(1, email);
            pstm.setInt(2, idDoctor);
            pstm.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeStatement(pstm);
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public Doctor findByID(Integer idDoctor) {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM DOCTOR WHERE idDoctor = ?");

            pstm.setInt(1, idDoctor);

            rs = pstm.executeQuery();

            if (rs.next()) {
                Clinic clinic = new Clinic();
                clinic.setIdClinic(rs.getInt("idClinic"));

                return new Doctor(
                        rs.getString("name"),
                        rs.getString("CPF"),
                        rs.getString("RG"),
                        rs.getString("phoneNumber1"),
                        rs.getString("phoneNumber2"),
                        rs.getDate("dateOfBirth").toLocalDate(),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getInt("idDoctor"),
                        rs.getString("CRM"),
                        rs.getString("speciality"),
                        rs.getString("status"),
                        clinic
                );
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
    public List<Doctor> findAll() {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(
                    "SELECT * FROM DOCTOR"
            );
            rs = pstm.executeQuery();
            List<Doctor> listDoctors = new ArrayList<>();
            if (rs.next()) {
                Clinic clinic = new Clinic();
                clinic.setIdClinic(rs.getInt("idClinic"));

                listDoctors.add(
                    new Doctor(
                            rs.getString("name"),
                            rs.getString("CPF"),
                            rs.getString("RG"),
                            rs.getString("phoneNumber1"),
                            rs.getString("phoneNumber2"),
                            rs.getDate("dateOfBirth").toLocalDate(),
                            rs.getString("address"),
                            rs.getString("email"),
                            rs.getInt("idDoctor"),
                            rs.getString("CRM"),
                            rs.getString("speciality"),
                            rs.getString("status"),
                            clinic
                    )
                );
                return listDoctors;
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
    public void disable(Doctor doctor) {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(
                    "UPDATE DOCTOR SET status = ? WHERE idDoctor = ?"
            );
            pstm.setString(1, "desativado");
            pstm.setInt(2, doctor.getIdDoctor());
            pstm.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.closeStatement(pstm);
            ConnectionFactory.closeConnection(conn);
        }
    }
}
