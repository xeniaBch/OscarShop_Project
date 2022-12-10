package com.telran.tests.smoke;

import com.telran.data.AddressData;
import com.telran.data.UserData;
import com.telran.pages.*;
import com.telran.tests.TestBase;
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
        new BasketPage(driver).fillShippingAddress(AddressData.FIRST_NAME, AddressData.LAST_NAME, );


    }

    @AfterMethod
    public void postconditions(){
        new HomePage(driver).clickOnAccount();
        new AccountPage(driver).deleteProfile(UserData.PASSWORD);
    }
}
