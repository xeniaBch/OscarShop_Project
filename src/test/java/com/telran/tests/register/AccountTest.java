package com.telran.tests.register;

import com.telran.data.AddressData;
import com.telran.data.UserData;
import com.telran.pages.AccountPage;
import com.telran.pages.HeaderPage;
import com.telran.pages.LoginPage;
import com.telran.tests.TestBaseNew;
import com.telran.utils.DataProviders;
import com.telran.utils.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AccountTest extends TestBaseNew {
    @BeforeMethod
    public void preconditions(){
        new HeaderPage(driver).selectEnglishLanguage();
        new HeaderPage(driver).clickOnLoginOrRegisterLink();
    }

    @Test
    public void editProfilePositiveTest(){
        new LoginPage(driver).loginUser(UserData.EXISTED_EMAIL, UserData.EXISTED_PASSWORD);
        new HeaderPage(driver).clickOnAccount();
        new AccountPage(driver).editProfile(AddressData.FIRST_NAME, AddressData.LAST_NAME);
        Assert.assertTrue(new AccountPage(driver).getUserName().contains(AddressData.FIRST_NAME + " " + AddressData.LAST_NAME));
        Assert.assertTrue(new AccountPage(driver).checkAlert().contains("Profile updated"));
    }

    @Test
    public void logoutTest(){
        new LoginPage(driver).loginUser(UserData.EXISTED_EMAIL, UserData.EXISTED_PASSWORD);
        new HeaderPage(driver).clickOnAccount();
        new AccountPage(driver).logout();
        Assert.assertTrue(new HeaderPage(driver).isLoginLinkPresent());
    }

}
