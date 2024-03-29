package com.zoi4erom.messenger.controllers;

import com.zoi4erom.messenger.service.AuthenticationService;
import com.zoi4erom.messenger.service.UserService;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoginController {
	@FXML
	private Label createAccountLabel;
	@FXML
	private TextField fullNameField;
	@FXML
	private TextField passwordField;
	private final UserService userService = new UserService();
	@FXML
	protected void initialize() {
		createAccountLabel.setOnMouseClicked(event -> {
			switchToRegistrationPage();
		});
	}
	private void switchToRegistrationPage() {
		try {
			Stage stage = (Stage) createAccountLabel.getScene().getWindow();
			Pane registrationPane = FXMLLoader.load(getClass().getResource("/com/zoi4erom/messenger/view/registration-view.fxml"));
			stage.getScene().setRoot(registrationPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@FXML
	private void handleLoginButtonAction() {
		AuthenticationService authenticationService = new AuthenticationService(userService);

		String login = fullNameField.getText();
		String password = passwordField.getText();

		if (authenticationService.authentication(login, password)){
			System.out.println("Успішна авторизація");
		}else {
			System.out.println("Провал");
		}
	}
}
