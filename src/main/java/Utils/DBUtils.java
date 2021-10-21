package Utils;

import java.sql.*;
import java.util.UUID;

public class DBUtils {

    private static final String DB_URL = System.getenv("JDBC_URL");
    private static final String USER = System.getenv("JDBC_USER_NAME");
    private static final String PASS = System.getenv("JDBC_PASSWORD");

    public Connection getConn () throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        return conn;
    }

    public static void jdbcSample(){
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM MYSCHEMA.EMPLOYEES");

            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                System.out.print("PKEY: " + rs.getInt("PKEY"));
                System.out.print(", FIRSTNAME: " + rs.getString("FIRSTNAME"));
                System.out.print(", LASTNAME: " + rs.getString("LASTNAME"));
                System.out.println(", COUNTRY: " + rs.getString("COUNTRY"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        System.out.println(UUID.randomUUID());
        System.out.println(UUID.randomUUID());
        System.out.println(UUID.randomUUID());
        System.out.println(UUID.randomUUID());
        System.out.println(UUID.randomUUID());
        System.out.println(UUID.randomUUID());
    }

}
