package peageobject.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static pageobject.pages.BasePage.TIME_OUT_30_SECONDS;

public class SearchTests extends BaseTest {

    private static final String SEARCH_QUERY_KEYWORD_FOR_EMAIL_CHECK = "toster";
    private static final String EMAIL_ADDRESS = "email@something.com";
    private static final String SEARCH_KEYWORD = "iPhone 11";
    private static final String EXPECTED_SEARCH_QUERY = "query=iPhone";

    @Test(priority = 1)
    public void checkThatUrlContainsSearchWord() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        assertTrue(getDriver().getCurrentUrl().contains(EXPECTED_SEARCH_QUERY));
    }

    @Test(priority = 2)
    public void checkElementsAmountOnSearchPage() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        getHomePage().implicitWait(TIME_OUT_30_SECONDS);
        assertEquals(getSearchResultsPage().getSearchResultsCount(), 12);
    }

    @Test(priority = 3)
    public void checkThatSearchResultsContainsSearchWord() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        for (WebElement webElement : getSearchResultsPage().getSearchResultsList()) {
            assertTrue(webElement.getText().contains(SEARCH_KEYWORD));
        }
    }


    //TODO: Refactor using PageObject Pattern
    //Home task Test#4
    @Test(priority = 8)
    public void checkProductIsAvailableAgainEmail() {
        getHomePage().searchByKeyword(SEARCH_QUERY_KEYWORD_FOR_EMAIL_CHECK);
        getSearchResultsPage().clickOnUnAvailableProductButton();
        getSearchResultsPage().waitVisibilityOfElement(TIME_OUT_30_SECONDS, getSearchResultsPage().getEmailForm());
        getSearchResultsPage().inputEmailAddressForAvailabilityNotification(EMAIL_ADDRESS);
        getSearchResultsPage().waitVisibilityOfElement(TIME_OUT_30_SECONDS, getSearchResultsPage().getModalResponseForEmailInput());
        assertEquals(getSearchResultsPage().getModalResponseForEmailInput().getText(), "Успешно!");
    }

}
