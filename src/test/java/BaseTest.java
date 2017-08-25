import by.htp.task.ui.page.UtilityImpl;
import by.htp.task.ui.webDriver.Driver;
import by.htp.task.ui.webDriver.DriverTypes;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest extends UtilityImpl {

    @BeforeClass
    public void init (){
        logger(this.getClass()+ " initialization");

        PageFactory.initElements(driver, this);
        driver = Driver.getWebDriverInstance("chrome", DriverTypes.GC);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

    }

    @Before
    public void start () {
        driver.manage().window().fullscreen();
    }


    @AfterClass
    public void cleanUp () {

    }
}
