package peageobject.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static pageobject.BasePage.TIME_OUT_30_SECONDS;

public class AirConditionersTests extends BaseTest {
    private static final String PRICE_FILTER_MIN_FORM_VALUE = "80000";
    private static final String PRICE_FILTER_MAX_FORM_VALUE = "81000";
    private static final String EXPECTED_PRICE = "80101 грн";
    private static final String PRODUCT = "//div[contains(@class,'item-prod')]//div[contains(@class,'prise-new')]";

    //Home task Test#2
    @Test(priority = 6)
    public void checkPriceRangeFilter() {
        getHomePage().clickOnAirConditionersButton();
        getAirConditionersPage().setPriceFilterMinValue(PRICE_FILTER_MIN_FORM_VALUE);
        getAirConditionersPage().setPriceFilterMaxValue(PRICE_FILTER_MAX_FORM_VALUE);

        getAirConditionersPage().waitUntilClickable(TIME_OUT_30_SECONDS, getAirConditionersPage().getPriceFilterAcceptButton());
        getAirConditionersPage().clickOnPriceFilterAcceptButton();

        Assert.assertEquals(getAirConditionersPage().getProductPrice(PRODUCT), EXPECTED_PRICE);
    }

}
