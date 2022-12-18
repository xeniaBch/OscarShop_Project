package com.telran.tests.product;

import com.telran.pages.BasketPage;
import com.telran.pages.HeaderPage;
import com.telran.pages.ProductsPage;
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
}
