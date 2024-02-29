module it.saimao.pakpi {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    exports it.saimao.pakpi.controllers;
    opens it.saimao.pakpi.controllers to javafx.fxml;
    exports it.saimao.pakpi;
    opens it.saimao.pakpi to javafx.fxml;
}