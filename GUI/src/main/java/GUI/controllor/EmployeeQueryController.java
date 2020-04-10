package GUI.controllor;

import GUI.Class.FreqEmployees;
import GUI.Class.busyweek;
import GUI.Class.license;
import GUI.Class.popularEmployee;
import GUI.DBconnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeQueryController implements Initializable {
    @FXML
    public TableView<popularEmployee> PopEmpTableview;
    @FXML
    public TableView<popularEmployee> PopEmpTableview2;
    @FXML
    public TableView<FreqEmployees> FreEmpTableview;
    @FXML
    public TableView<FreqEmployees> FreEmpTableview2;
    @FXML
    public TableView<license> licenseTableView;
    @FXML
    private TableColumn<?,?> col1;
    @FXML
    private TableColumn<?,?> col2;
    @FXML
    private TableColumn<?,?> col3;
    @FXML
    private TableColumn<?,?> col4;
    @FXML
    private TableColumn<?,?> col5;
    @FXML
    private TableColumn<?,?> col6;
    @FXML
    private TableColumn<?,?> col7;
    @FXML
    private TableColumn<?,?> col8;
    @FXML
    private TableColumn<?,?> col9;
    @FXML
    private TableColumn<?,?> col10;
    @FXML
    private TableColumn<?,?> col11;
    @FXML
    private TableColumn<?,?> col12;
    @FXML
    private TableColumn<?,?> col13;
    @FXML
    private TableColumn<?,?> col14;
    @FXML
    private TableColumn<?,?> col15;
    @FXML
    private TableColumn<?,?> col16;
    @FXML
    private TableColumn<?,?> col17;
    @FXML
    private TableColumn<?,?> col18;
    @FXML
    private TableColumn<?,?> col19;
    @FXML
    private TableColumn<?,?> col20;
    @FXML
    private TableColumn<?,?> col21;
    @FXML
    private TableColumn<?,?> col22;




    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs= null;
    private ObservableList<popularEmployee> data;
    private ObservableList<popularEmployee> data2;
    private ObservableList<FreqEmployees> data3;
    private ObservableList<FreqEmployees> data4;
    private ObservableList<license> data5;

    public void initialize(URL url, ResourceBundle rb) {
        firstfunction();
        con = GUI.DBconnection.dConnection();
        data = FXCollections.observableArrayList();
        data2 = FXCollections.observableArrayList();
        data3 = FXCollections.observableArrayList();
        data4 = FXCollections.observableArrayList();
        data5 = FXCollections.observableArrayList();
        loadData();
        loadData2();
        loadData3();
        loadData4();
        loadData5();

    }




    public void firstfunction() {
        //table1
        col1.setCellValueFactory(new PropertyValueFactory<>("month"));
        col2.setCellValueFactory(new PropertyValueFactory<>("employee"));
        col3.setCellValueFactory(new PropertyValueFactory<>("appointment"));
        col4.setCellValueFactory(new PropertyValueFactory<>("guest"));
        col5.setCellValueFactory(new PropertyValueFactory<>("location"));
        //table2
        col6.setCellValueFactory(new PropertyValueFactory<>("month"));
        col7.setCellValueFactory(new PropertyValueFactory<>("employee"));
        col8.setCellValueFactory(new PropertyValueFactory<>("appointment"));
        col9.setCellValueFactory(new PropertyValueFactory<>("guest"));
        col10.setCellValueFactory(new PropertyValueFactory<>("location"));
        //table3
        col11.setCellValueFactory(new PropertyValueFactory<>("month"));
        col12.setCellValueFactory(new PropertyValueFactory<>("Employee"));
        col13.setCellValueFactory(new PropertyValueFactory<>("days_work"));
        col14.setCellValueFactory(new PropertyValueFactory<>("shift_work"));
        col15.setCellValueFactory(new PropertyValueFactory<>("hours_work"));
        //table4
        col16.setCellValueFactory(new PropertyValueFactory<>("week"));
        col17.setCellValueFactory(new PropertyValueFactory<>("Employee"));
        col18.setCellValueFactory(new PropertyValueFactory<>("days_work"));
        col19.setCellValueFactory(new PropertyValueFactory<>("shift_work"));
        col20.setCellValueFactory(new PropertyValueFactory<>("hours_work"));
        //table5
        col21.setCellValueFactory(new PropertyValueFactory<>("employee"));
        col22.setCellValueFactory(new PropertyValueFactory<>("expire"));
    }

    public void loadData(){
        try {
            pst = con.prepareStatement("SELECT TOP 1\n" +
                    "MONTH(W.Week_Start) AS 'Month Number',\n" +
                    "CONCAT(E.Emp_Firstname, ' ', E.Emp_Lastname) AS 'Bottom Employee',\n" +
                    "COUNT(A.Appt_Num) AS 'Number of Appointments',\n" +
                    "COUNT(A.Cust_Num) AS 'Number of Guests',\n" +
                    "L.Loc_Street AS Location\n" +
                    "\n" +
                    "\n" +
                    "FROM Appointment A\n" +
                    "\n" +
                    "INNER JOIN Employee E ON A.Emp_Num = E.Emp_Num\n" +
                    "INNER JOIN Location L ON L.Loc_Num = A.Loc_Num\n" +
                    "INNER JOIN Week_Day D ON A.Appt_Date = D.Day_Date\n" +
                    "JOIN Work_Week W ON W.Week_Num = D.Week_Num\n" +
                    "\n" +
                    "WHERE A.Loc_Num = 2 \n" +
                    "AND W.Week_Start >= '2/1/2020' \n" +
                    "AND W.Week_End <= '2/29/2020'\n" +
                    "\n" +
                    "GROUP BY L.Loc_Street, E.Emp_Firstname, E.Emp_Lastname, W.Week_Start, W.Week_End\n" +
                    "\n" +
                    "ORDER BY COUNT(A.Appt_Num) ASC;");
            rs = pst.executeQuery();
            while(rs.next()){
                data.add(new popularEmployee(""+rs.getString(1),rs.getString(2),
                        ""+rs.getString(3),""+rs.getString(4),rs.getString(5)));

            }

        } catch (SQLException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        PopEmpTableview.setItems(data);

    }

    public void loadData2(){

        try {
            pst = con.prepareStatement("SELECT TOP 1\n" +
                    "MONTH(W.Week_Start) AS 'Month Number',\n" +
                    "CONCAT(E.Emp_Firstname, ' ', E.Emp_Lastname) AS 'Top Employee',\n" +
                    "COUNT(A.Appt_Num) AS 'Number of Appointments',\n" +
                    "COUNT(A.Cust_Num) AS 'Number of Guests',\n" +
                    "L.Loc_Street AS Location\n" +
                    "\n" +
                    "\n" +
                    "FROM Appointment A\n" +
                    "\n" +
                    "INNER JOIN Employee E ON A.Emp_Num = E.Emp_Num\n" +
                    "INNER JOIN Location L ON L.Loc_Num = A.Loc_Num\n" +
                    "INNER JOIN Week_Day D ON A.Appt_Date = D.Day_Date\n" +
                    "JOIN Work_Week W ON W.Week_Num = D.Week_Num\n" +
                    "\n" +
                    "WHERE A.Loc_Num = 1\n" +
                    "AND W.Week_Start >= '10/1/2019' \n" +
                    "AND W.Week_End <= '10/31/2019'\n" +
                    "\n" +
                    "GROUP BY L.Loc_Street, E.Emp_Firstname, E.Emp_Lastname, W.Week_Start, W.Week_End\n" +
                    "\n" +
                    "ORDER BY COUNT(A.Appt_Num) DESC;");
            rs = pst.executeQuery();
            while(rs.next()){
                data2.add(new popularEmployee(""+rs.getString(1),rs.getString(2),
                        ""+rs.getString(3),""+rs.getString(4),rs.getString(5)));

            }

        } catch (SQLException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        PopEmpTableview2.setItems(data2);
    }
    public void loadData3() {
        try {
            pst = con.prepareStatement("SELECT\n" +
                    "MONTH(Work_Week.Week_End) AS 'Month',\n" +
                    "CONCAT(Employee.Emp_Firstname, ' ', Employee.Emp_Lastname) AS 'Employee', \n" +
                    "COUNT(Emp_Schedule.Day_Date) AS 'Days Worked', \n" +
                    "COUNT(Emp_Schedule.Emp_Hours) AS 'Shifts Worked',  \n" +
                    "SUM(Emp_Schedule.Emp_Hours) AS 'Hours Worked'\n" +
                    "\n" +
                    "FROM Employee\n" +
                    "FULL OUTER JOIN Emp_Schedule ON Employee.Emp_Num = Emp_Schedule.Emp_Num\n" +
                    "LEFT OUTER JOIN Week_Day ON Emp_Schedule.Day_Date = Week_Day.Day_Date\n" +
                    "JOIN Work_Week ON Week_Day.Week_Num = Work_Week.Week_Num\n" +
                    "\n" +
                    "\n" +
                    "WHERE Week_End >= '10/1/2019'\n" +
                    "AND Week_End <= '10/31/2019'\n" +
                    "\n" +
                    "GROUP BY Week_End, Employee.Emp_Firstname, Employee.Emp_Lastname\n" +
                    "\n" +
                    "ORDER BY SUM(Emp_Schedule.Emp_Hours) DESC;");
            rs = pst.executeQuery();
            while(rs.next()){
                data3.add(new FreqEmployees(""+rs.getString(1),rs.getString(2),
                        ""+rs.getString(3),""+rs.getString(4),""+rs.getString(5)));

            }

        } catch (SQLException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        FreEmpTableview.setItems(data3);
    }
    public void loadData4() {
        try {
            pst = con.prepareStatement("SELECT TOP 3\n" +
                    "CONCAT(Employee.Emp_Firstname, ' ', Employee.Emp_Lastname) AS 'Employee', \n" +
                    " \n" +
                    "COUNT(Emp_Schedule.Day_Date) AS 'Days Worked', \n" +
                    "COUNT(Emp_Schedule.Emp_Hours) AS 'Shifts Worked',  \n" +
                    "SUM(Emp_Schedule.Emp_Hours) AS 'Hours Worked', \n" +
                    "FORMAT(Work_Week.Week_End, 'MM/dd/yyyy') AS 'Week Ending'\n" +
                    "\n" +
                    "FROM Employee\n" +
                    "FULL OUTER JOIN Emp_Schedule ON Employee.Emp_Num = Emp_Schedule.Emp_Num\n" +
                    "LEFT OUTER JOIN Week_Day ON Emp_Schedule.Day_Date = Week_Day.Day_Date\n" +
                    "JOIN Work_Week ON Week_Day.Week_Num = Work_Week.Week_Num\n" +
                    "\n" +
                    "WHERE Work_Week.Week_Num = 60\n" +
                    "\n" +
                    "GROUP BY Week_End, Employee.Emp_Firstname, Employee.Emp_Lastname\n" +
                    "\n" +
                    "ORDER BY SUM(Emp_Schedule.Emp_Hours) ASC;");
            rs = pst.executeQuery();
            while(rs.next()){
                data4.add(new FreqEmployees("0",rs.getString(1),""+rs.getString(2),
                        ""+rs.getString(3),""+rs.getString(4),rs.getString(5)));

            }

        } catch (SQLException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        FreEmpTableview2.setItems(data4);
    }
    public void loadData5() {
        try {
            pst = con.prepareStatement("\n" +
                    "SELECT \n" +
                    "CONCAT(Employee.Emp_Firstname, ' ', Employee.Emp_Lastname) AS Employee,\n" +
                    "FORMAT(Emp_License.Lic_Expire, 'MM/dd/yyyy') AS 'License Expires'\n" +
                    "\n" +
                    "FROM Employee\n" +
                    "LEFT JOIN Emp_License ON Emp_License.Emp_Num = Employee.Emp_Num\n" +
                    "LEFT JOIN License ON License.License_Num = Emp_License.Lic_Num\n" +
                    "\n" +
                    "WHERE Emp_License.Lic_Expire <= DATEADD(dd, 30, GETDATE());");
            rs = pst.executeQuery();
            while(rs.next()){
                data5.add(new license(rs.getString(1),rs.getString(2)));

            }

        } catch (SQLException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        licenseTableView.setItems(data5);
    }
}
