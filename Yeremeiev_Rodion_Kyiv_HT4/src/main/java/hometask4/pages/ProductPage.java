package hometask4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//div[@class='u-cb  ']//a[contains(text(), 'Add to basket')]")
    private WebElement addToBasketButton;

    @FindBy(xpath = "//div[contains(@class,'content-wrapper')]")
    private WebElement addToBasketPopUp;

    @FindBy(xpath = "//div[@class='clzBtnSection']//div[contains(@class,'viicon-close')]")
    private WebElement addToBasketPopUpCloseButton;

    @FindBy(xpath = "//div[contains(@class,'header-wrapper')]//div[@class='vi-overlayTitleBar']")
    private WebElement addToBasketPopUpHeader;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getAddToBasketButton() {
        return addToBasketButton;
    }

    public void clickAddToBasketButton() {
        getAddToBasketButton().click();
    }

    public WebElement getAddToBasketPopUp() {
        return addToBasketPopUp;
    }

    public void clickOnAddToBasketPopUpCloseButton() {
        addToBasketPopUpCloseButton.click();
    }

    public WebElement getAddToBasketPopUpHeader() {
        return addToBasketPopUpHeader;
    }

    public String getAddToBasketPopUpHeaderText() {
        return getAddToBasketPopUpHeader().getText();
    }
}
