package io.github.dowhep.Controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import io.github.dowhep.App;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}