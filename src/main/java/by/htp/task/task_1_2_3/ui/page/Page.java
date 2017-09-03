package by.htp.task.task_1_2_3.ui.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

abstract public class Page extends UtilityImpl {

    public static final Logger log = Logger.getLogger(Page.class);

    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        log.info(this.getClass().getSimpleName());
    }

    public WebDriver getDriver() {
        return driver;

    }


}
