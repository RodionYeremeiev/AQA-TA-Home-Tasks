package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SavedItemsPage extends BasePage{

    @FindBy(xpath = "//section[contains(@class,'productTiles')]//div[contains(@class,'productTile')]")
    private List<WebElement> listOfSavedItems;


    public SavedItemsPage(WebDriver driver) {
        super(driver);
    }


    public List<WebElement> getListOfSavedItems() {
        return listOfSavedItems;
    }

}
