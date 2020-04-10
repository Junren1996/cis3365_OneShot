package GUI.Class;

public class FreqEmployees {
    private
    String month, Employee, days_work, shift_work, hours_work, week;

    public FreqEmployees(String m, String e, String d, String sw, String hw){
        this.month = m;
        this.Employee =e;
        this.days_work =d;
        this.shift_work = sw;
        this.hours_work = hw;
    }
    public FreqEmployees(String m, String e, String d, String sw, String hw, String w){
        this.month = m;
        this.Employee =e;
        this.days_work =d;
        this.shift_work = sw;
        this.hours_work = hw;
        this.week = w;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getEmployee() {
        return Employee;
    }

    public void setEmployee(String employee) {
        Employee = employee;
    }

    public String getDays_work() {
        return days_work;
    }

    public void setDays_work(String days_work) {
        this.days_work = days_work;
    }

    public String getShift_work() {
        return shift_work;
    }

    public void setShift_work(String shift_work) {
        this.shift_work = shift_work;
    }

    public String getHours_work() {
        return hours_work;
    }

    public void setHours_work(String hours_work) {
        this.hours_work = hours_work;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }
}
