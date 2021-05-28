package peageobject.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static pageobject.BasePage.TIME_OUT_30_SECONDS;

public class ElectricalTransportTests extends BaseTest {
    private static final String AVAILABLE_FILTER_CONDITION = "available--on";
    private static final String XIAOMI_FILTER_CONDITION = "proizvoditel--xiaomi";
    private static final String XIAOMI_ELECTRICAL_SCOOTER = "//div[contains(@class,'prod-cart')]//div[contains(text(),'Xiaomi Mi Electric Scooter')]";
    private static final int EXPECTED_AMOUNT = 3;

    //Home task Test#1
    @Test(priority = 5)
    public void checkAmountXiaomiScooterAvailable() {
        getHomePage().clickOnProductCatalogButton();
        getHomePage().clickOnElectricalTransportButton();
        getElectricalTransportPage().clickOnAvailableFilterCheckBox();
        getElectricalTransportPage().waitForPageContainUrl(TIME_OUT_30_SECONDS, AVAILABLE_FILTER_CONDITION);
        getElectricalTransportPage().clickOnXiaomiFilterCheckBox();
        getElectricalTransportPage().waitForPageContainUrl(TIME_OUT_30_SECONDS, XIAOMI_FILTER_CONDITION);
        Assert.assertEquals(getElectricalTransportPage().countElements(XIAOMI_ELECTRICAL_SCOOTER), EXPECTED_AMOUNT);
    }

}
