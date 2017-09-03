package by.htp.task.task_1_2_3.ui.page.task_3;

import org.openqa.selenium.WebDriver;

public class CreditCardDeltaPage extends PassengerInfoDeltaPage {

    public CreditCardDeltaPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPurchaseButtonEnabled() throws InterruptedException {
        boolean result = purchaseButtonElement.isEnabled();
        log.info(result);

        return result;

    }
}