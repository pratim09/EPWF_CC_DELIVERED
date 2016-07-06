package BusinessSpecific;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import GenericLib.BrowserSpecific;
import GenericLib.CommonMethods;
import GenericLib.CommonValues;
import GenericLib.ExcelUtils;
import PageFactory.CCHomePage;
import PageFactory.CCPayByCreditCardPage;
import PageFactory.CCPaymentHistoryPage;
import PageFactory.CCPaymentInformationPage;
import PageFactory.CCReceiveConfirmationPage;
import PageFactory.CCTermsAndConditionPage;
import PageFactory.CCVerifyInfo;

/**
 * *****************************************************************************
 * ************** This class includes all the reusuable common methods scenarios
 * for control center
 ********************************************************************************************/
public class Methods {

	// ******************************Method declaration start
	// heres****************************************

	/**
	 * @return void
	 * @definition handles the maintenance popUp after login to Control Center
	 */

	public static void handleServicePopUp() {
		try {
			try {
				BrowserSpecific.driver
						.findElement(
								By.xpath("(//div[@id='_messageCenterPortlet_WAR_ControlCenterWebportlet_:mWidget:displayOutageDialog']//div[1]//a[1]//span)[1]"))
						.click();
			} catch (Exception e) {
				BrowserSpecific.driver
						.findElement(
								By.xpath("(//div[@id='_messageCenterPortlet_WAR_ControlCenterWebportlet_:mWidget:displayOutageDialog']//div[1]//a[1]//span)[2]"))
						.click();
			}
		} catch (ElementNotVisibleException e) {
			System.out.println("PopUp not present");
		}
	}

	/**
	 * @return void
	 * @definition navigate to Billing>>Pay Bill once user login to CC
	 */
	public static void navigateToPayBill() throws InterruptedException {

		CommonMethods.waitTillPageLoad();
        Thread.sleep(3000);
        JavascriptExecutor jse = (JavascriptExecutor)BrowserSpecific.driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        Thread.sleep(2000);
        CommonMethods.WaitForElement(CCHomePage.getBillingLink());
        CommonMethods.moveToElement(CCHomePage.getBillingLink());
        /*JavascriptExecutor executor = (JavascriptExecutor) BrowserSpecific.driver;
        executor.executeScript("arguments[0].click();",
                                CCHomePage.getBillingLink());*/

        CommonMethods.WaitForElement(CCHomePage.getPayBillLink());
        CCHomePage.getPayBillLink().click();
        CommonMethods.waitTillPageLoad();
        Thread.sleep(5000);



	}

	/**
	 * @return void
	 * @definition navigate to Pay Bill>>Pay By Credit Card once user login to
	 *             CC
	 */
	public static void navigateToPayCreditCard() throws InterruptedException {

		Methods.handleUpdateActPopUp();
		CommonMethods.WaitForElement(CCPaymentHistoryPage.getPayBillLink());
		CommonMethods.moveToElement(CCPaymentHistoryPage.getPayBillLink());
		JavascriptExecutor executor = (JavascriptExecutor) BrowserSpecific.driver;
		executor.executeScript("arguments[0].click();",
				CCPaymentHistoryPage.getPaybyCreditCardLink());
		CommonMethods.waitTillPageLoad();
		Thread.sleep(4000);

	}

	/**
	 * @return void
	 * @definition navigate to Pay Bill>>Pay By Bank Account once user login to
	 *             CC
	 */
	public static void navigateToPayByBankAccount() throws InterruptedException {
		CommonMethods.moveToElement(CCPaymentHistoryPage.getPayBillLink());
		JavascriptExecutor executor = (JavascriptExecutor) BrowserSpecific.driver;
		executor.executeScript("arguments[0].click();",
				CCPaymentHistoryPage.getPayByBankAccountLink());
		CommonMethods.waitTillPageLoad();

		Thread.sleep(4000);

	}

	/**
	 * @return void
	 * @definition select the number of accounts in the pay by credit card page
	 * @param numOfAccToSelect
	 *            : stores number of account to select
	 * @param billAmount
	 *            : stores the bill amount to pay for the account
	 * @throws Exception
	 * @throws NumberFormatException
	 */
	
