import libs.ParentTest;
import pages.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import java.net.MalformedURLException;


public class TestLoginFormEntering extends ParentTest {
    MainPage mainPage;

    public TestLoginFormEntering(String browser) throws MalformedURLException {
        super(browser);
    }

    @Test
    public void TestLogin() {
        mainPage = new MainPage(driver);
        mainPage.openMainPage();
        Assert.assertTrue(
                "Check is title correct! ", mainPage.getMainTitle().equals(driver.getTitle()));
        Assert.assertTrue("Check is login form present",
                mainPage.clickEnterInCabinet() &&
                        mainPage.isLoginFormPresent()
        );
    }

    @After
    public void tearDown() throws MalformedURLException {
        mainPage.closeBrowser();

    }

}
