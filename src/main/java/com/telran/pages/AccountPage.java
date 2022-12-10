package com.telran.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

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
}
