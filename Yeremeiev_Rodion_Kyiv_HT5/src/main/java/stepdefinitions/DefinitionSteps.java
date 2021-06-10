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
import pages.HomePage;
import pages.ProductPage;
import pages.SavedItemsPage;
import pages.SearchResultPage;

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
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getMyAcoountPopUp());
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
}
