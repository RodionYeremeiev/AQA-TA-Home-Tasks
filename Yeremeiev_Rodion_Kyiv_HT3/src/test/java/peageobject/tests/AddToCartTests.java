package peageobject.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static pageobject.BasePage.TIME_OUT_30_SECONDS;

public class AddToCartTests extends BaseTest {
    private static final String EXPECTED_AMOUNT_OF_PRODUCTS_IN_CART = "1";

    @Test(priority = 4)
    public void checkAddToCart() {
        getHomePage().clickOnProductCatalogButton();
        getHomePage().clickOnAppleStorePage();
        getAppleStorePage().clickOnIphoneButton();
        getIphonePage().waitForLoadingComplete(TIME_OUT_30_SECONDS);
        getIphonePage().clickOnAddToCartButton();

        getIphonePage().waitForVisibilityOfElement(TIME_OUT_30_SECONDS, getIphonePage().getAddToCartPopUp());

        getIphonePage().clickOnContinueShoppingButton();

        assertEquals(getHomePage().getTextOfAmountProductsInCart(), EXPECTED_AMOUNT_OF_PRODUCTS_IN_CART);
    }
}
