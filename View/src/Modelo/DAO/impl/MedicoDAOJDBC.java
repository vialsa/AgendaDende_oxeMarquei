package Modelo.DAO.impl;

import Fabrica.FabricaDeConexao;
import Modelo.Entidades.Clinica;
import Modelo.Entidades.Medico;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Modelo.DAO.MedicoDAO;

public class MedicoDAOJDBC implements MedicoDAO {
    private Connection conn;
    @Override
    public void insert(Medico doctor) {
        PreparedStatement pstm = null;

        try {
            conn = FabricaDeConexao.getConnection();
             pstm = conn.prepareStatement(
                "INSERT INTO DOCTOR(name, CPF, RG, phoneNumber1, phoneNumber2, dateOfBirth, " +
                "createdAt, email, CRM, specialty, status, idClinic) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );
            pstm.setString(1, doctor.getName());
            pstm.setString(2, doctor.getCPF());
            pstm.setString(3, doctor.getRG());
            pstm.setString(4, doctor.getPhoneNumber1());
            pstm.setString(5, doctor.getPhoneNumber2());
            pstm.setDate(6, Date.valueOf(doctor.getDateOfBirth()));
            pstm.setTimestamp(7, Timestamp.valueOf(doctor.getCreatedAt()));
            pstm.setString(8, doctor.getEmail());
            pstm.setString(9, doctor.getCRM());
            pstm.setString(10, doctor.getSpeciality());
            pstm.setString(11, doctor.getStatus());
            System.out.println("AQUI");
            pstm.setInt(12, doctor.getClinic().getIdClinic());
            System.out.println("AQUI");
            pstm.execute();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            FabricaDeConexao.closeStatement(pstm);
            FabricaDeConexao.closeConnection(conn);
        }
    }

    public void update(Integer idMedico, String nome, int clinica, String tel1, String tel2, String email) {
        PreparedStatement pstm =  null;

        try {
            conn = FabricaDeConexao.getConnection();
            pstm = conn.prepareStatement(
                    "UPDATE DOCTOR SET name = ?, idclinic = ?, phonenumber1 = ?, phonenumber2 = ?, email = ? WHERE iddoctor = ?"
            );

            pstm.setString(1, nome);
            pstm.setInt(2, clinica);
            pstm.setString(3, tel1);
            pstm.setString(4, tel2);
            pstm.setString(5, email);
            pstm.setInt(6, idMedico);
            pstm.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            FabricaDeConexao.closeStatement(pstm);
            FabricaDeConexao.closeConnection(conn);
        }
    }

    @Override
    public void update(String phoneNumber2, String email, Integer idDoctor) {
        PreparedStatement pstm =  null;

        try {
            conn = FabricaDeConexao.getConnection();
            pstm = conn.prepareStatement(
                    "UPDATE DOCTOR SET phoneNumber2 = ?, email = ? WHERE idDoctor = ?"
            );

            pstm.setString(1, phoneNumber2);
            pstm.setString(2, email);
            pstm.setInt(3, idDoctor);
            pstm.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            FabricaDeConexao.closeStatement(pstm);
            FabricaDeConexao.closeConnection(conn);
        }
    }

    @Override
    public void update(String email, Integer idDoctor) {
        PreparedStatement pstm =  null;

        try {
            conn = FabricaDeConexao.getConnection();
            pstm = conn.prepareStatement(
                    "UPDATE DOCTOR SET email = ? WHERE idDoctor = ?"
            );
            pstm.setString(1, email);
            pstm.setInt(2, idDoctor);
            pstm.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            FabricaDeConexao.closeStatement(pstm);
            FabricaDeConexao.closeConnection(conn);
        }
    }


    @Override
    public Medico findByID(Integer idDoctor) {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = FabricaDeConexao.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM DOCTOR WHERE idDoctor = ?");

            pstm.setInt(1, idDoctor);

            rs = pstm.executeQuery();

            if (rs.next()) {
                Clinica clinic = new Clinica();
                clinic.setIdClinic(rs.getInt("idClinic"));

                return new Medico(
                        rs.getString("name"),
                        rs.getString("CPF"),
                        rs.getString("RG"),
                        rs.getString("phoneNumber1"),
                        rs.getString("phoneNumber2"),
                        rs.getDate("dateOfBirth").toLocalDate(),
                        rs.getString("email"),
                        rs.getInt("idDoctor"),
                        rs.getString("CRM"),
                        rs.getString("specialty"),
                        rs.getString("status"),
                        clinic
                );
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
    public List<Medico> findAll() {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = FabricaDeConexao.getConnection();
            pstm = conn.prepareStatement(
                    "SELECT * FROM DOCTOR"
            );
            rs = pstm.executeQuery();
            List<Medico> listDoctors = new ArrayList<>();
            while (rs.next()) {
                Clinica clinic = new Clinica();
                clinic.setIdClinic(rs.getInt("idClinic"));

                listDoctors.add(new Medico(
                            rs.getString("name"),
                            rs.getString("CPF"),
                            rs.getString("RG"),
                            rs.getString("phoneNumber1"),
                            rs.getString("phoneNumber2"),
                            rs.getDate("dateOfBirth").toLocalDate(),
                            rs.getString("email"),
                            rs.getInt("idDoctor"),
                            rs.getString("CRM"),
                            rs.getString("specialty"),
                            rs.getString("status"),
                            clinic
                    )
                );   
            }
            return listDoctors;
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
    public void disable(Medico doctor) {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = FabricaDeConexao.getConnection();
            pstm = conn.prepareStatement(
                    "UPDATE DOCTOR SET status = ? WHERE idDoctor = ?"
            );
            pstm.setString(1, "desativado");
            pstm.setInt(2, doctor.getIdDoctor());
            pstm.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            FabricaDeConexao.closeStatement(pstm);
            FabricaDeConexao.closeConnection(conn);
        }
    }

    @Override
    public List<Medico> findBySpecialty(String specialty) {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = FabricaDeConexao.getConnection();
            pstm = conn.prepareStatement(
                    "SELECT * FROM DOCTOR WHERE specialty = ?"
            );
            pstm.setString(1, specialty);
            
            rs = pstm.executeQuery();
            List<Medico> listDoctors = new ArrayList<>();
            while (rs.next()) {
                Clinica clinic = new Clinica();
                clinic.setIdClinic(rs.getInt("idClinic"));

                listDoctors.add(new Medico(
                            rs.getString("name"),
                            rs.getString("CPF"),
                            rs.getString("RG"),
                            rs.getString("phoneNumber1"),
                            rs.getString("phoneNumber2"),
                            rs.getDate("dateOfBirth").toLocalDate(),
                            rs.getString("email"),
                            rs.getInt("idDoctor"),
                            rs.getString("CRM"),
                            rs.getString("specialty"),
                            rs.getString("status"),
                            clinic
                    )
                );
            }
            return listDoctors;
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
    public List<String> findAllSpecialty() {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            conn = FabricaDeConexao.getConnection();
            pstm = conn.prepareStatement(
                    "SELECT specialty FROM DOCTOR"
            );
 
            
            rs = pstm.executeQuery();
            List<String> listSpecialtys = new ArrayList<>();
            while (rs.next()) {
                listSpecialtys.add(rs.getString("specialty"));
            }
            return listSpecialtys;
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
    public void update(String phoneNumber1, String phoneNumber2, String email, String status, Integer idDoctor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
