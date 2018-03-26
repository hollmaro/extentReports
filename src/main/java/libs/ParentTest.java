package libs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.After;
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

    @Rule
    public TestName name = new TestName();

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new String[][]{
                {getCfgValue("BROWSER")}
        });

    }

    public ParentTest(String browser) throws MalformedURLException {
        //-------------Configuration driver path for WIN-----------------
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("safebrowsing.enabled", "true");

      /*System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
      System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer.exe");
      System.setProperty("webdriver.edge.driver", "C:\\MicrosoftWebDriver.exe");*/
        if (browser.equals("fireFox")) {
            WebDriverManager.firefoxdriver().setup();
            this.driver = new FirefoxDriver();
        }
        else if (browser.equals("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", prefs);
            options.addArguments("disable-infobars");
            this.driver = new ChromeDriver(options);
            driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
        }
        else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            this.driver = new EdgeDriver();
        }

        log.info(" ----- " + driver.getClass() + " -------" );



    }

    @Before
    public void setUp(){
        log.info("Test - " +  name.getMethodName() + " - started");
    }


}