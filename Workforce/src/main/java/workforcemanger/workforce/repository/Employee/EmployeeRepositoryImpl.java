package workforcemanger.workforce.repository.Employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import workforcemanger.workforce.configuration.SessionFactoryUtil;
import workforcemanger.workforce.model.Employee;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    final SessionFactory sessionFactory;
    public EmployeeRepositoryImpl(SessionFactoryUtil sessionfactoryutil) {
        this.sessionFactory = sessionfactoryutil.getSessionFactory();
    }
    @Override
    public <T> T create(T t) {
        if (t instanceof Employee) {
            Transaction transaction = null;
            try (Session session = sessionFactory.openSession()) {
                transaction = session.beginTransaction();
                session.save(t);
                transaction.commit();
                return t;
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public <T> T delete(T t) {
       return null;
    }

    @Override
    public <T> T update(T t) {
        if (t instanceof Employee){
            Transaction transaction = null;
            try(Session session = sessionFactory.openSession()){
                transaction = session.beginTransaction();
                session.update(t);
                transaction.commit();
                return (T) t;
            }catch (Exception e){
                if (transaction != null){
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public <T> T get(T t) {
        if (t instanceof Employee){
            Transaction transaction = null;
            try(Session session = sessionFactory.openSession()){
                transaction = session.beginTransaction();
                Employee employee = (Employee) t;
            } catch (Exception e) {
                if (transaction != null){
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean deleteById(int employeeId) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            // Fetch the employee by ID
            Employee employee = session.get(Employee.class, employeeId);
            if (employee != null) {
                session.delete(employee); // Delete the fetched employee
                transaction.commit();
                return true; // Return true if deletion was successful
            } else {
                // Handle case where employee was not found
                System.out.println("Employee not found with ID: " + employeeId);
                return false; // Return false if no employee was found
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Rollback the transaction in case of error
            }
            e.printStackTrace();
            return false; // Return false if an exception occurred
        }
    }

}
