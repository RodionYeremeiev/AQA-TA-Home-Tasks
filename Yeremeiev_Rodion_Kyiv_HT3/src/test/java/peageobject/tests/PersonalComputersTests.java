package peageobject.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static pageobject.BasePage.TIME_OUT_30_SECONDS;

public class PersonalComputersTests extends BaseTest {

    private static final String EXPECTED_QUERY = "proizvoditel--asus";

    //Home task Test#3
    @Test(priority = 7)
    public void checkPopUpsAllInOnePcAsus() {
        getHomePage().moveToPersonalComputersPopUp();
        getHomePage().waitForPopUpNextLevelVisible(TIME_OUT_30_SECONDS, getHomePage().getAllInOnePersonalComputersPopUpLocator());
        getHomePage().moveToAllInOnePersonalComputersPopUp();
        getHomePage().clickOnAsusButton();
        assertTrue(getAllInOnePersonalComputersPage().getAllInOnePcPageURL().contains(EXPECTED_QUERY));
    }

}
