package workforcemanger.workforce.mapper;

import workforcemanger.workforce.dto.EmployeeDTO;
import workforcemanger.workforce.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDtoMapper {

    public EmployeeDtoMapper() {
    }

    public Employee mapToEmployee(EmployeeDTO employeeDTO) {
        if (employeeDTO == null) {
            throw new IllegalArgumentException("EmployeeDTO cannot be null");
        }
        try {
            return new Employee(
                    employeeDTO.getId(),
                    employeeDTO.getName(),
                    employeeDTO.getEmail(),
                    employeeDTO.getPhone(),
                    employeeDTO.getPoste(),
                    employeeDTO.getDepartment()
            );
        } catch (Exception e) {
            throw new RuntimeException("Error while mapping EmployeeDTO to Employee", e);
        }
    }
    public EmployeeDTO mapToEmployeeDTO(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee cannot be null");
        }

        try {
            return new EmployeeDTO(
                    employee.getId(),
                    employee.getName(),
                    employee.getEmail(),
                    employee.getPhone(),
                    employee.getPoste(),
                    employee.getDepartment()
            );
        } catch (Exception e) {
            throw new RuntimeException("Error while mapping Employee to EmployeeDTO", e);
        }
    }
    public List<EmployeeDTO> mapToEmployeeDTOs(List<Employee> employees) {
     if (employees == null) {
         throw new IllegalArgumentException("Employees cannot be null");
     }
     List<EmployeeDTO> employeeDTOs = new ArrayList<EmployeeDTO>();
     employees.forEach(employee -> employeeDTOs.add(mapToEmployeeDTO(employee)));
     return employeeDTOs;
    }
}
