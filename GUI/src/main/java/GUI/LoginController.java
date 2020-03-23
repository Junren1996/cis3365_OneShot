package GUI;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    private TextField accountField;
    @FXML
    private PasswordField passwordField;


    public void login(ActionEvent event) throws Exception {

        String account = accountField.getText().trim();
        String password = passwordField.getText().trim();
        //调用登录功能

           // if ( password == "we") {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Message");
                alert.setContentText("Login Successful!");
                alert.showAndWait();
                //创建主界面舞台
        Stage mainStage = new Stage();
        //读入布局
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"));
        BorderPane root = fxmlLoader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/css/style.css");
        mainStage.setTitle("Sakura Manage system");
        mainStage.setMaximized(true);
        mainStage.setScene(scene);
        mainStage.getIcons().add(new Image("/img/logo.png"));
        mainStage.show();

                Stage loginStage = (Stage) accountField.getScene().getWindow();
                loginStage.close();

          /*  } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Message");
                alert.setContentText("Login Fail!");
                alert.showAndWait();
            }*/
        }
    }
