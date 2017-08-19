package by.htp.task.ui.page.task_2;

import by.htp.task.ui.page.task_2.bo.Account;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by user on 07.08.17.
 */
public class SingInPage extends Page{

    @FindBy(how= How.ID, id="identifierId")
    WebElement emailElement;

    @FindBy(how= How.ID, id="identifierNext")
    WebElement buttonElement;

    @FindBy(how= How.XPATH, xpath=".//*[@id='password']/div[1]/div/div[1]/input")
    WebElement passwordElement;

    @FindBy(how= How.ID, id="passwordNext")
    WebElement buttonPasswordNextdElement;


    public MailPage singIn(WebDriver webDriver, Account account) throws InterruptedException {
        logger("task 2");
        logger("sing in: " + account);

        webDriver.get("http://gmail.com");
        emailElement.sendKeys(account.getEmail());
        buttonElement.click();
        Thread.sleep(1000);
        passwordElement.sendKeys(account.getPassword());

        buttonPasswordNextdElement.click();

        return new MailPage();
    }
}
