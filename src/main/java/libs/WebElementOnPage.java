package libs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;
import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static libs.ConfigData.ui;


public class WebElementOnPage {

	WebDriver  driver;
	Logger log;
	WebDriverWait wait;

	
	public WebElementOnPage(WebDriver extDriver){
		this.driver = extDriver;
		log = Logger.getLogger(getClass());
		//wait = new WebDriverWait(driver, 30);
	}
	
	/**
	 * Method opens Browser & URL 
	 * @param url
	 */
	public void openBrowserAndUrl(String url) {
		try {
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.get(url);
			log.info("Browser and url " + url + " was opened!");
			
			
		} catch (Exception e) {
			log.error(e);
			Assert.assertTrue("Browser can't start", false);
			
		}
	}
	
	/**
	 * Method closes Browser
	 */
	public void closeBrowser() {
		try {
			driver.quit();
			log.info("Browser was closed!");
		} catch (Exception e) {
			log.error(e);
		}
		
	}
	/**
	 *All keys are from UIMapping.properties file 
	 */
	//If will not work - DELETE THIS METHOD
	public void closePage(){
		try {
			driver.get("");
		} catch (Exception e) {
		    log.error(e);// TODO: handle exception
		}
	}

	/**
	 *All keys are from UIMapping.properties file
	 */
	/**
	 * Method clear input and typing text in input
	 * @param text
	 * @param keyInputLocator
	 * @return boolean
	 */
	public boolean typeTextIntoInput(String text, String keyInputLocator) {
		/*wait.until(ExpectedConditions.elementToBeClickable(
				driver.findElement(ui(keyInputLocator))));*/
		try {
			WebElement input;
			input = driver.findElement(ui(keyInputLocator));
			input.clear();
			input.sendKeys(text);
			log.info("Text " + text + " was typed in input!");
			return true;
		} catch (Exception e) {
			log.error(e);
			return false;
		}
	}
	/**
	 * Method click link by keyLinkLocator
	 * @param keyLinckLocator
	 * @return boolean
	 */
	public boolean clickLink(String keyLinckLocator) {
		/*wait.until(ExpectedConditions.elementToBeClickable(
				driver.findElement(ui(keyLinckLocator))));*/
		try {
			WebElement link;
			link = driver.findElement(ui(keyLinckLocator));
			link.click();
			log.info("Link " + link + " was clicked!");
			return true;
		} catch (Exception e) {
			log.error(e);
			return false;
		}
	}
	/**
	 * Method clicking on button by keyButtonLocator
	 * @param keyButtonLocator
	 * @return boolean
	 */
	public boolean clickButton(String keyButtonLocator) {
		try {
			/*wait.until(ExpectedConditions.elementToBeClickable(
					driver.findElement(ui(keyButtonLocator))));*/
			WebElement button = driver.findElement(ui(keyButtonLocator));
			button.click();
			log.info("Button " + button + " was clicked!");
			return true;
		} catch (Exception e) {
			log.error(e);
			return false;
		}
	}
	/**
	 * Method clicking on radioButton by key from UIMaping
	 * @param keyRadioButtonLocator
	 * @return boolean
	 */
	public boolean clickOnRadioButton(String keyRadioButtonLocator) {
		/*wait.until(ExpectedConditions.elementToBeClickable(
				driver.findElement(ui(keyRadioButtonLocator))));*/
		try {
			WebElement radioButton = driver.findElement(ui(keyRadioButtonLocator));
			radioButton.click();
			log.info("RadioButton " + radioButton + " was clicked!");
			return true;
		} catch (Exception e) {
			log.error(e);
			return false;
		}
	}
	/**
	 * Method select text from DropDown
	 * @param keyLocatorMainDD
	 * @param itemText
	 * @return boolean
	 */
	public boolean selectItemFromDDByText(String keyLocatorMainDD, String itemText) {
		try {
			/*wait.until(ExpectedConditions.elementToBeClickable(
					driver.findElement(ui(keyLocatorMainDD))));*/
			WebElement mainDD = driver.findElement(ui(keyLocatorMainDD));
			Select itemsFromDD = new Select(mainDD);
			itemsFromDD.selectByVisibleText(itemText);
			log.info("Item " + itemText + " was selected in DD!");
			return true;
		} catch (Exception e) {
			log.error(e);
			return false;
		}
	}
	/**
	 * Method sets state in CheckBox
	 * @param keyCheckLocator
	 * @param stateFromTC (should be exactly "Check" or "UnChecked")
	 * @return boolean
	 */
	public boolean setActionIncheckBox(String keyCheckLocator,String stateFromTC) {
		/*wait.until(ExpectedConditions.elementToBeClickable(
				driver.findElement(ui(keyCheckLocator))));*/
		try {
			WebElement checkBox;
			checkBox = driver.findElement(ui(keyCheckLocator));
			if (checkBox.isSelected() && stateFromTC.equals("Check")){
				log.info("Is already checked");
			}
			else if (checkBox.isSelected() && stateFromTC.equals("UnChecked")){
				checkBox.click();
				log.info("Was unchecked");
			}
			else if (!checkBox.isSelected() && stateFromTC.equals("Check")){
				checkBox.click();
				log.info("Checked");
			}
			else if (!checkBox.isSelected() && stateFromTC.equals("UnChecked")){
				log.info("Is already unchecked");
			}
			return true;
		} catch (Exception e) {
			log.error(e);
			return false;
		}
	
	}
	/**
	 * Method checks presents of element on page
	 * @param keyElementLocator
	 * @return boolean
	 */
	public boolean isElementOnPage(String keyElementLocator){
		try {
			WebElement tempElement;
			tempElement = driver.findElement(ui(keyElementLocator));
			if (tempElement.isEnabled() && tempElement.isDisplayed()){
				log.info("Element is present on page");
				return true;
			}
			else{
				log.info("Element is not Enable or not Displayed");
				return false;
			}
		} catch (Exception e) {
			log.info("Element not found");
			return false;
		}
		
	}
	/**
	 * Method checks presents of element on page by text
	 * @param keyElementLocator
	 * @return boolean
	 */
	public boolean isElementOnPage(String keyElementLocator, String textForSearch){
		try {
			WebElement tempElement;
			tempElement = driver.findElement(ui(String.format(keyElementLocator, textForSearch)));
			if (tempElement.isEnabled() && tempElement.isDisplayed()){
				log.info("Element is present on page");
				return true;
			}
			else{
				log.info("Element is not Enable or not Displayed");
				return false;
			}
		} catch (Exception e) {
			log.info("Element not found");
			return false;
		}

	}
	/**
	 * Method cheks is element on page by xpath locator
	 * @param xpathElementLocator
	 * @return boolean
	 */
	public boolean isAnyElementOnPage(String xpathElementLocator){
		try {
			WebElement tempElement;
			tempElement = driver.findElement(By.xpath(xpathElementLocator));
			if (tempElement.isEnabled() && tempElement.isDisplayed()){
				log.info("Element is present on page");
				return true;
			}
			else{
				log.info("Element is not Enable or not Displayed");
				return false;
			}
		} catch (Exception e) {
			log.info("Element not found");
			return false;
		}
		
	}
	/**
	 * Method cheks is element has empty value by key from UIMapping.properties file
	 * @param keyElementLocator
	 * @return boolean
	 */
	public boolean isElementHasEmptyValue(String keyElementLocator){
		try {
			WebElement tempElement = driver.findElement(ui(keyElementLocator));
			String valueConsist = tempElement.getAttribute("value");
			if(valueConsist.equals("")){
				log.info("Element is empty (cheked)!");
				return true;
			}
			else 
			log.info("Element is not empty!");
			return false;
					
		} catch (Exception e) {
			log.error(e);
			return false;
		}
		
		
		
	}

