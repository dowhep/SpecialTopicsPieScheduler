package io.github.dowhep.Controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import io.github.dowhep.App;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
