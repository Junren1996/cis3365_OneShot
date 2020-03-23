package GUI.controllor;

import GUI.Class.customer;
import GUI.Class.employee;
import GUI.Class.service;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class serviceControllor {

    private StackPane mainContainer;
    //tableview elements
    @FXML
    public TableView<service> servicetableview;
    @FXML
    private TableColumn<service, String> col1;
    @FXML
    private TableColumn<service, String> col2;
    @FXML
    private TableColumn<service, String> col3;

    @FXML
    private TextField number;
    @FXML
    private TextField name;
    @FXML
    private TextField price;



    public void initialize(URL url, ResourceBundle rb) {
        //set up tableview
        col1.setCellValueFactory(new PropertyValueFactory<service, String>("number"));
        col2.setCellValueFactory(new PropertyValueFactory<service, String>("Des"));
        col3.setCellValueFactory(new PropertyValueFactory<service, String>("price"));

        // updata tableview
        servicetableview.setEditable(true);
        col1.setCellFactory(TextFieldTableCell.forTableColumn());
        col2.setCellFactory(TextFieldTableCell.forTableColumn());
        col3.setCellFactory(TextFieldTableCell.forTableColumn());
        // select mutiple rows once
        servicetableview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        servicetableview.setItems(originalPatient());
        servicetableview.setItems(originalPatient2());
        servicetableview.setItems(originalPatient3());
    }

    public void changefirstname(TableColumn.CellEditEvent editt) {
        service selectPatient = servicetableview.getSelectionModel().getSelectedItem();
        selectPatient.setNumber(editt.getNewValue().toString());
    }

    public void changelastname(TableColumn.CellEditEvent editt) {
        service selectPatient = servicetableview.getSelectionModel().getSelectedItem();
        selectPatient.setDes(editt.getNewValue().toString());
    }


    public void NewButten() {

        service newpatient = new service(number.getText(), name.getText(), price.getText());
        servicetableview.getItems().addAll(newpatient);


    }

    public void deleteButton() {
        ObservableList<service> selectRow;
        //select items
        selectRow = servicetableview.getSelectionModel().getSelectedItems();

        for (service services : selectRow) {
            servicetableview.getItems().remove(services);
        }
    }


    //return value to tableview
    public ObservableList<service> originalPatient() {


        ObservableList<service> person = FXCollections.observableArrayList();

        person.add(new service("001","LCN Classic Manicure","$16"));

        return person;

    }
    public ObservableList<service> originalPatient2() {


        ObservableList<service> person = FXCollections.observableArrayList();

        person.add(new service("002","OPI Classic Pedicure","$26"));

        return person;

    }
    public ObservableList<service> originalPatient3() {


        ObservableList<service> person = FXCollections.observableArrayList();

        person.add(new service("003","LCN red-wine pedicure","$46"));

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
