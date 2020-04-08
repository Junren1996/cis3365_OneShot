package GUI.controllor;

import GUI.Class.busyweek;
import GUI.Class.customer;
import GUI.Class.manyapp;
import GUI.DBconnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class appointmentQueryControllor implements Initializable {
    @FXML
    public TableView<busyweek> BusyWeektableview;
    @FXML
    public TableView<manyapp> manyapptableview;
    @FXML
    public TableView<guestonday> guestdayableview;
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
    private TextField search;
    @FXML
    private TableColumn<?,?> col6;
    @FXML
    private TableColumn<?,?> col7;
    @FXML
    private TableColumn<?,?> col8;

    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs= null;
    private ObservableList<busyweek> data;
    private ObservableList<manyapp> data2;
    private ObservableList<guestonday> data3;

    public void initialize(URL url, ResourceBundle rb) {
        firstfunction();
        con=GUI.DBconnection.dConnection();
        data = FXCollections.observableArrayList();
        data2 = FXCollections.observableArrayList();
        data3 = FXCollections.observableArrayList();
        loadDATA();
        loadDATA2();
        //loadDATA3();

    }

    public void firstfunction(){
        //set up tableview
        col1.setCellValueFactory(new PropertyValueFactory<>("week"));
        col2.setCellValueFactory(new PropertyValueFactory<>("bookings"));
        col3.setCellValueFactory(new PropertyValueFactory<>("month"));
        col4.setCellValueFactory(new PropertyValueFactory<>("location"));
        col5.setCellValueFactory(new PropertyValueFactory<>("appCount"));
        col6.setCellValueFactory(new PropertyValueFactory<>("appDay"));
        col7.setCellValueFactory(new PropertyValueFactory<>("Day"));
        col8.setCellValueFactory(new PropertyValueFactory<>("bookings"));



    }

    public void loadDATA(){
        try {
            pst = con.prepareStatement("SELECT TOP 1\n" +
                    "FORMAT(Work_Week.Week_End, 'MM/dd/yyyy') AS 'Week Ending',\n" +
                    "COUNT(DISTINCT Appointment.Appt_Num) AS 'Total Bookings'\n" +
                    "\n" +
                    "\n" +
                    "FROM Appointment\n" +
                    "LEFT JOIN Week_Day D ON Appointment.Appt_Date = D.Day_Date\n" +
                    "LEFT JOIN Work_Week ON D.Week_Num = Work_Week.Week_Num\n" +
                    "\n" +
                    "WHERE Week_Start >= '10/1/2019' AND Week_End <= '10/31/2019'\n" +
                    "\n" +
                    "GROUP BY Work_Week.Week_End\n" +
                    "\n" +
                    "ORDER BY 'Total Bookings' DESC;");
            rs = pst.executeQuery();
            while(rs.next()){
                data.add(new busyweek(rs.getString(1),""+rs.getString(2)));

            }

        } catch (SQLException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        BusyWeektableview.setItems(data);
    }
    public void loadDATA2(){
        try {
            pst = con.prepareStatement("SELECT \n" +
                    "MONTH(Work_Week.Week_Start) AS 'Month',\n" +
                    "CONCAT(Location.Loc_Street, ', ', Zip.Zip_City) AS 'Location',\n" +
                    "COUNT(Appointment.Appt_Num) AS 'Appointment Count'\n" +
                    "\n" +
                    "\n" +
                    "From Location\n" +
                    "INNER JOIN Appointment ON Location.Loc_Num = Appointment.Loc_Num\n" +
                    "INNER JOIN Week_Day D ON D.Day_Date = Appointment.Appt_Date\n" +
                    "JOIN Work_Week ON Work_Week.Week_Num = D.Week_Num\n" +
                    "JOIN Zip ON Location.Loc_Zip = Zip.Zip_Code\n" +
                    "\n" +
                    "WHERE Work_Week.Week_End >= '10/1/2019'\n" +
                    "AND Work_Week.Week_End <= '10/31/2019'\n" +
                    "\n" +
                    "GROUP BY Location.Loc_Street, Zip.Zip_City, MONTH(Work_Week.Week_Start);");
            rs = pst.executeQuery();
            while(rs.next()){
                data2.add(new manyapp(""+rs.getString(1),rs.getString(2),""+rs.getString(3)));

            }

        } catch (SQLException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        manyapptableview.setItems(data2);
    }
    public void loadDATA3(){
        data3.clear();
        String dates = search.getText();
        try {
            pst = con.prepareStatement("SELECT \n" +
                    "FORMAT(Appointment.Appt_Date, 'MM/dd/yyyy') AS 'Appointment Date',\n" +
                    "WorkDay.Day_Name AS Day,\n" +
                    "COUNT(Appointment.Appt_Num) AS 'Total Bookings'\n" +
                    "\n" +
                    " \n" +
                    "FROM Appointment\n" +
                    "JOIN Week_Day ON Appointment.Appt_Date = Week_Day.Day_Date\n" +
                    "JOIN Workday ON Week_Day.Day_Num = Workday.Day_Num\n" +
                    " \n" +
                    "WHERE Appointment.Appt_Date = ? \n" +
                    "\n" +
                    "GROUP BY Workday.Day_Name, Appointment.Appt_Date;");
            pst.setString(1,dates);
            rs = pst.executeQuery();
            while(rs.next()){
                data3.add(new guestonday(rs.getString(1),rs.getString(2),""+rs.getString(3)));

            }

        } catch (SQLException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        guestdayableview.setItems(data3);
    }
}
