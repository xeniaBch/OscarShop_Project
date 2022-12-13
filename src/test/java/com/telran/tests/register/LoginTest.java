package com.telran.tests.register;

import com.telran.pages.HeaderPage;
import com.telran.tests.TestBaseNew;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBaseNew {

    @BeforeMethod
    public void preconditions(){
        new HeaderPage(driver).selectEnglishLanguage();
    }

    @Test
    public void loginUserPositiveTest(){

    }
}
