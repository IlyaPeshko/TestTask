package by.htp.task.task_1_2_3.ui.page.task_1;

import org.openqa.selenium.WebDriver;

public class IndexTutByPage extends TutBy {

    public IndexTutByPage(WebDriver driver) {
        super(driver);
    }

    public IndexTutByPage putRequest(String word) {
        log.info(word);
        fieldSearchElement.sendKeys(word);

        return this;
    }

    public SearchTutByPage clickSearch() {
        btnSearchElement.click();

        return new SearchTutByPage(driver);

    }
}
