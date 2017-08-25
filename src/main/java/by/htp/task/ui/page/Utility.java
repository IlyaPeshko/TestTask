package by.htp.task.ui.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface Utility {

    WebDriver scrollPage (WebDriver driver);

    void logger (Object message);

    WebDriver init (WebDriver driver);

    WebDriver getDriverInstance (WebDriver driver);



}
