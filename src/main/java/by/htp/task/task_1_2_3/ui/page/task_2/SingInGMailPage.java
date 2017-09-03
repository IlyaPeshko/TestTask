package by.htp.task.task_1_2_3.ui.page.task_2;

import by.htp.task.task_1_2_3.ui.page.task_2.bo.Account;
import org.openqa.selenium.*;

public class SingInGMailPage extends GMail {

    public SingInGMailPage(WebDriver driver) {
        super(driver);
    }

    public SingInGMailPage putEmail (Account account){
        emailElement.sendKeys(account.getEmail());

        return this;
    }

    public SingInGMailPage clickNextGoToPassword (){
        buttonElement.click();

        return this;
    }

    public SingInGMailPage putPassword (Account account){
        passwordElement.sendKeys(account.getPassword());

        return this;
    }

    public MailGMailPage clickNext() throws InterruptedException {
        Thread.sleep(100);
        buttonPasswordNextElement.click();

        return new MailGMailPage(driver);
    }
}
