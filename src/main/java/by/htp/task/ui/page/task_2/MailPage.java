package by.htp.task.ui.page.task_2;

import by.htp.task.ui.page.Page;
import by.htp.task.ui.page.task_2.bo.Account;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.openqa.selenium.Keys.ENTER;

import java.util.ArrayList;
import java.util.List;

public class MailPage extends Page {

    private int sleep = 1000;
    private static final String sentURL = "https://mail.google.com/mail/#sent";
    private static final String spamURL = "https://mail.google.com/mail/#spam";
    private static final By letterCounter = By.xpath("//tr[@draggable='true']");
    private static boolean result;
    private static String driverUrl;

    @FindBy(how= How.XPATH, xpath=".//*[@href='https://mail.google.com/mail/#sent']")
    WebElement sentElement;
    @FindBy(how= How.XPATH, xpath=".//span[@class='ait']/div")
    WebElement clickVisibleElement;
    @FindBy(how= How.XPATH, xpath=".//*[@href='https://mail.google.com/mail/#spam']")
    WebElement spamElement;
    @FindBy(how= How.XPATH, xpath=".//*[@href='https://accounts.google.com/SignOutOptions?hl=ru&continue=https://mail.google.com/mail&service=mail']")
    WebElement EElement;
    @FindBy(how= How.XPATH, xpath=".//*[@aria-label='Информация об аккаунте']/div[3]/div[2]/a")
    WebElement logOutElement;
    @FindBy(how= How.XPATH, xpath=".//*[@id='gbqfq']")
    WebElement searchElement;

    @FindBy(how= How.XPATH, xpath=".//div[@role='button'][@gh='cm']")
    WebElement newMailElement;
    @FindBy(how= How.XPATH, xpath=".//*[@aria-autocomplete='list']")
    WebElement inputEmailElement;
    @FindBy(how= How.XPATH, xpath=".//*[@name='subjectbox']")
    WebElement inputSubjectElement;
    @FindBy(how= How.XPATH, xpath=".//*[@role='textbox']")
    WebElement inputTextElement;
    @FindBy(how= How.XPATH, xpath=".//*[@data-tooltip='Отправить \u202A(⌘Enter)\u202C']")
    WebElement sentButtonElement;


    public MailPage(WebDriver driver) {
        super(driver);
    }

    public List checkQuantityLetters (String log, WebDriver driver){
        List <WebElement> listInBox = driver.findElements(letterCounter);
        logger(log + " : " + listInBox.size());

        driver.navigate().refresh();

        return listInBox;
    }

    public boolean verifyPage (WebDriver driver, String currentUrl){
        driverUrl = driver.getCurrentUrl().toString();
        logger("comparing: " + driverUrl  + " AND " + currentUrl);
        result = driverUrl.equals(currentUrl);
        logger("result: " + result);

        return result;
    }

    public List<List<String>> searchLetterByWord(WebDriver driver, String searchWord) {
        logger("try find letter with '"+searchWord+"'");
        searchElement.clear();
        searchElement.sendKeys("label:inbox "+searchWord + ENTER);
        driver.navigate().refresh();
        driver.navigate().refresh();

        List <WebElement> listInBox = driver.findElements(letterCounter);
        List <String> listInBoxString = new ArrayList<String>();

        for (WebElement element : listInBox) {
            listInBoxString.add(element.getText().toString());
        }

        logger("found: " + listInBoxString.size());

        List collection = new ArrayList();
        collection.add(listInBoxString);

        return collection;
    }

    public MailPage sentMail (Account account){
        logger("sent mail to " + account.getEmail());
        newMailElement.click();

        inputEmailElement.sendKeys(account.getEmail());
        inputSubjectElement.sendKeys("subject");
        inputTextElement.sendKeys("automation message");

        sentButtonElement.click();

        return this;
    }

    public void logOut (WebDriver driver){
        EElement.click();

        try {
            logOutElement.click();
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }catch (UnhandledAlertException e) {
            logger(e);
            driver.navigate().refresh();
            EElement.click();
            logOutElement.click();
        }

        logger("logOut");
    }

    public MailPage clickSentLetters (){
        sentElement.click();

        return this;
    }

    public MailPage clickSpamLetters (){
        spamElement.click();

        return this;
    }

    public MailPage clickOpenAllMenu() {
        clickVisibleElement.click();

        return this;
    }
}
