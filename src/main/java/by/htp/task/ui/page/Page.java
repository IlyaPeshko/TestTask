package by.htp.task.ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract public class Page extends UtilityImpl {

    public WebDriver getDriver() {
        return driver;
    }

    public Page(WebDriver driver) {
        init(driver);
    }

    public void waitPage () {
        //driver.navigate().refresh();
        WebElement element = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(".//span[@class='ait']/div")));
    }




}
