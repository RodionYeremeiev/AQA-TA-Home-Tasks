package avic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.Keys.ENTER;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AvicTests {

    private WebDriver driver;

    @BeforeTest
    public void profileSetUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }

    @BeforeMethod
    public void testsSetUp() {
        driver = new ChromeDriver();//создаем экзаемпляр хром драйвера
        driver.manage().window().maximize();//открыли браузер на весь экран
        driver.get("https://avic.ua/");//открыли сайт
    }

    @Test(priority = 1)
    public void checkThatUrlContainsSearchWord() {
        driver.findElement(xpath("//input[@id='input_search']")).sendKeys("iPhone 11", ENTER);//вводим в поиск iPhone 11
        assertTrue(driver.getCurrentUrl().contains("query=iPhone"));//проверяем что урла содержит кверю
    }

    @Test(priority = 2)
    public void checkElementsAmountOnSearchPage() {
        driver.findElement(xpath("//input[@id='input_search']")).sendKeys("iPhone 11", ENTER);//вводим в поиск iPhone 11
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//неявное ожидание 30 сек
        List<WebElement> elementsList = driver.findElements(xpath("//div[@class='prod-cart__descr']"));//собрали элементы поиска в лист
        int actualElementsSize = elementsList.size();//узнали количество элементов в листе
        assertEquals(actualElementsSize, 12);//сравнили количество элементов актуальное с тем которое ожидаем
    }

    @Test(priority = 3)
    public void checkThatSearchResultsContainsSearchWord() {
        driver.findElement(xpath("//input[@id='input_search']")).sendKeys("iPhone 11", ENTER);//вводим в поиск iPhone 11
        List<WebElement> elementList = driver.findElements(xpath("//div[@class='prod-cart__descr']"));//собрали элементы поиска в лист
        for (WebElement webElement : elementList) { //прошлись циклом и проверили что каждый элемент листа содержит текс iPhone 11
            assertTrue(webElement.getText().contains("iPhone 11"));
        }
    }

    @Test(priority = 4)
    public void checkAddToCart() {
        driver.findElement(xpath("//span[@class='sidebar-item']")).click();//каталог товаров
        driver.findElement(xpath("//ul[contains(@class,'sidebar-list')]//a[contains(@href, 'apple-store')]")).click();//Apple Store
        driver.findElement(xpath("//div[@class='brand-box__title']/a[contains(@href,'iphone')]")).click();//iphone
        new WebDriverWait(driver, 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));//wait for page loading
        driver.findElement(xpath("//a[@class='prod-cart__buy'][contains(@data-ecomm-cart,'64GB Black (MGDX3)')]")).click();//add to cart iphone
        WebDriverWait wait = new WebDriverWait(driver, 30);//ждем пока не отобразится попап с товаром добавленным в корзину
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js_cart")));
        driver.findElement(xpath("//div[@class='btns-cart-holder']//a[contains(@class,'btn--orange')]")).click();//продолжить покупки
        String actualProductsCountInCart =
                driver.findElement(xpath("//div[contains(@class,'header-bottom__cart')]//div[contains(@class,'cart_count')]")).getText();//получили 1 которая в корзине (один продукт)
        assertEquals(actualProductsCountInCart, "1");
    }

    //Home task Test#1
    @Test(priority = 5)
    public void checkAmountXiaomiScooterAvailable() {
        driver.findElement(By.xpath("//span[@class='sidebar-item']")).click();
        driver.findElement(By.xpath("//ul[@class='sidebar-list sidebar-list--fl']//a[@href='https://avic.ua/girobordyi-i-giroskuteryi']")).click();

        driver.findElement(By.xpath("//div[contains(@class,'filter')]//label[@for='fltr-1']")).click();
        new WebDriverWait(driver, 30).until(ExpectedConditions.urlContains("available--on"));

        driver.findElement(By.xpath("//div[contains(@class,'filter')]//label[@for='fltr-proizvoditel-xiaomi']")).click();
        new WebDriverWait(driver, 30).until(ExpectedConditions.urlContains("proizvoditel--xiaomi"));

        List<WebElement> elementList = driver.findElements(By.xpath("//div[contains(@class,'prod-cart')]//div[contains(text(),'Xiaomi Mi Electric Scooter')]"));

        Assert.assertEquals(elementList.size(), 3);
    }

    //Home task Test#2
    @Test(priority = 6)
    public void checkPriceRangeFilter() {
        WebElement webElement;
        driver.findElement(By.xpath("//div[contains(@class,'top-links flex')]//a[contains(@href,'kondiczionery')]")).click();

        driver.findElement(By.xpath("//div[@class='row-m']//input[contains(@class,'form-control-min')]")).clear();
        driver.findElement(By.xpath("//div[@class='row-m']//input[contains(@class,'form-control-min')]")).sendKeys("80000", ENTER);

        driver.findElement(By.xpath("//div[@class='row-m']//input[contains(@class,'form-control-max')]")).clear();
        driver.findElement(By.xpath("//div[@class='row-m']//input[contains(@class,'form-control-max')]")).sendKeys("81000", ENTER);

        webElement = driver.findElement(By.xpath("//div[contains(@class,'form-group')]//a[contains(@class,'filters_accept')]"));
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();

        webElement = driver.findElement(By.xpath("//div[contains(@class,'item-prod')]//div[contains(@class,'prise-new')]"));
        Assert.assertEquals(webElement.getText(), "80101 грн");
    }

    //Home task Test#3
    @Test(priority = 7)
    public void checkPopUpsAllInOnePcAsus() {
        WebElement webElement;
        Actions actions = new Actions(driver);
        webElement = driver.findElement(By.xpath("//ul[contains(@class, 'sidebar-list')]//a[contains(@href,'elektronika')]"));
        actions.moveToElement(webElement).build().perform();

        webElement = driver.findElement(By.xpath("//li[contains(@class, 'parent js_sidebar-item')]//a[contains(text(),'Моноблоки (All in one)')]"));

        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(webElement));

        actions.moveToElement(webElement).build().perform();

        webElement = driver.findElement(By.xpath("//ul[@class='third-level-item js_height-block']//a[contains(@href,'monobloki/proizvoditel--asus')]"));
        webElement.click();

        assertTrue(driver.getCurrentUrl().contains("proizvoditel--asus"));
    }

    //Home task Test#4
    @Test(priority = 8)
    public void checkProductIsAvailableAgainEmail() {
        WebElement webElement;

        driver.findElement(xpath("//input[@id='input_search']")).sendKeys("toster", ENTER);//вводим в поиск iPhone 11


        driver.findElement(By.xpath("//div[@data-product='231494']//a[contains(@href,'availableProduct')]")).click();

        webElement = driver.findElement(By.xpath("//div[@class='modal-middle']//input[@name='email']"));
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(webElement));
        webElement.sendKeys("email@something.com", ENTER);

        webElement = driver.findElement(By.xpath("//div[@id='modalAlert']//div[@class='ttl js_title']"));
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(webElement));

        assertEquals(webElement.getText(), "Успешно!");

    }

    @AfterMethod
    public void tearDown() {
        driver.close();//закрытие драйвера
    }
}
