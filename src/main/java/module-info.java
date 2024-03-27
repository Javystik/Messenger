module com.zoi4erom.messenger {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.zoi4erom.messenger to javafx.fxml;
    exports com.zoi4erom.messenger;
}