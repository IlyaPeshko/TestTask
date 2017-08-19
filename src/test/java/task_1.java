import by.htp.task.ui.page.task_1.IndexTutBy;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class task_1 extends BaseTest {


    @Test
    public void searchTutBy (){

        IndexTutBy page = PageFactory.initElements(driver, IndexTutBy.class);

        Assert.assertTrue(page.step1(driver).
                step2(driver));

    }

}
