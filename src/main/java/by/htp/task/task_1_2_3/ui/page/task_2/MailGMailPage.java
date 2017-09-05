package by.htp.task.task_1_2_3.ui.page.task_2;

import by.htp.task.task_1_2_3.ui.page.task_2.bo.Account;
import org.openqa.selenium.*;
import static org.openqa.selenium.Keys.ENTER;
import java.util.ArrayList;
import java.util.List;

public class MailGMailPage extends SingInGMailPage {

    protected static boolean isResult;
    protected static String driverUrl;

    public MailGMailPage(WebDriver driver) {
        super(driver);
    }

    public List getQuantityLetters(String url){
        List <WebElement> listInBox = driver.findElements(letterCounterElement);
        log.info(url + ": " + listInBox.size());
        driver.navigate().refresh();

        return listInBox;
    }

    public boolean isCurrentUrl(String currentUrl){
        driverUrl = driver.getCurrentUrl().toString();
        isResult = driverUrl.equals(currentUrl);
        log.info(isResult);

        return isResult;
    }

    public List<List<String>> getCollectionByWord(WebDriver driver, String searchWord) {
        searchElement.clear();
        searchElement.sendKeys("label:inbox "+searchWord + ENTER);
        driver.navigate().refresh();
        driver.navigate().refresh();

        List <WebElement> listInBox = driver.findElements(letterCounterElement);
        List <String> listInBoxString = new ArrayList<String>();

        for (WebElement element : listInBox) {
            listInBoxString.add(element.getText().toString());
        }

        log.info(searchWord + " / found: " + listInBoxString.size());

        List collection = new ArrayList();
        collection.add(listInBoxString);

        return collection;
    }

    public MailGMailPage sentMail (Account account){
        log.info("to: " + account.getEmail());

        newMailElement.click();
        inputEmailElement.sendKeys(account.getEmail());
        inputSubjectElement.sendKeys("subject");
        inputTextElement.sendKeys("automation message");

        sentButtonElement.click();

        return this;
    }

    public void logOut (){
        EElement.click();

        try {
            logOutElement.click();
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }catch (NoAlertPresentException e) {
            log.error(e);
            driver.navigate().refresh();
            EElement.click();
            logOutElement.click();
        }

        log.info("");
    }

    public MailGMailPage clickSentLetters (){
        sentElement.click();

        return this;
    }

    public MailGMailPage clickSpamLetters (){
        spamElement.click();

        return this;
    }

    public MailGMailPage clickOpenAllMenu() {
        clickVisibleElement.click();

        return this;
    }
}
