package TestCases.CreditCard;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import BusinessSpecific.Methods;
import GenericLib.BrowserSpecific;
import GenericLib.ExcelUtils;
import GenericLib.ExtendingCC;
import PageFactory.CCPayByCreditCardPage;

/*
 * *******************************************************************************************
 * This class is implemented to verify the Cancelation message after clicking on the Cancel Link in every payment page.
 ********************************************************************************************/
public class VerifyCancellationInfoCC extends ExtendingCC{

  	@Test
  	public void testVerifyCancellationInfoCC() throws Exception {
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
  		
  		CCPayByCreditCardPage.getCancelBtn().click();
  		
  		Methods.verifyPaymentCancellationMsg();
  		
  	}
  	
}