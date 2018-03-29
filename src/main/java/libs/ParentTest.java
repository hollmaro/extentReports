package libs;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Test;
import junit.framework.TestResult;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import static libs.ConfigData.*;

@RunWith(Parameterized.class)
public class ParentTest {
    public WebDriver driver;
    public Logger log = Logger.getLogger(getClass());
    public static ExtentReports extent = new ExtentReports("test-output/ExtentReport.html", true);
    public ExtentTest extentlogger = extent.startTest(getClass().toString());

    @Rule
    public TestName name = new TestName();

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new String[][]{
                {getCfgValue("BROWSER")}
        });

    }

    public ParentTest(String browser) throws MalformedURLException {
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("safebrowsing.enabled", "true");
        if (browser.equals("fireFox")) {
            WebDriverManager.firefoxdriver().setup();
            this.driver = new FirefoxDriver();
        } else if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", prefs);
            options.addArguments("disable-infobars");
            this.driver = new ChromeDriver(options);
            driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            this.driver = new EdgeDriver();
        }
        extent
                .addSystemInfo("Host Name", "localhost")
                .addSystemInfo("Environment", "Test env/VM/remote server")
                .addSystemInfo("User Name", "Roman Lekh (Automation QA)");
        extent.loadConfig(new File("extent-config.xml"));


        log.info(" ----- " + driver.getClass() + " -------");


    }

    @Before
    public void setUp() {
        log.info("Test - " + name.getMethodName() + " - started");
    }


}