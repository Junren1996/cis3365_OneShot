package GUI.Class;

public class order {
    private int ordernumber;
    private int employeenumber;
    private int suppliernumber;
    private String date;
    private double price;

    public int getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(int ordernumber) {
        this.ordernumber = ordernumber;
    }

    public int getEmployeenumber() {
        return employeenumber;
    }

    public void setEmployeenumber(int employeenumber) {
        this.employeenumber = employeenumber;
    }

    public int getSuppliernumber() {
        return suppliernumber;
    }

    public void setSuppliernumber(int suppliernumber) {
        this.suppliernumber = suppliernumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
