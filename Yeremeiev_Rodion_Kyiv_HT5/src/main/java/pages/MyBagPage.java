package pages;

import org.jsoup.nodes.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyBagPage extends BasePage{

//    @FindBy(xpath = "//span[@class='bag-item-price bag-item-price--current bag-item-price--rrp']")
//    @FindBy(xpath = "//div[@class='bag-contents-holder-panel']//span[@class='bag-subtotal-price']")
    @FindBy(xpath = "//h3[@class='bag-subtotal']/span[contains(@class,'bag-subtotal-price')]")
    private WebElement itemsSubTotalPrice;

    public MyBagPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getItemsSubTotalPrice() {
        return itemsSubTotalPrice;
    }
}
