package TestCases.CreditCard;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import BusinessSpecific.Methods;
import GenericLib.BrowserSpecific;
import GenericLib.ExcelUtils;
import GenericLib.ExtendingCC;
import PageFactory.CCPayByCreditCardPage;
import PageFactory.CCReceiveConfirmationPage;
import PageFactory.CCVerifyInfo;

/**
 * *******************************************************************************************
 * This class implements the e2e test cases . 
 ********************************************************************************************/
public class CCAutomationE2E extends ExtendingCC {

	//******************************String declaration ***************************************
	String confirmationNumber;
	String numOfAccToSelect;
	String billAmount;
	String cardNumber;
	String zipCode;

	@Test
	public void testCCAutomationE2E() throws Exception {

		Methods.handleServicePopUp();
	
		Methods.navigateToPayBill();


		//NAvigate to Pay Bill>>Pay By Credit Card 
		Methods.navigateToPayCreditCard();

		//Select Account and proceed
		numOfAccToSelect = ExcelUtils.getCellData("TestSheet", 1, 8);
		billAmount = ExcelUtils.getCellData("TestSheet", 1, 9);
		Methods.selectAccount(numOfAccToSelect, billAmount, 1);
		Methods.authorizeAndProceed();

		//Verify the accounts details in Payment Information Page
		Methods.verifyAgreeButtonInPayCardPage();
		Methods.verifyCancelButtonInPayCardPage();
		Methods.verifySpeedPayLogoInPayCardPage();
		Methods.verifyTermsAndConditionInPayCardPage();
		Methods.verifyConvncFeeInPayCardPage(numOfAccToSelect);

		//Agree the Terms and Conditions
		CCPayByCreditCardPage.getAgreeBtn().click();
		BrowserSpecific.driver.switchTo().defaultContent();

		
		//Verify the accounts details in Payment Information Page
		Methods.verifyAmountFieldDisable();
		Methods.verifyDateFieldDisable();
		Methods.verifyConvncFeeInPymtInfoPage(numOfAccToSelect);
		Methods.verifyTotalPymtAmtInPymtInfo(billAmount, numOfAccToSelect);
		Methods.verifySpeedPayLogoInPaymtInfoPage();
		Methods.verifyTermsAndConditionInPaymtInfoPage();

		
		//Selecting new credit and Debit Card
		cardNumber = ExcelUtils.getCellData("TestSheet", 1, 10);
		zipCode = ExcelUtils.getCellData("TestSheet", 1, 14);
		Methods.fillingNewCreditOrDebitAccountInfo(cardNumber, zipCode, false,
				true);

		
		//Verify the accounts details in Verify Information Page
		Methods.verifyBillAmtInVerifyInfoPage(billAmount, numOfAccToSelect);
		Methods.verifyConvncFeeInVerifyInfoPage(numOfAccToSelect);
		Methods.verifyTotalPymtAmtInVerifyInfo(billAmount, numOfAccToSelect);
		Methods.verifyPymtDateInVerifyInfoPage();
		Methods.verifyPymtMthdInVerifyInfopage(cardNumber);
		Methods.verifySpeedLogoInVIPage();

		//Submit the selected Payment
		CCVerifyInfo.getSubmitPaymentBtn().click();

		//Verify the accounts details in Receive Confirmation Page
		Methods.verifyBillAmtInRCPage(billAmount, numOfAccToSelect);
		Methods.verifyConvncFeeInRCPage(numOfAccToSelect);
		Methods.verifyTotalPymtAmtInRCPage(billAmount, numOfAccToSelect);
		Methods.verifyPymtDateInRCPage();
		Methods.verifyPymtMthdInRCpage(cardNumber);
		Methods.verifySpeedLogoInRCPage();
		Methods.verifyThanksMsgInRCPage();

		//Storing the confirmation number after successful submission of payments
		confirmationNumber = CCReceiveConfirmationPage
				.getConfirmationNmbrText().getText();
		System.out.println("confirmationNumber = " + confirmationNumber);

	}

}