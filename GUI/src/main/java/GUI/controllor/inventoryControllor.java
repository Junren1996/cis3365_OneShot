package GUI.controllor;

import GUI.Class.appoinment;
import GUI.Class.customer;
import GUI.Class.product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.scene.control.cell.ChoiceBoxTableCell.forTableColumn;

public class inventoryControllor {
    private StackPane mainContainer;
    private int n =1;
    @FXML
    public TableView<product> tableview;
    @FXML
    private TableColumn<product, Integer> col1;
    @FXML
    private TableColumn<product, String> col2;
    @FXML
    private TableColumn<product, String> col3;
    @FXML
    private TableColumn<product, String> col4;
    @FXML
    private TextField fName;
    @FXML
    private TextField Amount;
    @FXML
    private TextArea detail;

    public void initialize(URL url, ResourceBundle rb) {
        //set up tableview
        col1.setCellValueFactory(new PropertyValueFactory<product, Integer>("ID"));
        col2.setCellValueFactory(new PropertyValueFactory<product, String>("Name"));
        col3.setCellValueFactory(new PropertyValueFactory<product, String>("Amount"));
        col4.setCellValueFactory(new PropertyValueFactory<product, String>("Des"));

          tableview.setItems(originalPatient());
        // updata tableview
            tableview.setEditable(true);
        col1.setCellFactory(forTableColumn());
        col2.setCellFactory(TextFieldTableCell.forTableColumn());
        col3.setCellFactory(TextFieldTableCell.forTableColumn());
        col4.setCellFactory(TextFieldTableCell.forTableColumn());

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


       public void NewButten(ActionEvent event) {

            product newproduct= new product(n,fName.getText(), Amount.getText(),detail.getText());

            tableview.getItems().addAll(newproduct);

        }

    public void deleteButton() {
        ObservableList<product> selectRow;
        //select items
        selectRow = tableview.getSelectionModel().getSelectedItems();

        for (product product : selectRow) {
            tableview.getItems().remove(product);
        }
    }



   /* public void newappoinmentbutt2(ActionEvent event) throws IOException {
        //create new scene

        Parent NewScene = FXMLLoader.load(getClass().getResource("/fxml/employee12.fxml"));
        Scene NewPatient = new Scene(NewScene);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //window.getStylesheets().add(style.css);
        window.setScene(NewPatient);
        window.show();

    }*/




    //return value to tableview
   public ObservableList<product> originalPatient() {
        String str = "2015-03-15";
        /*DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateTime = LocalDate.parse(str, formatter);*/
        ObservableList<product> person = FXCollections.observableArrayList();
        person.add(new product(n,"Dior", "89586", "32482"));
        n = n+1;

        return person;

    }

    public void appoinment(ActionEvent event) throws Exception {
        Parent NewScene = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
        Scene NewPatient = new Scene(NewScene);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //window.getStylesheets().add(style.css);
        window.setScene(NewPatient);
        window.show();
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



