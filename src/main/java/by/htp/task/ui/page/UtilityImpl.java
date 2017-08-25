package by.htp.task.ui.page;

import by.htp.task.ui.webDriver.Driver;
import by.htp.task.ui.webDriver.DriverTypes;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by user on 24.08.17.
 */
public class UtilityImpl implements Utility{

    protected WebDriver driver;
    private static JavascriptExecutor jse;
    private static final Logger log = Logger.getLogger(Utility.class);


    public WebDriver scrollPage (WebDriver driver) {
        jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        return driver;
    }

    public void logger (Object message){
        log.info(message);
        System.out.println(message);
    }

    public WebDriver init(WebDriver driver) {
        PageFactory.initElements(driver, this);
        return driver;
    }

     public WebDriver getDriverInstance (WebDriver driver) {
        PageFactory.initElements(driver, this);
        driver = Driver.getWebDriverInstance("chrome", DriverTypes.GC);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        return driver;
    }

}
