package workforcemanger.workforce.model;


public class Employee {
    private int id ;
    private String name;
    private String email;
    private String phone;
    private String poste;
    private int departementID;
    public Employee(){}
    public Employee(int id, String name, String email, String phone, String poste, int departementID) {
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
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPoste() {
        return poste;
    }
    public int getDepartementID() {
        return departementID;
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
    public void setDepartementID(int departementID) {
        this.departementID = departementID;
    }
}
