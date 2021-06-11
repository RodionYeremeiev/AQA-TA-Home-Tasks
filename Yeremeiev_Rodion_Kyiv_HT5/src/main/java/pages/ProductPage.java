package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//div[@class='save-button-wrapper']//button[@class='save-button']")
    private WebElement saveUnrvlldForLater;

    @FindBy(xpath = "//span[contains(text(),'Add to bag')]")
    private WebElement addToBagButton;

    @FindBy(xpath = "//button[@data-testid='minibag-close-btn']")
    private WebElement bagPopUp;

    @FindBy(xpath = "//span[@class='_1z5n7CN']")
    private WebElement bagCounter;


    @FindBy(xpath = "//span[@class='_1z5n7CN']")
    private WebElement bagButton;

    @FindBy(xpath = "//span[text()='View Bag']")
    private WebElement viewBagButton;

    @FindBy(xpath = "//span[@data-id='current-price']")
    private WebElement itemPrice;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSaveProductForLaterButton() {
        saveUnrvlldForLater.click();
    }

    public void clickOnAddToBagButton() {
        addToBagButton.click();
    }

    public WebElement getBagPopUp() {
        return bagPopUp;
    }

    public WebElement getBagCounter() {
        return bagCounter;
    }

    public void clickOnBagButton() {
        bagButton.click();
    }

    public void clickOnPopupViewBagButton() {
        viewBagButton.click();
    }

    public WebElement getItemPrice() {
        return itemPrice;
    }
}
