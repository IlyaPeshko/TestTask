package by.htp.task.ui.page.task_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class IndexTutBy extends Page{


    @FindBy(how= How.ID, id="search_from_str")
    WebElement fieldSearch;
    @FindBy(how=How.NAME, name="search")
    WebElement btnSearch;

    public SearchPage step1 (WebDriver webDriver) {
        logger("Task 1");
        webDriver.get("https://www.tut.by/");
        fieldSearch.sendKeys("automated testing");
        btnSearch.click();

        return new SearchPage ();
    }

}
