module OnibmagAirlines {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires java.sql;
    requires javafx.web;
    requires org.controlsfx.controls;
    requires jfxtras.controls;
    requires java.desktop;

    exports com.onibmagairlines.javafx to javafx.graphics, javafx.fxml, javafx.web;

    opens com.onibmagairlines.javafx to javafx.fxml;
    opens com.onibmagairlines.classes to javafx.base;
    exports com.onibmagairlines.controllers to javafx.fxml, javafx.graphics;
    opens com.onibmagairlines.controllers to javafx.fxml;
}