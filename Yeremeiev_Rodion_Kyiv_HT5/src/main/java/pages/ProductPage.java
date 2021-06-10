package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{

    @FindBy(xpath = "//div[@class='save-button-wrapper']//button[@class='save-button']")
    private WebElement saveUnrvlldForLater;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSaveProductForLaterButton() {
        saveUnrvlldForLater.click();
    }

    public WebElement getSaveUnrvlldForLater() {
        return saveUnrvlldForLater;
    }
}
