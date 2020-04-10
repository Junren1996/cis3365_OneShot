package GUI.controllor;

import GUI.Class.customer;
import GUI.DBconnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class maincontrollor implements Initializable{



    private StackPane mainContainer;
        //tableview elements
        @FXML
        public TableView<customer> tableview;
        @FXML
        private TableColumn<?,?> col1;
        @FXML
        private TableColumn<?,?> col2;
    @FXML
    private TableColumn<?,?> col3;

    @FXML
    private TableColumn<?,?> col5;
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
       private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs= null;
    private ObservableList<customer> data;

        public void initialize(URL url, ResourceBundle rb) {
           firstfunction();
            con=GUI.DBconnection.dConnection();
            data = FXCollections.observableArrayList();
            loadDATA();


        }

        public void firstfunction(){
            //set up tableview
            col1.setCellValueFactory(new PropertyValueFactory<>("firstname"));
            col2.setCellValueFactory(new PropertyValueFactory<>("lastname"));
            col3.setCellValueFactory(new PropertyValueFactory<>("Phone"));
            col5.setCellValueFactory(new PropertyValueFactory<>("email"));

            // updata tableview
            tableview.setEditable(true);
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

        public void loadDATA(){

            try {
                pst = con.prepareStatement("SELECT * FROM dbo.Customer");
                rs = pst.executeQuery();
                while(rs.next()){
                    data.add(new customer(rs.getString(3),rs.getString(2),rs.getString(4),rs.getString(5)));

                }

            } catch (SQLException ex) {
                Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
            }
            tableview.setItems(data);


        }


   /* public void NewButten() {



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






    public void appoinment(ActionEvent event) throws Exception {
        Parent NewScene = FXMLLoader.load(getClass().getResource("/fxml/appoinment.fxml"));
        Scene NewPatient = new Scene(NewScene);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //window.getStylesheets().add(style.css);
        window.setScene(NewPatient);
        window.show();
    }
    public void appoinment2(ActionEvent event) throws Exception {
        Parent NewScene = FXMLLoader.load(getClass().getResource("/fxml/appointmentquery.fxml"));
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
    public void employee(ActionEvent event) throws Exception {
        Parent NewScene = FXMLLoader.load(getClass().getResource("/fxml/employeereport.fxml"));
        Scene NewPatient = new Scene(NewScene);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //window.getStylesheets().add(style.css);
        window.setScene(NewPatient);
        window.show();
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



