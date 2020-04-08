package GUI.controllor;

public class guestonday {
    private String appDay, Day, bookings;

    public guestonday(String a, String d, String b){
        this.appDay =a;
        this.Day =d;
        this.bookings=b;
    }

    public String getAppDay() {
        return appDay;
    }

    public void setAppDay(String appDay) {
        this.appDay = appDay;
    }

    public String getDay() {
        return Day;
    }

    public void setDay(String day) {
        Day = day;
    }

    public String getBookings() {
        return bookings;
    }

    public void setBookings(String bookings) {
        this.bookings = bookings;
    }
}
