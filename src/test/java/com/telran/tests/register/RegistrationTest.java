package com.telran.tests.register;

import com.telran.data.UserData;
import com.telran.pages.AccountPage;
import com.telran.pages.HeaderPage;
import com.telran.pages.LoginPage;
import com.telran.pages.ProductsPage;
import com.telran.tests.TestBaseNew;
import com.telran.utils.DataProviders;
import com.telran.utils.model.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBaseNew {

    @BeforeMethod
    public void preconditions(){
        new HeaderPage(driver).selectEnglishLanguage();
    }

    @Test(enabled = false)
    public void registerPositiveTest(){
        new HeaderPage(driver).clickOnLoginOrRegisterLink();
        new LoginPage(driver).registerUser(UserData.EMAIL, UserData.PASSWORD, UserData.PASSWORD_CONFIRMATION);
        Assert.assertTrue(new HeaderPage(driver).checkAccount().contains("Account"));
        Assert.assertTrue(new ProductsPage(driver).checkWelcomeMessage().contains("Thanks for registering!"));
        new HeaderPage(driver).clickOnAccount();
        new AccountPage(driver).deleteProfile(UserData.PASSWORD);
    }

    @Test (dataProvider = "newUserPositiveRegisterWithCsv", dataProviderClass = DataProviders.class, enabled = false)
    public void registerFromCsvPositiveTest(User user){
        new HeaderPage(driver).clickOnLoginOrRegisterLink();
        new LoginPage(driver).registerUser(user.getEmail(), user.getPassword(), user.getConfirmPassword());
        Assert.assertTrue(new HeaderPage(driver).checkAccount().contains("Account"));
        Assert.assertTrue(new ProductsPage(driver).checkWelcomeMessage().contains("Thanks for registering!"));
        new HeaderPage(driver).clickOnAccount();
        new AccountPage(driver).deleteProfile(user.getPassword());
    }

    @Test (enabled = false)
    public void registerWithEmptyEmailFieldNegativeTest(){
        new HeaderPage(driver).clickOnLoginOrRegisterLink();
        new LoginPage(driver).registerUserWithEmptyEmail(UserData.PASSWORD, UserData.PASSWORD_CONFIRMATION);
        Assert.assertTrue(new LoginPage(driver).checkHeaderRegister().contains("Register"));
    }

    @Test (enabled = false)
    public void registerWithEmptyPasswordFieldNegativeTest(){
        new HeaderPage(driver).clickOnLoginOrRegisterLink();
        new LoginPage(driver).registerUserWithEmptPassword(UserData.EMAIL);
        Assert.assertTrue(new LoginPage(driver).checkHeaderRegister().contains("Register"));
    }

    @Test (dataProvider = "newUserNegativeEmailRegisterWithCsv", dataProviderClass = DataProviders.class, enabled = false)
    public void registerFromCsvWrongEmailNegativeTest(User user){
        new HeaderPage(driver).clickOnLoginOrRegisterLink();
        new LoginPage(driver).registerUser(user.getEmail(), user.getPassword(), user.getConfirmPassword());
        Assert.assertTrue(new LoginPage(driver).checkHeaderRegister().contains("Register"));
    }

    @Test (dataProvider = "newUserNegativePasswordRegisterWithCsv", dataProviderClass = DataProviders.class, enabled = false)
    public void registerFromCsvWrongPasswordNegativeTest(User user){
        new HeaderPage(driver).clickOnLoginOrRegisterLink();
        new LoginPage(driver).registerUser(user.getEmail(), user.getPassword(), user.getConfirmPassword());
        Assert.assertTrue(new LoginPage(driver).checkErrorMessage().contains("Oops! We found some errors"));
    }

    @Test (enabled = false)
    public void registerWithExistedUserDataNegativeTest(){
        new HeaderPage(driver).clickOnLoginOrRegisterLink();
        new LoginPage(driver).registerUser(UserData.EXISTED_EMAIL, UserData.EXISTED_PASSWORD, UserData.EXISTED_PASSWORD_CONFIRMATION);
        Assert.assertTrue(new LoginPage(driver).checkErrorMessage().contains("Oops! We found some errors"));
        Assert.assertTrue(new LoginPage(driver).checkErrorBlock().contains("email address already exists"));
    }

    @Test
    public void registerWithDifferentPasswordConfirmationValueNegativeTest(){
        new HeaderPage(driver).clickOnLoginOrRegisterLink();
        new LoginPage(driver).registerUser(UserData.EMAIL, UserData.PASSWORD, UserData.EXISTED_PASSWORD_CONFIRMATION);
        Assert.assertTrue(new LoginPage(driver).checkErrorMessage().contains("Oops! We found some errors"));
        Assert.assertTrue(new LoginPage(driver).checkErrorBlock().contains("password fields didn't match."));
    }

}
