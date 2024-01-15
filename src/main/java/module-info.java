module it.saimao.shancalendar {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;


    exports it.saimao.shancalendar.applications;
    opens it.saimao.shancalendar.applications to javafx.fxml;
    exports it.saimao.shancalendar.controllers;
    opens it.saimao.shancalendar.controllers to javafx.fxml;
}