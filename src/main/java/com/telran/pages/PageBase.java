package com.telran.pages;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class PageBase {

        public WebDriver driver;

        public PageBase(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        public void click(WebElement element){
            element.click();
        }

        public void type(WebElement element, String text){
            if(text != null){
                click(element);
                element.clear();
                element.sendKeys(text);
            }
        }

        public void clickWithJSExecutor(WebElement element, int x, int y){
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(" + x + "," + y + ")");
            click(element);
        }

        public void typeWithJSExecutor(WebElement element, int x, int y, String text){
            JavascriptExecutor js = (JavascriptExecutor) driver;
            if(text != null){
                clickWithJSExecutor(element, x, y);
                element.clear();
                element.sendKeys(text);
            }
        }

        public void takeScreenshot(String pathToFile){
            File tmp = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            File screenshot = new File(pathToFile);
            try {
                Files.copy(tmp, screenshot);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void hideAd(){
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("document.getElementById('adplus-anchor').style.display = 'none'");
        }


        public void pause(int millis) {
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
}
