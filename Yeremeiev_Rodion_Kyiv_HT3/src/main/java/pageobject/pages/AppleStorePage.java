package pageobject.pages;

import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class AppleStorePage extends BasePage {

    private static final String IPHONE_BUTTON = "//div[@class='brand-box__title']/a[contains(@href,'iphone')]";

    public AppleStorePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnIphoneButton() {
        driver.findElement(xpath(IPHONE_BUTTON)).click();
    }

}
