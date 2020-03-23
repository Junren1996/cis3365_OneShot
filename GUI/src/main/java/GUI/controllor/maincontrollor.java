package GUI.controllor;

import GUI.Class.customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class maincontrollor implements Initializable{






    private StackPane mainContainer;
        //tableview elements
        @FXML
        public TableView<customer> tableview;
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
       /* @FXML
        private TextField fName;
        @FXML
        private TextField lName;
        @FXML
        private TextField PhoneNumber;
        @FXML
        private TextField email;
        @FXML
        private TextArea address;*/
        //pop
        private VBox vbox = new VBox();
        //  @FXML private JFXPopup popwindow = new JFXPopup();

        public void initialize(URL url, ResourceBundle rb) {
            //set up tableview
            col1.setCellValueFactory(new PropertyValueFactory<customer, String>("firstname"));
            col2.setCellValueFactory(new PropertyValueFactory<customer, String>("lastname"));
            col3.setCellValueFactory(new PropertyValueFactory<customer, String>("Phone"));
            col4.setCellValueFactory(new PropertyValueFactory<customer, String>("address"));
            col5.setCellValueFactory(new PropertyValueFactory<customer, String>("email"));
            tableview.setItems(originalPatient());
            // updata tableview
            tableview.setEditable(true);
            col1.setCellFactory(TextFieldTableCell.forTableColumn());
            col2.setCellFactory(TextFieldTableCell.forTableColumn());
            col3.setCellFactory(TextFieldTableCell.forTableColumn());
            col4.setCellFactory(TextFieldTableCell.forTableColumn());
            col5.setCellFactory(TextFieldTableCell.forTableColumn());
            // select mutiple rows once
            tableview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        }

        public void changefirstname(TableColumn.CellEditEvent editt) {
            customer selectPatient = tableview.getSelectionModel().getSelectedItem();
            selectPatient.setFirstname(editt.getNewValue().toString());
        }

        public void changelastname(TableColumn.CellEditEvent editt) {
            customer selectPatient = tableview.getSelectionModel().getSelectedItem();
            selectPatient.setLastname(editt.getNewValue().toString());
        }


       /* public void NewPatientButten(ActionEvent event) {

            customer newpatient = new customer(fName.getText(), lName.getText(), email.getText(), PhoneNumber.getText(), address.getText());
            tableview.getItems().addAll(newpatient);

        }*/

        public void deleteButton() {
            ObservableList<customer> selectRow;
            //select items
            selectRow = tableview.getSelectionModel().getSelectedItems();

            for (customer customer : selectRow) {
                tableview.getItems().remove(customer);
            }
        }

        public void newbutt(ActionEvent event) throws IOException {
            //create new scene

            Parent NewScene = FXMLLoader.load(getClass().getResource("/fxml/newclient.fxml"));
            Scene NewPatient = new Scene(NewScene);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            //window.getStylesheets().add(style.css);
            window.setScene(NewPatient);
            window.show();

        }

    public void newbutt2(ActionEvent event) throws IOException {
        //create new scene

        Parent NewScene = FXMLLoader.load(getClass().getResource("/fxml/appoinment.fxml"));
        Scene NewPatient = new Scene(NewScene);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //window.getStylesheets().add(style.css);
        window.setScene(NewPatient);
        window.show();

    }




        //return value to tableview
        public ObservableList<customer> originalPatient() {
            String str = "2015-03-15";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate dateTime = LocalDate.parse(str, formatter);
            ObservableList<customer> person = FXCollections.observableArrayList();
            person.add(new customer("Chris", "KKK", "89586", "32482", "1881fountail"));

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
    public void employee1(ActionEvent event) throws Exception {
        Parent NewScene = FXMLLoader.load(getClass().getResource("/fxml/employee1.fxml"));
        Scene NewPatient = new Scene(NewScene);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //window.getStylesheets().add(style.css);
        window.setScene(NewPatient);
        window.show();
    }
    public void inventory(ActionEvent event) throws Exception {
        Parent NewScene = FXMLLoader.load(getClass().getResource("/fxml/inventory.fxml"));
        Scene NewPatient = new Scene(NewScene);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //window.getStylesheets().add(style.css);
        window.setScene(NewPatient);
        window.show();
    }
    public void inventory1() throws Exception {
        switchView("inventory1.fxml");
    }
    public void membership(ActionEvent event) throws Exception {
        Parent NewScene = FXMLLoader.load(getClass().getResource("/fxml/membership.fxml"));
        Scene NewPatient = new Scene(NewScene);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //window.getStylesheets().add(style.css);
        window.setScene(NewPatient);
        window.show();
    }
    public void other() throws Exception {
        switchView("other.fxml");
    }
    public void service(ActionEvent event) throws Exception {
        Parent NewScene = FXMLLoader.load(getClass().getResource("/fxml/service.fxml"));
        Scene NewPatient = new Scene(NewScene);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //window.getStylesheets().add(style.css);
        window.setScene(NewPatient);
        window.show();
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



