package GUI.controllor;

import GUI.Class.customer;
import GUI.Class.membership;
import GUI.Class.product;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MembershipControllor implements Initializable {
    private static final String DELETE_MESSAGE = "Are you sure you want to move this?";

    public TableView<customer> customerTableView;
    public TableColumn<customer,String> col1 = new TableColumn<>();

    public TableView<membership> memberTableView;
    public TableColumn<membership,String> col2 = new TableColumn<>();





    public void movetoProduct(MouseEvent mouseEvent) {
        Dragboard dragboard = customerTableView.startDragAndDrop((TransferMode.COPY_OR_MOVE));
        ClipboardContent clipboardContent = new ClipboardContent();
        dragboard.setContent(clipboardContent);
        mouseEvent.consume();

    }

    public void dragOver(DragEvent dragEvent){
        Dragboard dragboard = dragEvent.getDragboard();
        if(dragboard.hasContent(DataFormat.PLAIN_TEXT)){
            dragEvent.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }

    }

    public void dragtoTarget(DragEvent dragEvent){
        Dragboard dragboard = dragEvent.getDragboard();
        boolean dragComplete = false;
        if(dragboard.hasContent(DataFormat.PLAIN_TEXT)){
            customer job1 = customerTableView.getSelectionModel().getSelectedItem();


            customerTableView.refresh();
            dragComplete = true;
        }
        dragEvent.setDropCompleted(dragComplete);
        dragEvent.consume();
    }



    public void initialize(URL url, ResourceBundle resourceBundle){
        col1.setCellValueFactory(new PropertyValueFactory<customer,String>("Name1"));
        col2.setCellValueFactory(new PropertyValueFactory<membership, String>("Name"));

        col1.setCellFactory(TextFieldTableCell.forTableColumn());
        col2.setCellFactory(TextFieldTableCell.forTableColumn());
        ObservableList<customer> person = FXCollections.observableArrayList();
        person.add(new customer("Chris", "KKK", "89586", "32482", "1881fountail"));
        customerTableView.getItems().addAll(person);
    }




}
