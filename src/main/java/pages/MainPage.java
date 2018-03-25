package pages;

import libs.WebElementOnPage;
import static libs.ConfigData.getCfgValue;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;


public class MainPage {
    WebDriver driver;
    Logger log;
    WebElementOnPage webElementOnPage;
    String MAIN_PAGE_URL;
    String MAIN_PAGE_TITLE;

    /**
     * Constructor for MainPage
     * @param externalDriver
     */
    public MainPage(WebDriver externalDriver){
        this.driver = externalDriver;
        log = Logger.getLogger(getClass());
        webElementOnPage = new WebElementOnPage(driver);
        MAIN_PAGE_URL = getCfgValue("MAIN_PAGE_URL");
        MAIN_PAGE_TITLE =
                "Интернет-магазин ROZETKA™: фототехника, видеотехника, аудиотехника, компьютеры и компьютерные комплектующие";
    }

    /**
     * method opens main page rozetka.com
     */
    public void openMainPage(){
        try {
            webElementOnPage.openBrowserAndUrl(MAIN_PAGE_URL);
            log.info("Main page was opened!");
        } catch (Exception e) {
            log.error("Main page WASN'T opened!" + e);
        }
    }

    /**
     * method close browser from main page
     */
    public void closeBrowser(){
        webElementOnPage.closeBrowser();
        log.info("Browser was closed from page " + MAIN_PAGE_URL);
    }

    /**
     * method close window, not browser instance
     */
    public void closeMainPage(){
        webElementOnPage.closePage();
        log.info("Main page was closed!");
    }

    /**
     * method click button for canceling notifications
     * @return boolean
     */
    public boolean clickOtkazatsaOtUvedomlienij() {
        boolean tempElement = webElementOnPage.clickButton("MainPage.NotificationPanel.Cancel.Button");
        log.info("Button for canceling notifications was clicked! ");
        return tempElement;
    }

    /**
     * method checks is notafication panel is on the page
     * @return boolean
     */
    public boolean isNotificationPanelIsPresent() {
        boolean tempElement =
                webElementOnPage.isElementOnPage("MainPage.NotificationPanel");
        log.info("Notification panel is present: " + tempElement);
        return tempElement;

    }

    /**
     * method clicked on MainPage.Menu.Phones.Link item
     * @return boolean
     */
    public boolean clickMenuSmartphonesTvElectronic() {
        boolean tempElement =
                webElementOnPage.mouseOnElement("MainPage.Menu.SmartPhonesTvElectronic.Link");
        log.info("Was opened menu item: MainPage.Menu.Phones.Link: " + tempElement);
        return tempElement;
    }

    /**
     * method clicked on MainPage.Menu.Smartphones.Link item
     * @return boolean
     */
    public boolean clickMenuSmartPhones() {
        boolean tempElement =
                webElementOnPage.mouseOnElementAndClick("MainPage.Menu.SmartPhones.Link");
        log.info("Link Smartphones was clicked: " + tempElement);
        return tempElement;
    }

    /**
     * get page title
     * @return String title
     */
    public String getMainTitle() {
        return MAIN_PAGE_TITLE;
    }

    public boolean typeTextInSearch(String textForSearch){
        try {
            webElementOnPage.typeTextIntoInput(textForSearch, "MainPage.Search.Input");
            log.info("Text " + textForSearch + "was typed in Search Input");
            return true;
        }catch (Exception e){
            log.error(e);
            return false;
        }
    }

    /**
     * method clicks Menu button
     * @return
     */
    public boolean clickMenuButton() {
        boolean tempElement =
                webElementOnPage.clickButton("MainPage.Menu.Button");
        log.info("Menu button was clicked: " + tempElement);
        return tempElement;
    }

    /**
     * method clicks "Voidite v lichnyi cabinet"
     * @return
     */
    public boolean clickEnterInCabinet() {
        boolean tempElement =
                webElementOnPage.clickLink("MainPage.Login.Link");
        log.info("Link \"Voidite v lichnyi cabinet\" was clicked: " + tempElement);
        return tempElement;
    }
    /**
     * method checks if login form is on the page
     * @return boolean
     */
    public boolean isLoginFormPresent() {
        boolean tempElement =
                webElementOnPage.isElementOnPage("MainPage.Login.Email.Input")&&
                webElementOnPage.isElementOnPage("MainPage.Login.Password.Input")&&
                webElementOnPage.isElementOnPage("MainPage.Login.Submit.Button");
        log.info("Login form is present: " + tempElement);
        return tempElement;

    }

    /**
     * method typing text into email input
     * @param text
     * @return
     */
    public boolean typeTextIntoEmail(String text) {
        try {
            webElementOnPage.typeTextIntoInput(text, "MainPage.Login.Email.Input");
            log.info("Text " + text + " was typed in email Input");
            return true;
        }catch (Exception e){
            log.error(e);
            return false;
        }

    }
    /**
     * method typing text into password input
     * @param text
     * @return
     */
    public boolean typeTextIntoPassw(String text) {
        try {
            webElementOnPage.typeTextIntoInput(text, "MainPage.Login.Password.Input");
            log.info("Text " + text + " was typed in password Input");
            return true;
        }catch (Exception e){
            log.error(e);
            return false;
        }

    }
    /**
     * method clicks Enter button
     * @return
     */
    public boolean clickEnterButton() {
        boolean tempElement =
                webElementOnPage.clickButton("MainPage.Login.Submit.Button");
        log.info("Enter button was clicked: " + tempElement);
        return tempElement;
    }
    /**
     * method checks if email input is ERROR style
     * @return boolean
     */
    public boolean isEmailInputError() {
        boolean tempElement =
                webElementOnPage.isElementOnPage("MainPage.Login.Email.Input_ERROR_STYLE");
        log.info("Email input is ERROR: " + tempElement);
        return tempElement;

    }
    /**
     * method checks if password input is ERROR style
     * @return boolean
     */
    public boolean isPasswInputError() {
        boolean tempElement =
                webElementOnPage.isElementOnPage("MainPage.Login.Password.Input_ERROR_STYLE");
        log.info("Password input is ERROR: " + tempElement);
        return tempElement;

    }

    /**
     * method clicks Search button
     * @return
     */
    public boolean clickSearchButton() {
        boolean tempElement =
                webElementOnPage.clickButton("MainPage.SearchButton");
        log.info("search button was clicked: " + tempElement);
        return tempElement;

    }
}
