package by.htp.task.task_1_2_3.ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract public class Page extends UtilityImpl {

    protected WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public Page(WebDriver driver) {
        init(driver);
    }


}
