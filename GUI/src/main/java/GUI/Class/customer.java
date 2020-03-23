package GUI.Class;

import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class customer {
    private Long id;
    private String lastname;
    private String firstname;
    private String Phone;
    private String address;
    private String email;




    public customer() {
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



    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLasttname() {
        return lastname;
    }

    public void setLastname(String firstname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", Firstname='" + firstname + '\'' +
                ", Lastname='" + lastname + '\'' +
                ", Address='" + address + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Email='" + email + '\'' +

                '}';
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

    public customer(String first, String last, String mail, String phonenumber, String address1) {
        this.firstname = first;
        this.lastname = last;
        this.Phone = phonenumber;
        this.address = address1;
        this.email = mail;
    }


}
