package TestCases.CreditCard;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import BusinessSpecific.Methods;
import GenericLib.BrowserSpecific;
import GenericLib.CommonMethods;
import GenericLib.ExcelUtils;
import GenericLib.ExtendingCC;
import PageFactory.CCPayByCreditCardPage;

/*
 * *******************************************************************************************
 * This class is implemented to verify the disabled amount and date field in payment information page.
 ********************************************************************************************/
public class VerifyAmountAndDateFieldsCC extends ExtendingCC{


	
	@Test
	public void testVerifyAmountAndDateFieldsCC() throws Exception {
		
		Methods.handleServicePopUp();
		
		Methods.navigateToPayBill();
		
  		Methods.navigateToPayCreditCard();
  		 
  		String numOfAccToSelect = ExcelUtils.getCellData("TestSheet", 1, 8);
  		String billAmount = ExcelUtils.getCellData("TestSheet", 1, 9);
  		
  		Methods.selectAccount(numOfAccToSelect, billAmount, 1);
  		Methods.authorizeAndProceed();
  		
  		Methods.verifyAgreeButtonInPayCardPage();
  		Methods.verifyCancelButtonInPayCardPage();
  		Methods.verifySpeedPayLogoInPayCardPage();
  		Methods.verifyTermsAndConditionInPayCardPage();
  		Methods.verifyConvncFeeInPayCardPage(numOfAccToSelect);
  		 
  		CCPayByCreditCardPage.getAgreeBtn().click();
  		
  		BrowserSpecific.driver.switchTo().defaultContent();
  		Methods.verifyAmountFieldDisable();
  		Methods.verifyDateFieldDisable();
  		
	}

}