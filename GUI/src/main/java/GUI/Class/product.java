package GUI.Class;

public class product {
    private int productnumber;
    private String productname;
    private String des;
    private String amount;

    public int getProductnumber() {
        return productnumber;
    }

    public void setProductnumber(int productnumber) {
        this.productnumber = productnumber;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public product(int id,String n, String d, String a){
        this.productnumber=id;
        this.productname=n;
        this.des =d;
        this.amount =a;
    }
}
