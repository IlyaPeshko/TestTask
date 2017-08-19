
import by.htp.task.ui.page.task_2.MailPage;
import by.htp.task.ui.page.task_2.SingInPage;
import by.htp.task.ui.page.task_2.bo.Account;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by user on 18.08.17.
 */
public class task_2 extends BaseTest{
    private static Account account = new Account("entityfortest@gmail.com", "eftversion1");

    @Test
    public void verifyPage () throws InterruptedException {
        SingInPage page = PageFactory.initElements(driver, SingInPage.class);
        MailPage mailPage = page.singIn(driver, account);

        mailPage.verifyPage(driver);
        Assert.assertTrue(mailPage.isSentPage());
        Assert.assertTrue(mailPage.isSpamPage());

        mailPage.sentMail(driver, account);

        Assert.assertTrue(mailPage.searchLetterByWord(driver, "text") == 5);

        mailPage.logOut(driver);
    }


}
