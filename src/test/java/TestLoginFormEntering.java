import libs.ParentTest;
import pages.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import java.net.MalformedURLException;

/**
 * Created by roman on 3/10/17.
 */
public class TestLoginFormEntering extends ParentTest {
    MainPage mainPage;

    public TestLoginFormEntering(String browser) throws MalformedURLException {
        super(browser);
    }

    @Test
    public void TestLogin() {
        extentlogger = extent.startTest(name.getMethodName());
        mainPage = new MainPage(driver);
        mainPage.openMainPage();
        Assert.assertTrue(
                "Check is title correct! ", mainPage.getMainTitle().equals(driver.getTitle()));
        if (mainPage.isNotificationPanelIsPresent()) {
            mainPage.clickOtkazatsaOtUvedomlienij();
        }
        Assert.assertTrue("Check is login form present",
                mainPage.clickEnterInCabinet()&&
                mainPage.isLoginFormPresent()
        );
    }

    @After
    public void tearDown() {
        mainPage.closeBrowser();
        extent.endTest(extentlogger);
        extent.flush();
        extent.close();
    }
}
