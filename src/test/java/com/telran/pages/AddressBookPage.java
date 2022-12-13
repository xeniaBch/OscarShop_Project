package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Collection;

public class AddressBookPage extends PageBase{
    public AddressBookPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText="Add a new address")
    WebElement addAddressButton;

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

    @FindBy(xpath = "//button[contains(.,'Save')]")
    WebElement saveButton;

    public void addNewAddress(String firstName, String lastName,
                              String firstLine, String city, String zipCode, String phone, String instruction) {
        click(addAddressButton);
        type(id_first_name, firstName);
        type(id_last_name, lastName);
        type(id_line1, firstLine);
        type(id_line4, city);
        type(id_postcode, zipCode);
        Select selectCountry = new Select(id_country);
        selectCountry.selectByValue("US");
        type(id_phone_number, phone);
        type(id_notes, instruction);
        clickWithJSExecutor(saveButton, 0, 300);
    }

    @FindBy(css=".alertinner")
    WebElement alert;
    public String checkMessage() {
        return alert.getText();
    }

    @FindBy(css=".btn-group:nth-child(1) > .dropdown-toggle")
    WebElement selectAction;

    @FindBy(linkText="Delete")
    WebElement delete;

    @FindBy(xpath="//button[contains(.,'Delete')]")
    WebElement deleteSubmit;
    public void deleteAddress() {
        click(selectAction);
        click(delete);
        click(deleteSubmit);

    }

    @FindBy(linkText="Edit")
    WebElement editButton;
    public void editAddress(String firstNameEdited, String firstLineOfAddressEdited) {
        click(editButton);
        type(id_first_name, firstNameEdited);
        type(id_line1, firstLineOfAddressEdited);
        clickWithJSExecutor(saveButton, 0, 300);
    }
}
