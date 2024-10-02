package workforcemanger.workforce;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import workforcemanger.workforce.configuration.SessionFactoryUtil;
import workforcemanger.workforce.model.Employee;
import workforcemanger.workforce.service.EmployeeServices;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()) {
            EmployeeServices employeeServices = new EmployeeServices(new SessionFactoryUtil());
            Employee employee = new Employee();
            employee.setEmail("test@test.com");
            employee.setName("Test Employee");
            employee.setPhone("7778");
            employee.setPoste("Worker");
            employee.setDepartementID(4);
            transaction = session.beginTransaction();
            employeeServices.update(employee);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
