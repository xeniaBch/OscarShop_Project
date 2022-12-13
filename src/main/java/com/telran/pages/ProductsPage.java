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

    @FindBy(css=".col-sm-6:nth-child(1) .mt-3 > a")
    WebElement productLink;

    @FindBy(css=".btn-lg:nth-child(1)")
    WebElement selectWishList;

    @FindBy(linkText="Add to 'Test Wish List' wish list")
    WebElement addToWishList;

    @FindBy(xpath="//a[contains(@href, '/en-gb/accounts/wishlists/2n7jjk/')]")
    WebElement openWishList;


    public void addToWishList() {
        click(productLink);
        click(selectWishList);
        click(addToWishList);
        click(openWishList);
    }
}
