package pagefactory.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@id='input_search']")
    private WebElement searchInput;

    @FindBy(xpath = "//span[@class='sidebar-item']")
    private WebElement productCatalogueButton;

    @FindBy(xpath = "//ul[contains(@class,'sidebar-list')]//a[contains(@href, 'apple-store')]")
    private WebElement appleStoreButton;

    @FindBy(xpath = "//div[contains(@class,'header-bottom__cart')]//div[contains(@class,'cart_count')]")
    private WebElement amountOfProductsInCart;

    @FindBy(xpath = "//ul[contains(@class, 'sidebar-list')]//a[contains(@href,'elektronika')]")
    private WebElement personalComputersButton;

    @FindBy(xpath = "//li[contains(@class, 'parent js_sidebar-item')]//a[contains(text(),'Моноблоки (All in one)')]")
    private WebElement allInOnePersonalComputersButton;

    @FindBy(xpath = "//ul[@class='third-level-item js_height-block']//a[contains(@href,'monobloki/proizvoditel--asus')]")
    private WebElement allInOneAsusButton;

    @FindBy(xpath = "//div[contains(@class,'top-links flex')]//a[contains(@href,'kondiczionery')]")
    private WebElement airConditionersButton;

    @FindBy(xpath = "//ul[@class='sidebar-list sidebar-list--fl']//a[@href='https://avic.ua/girobordyi-i-giroskuteryi']")
    private WebElement electricalTransportButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchByKeyword(final String keyword) {
        searchInput.sendKeys(keyword, Keys.ENTER);
    }

    public void clickOnProductCatalogButton() {
        productCatalogueButton.click();
    }

    public void clickOnAppleStoreButton() {
        appleStoreButton.click();
    }

    public String getTextOfAmountProductsInCart() {
        return amountOfProductsInCart.getText();
    }

    public void moveToPersonalComputersButton() {
        Actions actions = new Actions(driver);
        actions.moveToElement(personalComputersButton).build().perform();
    }

    public void moveToAllInOnePersonalComputersButton() {
        Actions actions = new Actions(driver);
        actions.moveToElement(allInOnePersonalComputersButton).build().perform();
    }

    public WebElement getAllInOnePersonalComputersButton() {
        return allInOnePersonalComputersButton;
    }

    public void clickOnAsusAllInOnePcButton() {
        allInOneAsusButton.click();
    }

    public void clickOnAirConditionersButton() {
        airConditionersButton.click();
    }

    public void clickOnElectricalTransportButton(){
        electricalTransportButton.click();
    }

}
