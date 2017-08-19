package by.htp.task.ui.page.task_3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by user on 17.08.17.
 */
public class CreditCardPage extends Page {
    @FindBy(how= How.ID, id="continue_button")
    WebElement purchaseButton;

    public void checkComplitePurchseButton (WebDriver driver) throws InterruptedException {

        PageFactory.initElements(driver, this);
        Thread.sleep(2000);

        logger("Purchase button isEnabled: "+ purchaseButton.isEnabled());
        logger("Purchase button isDisplayed: " + purchaseButton.isDisplayed());
        purchaseButton.click();


    }
}
