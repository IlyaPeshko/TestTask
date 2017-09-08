package by.htp.task.task_1_2_3.ui.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface Utility {

    WebDriver scrollIntoView (WebDriver driver, WebElement element);

    void waitElement (WebDriver driver, WebElement element);
}
