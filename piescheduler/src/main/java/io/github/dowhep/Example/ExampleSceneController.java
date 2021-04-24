package io.github.dowhep.Example;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ExampleSceneController {

    @FXML
    private Label exampleTxt;

    @FXML
    private Button exampleBtn;

    /**
     * This is called on button click
     * @param event the event
     */
    @FXML
    void onExampleBtnClick(ActionEvent event) {
        exampleTxt.setText(exampleTxt.getText() + "!");
    }

}
