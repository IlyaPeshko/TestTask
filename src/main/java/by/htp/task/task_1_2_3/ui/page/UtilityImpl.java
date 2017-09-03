package by.htp.task.task_1_2_3.ui.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static by.htp.task.task_1_2_3.ui.page.Page.log;

public class UtilityImpl implements Utility{

    public WebDriver scrollIntoView (WebDriver driver, WebElement element) {
        log.debug("scroll...");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", element);
        return driver;
    }

    public void waitElement (WebDriver driver, By by){
        log.debug("waiting...");
        WebDriverWait driverWait = new WebDriverWait(driver, 90);
        driverWait.until(ExpectedConditions.or(
                ExpectedConditions.presenceOfElementLocated(by)));


    }

}
