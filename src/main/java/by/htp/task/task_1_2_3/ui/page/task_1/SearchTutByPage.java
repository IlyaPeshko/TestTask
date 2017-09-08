package by.htp.task.task_1_2_3.ui.page.task_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import java.util.List;

public class SearchTutByPage extends IndexTutByPage {

    public SearchTutByPage(WebDriver driver) {
        super(driver);
    }

    public void checkException( String target) {
        List<WebElement> list = resultElement;
        for (WebElement element : list) {
            if (element.getText().equals(target) & element.isEnabled()){
                element.click();
                isFounded = true;
            }
        }
        log.info("founded: " +list.size());
        log.info("searching on page: " + target + ": " + isFounded);

        if (!isFounded){
            throw new WebDriverException ("Minsk Automated Testing Community - not found");
        }
    }
}
