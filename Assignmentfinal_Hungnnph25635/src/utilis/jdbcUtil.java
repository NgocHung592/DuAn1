package utilis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbcUtil {

    private static Connection con;

    public static Connection getConnection() {
        if (jdbcUtil.con == null) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

                String dbUser = "sa";
                String dbPass = "123456";
                String dbUrl = "jdbc:sqlserver://localhost:1433;databasename=assignment_java"
                        + ";encrypt=true;trustServerCertificate=true;";
                jdbcUtil.con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return con;
    }
}
