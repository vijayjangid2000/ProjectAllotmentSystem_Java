package com.example.project_allotment_system;

import dbHelper.DatabaseHelper;
import dbHelper.DbQueries;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        DatabaseHelper.getInstance();
        DbQueries.getInstance();


        String first = "hello-view.fxml";
        String login = "loginPage.fxml";
        String employee = "AddEmployee.fxml";
        String project = "AddProject.fxml";
        String client = "AddClient.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(client));
        Scene scene = new Scene(fxmlLoader.load(), 500, 500);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}