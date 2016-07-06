package TestCases.ACH;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import BusinessSpecific.Methods;
import GenericLib.BrowserSpecific;
import GenericLib.CommonMethods;
import GenericLib.ExcelUtils;
import GenericLib.ExtendingACH;
import PageFactory.CCPaymentInformationPage;
import PageFactory.CCVerifyInfo;

/*
 * *******************************************************************************************
 * This class implements to verify the ACH convenience fee for all the pages  
 ********************************************************************************************/
public class VerifyACHConvenienceFeeInAllPages extends ExtendingACH{
	
	String browserName;
	String controlCentreUrlStr;
	String userName;
	String password;
	String numOfAccToSelect;
	String billAmount;
	String cardNumber;
	String confirmationNumber;
	String zipCode;
  
  @Test
  public  void testVerifyACHConvenienceFeeInAllPages() throws Exception {
	  
	//  	Methods.handleServicePopUp();
	  
	    Methods.navigateToPayBill();
		
		//handle Update Account PopUp
	    
		Methods.handleUpdateActPopUp();

		
		Methods.navigateToPayByBankAccount();

		numOfAccToSelect = ExcelUtils.getCellData("TestSheet", 2, 8);
		billAmount = ExcelUtils.getCellData("TestSheet", 2, 9);
	 
		Methods.selectAccount(numOfAccToSelect, billAmount,2);

		Methods.authorizeAndProceed();
		
		Select select = new Select(CCPaymentInformationPage.getMethodOfPaymentDrpDwn());
		select.selectByVisibleText("New Checking Account");
		String routingno = ExcelUtils.getCellData("TestSheet", 2, 16);
		String accountno = ExcelUtils.getCellData("TestSheet", 2, 11);
		CCPaymentInformationPage.getRoutingNoTextBox().sendKeys(routingno);
		CCPaymentInformationPage.getAccountNoTextBox().sendKeys(accountno);
		
		CommonMethods.WaitForElement(CCPaymentInformationPage.getagreeCheckbox());
		CCPaymentInformationPage.getagreeCheckbox().click();
		
	    CommonMethods.WaitForElement(CCPaymentInformationPage.getNextBtn());
	    CCPaymentInformationPage.getNextBtn().click();
	    
	    Methods.verifyACHConvncFeeInVerifyInfoPage(numOfAccToSelect);
	    
	    CommonMethods.WaitForElement(CCVerifyInfo.getSubmitPaymentBtn());
	    CCVerifyInfo.getSubmitPaymentBtn().click();
	
  
	    Methods.verifyACHConvncFeeInVerifyInfoPage(numOfAccToSelect);
	   
	    
	    	System.out.println("We apologize for the inconvenience, our system is down");
	    
  }
  
  
}
