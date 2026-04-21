package uaedunung.se.servlet;

import uaedunung.se.dao.UserDAO;
import freemarker.template.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import java.io.*;
import java.util.*;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    private Configuration cfg;
    private UserDAO dao = new UserDAO();

    @Override
    public void init() throws ServletException {
        cfg = new Configuration(Configuration.VERSION_2_3_31);
        cfg.setClassForTemplateLoading(this.getClass(), "/templates");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");

        List<Map<String, String>> users = dao.getAllUsers();
System.out.println("Users size: " + users.size());
        Map<String, Object> data = new HashMap<>();
        data.put("message", "Users list:");
        data.put("users", users);

        try {
            Template template = cfg.getTemplate("hello.ftl");
            template.process(data, resp.getWriter());
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println("ERROR: " + e.getMessage());
        }
    }
}
