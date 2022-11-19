package Repositories;

import models.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositoryAccount {

    public Account login(String username, String password) {
        Connection conn = utilis.jdbcUtil.getConnection();

        String sql = "SELECT * FROM Logins WHERE username=? AND password=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            if (rs.next() == false) {
                return null;
            }

            String role = rs.getString("vai_tro");

            Account account = new Account(username, password, role);
            return account;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
