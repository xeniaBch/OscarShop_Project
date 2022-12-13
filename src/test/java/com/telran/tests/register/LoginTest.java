package com.telran.tests.register;

import com.telran.data.UserData;
import com.telran.pages.HeaderPage;
import com.telran.pages.LoginPage;
import com.telran.tests.TestBaseNew;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBaseNew {

    @BeforeMethod
    public void preconditions(){
        new HeaderPage(driver).selectEnglishLanguage();
        new HeaderPage(driver).clickOnLoginOrRegisterLink();
    }

    @Test
    public void loginPositiveTest(){
        new LoginPage(driver).loginUser(UserData.EXISTED_EMAIL, UserData.EXISTED_PASSWORD);
        Assert.assertTrue(new HeaderPage(driver).isAccountLinkPresent());
    }

    @Test
    public void loginWithWrongPasswordNegativeTest(){
        new LoginPage(driver).loginUser(UserData.EXISTED_EMAIL, UserData.PASSWORD);
        Assert.assertTrue(new LoginPage(driver).checkLoginErrorMessage().contains("Please enter a correct username and password."));
    }

    @Test
    public void loginWithWrongEmailNegativeTest(){
        new LoginPage(driver).loginUser(UserData.EMAIL, UserData.EXISTED_PASSWORD);
        Assert.assertTrue(new LoginPage(driver).checkLoginErrorMessage().contains("Please enter a correct username and password."));
    }

    @Test
    public void loginWithEmptyEmailFieldNegativeTest(){
        new LoginPage(driver).loginUser("", UserData.EXISTED_PASSWORD);
        Assert.assertTrue(new LoginPage(driver).checkHeaderLogin().contains("Log In"));
    }

    @Test
    public void loginWithEmptyPasswordFieldNegativeTest(){
        new LoginPage(driver).loginUser(UserData.EXISTED_EMAIL, "");
        Assert.assertTrue(new LoginPage(driver).checkHeaderLogin().contains("Log In"));
    }

}
