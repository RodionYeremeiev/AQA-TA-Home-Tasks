package pagefactory.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static pagefactory.pages.BasePage.TIME_OUT_30_SECONDS;


public class FiltersTests extends BaseTest {
    private static final String PRICE_FILTER_MIN_FORM_VALUE = "80000";
    private static final String PRICE_FILTER_MAX_FORM_VALUE = "81000";
    private static final String EXPECTED_PRICE = "80101 грн";
    private static final String AVAILABLE_ONLY_FILTER_CONDITION_ON = "available--on";
    private static final String MANUFACTURER_FILTER_CONDITION_XIAOMI = "proizvoditel--xiaomi";


    //Home task Test#1
    @Test(priority = 5)
    public void checkAmountXiaomiScooterAvailable() {
        getHomePage().clickOnProductCatalogButton();
        getHomePage().clickOnElectricalTransportButton();
        getElectricalTransportPage().clickOnAvailableOnlyFilterButton();
        getElectricalTransportPage().waitForUrlContainsString(TIME_OUT_30_SECONDS, AVAILABLE_ONLY_FILTER_CONDITION_ON);
        getElectricalTransportPage().clickOnManufacturerXiaomiFilterButton();
        getElectricalTransportPage().waitForUrlContainsString(TIME_OUT_30_SECONDS, MANUFACTURER_FILTER_CONDITION_XIAOMI);

        Assert.assertEquals(getElectricalTransportPage().getFilteredXiaomiScootersAmount(), 3);
    }

    //    Home task Test#2
    @Test(priority = 6)
    public void checkPriceRangeFilter() {
        getHomePage().clickOnAirConditionersButton();
        getAirConditionersPage().setPriceFilterMinValue(PRICE_FILTER_MIN_FORM_VALUE);
        getAirConditionersPage().setPriceFilterMaxValue(PRICE_FILTER_MAX_FORM_VALUE);
        getAirConditionersPage().waitForElementToBeClickable(TIME_OUT_30_SECONDS, getAirConditionersPage().getFilterAcceptPriceButton());
        getAirConditionersPage().clickOnFilterAcceptPriceButton();
        Assert.assertEquals(getAirConditionersPage().getSortedAirConditionerItem().getText(), EXPECTED_PRICE);
    }


}
