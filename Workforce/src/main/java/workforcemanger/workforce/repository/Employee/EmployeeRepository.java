package workforcemanger.workforce.repository.Employee;

import workforcemanger.workforce.model.Employee;
import workforcemanger.workforce.repository.Repository;

import java.util.List;

public interface EmployeeRepository extends Repository {
    boolean deleteById(int employeeId);
    List<Employee> getAll();
    Employee getById(int employeeId);
}
