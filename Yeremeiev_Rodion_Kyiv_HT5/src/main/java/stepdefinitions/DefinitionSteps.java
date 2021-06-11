package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.Arrays;
import java.util.List;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DefinitionSteps {
    private static final long DEFAULT_TIMEOUT = 60;
    WebDriver driver;
    HomePage homePage;
    ProductPage productPage;
    SavedItemsPage savedItemsPage;
    SearchResultPage searchResultPage;
    RegistrationPage registrationPage;
    LogInPage logInPage;
    MyBagPage myBagPage;
    MarketPlacePage marketPlacePage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User clicks on sunnies button")
    public void userClicksOnSunniesButton() {
        homePage.clickOnSunniesButton();
    }


    @And("User clicks save for later button on round sunglasses")
    public void userClicksSaveForLaterButtonOnRoundSunglasses() {
        homePage.clickSaveForLater();
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
    }

    @And("User clicks on Ray-Ban sunglasses to go to Product page")
    public void userClicksOnRayBanSunglassesToGoToProductPage() {
        homePage.clickOnRayBanGlassesButton();
        productPage = pageFactoryManager.getProductPage();
    }

    @And("User clicks on save item from Product page")
    public void userClicksOnSaveItemFromProductPage() {
        productPage.waitForPageLoadingComplete(DEFAULT_TIMEOUT);
        productPage.clickOnSaveProductForLaterButton();
    }

    @When("User clicks on saved items")
    public void userClicksOnSavedItems() {
        homePage.clickOnSavedItemsButton();
        savedItemsPage = pageFactoryManager.getSavedItemsPage();
    }

    @Then("User checks that list of saved products contains {int} elements")
    public void userChecksThatListOfSavedProductsContainsNumberOfElementsElements(int numberOfElements) {
        savedItemsPage.waitForPageLoadingComplete(DEFAULT_TIMEOUT);
        savedItemsPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        savedItemsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, savedItemsPage.getListOfSavedItems().get(0));
        Assert.assertEquals(savedItemsPage.getListOfSavedItems().size(), numberOfElements);
    }


    @And("User checks header visibility")
    public void userChecksHeaderVisibility() {
        homePage.waitForPageLoadingComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.isHeaderVisible();
    }

    @And("User checks footer visibility")
    public void userChecksFooterVisibility() {
        homePage.isFooterVisible();
    }

    @And("User checks search field visibility")
    public void userChecksSearchFieldVisibility() {
        homePage.isSearchFieldVisible();
    }

    @And("User checks my account popup visibility")
    public void userChecksMyAccountPopupVisibility() {
        homePage.moveToElement(homePage.getMyAccountButton());
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getMyAccountPopUp());
        homePage.isMyAccountPopUpVisible();
    }

    @And("User checks saved items button visibility")
    public void userChecksSavedItemsButtonVisibility() {
        homePage.isSavedItemsButtonVisible();
    }

    @And("User check bag button visibility")
    public void userCheckBagButtonVisibility() {
        homePage.isBagButtonVisible();
    }

    @Then("User checks that sale popup is visible and contains {int} in Shop sale by product section")
    public void checkSalePopup(final int amountOfElements) {
        homePage.moveToElement(homePage.getSalePopUpButton());
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getSalePopUp());
        Assert.assertEquals(homePage.getSalePopUpProductsList().size(), amountOfElements);
    }

    @And("User checks that New in popup is visible and contains {int} in New Products section")
    public void checkNewInPopup(final int amountOfElements) {
        homePage.moveToElement(homePage.getNewInPopUpButton());
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getNewInPopUp());
        Assert.assertEquals(homePage.getNewInPopUpProductsList().size(), amountOfElements);
    }

    @And("User checks that Topman popup is visible and contains {int} in Shop by product section")
    public void userChecksThatTopmanPopupIsVisibleAndContainsTopManInShopByProductSection(final int amountOfElements) {
        homePage.moveToElement(homePage.getTopManPopUpButton());
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getTopManPopUp());
        Assert.assertEquals(homePage.getTopManPopUpProductsList().size(), amountOfElements);
    }

    @And("User clicks on Women button")
    public void userClicksOnWomenButton() {
        homePage.clickOnWomenButton();
    }

    @And("User checks that Women's Sale Carousel is visible")
    public void checkWomanCarouselVisible() {
        homePage.isWomanCarouselVisible();
    }

    @And("User clicks on Carousel scroll forward button")
    public void userClicksOnCarouselScrollForwardButton() {
        homePage.waitForClickAbilityofElement(DEFAULT_TIMEOUT, homePage.getScrollForwardButton());
        homePage.clickOnScrollForwardButton();
    }

    @And("User checks that Carousel where scrolled forward")
    public void userChecksThatCarouselWhereScrolledForward() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getCarouselLastElement());
        Assert.assertTrue(homePage.isLastCarouselElementVisible());
    }

    @When("User clicks on Carousel scroll backward button")
    public void userClicksOnCarouselScrollBackwardButton() {
        homePage.waitForClickAbilityofElement(DEFAULT_TIMEOUT, homePage.getScrollBackwardButton());
        homePage.clickOnScrollBackWardButton();
    }

    @And("User checks that Carousel where scrolled backward")
    public void userChecksThatCarouselWhereScrolledBackward() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getCarouselFirstElement());
        Assert.assertTrue(homePage.isFirstCarouselElementVisible());
    }

    @Then("User checks that Carousel has correct {int} of elements")
    public void userChecksThatCarouselHasCorrectAmountOfElements(final int amountOfElements) {
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        Assert.assertEquals(homePage.getCarouselElementsList().size(), amountOfElements);
    }

    @And("User checks that correct initial titles are displayed")
    public void userChecksThatCorrectInitialTitlesAreDisplayed() {
        List<String> expectedCarouselTitles = Arrays.asList("DRESSES", "TOPS", "SHOES", "JEANS", "SWIMWEAR", "SKIRTS", "");
        List<WebElement> actualCarouselTitles = homePage.getCarouselElementsList();
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        for (int i = 0; i < homePage.getCarouselElementsList().size(); i++) {
            System.out.println(actualCarouselTitles.get(i).getText());
            Assert.assertEquals(actualCarouselTitles.get(i).getText(), expectedCarouselTitles.get(i));
        }
    }

    @And("User checks that correct titles are displayed after scrolling forward")
    public void userChecksThatCorrectTitlesAreDisplayedAfterScrollingForward() {
        List<String> expectedCarouselTitles = Arrays.asList("", "TOPS", "SHOES", "JEANS", "SWIMWEAR", "SKIRTS", "ACCESSORIES");
        List<WebElement> actualCarouselTitles = homePage.getCarouselElementsList();
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        for (int i = 0; i < homePage.getCarouselElementsList().size(); i++) {
            System.out.println(actualCarouselTitles.get(i).getText());
            Assert.assertEquals(actualCarouselTitles.get(i).getText(), expectedCarouselTitles.get(i));
        }
    }

    @And("User checks that Carousel correct titles are displayed after scrolling backward")
    public void userChecksThatCarouselCorrectTitlesAreDisplayedAfterScrollingBackward() {
        List<String> expectedCarouselTitles = Arrays.asList("DRESSES", "TOPS", "SHOES", "JEANS", "SWIMWEAR", "SKIRTS", "");
        List<WebElement> actualCarouselTitles = homePage.getCarouselElementsList();
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        for (int i = 0; i < homePage.getCarouselElementsList().size(); i++) {
            System.out.println(actualCarouselTitles.get(i).getText());
            Assert.assertEquals(actualCarouselTitles.get(i).getText(), expectedCarouselTitles.get(i));
        }
    }

    @And("User enters search {string} to search field")
    public void userEntersSearchKeywordToSearchField(final String keyword) {
        homePage.waitForPageLoadingComplete(DEFAULT_TIMEOUT);
        homePage.inputSearchQuery(keyword + " shoes");
        homePage.clickSearchButton();
    }

    @And("User clicks Search button")
    public void userClicksSearchButton() {
        homePage.clickSearchButton();
        searchResultPage = pageFactoryManager.getSearchResultPage();
    }

    @When("User checks that all search results contains {string}")
    public void userChecksThatAllSearchResultsContainsKeyword(final String keyword) {
        searchResultPage.waitForPageLoadingComplete(DEFAULT_TIMEOUT);
        Assert.assertTrue(searchResultPage.checkResultListContainsKeyword(keyword));
    }

    @And("User checks that URL contains {string}")
    public void userChecksThatURLContainsKeyword(final String keyword) {
        homePage.waitForPageLoadingComplete(DEFAULT_TIMEOUT);
        Assert.assertTrue(driver.getCurrentUrl().contains(keyword));
    }

    @And("check that Search result title contains {string}")
    public void checkThatSearchResultTitleContainsKeyword(final String keyword) {
        homePage.waitForPageLoadingComplete(DEFAULT_TIMEOUT);
        Assert.assertTrue(searchResultPage.checkSearchResultTitleContainsKeyWord(keyword));
    }

    @Then("User checks that search result page contains correct {int} of products")
    public void userChecksThatSearchResultPageContainsCorrectAmountOfProducts(final int expectedAmount) {
        homePage.waitForPageLoadingComplete(DEFAULT_TIMEOUT);
        Assert.assertTrue((searchResultPage.getSearchResultAmount() - expectedAmount) <= 10
                || (searchResultPage.getSearchResultAmount() - expectedAmount) >= -10);
    }

    @And("User moves cursor to My Account button")
    public void userMovesCursorToMyAccountButton() {
        homePage.moveToElement(homePage.getMyAccountButton());
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getMyAccountPopUp());
    }

    @And("User clicks Join Button at popup menu")
    public void userClicksJoinButtonAtPopupMenu() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getMyAccountPopUp());
        homePage.clickJoinButton();
        registrationPage = pageFactoryManager.getRegistrationPage();
        registrationPage.waitForPageLoadingComplete(DEFAULT_TIMEOUT);
    }

    @And("User enters valid Email into registration form")
    public void userEntersValidEmailIntoRegistrationForm() {
        registrationPage.inputGeneratedEmail();
    }

    @And("User enters valid First Name registration form")
    public void userEntersValidFirstNameRegistrationForm() {
        registrationPage.inputGeneratedString(registrationPage.getFirstNameField());
    }

    @And("User enters valid Last Name registration form")
    public void userEntersValidLastNameRegistrationForm() {
        registrationPage.inputGeneratedString(registrationPage.getLastNameField());
    }

    @And("User enters valid Password registration form")
    public void userEntersValidPasswordRegistrationForm() {
        registrationPage.inputGeneratedString(registrationPage.getPasswordNameField());
    }

    @And("User selects date of birth")
    public void userSelectsDateOfBirth() {
        registrationPage.clickDaySelector();
        registrationPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, registrationPage.getDayFifteen());
        registrationPage.getDayFifteen().click();
        registrationPage.waitForAjaxToCompletePdp(DEFAULT_TIMEOUT);
        registrationPage.clickMonthSelector();
        registrationPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, registrationPage.getJanuary());
        registrationPage.getJanuary().click();
        registrationPage.waitForAjaxToCompletePdp(DEFAULT_TIMEOUT);
        registrationPage.clickYearSelector();
        registrationPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, registrationPage.getYear2005());
        registrationPage.getYear2005().click();
        registrationPage.waitForAjaxToCompletePdp(DEFAULT_TIMEOUT);
        registrationPage.waitForPageLoadingComplete(DEFAULT_TIMEOUT);
    }

    @And("User clicks on Select All button for Contact Preferences")
    public void userClicksOnSelectAllButtonForContactPreferences() {
        registrationPage.clickOnSelectAllButton();
    }

    @Then("User checks that all input fields are valid")
    public void userChecksThatAllInputFieldsAreValid() {
        registrationPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, registrationPage.getSubmitButton());
        Assert.assertTrue(registrationPage.submitButtonIsVisible());
    }

    @And("User clicks on Join Asos button")
    public void userClicksOnJoinAsosButton() {
        registrationPage.clickOnSubmitButton();
    }

    @Then("User opens {string} again to check if registration were successful")
    public void checkIfRegistrationIsSuccessful(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
        Assert.assertFalse(registrationPage.signInButtonIsVisible());
    }

    @And("User clicks Sign In button")
    public void userClicksSignInButton() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getMyAccountPopUp());
        homePage.clickSignInButton();
        logInPage = pageFactoryManager.getLogInPage();
        logInPage.waitForPageLoadingComplete(DEFAULT_TIMEOUT);
    }


    @When("User input valid {string} in email form and click Enter")
    public void userInputValidEmail(final String email) {
        logInPage.waitForPageLoadingComplete(DEFAULT_TIMEOUT);
        logInPage.inputInValidEmail(email);
    }

    @And("User input valid {string} in password form")
    public void userInputValidPassword(final String password) {
        logInPage.waitForPageLoadingComplete(DEFAULT_TIMEOUT);
        logInPage.inputInValidPassword(password);
    }

    @And("User clicks Submit Button")
    public void userClicksSubmitButton() {
        logInPage.waitForPageLoadingComplete(DEFAULT_TIMEOUT);
        logInPage.clickOnSignInButton();
    }

    @And("User input Invalid {string} in email form and click Enter")
    public void InvalidEmailInput(final String email) {
        logInPage.waitForPageLoadingComplete(DEFAULT_TIMEOUT);
        logInPage.inputInValidEmail(email);
    }

    @And("User input Invalid {string} in password form and click Enter")
    public void InvalidPasswordInput(final String password) {
        logInPage.waitForPageLoadingComplete(DEFAULT_TIMEOUT);
        logInPage.inputInValidPassword(password);
    }

    @Then("User checks are Warning displayed")
    public void userChecksAreWarningDisplayed() {
        logInPage.waitForPageLoadingComplete(DEFAULT_TIMEOUT);
        logInPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, logInPage.getEmailError());
        Assert.assertTrue(logInPage.isEmailErrorVisible());
        logInPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, logInPage.getPasswordError());
        Assert.assertTrue(logInPage.isPasswordErrorVisible());
        Assert.assertFalse(logInPage.isSignInButtonClickable());
    }

    @Then("User checks that all input fields are displaying error warnings")
    public void userChecksThatAllInputFieldsAreDisplayingErrorWarnings() {
        registrationPage.waitForPageLoadingComplete(DEFAULT_TIMEOUT);
        registrationPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, registrationPage.getEmailErrorMessage());
        Assert.assertTrue(registrationPage.visibilityOfEmailError());
        registrationPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, registrationPage.getFirstNameError());
        Assert.assertTrue(registrationPage.visibilityOfFirstNameError());
        registrationPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, registrationPage.getLastNameError());
        Assert.assertTrue(registrationPage.visibilityOfLastNameError());
        registrationPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, registrationPage.getPasswordError());
        Assert.assertTrue(registrationPage.visibilityOfPasswordError());
    }

    @And("User enters Invalid {string} into Email field of registration form and Press Enter")
    public void invalidEmailRegistration(final String email) {
        registrationPage.inputInvalidEmail(email);
    }

    @And("User enters Invalid {string} into First name field of registration form and Press Enter")
    public void invalidFirstNameRegistration(final String firstName) {
        registrationPage.inputInvalidFirstName(firstName);
    }

    @And("User enters Invalid {string} into Last name field of registration form and Press Enter")
    public void invalidLastNameRegistration(final String lastName) {
        registrationPage.inputInvalidLastName(lastName);
    }


    @When("User enters Invalid {string} into Password field of registration form and Press Enter")
    public void invalidPasswordRegistration(final String password) {
        registrationPage.inputInvalidPassword(password);
    }

    @And("User clicks on Mango Umbrella item")
    public void userClicksOnMangoUmbrellaItem() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitForPageLoadingComplete(DEFAULT_TIMEOUT);
        searchResultPage.clickOnMangoUmbrella();
        searchResultPage.waitForPageLoadingComplete(DEFAULT_TIMEOUT);
        productPage = pageFactoryManager.getProductPage();
    }

    @And("User clicks on add to Bag Button")
    public void userClicksOnAddToBagButton() {
        productPage.waitForPageLoadingComplete(DEFAULT_TIMEOUT);
        productPage.clickOnAddToBagButton();
    }

    @And("User clicks on close popup button")
    public void userClicksOnClosePopupButton() {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getBagPopUp());
        productPage.getBagPopUp().click();
        productPage.waitForPageLoadingComplete(DEFAULT_TIMEOUT);
    }

    @When("bag icon shows {string} elements")
    public void bagIconShowsAmountElements(final String counter) {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getBagCounter());
        Assert.assertEquals(productPage.getBagCounter().getText(), counter);
    }

    @And("User clicks on Bag Button")
    public void userClicksOnBagButton() {
        productPage.waitForPageLoadingComplete(DEFAULT_TIMEOUT);
        productPage.clickOnBagButton();
    }

    @And("User clicks on view bag button")
    public void userClicksOnViewBagPopUpButton() {
        productPage.waitForPageLoadingComplete(DEFAULT_TIMEOUT);
        productPage.clickOnPopupViewBagButton();
        myBagPage = pageFactoryManager.getMyBagPage();
    }


    @And("User checks items {string}")
    public void userChecksItemsPrice(final String priceExpected) {
        myBagPage.waitForPageLoadingComplete(DEFAULT_TIMEOUT);
        Assert.assertEquals(myBagPage.getItemsSubTotalPrice().getText(), priceExpected);
    }


    @And("User clicks on Marketplace button")
    public void userClicksOnMarketplaceButton() {
        homePage.waitForPageLoadingComplete(DEFAULT_TIMEOUT);
        homePage.clickOnMarketPlaceButton();
        marketPlacePage = pageFactoryManager.getMarketPlacePage();
    }

    @And("User check that {string} matches expected")
    public void userCheckThatUrlMatchesExpected(final String url) {
        marketPlacePage.waitForPageLoadingComplete(DEFAULT_TIMEOUT);
        Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase(url));
    }

    @And("User clicks on Sell Here button")
    public void userClicksOnSellHereButton() {
        marketPlacePage.waitForAjaxToCompletePdp(DEFAULT_TIMEOUT);
        marketPlacePage.clickOnSellHereButton();
    }

    @And("User checks that Info-page header contains {string}")
    public void userChecksThatInfoPageHeaderContainsKeyword(final String keyword) {
        marketPlacePage.waitForPageLoadingComplete(DEFAULT_TIMEOUT);
        Assert.assertTrue(marketPlacePage.getInfoPageHeader().getText().contains(keyword));
    }

    @When("User clicks on Apply for boutique button")
    public void userClicksOnApplyForBoutiqueButton() {
        marketPlacePage.waitForPageLoadingComplete(DEFAULT_TIMEOUT);
        marketPlacePage.clickOnApplyForBoutiqueButton();
    }

    @Then("User checks that social button Sign In with Facebook leads to correct Url")
    public void userChecksThatSocialButtonSignInWithFacebookLeadsToCorrectUrl() {
        marketPlacePage.getSignInFacebookButton().click();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("facebook"));
    }


    @Then("User checks that footters external link leads back to Asos.com Url")
    public void userChecksThatFoottersExternalLinkLeadsBackToAsosComUrl() {
        marketPlacePage.clickOnExternalLink();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("asos.com"));
    }

    @And("User clicks country button")
    public void userClicksCountryButton() {
        homePage.waitForPageLoadingComplete(DEFAULT_TIMEOUT);
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getCountryButton());
        homePage.clickOnCountryButton();
    }

    @And("User checks that country is {string}")
    public void userChecksThatCountryIsCountry(final String country) {
        Assert.assertEquals(homePage.getCountryButton().getText(), country);
    }

    @And("User changes currency to USD")
    public void userChangesCurrencyToUSD() {
        homePage.waitForPageLoadingComplete(DEFAULT_TIMEOUT);
        homePage.clickOnUsdButton();
    }

    @And("User click on Update button")
    public void userClickOnUpdateButton() {
        homePage.waitForPageLoadingComplete(DEFAULT_TIMEOUT);
        homePage.clickOnUpdateButton();
    }

    @And("User clicks on Currency button")
    public void userClicksOnCurrencyButton() {
        homePage.waitForPageLoadingComplete(DEFAULT_TIMEOUT);
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getUsdButon());
        homePage.clickOnCurrencyButton();
    }

    @Then("User checks that item price is now {string}")
    public void userChecksThatItemPriceIsNowUsd(final String priceExpected) {
        productPage.waitForPageLoadingComplete(DEFAULT_TIMEOUT);
        Assert.assertEquals(productPage.getItemPrice().getText(), priceExpected);
    }
}
