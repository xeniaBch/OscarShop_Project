package com.telran.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.Collection;

public class AccountPage extends PageBase{
    public AccountPage(EventFiringWebDriver driver) {
        super(driver);
    }

    @FindBy(id = "delete_profile")
    WebElement delete;

    @FindBy(id = "id_password")
    WebElement passwordField;

    @FindBy(css = ".btn-lg")
    WebElement submitDelete;
    public void deleteProfile(String password) {
    click(delete);
    type(passwordField, password);
    click(submitDelete);
    }

    @FindBy(css=".btn:nth-child(5)")
    WebElement edit;

    @FindBy(id="id_first_name")
    WebElement fname;

    @FindBy(id="id_last_name")
    WebElement lname;

    @FindBy(css=".btn-lg")
    WebElement save;
    public void editProfile(String firstName, String lastName) {
        click(edit);
        type(fname, firstName);
        type(lname, lastName);
        clickWithJSExecutor(save, 0, 100);
    }

    @FindBy(css="tr:nth-child(1) > td")
    WebElement userName;
    public String getUserName() {
        System.out.println(userName.getText());
        return userName.getText();
    }

    @FindBy(css=".alertinner")
    WebElement alert;
    public String checkAlert() {
        return alert.getText();
    }

    @FindBy(id = "logout_link")
    WebElement logout;
    public void logout(){
        click(logout);
    }

    @FindBy(css=".nav-item:nth-child(7) > .nav-link")
    WebElement selectWishList;
    public void selectWishList() {
        click(selectWishList);
    }
}
