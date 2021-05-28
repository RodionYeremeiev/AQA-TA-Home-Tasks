package peageobject.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static pageobject.BasePage.TIME_OUT_30_SECONDS;

public class SearchTests extends BaseTest {
    private static final String SEARCH_KEYWORD_IPHONE = "iPhone 11";
    private static final String EXPECTED_SEARCH_QUERY = "query=iPhone";
    private static final String SEARCH_RESULTS_PRODUCTS_LIST = "//div[@class='prod-cart__descr']";
    private static final String SEARCH_KEYWORD_TOASTER = "toster";
    private static final String EMAIL_INPUT_FORM = "//div[@class='modal-middle']//input[@name='email']";
    private static final String EMAIL_ADDRESS = "email@something.com";
    private static final String EXPECTED_REPORT_MESSAGE = "Успешно!";

    private static final int EXPECTED_AMOUNT = 12;


    @Test(priority = 1)
    public void checkThatUrlContainsSearchWord() {
        getHomePage().searchByKeyWord(SEARCH_KEYWORD_IPHONE);
        assertTrue(getDriver().getCurrentUrl().contains(EXPECTED_SEARCH_QUERY));
    }


    @Test(priority = 2)
    public void checkElementsAmountOnSearchPage() {
        getHomePage().searchByKeyWord(SEARCH_KEYWORD_IPHONE);
        getHomePage().implicitWait(TIME_OUT_30_SECONDS, TimeUnit.SECONDS);
        assertEquals(getSearchResultPage().countElements(SEARCH_RESULTS_PRODUCTS_LIST), EXPECTED_AMOUNT);//сравнили количество элементов актуальное с тем которое ожидаем
    }


    @Test(priority = 3)
    public void checkThatSearchResultsContainsSearchWord() {
        getHomePage().searchByKeyWord(SEARCH_KEYWORD_IPHONE);
        for (WebElement webElement : getSearchResultPage().getSearchResultList(SEARCH_RESULTS_PRODUCTS_LIST)) { //прошлись циклом и проверили что каждый элемент листа содержит текс iPhone 11
            assertTrue(webElement.getText().contains(SEARCH_KEYWORD_IPHONE));
        }
    }

    //TODO: Refactor using PageObject Pattern
    //Home task Test#4
    @Test(priority = 8)
    public void checkProductIsAvailableAgainEmail() {
        getHomePage().searchByKeyWord(SEARCH_KEYWORD_TOASTER);
        getSearchResultPage().clickOnEmailWhenAvailableButton();
        getSearchResultPage().waitForVisibilityOfElement(TIME_OUT_30_SECONDS, By.xpath(EMAIL_INPUT_FORM));
        getSearchResultPage().inputEmailForNotification(EMAIL_INPUT_FORM, EMAIL_ADDRESS);
        getSearchResultPage().waitForVisibilityOfElement(TIME_OUT_30_SECONDS, getSearchResultPage().getEmailSendStatusReportElement());
        assertEquals(getSearchResultPage().getEmailSendStatusReportElement().getText(), EXPECTED_REPORT_MESSAGE);
    }


}
