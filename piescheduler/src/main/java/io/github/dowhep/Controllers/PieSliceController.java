package io.github.dowhep.Controllers;

import java.io.IOException;

import io.github.dowhep.App;
import io.github.dowhep.AbstractClasses.PieSlice;
import io.github.dowhep.HelperClasses.Data;
import io.github.dowhep.HelperClasses.TimeAlgs;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PieSliceController {

    private final IntegerProperty fromIntProperty = new SimpleIntegerProperty(0);
    private final IntegerProperty toIntProperty = new SimpleIntegerProperty(1439);

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
    private ColorPicker sliceColorPicker;

    @FXML
    void cancel(ActionEvent event) throws IOException {
        App.setRoot("piePage");
    }

    @FXML
    void enter(ActionEvent event) throws IOException {
        PieSlice newSlice = new PieSlice(eventNameText.getText(), eventDetailsText.getText(), fromIntProperty.get(),
                toIntProperty.get() - fromIntProperty.get(), sliceColorPicker.getValue());
        Data.getInstance().getPie().getSliceStorage().add(newSlice);
        App.setRoot("piePage");
    }

    @FXML
    void initialize() {
        fromIntProperty.addListener((arg0, oldVal, newVal) -> {
            fromTimeText.setText(TimeAlgs.translateTimeIntStr(fromIntProperty.get()));
            if (fromIntProperty.get() > toIntProperty.get()) {
                toIntProperty.set(fromIntProperty.get());
            }
        });
        toIntProperty.addListener((arg0, oldVal, newVal) -> {
            toTimeText.setText(TimeAlgs.translateTimeIntStr(toIntProperty.get()));
            if (fromIntProperty.get() > toIntProperty.get()) {
                fromIntProperty.set(toIntProperty.get());
            }
        });

        fromTimeText.setText("00:00");
        fromTimeText.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) {
                fromIntProperty.set(TimeAlgs.translateTimeStrInt(TimeAlgs.validateTimeForm(fromTimeText.getText())));
            } else {
                Platform.runLater(() -> {
                    if (fromTimeText.isFocused() && !fromTimeText.getText().isEmpty())
                        fromTimeText.selectAll();
                });
            }
        });
        toTimeText.setText("23:59");
        toTimeText.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) {
                toIntProperty.set(TimeAlgs.translateTimeStrInt(TimeAlgs.validateTimeForm(toTimeText.getText())));
            } else {
                Platform.runLater(() -> {
                    if (toTimeText.isFocused() && !toTimeText.getText().isEmpty())
                        toTimeText.selectAll();
                });
            }
        });
    }

}
