package it.saimao.pakpi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class PakpiApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
        FXMLLoader fxmlLoader = new FXMLLoader(PakpiApplication.class.getResource("/views/pakpi-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Pakpi Calendar");
        stage.setScene(scene);

        stage.setX(screenSize.getMinX());
        stage.setY(screenSize.getMinY());
        stage.setWidth(screenSize.getWidth());
        stage.setHeight(screenSize.getHeight());
        stage.setMaximized(true);
        stage.getIcons().add(new Image(getClass().getResource("/images/pakpi.jpg").toExternalForm()));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}