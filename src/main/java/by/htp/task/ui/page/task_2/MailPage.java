package by.htp.task.ui.page.task_2;

import by.htp.task.ui.page.task_2.bo.Account;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.Keys.ENTER;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 07.08.17.
 */
public class MailPage extends Page{

    private int sleep = 1000;
    private static final String sent = "https://mail.google.com/mail/#sent";
    private static final String spam = "https://mail.google.com/mail/#spam";

    @FindBy(how= How.XPATH, xpath=".//*[@href='https://mail.google.com/mail/#sent']")
    WebElement sentElement;

    @FindBy(how= How.XPATH, xpath=".//span[@class='ait']/div")
    WebElement clickVisible;

    @FindBy(how= How.XPATH, xpath=".//*[@href='https://mail.google.com/mail/#spam']")
    WebElement spamElement;

    @FindBy(how= How.XPATH, xpath=".//*[@href='https://accounts.google.com/SignOutOptions?hl=ru&continue=https://mail.google.com/mail&service=mail']")
    WebElement EElement;

    @FindBy(how= How.XPATH, xpath=".//*[@aria-label='Информация об аккаунте']/div[3]/div[2]/a")
    WebElement logOutElement;

    private static final By letterCounter = By.xpath("//tr[@draggable='true']");

    private boolean sentPage;
    private boolean spamPage;

    public void verifyPage (WebDriver webDriver) throws InterruptedException {
        logger("verifyPage");
        PageFactory.initElements(webDriver, this);

        Thread.sleep(sleep);
        //logger("inbox page "+ verifyCurrentPage(webDriver.getCurrentUrl().toString(), inbox));

        List <WebElement> listInBox = webDriver.findElements(letterCounter);
        logger("InBox letters: " + listInBox.size());

        sentElement.click();
        Thread.sleep(sleep);
        sentPage = verifyCurrentPage(webDriver.getCurrentUrl().toString(), sent);
        logger("now in sent page: "+ sentPage);

        Thread.sleep(sleep);
        webDriver.navigate().refresh();
        List <WebElement> listSent = webDriver.findElements(letterCounter);
        logger("Sent letters: "+ listSent.size());

        clickVisible.click();
        spamElement.click();
        Thread.sleep(sleep);
        spamPage = verifyCurrentPage(webDriver.getCurrentUrl().toString(), spam);
        logger("now in spam page: "+ spamPage);
        webDriver.navigate().refresh();
        List <WebElement> listSpam = webDriver.findElements(letterCounter);
        logger("Spam letters: "+ listSpam.size());

    }

    @FindBy(how= How.XPATH, xpath=".//*[@id='gbqfq']")
    WebElement searchElement;

    public int searchLetterByWord(WebDriver webDriver, String searchWord) throws InterruptedException {
        logger("searchLetterByWord");
        PageFactory.initElements(webDriver, this);
        Thread.sleep(sleep);
        logger("try find letter with '"+searchWord+"'");
        searchElement.clear();
        searchElement.sendKeys("label:inbox "+searchWord + ENTER);
        Thread.sleep(sleep);
        webDriver.navigate().refresh();

        List <WebElement> listInBox = webDriver.findElements(letterCounter);
        List <String> listInBoxString = new ArrayList<String>();

        for (WebElement element : listInBox) {
            listInBoxString.add(element.getText().toString());
        }

        logger("result: " + listInBoxString);

        return listInBoxString.size();
    }

    public void logOut (WebDriver webDriver){

        webDriver.navigate().refresh();
        EElement.click();
        logOutElement.click();
        Alert alert = webDriver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        logger("logOut");

    }

    @FindBy(how= How.XPATH, xpath=".//div[@role='button'][@gh='cm']")
    WebElement newMail;

    @FindBy(how= How.XPATH, xpath=".//*[@aria-autocomplete='list']")
    WebElement inputEmail;

    @FindBy(how= How.XPATH, xpath=".//*[@name='subjectbox']")
    WebElement inputSubject;

    @FindBy(how= How.XPATH, xpath=".//*[@role='textbox']")
    WebElement inputText;

    @FindBy(how= How.XPATH, xpath=".//*[@data-tooltip='Отправить \u202A(⌘Enter)\u202C']")
    WebElement sentButton;

    public void sentMail (WebDriver webDriver, Account account){
        logger("sent mail");
        PageFactory.initElements(webDriver, this);

        newMail.click();

        inputEmail.sendKeys(account.getEmail());
        inputSubject.sendKeys("subject");
        inputText.sendKeys("automation message");

        sentButton.click();

    }

    private static boolean verifyCurrentPage(String first, String second) {

        return verifyLink(first, second);
    }

    private static boolean verifyLink (String link, String element) {

        if (link.equals(element)){
            return true;
        }
        return false;
    }

    public boolean isSentPage() {
        return sentPage;
    }

    public boolean isSpamPage() {
        return spamPage;
    }

}
