package com.example.project_allotment_system;

import dbHelper.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoginPage implements Initializable {

    @FXML
    private Button btnForget, btnSubmit;
    @FXML
    private Text tvUserName, tvPassword, tvMessageView;
    @FXML
    private TextField tvInputUsername, tvInputPassword;

    @FXML
    void viewLinker() {

        btnSubmit.setOnAction(actionEvent -> {
            actionSubmitForm();
            System.out.println("Hello");
        });
    }

    @FXML
    void actionSubmitForm() {

        Authenticate authenticate = new Authenticate();
        authenticate.setUserEmail(tvInputUsername.getText());
        authenticate.setPassword(tvInputPassword.getText());

        if (authenticate.getUserEmail().length() == 0) {
            tvMessageView.setText("Please enter E-mail");
            return;
        } else if (authenticate.getPassword().length() == 0) {
            tvMessageView.setText("Please enter password");
            return;
        }

        authenticate.setPassword(Tools.toHashSha256(tvInputPassword.getText()));
        tvMessageView.setText(authenticate.getUserEmail() + " " + authenticate.getPassword());
        if (checkAuthenticate(authenticate)) {
            DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
            Authenticate.loggedInEmployee = databaseHelper.queryEmployee
                    (DbQueries.getInstance().psCheckEmployee(authenticate.getUserEmail())).get(0);
            tvMessageView.setText("Welcome " + Authenticate.loggedInEmployee.getName());
        } else {
            tvMessageView.setText("Incorrect Username and Password, \nPlease try again");
        }


    }

    boolean checkAuthenticate(Authenticate authenticate) {
        DatabaseHelper dbHelp = DatabaseHelper.getInstance();
        ArrayList<Authenticate> list = dbHelp.queryAuthenticate(DbQueries.getInstance()
                .psCheckAuthenticate(authenticate.getUserEmail(), authenticate.getPassword()));
        return list.size() > 0;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        viewLinker();
        System.out.println("INITIALIZED");
    }
}
