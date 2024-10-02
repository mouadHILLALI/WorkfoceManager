package workforcemanger.workforce.dto;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {
    private int id ;
    private String name;
    private String email;
    private String phone;
    private String poste;
    private int departementID;
    public EmployeeDTO() {
    }
    public EmployeeDTO(String name, String email, String phone, String poste, int departementID) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.poste = poste;
        this.departementID = departementID;
    }
    public EmployeeDTO( int id ,String name, String email, String phone, String poste, int departementID) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.poste = poste;
        this.departementID = departementID;
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

    public int getDepartementID() {
        return departementID;
    }

    public void setDepartementID(int departementID) {
        this.departementID = departementID;
    }
}
