package by.htp.task.task_1_2_3.ui.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityImpl implements Utility{

    private static final Logger log = Logger.getLogger(Utility.class);

    public WebDriver scrollIntoView (WebDriver driver, WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", element);
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

    public void waitElement (WebDriver driver, By by){
        logger("waiting...");
        WebDriverWait driverWait = new WebDriverWait(driver, 60);
        driverWait.until(ExpectedConditions.or(
                ExpectedConditions.presenceOfElementLocated(by)));
    }

}
