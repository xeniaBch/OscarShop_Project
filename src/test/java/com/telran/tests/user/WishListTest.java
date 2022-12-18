package com.telran.tests.user;

import com.telran.data.UserData;
import com.telran.data.WishListData;
import com.telran.pages.*;
import com.telran.tests.TestBaseNew;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WishListTest extends TestBaseNew {

    @BeforeMethod
    public void preconditions(){
        new HeaderPage(driver).selectEnglishLanguage();
        new HeaderPage(driver).clickOnLoginOrRegisterLink();
        new LoginPage(driver).loginUser(UserData.EXISTED_EMAIL, UserData.EXISTED_PASSWORD);
        new HeaderPage(driver).clickOnAccount();
        new AccountPage(driver).selectWishList();
    }

    @Test
    public void createWishListTest(){
        new WishListPage(driver).createNewWishList(WishListData.NAME);
        Assert.assertTrue(new WishListPage(driver).checkAlert().contains("Your wishlist has been created"));
    }

    @Test
    public void viewingWishListTest(){
        new WishListPage(driver).createNewWishList(WishListData.NAME);
        new AccountPage(driver).selectWishList();
        new WishListPage(driver).viewWishListPage();
        Assert.assertTrue(new WishListPage(driver).checkHeader().contains(WishListData.NAME));
    }


    @Test
    public void updateWishListQuantityTest(){
        new WishListPage(driver).createNewWishList(WishListData.NAME);
        new HeaderPage(driver).clickOnLogo();
        new ProductsPage(driver).addToWishList();
        new WishListPage(driver).setQuantity("4");
        Assert.assertTrue(new WishListPage(driver).checkAlert().contains("Quantities updated."));
    }


    @AfterMethod
    public void deleteWishList(){
        new AccountPage(driver).selectWishList();
        new WishListPage(driver).deleteWishList();
    }
}
