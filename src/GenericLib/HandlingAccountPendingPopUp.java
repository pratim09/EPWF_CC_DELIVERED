package GenericLib;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import BusinessSpecific.Methods;
/*
 * *******************************************************************************************
 * This class handling the pending account pop Up for the pending accounts. 
 ********************************************************************************************/
public class HandlingAccountPendingPopUp extends ExtendingCC {

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
	public void testHandlingAccountPendingPopUp() throws Exception {
		
		
		Methods.handleServicePopUp();
		

		// navigate to pay bill
		Methods.navigateToPayBill();


		Methods.navigateToPayCreditCard();

		numOfAccToSelect = ExcelUtils.getCellData("TestSheet", 1, 8);
		billAmount = ExcelUtils.getCellData("TestSheet", 1, 9);
		System.out.println("numOfAccToSelect " + numOfAccToSelect);
		System.out.println("billAmount " + billAmount);

		Methods.selectAccount(numOfAccToSelect, billAmount,1);

		Methods.authorizeAndProceed();

		Methods.handelPendingAccountPopUp();
	}

}
