module io.github.dowhep {
    requires javafx.controls;
    requires javafx.fxml;

    opens io.github.dowhep to javafx.fxml;
    opens io.github.dowhep.Controllers to javafx.fxml;
    exports io.github.dowhep;
}