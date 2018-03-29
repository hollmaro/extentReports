import com.relevantcodes.extentreports.LogStatus;
import junit.framework.TestResult;
import libs.ParentTest;
import org.junit.AfterClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
        Assert.assertTrue("Check is login form present",
                mainPage.clickEnterInCabinet() &&
                        mainPage.isLoginFormPresent()
        );


    }





    @After
    public void tearDown() throws MalformedURLException {
        mainPage.closeBrowser();
        extent.endTest(extentlogger);
        extent.flush();
        extent.close();


    }
    @AfterClass
    public static void end(){

    }
}
