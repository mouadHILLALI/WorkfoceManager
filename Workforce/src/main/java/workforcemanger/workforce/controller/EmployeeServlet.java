package workforcemanger.workforce.controller;

import workforcemanger.workforce.configuration.SessionFactoryUtil;
import workforcemanger.workforce.dto.EmployeeDTO;
import workforcemanger.workforce.model.Employee;
import workforcemanger.workforce.service.EmployeeServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

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
            default:
                System.out.println("Im here");
                break;
        }

    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action){
             case "update":
                 getEmployee(req, resp);
                 break;
            default:
                getAllEmployees(req, resp);
        }
    }

    public void createEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String poste = req.getParameter("poste");
            String phone = req.getParameter("phone");
            String department = req.getParameter("department");
            EmployeeDTO employeeDTO = new EmployeeDTO(name, email, poste, phone, department);
            Employee employee = employeeServices.create(employeeDTO);
            req.setAttribute("employee", employee);
            RequestDispatcher dispatcher;
            if(employee !=null){
                dispatcher = req.getRequestDispatcher("/Views/success.jsp");
            }else{
                dispatcher = req.getRequestDispatcher("/Views/fail.jsp");
            }
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().write("{\"error\": \"Failed to create employee.\"}");
            e.printStackTrace();
        }
    }
    public void deleteEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int employeeID = Integer.parseInt(req.getParameter("id"));
            boolean flag = employeeServices.delete(employeeID);
            RequestDispatcher dispatcher;
            if (flag) {
                req.setAttribute("flashMessage", "Employee deleted successfully!");
                dispatcher = req.getRequestDispatcher("/Views/success.jsp");
                dispatcher.forward(req, resp);
            } else if (!flag){
                req.setAttribute("flashMessage", "Employee could not be deleted!");
                dispatcher = req.getRequestDispatcher("/Views/fail.jsp");
                dispatcher.forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();

            if (!resp.isCommitted()) {
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error during employee deletion");
            }
        }
    }

    public void updateEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            employeeDTO.setName(req.getParameter("name"));
            employeeDTO.setId(Integer.parseInt(req.getParameter("id")));
            employeeDTO.setEmail(req.getParameter("email"));
            employeeDTO.setPoste(req.getParameter("poste"));
            employeeDTO.setPhone(req.getParameter("phone"));
            employeeDTO.setDepartment(req.getParameter("department"));
            Employee employee = employeeServices.update(employeeDTO);
            req.setAttribute("employee", employee);
            RequestDispatcher dispatcher;
            if(employee !=null){
                dispatcher = req.getRequestDispatcher("/Views/success.jsp");
            }else{
                dispatcher = req.getRequestDispatcher("/Views/fail.jsp");
            }
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void getAllEmployees(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("text/html");
            List<EmployeeDTO> employees = employeeServices.getAll();
            req.setAttribute("employees", employees);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/Views/employee.jsp?action=");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public void getEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int employeeID = Integer.parseInt(req.getParameter("id"));
            resp.setContentType("text/html");
            EmployeeDTO employee = employeeServices.get(employeeID);
            req.setAttribute("employee", employee);
            req.getRequestDispatcher("/Views/update.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}