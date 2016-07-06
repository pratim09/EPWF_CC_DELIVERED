package TestCases.CreditCard;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import BusinessSpecific.Methods;
import GenericLib.BrowserSpecific;
import GenericLib.CommonMethods;
import GenericLib.ExcelUtils;
import GenericLib.ExtendingCC;
import PageFactory.CCPayByCreditCardPage;
import PageFactory.CCPaymentInformationPage;
import PageFactory.CCVerifyInfo;

/*
 * *******************************************************************************************
 * This class is implemented to verify the Terms and Conditions details for the credit  card
 ********************************************************************************************/
public class CheckTermsAndCondnDtlsForCreditCard extends ExtendingCC {

	@Test
	public void testCheckTermsAndCondnDtlsForCreditCard() throws Exception {
		
		Methods.handleServicePopUp();
		
		// navigate to pay bill
		Methods.navigateToPayBill();

		// handle Update Account PopUp
		Methods.handleUpdateActPopUp();

		Methods.navigateToPayCreditCard();

		String numOfAccToSelect = ExcelUtils.getCellData("TestSheet", 1, 8);
		String billAmount = ExcelUtils.getCellData("TestSheet", 1, 9);

		Methods.selectAccount(numOfAccToSelect, billAmount, 1);

		Methods.authorizeAndProceed();

		CommonMethods.WaitForElement(CCPayByCreditCardPage
				.getTermsAndConditionLink());
		CCPayByCreditCardPage.getTermsAndConditionLink().click();
		//CommonMethods.waitTillPageLoad();

		Methods.termsAndCondnInPayCardPage();

		CommonMethods.WaitForElement(CCPayByCreditCardPage.getAgreeBtn());// added
		CCPayByCreditCardPage.getAgreeBtn().click();
		
		//CommonMethods.waitTillPageLoad();
		BrowserSpecific.driver.switchTo().defaultContent();
		Methods.verifyAmountFieldDisable();

		CommonMethods.WaitForElement(CCPaymentInformationPage
				.getTermsAndConditionLink());
		CCPaymentInformationPage.getTermsAndConditionLink().click();
		CommonMethods.waitTillPageLoad();

		Methods.termsAndCondnInPayCardPage();

		CommonMethods.WaitForElement(CCPaymentInformationPage
				.gettermsAndConditionFooterLink());
		CCPaymentInformationPage.gettermsAndConditionFooterLink().click();
		CommonMethods.waitTillPageLoad();

		Methods.termsAndCondnInPayCardPage();

		String cardNumber = ExcelUtils.getCellData("TestSheet", 1, 10);
		String zipCode = ExcelUtils.getCellData("TestSheet", 1, 14);
		Methods.fillingNewCreditOrDebitAccountInfo(cardNumber, zipCode, false,
				true);

		CommonMethods.WaitForElement(CCPaymentInformationPage
				.gettermsAndConditionFooterLink());
		CCPaymentInformationPage.gettermsAndConditionFooterLink().click();
		//CommonMethods.waitTillPageLoad();

		Methods.termsAndCondnInPayCardPage();

		CCVerifyInfo.getSubmitPaymentBtn().click();

		CommonMethods.WaitForElement(CCPaymentInformationPage
				.gettermsAndConditionFooterLink());
		CCPaymentInformationPage.gettermsAndConditionFooterLink().click();
		//CommonMethods.waitTillPageLoad();

		Methods.termsAndCondnInPayCardPage();

	}

}
