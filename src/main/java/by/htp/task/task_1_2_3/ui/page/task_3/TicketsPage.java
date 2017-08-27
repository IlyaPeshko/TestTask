package by.htp.task.task_1_2_3.ui.page.task_3;

import by.htp.task.task_1_2_3.ui.page.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class TicketsPage extends Page {

    @FindBy(how = How.XPATH, xpath = ".//*[@id='fareRowContainer_0']/tbody/tr[2]/td[2]")
    WebElement firstTicketElement;
    @FindBy(how = How.XPATH, xpath = ".//*[@id='fareRowContainer_1']/tbody/tr[2]/td[2]")
    WebElement secondTiсketElement;
    @FindBy(how = How.ID, id = "tripSummarySubmitBtn")
    WebElement continueButtonElement;
    @FindBy(how = How.XPATH, xpath = ".//*[@id='tripPriceTotals']/div/div/div[2]/span[3]")
    WebElement centTotalPriceElement;


    public TicketsPage(WebDriver driver) {
        super(driver);
    }

    public TicketsPage selectTickets(WebDriver driver) {
        PageFactory.initElements(driver, this);

        logger("select first ticket");
        firstTicketElement.click();
        logger("first ticket is selected");

        waitElement(driver, By.xpath(".//*[@class='topHeaderWrapper tripRowContainer']/div/div/table/tbody/tr"));
        logger("select second ticket");
        secondTiсketElement.click();
        logger("second ticket is selected");

        return this;
    }

    public PassengerInfoPage clickContinueButton () {
        continueButtonElement.click();

        return new PassengerInfoPage(driver);
    }

    public boolean checkTicketsSum(WebDriver driver) {
        PageFactory.initElements(driver, this);
        List<WebElement> priceDollar = driver.findElements(By.xpath(".//*[@class='txtInteger currencyInt']"));
        List<WebElement> priceCent = driver.findElements(By.xpath(".//*[@class='txtInteger currencyInt']/following-sibling::span[2]"));
        ArrayList<Double> list = new ArrayList();
        int dollar;
        double cent;

        priceCent.add(centTotalPriceElement);
        for (int i = 0; i < priceDollar.size(); i++) {
            dollar = (Integer.parseInt(priceDollar.get(i).getText()));
            cent = (Integer.parseInt(priceCent.get(i).getText().replace(".", "").trim()));
            list.add((dollar + (cent / 100)));
        }

        logger("price: " + list);

        Double sumRound = new BigDecimal(list.get(0) + list.get(1)).setScale(4, RoundingMode.DOWN).doubleValue();
        Double total = list.get(2);

        return sumRound.equals(total);
    }
}

