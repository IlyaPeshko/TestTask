import by.htp.task.task_1_2_3.ui.page.task_3.HomeDeltaPage;
import by.htp.task.task_1_2_3.ui.page.task_3.bo.Combination;
import by.htp.task.task_1_2_3.ui.page.task_3.bo.Passenger;
import by.htp.task.task_1_2_3.ui.webDriver.Driver;
import by.htp.task.task_1_2_3.ui.webDriver.DriverTypes;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Created by user on 05.09.17.
 */
public class Circle {
    private static final String indexURL = "https://www.delta.com/";
    private Combination combination = new Combination("JFK", "SVO", "11092017", "11142017");
    private static Passenger passenger = new Passenger("Ivan", "Ivanov", "291231212", "entityfortest@gmail.com");
    private WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        Circle circle = new Circle();
        for (int i=0; i<30; i++){
            circle.test3();
        }
    }

    public void test3 () throws InterruptedException {
        driver = Driver.getWebDriverInstance(DriverTypes.GC_MAC64);
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
        driver.close();
    }
}
