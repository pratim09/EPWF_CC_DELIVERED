package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * *******************************************************************************************
 * This class includes all the webElements required to verify the payment information once
 *  the payment is done
 ********************************************************************************************/
public class CCVerifyInfo {
	
	/*
	 * *******************************************************************************************
	 * 							WebElement Declaration
	 ********************************************************************************************/
	
	// Thanks Message Text in the Verify Information Page
	@FindBy(xpath = "//h3[contains(text(),'Thanks')]")
	private static WebElement thanksMsgText;

	// Confirmation Number Text in the Verify Information Page
	@FindBy(xpath = "//h3[contains(text(),'Confirmation')]")
	private static WebElement confirmationNmbrText;

	// Bill Amount Text in the Verify Information Page
	@FindBy(xpath = "//td[text()='Bill Payment:']/following-sibling::td[2]/span[2]")
	private static WebElement billAmountText;

	// Convenience Fee Text in the Verify Information Page
	@FindBy(xpath = "//td[text()='Convenience Fee:']/following-sibling::td[2]/span[2]")
	private static WebElement convenienceFeeText;

	// Total Payment Text in the Verify Information Page
	@FindBy(xpath = "//td[text()='Total Payment:']/following-sibling::td[2]/span[2]")
	private static WebElement totalPayment;

	// Payment Date Text in the Verify Information Page
	@FindBy(xpath = "//td[text()='Payment Date:']/following-sibling::td[2]")
	private static WebElement paymentDateText;

	// Card Number in the Verify Information Page
	@FindBy(xpath = "//td[text()='Payment Method:']/following-sibling::td[2]")
	private static WebElement paymentMethod;

	// in the Verify Information Page
	@FindBy(xpath = "//div[contains(@class,'speedPayLogoFooter')]")
	private static WebElement speedPayLogo;//

	// Submit Payment Button in the Verify Information Page
	@FindBy(id = "submitPayment")
	private static WebElement submitPaymentBtn;
	
	// Convenience Fee text in the Verify Information Page in case of payment through Bank Account - written by ManiRaj
	@FindBy(xpath = "//td[text()='Convenience Fee*:']/following-sibling::td[2]/span[2]")
	private static WebElement convenienceFeeTextForBankAccountPayment;
	
	// Convenience Fee Text in the Verify Information Page
	@FindBy(xpath = "//td[text()='Convenience Fee*:']/following-sibling::td[2]/span[2]")
	private static WebElement aCHconvenienceFeeText;//added*******************
		
	@FindBy(xpath = "//a[text()='Cancel']")
	private static WebElement cancelBtn;
	
	/*
	 * *******************************************************************************************
	 * 							Call To WebElements 
	 ********************************************************************************************/
	
	/**
	 * @return WebElement
	 * @methodName getThanksMsgText()
	 * @description returns Thanks Message Text webElement from PVerify
	 *              Information Page
	 * */
	public static WebElement getThanksMsgText() {
		return thanksMsgText;
	}

	/**
	 * @return WebElement
	 * @methodName getConfirmationNmbrText()
	 * @description returns Confirmation Number Text webElement from Verify
	 *              Information Page
	 * */
	public static WebElement getConfirmationNmbrText() {
		return confirmationNmbrText;
	}

	/**
	 * @return WebElement
	 * @methodName getBillAmountText()
	 * @description returns Bill Amount Text webElement from Verify Information
	 *              Page
	 * */
	public static WebElement getBillAmountText() {
		return billAmountText;
	}

	/**
	 * @return WebElement
	 * @methodName getConvenienceFeeText()
	 * @description returns Convenience Fee Text webElement from Verify
	 *              Information Page
	 * */
	public static WebElement getConvenienceFeeText() {
		return convenienceFeeText;
	}

	/**
	 * @return WebElement
	 * @methodName getTotalPayment()
	 * @description returns Total Payment Text webElement from Verify Information
	 *              Page
	 * */
	public static WebElement getTotalPayment() {
		return totalPayment;
	}

	/**
	 * @return WebElement
	 * @methodName getPaymentDateText()
	 * @description returns Payment Date Text webElement from Verify Information
	 *              Page
	 * */
	public static WebElement getPaymentDateText() {
		return paymentDateText;
	}

	/**
	 * @return WebElement
	 * @methodName getPaymentMethod()
	 * @description returns Card number Text  webElement from Verify Information
	 *              Page
	 * */
	public static WebElement getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * @return WebElement
	 * @methodName getBillAmountText()
	 * @description returns Bill Amount Text webElement from Verify Information
	 *              Page
	 * */
	public static WebElement getSpeedPayLogo() {
		return speedPayLogo;//
	}
	
	/**
	 * @return WebElement
	 * @methodName getSubmitPaymentBtn()
	 * @description returns SubmitPayment Button webElement from Verify
	 *              Information Page
	 * */
	public static WebElement getSubmitPaymentBtn() {
		return submitPaymentBtn;
	}
	
	/**
	 * @return WebElement
	 * @methodName getConvenienceFeeText()
	 * @description returns Convenience Fee Text webElement from Verify
	 *              Information Page
	 * */
	public static WebElement getConvenienceFeeTextForBankAccountPayment() {
		return convenienceFeeTextForBankAccountPayment;
	}
	
	
	/**
	 * @return WebElement
	 * @methodName getaCHconvenienceFeeText()
	 * @description returns Convenience Fee Text webElement from Verify
	 *              Information Page
	 * */
	public static WebElement getaCHconvenienceFeeText() {
		return aCHconvenienceFeeText;
	}
	
	
	/**
	 * @return WebElement
	 * @methodName getCancelButton()
	 * @description returns cancel button  webElement from Verify
	 *              Information Page
	 * */
	public static WebElement getCancelButton(){
		return cancelBtn;
	}

	/**
	 * @return WebElement
	 * @methodName getCancelBtn()
	 * @description returns SubmitPayment Button webElement from Verify
	 *              Information Page
	 * */
	public static WebElement getCancelBtn() {
		return cancelBtn;
	}
	
}