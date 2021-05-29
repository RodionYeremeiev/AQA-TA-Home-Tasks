package pagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ElectricalTransportPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'prod-cart')]//div[contains(text(),'Xiaomi Mi Electric Scooter')]")
    List<WebElement> listOfFilteredXiaomiScooters;

    @FindBy(xpath = "//div[contains(@class,'filter')]//label[@for='fltr-1']")
    private WebElement availableOnlyFilterButton;

    @FindBy(xpath = "//div[contains(@class,'filter')]//label[@for='fltr-proizvoditel-xiaomi']")
    private WebElement manufacturerFilterXiaomiButton;

    @FindBy(xpath = "//div[contains(@class,'prod-cart')]//div[contains(text(),'Xiaomi Mi Electric Scooter')]")
    private WebElement filteredXiaomiScooters;


    public ElectricalTransportPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAvailableOnlyFilterButton() {
        availableOnlyFilterButton.click();
    }

    public void clickOnManufacturerXiaomiFilterButton() {
        manufacturerFilterXiaomiButton.click();
    }

    public int getFilteredXiaomiScootersAmount() {
        return listOfFilteredXiaomiScooters.size();
    }


}
