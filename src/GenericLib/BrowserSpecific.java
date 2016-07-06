package GenericLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;

import PageFactory.CCHomePage;
import PageFactory.CCLoginPage;
import PageFactory.CCPayByCreditCardPage;
import PageFactory.CCPaymentHistoryPage;
import PageFactory.CCPaymentInfo;
import PageFactory.CCPaymentInformationPage;
import PageFactory.CCReceiveConfirmationPage;
import PageFactory.CCTermsAndConditionPage;
import PageFactory.CCVerifyInfo;
/**
 * ****************************************************************************************************************************************
 * This class includes all the browser specific reusuable methods 
 ******************************************************************************************************************************************/
public class BrowserSpecific {

	// ******************************Variables declaration*************************************

	public static WebDriver driver;

	// ******************************Method declaration****************************************
	
	@Parameters("browser")
	

	/**
	 * @return WebElement
	 * @definition launch the browser firefox/chrome/ie based on the user
	 *             requirement.
	 * @param browserStr
	 *            stores the name of the browser to launch
	 */
	
	public static WebDriver selectRequiredBrowser(String browser) {
		
		

		if (browser.equals("FireFox")) {
			driver = new FirefoxDriver();

		} else if (browser.equals("Internet Explorer")) {
			System.setProperty(
					"webdriver.ie.driver",
					"C:\\Users\\ab14917\\Desktop\\PERSONAL\\SELENIUM\\selenium_jar_sulabh\\IEDriverServer.exe");
			DesiredCapabilities ieCapabilities = DesiredCapabilities
					.internetExplorer();
			ieCapabilities
					.setCapability(
							InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);
			ieCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			ieCapabilities.setCapability("requireWindowFocus", true);
			driver = new InternetExplorerDriver(ieCapabilities);

		} else if (browser.equals("Chrome")) {
			System.setProperty(
					"webdriver.chrome.driver",
					"C:\\Users\\ab14917\\Desktop\\PERSONAL\\SELENIUM\\selenium_jar_sulabh\\chromedriver.exe");
			driver = new ChromeDriver();

		} else {
			driver = new FirefoxDriver();

		}

		return driver;
	}

	/**
	 * @return void
	 * @definition navigate to the url
	 * @param browserStr
	 *            stores the name of the browser to launch
	 * @param url
	 *            stores the specific url to open
	 */
	public static void navigateToURL(String browser,String url) {
		selectRequiredBrowser(browser);
		driver.get(url);
		driver.manage().window().maximize();
		CommonMethods.waitTillPageLoad();
	}

	/**
	 * @return void
	 * @definition initiate all the page factory pages
	 */
	public static void initiatePageFactory() {
		PageFactory.initElements(driver, CCPayByCreditCardPage.class);
		PageFactory.initElements(driver, CCPaymentInformationPage.class);
		PageFactory.initElements(driver, CCHomePage.class);
		PageFactory.initElements(driver, CCPaymentHistoryPage.class);
		PageFactory.initElements(driver, CCLoginPage.class);
		PageFactory.initElements(driver, CCPaymentInfo.class);
		PageFactory.initElements(driver, CCVerifyInfo.class);
		PageFactory.initElements(driver, CCTermsAndConditionPage.class);
		PageFactory.initElements(driver, CCReceiveConfirmationPage.class);
	}

}