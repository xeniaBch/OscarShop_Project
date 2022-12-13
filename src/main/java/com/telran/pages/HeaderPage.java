package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Collection;

public class HeaderPage extends PageBase{


    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//select[@name='language']")
    WebElement language;


    @FindBy(css =".btn:nth-child(4)")
    WebElement submit;
    public void selectLanguage(String lang) {
        Select select = new Select(language);
        select.selectByValue(lang);
        click(submit);
    }


    @FindBy(id = "login_link")
    WebElement login_link;
    public void clickOnLoginOrRegisterLink() {
        click(login_link);
    }

    public void selectEnglishLanguage() {
        selectLanguage("en-gb");
    }

    @FindBy(id = "logout_link")
    WebElement logout;
    public void logout() {
        click(logout);
    }

    @FindBy(xpath="//a[contains(@href, '/en-gb/basket/')]")
    WebElement basket;
    public void viewBasket() {
        click(basket);
    }

    @FindBy(xpath="//a[contains(text(),'All products')]")
    WebElement allProducts;
    public void selectAllProducts() {
        click(allProducts);
    }

    @FindBy(css=".nav-item > .mt-2")
    WebElement accountLink;
    public void clickOnAccount() {
        click(accountLink);
    }

    @FindBy(xpath="//a[contains(text(),'Oscar')]")
    WebElement logo;
    public void clickOnLogo() {
        click(logo);
    }


    public String checkAccount() {
        return accountLink.getText();
    }

    public boolean isAccountLinkPresent() {

        return accountLink.isDisplayed();
    }
}
