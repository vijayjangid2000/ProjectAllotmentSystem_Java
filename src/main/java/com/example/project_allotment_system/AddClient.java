package com.example.project_allotment_system;

import dbHelper.Client;
import dbHelper.DatabaseHelper;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class AddClient implements Initializable {
    public TextField tvLastName;
    public TextField tvEmail;
    public TextField tvCompanyName;
    public TextField tvLocation;
    public TextField tvMobile;
    public TextField tvFirstName;
    public Button btnSubmit;
    public Text tvMessage;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnSubmit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                actionSubmit();
            }
        });
    }

    private void actionSubmit() {
        Client client = new Client();

        client.setFirstName(tvFirstName.getText());
        client.setLastName(tvLastName.getText());
        client.setCompanyName(tvCompanyName.getText());
        client.setLocation(tvLocation.getText());
        client.setEmail(tvEmail.getText());
        client.setMobile(tvMobile.getText());

        String email;// = Authenticate.loggedInEmployee.getEmail();
        email = "vijay1@gmail.com";

        client.setLastModifiedBy(email);
        client.setLastModifiedOn(String.valueOf(new Date(System.currentTimeMillis())));
        client.setCreatedBy(email);
        client.setCreatedOn(String.valueOf(new Date(System.currentTimeMillis())));
        client.setActive(true);

        System.out.println(client);

        tvMessage.setText("Successful");

        DatabaseHelper.getInstance().addNewRowToClientTable(client, false);
    }


}
