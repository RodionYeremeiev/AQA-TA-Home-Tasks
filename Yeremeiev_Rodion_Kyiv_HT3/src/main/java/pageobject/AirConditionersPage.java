package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.Keys.ENTER;

public class AirConditionersPage extends BasePage {

    private static final String PRICE_FILTER_MIN_VALUE_FORM_INPUT = "//div[@class='row-m']//input[contains(@class,'form-control-min')]";
    private static final String PRICE_FILTER_MAX_VALUE_FORM_INPUT = "//div[@class='row-m']//input[contains(@class,'form-control-max')]";
    private static final String PRICE_FILTER_ACCEPT_BUTTON = "//div[contains(@class,'form-group')]//a[contains(@class,'filters_accept')]";

    public AirConditionersPage(WebDriver driver) {
        super(driver);
    }

    public void setPriceFilterMinValue(String value) {
        driver.findElement(By.xpath(PRICE_FILTER_MIN_VALUE_FORM_INPUT)).clear();
        driver.findElement(By.xpath(PRICE_FILTER_MIN_VALUE_FORM_INPUT)).sendKeys(value, ENTER);
    }

    public void setPriceFilterMaxValue(String value) {
        driver.findElement(By.xpath(PRICE_FILTER_MAX_VALUE_FORM_INPUT)).clear();
        driver.findElement(By.xpath(PRICE_FILTER_MAX_VALUE_FORM_INPUT)).sendKeys(value, ENTER);
    }

    public WebElement getPriceFilterAcceptButton() {
        return driver.findElement(By.xpath(PRICE_FILTER_ACCEPT_BUTTON));
    }

    public void clickOnPriceFilterAcceptButton() {
        getPriceFilterAcceptButton().click();
    }

}
