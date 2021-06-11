package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//button[@data-testid='myAccountIcon']")
    private WebElement myAccountButton;

    @FindBy(xpath = "//button[@data-testid='search-button-inline']")
    private WebElement searchButton;

    @FindBy(xpath = "//header")
    private WebElement header;

    @FindBy(xpath = "//footer")
    private WebElement footer;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchField;

    @FindBy(xpath = "//span[text()='VIEW ALL']")
    private WebElement viewAllButton;

    @FindBy(xpath = "//article[@id='product-14315631']//button[@data-auto-id = 'saveForLater']")
    private WebElement saveForLaterButton;

    @FindBy(xpath = "//li[@class='_3Wo6fpk']//span[@type='heartPrideFilled']")
    private WebElement savedItemsButton;

    @FindBy(xpath = "//section[contains(@class,'mu-section')]//a[contains(@href,'sunglasses')]")
    private WebElement sunniesButton;

    @FindBy(xpath = "//article[@id='product-200211855']")
    private WebElement rayBanGlassesButton;

    @FindBy(xpath = "//div[@id='myaccount-dropdown']")
    private WebElement myAccountPopUp;

    @FindBy(xpath = "//span[@type='bagUnfilled']")
    private WebElement bagButton;

    @FindBy(xpath = "//button[contains(@data-id,'c223e1a9')]//span[text()='Sale']")
    private WebElement salePopUpButton;

    @FindBy(xpath = "//div[contains(@id,'c223e1a9')]//span[text()='SHOP SALE BY PRODUCT']")
    private WebElement salePopUpInsideHeader;

    @FindBy(xpath = "//ul[contains(@data-id,'c223e1a9')]//a[contains(@class,'_1cjL45H') and contains(@href,'/men/sale')]")
    private List<WebElement> salePopUpByProductElementsList;

    @FindBy(xpath = "//button[@data-id='029c47b3-2111-43e9-9138-0d00ecf0b3db']//span[text()='New in']")
    private WebElement newInPopUpButton;

    @FindBy(xpath = "//div[contains(@id,'029c47b3')]//span[text()='NEW PRODUCTS']")
    private WebElement newInPopUp;

    @FindBy(xpath = "//ul[@data-id='029c47b3-2111-43e9-9138-0d00ecf0b3db']//a[@class='_1cjL45H _2Y7IAa_ CLdGn9X _1XjY6Zd' and contains(@href,'/men')]")
    private List<WebElement> newInPopUpProductList;

    @FindBy(xpath = "//button[contains(@data-id,'495d8469')]//span[text()='Topman']")
    private WebElement topManPopUpButton;

    @FindBy(xpath = "//div[contains(@id,'495d8469')]//span[text()='SHOP BY PRODUCT']")
    private WebElement topManPopUpInsideHeader;

    @FindBy(xpath = "//ul[contains(@data-id,'495d8469')]//li[@class='_3QF73Dj']//a[contains(@href,'/topman')]")
    private List<WebElement> topManPopUpProductList;

    @FindBy(xpath = "//a[@id='women-floor']")
    private WebElement womanButton;

    @FindBy(xpath = "//ul[contains(@class,'carousel__list')]")
    private WebElement womanCarousel;

    @FindBy(xpath = "//button[@aria-label='next']")
    private WebElement scrollForwardButton;

    //    @FindBy(xpath = "//li[@class='visible' or @class='hidden']//span[@class='carousel__labelText']")
    @FindBy(xpath = "//div[@class='carousel__label']//span[@class='carousel__labelText']")
    private List<WebElement> carouselElementList;

    @FindBy(xpath = "//button[@aria-label='previous']")
    private WebElement scrollBackwardButton;

    @FindBy(xpath = "//a[@data-testid='signup-link']")
    private WebElement joinButton;

    @FindBy(xpath = "//a[@data-testid='signin-link']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@data-testid='marketplace']")
    private WebElement marketPlaceButton;

    @FindBy(xpath = "//div[@data-testid='topbar']//button[contains(@aria-label,'Ukraine')]")
    private WebElement countryButton;

    @FindBy(xpath = "//select[@id='currency']")
    private WebElement currencyButton;

    @FindBy(xpath = "//option[text()='$ USD']")
    private WebElement usdButton;

    @FindBy(xpath = "//button[text()='Update Preferences']")
    private WebElement updateButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void isHeaderVisible() {
        header.isDisplayed();
    }

    public void isFooterVisible() {
        footer.isDisplayed();
    }

    public void isSearchFieldVisible() {
        searchField.isDisplayed();
    }

    public WebElement getMyAccountButton() {
        return myAccountButton;
    }

    public void clickSaveForLater() {
        saveForLaterButton.click();
    }

    public void clickOnSavedItemsButton() {
        savedItemsButton.click();
    }

    public void clickOnSunniesButton() {
        sunniesButton.click();
    }

    public void clickOnRayBanGlassesButton() {
        rayBanGlassesButton.click();
    }

    public WebElement getMyAccountPopUp() {
        return myAccountPopUp;
    }

    public boolean isMyAccountPopUpVisible() {
        return getMyAccountPopUp().isDisplayed();
    }

    public boolean isSavedItemsButtonVisible() {
        return savedItemsButton.isDisplayed();
    }

    public boolean isBagButtonVisible() {
        return bagButton.isDisplayed();
    }

    public WebElement getSalePopUpButton() {
        return salePopUpButton;
    }

    public WebElement getSalePopUp() {
        return salePopUpInsideHeader;
    }

    public List<WebElement> getSalePopUpProductsList() {
        return salePopUpByProductElementsList;
    }

    public WebElement getNewInPopUpButton() {
        return newInPopUpButton;
    }

    public WebElement getNewInPopUp() {
        return newInPopUp;
    }

    public List<WebElement> getNewInPopUpProductsList() {
        return newInPopUpProductList;
    }

    public WebElement getTopManPopUpButton() {
        return topManPopUpButton;
    }

    public WebElement getTopManPopUp() {
        return topManPopUpInsideHeader;
    }

    public List<WebElement> getTopManPopUpProductsList() {
        return topManPopUpProductList;
    }

    public void clickOnWomenButton() {
        womanButton.click();
    }

    public boolean isWomanCarouselVisible() {
        return womanCarousel.isDisplayed();
    }

    public void clickOnScrollForwardButton() {
        this.getScrollForwardButton().click();
    }

    public WebElement getScrollForwardButton() {
        return scrollForwardButton;
    }

    public boolean isLastCarouselElementVisible() {
        return getCarouselLastElement().isDisplayed();
    }

    public List<WebElement> getCarouselElementsList() {
        return carouselElementList;
    }

    public WebElement getCarouselLastElement() {
        return carouselElementList.get(carouselElementList.size() - 1);
    }

    public void clickOnScrollBackWardButton() {
        scrollBackwardButton.click();
    }

    public WebElement getScrollBackwardButton() {
        return scrollBackwardButton;
    }

    public boolean isFirstCarouselElementVisible() {
        return carouselElementList.get(0).isDisplayed();
    }

    public WebElement getCarouselFirstElement() {
        return carouselElementList.get(0);
    }

    public void inputSearchQuery(String keyword) {
        searchField.clear();
        searchField.sendKeys(keyword);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickJoinButton() {
        joinButton.click();
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public void clickOnMarketPlaceButton() {
        marketPlaceButton.click();
    }

    public void clickOnCountryButton() {
        countryButton.click();
    }

    public WebElement getCountryButton() {
        return countryButton;
    }

    public void clickOnCurrencyButton() {
        currencyButton.click();
    }

    public void clickOnUsdButton() {
        usdButton.click();
    }

    public void clickOnUpdateButton() {
        updateButton.click();
    }

    public WebElement getUsdButon() {
        return usdButton;
    }
}
