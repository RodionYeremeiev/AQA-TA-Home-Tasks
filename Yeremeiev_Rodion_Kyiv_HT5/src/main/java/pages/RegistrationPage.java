package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

    @FindBy(xpath = "//input[@name='Email']")
    private WebElement emailInputField;

    @FindBy(xpath = "//input[@name='FirstName']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@name='LastName']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@name='Password']")
    private WebElement passwordField;

    @FindBy(xpath = "//span[@id='Email-error']")
    private WebElement emailErrorMessage;

    @FindBy(xpath = "//span[@id='FirstName-error']")
    private WebElement firstNameError;

    @FindBy(xpath = "//span[@id='LastName-error']")
    private WebElement lastNameError;

    @FindBy(xpath = "//span[@id='Password-error']")
    private WebElement PasswordError;

    @FindBy(xpath = "//select[@aria-label='Date of birth Day']")
    private WebElement daySelector;

    @FindBy(xpath = "//option[@value='15']")
    private WebElement dayFifteen;

    @FindBy(xpath = "//select[@aria-label='Date of birth Month']")
    private WebElement monthSelector;

    @FindBy(xpath = "//option[text()='January']")
    private WebElement january;

    @FindBy(xpath = "//select[@aria-label='Date of birth Year']")
    private WebElement yearSelector;

    @FindBy(xpath = "//option[text()='2005']")
    private WebElement year2005;

    @FindBy(xpath = "//button[contains(text(),'Select All')]")
    private WebElement selectAllButton;

    @FindBy(xpath = "//input[@id='register']")
    private WebElement submitButton;

    @FindBy(xpath = "//a[@data-testid='signin-link']")
    private WebElement signInButton;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void inputGeneratedEmail() {
        emailInputField.clear();
        emailInputField.sendKeys(generateStringforRegistration() + "@mail.com", Keys.ENTER);
    }

    public boolean visibilityOfEmailError() {
        return emailErrorMessage.isDisplayed();
    }

    public WebElement getFirstNameField() {
        return firstNameField;
    }

    public WebElement getLastNameField() {
        return lastNameField;
    }

    public WebElement getPasswordNameField() {
        return passwordField;
    }

    public boolean visibilityOfFirstNameError() {
        return firstNameError.isDisplayed();
    }

    public boolean visibilityOfLastNameError() {
        return lastNameError.isDisplayed();
    }

    public boolean visibilityOfPasswordError() {
        return PasswordError.isDisplayed();
    }

    public void inputGeneratedString(WebElement element) {
        element.sendKeys(generateStringforRegistration(), Keys.ENTER);
    }

    public void clickDaySelector() {
        daySelector.click();
    }

    public void clickMonthSelector() {
        daySelector.click();
    }

    public void clickYearSelector() {
        daySelector.click();
    }

    public WebElement getDayFifteen() {
        return dayFifteen;
    }

    public WebElement getJanuary() {
        return january;
    }

    public WebElement getYear2005() {
        return year2005;
    }

    public void clickOnSelectAllButton() {
        selectAllButton.click();
    }

    public void clickOnSubmitButton() {
        submitButton.click();
    }

    public boolean submitButtonIsVisible() {
        return submitButton.isDisplayed();
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public boolean signInButtonIsVisible() {
        return signInButton.isDisplayed();
    }

    public void inputInvalidEmail(String email) {
        emailInputField.sendKeys(email, Keys.ENTER);
    }

    public void inputInvalidFirstName(String firstName) {
        firstNameField.sendKeys(firstName, Keys.ENTER);
    }

    public void inputInvalidLastName(String lastName) {
        lastNameField.sendKeys(lastName, Keys.ENTER);
    }

    public void inputInvalidPassword(String password) {
        passwordField.sendKeys(password, Keys.ENTER);
    }

    public WebElement getEmailErrorMessage() {
        return emailErrorMessage;
    }

    public WebElement getFirstNameError() {
        return firstNameError;
    }

    public WebElement getLastNameError() {
        return lastNameError;
    }

    public WebElement getPasswordError() {
        return PasswordError;
    }
}
