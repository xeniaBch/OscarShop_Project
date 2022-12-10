package com.telran.utils;

import com.telran.pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyListener extends AbstractWebDriverEventListener {
    Logger logger = LoggerFactory.getLogger(MyListener.class);

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        logger.info("Start find element -->" + by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        logger.info("Element with locator" + by + "was found");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        logger.info("We have throwable -->" + throwable.getMessage());
        logger.info("We have throwable -->" + throwable.getCause());
        logger.info("We have throwable -->" + throwable.getCause());
        int index = (int) ((System.currentTimeMillis() / 1000) % 3600);
        String link = "screenshots/screen" + index + ".png";

        PageBase base = new PageBase(driver);
        base.takeScreenshot(link);
        logger.info("Your screenshot is here "+ link);

    }

    public MyListener(){
        super();
    }
}
