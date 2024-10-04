package workforcemanger.workforce.service;

import workforcemanger.workforce.configuration.SessionFactoryUtil;
import workforcemanger.workforce.dto.EmployeeDTO;
import workforcemanger.workforce.helper.DataValidator;
import workforcemanger.workforce.mapper.EmployeeDtoMapper;
import workforcemanger.workforce.model.Employee;
import workforcemanger.workforce.repository.Employee.EmployeeRepositoryImpl;

import java.util.List;

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
    public List<EmployeeDTO> getAll() {
        try {
           return employeeDtoMapper.mapToEmployeeDTOs(employeeRepository.getAll());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public EmployeeDTO get(int employeeID) {
        try {
            return employeeDtoMapper.mapToEmployeeDTO(employeeRepository.getById(employeeID));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<EmployeeDTO> search(String search) {
        try {
            return employeeDtoMapper.mapToEmployeeDTOs(employeeRepository.search(search));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<EmployeeDTO> filer(String departement) {
        try {
            return employeeDtoMapper.mapToEmployeeDTOs(employeeRepository.filter(departement));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
