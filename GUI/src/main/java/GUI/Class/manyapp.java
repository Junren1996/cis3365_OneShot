package GUI.Class;

public class manyapp {
    private String month, location, appCount;

    public manyapp(String m, String l , String ac){
        this.month = m;
        this.location = l;
        this.appCount = ac;
    }


    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAppCount() {
        return appCount;
    }

    public void setAppCount(String appCount) {
        this.appCount = appCount;
    }
}
