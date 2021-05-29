package pagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.Keys.ENTER;

public class AirConditionersPage extends BasePage {

    @FindBy(xpath = "//div[@class='row-m']//input[contains(@class,'form-control-min')]")
    private WebElement priceFilterFormInputValueMin;

    @FindBy(xpath = "//div[@class='row-m']//input[contains(@class,'form-control-max')]")
    private WebElement priceFilterFormInputValueMax;

    @FindBy(xpath = "//div[contains(@class,'form-group')]//a[contains(@class,'filters_accept')]")
    private WebElement priceFilterAcceptButton;

    @FindBy(xpath = "//div[contains(@class,'item-prod')]//div[contains(@class,'prise-new')]")
    private WebElement sortedAirConditionerItem;

    public AirConditionersPage(WebDriver driver) {
        super(driver);
    }

    public void setPriceFilterMinValue(String value) {
        priceFilterFormInputValueMin.clear();
        priceFilterFormInputValueMin.sendKeys(value, ENTER);
    }

    public void setPriceFilterMaxValue(String value) {
        priceFilterFormInputValueMax.clear();
        priceFilterFormInputValueMax.sendKeys(value, ENTER);
    }

    public WebElement getFilterAcceptPriceButton() {
        return priceFilterAcceptButton;
    }

    public void clickOnFilterAcceptPriceButton() {
        getFilterAcceptPriceButton().click();
    }

    public WebElement getSortedAirConditionerItem() {
        return sortedAirConditionerItem;
    }
}
