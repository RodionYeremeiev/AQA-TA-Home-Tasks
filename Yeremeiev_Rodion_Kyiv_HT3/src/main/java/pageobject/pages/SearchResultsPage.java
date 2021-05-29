package pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.Keys.ENTER;

public class SearchResultsPage extends BasePage {

    private static final String SEARCH_RESULTS_PRODUCTS_LIST_TEXT = "//div[@class='prod-cart__descr']";
    private static final String UNAVAILABLE_PRODUCT_BUTTON = "//div[@data-product='231494']//a[contains(@href,'availableProduct')]";
    private static final String EMAIL_FORM = "//div[@class='modal-middle']//input[@name='email']";
    private static final String MODAL_RESPONSE_FOR_EMAIL_INPUT = "//div[@id='modalAlert']//div[@class='ttl js_title']";

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public int getSearchResultsCount() {
        return getSearchResultsList().size();
    }

    public List<WebElement> getSearchResultsList() {
        return driver.findElements(xpath(SEARCH_RESULTS_PRODUCTS_LIST_TEXT));
    }

    public void clickOnUnAvailableProductButton() {
        driver.findElement(By.xpath(UNAVAILABLE_PRODUCT_BUTTON)).click();
    }

    public WebElement getEmailForm() {
        return driver.findElement(By.xpath(EMAIL_FORM));
    }

    public void inputEmailAddressForAvailabilityNotification(String emailAddress){
        getEmailForm().clear();
        getEmailForm().sendKeys(emailAddress, ENTER);
    }

    public WebElement getModalResponseForEmailInput(){
        return driver.findElement(By.xpath(MODAL_RESPONSE_FOR_EMAIL_INPUT));
    }

}
