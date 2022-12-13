package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.Collection;

public class ProductsPage extends PageBase{
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css=".col-xs-6:nth-child(1) .btn")
    WebElement add;
    public void addToBasket() {
        click(add);
    }

    @FindBy(id= "messages")
    WebElement welcomeMessage;
    public String checkWelcomeMessage() {
        System.out.println(welcomeMessage.getText());
        return welcomeMessage.getText();
    }
}
