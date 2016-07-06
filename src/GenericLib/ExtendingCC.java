package GenericLib;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import BusinessSpecific.Methods;


/**
 * *******************************************************************************************
 * This class contains precondition and postcondition for the Test Scenarios
 ********************************************************************************************/
public class ExtendingCC {
	static ExtentReports report;
	static ExtentTest test;
	
	
	 @BeforeMethod
	 @Parameters("browser")
	  public static void beforeMethod(String browser) throws Exception {

		

		  //launch the browser
		 // String browserName = ExcelUtils.getCellData("TestSheet", 1, 3);
		  String controlCentreUrlStr = ExcelUtils.getCellData("TestSheet", 1, 4);
		  report = new ExtentReports("C://Users//ab14917//SELENIUM_WORKSPACE//CCAutomationUpdated//FinalReport.html");
		  test = report.startTest("STARTING THE BROWSER  !!!!!!!!");

		  BrowserSpecific.navigateToURL(browser, controlCentreUrlStr);
		  
		  
		  
		  //initiate the pageFactory
		  BrowserSpecific.initiatePageFactory();
			BrowserSpecific.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  //Login
		  String userName = ExcelUtils.getCellData("TestSheet", 1, 5);
		  String password = ExcelUtils.getCellData("TestSheet", 1, 6);
		  CommonMethods.login(userName,password);
		 
		  
	  }
	 
	  	@AfterMethod
	  	public void tearDown(ITestResult testResult) throws Exception {
	  		
			if (testResult.getStatus() == ITestResult.FAILURE) {
				
				
					DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
						Calendar calobj = Calendar.getInstance();


				File scrFile = ((TakesScreenshot) BrowserSpecific.driver)
						.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile,new File("./Screenshots/" + testResult.getName() + CommonMethods.getCurrentDateTimeForReqID()+".png"));
						//new File("./Screenshots/" + testResult.getName() + df.format(calobj.getTime()) + ".png"));
						//new File("./Screenshots/" + testResult.getName() + df+calobj+".png"));
			}
			String billAmount = ExcelUtils.getCellData("TestSheet", 1, 9);

			float mobbillAmount = (float) (Float.parseFloat(billAmount) + 0.01);
			String Result = String.format("%.2f", mobbillAmount);
			ExcelUtils.setCellData(Result, "Testsheet", 1, 9);

			report.endTest(test);
			report.flush();	  	
		  		
		  	Methods.closeBrowser();

	  	}
	  	
}