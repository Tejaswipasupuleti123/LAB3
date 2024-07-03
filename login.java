package com.example.lab2pc;

import com.mysql.cj.protocol.x.XMessage;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class login {

    public Button login;

    public TextField username;

    public TextField password;

    public void loginClick(ActionEvent actionEvent) {
        String name = username.getText();
        String upassword = password.getText();
    }
}