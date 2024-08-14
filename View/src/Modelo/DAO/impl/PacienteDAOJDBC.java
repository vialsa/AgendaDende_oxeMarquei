package Modelo.DAO.impl;

import Fabrica.FabricaDeConexao;
import Modelo.Entidades.Paciente;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Modelo.DAO.PacienteDAO;

public class PacienteDAOJDBC implements PacienteDAO {
    private Connection conn;

    @Override
    public void insert(Paciente patient) {
        String sql = "INSERT INTO PATIENT(name, CPF, RG, phoneNumber1, phoneNumber2, dateOfBirth, createdAt, address, email, SIGTAP) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstm =  null;

        try {
            conn = FabricaDeConexao.getConnection();
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
            FabricaDeConexao.closeStatement(pstm);
            FabricaDeConexao.closeConnection(conn);
        }
    }

    
    public void update(String nome, String phoneNumber1, String phoneNumber2, String address, String email, Integer idPatient) {
        PreparedStatement pstm =  null;

        try {
            conn = FabricaDeConexao.getConnection();
            pstm = conn.prepareStatement(
                    "UPDATE PATIENT SET phoneNumber1 = ?, phoneNumber2 = ?, address = ?, email = ?, name = ? WHERE idPatient = ?"
            );

            pstm.setString(1, phoneNumber1);
            pstm.setString(2, phoneNumber2);
            pstm.setString(3, address);
            pstm.setString(4, email);
            pstm.setString(5, nome);
            pstm.setInt(6, idPatient);
            pstm.executeUpdate();
            System.out.println("FUNCIONOUUUU");
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            FabricaDeConexao.closeStatement(pstm);
            FabricaDeConexao.closeConnection(conn);
        }
    }

    @Override
    public Paciente findById(Integer idPatient) {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = FabricaDeConexao.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM PATIENT WHERE idPatient = ?");

            pstm.setInt(1, idPatient);

            rs = pstm.executeQuery();

            if (rs.next()) {
                Paciente patient = new Paciente(
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
            FabricaDeConexao.closeConnection(conn);
            FabricaDeConexao.closeStatement(pstm);
            FabricaDeConexao.closeResultSet(rs);
        }
        return null;
    }
    
    @Override
    public List<Paciente> findAll() {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = FabricaDeConexao.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM PATIENT");
            rs = pstm.executeQuery();

            List<Paciente> listPatient = new ArrayList<>();

            while (rs.next()) {
                Paciente patient = new Paciente(
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
            FabricaDeConexao.closeConnection(conn);
            FabricaDeConexao.closeStatement(pstm);
            FabricaDeConexao.closeResultSet(rs);
        }
        return null;
    }

    @Override
    public void update(String phoneNumber1, String phoneNumber2, String address, String email, Integer idPatient) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}