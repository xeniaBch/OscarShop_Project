package com.telran.tests.product;

import com.telran.data.ReviewData;
import com.telran.data.UserData;
import com.telran.data.WishListData;
import com.telran.pages.*;
import com.telran.tests.TestBaseNew;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProductTest extends TestBaseNew {

    @BeforeMethod
    public void preconditions(){
        new HeaderPage(driver).selectEnglishLanguage();
    }

    @Test
    public void checkAllPageLink(){
        SoftAssert asrt = new SoftAssert();
        asrt.assertTrue(new ProductsPage(driver).isClothingLinkPresent());
        asrt.assertTrue(new ProductsPage(driver).isBooksLinkPresent());
        asrt.assertTrue(new ProductsPage(driver).isFictionLinkPresent());
        asrt.assertTrue(new ProductsPage(driver).isComputersInLiteratureLinkPresent());
        asrt.assertTrue(new ProductsPage(driver).isNonFictionLinkPresent());
        asrt.assertTrue(new ProductsPage(driver).isNonFictionLinkPresent());
        asrt.assertTrue(new ProductsPage(driver).isEssentialProgrammingLinkPresent());
        asrt.assertTrue(new ProductsPage(driver).isHackingLinkPresent());
    }

    @Test
    public void checkAddToBasketPositiveTest(){
        new ProductsPage(driver).addToBasket();
        new HeaderPage(driver).viewBasketNew();
        new BasketPage(driver).proceedToCheckout();
        Assert.assertTrue(new BasketPage(driver).checkUserUnregistered().contains("Who are you?"));
    }

    @Test
    public void checkNextPageTest(){
        new ProductsPage(driver).clickOnNextButton();
        Assert.assertTrue(new ProductsPage(driver).getCurrentPage().contains("2"));
    }

    @Test
    public void checkPreviousPageTest(){
        new ProductsPage(driver).clickOnNextButton();
        new ProductsPage(driver).clickOnPreviousButton();
        Assert.assertTrue(new ProductsPage(driver).getCurrentPage().contains("1"));
    }

    @Test
    public void addToWishListPositiveTest(){
        new HeaderPage(driver).clickOnLoginOrRegisterLink();
        new LoginPage(driver).loginUser(UserData.EXISTED_EMAIL, UserData.EXISTED_PASSWORD);
        new HeaderPage(driver).clickOnAccount();
        new AccountPage(driver).selectWishList();
        new WishListPage(driver).createNewWishList(WishListData.NAME);
        new HeaderPage(driver).clickOnLogo();
        new ProductsPage(driver).addToWishList();
        Assert.assertTrue(new WishListPage(driver).isProductAdded().contains("The shellcoder's handbook"));
        new AccountPage(driver).selectWishList();
        new WishListPage(driver).deleteWishList();
    }

    @Test
    public void leaveReviewPositiveTest(){
        new HeaderPage(driver).clickOnLoginOrRegisterLink();
        new LoginPage(driver).loginUser(UserData.EXISTED_EMAIL, UserData.EXISTED_PASSWORD);
        new HeaderPage(driver).clickOnLogo();
        new ProductsPage(driver).leaveReview(ReviewData.TITLE, ReviewData.BODY);
        Assert.assertTrue(new ProductsPage(driver).isReviewed());
    }

}
