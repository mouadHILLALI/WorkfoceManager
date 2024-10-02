package workforcemanger.workforce.mapper;

import workforcemanger.workforce.dto.EmployeeDTO;
import workforcemanger.workforce.model.Employee;

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
                    employeeDTO.getDepartementID()
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
                    employee.getDepartementID()
            );
        } catch (Exception e) {
            throw new RuntimeException("Error while mapping Employee to EmployeeDTO", e);
        }
    }
}
