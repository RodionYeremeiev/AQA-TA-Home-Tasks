package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.Keys.ENTER;

public class SearchResultPage extends BasePage {
    private final static String EMAIL_WHEN_AVAILABLE_AGAIN_BUTTON = "//div[@data-product='231494']//a[contains(@href,'availableProduct')]";
    private static final String SEND_REQUEST_STATUS = "//div[@id='modalAlert']//div[@class='ttl js_title']";


    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnEmailWhenAvailableButton() {
        driver.findElement(By.xpath(EMAIL_WHEN_AVAILABLE_AGAIN_BUTTON)).click();
    }

    public void inputEmailForNotification(String locator, String email) {
        driver.findElement(By.xpath(locator)).sendKeys(email, ENTER);
    }

    public WebElement getEmailSendStatusReportElement() {
        return driver.findElement(By.xpath(SEND_REQUEST_STATUS));
    }

}
