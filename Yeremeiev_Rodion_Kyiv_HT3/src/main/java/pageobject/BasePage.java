package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.xpath;

public class BasePage {
    public static final int TIME_OUT_30_SECONDS = 30;

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForLoadingComplete(long timeToWait) {
        new WebDriverWait(driver, timeToWait).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));//wait for page loading
    }

    /**
     *
     * @param timeout
     * @param locator
     *  ждем пока не отобразится попап с товаром добавленным в корзину
     */
    public void waitForVisibilityOfElement(long timeout, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForVisibilityOfElement(long timeout, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForPopUpNextLevelVisible(long timeout, String locator){
        WebElement webElement = driver.findElement(By.xpath(locator));
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(webElement));
    }

    /**
     *  неявное ожидание 30 сек
     */
    public void implicitWait(long timeout, TimeUnit timeUnit) {
        driver.manage().timeouts().implicitlyWait(timeout, timeUnit);
    }

    public void waitForPageContainUrl(long timeout, String condition){
        new WebDriverWait(driver, timeout).until(ExpectedConditions.urlContains(condition));
    }

    public void waitUntilClickable(long timeout, WebElement webElement){
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /**
     * собрали элементы поиска в лист;
     *
     * @return Returns a List<WebElement> of element found
     */
    public List<WebElement> getSearchResultList(String locator) {
        return driver.findElements(By.xpath(locator));
    }

    /**
     * @return узнали количество элементов в листе
     */
    public int countElements(String locator) {
        return getSearchResultList(locator).size();
    }

    public String getProductPrice(String locator){
        return driver.findElement(By.xpath(locator)).getText();
    }



}
