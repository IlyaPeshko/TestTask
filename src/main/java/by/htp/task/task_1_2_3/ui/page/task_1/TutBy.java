package by.htp.task.task_1_2_3.ui.page.task_1;

import by.htp.task.task_1_2_3.ui.page.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

class TutBy extends Page {
    @FindBy(how= How.ID, id="search_from_str")
    WebElement fieldSearchElement;
    @FindBy(how=How.NAME, name="search")
    WebElement btnSearchElement;
    @FindBy(how=How.XPATH, xpath=".//li[@class='b-results__li']/h3/a[2]")
    List <WebElement> resultElement;

    protected boolean isFounded = false;

    public TutBy(WebDriver driver) {
        super(driver);
    }
}
