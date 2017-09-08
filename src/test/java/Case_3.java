import by.htp.task.task_1_2_3.ui.page.task_3.HomeDeltaPage;
import by.htp.task.task_1_2_3.ui.page.task_3.bo.Combination;
import by.htp.task.task_1_2_3.ui.page.task_3.bo.Passenger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Case_3 extends BaseTest{

    @Test
    public void test () throws InterruptedException {
        HomeDeltaPage homePage = new HomeDeltaPage(driver);
        driver.get(indexURLDelta);

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
