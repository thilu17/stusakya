package com.thilu.stusakya.controller;

import com.jfoenix.controls.JFXTextField;
import com.thilu.stusakya.db.Database;
import com.thilu.stusakya.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpFormController {
    public AnchorPane context;
    public JFXTextField txtFirstName;
    public JFXTextField txtEmail;
    public JFXTextField txtLastName;
    public JFXTextField txtPassword;

    public void btnSignUpOnAction(ActionEvent actionEvent) throws IOException {
        String email = txtEmail.getText().toLowerCase().trim();
        String firstName = txtFirstName.getText().trim();
        String lastName = txtLastName.getText().trim();
        String password = txtPassword.getText().trim();
        Database.userTable.add(
                new User(firstName,lastName,email,password)
        );
        new Alert(Alert.AlertType.CONFIRMATION,"Welcome!").show();
        setUi("LoginForm");
    }

    public void btnAlreadyHaveAnAccountOnAction(ActionEvent actionEvent) throws IOException {
        setUi("LoginForm");
    }



    private void setUi(String location) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();
        stage.setScene(new Scene(
                FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
        stage.centerOnScreen();
    }
}
