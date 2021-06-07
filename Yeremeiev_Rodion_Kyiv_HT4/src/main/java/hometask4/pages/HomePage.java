package hometask4.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//header[@id = 'gh']")
    private WebElement header;

    @FindBy(xpath = "//footer[@id = 'glbfooter']")
    private WebElement footer;

    @FindBy(xpath = "//div[@id = 'gh-ac-box']//input[contains(@placeholder,'Search')]")
    private WebElement searchInputField;

    @FindBy(xpath = "//td[contains(@class,'sch-btn')]//input[@id='gh-btn']")
    private WebElement searchButton;

    @FindBy(xpath = "//li[@id='gh-minicart-hover']//a[contains(@aria-label,'shopping basket')]")
    private WebElement shoppingBasketButton;

    @FindBy(xpath = "//div[contains(@class,'gh-minicart-header')]//span[@class='gh-minicart-header__title']")
    private WebElement shoppingBasketPopUp;

    @FindBy(xpath = "//li[@class='gh-t ']//a[contains(text(),'Sign in')]")
    private WebElement signInButton;

    @FindBy(xpath = "//li[@class='gh-t ']//a[contains(text(),'register')]")
    private WebElement registerButton;

    @FindBy(xpath = "//div[@class='gf-flags-wpr']//a[contains(text(), 'United Kingdom')]")
    private WebElement languageButtonUK;

    @FindBy(xpath = "//div[@class='gh-menu']//a[@title='My eBay']")
    private WebElement myEbayButton;

    @FindBy(xpath = "//div[@class='gh-menu']//div[@id='gh-eb-My-o']")
    private WebElement myEbayPopUp;

    @FindBy(xpath = "//li[contains(@data-hover-track, '.l6435')]//a[contains(@href,'Sports-Hobbies-Leisure')]")
    private WebElement sportsAndLeisureButton;

    @FindBy(xpath = "//a[contains(@class,'cart-count')]//i[text()= '1']")
    private WebElement cartCount;

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public WebElement getHeader() {
        return header;
    }

    public WebElement getFooter() {
        return footer;
    }

    public WebElement getSearchInputField() {
        return searchInputField;
    }

    public void setSearchInputFieldWithSearchButton(String searchRequest) {
        getSearchInputField().clear();
        getSearchInputField().sendKeys(searchRequest);
        getSearchButton().click();
    }

    public void setSearchInputFieldWithEnterKey(String searchRequest) {
        getSearchInputField().clear();
        getSearchInputField().sendKeys(searchRequest, Keys.ENTER);
    }


    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getShoppingBasketButton() {
        return shoppingBasketButton;
    }

    public WebElement getShoppingBasketPopUp() {
        return shoppingBasketPopUp;
    }

    public WebElement getSignInButton() {
        return signInButton;
    }

    public WebElement getRegisterButton() {
        return registerButton;
    }

    public WebElement getLanguageButtonUK() {
        return languageButtonUK;
    }

    public WebElement getMyEbayPopUp() {
        return myEbayPopUp;
    }

    public WebElement getMyEbayButton() {
        return myEbayButton;
    }

    public WebElement getSportsAndLeisureButton() {
        return sportsAndLeisureButton;
    }

    public WebElement getCartCount() {
        return cartCount;
    }

    public boolean isHeaderVisible() {
        return header.isDisplayed();
    }

    public boolean isFooterVisible() {
        return footer.isDisplayed();
    }

    public boolean isSearchInputVisible() {
        return searchInputField.isDisplayed();
    }

    public boolean isSearchButtonVisible() {
        return searchButton.isDisplayed();
    }

    public boolean isShoppingBasketVisible() {
        return shoppingBasketButton.isDisplayed();
    }

    public boolean isShoppingBasketPopUpVisible() {
        return shoppingBasketPopUp.isDisplayed();
    }

    public boolean isSignInButtonVisible() {
        return signInButton.isDisplayed();
    }

    public boolean isRegisterButtonVisible() {
        return registerButton.isDisplayed();
    }

    public boolean isLanguageButtonVisible() {
        return languageButtonUK.isDisplayed();
    }

    public boolean isMyEbayPopUpVisible() {
        return myEbayPopUp.isDisplayed();
    }

    public void moveToShoppingBasket() {
        new Actions(driver).moveToElement(getShoppingBasketButton()).build().perform();
    }

    public void moveMyEbayButton() {
        new Actions(driver).moveToElement(getMyEbayButton()).build().perform();
    }

    public void clickOnSportsAndLeisureButton() {
        getSportsAndLeisureButton().click();
    }

    public void clickOnSignInButton() {
        getSignInButton().click();
    }

    public void clickOnRegisterButton() {
        getRegisterButton().click();
    }

}
