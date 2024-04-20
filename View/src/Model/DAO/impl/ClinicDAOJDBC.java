package Model.DAO.impl;

import Factory.ConnectionFactory;
import Model.DAO.ClinicDAO;
import Model.Entities.Clinic;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClinicDAOJDBC implements ClinicDAO {

    private Connection conn;
    @Override
    public void insert(Clinic clinic) {
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(
                    "INSERT INTO CLINIC(nameOfClinic, address, phoneNumber, email, status) " +
                    "VALUES (?, ?, ?, ?, ?)"
            );
            pstm.setString(1, clinic.getNameOfClinic());
            pstm.setString(2, clinic.getAddress());
            pstm.setString(3, clinic.getPhoneNumber());
            pstm.setString(4, clinic.getEmail());
            pstm.setString(5, clinic.getAddress());
            pstm.execute();

        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeStatement(pstm);
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public void update(String nameOfClinic, String address, String phoneNumber, String email, Integer idClinic) {
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(
              "UPDATE CLINIC SET nameOfClinic = ?, address, = ?, phoneNumber = ?, email = ? WHERE idClinic = ?"
            );
            pstm.setString(1, nameOfClinic);
            pstm.setString(2, address);
            pstm.setString(3, phoneNumber);
            pstm.setString(4, email);
            pstm.setInt(5, idClinic);
            pstm.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.closeStatement(pstm);
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public void update(String address, String phoneNumber, String email, Integer idClinic) {
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(
                    "UPDATE CLINIC SET address, = ?, phoneNumber = ?, email = ? WHERE idClinic = ?"
            );

            pstm.setString(1, address);
            pstm.setString(2, phoneNumber);
            pstm.setString(3, email);
            pstm.setInt(4, idClinic);
            pstm.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.closeStatement(pstm);
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public void update(String phoneNumber, String email, Integer idClinic) {
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(
                    "UPDATE CLINIC SET phoneNumber = ?, email = ? WHERE idClinic = ?"
            );

            pstm.setString(1, phoneNumber);
            pstm.setString(2, email);
            pstm.setInt(3, idClinic);
            pstm.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.closeStatement(pstm);
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public void update(String email, Integer idClinic) {
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(
                    "UPDATE CLINIC SET email = ? WHERE idClinic = ?"
            );

            pstm.setString(1, email);
            pstm.setInt(3, idClinic);
            pstm.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.closeStatement(pstm);
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public Clinic findByID(Integer idClinic) {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(
                    "SELECT * FROM CLINIC WHERE idClinic = ?"
            );
            pstm.setInt(1, idClinic);
            rs = pstm.executeQuery();

            if (rs.next()) {
                return new Clinic(
                        rs.getInt("idClinic"),
                        rs.getString("nameOfClinic"),
                        rs.getString("address"),
                        rs.getString("phoneNumber"),
                        rs.getString("email"),
                        rs.getString("status")
                );
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conn);
            ConnectionFactory.closeStatement(pstm);
            ConnectionFactory.closeResultSet(rs);
        }
        return null;
    }

    @Override
    public List<Clinic> findAll() {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(
              "SELECT * FROM CLINIC"
            );
            rs = pstm.executeQuery();
            List<Clinic> listClinic = new ArrayList<>();

            while (rs.next()) {
                Clinic clinic = new Clinic(
                        rs.getInt("idClinic"),
                        rs.getString("nameOfClinic"),
                        rs.getString("address"),
                        rs.getString("phoneNumber"),
                        rs.getString("email"),
                        rs.getString("status")
                );
                listClinic.add(clinic);
            }
            return listClinic;
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
    public void disable(Clinic clinic) {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(
                    "UPDATE CLINIC SET status = ? WHERE idClinic = ?"
            );
            pstm.setString(1, "desativado");
            pstm.setInt(2, clinic.getIdClinic());
            pstm.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.closeStatement(pstm);
            ConnectionFactory.closeConnection(conn);
        }
    }
}
