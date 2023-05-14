module com.example.finanzas {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.finanzas to javafx.fxml;
    exports com.example.finanzas;
    exports com.example.finanzas.model;
    opens com.example.finanzas.model to javafx.fxml;
}