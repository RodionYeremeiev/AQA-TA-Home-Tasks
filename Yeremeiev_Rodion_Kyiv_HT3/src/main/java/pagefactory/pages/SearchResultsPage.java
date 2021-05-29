package pagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.Keys.ENTER;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//div[@class='prod-cart__descr']")
    private List<WebElement> searchResultsProductsListText;

    @FindBy(xpath = "//div[@data-product='231494']//a[contains(@href,'availableProduct')]")
    private WebElement unAvailableProductButton;

    @FindBy(xpath = "//div[@class='modal-middle']//input[@name='email']")
    private WebElement emailForm;

    @FindBy(xpath = "//div[@id='modalAlert']//div[@class='ttl js_title']")
    private WebElement modalResponseForEmailInput;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public int getSearchResultsCount() {
        return getSearchResultsList().size();
    }

    public List<WebElement> getSearchResultsList() {
        return searchResultsProductsListText;
    }

    public void clickOnUnAvailableProductButton() {
        unAvailableProductButton.click();
    }

    public WebElement getEmailForm() {
        return emailForm;
    }

    public void inputEmailAddressForAvailabilityNotification(String emailAddress) {
        getEmailForm().clear();
        getEmailForm().sendKeys(emailAddress, ENTER);
    }

    public WebElement getModalResponseForEmailInput() {
        return modalResponseForEmailInput;
    }

}
