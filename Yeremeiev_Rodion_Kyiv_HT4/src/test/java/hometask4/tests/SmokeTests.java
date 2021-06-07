package hometask4.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SmokeTests extends BaseTest {
    // TODO: implement test methods watch for correct class and package names
    private static final long TIME_OUT_30 = 30;
    private static final long TIME_OUT_60 = 60;
    private static final long TIME_OUT_90 = 90;
    private static final long TIME_OUT_120 = 120;

    private static final String EXPECTED_AMOUNT_IN_BASKET = "1";
    private static final String EXPECTED_ADD_TO_BASKET_HEADER_TEXT = "1 item added to basket";
    private static final String EXPECTED_LANGUAGE = "United Kingdom";
    private static final String SEARCH_REQUEST = "tent";
    private static final String EXPECTED_PRICE = "£23.99";

    @Test
    public void checkHomePageComponents() {
        getHomePage().waitForPageLoadComplete(TIME_OUT_90);
        getHomePage().isHeaderVisible();
        getHomePage().isFooterVisible();
        getHomePage().isSignInButtonVisible();
        getHomePage().isRegisterButtonVisible();
        getHomePage().moveMyEbayButton();
        getHomePage().waitForVisibilityOfElement(TIME_OUT_90, getHomePage().getMyEbayPopUp());
        Assert.assertTrue(getHomePage().isMyEbayPopUpVisible());
        getHomePage().waitForPageLoadComplete(TIME_OUT_90);
        getHomePage().isShoppingBasketVisible();
        getHomePage().moveToShoppingBasket();
        getHomePage().waitForVisibilityOfElement(TIME_OUT_90, getHomePage().getShoppingBasketPopUp());
        Assert.assertTrue(getHomePage().isShoppingBasketPopUpVisible());
        getHomePage().waitForPageLoadComplete(TIME_OUT_90);
        getHomePage().isSearchInputVisible();
        getHomePage().isSearchButtonVisible();
        getHomePage().isLanguageButtonVisible();
        Assert.assertEquals(getHomePage().getLanguageButtonUK().getText(), EXPECTED_LANGUAGE);
        assertTrue(getDriver().getCurrentUrl().contains("uk"));
    }

    @Test
    public void chekSignInPage() {
        getHomePage().waitForPageLoadComplete(TIME_OUT_60);
        getHomePage().clickOnSignInButton();
        getSignInPage().waitForPageLoadComplete(TIME_OUT_60);
        Assert.assertTrue(getSignInPage().isUserNameFieldVisible());
        Assert.assertTrue(getSignInPage().isContinueButtonVisible());
        Assert.assertTrue(getSignInPage().isSignInViaFaceBookVisible());
        Assert.assertTrue(getSignInPage().isSignInViaGoogleVisible());
        Assert.assertTrue(getSignInPage().isSignInViaAppleVisible());
    }

    @Test
    public void checkRegisterPage() {
        getHomePage().waitForPageLoadComplete(TIME_OUT_60);
        getHomePage().clickOnRegisterButton();
        getRegisterPage().waitForPageLoadComplete(TIME_OUT_60);
        Assert.assertTrue(getRegisterPage().isUserFirstNameFieldVisible());
        Assert.assertTrue(getRegisterPage().isUserLastNameFieldVisible());
        Assert.assertTrue(getRegisterPage().isUserEmailFieldVisible());
        Assert.assertTrue(getRegisterPage().isUserPasswordFieldVisible());
        Assert.assertTrue(getRegisterPage().isRegisterButtonVisible());
        Assert.assertFalse(getRegisterPage().isRegisterButtonEnabled());
        Assert.assertTrue(getRegisterPage().isContinueViaFaceBookVisible());
        Assert.assertTrue(getRegisterPage().isContinueViaGoogleVisible());
        Assert.assertTrue(getRegisterPage().isContinueViaAppleVisible());

    }

    @Test
    public void checkSearchWithAndWithoutSearchButton() {
        getHomePage().setSearchInputFieldWithSearchButton(SEARCH_REQUEST);
        getSearchResultPage().waitForPageLoadComplete(TIME_OUT_60);
        Assert.assertEquals(getSearchResultPage().getItemPrice(), EXPECTED_PRICE);
        getHomePage().waitForPageLoadComplete(TIME_OUT_60);
        getSearchResultPage().waitForElementToBeClickable(TIME_OUT_60, getSearchResultPage().getEbayHomeButton());
        getSearchResultPage().clickOnEbayHomeButton();
        getHomePage().waitForPageLoadComplete(TIME_OUT_60);
        getHomePage().setSearchInputFieldWithEnterKey(SEARCH_REQUEST);
        getHomePage().waitForPageLoadComplete(TIME_OUT_60);
        Assert.assertEquals(getSearchResultPage().getItemPrice(), EXPECTED_PRICE);
    }

    @Test
    public void checkAddToCart() {
        getHomePage().waitForPageLoadComplete(TIME_OUT_60);
        getHomePage().clickOnSportsAndLeisureButton();
        getSportsAndLeisurePage().clickOnCampingAndHikingButton();
        getCampingAndHikingPage().clickOnScarpaCyrusBootsButton();
        getProductPage().clickAddToBasketButton();
        getProductPage().waitForVisibilityOfElement(TIME_OUT_60, getProductPage().getAddToBasketPopUp());
        Assert.assertEquals(getProductPage().getAddToBasketPopUpHeaderText(), EXPECTED_ADD_TO_BASKET_HEADER_TEXT);
        getProductPage().clickOnAddToBasketPopUpCloseButton();
        getProductPage().waitForVisibilityOfElement(TIME_OUT_60, getHomePage().getCartCount());
        Assert.assertEquals(getHomePage().getCartCount().getText(), EXPECTED_AMOUNT_IN_BASKET);
    }
}
