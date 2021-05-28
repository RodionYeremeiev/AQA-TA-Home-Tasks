package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllInOnePersonalComputersPage extends BasePage{
    public AllInOnePersonalComputersPage(WebDriver driver) {
        super(driver);
    }

    public String getAllInOnePcPageURL(){
        return driver.getCurrentUrl();
    }
}
