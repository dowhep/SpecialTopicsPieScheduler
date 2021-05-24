package io.github.dowhep.Controllers;

import java.io.IOException;

import io.github.dowhep.App;
import io.github.dowhep.AbstractClasses.PieSlice;
import io.github.dowhep.HelperClasses.Data;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PieSliceController {

    @FXML
    private TextField eventNameText;

    @FXML
    private TextField fromTimeText;

    @FXML
    private TextField toTimeText;

    @FXML
    private TextArea eventDetailsText;

    @FXML
    private Button cancelButton;

    @FXML
    private Button enterButton;

    @FXML
    void cancel(ActionEvent event) {
    }

    @FXML
    void enter(ActionEvent event) throws IOException {
        PieSlice newSlice = new PieSlice(eventNameText.getText(), eventDetailsText.getText());
        Data.getInstance().getPie().getPieSlices().add(newSlice);
        App.setRoot("piePage");
    }
}
