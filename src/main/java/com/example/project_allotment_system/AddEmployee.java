package com.example.project_allotment_system;

import dbHelper.*;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class AddEmployee implements Initializable {

    public TextField textInputName;
    public TextField textInputEmail;
    public TextField textInputMobile;
    public TextField textInputPreviousExp;
    public TextField textInputDomainExpert;
    public PasswordField tvInputPassword;
    public Text tvMessage;
    public DatePicker dateInputJoining;
    public DatePicker dateInputDOB;
    public TextField textInputManagerId;
    public ChoiceBox<String> choiceBoxRoleInCompany;
    public Button btnSubmit;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnSubmit.setOnAction(actionEvent -> actionSubmitForm());

        for (int i = 0; i < DbQueries.getInstance().roleOfEmployee.length; i++) {
            choiceBoxRoleInCompany.getItems().add(i, DbQueries.getInstance().roleOfEmployee[i]);
        }
    }

    void actionSubmitForm() {

        // temp
        Employee employee = new Employee();

        employee.setName(textInputName.getText());
        employee.setEmail(textInputEmail.getText());
        employee.setMobile(textInputMobile.getText());
        employee.setPreviousExperienceInYears(Integer.parseInt(textInputPreviousExp.getText()));
        employee.setDomainExpertiseId(Integer.parseInt(textInputDomainExpert.getText()));
        employee.setJoiningDate(dateInputJoining.getEditor().getText());
        employee.setDateOfBirth(dateInputDOB.getEditor().getText());
        employee.setManagerId(Integer.parseInt(textInputManagerId.getText()));
        employee.setRoleInCompany(choiceBoxRoleInCompany.getSelectionModel().getSelectedIndex());

        String email;// = Authenticate.loggedInEmployee.getEmail();
        email = "vijay1@gmail.com";

        employee.setLastModifiedBy(email);
        employee.setLastModifiedOn(String.valueOf(new Date(System.currentTimeMillis())));
        employee.setCreatedBy(email);
        employee.setCreatedOn(String.valueOf(new Date(System.currentTimeMillis())));
        employee.setActive(true);

        // save data into database
        DatabaseHelper.getInstance().addNewRowToEmployeeTable(employee, false);

        Authenticate authenticate = new Authenticate();
        authenticate.setUserEmail(employee.getEmail());
        authenticate.setPassword(Tools.toHashSha256(tvInputPassword.getText()));

        authenticate.setLastModifiedBy(email);
        authenticate.setLastModifiedOn(String.valueOf(new Date(System.currentTimeMillis())));
        authenticate.setCreatedBy(email);
        authenticate.setCreatedOn(String.valueOf(new Date(System.currentTimeMillis())));
        authenticate.setActive(true);

        DatabaseHelper.getInstance().addNewRowToAuthenticateTable(authenticate, false);

        tvMessage.setText("Employee Added Successfully");

    }

}
