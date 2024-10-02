package workforcemanger.workforce.service;

import workforcemanger.workforce.configuration.SessionFactoryUtil;
import workforcemanger.workforce.dto.EmployeeDTO;
import workforcemanger.workforce.helper.DataValidator;
import workforcemanger.workforce.mapper.EmployeeDtoMapper;
import workforcemanger.workforce.model.Employee;
import workforcemanger.workforce.repository.Employee.EmployeeRepositoryImpl;

public class EmployeeServices {
    private final EmployeeRepositoryImpl employeeRepository;
    final DataValidator dataValidator = new DataValidator();
    final EmployeeDtoMapper employeeDtoMapper = new EmployeeDtoMapper();
    public EmployeeServices(SessionFactoryUtil sessionFactoryUtil) {
        this.employeeRepository = new EmployeeRepositoryImpl(sessionFactoryUtil);
    }
    public Employee create(EmployeeDTO employeeDTO) {
        try {
            if (!dataValidator.validate(employeeDTO)){
                return null;
            }
           return employeeRepository.create(employeeDtoMapper.mapToEmployee(employeeDTO));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public Employee update(EmployeeDTO employeeDTO) {
        try {
            if (!dataValidator.validate(employeeDTO)){
                return null;
            }
            return employeeRepository.update(employeeDtoMapper.mapToEmployee(employeeDTO));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public boolean delete(int employeeID) {
        try {
            return employeeRepository.deleteById(employeeID);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
