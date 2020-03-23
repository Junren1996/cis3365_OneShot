package GUI.Class;

public class service {
    private String number;
    private String Des;
    private String price;

    public service() {
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDes() {
        return Des;
    }

    public void setDes(String des) {
        Des = des;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public service(String n, String d, String p) {
        this.number = n;
        this.Des = d;
        this.price = p;

    }
}
