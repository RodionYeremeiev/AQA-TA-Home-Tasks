package pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.openqa.selenium.By.xpath;

public class HomePage extends BasePage {

    private static final String SEARCH_INPUT = "//input[@id='input_search']";
    private static final String PRODUCT_CATALOG_BUTTON = "//span[@class='sidebar-item']";
    private static final String APPLE_STORE_BUTTON = "//ul[contains(@class,'sidebar-list')]//a[contains(@href, 'apple-store')]";
    private static final String AMOUNT_OF_PRODUCTS_IN_CART = "//div[contains(@class,'header-bottom__cart')]//div[contains(@class,'cart_count')]";
    private static final String PERSONAL_COMPUTERS_BUTTON = "//ul[contains(@class, 'sidebar-list')]//a[contains(@href,'elektronika')]";
    private static final String ALL_IN_ONE_PERSONAL_COMPUTERS_BUTTON = "//li[contains(@class, 'parent js_sidebar-item')]//a[contains(text(),'Моноблоки (All in one)')]";
    private static final String ALL_IN_ONE_ASUS_BUTTON = "//ul[@class='third-level-item js_height-block']//a[contains(@href,'monobloki/proizvoditel--asus')]";
    private static final String AIR_CONDITIONERS_BUTTON = "//div[contains(@class,'top-links flex')]//a[contains(@href,'kondiczionery')]";
    private static final String ELECTRICAL_TRANSPORT_BUTTON = "//ul[@class='sidebar-list sidebar-list--fl']//a[@href='https://avic.ua/girobordyi-i-giroskuteryi']";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchByKeyword(final String keyword) {
        driver.findElement(xpath(SEARCH_INPUT)).sendKeys(keyword, Keys.ENTER);
    }

    public void clickOnProductCatalogButton() {
        driver.findElement(xpath(PRODUCT_CATALOG_BUTTON)).click();
    }

    public void clickOnAppleStoreButton() {
        driver.findElement(xpath(APPLE_STORE_BUTTON)).click();
    }

    public String getTextOfAmountProductsInCart() {
        return driver.findElement(xpath(AMOUNT_OF_PRODUCTS_IN_CART)).getText();
    }

    public void moveToPersonalComputersButton() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(PERSONAL_COMPUTERS_BUTTON))).build().perform();
    }

    public void moveToAllInOnePersonalComputersButton() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(ALL_IN_ONE_PERSONAL_COMPUTERS_BUTTON))).build().perform();
    }

    public WebElement getAllInOnePersonalComputersButton() {
        return driver.findElement(xpath(ALL_IN_ONE_PERSONAL_COMPUTERS_BUTTON));
    }

    public void clickOnAsusAllInOnePcButton() {
        driver.findElement(By.xpath(ALL_IN_ONE_ASUS_BUTTON)).click();
    }

    public void clickOnAirConditionersButton() {
        driver.findElement(By.xpath(AIR_CONDITIONERS_BUTTON)).click();
    }

    public void clickOnElectricalTransportButton(){
        driver.findElement(By.xpath(ELECTRICAL_TRANSPORT_BUTTON)).click();
    }

}
