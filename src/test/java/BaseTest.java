import by.htp.task.task_1_2_3.ui.page.UtilityImpl;
import by.htp.task.task_1_2_3.ui.webDriver.Driver;
import by.htp.task.task_1_2_3.ui.webDriver.DriverTypes;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest extends UtilityImpl {

    protected WebDriver driver;

    @BeforeClass
    public void init (){
        logger(this.getClass()+ " initialization");
        driver = Driver.getWebDriverInstance("chrome", DriverTypes.GC);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
        init(driver);
    }

    @Before
    public void start () {
        driver.manage().window().fullscreen();
    }


    @AfterClass
    public void cleanUp () {
        //driver.close();
    }
}
