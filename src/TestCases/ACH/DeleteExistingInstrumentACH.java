package TestCases.ACH;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import BusinessSpecific.Methods;
import GenericLib.BrowserSpecific;
import GenericLib.ExcelUtils;
import GenericLib.ExtendingACH;

/**
 * *******************************************************************************************
 * This class is implement to delete the existing ACH payment 
 ********************************************************************************************/
public class DeleteExistingInstrumentACH extends ExtendingACH {

	@Test
	public void ccTestCase7Execution() throws Exception {
		
//		Methods.handleServicePopUp();
		
		Methods.navigateToPayBill();

		Methods.handleUpdateActPopUp();

		Methods.navigateToPayByBankAccount();

		String numOfAccToSelect = ExcelUtils.getCellData("TestSheet", 2, 8);
		String billAmount = ExcelUtils.getCellData("TestSheet", 2, 9);
		Methods.selectAccount(numOfAccToSelect, billAmount,2);

		Methods.authorizeAndProceed();

		String accountNumber = ExcelUtils.getCellData("TestSheet", 2, 12);
		Methods.deleteExistingACH();
		
	}

}