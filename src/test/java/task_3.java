import by.htp.task.ui.page.task_3.HomePage;
import by.htp.task.ui.page.task_3.TicketsPage;
import by.htp.task.ui.page.task_3.bo.Combination;
import by.htp.task.ui.page.task_3.bo.Passenger;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by user on 19.08.17.
 */
public class task_3 extends BaseTest {
    private Combination combination = new Combination("JFK", "SVO", "11092017", "11142017");
    private static Passenger passenger = new Passenger("Ivan", "Ivanov", "291231212", "entityfortest@gmail.com");

    @Test
    public void booking () throws InterruptedException {
        HomePage page = new HomePage();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.delta.com/");
        page.putInfo(driver,combination).
                selectTicket(driver).
                putPassengerInfo(driver, passenger).
                checkComplitePurchseButton(driver);

        Assert.assertTrue(TicketsPage.isTotalprice());
        System.out.println(TicketsPage.isTotalprice());
    }
}
