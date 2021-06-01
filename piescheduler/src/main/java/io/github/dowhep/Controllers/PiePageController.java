package io.github.dowhep.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import io.github.dowhep.App;
import io.github.dowhep.AbstractClasses.*;
import io.github.dowhep.HelperClasses.Data;

public class PiePageController {
    final private HashMap<Node, PieSlice> map = new HashMap<Node, PieSlice>();

    @FXML
    private VBox sceneContainer;

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
    private PieChart pieChartDisplay;

    @FXML
    void createNewSlice(ActionEvent event) throws IOException {
        App.setRoot("createANewSlicePage");
    }

    @FXML
    public void initialize() {

        sliceTable.setPlaceholder(new Label("Just Emptiness..."));

        sliceNameColumn.setCellValueFactory(new PropertyValueFactory<>("sliceName"));
        taskNameColumn.setCellValueFactory(new PropertyValueFactory<>("task"));

        // pie chart
        ObservableList<PieSlice> slices = Data.getInstance().getPie().getSliceStorage();
        ArrayList<PieChart.Data> dataList = new ArrayList<PieChart.Data>();

        for (int i = 0; slices.size() > i; i++) {
            PieChart.Data slice = new PieChart.Data(slices.get(i).getSliceName(), slices.get(i).getDuration());
            dataList.add(slice);
        }
        sliceTable.setItems(slices);
        ObservableList<PieChart.Data> chartData = FXCollections.observableList(dataList);

        final PieChart thingsChart = new PieChart(chartData);

        thingsChart.setTitle("Your Day");

        final Label caption = new Label();
        caption.setTextFill(Color.DARKORANGE);
        caption.setStyle("-fx-font: 16 arial;");

        sceneContainer.getChildren().add(thingsChart);
        sceneContainer.getChildren().add(caption);

        // credit to jewelsea on stackoverflow for the coloring
        for (int i = 0; slices.size() > i; i++) {
            Node slice = dataList.get(i).getNode();
            map.put(slice, slices.get(i));

            slice.setStyle("-fx-pie-color: " + toHexString(slices.get(i).color()) + ";");

            // we can do something here
            slice.addEventHandler(MouseEvent.MOUSE_ENTERED, (e) -> {
                PieSlice theSlice = map.get(e.getSource());
                caption.setText("Start: " + theSlice.getStartTimeString() + ", Duration: " + theSlice.getDuration()
                        + " minutes");
            }); // when slice is hovered
            slice.addEventHandler(MouseEvent.MOUSE_MOVED, (e) -> {
                caption.setTranslateX(e.getX() + 335);
                caption.setTranslateY(e.getY() - 65);
            }); // when mouse is moving
            slice.addEventHandler(MouseEvent.MOUSE_EXITED, (e) -> {
                caption.setTranslateX(-1000);
                caption.setTranslateY(-1000);
            }); // when slice is unhovered
        }

    }

    // Helper method, safe floating points
    private String format(double val) {
        String safein = Integer.toHexString((int) Math.round(val * 255));
        return safein.length() == 1 ? "0" + safein : safein;
    }

    public String toHexString(Color value) {
        return "#" + format(value.getRed()) + format(value.getGreen()) + format(value.getBlue())
                + format(value.getOpacity());
    }

}
