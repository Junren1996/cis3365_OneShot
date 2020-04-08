package GUI.Class;



public class employee {
    private Long id;
    private String lastname;
    private String firstname;
    private String SSN;
    private String Phone;
    private String address;
    private String email;
    private String Date;
    private String City;



    public employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }




    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }




    public String toString(int h) {
        return " " +h;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getHours() {
        return Date;
    }

    public void setHours( String hours) {
        this.Date = hours;
    }

    public employee(String first, String last, String mail, String phonenumber, String address1, String h, String SSN) {
        this.firstname = first;
        this.lastname = last;
        this.Phone = phonenumber;
        this.address = address1;
        this.email = mail;
        this.Date = h;
        this.SSN = SSN;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
