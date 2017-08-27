import by.htp.task.task_1_2_3.ui.page.task_3.CreditCardPage;
import by.htp.task.task_1_2_3.ui.page.task_3.HomePage;
import by.htp.task.task_1_2_3.ui.page.task_3.PassengerInfoPage;
import by.htp.task.task_1_2_3.ui.page.task_3.TicketsPage;
import by.htp.task.task_1_2_3.ui.page.task_3.bo.Combination;
import by.htp.task.task_1_2_3.ui.page.task_3.bo.Passenger;
import org.junit.Assert;
import org.testng.annotations.Test;

/**
 * Created by user on 25.08.17.
 */
public class Case_3 extends BaseTest{
    private static final String indexURL = "https://www.delta.com/#";
    private Combination combination = new Combination("JFK", "SVO", "11092017", "11142017");
    private static Passenger passenger = new Passenger("Ivan", "Ivanov", "291231212", "entityfortest@gmail.com");

    @Test
    public void test () throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        driver.get(indexURL);

        try {
            homePage.closePopUp();
        }catch (Exception e){
            logger("pop up didn't appear ");
        }

        homePage.putCombination(combination);

        TicketsPage ticketsPage = homePage.clickFindButton();
        ticketsPage.selectTickets(driver);
        Assert.assertTrue(ticketsPage.checkTicketsSum(driver));

        PassengerInfoPage passengerInfoPage = ticketsPage.clickContinueButton();
        passengerInfoPage.putPassengerName(driver, passenger).
                putPassengerBirth(driver).
                putPassengerContactInformation(passenger);

        CreditCardPage creditCardPage = passengerInfoPage.clickContinueButton();
        Assert.assertTrue(creditCardPage.checkCompletePurchaseButton(driver));

        driver.close();
    }
}
