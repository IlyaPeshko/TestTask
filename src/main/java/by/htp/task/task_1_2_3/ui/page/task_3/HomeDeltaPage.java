package by.htp.task.task_1_2_3.ui.page.task_3;

import by.htp.task.task_1_2_3.ui.page.task_3.bo.Combination;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class HomeDeltaPage extends Delta {

    public HomeDeltaPage(WebDriver driver) {
        super(driver);
    }

    public HomeDeltaPage putCombination (Combination combination){
        log.info(combination);

        fromElement.clear();
        fromElement.sendKeys(combination.getFrom());
        toElement.sendKeys(combination.getTo());
        departDateElement.sendKeys(combination.getDepartDate());
        returnDateElement.sendKeys(combination.getReturnDate());

        return this;
    }

    public TicketsDeltaPage clickFindButton(){
        findButtonElement.click();

        return new TicketsDeltaPage(driver);
    }

    public HomeDeltaPage closePopUp() {

        try {
            closeSelectRegionElement.click();
            log.info("closed");

        } catch (NoSuchElementException e) {
            log.error("didn't appear");
        }
        return this;
    }

}
