package GUI.controllor;

import GUI.Class.appoinment;
import GUI.Class.customer;
import GUI.Class.employee;
import GUI.DBconnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class appoinmentControllor  implements Initializable{

    private StackPane mainContainer;
    //tableview elements
    @FXML
    public TableView<appoinment> Appoinmenttableview;
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

    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs= null;
    private ObservableList<appoinment> data;



    public void initialize(URL url, ResourceBundle rb) {
        firstfunction();
        con=GUI.DBconnection.dConnection();
        data = FXCollections.observableArrayList();
        loaddata();


    }
    public void loaddata(){
        data.clear();

        try {
            pst = con.prepareStatement("SELECT \n" +
                    "A.Appt_Num AS 'Appoinment',\n" +
                    "CONCAT(Customer.Cust_FirstName, ' ', Customer.Cust_LastName) AS Customer,\n" +
                    "Service.Svc_Desc AS Service,\n" +
                    "/*CONCAT(E.Emp_Firstname, ' ', E.Emp_Lastname) AS Employee,\n" +
                    "Location.Loc_Street AS Location,*/\n" +
                    "CONVERT(VARCHAR, Time_Slot.Slot_Start, 100) AS 'Time',\n" +
                    "FORMAT(A.Appt_Date, 'MM/dd/yyyy') AS 'Date'\n" +
                    "\n" +
                    "\n" +
                    "FROM Customer\n" +
                    " JOIN Appointment A ON A.Cust_Num = Customer.Cust_Num\n" +
                    "LEFT JOIN Location ON Location.Loc_Num = A.Loc_Num\n" +
                    "LEFT JOIN Employee E ON E.Emp_Num = A.Emp_Num\n" +
                    "LEFT JOIN Appt_Svc S ON A.Appt_Num = S.Appt_Num\n" +
                    "LEFT JOIN Service ON S.Svc_Num = Service.Svc_Num\n" +
                    "LEFT JOIN Appt_Time T ON A.Appt_Num = T.Appt_Num\n" +
                    "LEFT JOIN Time_Slot ON T.Slot_Num = Time_Slot.Slot_Num\n" +
                    "\n" +
                    "Order by A.Appt_Date, T.Slot_Num;");

            rs = pst.executeQuery();

            while(rs.next()){

                data.add(new appoinment("" + rs.getString(1), rs.getString(2), "" + rs.getString(3), rs.getString(4),rs.getString(5)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        Appoinmenttableview.setItems(data);


    }

    public void firstfunction(){
        //set up tableview
        col1.setCellValueFactory(new PropertyValueFactory<>("appnumber"));
        col2.setCellValueFactory(new PropertyValueFactory<>("name"));
        col3.setCellValueFactory(new PropertyValueFactory<>("service"));
        col4.setCellValueFactory(new PropertyValueFactory<>("time"));
        col5.setCellValueFactory(new PropertyValueFactory<>("Date"));

    }



    public void deleteButton() {
        ObservableList<appoinment> selectRow;
        //select items
        selectRow = Appoinmenttableview.getSelectionModel().getSelectedItems();

        for (appoinment appoinment : selectRow) {
            Appoinmenttableview.getItems().remove(appoinment);
        }
    }

    public void newappoinmentbutt(ActionEvent event) throws IOException {
        //create new scene

        Parent NewScene = FXMLLoader.load(getClass().getResource("/fxml/EnterClientID.fxml"));
        Scene NewPatient = new Scene(NewScene);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //window.getStylesheets().add(style.css);
        window.setScene(NewPatient);
        window.show();

    }

    public void newappoinmentbutt2(ActionEvent event) throws IOException {
        //create new scene

        Parent NewScene = FXMLLoader.load(getClass().getResource("/fxml/employee12.fxml"));
        Scene NewPatient = new Scene(NewScene);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //window.getStylesheets().add(style.css);
        window.setScene(NewPatient);
        window.show();

    }




    //return value to tableview
   /* public ObservableList<customer> originalPatient() {
        String str = "2015-03-15";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateTime = LocalDate.parse(str, formatter);
        ObservableList<customer> person = FXCollections.observableArrayList();
        person.add(new customer("Chris", "KKK", "89586", "32482", "1881fountail"));

        return person;

    }*/

    public void appoinment() throws Exception {
        switchView("appoinment.fxml");
    }
    public void client(ActionEvent event) throws Exception {
        Parent NewScene = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
        Scene NewPatient = new Scene(NewScene);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //window.getStylesheets().add(style.css);
        window.setScene(NewPatient);
        window.show();
    }
    public void employee() throws Exception {
        switchView("employee.fxml");
    }
    public void employee1() throws Exception {
        switchView("employee1.fxml");
    }
    public void inventory() throws Exception {
        switchView("invemtory.fxml");
    }
    public void inventory1() throws Exception {
        switchView("inventory1.fxml");
    }
    public void membership() throws Exception {
        switchView("membership.fxml");
    }
    public void other() throws Exception {
        switchView("other.fxml");
    }
    public void service() throws Exception {
        switchView("service.fxml");
    }
    public void service1() throws Exception {
        switchView("/fxml/service1.fxml");
    }

    private void switchView(String fileName) throws Exception {

        mainContainer.getChildren().clear();
        AnchorPane anchorPane = new FXMLLoader(getClass().getResource("/fxml/" + fileName)).load();
        mainContainer.getChildren().add(anchorPane);
    }
}
