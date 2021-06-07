package hometask4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//span[@class='s-item__price']")
    private List<WebElement> searchResultList;

    @FindBy(xpath = "//a[contains(@_sp,'m570.l2586')]")
    private WebElement ebayHomeButton;


    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public String getItemPrice() {
        return searchResultList.get(0).getText();
    }

    public WebElement getEbayHomeButton(){
        return ebayHomeButton;
    }

    public void clickOnEbayHomeButton(){
        ebayHomeButton.click();
    }

}
