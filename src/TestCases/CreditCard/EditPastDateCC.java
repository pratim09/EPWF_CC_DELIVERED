package TestCases.CreditCard;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import BusinessSpecific.Methods;
import GenericLib.BrowserSpecific;
import GenericLib.CommonMethods;
import GenericLib.ExcelUtils;
import GenericLib.ExtendingCC;
import PageFactory.CCPayByCreditCardPage;
import PageFactory.CCPaymentInformationPage;

/*
 * *******************************************************************************************
 * This class is implemented to verify whether the past date data reflect in the UI after past date is given
 ********************************************************************************************/
public class EditPastDateCC extends ExtendingCC {

	@Test
	public static void pastDate() throws Exception{
	Methods.handleServicePopUp();
		
	 Methods.navigateToPayBill();
	    
	 Methods.navigateToPayCreditCard();
	 
	 String numOfAccToSelect = ExcelUtils.getCellData("TestSheet", 1, 8);
	 String billAmount = ExcelUtils.getCellData("TestSheet", 1, 9);
	 
	 
	 Methods.selectAccount(numOfAccToSelect, billAmount, 1);
	 
	 Methods.authorizeAndProceed();
	 JavascriptExecutor executor = (JavascriptExecutor)BrowserSpecific.driver;
		executor.executeScript("arguments[0].click();",  CCPayByCreditCardPage.getAgreeBtn());
	 CommonMethods.waitTillPageLoad();
		BrowserSpecific.driver.switchTo().defaultContent();
	 BrowserSpecific.driver.switchTo().frame("epwfpageId");
	 
	 Select select = new Select(CCPaymentInformationPage.getMethodOfPaymentDrpDwn());
		select.selectByIndex(1);
		String expectedPaymentAccount = select.getFirstSelectedOption().getText();
		if(expectedPaymentAccount.contains("New Credit or Debit Account")){
			System.out.println("No saved payment method found");
		}else{
	BrowserSpecific.driver.findElement(By.xpath("//label[contains(text(),'"+expectedPaymentAccount+"')]//following-sibling::a[text()='Edit']")).click();
	try {
		if(CCPaymentInformationPage.getmethodOfPaymentPopUp().isDisplayed()){
			WebElement frame =BrowserSpecific. driver.findElement(By.xpath("(//iframe[@id='UpdateWalletIframe'])[2]"));
			BrowserSpecific.driver.switchTo().frame(frame);
			Thread.sleep(5000);	
			String expectedPopUpdateErrorMsg ="Please double check your expiration date";
			Select mnthDrpdwn=new Select(CCPaymentInformationPage.monthDropdown());
			mnthDrpdwn.selectByIndex(1);
			Select yearDrpdwn=new Select(CCPaymentInformationPage.yearDropdown());
			yearDrpdwn.selectByIndex(1);
			Thread.sleep(5000);
		if(CCPaymentInformationPage.getpopUpSaveButton().isDisplayed()){
			JavascriptExecutor executor1 = (JavascriptExecutor)BrowserSpecific.driver;
			executor1.executeScript("arguments[0].click();", CCPaymentInformationPage.getpopUpSaveButton());
			CommonMethods.waitTime();
		}else{
			System.out.println("not displayed");
		}
		CommonMethods.WaitForElement(CCPaymentInformationPage.getpopUpExpiryMonthError());
		String  actualPopUpdateErrorMsg= CCPaymentInformationPage.getpopUpExpiryMonthError().getText();
		Assert.assertEquals(actualPopUpdateErrorMsg, expectedPopUpdateErrorMsg, "page is able to load with past date ");
		}
	
		
	
	}
	catch(Exception e)
	{
		System.out.println("Coming to catch block ");
	}
		}
	}

}