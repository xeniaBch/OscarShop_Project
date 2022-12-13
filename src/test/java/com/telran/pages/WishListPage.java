package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.Collection;

public class WishListPage extends PageBase{
    public WishListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//a[contains(text(),'Create a new wish list')]")
    WebElement create;

    @FindBy(id = "id_name")
    WebElement wishListName;

    @FindBy(xpath="//button[contains(.,'Save')]")
    WebElement save;
    public void createNewWishList(String name) {
        click(create);
        type(wishListName, name);
        click(save);

    }

    @FindBy(css=".alertinner")
    WebElement alert;
    public String checkAlert() {
        return alert.getText();
    }

    @FindBy(css="tr:nth-child(2) .dropdown-toggle")
    WebElement dropdown;

    @FindBy(css=".show > .dropdown-item:nth-child(2)")
    WebElement deleteAction;

    @FindBy(css=".btn-danger")
    WebElement submitDelete;
    public void deleteWishList() {
        click(dropdown);
        click(deleteAction);
        click(submitDelete);
    }

    @FindBy (linkText="View")
    WebElement viewAction;
    public void viewWishListPage() {
        click(viewAction);
    }

    @FindBy(css="h1")
    WebElement wishListHeader;
    public String checkHeader() {
        return wishListHeader.getText();
    }

    @FindBy(id="id_lines-0-quantity")
    WebElement quantity;

    @FindBy(css=".btn-primary")
    WebElement updateQuantity;
    public void setQuantity(String number) {
        type(quantity, number);
        click(updateQuantity);

    }
}
