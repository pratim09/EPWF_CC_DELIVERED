package GenericLib;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageFactory.CCLoginPage;

/**
 * *******************************************************************************************
 * This class includes all the common methods of the project
 ********************************************************************************************/
public class CommonMethods {

	/**
	 * @return void
	 * @definition wait for the element to be present in the UI
	 * @param dynamicElement
	 *            stores the webElement
	 * @param timeUnit
	 *            stores the time duration to wait the webelement
	 */
	public static void WaitForElement(WebElement dynamicElement) {

		dynamicElement = (new WebDriverWait(BrowserSpecific.driver, 30))
				.until(ExpectedConditions.visibilityOf(dynamicElement));

	}

	/**
	 * @return void
	 * @definition wait for the element to be clickable
	 * @param dynamicElement
	 *            stores the webElement
	 * @param timeUnit
	 *            stores the time duration to wait the webelement
	 */
	public static void WaitForElementclick(WebElement dynamicElement) {

		dynamicElement = (new WebDriverWait(BrowserSpecific.driver, 30))
				.until(ExpectedConditions.elementToBeClickable(dynamicElement));

	}

	/**
	 * @return void
	 * @definition create the Action class object and used in the scenarios
	 * @param dynamicElement
	 *            stores the webElement
	 */
	public static void moveToElement(WebElement element) {
		Actions action = new Actions(BrowserSpecific.driver);
		action.moveToElement(element).perform();
	}

	/**
	 * @return void
	 * @definition wait till entire page to load
	 * @param timeUnit
	 *            stores the time duration to wait the webelement
	 */
	public static void waitTillPageLoad() {
		BrowserSpecific.driver.manage().timeouts()
				.implicitlyWait(30, TimeUnit.SECONDS);
	}

	/**
	 * @return void
	 * @definition pause for control for the specific time unit
	 * @param timeUnit
	 *            stores the time duration to wait the webelement
	 */
	public static void waitTime() throws InterruptedException {
		Thread.sleep(5000);
	}

	/**
	 * @return void
	 * @definition switch to any frame using id or name
	 * @param frameName
	 *            stores the frame name to switch
	 */
	public static void frameSwitching(String frameName) {
		BrowserSpecific.driver.switchTo().frame(frameName);
	}

	/**
	 * @return void
	 * @definition refresh the browser
	 */
	public static void refreshBrowser() {
		BrowserSpecific.driver.navigate().refresh();
	}

	/**
	 * @return void
	 * @definition go to the previous page
	 */
	public static void backPageNavigation() {
		BrowserSpecific.driver.navigate().back();
	}

	/**
	 * @return void
	 * @definition get current date based on the systen date
	 */
	public static String getCurrentDate() {
		
		int day, month, year;
		GregorianCalendar date = new GregorianCalendar();

		day = date.get(Calendar.DAY_OF_MONTH);
		month = date.get(Calendar.MONTH);
		year = date.get(Calendar.YEAR);

		String todayDate = day + "/" + (month + 1) + "/" + year;
		return todayDate;
	}

	
	
	/**
	 * @return void
	 * @definition used to format the date pattern
	 */
	public static String datePattern() throws Exception {
		
		
		
		String dateInputPattern = "dd/MM/yyyy"; // numeric 2 digit month
		String dateTargetPattern = "MMMM d, yyyy"; // For 3 char month name
		String dateString = CommonMethods.getCurrentDate();

		String datePattern = patternTest(dateInputPattern, dateString,
				dateTargetPattern);
		return datePattern;

	}
	
	
	
	public static String getCurrentDateTimeForReqID() {
		DateFormat dateFormat = new SimpleDateFormat(" yyyy-MM-dd-HH.mm.ss");
		Calendar cal = Calendar.getInstance();
		String CurrDateTime = dateFormat.format(cal.getTime());
		return CurrDateTime;
	}
	
	
/*	public static void main(String[] args) {
		
		System.out.println(getCurrentDateTimeForReqID());
		
	}*/
	

	/**
	 * @return void
	 * @definition used to format the date pattern
	 * @param dateInputPattern
	 *            stores the
	 * @param dateString
	 *            stores the
	 * @param dateTargetPattern
	 *            stores the
	 */
	public static String patternTest(String dateInputPattern,
			String dateString, String dateTargetPattern) throws Exception {
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
				dateInputPattern);
		java.util.Date date = sdf.parse(dateString);
		sdf.applyPattern(dateTargetPattern);

		String datePattern = sdf.format(date);
		System.out.println(datePattern);
		return datePattern;

	}

	/**
	 * @return void
	 * @definition login to the application
	 * @param userName
	 *            stores the user name
	 * @param passWord
	 *            stores the user password
	 */
	public static void login(String userName, String passWord) {

		CCLoginPage.getUserNameTextBox().sendKeys(userName);
		CCLoginPage.getPasswordTextBox().sendKeys(passWord);
		CCLoginPage.getLoginBtn().click();

	}

}