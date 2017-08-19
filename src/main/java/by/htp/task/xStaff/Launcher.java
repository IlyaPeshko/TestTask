package by.htp.task.xStaff;

import by.htp.task.ui.page.task_1.IndexTutBy;
import by.htp.task.ui.page.task_2.MailPage;
import by.htp.task.ui.page.task_2.SingInPage;
import by.htp.task.ui.page.task_2.bo.Account;
import by.htp.task.ui.page.task_3.HomePage;

import by.htp.task.ui.page.task_3.bo.Combination;
import by.htp.task.ui.page.task_3.bo.Passenger;
import by.htp.task.ui.webDriver.Driver;
import by.htp.task.ui.webDriver.DriverTypes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class Launcher {

    private WebDriver driver = Driver.getWebDriverInstance("Google Chrome", DriverTypes.GC);
    private static Account account = new Account("entityfortest@gmail.com", "eftversion1");

    private Combination combination = new Combination("JFK", "SVO", "11092017", "11142017");
    private static Passenger passenger = new Passenger("Ivan", "Ivanov", "291231212", "reggae.straight@gmail.com");

    public static void main(String[] args) throws Exception {
        Launcher launcher = new Launcher();
        //launcher.task_1();
        launcher.task_2();
        //launcher.task_3();

    }

    private void task_1 () throws InterruptedException {

        IndexTutBy page = PageFactory.initElements(driver, IndexTutBy.class);
        page.step1(driver).
                step2(driver);

    }

    private void task_2() throws InterruptedException {

        SingInPage page = PageFactory.initElements(driver, SingInPage.class);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        MailPage mailPage = page.singIn(driver, account);
        mailPage.verifyPage(driver);
        mailPage.sentMail(driver, account);
        System.out.println("searchLetterByWord " + mailPage.searchLetterByWord(driver, "text"));
        mailPage.logOut(driver);

    }

    private void task_3 () throws InterruptedException{
        HomePage page = new HomePage();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.delta.com/");
        page.putInfo(driver,combination).
                selectTicket(driver).
                putPassengerInfo(driver, passenger).
                checkComplitePurchseButton(driver);

    }

}
