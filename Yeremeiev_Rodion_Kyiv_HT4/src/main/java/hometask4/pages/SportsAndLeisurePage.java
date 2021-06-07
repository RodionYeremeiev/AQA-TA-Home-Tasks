package hometask4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SportsAndLeisurePage extends BasePage {


    @FindBy(xpath = "//section[contains(@class,'b-visualnav')]//a[contains(@href,'Camping-Hiking')]")
    private WebElement campingAndHikingButton;

    public SportsAndLeisurePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getCampingAndHikingButton() {
        return campingAndHikingButton;
    }

    public void clickOnCampingAndHikingButton(){
        getCampingAndHikingButton().click();
    }
}
