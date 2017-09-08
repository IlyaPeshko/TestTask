import by.htp.task.task_1_2_3.ui.page.task_1.IndexTutByPage;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.Test;

import java.io.IOException;

public class Case_1 extends BaseTest {

    @Test(expectedExceptions = {WebDriverException.class})
    public void test() throws IOException {
        IndexTutByPage tutBy = new IndexTutByPage(driver);
        driver.get(indexURLTutBy);
        tutBy.putRequest(requestTutBy).
                clickSearch().
                checkException(targetTutBy);

    }
}
