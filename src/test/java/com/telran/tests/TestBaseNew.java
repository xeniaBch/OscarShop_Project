package com.telran.tests;

import ch.qos.logback.classic.Logger;
import com.telran.pages.PageBase;
import com.telran.tests_old.TestBase;
import com.telran.utils.MyListener;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class TestBaseNew {
    public EventFiringWebDriver driver;

    Logger logger = (Logger) LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void init(){
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("headless");
        //options.addArguments("windows-size=1200X800");
        //driver = new EventFiringWebDriver(new ChromeDriver(options));
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.manage().window().maximize();
        driver.get("https://latest.oscarcommerce.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.register(new MyListener());
    }


    @BeforeMethod
    public void startTest(Method m, Object[] o){
        logger.info("Start test with method " + m.getName() + " with data: " + Arrays.asList(o));

    }


    @AfterMethod(enabled = false)
    public void tearDown(){
        driver.quit();
    }


    @AfterMethod
    public void stopTest(ITestResult result){
        if(result.isSuccess()){
            logger.info("PASSED " + result.getMethod().getMethodName());
        }
        else {
            logger.info("FAILED " + result.getMethod().getMethodName());
            String screen = "screenshots/screen" + (System.currentTimeMillis()/1000%3600) + ".png";
            new PageBase(driver).takeScreenshot(screen);
        }

        logger.info("______________________________________");
    }
}

