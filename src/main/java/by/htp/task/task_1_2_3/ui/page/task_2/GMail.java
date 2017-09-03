package by.htp.task.task_1_2_3.ui.page.task_2;

import by.htp.task.task_1_2_3.ui.page.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

class GMail extends Page {
    @FindBy(how= How.ID, id="identifierId")
    WebElement emailElement;
    @FindBy(how= How.ID, id="identifierNext")
    WebElement buttonElement;
    @FindBy(how= How.XPATH, xpath=".//*[@id='password']/div[1]/div/div[1]/input")
    WebElement passwordElement;
    @FindBy(how= How.ID, id="passwordNext")
    WebElement buttonPasswordNextElement;

    @FindBy(how= How.XPATH, xpath=".//*[@href='https://mail.google.com/mail/#sent']")
    WebElement sentElement;
    @FindBy(how= How.XPATH, xpath=".//span[@class='ait']/div")
    WebElement clickVisibleElement;
    @FindBy(how= How.XPATH, xpath=".//*[@href='https://mail.google.com/mail/#spam']")
    WebElement spamElement;
    @FindBy(how= How.XPATH, xpath=".//*[@href='https://accounts.google.com/SignOutOptions?hl=ru&continue=https://mail.google.com/mail&service=mail']")
    WebElement EElement;
    @FindBy(how= How.XPATH, css="#gb_71")
    WebElement logOutElement;
    @FindBy(how= How.XPATH, xpath=".//*[@id='gbqfq']")
    WebElement searchElement;
    @FindBy(how= How.XPATH, xpath=".//div[@role='button'][@gh='cm']")
    WebElement newMailElement;
    @FindBy(how= How.XPATH, xpath=".//textarea[@name='to']")
    WebElement inputEmailElement;
    @FindBy(how= How.XPATH, xpath=".//*[@name='subjectbox']")
    WebElement inputSubjectElement;
    @FindBy(how= How.XPATH, xpath=".//*[@role='textbox']")
    WebElement inputTextElement;
    @FindBy(how= How.XPATH, xpath=".//*[@data-tooltip-delay='800' and @role='button']")
    WebElement sentButtonElement;
    protected static final By letterCounterElement = By.xpath("//tr[@draggable='true']");

    public GMail(WebDriver driver) {
        super(driver);
    }
}
