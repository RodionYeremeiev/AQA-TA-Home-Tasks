package peageobject.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static pageobject.pages.BasePage.TIME_OUT_30_SECONDS;

public class AddToCartTests extends BaseTest {

    private String EXPECTED_AMOUNT_OF_PRODUCTS_IN_CART = "1";

    @Test
    public void checkAddToCart() {
        getHomePage().clickOnProductCatalogButton();
        getHomePage().clickOnAppleStoreButton();
        getAppleStorePage().clickOnIphoneButton();
        getIphonePage().waitForPageLoadComplete(TIME_OUT_30_SECONDS);
        getIphonePage().clickOnAddToCartButton();
        getIphonePage().waitVisibilityOfElement(TIME_OUT_30_SECONDS, getIphonePage().getAddToCartPopup());
        getIphonePage().clickOnContinueShoppingButton();
        assertEquals(getHomePage().getTextOfAmountProductsInCart(), EXPECTED_AMOUNT_OF_PRODUCTS_IN_CART);
    }
}
