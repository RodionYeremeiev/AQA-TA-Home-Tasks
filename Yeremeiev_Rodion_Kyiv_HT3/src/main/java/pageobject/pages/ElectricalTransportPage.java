package pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElectricalTransportPage extends BasePage {

    private static final String AVAILABLE_ONLY_FILTER_BUTTON = "//div[contains(@class,'filter')]//label[@for='fltr-1']";
    private static final String MANUFACTURER_FILTER_XIAOMI_BUTTON = "//div[contains(@class,'filter')]//label[@for='fltr-proizvoditel-xiaomi']";
    private static final String FILTERED_XIAOMI_SCOOTERS = "//div[contains(@class,'prod-cart')]//div[contains(text(),'Xiaomi Mi Electric Scooter')]";

    public ElectricalTransportPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAvailableOnlyFilterButton() {
        driver.findElement(By.xpath(AVAILABLE_ONLY_FILTER_BUTTON)).click();
    }

    public void clickOnManufacturerXiaomiFilterButton() {
        driver.findElement(By.xpath(MANUFACTURER_FILTER_XIAOMI_BUTTON)).click();
    }

    public int getFilteredXiaomiScootersAmount() {
        List<WebElement> elementList = driver.findElements(By.xpath(FILTERED_XIAOMI_SCOOTERS));
        return elementList.size();
    }


}
