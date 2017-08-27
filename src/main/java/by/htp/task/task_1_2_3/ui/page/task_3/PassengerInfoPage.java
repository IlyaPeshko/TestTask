package by.htp.task.task_1_2_3.ui.page.task_3;

import by.htp.task.task_1_2_3.ui.page.Page;
import by.htp.task.task_1_2_3.ui.page.task_3.bo.Passenger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PassengerInfoPage extends Page {

    //putPassengerName / Mr. Ivan Ivanov
    @FindBy(how= How.XPATH, xpath=".//*[@id='prefix0-button']/span[1]")
    WebElement prefixElement;
    @FindBy(how= How.XPATH, xpath=".//*[@id='prefix0-menu']/li[2]")
    WebElement prefixSelectElement;
    @FindBy(how= How.ID, id="firstName0")
    WebElement firstNameElement;
    @FindBy(how= How.ID, id="lastName0")
    WebElement lastNameElement;
    @FindBy(how= How.XPATH, xpath=".//*[@id='declineContactN_0']/following-sibling::span[1]")
    WebElement declineEmergencyContactElement;

    //putPassengerBirth / Male 4 February 1989
    @FindBy(how= How.XPATH, xpath=".//*[@id='gender0-button']/span[2]")
    WebElement genderElement;
    @FindBy(how= How.XPATH, xpath=".//*[@id='gender0-menu']/li[2]")
    WebElement genderSelectElement;
    @FindBy(how= How.XPATH, xpath=".//*[@id='day0-button']/span[2]")
    WebElement dayElement;
    @FindBy(how= How.XPATH, xpath=".//*[@id='day0-menu']/li[5]")
    WebElement daySelectElement;
    @FindBy(how= How.XPATH, xpath=".//*[@id='month0-button']/span[2]")
    WebElement monthElement;
    @FindBy(how= How.XPATH, xpath=".//*[@id='month0-menu']/li[3]")
    WebElement monthSelectElement;
    @FindBy(how= How.XPATH, xpath=".//*[@id='year0-button']/span[2]")
    WebElement yearElement;
    @FindBy(how= How.XPATH, xpath=".//*[@id='year0-menu']/li[30]")
    WebElement yearSelectElement;

    //putPassengerContactInformation / Cell Belarus 291231212 entityfortest@gmail.com
    @FindBy(how= How.XPATH, xpath=".//*[@id='deviceType-button']/span[2]")
    WebElement deviceTypeElement;
    @FindBy(how= How.XPATH, xpath=".//*[@id='deviceType-menu']/li[1]")
    WebElement deviceTypeSelectElement;
    @FindBy(how= How.XPATH, xpath=".//*[@id='countryCode0-button']/span[2]")
    WebElement countryElement;
    @FindBy(how= How.XPATH, xpath=".//*[@id='countryCode0-menu']/li[19]")
    WebElement countrySelectElement;
    @FindBy(how= How.ID, id="telephoneNumber0")
    WebElement telephoneNumberElement;
    @FindBy(how= How.ID, id="email")
    WebElement emailElement;
    @FindBy(how= How.ID, id="reEmail")
    WebElement reEmailElement;

    @FindBy(how= How.ID, id="paxReviewPurchaseBtn")
    WebElement continueButtonElement;


    public PassengerInfoPage(WebDriver driver) {
        super(driver);
    }

    public PassengerInfoPage putPassengerName (WebDriver driver,Passenger passenger) {
        logger("putPassengerName: " + passenger);
        init(driver);
        prefixElement.click();
        prefixSelectElement.click();
        firstNameElement.sendKeys(passenger.getFirstName());
        lastNameElement.sendKeys(passenger.getLastName());
        declineEmergencyContactElement.click();

        return this;
    }

    public PassengerInfoPage putPassengerBirth (WebDriver driver) throws InterruptedException {
        logger("putPassengerBirth");

        yearElement.click();
        scrollIntoView(driver, yearSelectElement);
        yearSelectElement.click();

        genderElement.click();
        genderSelectElement.click();
        monthElement.click();
        monthSelectElement.click();
        dayElement.click();
        daySelectElement.click();

        return this;
    }

    public PassengerInfoPage putPassengerContactInformation(Passenger passenger) {
        logger("putPassengerContactInformation");
        deviceTypeElement.click();
        deviceTypeSelectElement.click();
        countryElement.click();
        countrySelectElement.click();
        telephoneNumberElement.sendKeys(passenger.getPhone());
        emailElement.sendKeys(passenger.getEmail());
        reEmailElement.sendKeys(passenger.getEmail());

        return this;
    }

    public CreditCardPage clickContinueButton () {
        continueButtonElement.click();

        return new CreditCardPage(driver);
    }
}
