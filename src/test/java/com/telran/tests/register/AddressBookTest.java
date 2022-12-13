package com.telran.tests.register;

import com.telran.data.AddressData;
import com.telran.data.UserData;
import com.telran.pages.AccountPage;
import com.telran.pages.AddressBookPage;
import com.telran.pages.HeaderPage;
import com.telran.pages.LoginPage;
import com.telran.tests.TestBaseNew;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddressBookTest extends TestBaseNew {

    @BeforeMethod
    public void preconditions(){
        new HeaderPage(driver).selectEnglishLanguage();
        new HeaderPage(driver).clickOnLoginOrRegisterLink();
        new LoginPage(driver).loginUser(UserData.EXISTED_EMAIL, UserData.EXISTED_PASSWORD);
        new HeaderPage(driver).clickOnAccount();
        new AccountPage(driver).selectAddressBook();
    }

    @Test
    public void createAddressBookPositiveTest(){
        new AddressBookPage(driver).addNewAddress(AddressData.FIRST_NAME, AddressData.LAST_NAME, AddressData.FIRST_LINE_OF_ADDRESS,
                AddressData.CITY, AddressData.ZIP_CODE, AddressData.PHONE, AddressData.INSTRUCTION);
        Assert.assertTrue(new AddressBookPage(driver).checkMessage().contains("created"));
    }

    @Test
    public void editAddressBookPositiveTest(){
        new AddressBookPage(driver).addNewAddress(AddressData.FIRST_NAME, AddressData.LAST_NAME, AddressData.FIRST_LINE_OF_ADDRESS,
                AddressData.CITY, AddressData.ZIP_CODE, AddressData.PHONE, AddressData.INSTRUCTION);
        new AddressBookPage(driver).editAddress(AddressData.FIRST_NAME_EDITED, AddressData.FIRST_LINE_OF_ADDRESS_EDITED);
        Assert.assertTrue(new AddressBookPage(driver).checkMessage().contains("updated"));
        Assert.assertTrue(new AddressBookPage(driver).checkMessage().contains(AddressData.FIRST_NAME_EDITED));
        Assert.assertTrue(new AddressBookPage(driver).checkMessage().contains(AddressData.FIRST_LINE_OF_ADDRESS_EDITED));
    }

    @AfterMethod
    public void deleteAddress(){
        new AddressBookPage(driver).deleteAddress();
    }
}
