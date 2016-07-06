package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * *******************************************************************************************
 * This class includes all the webElements required to verify the payment information once the 
 * existing or new account is added
 ********************************************************************************************/
public class CCPaymentInfo {
	/*
	 * *******************************************************************************************
	 * 							WebElement Declaration
	 ********************************************************************************************/

	// Bill Amount Text in the Payment Information Page
	@FindBy(xpath = "//td[text()='Bill Payment:']/following-sibling::td[2]/span[2]")
	private static WebElement billAmountText;

	// Convenience Fee Text in the Payment Information Page
	@FindBy(xpath = "//td[text()='Convenience Fee:']/following-sibling::td[2]/span[2]")
	private static WebElement convenienceFeeText;

	// Total Payment Text in the Payment Information Page
	@FindBy(xpath = "//td[text()='Total Payment:']/following-sibling::td[2]/span[2]")
	private static WebElement totalPaymentText;

	// Payment Date Text in the Payment Information Page
	@FindBy(xpath = "//td[text()='Payment Date:']/following-sibling::td[2]")
	private static WebElement paymentDateText;

	// Card Number Text in the Payment Information Page
	@FindBy(xpath = "//td[text()='Payment Method:']/following-sibling::td[2]")
	private static WebElement cardNumberText;

	// Cancel Button in the Payment Information Page
	@FindBy(xpath = "//a[contains(@href,'cancel')]")
	private static WebElement cancelBtn;

	// Submit Payment Button in the Payment Information Page
	@FindBy(id = "submitPayment")
	private static WebElement submitPaymentBtn;

	// SpeedPay Logo Image in the Payment Information Page
	@FindBy(xpath = "//div[contains(@class,'speedPayLogoFooter')]")
	private static WebElement speedPayLogoImage;
	
	
	/*
	 * *******************************************************************************************
	 * 							Call To WebElements 
	 ********************************************************************************************/
	
	/**
	 * @return WebElement
	 * @methodName getBillAmountText()
	 * @description returns Bill Amount Text webElement from Payment Information
	 *              Page
	 * */
	public static WebElement getBillAmountText() {
		return billAmountText;
	}

	/**
	 * @return WebElement
	 * @methodName getConvenienceFeeText()
	 * @description returns ConvenienceFee Text webElement from Payment
	 *              Information Page
	 * */
	public static WebElement getConvenienceFeeText() {
		return convenienceFeeText;
	}

	/**
	 * @return WebElement
	 * @methodName getTotalPaymentText()
	 * @description returns TotalPayment Text webElement from Payment
	 *              Information Page
	 * */
	public static WebElement getTotalPaymentText() {
		return totalPaymentText;
	}

	/**
	 * @return WebElement
	 * @methodName getPaymentDateText()
	 * @description returns PaymentDate Text webElement from Payment Information
	 *              Page
	 * */
	public static WebElement getPaymentDateText() {
		return paymentDateText;
	}

	/**
	 * @return WebElement
	 * @methodName getcardNumberText()
	 * @description returns cardNumber Text webElement from Payment Information
	 *              Page
	 * */
	public static WebElement getcardNumberText() {
		return cardNumberText;
	}

	/**
	 * @return WebElement
	 * @methodName getCancelBtn()
	 * @description returns Cancel Button webElement from Payment Information
	 *              Page
	 * */
	public static WebElement getCancelBtn() {
		return cancelBtn;
	}

	/**
	 * @return WebElement
	 * @methodName getSubmitPaymentBtn()
	 * @description returns SubmitPayment Button webElement from Payment
	 *              Information Page
	 * */
	public static WebElement getSubmitPaymentBtn() {
		return submitPaymentBtn;
	}

	/**
	 * @return WebElement
	 * @methodName getSpeedPayLogoImage()
	 * @description returns SpeedPay Logo Image webElement from Payment
	 *              Information Page
	 * */
	public static WebElement getSpeedPayLogoImage() {
		return speedPayLogoImage;
	}
}
