package hometask4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CampingAndHikingPage extends BasePage {

    @FindBy(xpath = "//li//div[contains(text(),'Scarpa Cyrus Mens')]")
    private WebElement scarpaCyrusBootsButton;

    public CampingAndHikingPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getScarpaCyrusBootsButton() {
        return scarpaCyrusBootsButton;
    }

    public void clickOnScarpaCyrusBootsButton() {
        getScarpaCyrusBootsButton().click();
    }

}
