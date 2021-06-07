package hometask4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    @FindBy(xpath = "//div[@class='textbox']//input[@id='userid']")
    private WebElement userNameField;

    @FindBy(xpath = "//button[@id='signin-continue-btn']")
    private WebElement continueButton;

    @FindBy(xpath = "//div[contains(@class,'signin-buttons')]//button[@id='signin_fb_btn']")
    private WebElement signInViaFaceBook;

    @FindBy(xpath = "//div[contains(@class,'signin-buttons')]//button[@id='signin_ggl_btn']")
    private WebElement signInViaGoogle;

    @FindBy(xpath = "//div[contains(@class,'signin-buttons')]//button[@id='signin_appl_btn']")
    private WebElement signInViaApple;

    public SignInPage(WebDriver driver) {
        super(driver);
    }


    public boolean isUserNameFieldVisible() {
        return userNameField.isDisplayed();
    }

    public boolean isContinueButtonVisible() {
        return continueButton.isDisplayed();
    }

    public boolean isSignInViaFaceBookVisible() {
        return signInViaFaceBook.isDisplayed();
    }

    public boolean isSignInViaGoogleVisible() {
        return signInViaGoogle.isDisplayed();
    }

    public boolean isSignInViaAppleVisible() {
        return signInViaApple.isDisplayed();
    }
}
