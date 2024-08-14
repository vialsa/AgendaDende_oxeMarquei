package Fabrica;

import java.sql.*;

public class FabricaDeConexao {

    
    public static Connection getConnection() {
        Connection connection = null;
        try {
            //Classe importada para usar o banco
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/teste"
            , "postgres", "1234");
            System.out.println("Conexao com o banco feita com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}