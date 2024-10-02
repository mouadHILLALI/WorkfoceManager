package workforcemanger.workforce.model;


public class Employee {
    private int id ;
    private String name;
    private String email;
    private String phone;
    private String poste;
    private String department;
    public Employee(){}
    public Employee(int id, String name, String email, String phone, String poste, String department) {
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
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPoste() {
        return poste;
    }
    public String getDepartment() {
        return department;
    }

    public String getPhone() {
        return phone;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setPoste(String poste) {
        this.poste = poste;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
}
