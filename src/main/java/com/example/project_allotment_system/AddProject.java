package com.example.project_allotment_system;

import dbHelper.DatabaseHelper;
import dbHelper.DbQueries;
import dbHelper.Milestone;
import dbHelper.Project;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class AddProject implements Initializable {

    public TextField tvTitle;
    public TextField tvName;
    public TextField tvDescription;
    public DatePicker cbDeadline;
    public TextField tvNumOfEmp;
    public TextField tvNumOfExperiEmp;
    public TextField tvExperienceInYears;
    public TextField tvNumOfMilestone;
    public TextField tvClientId;
    public Text tvMessage;
    public ChoiceBox<String> cbDomainId;
    public Button btnSubmit;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnSubmit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                actionSubmit();
            }
        });

        for (int i = 0; i < DbQueries.getInstance().domainExpertise.length; i++) {
            cbDomainId.getItems().add(i, DbQueries.getInstance().domainExpertise[i]);
        }
    }

    void actionSubmit() {
        Project project = new Project();

        project.setTitle(tvTitle.getText());
        project.setName(tvName.getText());
        project.setDescription(tvDescription.getText());
        project.setDeadLine(cbDeadline.getEditor().getText());
        project.setFinishedOn(cbDeadline.getEditor().getText());
        project.setBeforeDeadline(false);
        project.setNumberOfEmployeeRequired(Integer.parseInt(tvNumOfEmp.getText()));
        project.setNumberOfExperienced(Integer.parseInt(tvNumOfExperiEmp.getText()));
        project.setMinimumExperience(Integer.parseInt(tvExperienceInYears.getText()));
        project.setStatus(Integer.parseInt(tvNumOfMilestone.getText()));
        project.setDomainExpert(cbDomainId.getSelectionModel().getSelectedIndex() + 1);
        project.setClientId(Integer.parseInt(tvClientId.getText()));

        String email;// = Authenticate.loggedInEmployee.getEmail();
        email = "vijay1@gmail.com";

        project.setLastModifiedBy(email);
        project.setLastModifiedOn(String.valueOf(new Date(System.currentTimeMillis())));
        project.setCreatedBy(email);
        project.setCreatedOn(String.valueOf(new Date(System.currentTimeMillis())));
        project.setActive(true);

        System.out.println(project);
        tvMessage.setText("Successful");

        DatabaseHelper.getInstance().addNewRowToProjectTable(project, false);

        int size = project.getNumberOfEmployeeRequired();

        for (int i = 0; i < size; i++) {

            Milestone milestone = new Milestone();
            milestone.setMileNumber(i + 1);
            milestone.setProjectId(project.getUniqueId());
            milestone.setTitle("Milestone " + (i + 1));
            milestone.setDescription("description of milestone");
            milestone.setTimeInHours(1);
            milestone.setStatus(DbQueries.getInstance().MILESTONE_IDLE);
            milestone.setAssignedToEmployeeId(DbQueries.getInstance().EMPTY_INT_COLUMN);
            milestone.setCompletedByEmployeeId(DbQueries.getInstance().EMPTY_INT_COLUMN);

            project.setLastModifiedBy(email);
            project.setLastModifiedOn(String.valueOf(new Date(System.currentTimeMillis())));
            project.setCreatedBy(email);
            project.setCreatedOn(String.valueOf(new Date(System.currentTimeMillis())));
            project.setActive(true);

            DatabaseHelper.getInstance().addNewRowToMilestoneTable(milestone, false);
        }


    }


}