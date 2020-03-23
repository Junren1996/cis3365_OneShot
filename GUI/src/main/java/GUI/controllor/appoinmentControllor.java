package GUI.controllor;

import GUI.Class.appoinment;
import GUI.Class.customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class appoinmentControllor {

    private StackPane mainContainer;
    //tableview elements
    @FXML
    public TableView<appoinment> tableview;
    @FXML
    private TableColumn<appoinment, String> col1;
    @FXML
    private TableColumn<appoinment, String> col2;
    @FXML
    private TableColumn<appoinment, String> col3;
    @FXML
    private TableColumn<appoinment, String> col4;
    @FXML
    private TableColumn<appoinment, String> col5;


    public void initialize(URL url, ResourceBundle rb) {
        //set up tableview
        col1.setCellValueFactory(new PropertyValueFactory<appoinment, String>("firstname"));
        col2.setCellValueFactory(new PropertyValueFactory<appoinment, String>("lastname"));
        col3.setCellValueFactory(new PropertyValueFactory<appoinment, String>("Phone"));
        col4.setCellValueFactory(new PropertyValueFactory<appoinment, String>("address"));
        col5.setCellValueFactory(new PropertyValueFactory<appoinment, String>("email"));
      //  tableview.setItems(originalPatient());
        // updata tableview
    //    tableview.setEditable(true);
        col1.setCellFactory(TextFieldTableCell.forTableColumn());
        col2.setCellFactory(TextFieldTableCell.forTableColumn());
        col3.setCellFactory(TextFieldTableCell.forTableColumn());
        col4.setCellFactory(TextFieldTableCell.forTableColumn());
        col5.setCellFactory(TextFieldTableCell.forTableColumn());
        // select mutiple rows once
        tableview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }

    /*public void changefirstname(TableColumn.CellEditEvent editt) {
        appoinment selectPatient = tableview.getSelectionModel().getSelectedItem();
        selectPatient.setFirstname(editt.getNewValue().toString());
    }

    public void changelastname(TableColumn.CellEditEvent editt) {
        customer selectPatient = tableview.getSelectionModel().getSelectedItem();
        selectPatient.setLastname(editt.getNewValue().toString());
    }*/


       /* public void NewPatientButten(ActionEvent event) {

            customer newpatient = new customer(fName.getText(), lName.getText(), email.getText(), PhoneNumber.getText(), address.getText());
            tableview.getItems().addAll(newpatient);

        }*/

    public void deleteButton() {
        ObservableList<appoinment> selectRow;
        //select items
        selectRow = tableview.getSelectionModel().getSelectedItems();

        for (appoinment appoinment : selectRow) {
            tableview.getItems().remove(appoinment);
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
