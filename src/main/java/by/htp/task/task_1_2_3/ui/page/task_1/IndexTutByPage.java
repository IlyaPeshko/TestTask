package by.htp.task.task_1_2_3.ui.page.task_1;

import by.htp.task.task_1_2_3.ui.page.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class IndexTutByPage extends Page {

    @FindBy(how= How.ID, id="search_from_str")
    WebElement fieldSearchElement;
    @FindBy(how=How.NAME, name="search")
    WebElement btnSearchElement;

    public IndexTutByPage(WebDriver driver) {
        super(driver);
    }

    public void putRequest(String word) {
        logger("searching: " + word);
        fieldSearchElement.sendKeys(word);

    }

    public SearchPage clickSearch() {
        logger("=>");
        btnSearchElement.click();

        return new SearchPage(driver);

    }
}
