import by.htp.task.ui.page.task_1.IndexTutByPage;
import org.junit.Assert;
import org.testng.annotations.Test;

/**
 * Created by user on 24.08.17.
 */
public class Test_1 extends BaseTest {

    private static String target = "Minsk Automated Testing Community";
    private static final String indexURL = "https://www.tut.by/";

    @Test
    public void test () throws InterruptedException {
        IndexTutByPage tutBy = new IndexTutByPage(driver);
        driver.get(indexURL);
        tutBy.search("automated testing");

        Assert.assertFalse(tutBy.clickGo().findOnPage(driver, target));

    }
}
