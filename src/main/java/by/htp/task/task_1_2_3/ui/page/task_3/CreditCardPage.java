package by.htp.task.task_1_2_3.ui.page.task_3;

import by.htp.task.task_1_2_3.ui.page.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CreditCardPage extends Page {
    @FindBy(how= How.ID, id="continue_button")
    WebElement purchaseButtonElement;

    public CreditCardPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkCompletePurchaseButton(WebDriver driver) throws InterruptedException {
        PageFactory.initElements(driver, this);

        boolean result = purchaseButtonElement.isEnabled();
        logger("Purchase button isEnabled: "+ result);

        return result;

    }
}
