package it.saimao.shancalendar.applications;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class ShanCalendarApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
        FXMLLoader fxmlLoader = new FXMLLoader(ShanCalendarApplication.class.getResource("/views/shan-calendar-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Shan Calendar");
        stage.setScene(scene);

        stage.setX(screenSize.getMinX());
        stage.setY(screenSize.getMinY());
        stage.setWidth(screenSize.getWidth());
        stage.setHeight(screenSize.getHeight());
        stage.setMaximized(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}