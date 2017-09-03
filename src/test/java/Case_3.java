import by.htp.task.task_1_2_3.ui.page.task_3.HomeDeltaPage;
import by.htp.task.task_1_2_3.ui.page.task_3.bo.Combination;
import by.htp.task.task_1_2_3.ui.page.task_3.bo.Passenger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Case_3 extends BaseTest{
    private static final String indexURL = "https://www.delta.com/";
    private Combination combination = new Combination("JFK", "SVO", "11092017", "11142017");
    private static Passenger passenger = new Passenger("Ivan", "Ivanov", "291231212", "entityfortest@gmail.com");

    @Test
    public void test () throws InterruptedException {
        HomeDeltaPage homePage = new HomeDeltaPage(driver);
        driver.get(indexURL);

        boolean result = homePage.closePopUp().
                putCombination(combination).
                clickFindButton().
                selectTickets().
                clickContinueButton().
                putPassengerName(passenger).
                putPassengerBirth().
                putPassengerContactInformation(passenger).
                clickContinueButton().
                isPurchaseButtonEnabled();

        Assert.assertTrue(result);
    }
}
