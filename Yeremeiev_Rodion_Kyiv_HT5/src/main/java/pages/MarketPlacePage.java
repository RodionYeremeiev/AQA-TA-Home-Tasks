package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MarketPlacePage extends BasePage {

    @FindBy(xpath = "//a[contains(text(),'Sell here')]")
    private WebElement sellHereButton;

    @FindBy(xpath = "//div[@class='info-page']//h1[contains(text(),'Sell on ASOS')]")
    private WebElement infoPageHeader;

    @FindBy(xpath = "//div[@class='apply-button-container']//a[contains(text(),'boutique')]")
    private WebElement applyForBoutiqueButton;

    @FindBy(xpath = "//span[text()='Sign in with Facebook']")
    private WebElement signInFacebookButton;

    @FindBy(xpath = "//span[text()='Sign up with Facebook']")
    private WebElement signUpFacebookButton;

    @FindBy(xpath = "//a[contains(@class,'Footer_externalLink')]")
    private WebElement externalLink;

    public MarketPlacePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSellHereButton() {
        sellHereButton.click();
    }

    public WebElement getInfoPageHeader() {
        return infoPageHeader;
    }

    public void clickOnApplyForBoutiqueButton() {
        applyForBoutiqueButton.click();
    }

    public WebElement getSignInFacebookButton() {
        return signInFacebookButton;
    }

    public WebElement getSignUpFacebookButton() {
        return signUpFacebookButton;
    }

    public boolean signInFacebookButtonIsVisible() {
        return signInFacebookButton.isDisplayed();
    }

    public boolean signUpFacebookButtonIsVisible() {
        return signUpFacebookButton.isDisplayed();
    }

    public void clickOnExternalLink() {
        externalLink.click();
    }
}
