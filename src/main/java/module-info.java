module com.zoi4erom.messenger {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires org.hibernate.orm.core;
    requires org.postgresql.jdbc;
    requires jakarta.persistence;
    requires org.kordamp.ikonli.core;
    requires java.naming;

    opens com.zoi4erom.messenger to javafx.fxml;
    opens com.zoi4erom.messenger.entity to org.hibernate.orm.core;
    opens com.zoi4erom.messenger.controllers to javafx.fxml;
    exports com.zoi4erom.messenger;
    exports com.zoi4erom.messenger.controllers;
}
