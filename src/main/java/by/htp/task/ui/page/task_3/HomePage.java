package by.htp.task.ui.page.task_3;

import by.htp.task.ui.page.task_3.bo.Combination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by user on 09.08.17.
 */
public class HomePage extends Page {


    @FindBy(how= How.ID, id="originCity")
    WebElement from;

    @FindBy(how= How.ID, id="destinationCity")
    WebElement to;

    @FindBy(how= How.ID, id="departureDate")
    WebElement departDate;

    @FindBy(how= How.ID, id="returnDate")
    WebElement returnDate;

    @FindBy(how= How.ID, id="findFlightsSubmit")
    WebElement findButton;

    private static final int _SLEEP = 500;

    public TicketsPage putInfo (WebDriver driver, Combination combination) throws InterruptedException {
        logger("task 3");
        logger(combination);
        PageFactory.initElements(driver, this);
        System.out.println(combination);

        Thread.sleep(_SLEEP);
        from.clear();
        from.sendKeys(combination.getFrom());
        to.sendKeys(combination.getTo());
        departDate.sendKeys(combination.getDepartDate());
        returnDate.sendKeys(combination.getReturnDate());
        findButton.click();

        return new TicketsPage ();
    }


}
