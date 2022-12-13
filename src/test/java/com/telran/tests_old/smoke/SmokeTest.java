package com.telran.tests_old.smoke;

import com.telran.data.AddressData;
import com.telran.data.UserData;
import com.telran.pages.*;
import com.telran.tests_old.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SmokeTest extends TestBase {

    @BeforeMethod
    public void preconditions(){
        new HeaderPage(driver).selectEnglishLanguage();
    }

    @Test
    public void smokeTest(){
        new HeaderPage(driver).clickOnLoginOrRegisterLink();
        new LoginPage(driver).takeScreenshotWithScrollDown();
        new LoginPage(driver).registerUser(UserData.EMAIL, UserData.PASSWORD, UserData.PASSWORD_CONFIRMATION);
        new HeaderPage(driver).logout();
        new HeaderPage(driver).clickOnLoginOrRegisterLink();
        new LoginPage(driver).loginUser(UserData.EMAIL, UserData.PASSWORD);
        new HeaderPage(driver).selectAllProducts();
        new ProductsPage(driver).addToBasket();
        new HeaderPage(driver).viewBasket();
        new BasketPage(driver).proceedToCheckout();
        new BasketPage(driver).fillShippingAddress(AddressData.FIRST_NAME, AddressData.LAST_NAME, AddressData.FIRST_LINE_OF_ADDRESS,
                AddressData.CITY, AddressData.ZIP_CODE, AddressData.PHONE, AddressData.INSTRUCTION);
        new BasketPage(driver).payment();
        new BasketPage(driver).placeOrder();
        Assert.assertTrue(new BasketPage(driver).orderConfirmation().contains("The shellcoder's handbook"));


    }

    @AfterMethod
    public void postconditions(){
        new HeaderPage(driver).clickOnLogo();
        new HeaderPage(driver).clickOnAccount();
        new AccountPage(driver).deleteProfile(UserData.PASSWORD);
    }
}
