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
import javafx.scene.control.*;

import javafx.stage.Stage;

import java.io.IOException;

public class newclientControllor {
    @FXML
    private TextField fName;
    @FXML
    private TextField lName;
    @FXML
    private TextField PhoneNumber;
    @FXML
    private TextField email;
    @FXML
    private TextArea address;

    public void NewB(){

        customer newc = new customer(fName.getText(),lName.getText(),email.getText(),PhoneNumber.getText(),address.getText());
        maincontrollor m = new maincontrollor();
        m.tableview.getItems().addAll(newc);

    }
public void back(ActionEvent event) throws IOException {
    Parent NewScene = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
    Scene NewPatient = new Scene(NewScene);
    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    //window.getStylesheets().add(style.css);
    window.setScene(NewPatient);
    window.show();
}

}
