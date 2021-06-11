package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage {

    @FindBy(xpath = "//input[@name='Username']")
    private WebElement emailInputForm;

    @FindBy(xpath = "//input[@name='Password']")
    private WebElement passwordInputForm;

    @FindBy(xpath = "//input[@id='signin']")
    private WebElement signInButton;

    @FindBy(xpath = "//span[@id='EmailAddress-error']")
    private WebElement emailError;

    @FindBy(xpath = "//span[@id='Password-error']")
    private WebElement passwordError;


    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public void inputInValidEmail(String email) {
        emailInputForm.clear();
        emailInputForm.sendKeys(email, Keys.ENTER);
    }

    public void inputInValidPassword(String password) {
        passwordInputForm.clear();
        passwordInputForm.sendKeys(Keys.ENTER);
    }

    public void clickOnSignInButton() {
        signInButton.click();
    }

    public WebElement getEmailError() {
        return emailError;
    }

    public WebElement getPasswordError() {
        return passwordError;
    }

    public boolean isEmailErrorVisible() {
        return emailError.isDisplayed();
    }

    public boolean isPasswordErrorVisible() {
        return passwordError.isDisplayed();
    }

    public boolean isSignInButtonClickable() {
        return signInButton.isEnabled();
    }
}
