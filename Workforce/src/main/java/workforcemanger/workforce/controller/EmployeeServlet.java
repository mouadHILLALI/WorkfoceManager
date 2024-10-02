package workforcemanger.workforce.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EmployeeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }


    public void createEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void updateEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
