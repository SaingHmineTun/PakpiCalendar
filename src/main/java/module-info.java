module it.saimao.shancalendar {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;


    exports it.saimao.pakpi.applications;
    opens it.saimao.pakpi.applications to javafx.fxml;
    exports it.saimao.pakpi.controllers;
    opens it.saimao.pakpi.controllers to javafx.fxml;
}