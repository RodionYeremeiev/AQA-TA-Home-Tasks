package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//article[@data-auto-id='productTile']//div/p")
    private List<WebElement> searchResultList;

    @FindBy(xpath = "//p[@class='vp-JnyG']")
    private WebElement searchResultTitle;

    @FindBy(xpath = "//p[@data-auto-id='styleCount']")
    private WebElement searchResultAmount;

    @FindBy(xpath = "//img[contains(@src,'floral-print-umbrella')]")
    private WebElement fulltonUmbrella;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkResultListContainsKeyword(String keyword) {
        for (WebElement element : searchResultList) {
            if (element.getText().toLowerCase().contains(keyword)) ;
            return true;
        }
        return false;
    }

    public boolean checkSearchResultTitleContainsKeyWord(String keyword) {
        return searchResultTitle.getText().toLowerCase().contains(keyword);
    }

    public int getSearchResultAmount() {
        return Integer.valueOf(searchResultAmount.getText().replaceAll("[^\\d.]", ""));
    }

    public void clickOnUmbrella() {
        fulltonUmbrella.click();
    }
}
