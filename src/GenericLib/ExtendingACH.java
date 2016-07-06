package GenericLib;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BusinessSpecific.Methods;

/**
 * *******************************************************************************************
 * This class contains precondition and postcondition for the Test Scenarios
 ********************************************************************************************/
public class ExtendingACH {
	
	

		static ExtentReports report;
		static ExtentTest test;
		
		  @Parameters("browser")

		
		
	
	 @BeforeMethod
	  public static void beforeMethod(String browser) throws Exception {
			
		 
		  //launch the browser
		  //String browserName = ExcelUtils.getCellData("TestSheet", 2, 3);
		  String controlCentreUrlStr = ExcelUtils.getCellData("TestSheet", 2, 4);
		  
		  report = new ExtentReports("C://Users//ab14917//SELENIUM_WORKSPACE//CCAutomationUpdated//FinalReport.html");
		  test = report.startTest("CONTROL CENTRE  !!!!!!!!");
		  
		  BrowserSpecific.navigateToURL(browser, controlCentreUrlStr);
		  BrowserSpecific.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  
		  
		  BrowserSpecific.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  
		  
		  
		  //initiate the pageFactory
		  BrowserSpecific.initiatePageFactory();
		  
		  
		 

		  
		  
		  //Login
		  String userName = ExcelUtils.getCellData("TestSheet", 2, 5);
		  String password = ExcelUtils.getCellData("TestSheet", 2, 6);
		  CommonMethods.login(userName,password);
		  
		  test.log(LogStatus.INFO, "Login Succesfull");
		  
	  }
	 
	  	@AfterMethod
	  	public void tearDown(ITestResult testResult) throws Exception {
	  		
		if (testResult.getStatus() == ITestResult.FAILURE) {

			File scrFile = ((TakesScreenshot) BrowserSpecific.driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile,
					new File("./Screenshots/" + testResult.getName() + CommonMethods.getCurrentDateTimeForReqID()+".png"));
				}
		String billAmount = ExcelUtils.getCellData("TestSheet", 2, 9);

		float mobbillAmount = (float) (Float.parseFloat(billAmount) + 0.01);
		String Result = String.format("%.2f", mobbillAmount);
		ExcelUtils.setCellData(Result, "Testsheet", 2, 9);
		
		
		report.endTest(test);
		report.flush();	  		
	  		
	  	Methods.closeBrowser();
	  	
	  	}  	


	  	}
	  	
	  	
	  	
