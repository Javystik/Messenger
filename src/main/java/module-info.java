module com.zoi4erom.messenger {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires org.hibernate.orm.core;
    requires org.postgresql.jdbc;
    requires jakarta.persistence;

    opens com.zoi4erom.messenger to javafx.fxml;
    exports com.zoi4erom.messenger;
}
