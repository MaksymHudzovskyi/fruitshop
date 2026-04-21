package uaedunung.se.dao;

import java.sql.*;
import java.util.*;

public class UserDAO {

    private String url = "jdbc:mysql://127.0.0.1:3306/myapp?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private String user = "myuser";
    private String password = "1234";

    public List<Map<String, String>> getAllUsers() {
        List<Map<String, String>> users = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");

            while (rs.next()) {
                Map<String, String> u = new HashMap<>();
                u.put("name", rs.getString("name"));
                u.put("email", rs.getString("email"));
                users.add(u);
            }

            conn.close();

        } catch (Exception e) {
    e.printStackTrace();
    System.out.println("DB ERROR: " + e.getMessage());
}
        return users;
    }
}
