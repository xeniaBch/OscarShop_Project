package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Collection;

public class BasketPage extends PageBase{
    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//a[contains(text(),'Proceed to checkout')]")
    WebElement proceed;
    public void proceedToCheckout() {
        clickWithJSExecutor(proceed, 0, 300);
    }

    @FindBy(id = "id_title")
    WebElement title;

    @FindBy(id = "id_first_name")
    WebElement id_first_name;

    @FindBy(id = "id_last_name")
    WebElement id_last_name;

    @FindBy(id = "id_line1")
    WebElement id_line1;

    @FindBy(id = "id_line4")
    WebElement id_line4;

    @FindBy(id = "id_postcode")
    WebElement id_postcode;

    @FindBy(id = "id_country")
    WebElement id_country;

    @FindBy(id = "id_phone_number")
    WebElement id_phone_number;

    @FindBy(id = "id_notes")
    WebElement id_notes;

    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement continueButton;
    public void fillShippingAddress(String firstName, String lastName,
                                    String firstLine, String city, String zipCode, String phone, String instruction) {

        Select select = new Select(title);
        select.selectByValue("Mr");
        type(id_first_name, firstName);
        type(id_last_name, lastName);
        type(id_line1, firstLine);
        type(id_line4, city);
        type(id_postcode, zipCode);
        Select selectCountry = new Select(id_country);
        selectCountry.selectByValue("US");
        type(id_phone_number, phone);
        type(id_notes, instruction);
        click(continueButton);
    }

    @FindBy(id = "view_preview")
    WebElement continuePayment;
    public void payment() {
        click(continuePayment);
    }

    @FindBy(id = "place-order")
    WebElement place;
    public void placeOrder() {
        clickWithJSExecutor(place, 0, 400);
    }

    @FindBy(css = "h3 > a")
    WebElement purchase;
    public String orderConfirmation() {
        System.out.println(purchase.getText());
        return purchase.getText();
    }
}
