package peageobject.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pageobject.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTest {

    private static final String AVIC_URL = "https://avic.ua";
    private WebDriver driver;

    @BeforeTest
    public void profileSetUp() {
        chromedriver().setup();
    }

    @BeforeMethod
    public void testsSetUp() {
        driver = new ChromeDriver();//создаем экзаемпляр хром драйвера
        driver.manage().window().maximize();//открыли браузер на весь экран
        driver.get(AVIC_URL);//открыли сайт
    }

    @AfterMethod
    public void tearDown() {
        driver.close();//закрытие драйвера
    }

    public WebDriver getDriver() {
        return driver;
    }

    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }

    public AppleStorePage getAppleStorePage() {
        return new AppleStorePage(getDriver());
    }

    public IphonePage getIphonePage() {
        return new IphonePage(getDriver());
    }

    public SearchResultPage getSearchResultPage() {
        return new SearchResultPage(getDriver());
    }

    public ElectricalTransportPage getElectricalTransportPage() {
        return new ElectricalTransportPage(getDriver());
    }

    public AirConditionersPage getAirConditionersPage() {
        return new AirConditionersPage(getDriver());
    }

    public AllInOnePersonalComputersPage getAllInOnePersonalComputersPage() {
        return new AllInOnePersonalComputersPage(getDriver());
    }

}
