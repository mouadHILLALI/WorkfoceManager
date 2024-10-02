package workforcemanger.workforce.controller;

import workforcemanger.workforce.configuration.SessionFactoryUtil;
import workforcemanger.workforce.dto.EmployeeDTO;
import workforcemanger.workforce.service.EmployeeServices;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EmployeeServlet extends HttpServlet {
    SessionFactoryUtil sessionFactoryUtil = new SessionFactoryUtil();
    final EmployeeDTO employeeDTO = new EmployeeDTO();
    final EmployeeServices employeeServices = new EmployeeServices(sessionFactoryUtil);
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "create":
                createEmployee(req, resp);
                break;
            case "update":
                updateEmployee(req, resp);
                break;
            case "delete":
                deleteEmployee(req, resp);
                break;
            default:
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
                break;
        }

    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    public void createEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            employeeDTO.setName(req.getParameter("name"));
            employeeDTO.setEmail(req.getParameter("email"));
            employeeDTO.setPoste(req.getParameter("poste"));
            employeeDTO.setPhone(req.getParameter("phone"));
            employeeDTO.setDepartementID(Integer.parseInt(req.getParameter("departement_id")));
            employeeServices.create(employeeDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int employeeID = Integer.parseInt(req.getParameter("employee_id"));
            employeeServices.delete(employeeID);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void updateEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            employeeDTO.setName(req.getParameter("name"));
            employeeDTO.setEmail(req.getParameter("email"));
            employeeDTO.setPoste(req.getParameter("poste"));
            employeeDTO.setPhone(req.getParameter("phone"));
            employeeDTO.setDepartementID(Integer.parseInt(req.getParameter("departement_id")));
            employeeServices.update(employeeDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}