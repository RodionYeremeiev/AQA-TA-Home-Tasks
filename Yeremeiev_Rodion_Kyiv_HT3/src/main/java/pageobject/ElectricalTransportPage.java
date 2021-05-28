package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElectricalTransportPage extends BasePage {

    private static final String AVAILABLE_CHECK_BOX = "//div[contains(@class,'filter')]//label[@for='fltr-1']";
    private static final String XIAOMI_CHECK_BOX = "//div[contains(@class,'filter')]//label[@for='fltr-proizvoditel-xiaomi']";

    public ElectricalTransportPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAvailableFilterCheckBox(){
        driver.findElement(By.xpath(AVAILABLE_CHECK_BOX)).click();
    }

    public void clickOnXiaomiFilterCheckBox(){
        driver.findElement(By.xpath(XIAOMI_CHECK_BOX)).click();
    }


}
