package GUI.validation;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FieldValidation {
    public static boolean isFieldNotEmpty(TextField tf){
        boolean b = false;
        if(tf.getText().length() != 0 || !tf.getText().isEmpty()){
            b =true;
        }
        return b;
    }
    public static boolean isFieldNotEmpty(TextField tf, Label lab, String wrongmessage){
        boolean b = true;
        String msg = null;
        if(!isFieldNotEmpty(tf)){
            b =false;
            msg = wrongmessage;
        }
        lab.setText(msg);
        return b;
    }

}