	public static void selectAccount(String numOfAccToSelect, String billAmount, int row)
			throws NumberFormatException, Exception {

		int accToSelect = Integer.parseInt(numOfAccToSelect);
		
		
		JavascriptExecutor js = (JavascriptExecutor) BrowserSpecific.driver;
		BrowserSpecific.driver.manage().timeouts()
				.setScriptTimeout(10, TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(0,250)", "");
		int count = 0;
		List<WebElement> chkableEle = BrowserSpecific.driver
				.findElements(By
						.xpath("//div[@class='ui-datatable-scrollable-body']/table/tbody/tr/td[1]//div[2]"));
		List<WebElement> balanceTxt = BrowserSpecific.driver
				.findElements(By
						.xpath("//div[@class='ui-datatable-scrollable-body']/table/tbody/tr/td[7]/span"));
		List<WebElement> amountText = BrowserSpecific.driver
				.findElements(By
						.xpath("//div[@class='ui-datatable-scrollable-body']/table/tbody/tr/td[8]/input"));
		try{

		for (int i = 0; i < balanceTxt.size(); i++) {
			
			
			 balanceTxt = BrowserSpecific.driver
						.findElements(By
								.xpath("//div[@class='ui-datatable-scrollable-body']/table/tbody/tr/td[7]/span"));
			
			String balance = balanceTxt.get(i).getText();
			if(balance.contains("Not Available")){
				i++;
			}else{
			Float balanceFloat = Float.parseFloat(balance);
			if(ExcelUtils.getCellData("TestSheet", row, 7).equalsIgnoreCase("CreditCard")){
				if (balanceFloat > Float.parseFloat(ExcelUtils.getCellData("TestSheet", row, 9))) {	
					chkableEle = BrowserSpecific.driver
							.findElements(By
									.xpath("//div[@class='ui-datatable-scrollable-body']/table/tbody/tr/td[1]//div[2]"));
				CommonMethods.WaitForElementclick(chkableEle.get(i));
				/*js.executeScript("arguments[0].click();",
						chkableEle.get(i));*/
				js.executeScript(
						"var evt = document.createEvent('MouseEvents');"
								+ "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
								+ "arguments[0].dispatchEvent(evt);",
						chkableEle.get(i));

				Thread.sleep(5000);
				amountText = BrowserSpecific.driver
						.findElements(By
								.xpath("//div[@class='ui-datatable-scrollable-body']/table/tbody/tr/td[8]/input"));
				
				amountText.get(i).clear();
				amountText.get(i).sendKeys(billAmount);
				count++;
			}
			}else if(ExcelUtils.getCellData("TestSheet", row, 7).equalsIgnoreCase("BankAccount")){
				 chkableEle = BrowserSpecific.driver
							.findElements(By
									.xpath("//div[@class='ui-datatable-scrollable-body']/table/tbody/tr/td[1]//div[2]"));
					 balanceTxt = BrowserSpecific.driver
							.findElements(By
									.xpath("//div[@class='ui-datatable-scrollable-body']/table/tbody/tr/td[7]/span"));
					

				
				
				
				
				
				if (balanceFloat > Float.parseFloat(ExcelUtils.getCellData("TestSheet", row, 9))) {
					
					CommonMethods.WaitForElementclick(chkableEle.get(i));
					js.executeScript(
							"var evt = document.createEvent('MouseEvents');"
									+ "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
									+ "arguments[0].dispatchEvent(evt);",
							chkableEle.get(i));
					 amountText = BrowserSpecific.driver
								.findElements(By
										.xpath("//div[@class='ui-datatable-scrollable-body']/table/tbody/tr/td[8]/input"));
					//Thread.sleep(5000);
					amountText.get(i).clear();
					amountText.get(i).sendKeys(billAmount);
					count++;
				}
			}
			if (count == accToSelect) {
				break;
			}}
		}}
		catch(Exception e)
		{
			js.executeScript("window.scrollBy(0,250)", "");
			for (int i = 0; i < balanceTxt.size(); i++) {
				
				
				 balanceTxt = BrowserSpecific.driver
							.findElements(By
									.xpath("//div[@class='ui-datatable-scrollable-body']/table/tbody/tr/td[7]/span"));
				
				String balance = balanceTxt.get(i).getText();
				if(balance.contains("Not Available")){
					i++;
				}else{
				Float balanceFloat = Float.parseFloat(balance);
				if(ExcelUtils.getCellData("TestSheet", row, 7).equalsIgnoreCase("CreditCard")){
					if (balanceFloat > Float.parseFloat(ExcelUtils.getCellData("TestSheet", row, 9))) {	
						chkableEle = BrowserSpecific.driver
								.findElements(By
										.xpath("//div[@class='ui-datatable-scrollable-body']/table/tbody/tr/td[1]//div[2]"));
					CommonMethods.WaitForElementclick(chkableEle.get(i));
					/*js.executeScript("arguments[0].click();",
							chkableEle.get(i));*/
					js.executeScript(
							"var evt = document.createEvent('MouseEvents');"
									+ "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
									+ "arguments[0].dispatchEvent(evt);",
							chkableEle.get(i));

					Thread.sleep(5000);
					amountText = BrowserSpecific.driver
							.findElements(By
									.xpath("//div[@class='ui-datatable-scrollable-body']/table/tbody/tr/td[8]/input"));
					
					amountText.get(i).clear();
					amountText.get(i).sendKeys(billAmount);
					count++;
				}
				}else if(ExcelUtils.getCellData("TestSheet", row, 7).equalsIgnoreCase("BankAccount")){
					 chkableEle = BrowserSpecific.driver
								.findElements(By
										.xpath("//div[@class='ui-datatable-scrollable-body']/table/tbody/tr/td[1]//div[2]"));
						 balanceTxt = BrowserSpecific.driver
								.findElements(By
										.xpath("//div[@class='ui-datatable-scrollable-body']/table/tbody/tr/td[7]/span"));
						

					
					
					
					
					
					if (balanceFloat > Float.parseFloat(ExcelUtils.getCellData("TestSheet", row, 9))) {
						
						CommonMethods.WaitForElementclick(chkableEle.get(i));
						js.executeScript(
								"var evt = document.createEvent('MouseEvents');"
										+ "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
										+ "arguments[0].dispatchEvent(evt);",
								chkableEle.get(i));
						 amountText = BrowserSpecific.driver
									.findElements(By
											.xpath("//div[@class='ui-datatable-scrollable-body']/table/tbody/tr/td[8]/input"));
						//Thread.sleep(5000);
						amountText.get(i).clear();
						amountText.get(i).sendKeys(billAmount);
						count++;
					}
				}
				if (count == accToSelect) {
					break;
				}}
			}
		}
		CommonMethods.WaitForElement(CCPayByCreditCardPage
				.getPaySelectedBillsBtn());
		CCPayByCreditCardPage.getPaySelectedBillsBtn().click();
		CommonMethods.waitTillPageLoad();

	}
	
	
	
	/**
	 * @return void
	 * @definition check the authorize check box and click on the proceed button
	 */
	public static void authorizeAndProceed() throws InterruptedException {

		CommonMethods.WaitForElement(CCPayByCreditCardPage
				.getAuthorizationCheckBox());
		CCPayByCreditCardPage.getAuthorizationCheckBox().click();
		Thread.sleep(3000);

		CommonMethods.WaitForElement(CCPayByCreditCardPage.getProceedBtn());
		CCPayByCreditCardPage.getProceedBtn().click();
		CommonMethods.waitTillPageLoad();
		Thread.sleep(6000);

		BrowserSpecific.driver.switchTo().frame("epwfpageId");

	}

	/**
	 * @return void
	 * @definition verify whether the agree button present in the pay by credit
	 *             card page
	 */
	public static void verifyAgreeButtonInPayCardPage() {
		CommonMethods.WaitForElement(CCPayByCreditCardPage.getAgreeBtn());
		boolean agreeButton = CCPayByCreditCardPage.getAgreeBtn().isDisplayed();
		Assert.assertTrue(agreeButton, "I Agree button is not displayed");

	}

	/**
	 * @return void
	 * @definition verify whether the Cancel Button present in the pay by credit
	 *             card page
	 */
	public static void verifyCancelButtonInPayCardPage() {
		CommonMethods.WaitForElement(CCPayByCreditCardPage.getCancelBtn());
		boolean cancelButton = CCPayByCreditCardPage.getCancelBtn()
				.isDisplayed();
		Assert.assertTrue(cancelButton, "Cancel button is not displayed");

	}

	/**
	 * @return void
	 * @definition verify whether the SpeedPay Logo image is present in payment
	 *             information page
	 */
	public static void verifySpeedPayLogoInPaymtInfoPage() {
		CommonMethods.WaitForElement(CCPaymentInformationPage
				.getSpeedPayLogoImage());
		boolean speedPayLogo = CCPaymentInformationPage.getSpeedPayLogoImage()
				.isDisplayed();
		Assert.assertTrue(speedPayLogo, "Logo is not displayed");

	}

	/**
	 * @return void
	 * @definition verify whether the Terms And Condition Link is present in
	 *             payment information page
	 */
	public static void verifyTermsAndConditionInPaymtInfoPage() {
		CommonMethods.WaitForElement(CCPaymentInformationPage
				.getTermsAndConditionLink());
		boolean termsAndCondition = CCPaymentInformationPage
				.getTermsAndConditionLink().isDisplayed();
		Assert.assertTrue(termsAndCondition,
				"terms and condition link is not displayed");

	}

	/**
	 * @return void
	 * @definition verify whether the convenience fee present in the pay by
	 *             credit card page
	 * @param numOfAccSelected
	 *            stores the number of account to select
	 */
	public static void verifyConvncFeeInPayCardPage(String numOfAccSelected)
			throws InterruptedException {
		int convenienceFee = Integer.parseInt(numOfAccSelected);
		double totalConvenienceFee = convenienceFee
				* CommonValues.convienceFeeInt;
		String actualConvenienceFee = String
				.format("%.2f", totalConvenienceFee);
		String expectedconvenienceFee = CCPayByCreditCardPage
				.getConvenienceFeeText().getText();
		boolean flag = expectedconvenienceFee.contains(actualConvenienceFee);
		Assert.assertTrue(flag);

	}

	/**
	 * @return void
	 * @definition pass the control to the frame
	 */
	public static void switchToPaymentInformationFrame() {
		BrowserSpecific.driver.switchTo().frame("epwfpageId");

	}

	/**
	 * @return void
	 * @definition verify whether the amount field edit box is disable or not in
	 *             the payment information page
	 */
	public static void verifyAmountFieldDisable() throws InterruptedException {

		CommonMethods.waitTillPageLoad();

		CommonMethods.frameSwitching("epwfpageId");

		String amountAttributeValue = CCPaymentInformationPage
				.getPaymentAmountTextBox().getAttribute("autocomplete");

		Assert.assertEquals(amountAttributeValue, "off",
				"Amount field is not disabled");

	}

	/**
	 * @return void
	 * @definition verify whether the amount field edit box is disable or not in
	 *             the payment information page for ACH
	 */
	public static void verifyAmountFieldDisableACH()
			throws InterruptedException {

		CommonMethods.waitTillPageLoad();

		String amountAttributeValue = CCPaymentInformationPage
				.getPaymentAmountTextBox().getAttribute("autocomplete");
		Assert.assertEquals(amountAttributeValue, "off",
				"Amount field is not disabled");

	}

	/**
	 * @return void
	 * @definition verify whether the date field editbox is disable or not in
	 *             the payment information page
	 */
	public static void verifyDateFieldDisable() throws InterruptedException {

		Thread.sleep(2000);
		String dateAttributeValue = CCPaymentInformationPage
				.getPaymentDateTextBox().getAttribute("autocomplete");
		Assert.assertEquals(dateAttributeValue, "off",
				"Date field is not disabled");

	}

	/**
	 * @return void
	 * @definition verify whether the convenience fee text is displayed in the
	 *             UI in the payment information page
	 * @param numOfAccSelected
	 *            stores the number of account to select
	 */
	public static void verifyConvncFeeInPymtInfoPage(String numOfAccSelected)
			throws InterruptedException {
		int convenienceFee = Integer.parseInt(numOfAccSelected);
		double totalConvenienceFee = convenienceFee
				* CommonValues.convienceFeeInt;
		String actualConvenienceFee = String
				.format("%.2f", totalConvenienceFee);

		Thread.sleep(2000);
		String expectedconvenienceFee = CCPaymentInformationPage
				.getConvenienceFeeText().getText();
		boolean flag = expectedconvenienceFee.contains(actualConvenienceFee);
		Assert.assertTrue(flag);

	}

	/**
	 * @return void
	 * @definition verify whether the speedPay logo image is displayed in the UI
	 *             in the pay by credit page
	 */
	public static void verifySpeedPayLogoInPayCardPage()
			throws InterruptedException {

		Thread.sleep(2000);
		boolean speedPayLogo = CCPayByCreditCardPage.getSpeedPayLogoImage()
				.isDisplayed();
		Assert.assertTrue(speedPayLogo, "Logo is not displayed");

	}

	/**
	 * @return void
	 * @definition verify whether the Terms And Condition In Pay By Credit Card
	 *             Page
	 */
	public static void verifyTermsAndConditionInPayCardPage()
			throws InterruptedException {
		Thread.sleep(2000);
		boolean termsAndCondition = CCPayByCreditCardPage
				.getTermsAndConditionLink().isDisplayed();

		Assert.assertTrue(termsAndCondition,
				"terms and condition link is not displayed");

	}

	/**
	 * @return void
	 * @definition verify whether the Total Payment Amount In Payment
	 *             information Page
	 * @param numOfAccSelected
	 *            stores the number of account to select
	 * @param amtToPay
	 *            stores the number of amount to select
	 */
	public static void verifyTotalPymtAmtInPymtInfo(String amtToPay,
			String numOfAmtToPay) {
		int amtToSelect = Integer.parseInt(numOfAmtToPay);
		float amount = Float.parseFloat(amtToPay);
		float totalAmount = amount * amtToSelect;

		double totalConvenienceFee = amtToSelect * CommonValues.convienceFeeInt;

		double totalPymtAmount = totalAmount + totalConvenienceFee;

		String expectedTotalAmount = String.format("%.2f", totalPymtAmount);
		String actualTotalAmout = CCPaymentInformationPage
				.getTotalPaymentAmountValueText().getText();
		String newactualTotalAmout = actualTotalAmout.substring(1);
		boolean flag = expectedTotalAmount.contains(newactualTotalAmout);
		Assert.assertTrue(flag);

	}

	/**
	 * @return void
	 * @definition enter all the card details in payment information page
	 * @param cardNumber
	 *            stores the account card number
	 * @param zipCode
	 *            stores the zipcode
	 */
	public static void fillingNewCreditOrDebitAccountInfo(String cardNumber,
			String zipCode, boolean savePaymentChkbox, boolean clickNxtButton) {

		Select select = new Select(
				CCPaymentInformationPage.getMethodOfPaymentDrpDwn());
		select.selectByVisibleText(CommonValues.crdDbtPymt);
		CCPaymentInformationPage.Creditcardno().sendKeys(cardNumber);

		Select mnthDrpdwn = new Select(CCPaymentInformationPage.monthDropdown());
		mnthDrpdwn.selectByIndex(2);
		Select yearDrpdwn = new Select(CCPaymentInformationPage.yearDropdown());
		yearDrpdwn.selectByIndex(4);
		CCPaymentInformationPage.zipcodetxt().sendKeys(zipCode);
		CCPaymentInformationPage.getagreeCheckbox().click();
		if (savePaymentChkbox == true) {
			CCPaymentInformationPage.getSavePaymentMethodChkbox().click();
		}
		if (clickNxtButton == true) {
			CommonMethods.WaitForElement(CCPaymentInformationPage.getNextBtn());
			CCPaymentInformationPage.getNextBtn().click();
		}

	}

	/**
	 * @return void
	 * @definition verify the bill amount in the payment information page
	 * @param amountToPay
	 *            stores the bill amount to pay
	 * @param numOfAcct
	 *            stores the number of accounts to select
	 */
	public static void verifyBillAmtInVerifyInfoPage(String amountToPay,
			String numOfAcct) {

		int accToSelect = Integer.parseInt(numOfAcct);
		float amount = Float.parseFloat(amountToPay);
		float totalBillAmount = amount * accToSelect;
		String expectedTotalAmount = String.format("%.2f", totalBillAmount);
		String actualTotalAmout = CCVerifyInfo.getBillAmountText().getText();
		boolean flag = expectedTotalAmount.contains(actualTotalAmout);

		Assert.assertTrue(flag);

	}

	/**
	 * @return void
	 * @definition verify whether thw convenience fee displayed in the verify
	 *             information page
	 * @param numOfAccSelected
	 *            stores the number of accounts to select
	 */
	public static void verifyConvncFeeInVerifyInfoPage(String numOfAccSelected) {
		int convenienceFee = Integer.parseInt(numOfAccSelected);
		double totalConvenienceFee = convenienceFee
				* CommonValues.convienceFeeInt;

		String expectedconvenienceFee = String.format("%.2f",
				totalConvenienceFee);

		String actualConvenienceFee = CCVerifyInfo.getConvenienceFeeText()
				.getText();
		boolean flag = expectedconvenienceFee.contains(actualConvenienceFee);
		Assert.assertTrue(flag);
	}

	/**
	 * @return void
	 * @definition verify whether thw convenience fee displayed in the verify
	 *             information page
	 * @param numOfAccSelected
	 *            stores the number of accounts to select
	 */
	public static void verifyTotalPymtAmtInVerifyInfo(String amtToPay,
			String numOfAmtToPay) {
		int amtToSelect = Integer.parseInt(numOfAmtToPay);
		float amount = Float.parseFloat(amtToPay);
		float totalAmount = amount * amtToSelect;

		double totalConvenienceFee = amtToSelect * CommonValues.convienceFeeInt;

		double totalPymtAmount = totalAmount + totalConvenienceFee;

		String expectedTotalAmount = String.format("%.2f", totalPymtAmount);
		String actualTotalAmout = CCVerifyInfo.getTotalPayment().getText();
		boolean flag = expectedTotalAmount.contains(actualTotalAmout);
		Assert.assertTrue(flag);

	}

	/**
	 * @return void
	 * @definition verify payment date in the verify information page
	 */
	public static void verifyPymtDateInVerifyInfoPage() throws Exception {
		String expectedDatePattren = CommonMethods.datePattern();
		String actualDatePattren = CCVerifyInfo.getPaymentDateText().getText();
		boolean flag = actualDatePattren.contains(expectedDatePattren);
		Assert.assertTrue(flag);

	}

	/**
	 * @return void
	 * @definition verify the card number in the verify information page
	 * @param cardNum
	 *            stores the card number
	 */
	public static void verifyPymtMthdInVerifyInfopage(String cardNum) {
		Assert.assertEquals(CCVerifyInfo.getPaymentMethod().getText(), "Card "
				+ cardNum);
	}

	/**
	 * @return void
	 * @definition verify the speed logo image in verify information page
	 */
	public static void verifySpeedLogoInVIPage() {
		boolean logo = CCVerifyInfo.getSpeedPayLogo().isDisplayed();
		Assert.assertTrue(logo, "logo is not displayed");
	}

	/**
	 * @return void
	 * @definition verify bill amount in the Receiver confirmation page
	 * @param amountToPay
	 *            stores the bill amount
	 * @param numOfAcct
	 *            stores the number of account to select
	 */
	public static void verifyBillAmtInRCPage(String amountToPay,
			String numOfAcct) {

		int accToSelect = Integer.parseInt(numOfAcct);
		float amount = Float.parseFloat(amountToPay);
		float totalBillAmount = amount * accToSelect;
		String expectedTotalAmount = String.format("%.2f", totalBillAmount);
		String actualTotalAmout = CCReceiveConfirmationPage.getBillAmountText()
				.getText();
		boolean flag = expectedTotalAmount.contains(actualTotalAmout);
		Assert.assertTrue(flag);

	}

	/**
	 * @return void
	 * @definition verify convenience fee in the receiver confirmation page
	 * @param numOfAccSelected
	 *            stores the number of account to select
	 */
	public static void verifyConvncFeeInRCPage(String numOfAccSelected) {
		int convenienceFee = Integer.parseInt(numOfAccSelected);
		double totalConvenienceFee = convenienceFee
				* CommonValues.convienceFeeInt;

		String expectedconvenienceFee = String.format("%.2f",
				totalConvenienceFee);

		String actualConvenienceFee = CCReceiveConfirmationPage
				.getConvenienceFeeText().getText();
		boolean flag = expectedconvenienceFee.contains(actualConvenienceFee);
		Assert.assertTrue(flag);
	}

	/**
	 * @return void
	 * @definition verify total payment amount in the receiver confirmation page
	 * @param amtToPay
	 *            bill amount to pay
	 * @param numOfAmtToPay
	 *            number of ammount to pay
	 */
	public static void verifyTotalPymtAmtInRCPage(String amtToPay,
			String numOfAmtToPay) {
		int amtToSelect = Integer.parseInt(numOfAmtToPay);
		float amount = Float.parseFloat(amtToPay);
		float totalAmount = amount * amtToSelect;

		double totalConvenienceFee = amtToSelect * CommonValues.convienceFeeInt;

		double totalPymtAmount = totalAmount + totalConvenienceFee;

		String expectedTotalAmount = String.format("%.2f", totalPymtAmount);
		String actualTotalAmout = CCReceiveConfirmationPage.getTotalPayment()
				.getText();
		boolean flag = expectedTotalAmount.contains(actualTotalAmout);
		Assert.assertTrue(flag);

	}

	/**
	 * @return void
	 * @definition verify the payment date in the receiver confirmation page
	 */
	public static void verifyPymtDateInRCPage() throws Exception {
		String expectedDatePattren = CommonMethods.datePattern();
		boolean flag = CCReceiveConfirmationPage.getPaymentDateText().getText()
				.contains(expectedDatePattren);
		Assert.assertTrue(flag);

	}

	/**
	 * @return void
	 * @definition verify card number in the receiver confirmation page
	 * @param cardNum
	 *            stores the card number
	 */
	public static void verifyPymtMthdInRCpage(String cardNum) {
		String sub = cardNum.substring(12, 16);
		Assert.assertEquals(CCReceiveConfirmationPage.getPaymentMethod()
				.getText(), "Card ****" + sub);
	}

	/**
	 * @return void
	 * @definition verify speedlogo image in the receiver confirmation page
	 */
	public static void verifySpeedLogoInRCPage() {
		boolean logo = CCReceiveConfirmationPage.getSpeedPayLogo()
				.isDisplayed();
		Assert.assertTrue(logo, "logo is not displayed");
	}

	/**
	 * @return void
	 * @definition verify thanks message in the receiver confirmation page
	 */
	public static void verifyThanksMsgInRCPage() {

		Assert.assertEquals(CCReceiveConfirmationPage.getThanksMsgText()
				.getText(), CommonValues.thanksMsgStr);
	}

	/**
	 * @return void
	 * @definition Handled the Account update popUp after login
	 */
	public static void handleUpdateActPopUp() {
		try {
			//System.out.println("try");
			CommonMethods.WaitForElement(BrowserSpecific.driver.findElement(By
					.xpath("//div[@class='container-fluid ng-scope']")));
			if (BrowserSpecific.driver.findElement(
					By.xpath("//div[@class='container-fluid ng-scope']"))
					.isDisplayed()) {
				//System.out.println("if");
				CommonMethods.WaitForElement(BrowserSpecific.driver
						.findElement(By
								.xpath("//div[@class='modal-header']/button")));
				BrowserSpecific.driver.findElement(
						By.xpath("//div[@class='modal-header']/button"))
						.click();

			}
		} catch (Exception e) {
			//System.out.println("catch");
			System.out.println("no such popup");
		}

	}

	/**
	 * @author ab50783 - ManiRaj
	 * @return void
	 * @throws InterruptedException
	 * @definition verify whether the 'Payment has been cancelled' message is
	 *             present after clicking on cancel button in Payment
	 *             Information Frame
	 */
	public static void verifyPaymentCancellationMsg()
			throws InterruptedException {

		CommonMethods.waitTime();

		CommonMethods.WaitForElement(CCPayByCreditCardPage
				.getCancellationMsgText());

		String cancellationmsg = CCPayByCreditCardPage.getCancellationMsgText()
				.getText();
		String actcancellationmsg = cancellationmsg.substring(0, 49) + " "
				+ cancellationmsg.substring(51, 79);
		Assert.assertEquals(
				actcancellationmsg,
				"Per your request your payment has been cancelled. We appreciate your business.",
				"'Payment has been cancelled message' is not appeared on the page after cancel button is clicked.");
	}

	/**
	 * @author ab50783 - ManiRaj
	 * @return void
	 * @throws InterruptedException
	 * @definition Adds new Savings Account
	 */
	public static void fillingNewSavingsAccount(String routingnumber,
			String accountnumber) {
		Select select = new Select(
				CCPaymentInformationPage.getMethodOfPaymentDrpDwn());
		select.selectByVisibleText(CommonValues.newSavingsAcctPytm);
		CCPaymentInformationPage.getRoutingNoTextBox().sendKeys(routingnumber);
		CCPaymentInformationPage.getAccountNoTextBox().sendKeys(accountnumber);
		CCPaymentInformationPage.getSavePaymentMethodChkbox().click();
		CCPaymentInformationPage.getagreeCheckbox().click();
		CCPaymentInformationPage.getNextBtn().click();
	}

	/**
	 * @return void
	 * @author ab50783 - ManiRaj
	 * @definition verify whether the convenience fee displayed in the verify
	 *             information page while doing payment through Bank Account
	 */
	public static void verifyConvncFeeInVerifyInfoPageForBankAccount() {
		String actualConvenienceFee = CCVerifyInfo
				.getConvenienceFeeTextForBankAccountPayment().getText();
		String expectedConvenienceFee = "0.00";
		Assert.assertEquals(actualConvenienceFee, expectedConvenienceFee,
				"Actual Conenience Fee is not Expected Convenience Fee.");
	}

	/**
	 * @return void
	 * @author ab50783 - ManiRaj
	 * @definition verify whether the convenience fee displayed in the verify
	 *             information page while doing payment through Bank Account
	 */
	public static void selectACH(String accountNumber) {
		int length = accountNumber.length();
		String accountNumber2 = accountNumber.substring(length - 4);
		CommonMethods.WaitForElement(CCPaymentInformationPage
				.getMethodOfPaymentDrpDwn());
		Select select = new Select(
				CCPaymentInformationPage.getMethodOfPaymentDrpDwn());
		List<WebElement> options = BrowserSpecific.driver.findElements(By
				.xpath("//div/select[@name='paymentMethod']/option"));
		for (int i = 0; i < options.size(); i++) {
			String option = options.get(i).getText();
			if (option.contains(accountNumber2)) {
				select.selectByIndex(i);
			}
		}
		CCPaymentInformationPage.getagreeCheckbox().click();
		CCPaymentInformationPage.getNextBtn().click();
		CCVerifyInfo.getCancelButton().click();

	}

	/**
	 * @return void
	 * @definition check the terms and condition details for pay by card in each
	 *             page
	 */
	public static void termsAndCondnInPayCardPage() throws InterruptedException {

		Set<String> windowsIds = BrowserSpecific.driver.getWindowHandles();
		Iterator<String> itr = windowsIds.iterator();

		// patName will provide you parent window
		String patName = itr.next();

		// chldName will provide you child window
		String chldName = itr.next();

		// Switch to child window
		BrowserSpecific.driver.switchTo().window(chldName);

		// Do normal selenium code for performing action in child window
		String expected = "TERMINATION/CHANGES";
		String actual = CCTermsAndConditionPage.getTerminationText().getText();

		boolean flag = expected.contains(actual);
		Assert.assertTrue(flag);

		BrowserSpecific.driver.close();

		// To come back to parent window
		BrowserSpecific.driver.switchTo().window(patName);

		Thread.sleep(3000);
		BrowserSpecific.driver.switchTo().frame("epwfpageId");

	}

	/**
	 * @return void
	 * @definition check the terms and condition details for pay by Bank Account
	 *             in each page
	 */
	public static void termsAndCondnInACH() throws InterruptedException {

		Set<String> windowsIds = BrowserSpecific.driver.getWindowHandles();
		Iterator<String> itr = windowsIds.iterator();

		// patName will provide you parent window
		String patName = itr.next();

		// chldName will provide you child window
		String chldName = itr.next();

		// Switch to child window
		BrowserSpecific.driver.switchTo().window(chldName);

		// Do normal selenium code for performing action in child window
		String expected = " PAYMENT TERMS AND CONDITIONS ";
		String actual = CCTermsAndConditionPage.getpymtTermsAndCondnText()
				.getText();

		boolean flag = expected.contains(actual);
		Assert.assertTrue(flag);

		BrowserSpecific.driver.close();

		// To come back to parent window
		BrowserSpecific.driver.switchTo().window(patName);

		Thread.sleep(3000);
		BrowserSpecific.driver.switchTo().frame("epwfpageId");

	}

	/**
	 * @return void
	 * @definition select the method of payment in payment information page
	 *             using index value
	 * @param i
	 *            represent the index to be select
	 */
	public static void seletByIndex(int i) {
		CommonMethods.WaitForElement(CCPaymentInformationPage
				.getMethodOfPaymentDrpDwn());
		Select select = new Select(
				CCPaymentInformationPage.getMethodOfPaymentDrpDwn());
		select.selectByIndex(i);

	}

	/**
	 * @return void
	 * @methodName handelPendingAccountPopUp()
	 * @description handle the pending popUp message in case of account pending
	 *              *
	 */
	public static void handelPendingAccountPopUp() {
		try {

			if (CCPayByCreditCardPage.getPendingAccountMsgPopUp().isDisplayed()) {

				CommonMethods.WaitForElement(CCPayByCreditCardPage
						.getPopUpOkBtn());
				CCPayByCreditCardPage.getPopUpOkBtn().click();
				CommonMethods.waitTillPageLoad();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @return void
	 * @definition verify whether the convenience fee displayed in the verify
	 *             information page
	 * @param numOfAccSelected
	 *            stores the number of accounts to select
	 */
	public static void verifyACHConvncFeeInVerifyInfoPage(
			String numOfAccSelected) {
		int convenienceFee = Integer.parseInt(numOfAccSelected);
		double totalConvenienceFee = convenienceFee
				* CommonValues.aCHconvienceFeeInt;

		String expectedconvenienceFee = String.format("%.2f",
				totalConvenienceFee);

		String actualConvenienceFee = CCVerifyInfo.getaCHconvenienceFeeText()
				.getText();

		boolean flag = expectedconvenienceFee.contains(actualConvenienceFee);
		Assert.assertTrue(flag);
	}

	/**
	 * @return void
	 * @definition close the browser
	 */
	public static void closeBrowser() {
		BrowserSpecific.driver.close();
	}

	/**
	 * @return void
	 * @throws Exception
	 * @definition Select the required Bank Account Number from the Payment
	 *             Method drop down in the payment information page
	 */
	public static void deleteExistingACH() throws Exception {
		CommonMethods.WaitForElement(CCPaymentInformationPage
				.getMethodOfPaymentDrpDwn());
		Select select = new Select(
				CCPaymentInformationPage.getMethodOfPaymentDrpDwn());
		select.selectByIndex(1);
		String selectedAccount = select.getFirstSelectedOption().getText();
		ExcelUtils.setCellData(selectedAccount, "TestSheet", 2, 15);
		if (selectedAccount.contains("New Checking Account")) {
		} else {
			Thread.sleep(5000);
			BrowserSpecific.driver.findElement(
					By.xpath("//label[contains(text(),'" + selectedAccount
							+ "')]//following-sibling::a[text()='Delete']"))
					.click();

			try {
				if (CCPaymentInformationPage.getmethodOfPaymentPopUp()
						.isDisplayed()) {
					WebElement frame = BrowserSpecific.driver.findElement(By
							.xpath("(//iframe[@id='DeleteWalletIframe'])[2]"));
					BrowserSpecific.driver.switchTo().frame(frame);
					Thread.sleep(5000);
					if (CCPaymentInformationPage.getpopUpDeleteButton()
							.isDisplayed()) {
						JavascriptExecutor executor = (JavascriptExecutor) BrowserSpecific.driver;
						executor.executeScript("arguments[0].click();",
								CCPaymentInformationPage.getpopUpDeleteButton());
						executor.executeScript("arguments[0].click();",
								CCPaymentInformationPage
										.getDeleteACHCloseButton());
						CommonMethods.waitTime();
					} else {
						System.out.println("not displayed");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			Methods.verifyBankAccountDeleted();
		}

	}

	/**
	 * @return void
	 * @throws Exception
	 * @definition Select the required Bank Account Number from the Payment
	 *             Method drop down in the payment information page
	 */
	public static void verifyBankAccountDeleted() throws Exception {
		int count = 0;
		BrowserSpecific.driver.switchTo().defaultContent();
		CommonMethods.waitTime();
		Select select = new Select(
				CCPaymentInformationPage.getMethodOfPaymentDrpDwn());
		List<WebElement> options = select.getOptions();
		for (int i = 0; i < options.size(); i++) {
			if (options.get(i).getText()
					.contains(ExcelUtils.getCellData("TestSheet", 2, 15))) {
				count++;
				break;
			}
		}
		Assert.assertEquals(count, 0);
	}

	/**
	 * @return void
	 * @definition verify whether the convenience fee displayed in the verify
	 *             information page while doing payment through Bank Account
	 */

	public static void verifyCancellationMsgForBankAccount() throws Exception {
		CommonMethods.WaitForElement(CCPaymentInformationPage
				.getMethodOfPaymentDrpDwn());
		Select select = new Select(
				CCPaymentInformationPage.getMethodOfPaymentDrpDwn());
		select.selectByIndex(1);
		String selectedAccount = select.getFirstSelectedOption().getText();
		ExcelUtils.setCellData(selectedAccount, "TestSheet", 2, 15);
		if (selectedAccount.contains("New Checking Account")) {
			System.out.println("no saving account found");
		} else {
			Thread.sleep(5000);

			CCPaymentInformationPage.getagreeCheckbox().click();
			CCPaymentInformationPage.getNextBtn().click();
			CCVerifyInfo.getCancelBtn().click();
			String cancellationmsg = CCPayByCreditCardPage
					.getCancellationMsgText().getText();
			String actcancellationmsg = cancellationmsg.substring(0, 49) + " "
					+ cancellationmsg.substring(51, 79);
			Assert.assertEquals(
					actcancellationmsg,
					"Per your request your payment has been cancelled. We appreciate your business.",
					"'Payment has been cancelled message' is not appeared on the page after cancel button is clicked.");
		}

	}

	/**
	 * @return void
	 * @definition select the method of payment in payment information page
	 *             using visible text
	 * @param savingAccountStr
	 *            method of payment to be select
	 */
	public static void selectMethodOfPayment(String savingAccountStr) {
		Select select = new Select(
				CCPaymentInformationPage.getMethodOfPaymentDrpDwn());
		select.selectByVisibleText(savingAccountStr);
	}
}