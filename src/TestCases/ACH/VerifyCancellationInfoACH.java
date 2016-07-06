package TestCases.ACH;

import org.testng.annotations.Test;

import BusinessSpecific.Methods;
import GenericLib.ExcelUtils;
import GenericLib.ExtendingACH;
/**
 * *******************************************************************************************
 * This class is implemented to verify cancelation information for the ACH Payments
 ********************************************************************************************/
public class VerifyCancellationInfoACH extends ExtendingACH {

	@Test
	public void testVerifyCancellationInfoACH() throws Exception {
		
//		Methods.handleServicePopUp();
		
		Methods.navigateToPayBill();

		Methods.handleUpdateActPopUp();

		Methods.navigateToPayByBankAccount();

		String numOfAccToSelect = ExcelUtils.getCellData("TestSheet", 2, 8);
		String billAmount = ExcelUtils.getCellData("TestSheet", 2, 9);
		Methods.selectAccount(numOfAccToSelect, billAmount, 2);

		Methods.authorizeAndProceed();

		String accountNumber = ExcelUtils.getCellData("TestSheet", 2, 11);
		Methods.verifyCancellationMsgForBankAccount();

	}

}