module io.github.dowhep {
    requires javafx.controls;
    requires javafx.fxml;

    opens io.github.dowhep to javafx.fxml;
    opens io.github.dowhep.Controllers to javafx.fxml;
    opens io.github.dowhep.AbstractClasses to javafx.base;

    exports io.github.dowhep;
}