	/**
	 * method move mouse on element
	 * @param keyElementLocator
	 * @return boolean
	 */
	public boolean mouseOnElement(String keyElementLocator) {
		/*wait.until(ExpectedConditions.elementToBeSelected(
				driver.findElement(ui(keyElementLocator))));*/
		try {
			Actions action = new Actions(driver);
			WebElement tempElement =
					driver.findElement(ui(keyElementLocator));
			action.moveToElement(tempElement);
			action.build().perform();
			log.info("Mouse moved on element: " + keyElementLocator);
			return true;
		}catch (Exception e){
			log.error(e);
			return false;
		}


	}

	/**
	 * method move mouse on element and click on it
	 * @param keyElementLocator
	 * @return boolean
	 */
	public boolean mouseOnElementAndClick(String keyElementLocator) {
		/*wait.until(ExpectedConditions.elementToBeSelected(
				driver.findElement(ui(keyElementLocator))));*/
		try {
			Actions actions = new Actions(driver);
			WebElement tempElement =
					driver.findElement(ui(keyElementLocator));
			actions.moveToElement(tempElement).click().build().perform();
			log.info("Mouse moved on element " + keyElementLocator + " and clicked!");
			return true;
		}catch (Exception e){
			log.error(e);
			return false;
		}


	}

	/**
	 * method return list of elements like List<WebElement>
	 * @param keyElementLocator
	 * @return
	 */
	public List<WebElement> collectionOfElements(String keyElementLocator){
		List<WebElement> mapOfElements = driver.findElements(ui(keyElementLocator));
		log.info("Make list of elements by keyElementLocator: " + keyElementLocator);
		return mapOfElements;
	}
}


	