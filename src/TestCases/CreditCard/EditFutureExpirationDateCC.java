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
 * *************************************************************************************************************
 * This class is implemented to verify whether the future date data reflect in the UI after future date is given
 ***************************************************************************************************************/
public class EditFutureExpirationDateCC extends ExtendingCC{
	@Test
	public static void testEditFutureExpirationDateCC() throws Exception {
		
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

		Select select = new Select(CCPaymentInformationPage.getMethodOfPaymentDrpDwn());
		select.selectByIndex(1);
		String expectedPaymentAccount = select.getFirstSelectedOption().getText();
		if(expectedPaymentAccount.contains("New Credit or Debit Account")){
			System.out.println("No saved payment method found");
		}else{
			BrowserSpecific.driver.findElement(
					By.xpath("//label[contains(text(),'" + expectedPaymentAccount
							+ "')]//following-sibling::a[text()='Edit']")).click();
			try {
				if (CCPaymentInformationPage.getmethodOfPaymentPopUp()
						.isDisplayed()) {
					WebElement frame = BrowserSpecific.driver.findElement(By
							.xpath("(//iframe[@id='UpdateWalletIframe'])[2]"));
					BrowserSpecific.driver.switchTo().frame(frame);
					Thread.sleep(5000);
					Select mnthDrpdwn = new Select(
							CCPaymentInformationPage.monthDropdown());
					mnthDrpdwn.selectByVisibleText("June");
					Select yearDrpdwn = new Select(
							CCPaymentInformationPage.yearDropdown());
					yearDrpdwn.selectByVisibleText("2019");
					if (CCPaymentInformationPage.getpopUpSaveButton().isDisplayed()) {

						executor.executeScript("arguments[0].click();",
								CCPaymentInformationPage.getpopUpSaveButton());
						CommonMethods.waitTime();
					} else {
						System.out.println("not displayed");
					}
					if (CCPaymentInformationPage.getPopUpCloseButton()
							.isDisplayed()) {

						executor.executeScript("arguments[0].click();",
								CCPaymentInformationPage.getPopUpCloseButton());
						CommonMethods.waitTime();
					} else {
						System.out.println("not displayed");
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			BrowserSpecific.driver.switchTo().defaultContent();
			Thread.sleep(5000);
			BrowserSpecific.driver.switchTo().frame("epwfpageId");
			String actualMessageDate = BrowserSpecific.driver.findElement(
					By.xpath("//label[contains(text(),'" + expectedPaymentAccount
							+ "')]")).getText();
			String expectedMessageDate = "06/2019";
			boolean flag = actualMessageDate.contains(expectedMessageDate);
			Assert.assertTrue(flag, "Date Mismatch");

		}
		
	}

}