package by.htp.task.task_1_2_3.ui.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static by.htp.task.task_1_2_3.ui.page.Page.log;

public class UtilityImpl implements Utility{

    private static Properties properties;
    private static File file;
    private static FileReader fileReader;

    public WebDriver scrollIntoView (WebDriver driver, WebElement element) {
        log.debug("scroll...");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", element);

        return driver;
    }

    public void waitElement (WebDriver driver, WebElement element){
        log.debug("waiting...");
        WebDriverWait driverWait = new WebDriverWait(driver, 90, 1000);
        driverWait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(element)));

    }

    public static void loadData() throws IOException {
        properties = new Properties();
        file = new File(System.getProperty("user.dir")+"/src/main/resources/test.properties");
        fileReader = new FileReader(file);
        properties.load(fileReader);

    }

    public static String getObject(String data) throws IOException {
        loadData();
        String result = properties.getProperty(data);

        return result;
    }

}
