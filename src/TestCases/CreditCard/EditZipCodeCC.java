package TestCases.CreditCard;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import BusinessSpecific.Methods;
import GenericLib.BrowserSpecific;
import GenericLib.CommonMethods;
import GenericLib.ExcelUtils;
import GenericLib.ExtendingCC;
import PageFactory.CCPayByCreditCardPage;
import PageFactory.CCPaymentInformationPage;

/*
 * *******************************************************************************************
 * This class is implemented to verify whether the ZipCode date data reflect in the UI after zipcode date is given
 ********************************************************************************************/
public class EditZipCodeCC extends ExtendingCC {
	@Test
	public static void  editZip() throws Exception {
		Methods.handleServicePopUp();

		Methods.navigateToPayBill();

		Methods.navigateToPayCreditCard();

		String numOfAccToSelect = ExcelUtils.getCellData("TestSheet", 1, 8);
		String billAmount = ExcelUtils.getCellData("TestSheet", 1, 9);

		Methods.selectAccount(numOfAccToSelect, billAmount, 1);

		Methods.authorizeAndProceed();
		JavascriptExecutor executor = (JavascriptExecutor) BrowserSpecific.driver;
		executor.executeScript("arguments[0].click();",
				CCPayByCreditCardPage.getAgreeBtn());
		CommonMethods.waitTillPageLoad();
		BrowserSpecific.driver.switchTo().defaultContent();
		 BrowserSpecific.driver.switchTo().frame("epwfpageId");
		
		Select select = new Select(
				CCPaymentInformationPage.getMethodOfPaymentDrpDwn());
		select.selectByIndex(1);
		String expectedPaymentAccount = select.getFirstSelectedOption()
				.getText();
		if (expectedPaymentAccount.contains("New Credit or Debit Account")) {
			System.out.println("No saved payment method found");
		} else {
			BrowserSpecific.driver.findElement(
					By.xpath("//label[contains(text(),'"
							+ expectedPaymentAccount
							+ "')]//following-sibling::a[text()='Edit']"))
					.click();
			try {
				if (CCPaymentInformationPage.getmethodOfPaymentPopUp()
						.isDisplayed()) {
					WebElement frame = BrowserSpecific.driver.findElement(By
							.xpath("(//iframe[@id='UpdateWalletIframe'])[2]"));
					BrowserSpecific.driver.switchTo().frame(frame);
					Thread.sleep(5000);
					String expectedPopUpZipCodeErrorMsg = "Please double check your card billing zip code";
					if (CCPaymentInformationPage.getPopUpZipCode()
							.isDisplayed()) {
						CCPaymentInformationPage.getPopUpZipCode().clear();
					} else {
						System.out.println("not displayed");
					}

					if (CCPaymentInformationPage.getpopUpSaveButton()
							.isDisplayed()) {
						JavascriptExecutor executor1 = (JavascriptExecutor) BrowserSpecific.driver;
						executor1.executeScript("arguments[0].click();",
								CCPaymentInformationPage.getpopUpSaveButton());
						Thread.sleep(8000);
					} else {
						System.out.println("not displayed");

					}

					CommonMethods.WaitForElement(CCPaymentInformationPage
							.getpopUpZipCodeError());
					String actualPopUpZipCodeErrorMsg = CCPaymentInformationPage
							.getpopUpZipCodeError().getText();
					Assert.assertEquals(actualPopUpZipCodeErrorMsg,
							expectedPopUpZipCodeErrorMsg,
							"Page is able to load without zipcode");

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}