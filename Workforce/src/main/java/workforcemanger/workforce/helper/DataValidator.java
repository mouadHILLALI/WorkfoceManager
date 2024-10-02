package workforcemanger.workforce.helper;

import workforcemanger.workforce.dto.EmployeeDTO;
import java.util.regex.Pattern;

public class DataValidator {
    final String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    String phoneRegex = "^(?:\\+212|0)([5-7]\\d{8})$";
    public DataValidator() {

    }

    public boolean validate(EmployeeDTO employeeDTO ) {
        return validateName(employeeDTO) && validateEmail(employeeDTO)  && validatePoste(employeeDTO) && validateDepartement(employeeDTO);
    }

    private boolean validateName(EmployeeDTO employeeDTO) {
        if (employeeDTO.getName() == null || employeeDTO.getName().trim().isEmpty()) {
            System.out.println("Name cannot be null or empty");
            return false;
        }
        return true;
    }

    private boolean validateEmail(EmployeeDTO employeeDTO) {
        if (employeeDTO.getEmail() == null || !Pattern.matches(emailRegex, employeeDTO.getEmail())) {
            System.out.println("Invalid email format for: " + employeeDTO.getEmail());
            return false;
        }
        return true;
    }

    private boolean validatePhone(EmployeeDTO employeeDTO) {
        if (employeeDTO.getPhone() == null || !Pattern.matches(phoneRegex, employeeDTO.getPhone())) {
            System.out.println("Invalid phone number format for: " + employeeDTO.getPhone());
            return false;
        }
        return true;
    }

    private boolean validatePoste(EmployeeDTO employeeDTO) {
        if (employeeDTO.getPoste() == null || employeeDTO.getPoste().trim().isEmpty()) {
            System.out.println("Poste cannot be null or empty");
            return false;
        }
        return true;
    }

    private boolean validateDepartement(EmployeeDTO employeeDTO) {
        if (employeeDTO.getDepartment() == null || employeeDTO.getPoste().trim().isEmpty()) {
            System.out.println("department cannot be null or empty");
            return false;
        }
        return true;
    }
}
