package by.htp.task.ui.page.task_3;

import by.htp.task.ui.page.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 09.08.17.
 */
public class TicketsPage extends Page {

    @FindBy(how= How.XPATH, xpath=".//*[@id='fareRowContainer_0']/tbody/tr[2]/td[2]")
    WebElement firstTicket;

    @FindBy(how= How.XPATH, xpath=".//*[@id='fareRowContainer_1']/tbody/tr[2]/td[2]")
    WebElement secondTiket;

    @FindBy(how= How.ID, id="tripSummarySubmitBtn")
    WebElement continueButton;

    private static boolean totalprice;

    public TicketsPage(WebDriver driver) {
        super(driver);
    }

    public PassengerInfoPage selectTicket (WebDriver driver) throws InterruptedException {
        logger("select tickets");
        PageFactory.initElements(driver, this);

        Thread.sleep(5000);
        firstTicket.click();
        Thread.sleep(10000);
        secondTiket.click();
        Thread.sleep(7000);
        totalprice = checkTotal(driver);
        logger("isTotal: "+ totalprice);

        continueButton.click();

        return new PassengerInfoPage(driver);
    }

    @FindBy(how= How.XPATH, xpath=".//*[@id='tripPriceTotals']/div/div/div[2]/span[3]")
    WebElement centTotalPrice;

    private boolean checkTotal (WebDriver driver){
        List <WebElement> priceDollar = driver.findElements(By.xpath(".//*[@class='txtInteger currencyInt']"));
        List <WebElement> priceCent = driver.findElements(By.xpath(".//*[@class='txtInteger currencyInt']/following-sibling::span[2]"));
        ArrayList <Double>list = new ArrayList();
        int dollar;
        double cent;

        priceCent.add(centTotalPrice);
        for (int i=0; i<priceDollar.size();i++){
            dollar = (Integer.parseInt(priceDollar.get(i).getText()));
            cent = (Integer.parseInt(priceCent.get(i).getText().replace(".", "").trim()));
            list.add((dollar+(cent/100)));
        }
        logger("price: "+list);

        Double priceWithoutTax = list.get(0);
        Double tax = list.get(1);
        Double total = list.get(2);
        if((priceWithoutTax+tax)==total)
            return true;

        return false;
    }

    public static boolean isTotalprice() {
        return totalprice;
    }
}
