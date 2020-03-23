package GUI.controllor;

import GUI.Class.customer;
import GUI.Class.employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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

public class employeeControllor implements Initializable{


    private StackPane mainContainer;
        //tableview elements
        @FXML
        public TableView<employee> tableview;
        @FXML
        private TableColumn<customer, String> col1;
        @FXML
        private TableColumn<customer, String> col2;
    @FXML
    private TableColumn<customer, String> col3;
    @FXML
    private TableColumn<customer, String> col4;
    @FXML
    private TableColumn<customer, String> col5;
    @FXML
    private TableColumn<customer, String> col6;
    @FXML
    private TableColumn<customer, String> col7;
        @FXML
        private TextField fName;
        @FXML
        private TextField lName;
        @FXML
        private TextField PhoneNumber;
        @FXML
        private TextField email;
        @FXML
        private TextField address;
    @FXML
    private TextField Hours;
    @FXML
    private TextField SSN;


        public void initialize(URL url, ResourceBundle rb) {
            //set up tableview
            col1.setCellValueFactory(new PropertyValueFactory<customer, String>("firstname"));
            col2.setCellValueFactory(new PropertyValueFactory<customer, String>("lastname"));
            col3.setCellValueFactory(new PropertyValueFactory<customer, String>("Phone"));
            col4.setCellValueFactory(new PropertyValueFactory<customer, String>("address"));
            col5.setCellValueFactory(new PropertyValueFactory<customer, String>("email"));
            col6.setCellValueFactory(new PropertyValueFactory<customer, String>("SSN"));
            col7.setCellValueFactory(new PropertyValueFactory<customer, String>("Hours"));
         //   tableview.setItems(originalPatient());
            // updata tableview
            tableview.setEditable(true);
            col1.setCellFactory(TextFieldTableCell.forTableColumn());
            col2.setCellFactory(TextFieldTableCell.forTableColumn());
            col3.setCellFactory(TextFieldTableCell.forTableColumn());
            col4.setCellFactory(TextFieldTableCell.forTableColumn());
            col5.setCellFactory(TextFieldTableCell.forTableColumn());
            col6.setCellFactory(TextFieldTableCell.forTableColumn());
            col7.setCellFactory(TextFieldTableCell.forTableColumn());
            // select mutiple rows once
            tableview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        }

        public void changefirstname(TableColumn.CellEditEvent editt) {
            employee selectPatient = tableview.getSelectionModel().getSelectedItem();
            selectPatient.setFirstname(editt.getNewValue().toString());
        }

        public void changelastname(TableColumn.CellEditEvent editt) {
            employee selectPatient = tableview.getSelectionModel().getSelectedItem();
            selectPatient.setLastname(editt.getNewValue().toString());
        }


        public void NewButten() {

                employee newpatient = new employee(fName.getText(), lName.getText(), email.getText(), PhoneNumber.getText(), address.getText(),Hours.getText(),SSN.getText());
                tableview.getItems().addAll(newpatient);


        }

        public void deleteButton() {
            ObservableList<employee> selectRow;
            //select items
            selectRow = tableview.getSelectionModel().getSelectedItems();

            for (employee employees : selectRow) {
                tableview.getItems().remove(employees);
            }
        }


        //return value to tableview
        public ObservableList<employee> originalPatient() {
            String str = "2015-03-15";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            ObservableList<employee> person = FXCollections.observableArrayList();
            person.add(new employee());

            return person;

        }

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
        switchView("service1.fxml");
    }

    private void switchView(String fileName) throws Exception {

        mainContainer.getChildren().clear();
        AnchorPane anchorPane = new FXMLLoader(getClass().getResource("/fxml/" + fileName)).load();
        mainContainer.getChildren().add(anchorPane);
    }
    }



