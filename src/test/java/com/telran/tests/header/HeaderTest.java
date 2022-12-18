package com.telran.tests.header;

import com.telran.data.UserData;
import com.telran.pages.HeaderPage;
import com.telran.pages.LoginPage;
import com.telran.pages.ProductsPage;
import com.telran.tests.TestBaseNew;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HeaderTest extends TestBaseNew {

    @BeforeMethod
    public void preconditions(){
        new HeaderPage(driver).selectEnglishLanguage();
    }

    @Test
    public void logoPositiveTest(){
        Assert.assertTrue(new HeaderPage(driver).isLogoPresent());
    }

    @Test
    public void loginOrRegisterLinkPositiveTest(){
        Assert.assertTrue(new HeaderPage(driver).isLoginLinkPresent());
    }

    @Test
    public void accountLinkPositiveTest(){
        new HeaderPage(driver).clickOnLoginOrRegisterLink();
        new LoginPage(driver).loginUser(UserData.EXISTED_EMAIL, UserData.EXISTED_PASSWORD);
        Assert.assertTrue(new HeaderPage(driver).isAccountLinkPresent());
    }

    @Test
    public void searchFieldPositiveTest(){
        new HeaderPage(driver).search("Test");
        Assert.assertTrue(new ProductsPage(driver).getSearchProductName().contains("Test"));
    }

    @Test
    public void basketLinkPositiveTest(){
        SoftAssert asrt = new SoftAssert();
        asrt.assertTrue(new HeaderPage(driver).isBasketExists());
        asrt.assertTrue(new HeaderPage(driver).isViewBasketButtonIsClickable().contains("Basket"));
    }


}
