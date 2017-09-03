package by.htp.task.task_1_2_3.ui.page.task_3;

import by.htp.task.task_1_2_3.ui.page.task_3.bo.Passenger;
import org.openqa.selenium.WebDriver;

public class PassengerInfoDeltaPage extends TicketsDeltaPage {

    public PassengerInfoDeltaPage(WebDriver driver) {
        super(driver);
    }

    public PassengerInfoDeltaPage putPassengerName (Passenger passenger) {
        log.info(passenger);
        prefixElement.click();
        prefixSelectElement.click();
        firstNameElement.sendKeys(passenger.getFirstName());
        lastNameElement.sendKeys(passenger.getLastName());
        declineEmergencyContactElement.click();

        return this;
    }

    public PassengerInfoDeltaPage putPassengerBirth () throws InterruptedException {
        log.info("Male 4 February 1989");
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

    public PassengerInfoDeltaPage putPassengerContactInformation(Passenger passenger) {
        deviceTypeElement.click();
        deviceTypeSelectElement.click();
        countryElement.click();
        countrySelectElement.click();
        telephoneNumberElement.sendKeys(passenger.getPhone());
        emailElement.sendKeys(passenger.getEmail());
        reEmailElement.sendKeys(passenger.getEmail());

        return this;
    }

    public CreditCardDeltaPage clickContinueButton () {
        continueButtonPassengerElement.click();

        return new CreditCardDeltaPage(driver);
    }
}
