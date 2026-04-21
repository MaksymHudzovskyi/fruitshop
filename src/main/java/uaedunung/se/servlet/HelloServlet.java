package uaedunung.se.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<h1>Users table</h1>");
        out.println("<table border='1'>");
        out.println("<tr><th>Name</th><th>Email</th></tr>");

        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/myapp?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",
                    "myuser",
                    "1234"
            );

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM users");

            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getString("name") + "</td>");
                out.println("<td>" + rs.getString("email") + "</td>");
                out.println("</tr>");
            }

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
            out.println("<p style='color:red'>DB ERROR: " + e.getMessage() + "</p>");
        }

        out.println("</table>");
    }
}
