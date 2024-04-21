package Model.DAO.impl;

import Factory.ConnectionFactory;
import Model.DAO.PublicAgentDAO;
import Model.Entities.PublicAgent;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PublicAgentDAOJDBC implements PublicAgentDAO {
    private Connection conn;

    @Override
    public void insert(PublicAgent publicAgent) {
        String sql = "INSERT INTO PUBLIC_AGENT(name, CPF, RG, phoneNumber1, phoneNumber2, dateOfBirth, createdAt, address, email, userr, password, typeUser) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstm =  null;

        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, publicAgent.getName());
            pstm.setString(2, publicAgent.getCPF());
            pstm.setString(3, publicAgent.getRG());
            pstm.setString(4, publicAgent.getPhoneNumber1());
            pstm.setString(5, publicAgent.getPhoneNumber2());
            pstm.setDate(6, Date.valueOf(publicAgent.getDateOfBirth()));
            pstm.setTimestamp(7, Timestamp.valueOf(publicAgent.getCreatedAt()));
            pstm.setString(8, publicAgent.getAddress());
            pstm.setString(9, publicAgent.getEmail());
            pstm.setString(10, publicAgent.getUser());
            pstm.setString(11, publicAgent.getPassword());
            pstm.setString(12, publicAgent.getTypeUser());

            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeStatement(pstm);
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public void update(String phoneNumber1, String address, String email, Integer idPublicAgent) {
        PreparedStatement pstm =  null;

        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(
                    "UPDATE PUBLIC_AGENT SET phoneNumber1 = ?, address = ?, email = ? WHERE idPublicAgent = ?"
            );
            pstm.setString(1, phoneNumber1);
            pstm.setString(2, address);
            pstm.setString(3, email);
            pstm.setInt(4, idPublicAgent);
            pstm.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeStatement(pstm);
            ConnectionFactory.closeConnection(conn);
        }
    }

    @Override
    public PublicAgent findById(Integer idPublicAgent) {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM PUBLIC_AGENT WHERE idPublicAgent = ?");

            pstm.setInt(1, idPublicAgent);

            rs = pstm.executeQuery();

            if (rs.next()) {
                return new PublicAgent(
                        rs.getInt("idPublicAgent"),
                        rs.getString("name"),
                        rs.getString("CPF"),
                        rs.getString("RG"),
                        rs.getString("phoneNumber1"),
                        rs.getString("phoneNumber2"),
                        rs.getDate("dateOfBirth").toLocalDate(),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getString("typeUser")
                );
            }
            return null;
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
    public List<PublicAgent> findAll() {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement("SELECT * FROM PUBLIC_AGENT");
            rs = pstm.executeQuery();

            List<PublicAgent> listPublicAgent = new ArrayList<>();

            while (rs.next()) {
                PublicAgent publicAgent = new PublicAgent(
                        rs.getInt("idPublicAgent"),
                        rs.getString("name"),
                        rs.getString("CPF"),
                        rs.getString("RG"),
                        rs.getString("phoneNumber1"),
                        rs.getString("phoneNumber2"),
                        rs.getDate("dateOfBirth").toLocalDate(),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getString("typeUser")
                );
                listPublicAgent.add(publicAgent);
            }
            return listPublicAgent;
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(conn);
            ConnectionFactory.closeStatement(pstm);
            ConnectionFactory.closeResultSet(rs);
        }
        return null;
    }

    @Override
    public void disable(Integer idPublicAgent) {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(
                    "UPDATE PUBLIC_AGENT SET status = ? WHERE idClinic = ?"
            );
            pstm.setString(1, "desativado");
            pstm.setInt(2, idPublicAgent);
            pstm.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.closeStatement(pstm);
            ConnectionFactory.closeConnection(conn);
        }
    }
}
