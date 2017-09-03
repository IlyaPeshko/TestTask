package by.htp.task.task_1_2_3.ui.webDriver;

import by.htp.task.task_1_2_3.ui.webDriver.exception.UnknownDriverTypeException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Driver {

    private static final String drFF = "webdriver.gecko.driver";
    private static final String pFF = Permanent.FIREFOX_DRIVER_PATH;
    private static final String drGC = "webdriver.chrome.driver";
    private static final String pGC_MAC64 = Permanent.CHROME_DRIVER_MAC64_PATH;
    private static final String pGC_WIN32 = Permanent.CHROME_DRIVER_WIN32_PATH;
    private static Date name = new Date();

    private static HashMap<String, WebDriver> instances;
    static {
        instances = new HashMap<String, WebDriver>();
    }

    public static WebDriver getWebDriverInstance(DriverTypes driverTypes) {
        WebDriver driver;

        if (!instances.containsKey(name)) {
            switch (driverTypes) {
                case FIREFOX:
                    System.setProperty(drFF,pFF);
                    driver = new FirefoxDriver();
                    break;
                case GC_MAC64:
                    System.setProperty(drGC, pGC_MAC64);
                    driver = new ChromeDriver();
                    break;
                case GC_WIN32:
                    System.setProperty(drGC, pGC_WIN32);
                    driver = new ChromeDriver();
                    break;
                default:
                    throw new UnknownDriverTypeException("UnknownDriverTypeException" + driverTypes.getDriverName());
            }

            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
            instances.put(name.toString(), driver);

        }else {
            driver = instances.get(name);
        }
        return driver;
    }


}
