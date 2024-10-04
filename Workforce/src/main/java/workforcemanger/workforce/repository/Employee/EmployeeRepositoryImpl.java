package workforcemanger.workforce.repository.Employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import workforcemanger.workforce.configuration.SessionFactoryUtil;
import workforcemanger.workforce.model.Employee;

import java.util.Collections;
import java.util.List;

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
        return null;
    }

    @Override
    public boolean deleteById(int employeeId) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Employee employee = session.get(Employee.class, employeeId);
            if (employee != null) {
                session.delete(employee);
                transaction.commit();
                return true;
            } else {
                System.out.println("Employee not found with ID: " + employeeId);
                return false;
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public List<Employee> getAll() {
        try (Session session = sessionFactory.openSession()) {
            List<Employee> employees = session.createQuery("from Employee", Employee.class).list();
            return employees;
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch employees", e);
        }
    }

    @Override
    public Employee getById(int employeeId) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            Employee employee = session.get(Employee.class, employeeId);
            transaction.commit();
            return employee;
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employee> search(String name) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            List<Employee> employees = session.createQuery(
                            "from Employee e where e.name LIKE :name", Employee.class)
                    .setParameter("name", "%" + name + "%")
                    .list();
            transaction.commit();
            return employees;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Employee> filter(String departement) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            List<Employee> employees = session.createQuery(
                            "from Employee e where e.department LIKE :name", Employee.class)
                    .setParameter("department", "%" + departement + "%")
                    .list();
            transaction.commit();
            return employees;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
    }

}
