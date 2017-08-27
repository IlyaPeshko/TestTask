package by.htp.task.task_1_2_3.ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface Utility {

    void logger (Object message);

    WebDriver init (WebDriver driver);

    void waitElement (WebDriver driver, By by);



}
