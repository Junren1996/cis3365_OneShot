package GUI.Class;

public class busyweek {
    private String week;
    private String bookings;

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getBookings() {
        return bookings;
    }

    public void setBookings(String bookings) {
        this.bookings = bookings;
    }

    public busyweek(String w, String b){
        this.week=w;
        this.bookings=b;
    }
}
