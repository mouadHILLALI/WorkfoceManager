package workforcemanger.workforce.service;

import workforcemanger.workforce.configuration.SessionFactoryUtil;
import workforcemanger.workforce.model.Employee;
import workforcemanger.workforce.repository.Employee.EmployeeRepositoryImpl;

public class EmployeeServices {
    private final EmployeeRepositoryImpl employeeRepository;
    public EmployeeServices(SessionFactoryUtil sessionFactoryUtil) {
        this.employeeRepository = new EmployeeRepositoryImpl(sessionFactoryUtil);
    }
    public Employee create(Employee employee) {
        try {
            return employeeRepository.create(employee);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public Employee update(Employee employee) {
        try {
            return employeeRepository.update(employee);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void delete(Employee employee) {
        try {
            employeeRepository.delete(employee);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
