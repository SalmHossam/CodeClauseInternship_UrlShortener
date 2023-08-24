module com.example.urlshortener {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.urlshortener to javafx.fxml;
    exports com.example.urlshortener;
}