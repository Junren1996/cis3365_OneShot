package GUI.Class;

public class popularEmployee {
    private
    String month, employee, appointment, guest, location;

    public popularEmployee(String m , String e, String a, String g, String l){
        this.month = m;
        this.employee =e;
        this.appointment = a;
        this.guest = g;
        this.location = l;

    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getAppointment() {
        return appointment;
    }

    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }

    public String getGuest() {
        return guest;
    }

    public void setGuest(String guest) {
        this.guest = guest;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
