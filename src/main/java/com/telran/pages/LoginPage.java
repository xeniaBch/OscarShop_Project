package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver driver){
        super(driver);
    }


    @FindBy(id = "id_registration-email")
    WebElement emailField;

    @FindBy(id = "id_registration-password1")
    WebElement passwordField;

    @FindBy(id = "id_registration-password2")
    WebElement passwordConfirmationField;

    @FindBy(name = "registration_submit")
    WebElement registerButton;
    public void registerWithCorrectData(String email, String password, String passwordConfirmation) {
        type(emailField, email);
        type(passwordField, password);
        type(passwordConfirmationField, passwordConfirmation);
        click(registerButton);

    }

    @FindBy(id = "id_login-username")
    WebElement loginUsername;

    @FindBy(id = "id_login-password")
    WebElement loginPassword;

    @FindBy(name = "login_submit")
    WebElement loginButton;

    public void loginWithCorrectData(String email, String password) {
        type(loginUsername, email);
        type(loginPassword, password);
        click(loginButton);
    }
}
