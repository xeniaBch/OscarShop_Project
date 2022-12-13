package com.telran.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    public void registerUser(String email, String password, String passwordConfirmation) {
        type(emailField, email);
        type(passwordField, password);
        type(passwordConfirmationField, passwordConfirmation);
        click(registerButton);
    }

    public void registerUserWithEmptyEmail(String password, String passwordConfirmation) {
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

    public void loginUser(String email, String password) {
        type(loginUsername, email);
        type(loginPassword, password);
        click(loginButton);
    }

    @FindBy (css="#register_form > h2")
    WebElement headerRegister;
    public String checkHeaderRegister() {
        return headerRegister.getText();
    }

    public void registerUserWithEmptPassword(String email) {
        type(emailField, email);
        click(registerButton);
    }

    @FindBy(css = ".alert.alert-danger")
    WebElement alertError;
    public String checkErrorMessage() {
        System.out.println(alertError.getText());
        return alertError.getText();
    }

    @FindBy(css = ".error-block")
    WebElement errorBlock;
    public String checkErrorBlock() {
        System.out.println(errorBlock.getText());
        return errorBlock.getText();
    }


    @FindBy(xpath="//form[@id='login_form']/div[2]")
    WebElement loginErrorMessage;
    public String checkLoginErrorMessage() {
        return  loginErrorMessage.getText();
    }

    @FindBy (css="#login_form > h2")
    WebElement headerLogin;
    public String checkHeaderLogin() {
        return headerLogin.getText();
    }


}
