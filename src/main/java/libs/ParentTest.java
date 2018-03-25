package libs;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ParentTest {
  public RemoteWebDriver driver;
    WebDriver iE, fireFox, chrome;
  public Logger log = Logger.getLogger(getClass());

  @Rule 
  public TestName name = new TestName();

  @Parameterized.Parameters
  public static Collection data() {
   return Arrays.asList(new String[][] { 
    //{ "fireFoxString" }
    // ,
    { "chromeString" }
    //,
    //{ "ieString" }

    });
  }

  
  public ParentTest(String browser) throws MalformedURLException {
      //-------------Configuration driver path for WIN-----------------
      /*System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
      System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer.exe");
      System.setProperty("webdriver.edge.driver", "C:\\MicrosoftWebDriver.exe");*/
   if (browser.equals("fireFoxString")) {
    this.driver = new FirefoxDriver();
      /* DesiredCapabilities capability = DesiredCapabilities.firefox();
       this.driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
               capability);*/
  } else if (browser.equals("chromeString")) {
     this.driver = new ChromeDriver();

        /*DesiredCapabilities capability = DesiredCapabilities.chrome();
        this.driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
                capability);*/
   }
   else if (browser.equals("ieString")) {
       this.driver = new InternetExplorerDriver();

        /*DesiredCapabilities capability = DesiredCapabilities.ie();
        this.driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
                capability);*/
   }

   log.info(" ----- " + driver.getClass() + " -------" );
   
   

  }
 
 @Before
 public void setUp(){
     log.info("Test - " +  name.getMethodName() + " - started");
 }





}
