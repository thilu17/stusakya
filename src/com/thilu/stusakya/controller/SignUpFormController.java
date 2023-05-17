package com.thilu.stusakya.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpFormController {
    public AnchorPane context;
    public JFXTextField txtFirstName;
    public JFXTextField txtEmail;
    public JFXTextField txtLastName;
    public JFXTextField txtPassword;

    public void btnSignUpOnAction(ActionEvent actionEvent) {
    }

    public void btnAlreadyHaveAnAccountOnAction(ActionEvent actionEvent) {
        //setUi(LoginFormController);
    }



    private void setUi(String location) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();
        stage.setScene(new Scene(
                FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
        stage.centerOnScreen();
    }
}
