package by.htp.task.ui.page.task_2;

import by.htp.task.ui.page.Page;
import by.htp.task.ui.page.task_2.bo.Account;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SingInPage extends Page {

    @FindBy(how= How.ID, id="identifierId")
    WebElement emailElement;

    @FindBy(how= How.ID, id="identifierNext")
    WebElement buttonElement;

    @FindBy(how= How.XPATH, xpath=".//*[@id='password']/div[1]/div/div[1]/input")
    WebElement passwordElement;

    @FindBy(how= How.ID, id="passwordNext")
    WebElement buttonPasswordNextElement;

    public SingInPage(WebDriver driver) {
        super(driver);
    }

    public SingInPage putEmail (Account account){
        emailElement.sendKeys(account.getEmail());

        return this;
    }

    public SingInPage clickNextGoToPassword (){
        buttonElement.click();
        return this;

    }

    public SingInPage putPassword (Account account){
        passwordElement.sendKeys(account.getPassword());

        return this;
    }

    public MailPage clickNextGoToMailPage () throws InterruptedException {
        Thread.sleep(300);
        buttonPasswordNextElement.click();

        return new MailPage(driver);
    }
}
