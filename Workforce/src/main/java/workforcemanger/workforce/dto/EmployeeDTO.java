package workforcemanger.workforce.dto;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {
    private int id ;
    private String name;
    private String email;
    private String phone;
    private String poste;
    private String department;
    public EmployeeDTO() {
    }
    public EmployeeDTO(String name, String email, String phone, String poste, String department) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.poste = poste;
        this.department = department;
    }
    public EmployeeDTO( int id ,String name, String email, String phone, String poste, String department ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.poste = poste;
        this.department = department;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
