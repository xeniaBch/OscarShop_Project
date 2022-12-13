package com.telran.tests.register;

import com.telran.pages.AccountPage;
import com.telran.pages.HeaderPage;
import com.telran.pages.LoginPage;
import com.telran.tests.TestBaseNew;
import com.telran.utils.DataProviders;
import com.telran.utils.model.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AccountTest extends TestBaseNew {
    @BeforeMethod
    public void preconditions(){
        new HeaderPage(driver).selectEnglishLanguage();
        new HeaderPage(driver).clickOnLoginOrRegisterLink();

    }



    @Test (dataProvider = "newUserPositiveRegisterWithCsv", dataProviderClass = DataProviders.class, enabled = false)
    public void deletePositiveTest(User user){
        new LoginPage(driver).loginUser(user.getEmail(), user.getPassword());
        new HeaderPage(driver).clickOnAccount();
        new AccountPage(driver).deleteProfile(user.getPassword());
    }
}
