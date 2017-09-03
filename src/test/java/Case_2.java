import by.htp.task.task_1_2_3.ui.page.task_2.MailGMailPage;
import by.htp.task.task_1_2_3.ui.page.task_2.SingInGMailPage;
import by.htp.task.task_1_2_3.ui.page.task_2.bo.Account;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Case_2 extends BaseTest {
    private static Account account = new Account("entityfortest@gmail.com", "eftversion1");
    private static final String inboxURL = "https://mail.google.com/mail/#inbox";
    private static final String sentURL = "https://mail.google.com/mail/#sent";
    private static final String spamURL = "https://mail.google.com/mail/#spam";
    private static final String indexURL = "http://gmail.com";

    @Test()
    public void test () throws InterruptedException {
        SingInGMailPage singInPage = new SingInGMailPage(driver);
        driver.get(indexURL);

        MailGMailPage mailPage = singInPage.
                putEmail(account).
                clickNextGoToPassword().
                putPassword(account).
                clickNext();

        mailPage.getQuantityLetters("InBox");
        Assert.assertTrue(mailPage.isCurrentUrl(inboxURL));

        mailPage.clickSentLetters().
                getQuantityLetters("Sent");
        Assert.assertTrue(mailPage.isCurrentUrl(sentURL));

        mailPage.clickOpenAllMenu().
                clickSpamLetters().
                getQuantityLetters("Spam");
        Assert.assertTrue(mailPage.isCurrentUrl(spamURL));

        Assert.assertTrue(mailPage.searchLetterByWord(driver,"text").
                get(0).size()==2);

        mailPage.sentMail(account).
                logOut();

    }
}
