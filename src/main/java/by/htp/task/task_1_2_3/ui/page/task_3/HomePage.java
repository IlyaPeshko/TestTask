package by.htp.task.task_1_2_3.ui.page.task_3;

import by.htp.task.task_1_2_3.ui.page.Page;
import by.htp.task.task_1_2_3.ui.page.task_3.bo.Combination;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends Page {

    @FindBy(how= How.ID, id="originCity")
    WebElement fromElement;
    @FindBy(how= How.ID, id="destinationCity")
    WebElement toElement;
    @FindBy(how= How.ID, id="departureDate")
    WebElement departDateElement;
    @FindBy(how= How.ID, id="returnDate")
    WebElement returnDateElement;
    @FindBy(how= How.ID, id="findFlightsSubmit")
    WebElement findButtonElement;
    @FindBy(how= How.XPATH, xpath=".//span[text()='Close' and @class='ui-button-text']/ancestor::button[1]")
    WebElement closeSelectRegionElement;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage putCombination (Combination combination){
        logger(combination);

        fromElement.clear();
        fromElement.sendKeys(combination.getFrom());
        toElement.sendKeys(combination.getTo());
        departDateElement.sendKeys(combination.getDepartDate());
        returnDateElement.sendKeys(combination.getReturnDate());

        return this;
    }

    public TicketsPage clickFindButton(){
        findButtonElement.click();
        return new TicketsPage (driver);
    }

    public HomePage closePopUp() {
        logger("close pop up: select region");
        closeSelectRegionElement.click();
        logger("pop up is closed");

        return this;
    }

}
