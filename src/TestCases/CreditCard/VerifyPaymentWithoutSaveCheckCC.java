package TestCases.CreditCard;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import BusinessSpecific.Methods;
import GenericLib.BrowserSpecific;
import GenericLib.CommonMethods;
import GenericLib.CommonValues;
import GenericLib.ExcelUtils;
import GenericLib.ExtendingCC;
import PageFactory.CCPayByCreditCardPage;
import PageFactory.CCPaymentInformationPage;
import PageFactory.CCVerifyInfo;

/*
 * *******************************************************************************************
 * This class is implemented to verify that the payment should not populated in the method of payment dropdown if 
 * the payment is not saved .
 ********************************************************************************************/
public class VerifyPaymentWithoutSaveCheckCC extends ExtendingCC {
	
	
	@Test
	public static void testVerifyPaymentWithoutSaveCheckCC(XmlTest myxml) throws Exception

	{
		
		Methods.handleServicePopUp();

		Methods.navigateToPayBill();

		Methods.navigateToPayCreditCard();

		String numOfAccToSelect = ExcelUtils.getCellData("TestSheet", 1, 8);
		String billAmount = ExcelUtils.getCellData("TestSheet", 1, 9);

		Methods.selectAccount(numOfAccToSelect, billAmount, 1);

		String cardNumber = ExcelUtils.getCellData("TestSheet", 1, 10);
		String zipCode = ExcelUtils.getCellData("TestSheet", 1, 14);

		Methods.authorizeAndProceed();
		JavascriptExecutor executor = (JavascriptExecutor) BrowserSpecific.driver;
		executor.executeScript("arguments[0].click();",
				CCPayByCreditCardPage.getAgreeBtn());

		BrowserSpecific.driver.switchTo().defaultContent();
		BrowserSpecific.driver.switchTo().frame("epwfpageId");
		Select select = new Select(
				CCPaymentInformationPage.getMethodOfPaymentDrpDwn());
		select.selectByVisibleText(CommonValues.crdDbtPymt);
		;

		CCPaymentInformationPage.Creditcardno().sendKeys(cardNumber);

		Select mnthDrpdwn = new Select(CCPaymentInformationPage.monthDropdown());
		mnthDrpdwn.selectByIndex(2);
		Select yearDrpdwn = new Select(CCPaymentInformationPage.yearDropdown());
		yearDrpdwn.selectByIndex(4);
		CCPaymentInformationPage.zipcodetxt().sendKeys(zipCode);
		CCPaymentInformationPage.getagreeCheckbox().click();
		CommonMethods.WaitForElement(CCPaymentInformationPage.getNextBtn());
		CCPaymentInformationPage.getNextBtn().click();

		try {
			CCVerifyInfo.getSubmitPaymentBtn().submit();

		} catch (Exception e) {
			System.out.println("catch");
			executor.executeScript("arguments[0].click();",
					CCVerifyInfo.getSubmitPaymentBtn());

		}
		BrowserSpecific.driver.close();
		
		ExtendingCC.beforeMethod(myxml.getParameter("browser"));
		
		//ExtendingCC.beforeMethod(browser);

		/*// 2nd navigation by unchecking save credit card check box

		String browserName = ExcelUtils.getCellData("TestSheet", 1, 3);
		String controlCentreUrlStr = ExcelUtils.getCellData("TestSheet", 1, 4);
		BrowserSpecific.navigateToURL(browserName, controlCentreUrlStr);

		// initiate the pageFactory
		BrowserSpecific.initiatePageFactory();

		// Login
		String userName = ExcelUtils.getCellData("TestSheet", 1, 5);
		String password = ExcelUtils.getCellData("TestSheet", 1, 6);
		
		CommonMethods.login(userName, password);
		*/
		Methods.navigateToPayBill();

		Methods.navigateToPayCreditCard();

		numOfAccToSelect = ExcelUtils.getCellData("TestSheet", 1, 8);
		billAmount = ExcelUtils.getCellData("TestSheet", 1, 9);

		float mobbillAmount = (float) (Float.parseFloat(billAmount) + 0.01);
		billAmount = String.format("%.2f", mobbillAmount);

		Methods.selectAccount(numOfAccToSelect, billAmount, 1);

		Methods.authorizeAndProceed();

		CCPayByCreditCardPage.getAgreeBtn().click();

		cardNumber = ExcelUtils.getCellData("TestSheet", 1, 10);

		String expectedCardno = "Visa ending****"
				+ cardNumber.substring(12, 16);

		int count = 0;
		BrowserSpecific.driver.switchTo().parentFrame();
		CommonMethods.frameSwitching("epwfpageId");
		Select select1 = new Select(
				CCPaymentInformationPage.getMethodOfPaymentDrpDwn());
		List<WebElement> dropdownlist = select1.getOptions();
		for (int k = 0; k < dropdownlist.size(); k++) {
			if (dropdownlist.get(k).getText().equals(expectedCardno)) {
				count++;
			}
		}

		Assert.assertEquals(count, 0);

	}
}