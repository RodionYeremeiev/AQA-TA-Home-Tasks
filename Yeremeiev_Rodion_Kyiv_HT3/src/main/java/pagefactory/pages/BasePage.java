package pagefactory.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {
    public static final int TIME_OUT_30_SECONDS = 30;

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void implicitWait(long timeToWait) {
        driver.manage().timeouts().implicitlyWait(timeToWait, TimeUnit.SECONDS);
    }

    public void waitForPageLoadComplete(long timeToWait) {
        new WebDriverWait(driver, timeToWait).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void waitVisibilityOfElement(long timeToWait, WebElement webElement) {
        new WebDriverWait(driver, timeToWait).until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitForElementToBeClickable(long timeToWait, WebElement webElement) {
        new WebDriverWait(driver, timeToWait).until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void waitForUrlContainsString(long timeToWait, String query) {
        new WebDriverWait(driver, timeToWait).until(ExpectedConditions.urlContains(query));
    }


}
