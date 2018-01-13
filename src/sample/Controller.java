package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import javax.swing.*;

public class Controller {

    @FXML
    private Text actiontarget;
    @FXML
    private Text secondActiontarget;

    @FXML protected void handleSubmitButtonAction(ActionEvent event) {
        actiontarget.setText("Casper is a fat fuck");
    }

    @FXML protected void removeText(ActionEvent event){
        secondActiontarget.setText("HAHA no way, you can't obscure the truth!");
    }
}
