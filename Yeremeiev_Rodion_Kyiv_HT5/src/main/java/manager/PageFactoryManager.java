package manager;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.ProductPage;
import pages.SavedItemsPage;
import pages.SearchResultPage;

public class PageFactoryManager {
    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public ProductPage getProductPage() {
        return new ProductPage(driver);
    }

    public SavedItemsPage getSavedItemsPage() {
        return new SavedItemsPage(driver);
    }

    public SearchResultPage getSearchResultPage() {
        return new SearchResultPage(driver);
    }
}
