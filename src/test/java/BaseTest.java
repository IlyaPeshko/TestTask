import by.htp.task.task_1_2_3.ui.webDriver.Driver;
import by.htp.task.task_1_2_3.ui.webDriver.DriverTypes;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class BaseTest extends Property {

    protected WebDriver driver;

    @BeforeClass
    public void init () throws IOException {
        initProperties();
        driver = Driver.getWebDriverInstance(DriverTypes.valueOf(driverType));
        driver.manage().window().maximize();

    }

    @AfterClass
    public void cleanUp () {
        driver.close();
    }

}
