package peageobject.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static pageobject.pages.BasePage.TIME_OUT_30_SECONDS;

public class SideBarTests extends BaseTest {
    private static final String EXPECTED_MANUFACTURER = "proizvoditel--asus";

    //Home task Test#3
    @Test(priority = 7)
    public void checkSideBarAccessToAllInOnePcAsus() {
        getHomePage().moveToPersonalComputersButton();
        getHomePage().waitVisibilityOfElement(TIME_OUT_30_SECONDS, getHomePage().getAllInOnePersonalComputersButton());
        getHomePage().moveToAllInOnePersonalComputersButton();
        getHomePage().clickOnAsusAllInOnePcButton();
        assertTrue(getDriver().getCurrentUrl().contains(EXPECTED_MANUFACTURER));
    }

}
