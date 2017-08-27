package by.htp.task.task_1_2_3.ui.page.task_1;

import by.htp.task.task_1_2_3.ui.page.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import java.util.List;

public class SearchPage extends Page {
    private static final By resultElement = By.xpath("//*[@class='b-results-list']/li/h3/a[2]");
    private boolean isFounded = false;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void checkException(WebDriver webDriver, String target) {
        List<WebElement> list = webDriver.findElements(resultElement);
        for (WebElement element : list) {
            if (element.getText().equals(target) & element.isEnabled()){
                element.click();
                isFounded = true;
            }
        }
        logger("founded: " +list.size());
        logger("searching on page: " + target + " / " + isFounded);

        if (!isFounded){
            throw new WebDriverException ("Minsk Automated Testing Community - not found");
        }
    }
}
