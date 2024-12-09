package workforcemanger.workforce.controller;

import org.hibernate.SessionFactory;
import workforcemanger.workforce.configuration.SessionFactoryUtil;
import workforcemanger.workforce.model.Departement;
import workforcemanger.workforce.repository.Departement.DepartementRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DepartmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    create(req, resp);
    }
    public void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
            String name = req.getParameter("name");

            DepartementRepositoryImpl departementRepository = new DepartementRepositoryImpl(sessionFactory);
            Departement departement = new Departement();
            departement.setName(name);
            departementRepository.create(departement);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
