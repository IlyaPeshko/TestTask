package by.htp.task.ui.page.task_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import java.util.List;

public class SearchPage extends Page{
    private static final By resultElement = By.xpath("//*[@class='b-results-list']/li/h3/a[2]");
    private static String target = "Minsk Automated Testing Community";
    private boolean founded = false;

    public boolean step2 (WebDriver webDriver) throws WebDriverException{
        logger("searing: Minsk Automated Testing Community");

        List<WebElement> list = webDriver.findElements(resultElement);
        for (WebElement element : list) {
            if (element.getText().equals(target)){
                element.click();
                founded = true;
            }
        }

        logger("results: " +list.size());

        try{
            if (!founded){
                throw new WebDriverException ("Minsk Automated Testing Community - not found");
            }
        }catch (WebDriverException e){
            logger(e);
        }
        return (!list.isEmpty());
    }
}
