package GUI.controllor;

import GUI.Class.appoinment;
import GUI.Class.customer;
import GUI.Class.employee;
import GUI.Class.product;
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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import static javafx.scene.control.cell.ChoiceBoxTableCell.forTableColumn;

public class inventoryControllor implements Initializable {
    private StackPane mainContainer;

    @FXML
    public TableView<product> tableview;

    @FXML
    private TableColumn<?,?> col2;
    @FXML
    private TableColumn<?,?> col3;
    @FXML
    private TableColumn<?,?> col4;
    @FXML
    private TextField fName;
    @FXML
    private TextField Amount;
    @FXML
    private TextArea detail;
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs= null;
    private ObservableList<product> data;


    public void initialize(URL url, ResourceBundle rb) {
        //set up tableview
        firstfunction();
        con=GUI.DBconnection.dConnection();
        data = FXCollections.observableArrayList();
        loaddata();

    }

    public void firstfunction(){
        col2.setCellValueFactory(new PropertyValueFactory<>("productname"));
        col3.setCellValueFactory(new PropertyValueFactory<>("amount"));
        col4.setCellValueFactory(new PropertyValueFactory<>("des"));
    }

    public void loaddata(){
        data.clear();
        try {
            pst = con.prepareStatement("SELECT * FROM dbo.Product");
            rs = pst.executeQuery();
            while(rs.next()){
                data.add(new product(rs.getString(2),rs.getString(3),""+rs.getInt(4)));

            }

        } catch (SQLException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        tableview.setItems(data);

    }


       public void NewButten() {
           String sql = "Insert into dbo.Product(Prod_Name,Prod_Description, Prod_QOH) Values(?,?,?)";
           String name = fName.getText();
           String dt = detail.getText();
           int qoh = Integer.valueOf(Amount.getText());


           try {
               pst = con.prepareStatement(sql);
               pst.setString(1, name);
               pst.setString(2, dt);
               pst.setInt(3,qoh);

               int i = pst.executeUpdate();
               if (i == 1) {
                   System.out.print("Successful");
                   loaddata();
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }

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



