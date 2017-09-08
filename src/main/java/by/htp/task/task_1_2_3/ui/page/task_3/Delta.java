package by.htp.task.task_1_2_3.ui.page.task_3;

import by.htp.task.task_1_2_3.ui.page.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Delta extends Page {

    //HomeDeltaPage
    @FindBy(how= How.ID, id="originCity")
    WebElement fromElement;
    @FindBy(how= How.ID, id="destinationCity")
    WebElement toElement;
    @FindBy(how= How.ID, id="departureDate")
    WebElement departDateElement;
    @FindBy(how= How.ID, id="returnDate")
    WebElement returnDateElement;
    @FindBy(how= How.ID, id="findFlightsSubmit")
    WebElement findButtonElement;
    @FindBy(how= How.XPATH, xpath=".//span[text()='Close' and @class='ui-button-text']/ancestor::button[1]")
    WebElement closeSelectRegionElement;

    //TicketsDeltaPage
    @FindBy(how = How.XPATH, xpath = ".//*[@id='fareRowContainer_0']/tbody/tr[2]/td[2]")
    WebElement firstTicketElement;
    @FindBy(how = How.XPATH, xpath = ".//*[@id='fareRowContainer_1']/tbody/tr[2]/td[2]")
    WebElement secondTiсketElement;
    @FindBy(how = How.ID, id = "tripSummarySubmitBtn")
    WebElement continueButtonElement;
    @FindBy(how = How.XPATH, xpath = ".//*[@id='tripPriceTotals']/div/div/div[2]/span[3]")
    WebElement centTotalPriceElement;
    @FindBy(how = How.XPATH, xpath = ".//*[@id='fareRowContainer_1']/tbody/tr[2]/td[2]")
    WebElement waitSecondTicketElement;


    //TicketsDeltaPage
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
    WebElement continueButtonPassengerElement;

    //CreditCardDeltaPage
    @FindBy(how= How.ID, id="continue_button")
    WebElement purchaseButtonElement;

    public Delta(WebDriver driver) {
        super(driver);
    }
}
