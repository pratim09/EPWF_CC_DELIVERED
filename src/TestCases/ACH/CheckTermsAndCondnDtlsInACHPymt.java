package TestCases.ACH;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;



import BusinessSpecific.Methods;
import GenericLib.BrowserSpecific;
import GenericLib.CommonMethods;
import GenericLib.CommonValues;
import GenericLib.ExcelUtils;
import GenericLib.ExtendingACH;
import PageFactory.CCPaymentInformationPage;
import PageFactory.CCVerifyInfo;
/*
 * *******************************************************************************************
 * This class handling the pending account pop Up for the pending accounts. 
 ********************************************************************************************/
public class CheckTermsAndCondnDtlsInACHPymt extends ExtendingACH {

	String browserName;
	String controlCentreUrlStr;
	String userName;
	String password;
	String numOfAccToSelect;
	String billAmount;
	String cardNumber;
	String confirmationNumber;
	String zipCode;
	String text = "PAYMENT TERMS AND CONDITIONS";

	@Test
	public void testCheckTermsAndCondnDtlsInACHPymt() throws Exception {
		
		
//		Methods.handleServicePopUp();
		

		// navigate to pay bill
		Methods.navigateToPayBill();
		// handle Update Account PopUp
		Methods.handleUpdateActPopUp();

		Methods.navigateToPayByBankAccount();

		numOfAccToSelect = ExcelUtils.getCellData("TestSheet", CommonValues.twoInt, CommonValues.eightInt);
		billAmount = ExcelUtils.getCellData("TestSheet", CommonValues.twoInt, CommonValues.nineInt);

		Methods.selectAccount(numOfAccToSelect, billAmount,2);

		Methods.authorizeAndProceed();

		Select select = new Select(CCPaymentInformationPage.getMethodOfPaymentDrpDwn());
		select.selectByVisibleText("New Checking Account");
		String routingno = ExcelUtils.getCellData("TestSheet", 2, 16);
		String accountno = ExcelUtils.getCellData("TestSheet", 2, 11);
		CCPaymentInformationPage.getRoutingNoTextBox().sendKeys(routingno);
		CCPaymentInformationPage.getAccountNoTextBox().sendKeys(accountno);
		
		CommonMethods.WaitForElement(CCPaymentInformationPage
				.gettermsAndConditionFooterLink());
		CCPaymentInformationPage.gettermsAndConditionFooterLink().click();
		CommonMethods.waitTillPageLoad();

		Methods.termsAndCondnInACH();

		CommonMethods.WaitForElement(CCPaymentInformationPage
				.getagreeCheckbox());
		CCPaymentInformationPage.getagreeCheckbox().click();

		CommonMethods.WaitForElement(CCPaymentInformationPage.getNextBtn());
		CCPaymentInformationPage.getNextBtn().click();

		CCVerifyInfo.getSubmitPaymentBtn().click();
		
		 
	}

}