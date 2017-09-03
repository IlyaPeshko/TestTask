import by.htp.task.task_1_2_3.ui.page.task_1.IndexTutByPage;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.Test;

public class Case_1 extends BaseTest {

    private static String target = "Minsk Automated Testing Community";
    private static final String indexURL = "https://www.tut.by/";
    private static final String request = "automated testing";

    @Test(expectedExceptions = {WebDriverException.class})
    public void test() {
        IndexTutByPage tutBy = new IndexTutByPage(driver);
        driver.get(indexURL);
        tutBy.putRequest(request).
                clickSearch().
                checkException(target);

    }
}
