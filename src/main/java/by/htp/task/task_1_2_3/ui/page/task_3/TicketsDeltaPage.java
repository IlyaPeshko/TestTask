package by.htp.task.task_1_2_3.ui.page.task_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;

public class TicketsDeltaPage extends HomeDeltaPage {

    public TicketsDeltaPage(WebDriver driver) {
        super(driver);
    }

    public TicketsDeltaPage selectTickets() {
        log.info("first...");
        firstTicketElement.click();

        waitElement(driver, waitSecondTicketElement);
        log.info("second...");
        secondTiсketElement.click();

        if (!isTicketsSum())
            log.warn("Total and sum of tickets is different");

        return this;
    }

    public PassengerInfoDeltaPage clickContinueButton () {
        continueButtonElement.click();

        return new PassengerInfoDeltaPage(driver);
    }

    private boolean isTicketsSum() {
        PageFactory.initElements(driver, this);
        List<WebElement> priceDollar = driver.findElements(By.xpath(".//*[@class='txtInteger currencyInt']"));
        List<WebElement> priceCent = driver.findElements(By.xpath(".//*[@class='txtInteger currencyInt']/following-sibling::span[2]"));
        ArrayList<Double> list = new ArrayList();
        int dollar;
        double cent;

        priceCent.add(centTotalPriceElement);
        for (int i = 0; i < priceDollar.size(); i++) {
            dollar = (Integer.parseInt(priceDollar.get(i).getText()));
            cent = (Integer.parseInt(priceCent.get(i).getText().replace(".", "").trim())/100);
            list.add((dollar + cent));
        }

        Double sumRound = list.get(0) + list.get(1);
        Double total = list.get(2);

        return sumRound.equals(total);
    }
}

