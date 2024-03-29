package com.zoi4erom.messenger.controllers;

import com.zoi4erom.messenger.service.UserService;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class RegistrationController {

	@FXML
	private TextField fullNameField;
	@FXML
	private TextField emailField;
	@FXML
	private TextField passwordField;
	@FXML
	private Label loginLabel;
	private static final UserService userService = new UserService();

	@FXML
	private void initialize() {
		loginLabel.setOnMouseClicked(event -> {
			switchToLoginPage();
		});
	}

	@FXML
	private void handleRegisterButtonAction() {
		String fullName = fullNameField.getText();
		String email = emailField.getText();
		String password = passwordField.getText();

		userService.createUser(fullName, email, password);
	}
	private void switchToLoginPage() {
		try {
			Stage stage = (Stage) loginLabel.getScene().getWindow();
			Pane loginPane = FXMLLoader.load(getClass().getResource("/com/zoi4erom/messenger/view/login-view.fxml"));
			stage.getScene().setRoot(loginPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
