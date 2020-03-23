package GUI.Class;

public class membership {
    private int Membernumber;
    private int point;
    private String type;
    private String effectiveDate;


    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getMembernumber() {
        return Membernumber;
    }

    public void setMembernumber(int membernumber) {
        Membernumber = membernumber;
    }
}
