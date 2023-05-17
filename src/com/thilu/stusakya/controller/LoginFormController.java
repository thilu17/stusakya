package com.thilu.stusakya.controller;

import com.jfoenix.controls.JFXTextField;
import com.thilu.stusakya.db.Database;
import com.thilu.stusakya.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
    public AnchorPane context;
    public JFXTextField txtEmail;
    public JFXTextField txtPassword;


    public void btnLoginOnAction(ActionEvent actionEvent) {
        String email = txtEmail.getText().toLowerCase().trim();
        String password = txtPassword.getText().trim();

        for (User user : Database.userTable) {
            if (user.getEmail().equals(email)) {
                if (user.getPassword().equals(password)) {
                    System.out.println(user.toString());
                    return;
                } else {
                    new Alert(Alert.AlertType.ERROR, "Wrong Password!").show();
                    return;
                }
            }
        }
        new Alert(Alert.AlertType.WARNING,
                String.format("User not found (%s)", email)).show();
    }

    public void btnCreateAnAccountOnAction(ActionEvent actionEvent) throws IOException {
        setUi("SignUpForm");
    }


    private void setUi(String location) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();
        stage.setScene(new Scene(
                FXMLLoader.load(getClass().getResource("../view/" + location + ".fxml"))));
        stage.centerOnScreen();
    }
}
