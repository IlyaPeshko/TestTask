import by.htp.task.task_1_2_3.ui.webDriver.Driver;
import by.htp.task.task_1_2_3.ui.webDriver.DriverTypes;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void init (){
        //driver = Driver.getWebDriverInstance(DriverTypes.GC_WIN32);
        driver = Driver.getWebDriverInstance(DriverTypes.GC_MAC64);
    }

    @AfterClass
    public void cleanUp () {
        driver.close();
    }
}
