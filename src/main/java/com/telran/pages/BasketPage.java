package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class BasketPage extends PageBase{
    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//a[contains(text(),'Proceed to checkout')]")
    WebElement proceed;
    public void proceedToCheckout() {
        clickWithJSExecutor(proceed, 0, 300);
    }

    public void fillShippingAddress(String firstName, String lastName, ) {
    }
}
