import by.htp.task.ui.page.task_2.MailPage;
import by.htp.task.ui.page.task_2.SingInPage;
import by.htp.task.ui.page.task_2.bo.Account;
import org.junit.Assert;
import org.testng.annotations.Test;

/**
 * Created by user on 24.08.17.
 */
public class Test_2 extends BaseTest {
    private static Account account = new Account("entityfortest@gmail.com", "eftversion1");
    private static final String inboxURL = "https://mail.google.com/mail/#inbox";
    private static final String sentURL = "https://mail.google.com/mail/#sent";
    private static final String spamURL = "https://mail.google.com/mail/#spam";
    private static final String indexURL = "http://gmail.com";
    private MailPage mailPage;

    @Test(priority = 1)
    public void singIn () throws InterruptedException {
        SingInPage singInPage = new SingInPage(driver);
        driver.get(indexURL);
        singInPage.
                putEmail(account).
                clickNextGoToPassword().
                putPassword(account).
                clickNextGoToMailPage();

    }

    @Test(priority = 2)
    public void verifyPage (){
        mailPage = new MailPage(driver);
        mailPage.checkQuantityLetters("InBox", driver);
        Assert.assertTrue(mailPage.verifyPage(driver, inboxURL));

        mailPage.clickSentLetters();
        mailPage.checkQuantityLetters("Sent", driver);
        Assert.assertTrue(mailPage.verifyPage(driver, sentURL));

        mailPage.clickOpenAllMenu().clickSpamLetters();
        mailPage.checkQuantityLetters("Spam", driver);
        Assert.assertTrue(mailPage.verifyPage(driver, spamURL));
    }

    @Test(priority = 3)
    public void verifySearch () {
        Assert.assertTrue(mailPage.searchLetterByWord(driver,"text").
                get(0).size()==2);

    }

    @Test(priority = 4)
    public void sentLetter () {
        mailPage.sentMail(account);
    }

    @Test(priority = 5)
    public void singOut () {
        mailPage.logOut(driver);
    }

}
