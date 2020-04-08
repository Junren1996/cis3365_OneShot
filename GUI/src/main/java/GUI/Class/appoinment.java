package GUI.Class;

public class appoinment {
    private String appnumber;
    private String name;
    private String service;
    private String time;
    private String Date;


    public appoinment(String appnumber, String cn,String service,String time,String date){
        this.appnumber = appnumber;
        this.name = cn;
        this.service = service;
        this.time = time;
        this.Date =date;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }


    public String getAppnumber() {
        return appnumber;
    }

    public void setAppnumber(String appnumber) {
        this.appnumber = appnumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
