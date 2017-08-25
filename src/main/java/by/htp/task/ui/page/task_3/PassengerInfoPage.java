package by.htp.task.ui.page.task_3;

import by.htp.task.ui.page.Page;
import by.htp.task.ui.page.task_3.bo.Passenger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PassengerInfoPage extends Page {

    public PassengerInfoPage(WebDriver driver) {
        super(driver);
    }

    public CreditCardPage putPassengerInfo (WebDriver driver, Passenger passenger) throws InterruptedException {
        logger("putPassengerInfo");
        PageFactory.initElements(driver, this);

        Thread.sleep(3000);
        putPassengerName(passenger);
        putPassengerBirth(driver);
        putPassengerContactInformation(passenger);

        continueButton.click();
        return new CreditCardPage (driver);
    }

    private void putPassengerName (Passenger passenger) {
        prefix.click();
        prefixSelect.click();
        firstName.sendKeys(passenger.getFirstName());
        lastName.sendKeys(passenger.getLastName());
        declineEmergencyContact.click();
    }

    private void putPassengerBirth (WebDriver driver) throws InterruptedException {
        year.click();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", yearSelect);
        yearSelect.click();

        gender.click();
        genderSelect.click();
        month.click();
        monthSelect.click();
        day.click();
        daySelect.click();

    }

    private void putPassengerContactInformation(Passenger passenger) {
        deviceType.click();
        deviceTypeCelect.click();
        country.click();
        countrySelect.click();
        telephoneNumber.sendKeys(passenger.getPhone());
        email.sendKeys(passenger.getEmail());
        reEmail.sendKeys(passenger.getEmail());

    }

    //putPassengerName / Mr. Ivan Ivanov
    @FindBy(how= How.XPATH, xpath=".//*[@id='prefix0-button']/span[1]")
    WebElement prefix;
    @FindBy(how= How.XPATH, xpath=".//*[@id='prefix0-menu']/li[2]")
    WebElement prefixSelect;
    @FindBy(how= How.ID, id="firstName0")
    WebElement firstName;
    @FindBy(how= How.ID, id="lastName0")
    WebElement lastName;
    @FindBy(how= How.XPATH, xpath=".//*[@id='declineContactN_0']/following-sibling::span[1]")
    WebElement declineEmergencyContact;


    //putPassengerBirth / Male 4 February 1989
    @FindBy(how= How.XPATH, xpath=".//*[@id='gender0-button']/span[2]")
    WebElement gender;
    @FindBy(how= How.XPATH, xpath=".//*[@id='gender0-menu']/li[2]")
    WebElement genderSelect;
    @FindBy(how= How.XPATH, xpath=".//*[@id='day0-button']/span[2]")
    WebElement day;
    @FindBy(how= How.XPATH, xpath=".//*[@id='day0-menu']/li[5]")
    WebElement daySelect;
    @FindBy(how= How.XPATH, xpath=".//*[@id='month0-button']/span[2]")
    WebElement month;
    @FindBy(how= How.XPATH, xpath=".//*[@id='month0-menu']/li[3]")
    WebElement monthSelect;
    @FindBy(how= How.XPATH, xpath=".//*[@id='year0-button']/span[2]")
    WebElement year;
    @FindBy(how= How.XPATH, xpath=".//*[@id='year0-menu']/li[30]")
    WebElement yearSelect;


    //putPassengerContactInformation / Cell Belarus 291231212 entityfortest@gmail.com
    @FindBy(how= How.XPATH, xpath=".//*[@id='deviceType-button']/span[2]")
    WebElement deviceType;
    @FindBy(how= How.XPATH, xpath=".//*[@id='deviceType-menu']/li[1]")
    WebElement deviceTypeCelect;
    @FindBy(how= How.XPATH, xpath=".//*[@id='countryCode0-button']/span[2]")
    WebElement country;
    @FindBy(how= How.XPATH, xpath=".//*[@id='countryCode0-menu']/li[19]")
    WebElement countrySelect;
    @FindBy(how= How.ID, id="telephoneNumber0")
    WebElement telephoneNumber;
    @FindBy(how= How.ID, id="email")
    WebElement email;
    @FindBy(how= How.ID, id="reEmail")
    WebElement reEmail;

    @FindBy(how= How.ID, id="paxReviewPurchaseBtn")
    WebElement continueButton;



}
