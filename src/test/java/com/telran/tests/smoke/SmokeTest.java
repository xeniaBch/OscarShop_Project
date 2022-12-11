package com.telran.tests.smoke;

import com.telran.data.AddressData;
import com.telran.data.UserData;
import com.telran.pages.*;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SmokeTest extends TestBase {

    @BeforeMethod
    public void preconditions(){
        new HomePage(driver).selectEnglishLanguage();
    }

    @Test
    public void smokeTest(){
        new HomePage(driver).clickOnLoginOrRegisterLink();
        new LoginPage(driver).registerWithCorrectData(UserData.EMAIL, UserData.PASSWORD, UserData.PASSWORD_CONFIRMATION);
        new HomePage(driver).logout();
        new HomePage(driver).clickOnLoginOrRegisterLink();
        new LoginPage(driver).loginWithCorrectData(UserData.EMAIL, UserData.PASSWORD);
        new HomePage(driver).selectAllProducts();
        new ProductsPage(driver).addToBasket();
        new HomePage(driver).viewBasket();
        new BasketPage(driver).proceedToCheckout();
        new BasketPage(driver).fillShippingAddress(AddressData.FIRST_NAME, AddressData.LAST_NAME, AddressData.FIRST_LINE_OF_ADDRESS,
                AddressData.CITY, AddressData.ZIP_CODE, AddressData.PHONE, AddressData.INSTRUCTION);
        new BasketPage(driver).payment();
        new BasketPage(driver).placeOrder();
        Assert.assertTrue(new BasketPage(driver).orderConfirmation().contains("The shellcoder's handbook"));


    }

    @AfterMethod
    public void postconditions(){
        new HomePage(driver).clickOnLogo();
        new HomePage(driver).clickOnAccount();
        new AccountPage(driver).deleteProfile(UserData.PASSWORD);
    }
}
