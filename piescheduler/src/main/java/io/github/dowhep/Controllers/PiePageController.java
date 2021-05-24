package io.github.dowhep.Controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

import io.github.dowhep.App;
import io.github.dowhep.AbstractClasses.*;
import io.github.dowhep.HelperClasses.Data;

public class PiePageController {

    @FXML
    private Button createANewSliceButton;

    @FXML
    private TableView<PieSlice> sliceTable;

    @FXML
    private TableColumn<PieSlice, String> sliceNameColumn;

    @FXML
    private TableColumn<PieSlice, String> fromTimeColumn;

    @FXML
    private TableColumn<PieSlice, String> toTimeColumn;

    @FXML
    private TableColumn<PieSlice, String> taskNameColumn;

    @FXML
    void createNewSlice(ActionEvent event) throws IOException {
        App.setRoot("createANewSlicePage");
    }

    @FXML
    public void initialize() {
        sliceTable.setPlaceholder(new Label("Just Emptiness..."));

        sliceNameColumn.setCellValueFactory(new PropertyValueFactory<>("sliceName"));
        taskNameColumn.setCellValueFactory(new PropertyValueFactory<>("task"));

        ObservableList<PieSlice> slices = Data.getInstance().getPie().getPieSlices();
        sliceTable.setItems(slices);
    }

}
