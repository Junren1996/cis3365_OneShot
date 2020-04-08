package GUI.controllor;

import GUI.Class.customer;
import GUI.Class.employee;
import GUI.DBconnection;
import GUI.validation.FieldValidation;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class employeeControllor implements Initializable{

    private StackPane mainContainer;
        @FXML
        public TableView<employee> tableview;
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
    private TextField dates;
    @FXML
    private TextField SSN;
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs= null;
    private ObservableList<employee> data;
    @FXML
    private Label error_fname;
    @FXML
    private Label error_lname;
    @FXML
    private Label error_phone;
    @FXML
    private Label error_address;
    @FXML
    private Label error_SSN;



        public void initialize(URL url, ResourceBundle rb) {
            firstfunction();
            con=GUI.DBconnection.dConnection();
            data = FXCollections.observableArrayList();
            loaddata();
            setCellValueWhileClieckTable();
        }

        public void firstfunction(){
            //set up tableview
            col1.setCellValueFactory(new PropertyValueFactory<>("firstname"));
            col2.setCellValueFactory(new PropertyValueFactory<>("lastname"));
            col3.setCellValueFactory(new PropertyValueFactory<>("Phone"));
            col4.setCellValueFactory(new PropertyValueFactory<>("address"));
            col5.setCellValueFactory(new PropertyValueFactory<>("email"));
            col6.setCellValueFactory(new PropertyValueFactory<>("SSN"));
            col7.setCellValueFactory(new PropertyValueFactory<>("Hours"));
            //   tableview.setItems(originalPatient());
            // updata tableview
            tableview.setEditable(true);

            tableview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        }

        public void loaddata(){
            data.clear();
            try {
                pst = con.prepareStatement("SELECT * FROM dbo.Employee");
                rs = pst.executeQuery();
                while(rs.next()){
                    data.add(new employee(rs.getString(3),rs.getString(2),"test@sakurasalon.com",rs.getString(6),rs.getString(7),rs.getString(4),rs.getString(5)));

                }

            } catch (SQLException ex) {
                Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
            }
            tableview.setItems(data);

        }



        public void NewButten( ) {
            boolean filedoneEmpty = FieldValidation.isFieldNotEmpty(fName, error_fname,"Required");
            boolean filedtwoEmpty = FieldValidation.isFieldNotEmpty(lName, error_lname,"Required");
            boolean filedthreeEmpty = FieldValidation.isFieldNotEmpty(PhoneNumber, error_phone,"Required");
            boolean filedfourEmpty = FieldValidation.isFieldNotEmpty(SSN, error_address,"Required");
            boolean filedfiveEmpty = FieldValidation.isFieldNotEmpty(SSN, error_SSN,"Required");


            if(filedfiveEmpty && filedfourEmpty && filedthreeEmpty && filedtwoEmpty && filedoneEmpty) {

                String sql = "Insert into dbo.Employee(Emp_Lastname,Emp_Firstname,Emp_HireDate,Emp_SSN,Emp_Phone,Emp_Street) Values(?,?,?,?,?,?)";
                String fname = fName.getText();
                String lname = lName.getText();
                String phonen = PhoneNumber.getText();
                String ssn = SSN.getText();
                String street = address.getText();
                String date = dates.getText();


                try {
                    pst = con.prepareStatement(sql);
                    pst.setString(1, lname);
                    pst.setString(2, fname);
                    pst.setString(3,date);
                    pst.setString(4, ssn);
                    pst.setString(5, phonen);
                    pst.setString(6, street);
                    int i = pst.executeUpdate();
                    if (i == 1) {
                        System.out.print("Successful");
                        loaddata();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }

        private void clearfield(){
            fName.clear();
            lName.clear();
            address.clear();
            SSN.clear();
            PhoneNumber.clear();
            email.clear();
            data.clear();
        }

        public void deleteButton() {
           String sql = "delete from dbo.Employee where Emp_SSN = ?";

            try {
                pst = con.prepareStatement(sql);
                pst.setString(1,SSN.getText());
                int i = pst.executeUpdate();
                if(i==1){
                    loaddata();
                    clearfield();

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }



        private void setCellValueWhileClieckTable(){
            tableview.setOnMouseClicked(e -> {
                employee em = tableview.getItems().get(tableview.getSelectionModel().getSelectedIndex());
                fName.setText(em.getFirstname());
                lName.setText(em.getLastname());
                PhoneNumber.setText(em.getPhone());
                dates.setText(em.getHours());
                SSN.setText(em.getSSN());
                address.setText(em.getAddress());
                email.setText(em.getEmail());
            });

        }

        public void updateData(){
            String sql = "Update dbo.Employee set Emp_Lastname = ?,Emp_Firstname = ?,Emp_HireDate = ?,Emp_Phone = ?,Emp_Street= ? where Emp_SSN = ?";
            try {
                pst = con.prepareStatement(sql);
                String fname = fName.getText();
                String lname = lName.getText();
                String phonen = PhoneNumber.getText();
                String ssn = SSN.getText();
                String street = address.getText();
                String date = dates.getText();

                pst.setString(1, lname);
                pst.setString(2, fname);
                pst.setString(3,date);
                pst.setString(4, phonen);
                pst.setString(5, street);
                pst.setString(6, ssn);

                int i = pst.executeUpdate();
                if(i==1){
                    loaddata();

                }
            } catch (SQLException e) {
                Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, e);
            }


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



