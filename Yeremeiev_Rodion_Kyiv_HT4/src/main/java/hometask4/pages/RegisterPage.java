package hometask4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    @FindBy(xpath = "//form[contains(@name,'create-personal')]//input[@id='firstname']")
    private WebElement userFirstNameField;

    @FindBy(xpath = "//form[contains(@name,'create-personal')]//input[@id='lastname']")
    private WebElement userLastNameField;

    @FindBy(xpath = "//form[contains(@name,'create-personal')]//input[@id='Email']")
    private WebElement userEmailField;

    @FindBy(xpath = "//form[contains(@name,'create-personal')]//input[@id='password']")
    private WebElement userPasswordField;

    @FindBy(xpath = "//div[@class='form-actions']//button[contains(@name,'FORM_SUBMIT')]")
    private WebElement registerButton;

    @FindBy(xpath = "//div[@class='social-flex-container']//button[@id='facebook']")
    private WebElement continueViaFaceBookButton;

    @FindBy(xpath = "//div[@class='social-flex-container']//button[@id='google']")
    private WebElement continueViaGoogleButton;

    @FindBy(xpath = "//div[@class='social-flex-container']//button[@id='apple']")
    private WebElement continueViaAppleButton;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public boolean isUserFirstNameFieldVisible() {
        return userFirstNameField.isDisplayed();
    }

    public boolean isUserLastNameFieldVisible() {
        return userLastNameField.isDisplayed();
    }

    public boolean isUserEmailFieldVisible() {
        return userEmailField.isDisplayed();
    }

    public boolean isUserPasswordFieldVisible() {
        return userPasswordField.isDisplayed();
    }

    public boolean isRegisterButtonVisible() {
        return registerButton.isDisplayed();
    }

    public boolean isRegisterButtonEnabled() {
        return registerButton.isEnabled();
    }

    public boolean isContinueViaFaceBookVisible() {
        return continueViaFaceBookButton.isDisplayed();
    }

    public boolean isContinueViaGoogleVisible() {
        return continueViaGoogleButton.isDisplayed();
    }

    public boolean isContinueViaAppleVisible() {
        return continueViaAppleButton.isDisplayed();
    }
}
