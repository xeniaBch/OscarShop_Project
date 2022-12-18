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

    @FindBy(css=".col-sm-6:nth-child(1) .btn")
    WebElement add;
    public void addToBasket() {
        clickWithJSExecutor(add, 0, 200);
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

    @FindBy (css=".col-sm-4:nth-child(1) .mt-3 > a")
    WebElement foundElement;
    public String getSearchProductName() {
        return foundElement.getText();
    }

    @FindBy(xpath="(//a[contains(text(),'Clothing')])[2]")
    WebElement clothing;
    public boolean isClothingLinkPresent() {
        return isElementPresent(clothing);
    }

    @FindBy(xpath="(//a[contains(text(),'Books')])[2]")
    WebElement books;
    public boolean isBooksLinkPresent() {
        return isElementPresent(books);
    }

    @FindBy (xpath="//a[contains(text(),'Fiction')]")
    WebElement fiction;
    public boolean isFictionLinkPresent() {
        return isElementPresent(fiction);
    }

    @FindBy(xpath="//a[contains(text(),'Computers in Literature')]")
    WebElement computers;
    public boolean isComputersInLiteratureLinkPresent() {
        return isElementPresent(computers);
    }

    @FindBy(xpath="//a[contains(text(),'Non-Fiction')]")
    WebElement nonFiction;
    public boolean isNonFictionLinkPresent() {
        return isElementPresent(nonFiction);
    }


    @FindBy(xpath="//a[contains(text(),'Essential programming')]")
    WebElement esProgramming;
    public boolean isEssentialProgrammingLinkPresent() {
        return isElementPresent(esProgramming);
    }

    @FindBy(xpath="//a[contains(text(),'Hacking')]")
    WebElement hacking;
    public boolean isHackingLinkPresent() {
        return isElementPresent(hacking);
    }

    @FindBy(xpath="//a[contains(text(),'next')]")
    WebElement nextButton;
    public void clickOnNextButton() {
        clickWithJSExecutor(nextButton, 0, 600);
    }

    @FindBy(css=".page-item:nth-child(2)")
    WebElement pageNumber;
    public String getCurrentPage() {
        return pageNumber.getText();
    }

    @FindBy(xpath="//a[contains(text(),'previous')]")
    WebElement previousButton;
    public void clickOnPreviousButton() {
        clickWithJSExecutor(previousButton, 0, 600);
    }
}
