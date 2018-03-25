package pages;

import libs.WebElementOnPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    WebDriver driver;
    WebElementOnPage webElementOnPage;
    Logger log;

    /**
     * constructor for SearchPage
     * @param externalDriver
     */
    public SearchPage(WebDriver externalDriver) {
        this.driver = externalDriver;
        log = Logger.getLogger(getClass());
        webElementOnPage = new WebElementOnPage(driver);
    }

    /**
     * method check if element with some text is on the page
     * @param searchText
     * @return
     */
    public boolean isElementWithTextOnPage(String searchText) {
        boolean tempElement =
                webElementOnPage.isElementOnPage("SearchPage.ElementWithText", searchText);
        log.info("Element with text " + searchText + " is on the page: " + tempElement);
        return tempElement;

    }
}
