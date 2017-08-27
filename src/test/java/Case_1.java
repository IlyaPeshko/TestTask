import by.htp.task.task_1_2_3.ui.page.task_1.IndexTutByPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.Test;

/**
 * Created by user on 24.08.17.
 */
public class Case_1 extends BaseTest {

    private static String target = "Minsk Automated Testing Community";
    private static final String indexURL = "https://www.tut.by/";

    @Test(expectedExceptions = { WebDriverException.class})
    public void test() throws Exception {
        IndexTutByPage tutBy = new IndexTutByPage(driver);
        driver.get(indexURL);
        tutBy.putRequest("automated testing");

        tutBy.clickSearch().checkException(driver, target);
        throw new Exception();
    }


}
