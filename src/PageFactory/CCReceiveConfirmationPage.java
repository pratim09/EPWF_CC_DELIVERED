package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * *******************************************************************************************
 * This class includes all the webElements required to verify the payment information once
 *  the payment is received
 ********************************************************************************************/
public class CCReceiveConfirmationPage {
	/*
	 * *******************************************************************************************
	 * 							WebElement Declaration
	 ********************************************************************************************/
	
	// Thanks Message Text in the Receive Confirmation Page 
	@FindBy(xpath = "//h3[contains(text(),'Thanks')]")
	private static WebElement thanksMsgText;

	// Confirmation Number Text in the Receive Confirmation Page
	@FindBy(xpath = "//h3[contains(text(),'Confirmation')]")
	private static WebElement confirmationNmbrText;

	// Bill Amount Text in the Receive Confirmation Page
	@FindBy(xpath = "//td[text()='Bill Payment:']/following-sibling::td[2]/span[2]")
	private static WebElement billAmountText;

	// Convenience Fee Text in the Receive Confirmation Page
	@FindBy(xpath = "//td[text()='Convenience Fee:']/following-sibling::td[2]/span[2]")
	private static WebElement convenienceFeeText;

	// Total Payment Text in the Receive Confirmation Page
	@FindBy(xpath = "//td[text()='Total Payment:']/following-sibling::td[2]/span[2]")
	private static WebElement totalPayment;

	// Payment Date Text in the Receive Confirmation Page
	@FindBy(xpath = "//td[text()='Payment Date:']/following-sibling::td[2]")
	private static WebElement paymentDateText;

	// Card Number in the Receive Confirmation Page
	@FindBy(xpath = "//td[text()='Payment Method:']/following-sibling::td[2]")
	private static WebElement paymentMethod;

	// SpeedPayLogo image in the Receive Confirmation Page
	@FindBy(xpath = "//div[contains(@class,'speedPayLogoFooter')]")
	private static WebElement speedPayLogo;//


	/*
	 * *******************************************************************************************
	 * 							Call To WebElements 
	 ********************************************************************************************/
	
	/**
	 * @return WebElement
	 * @methodName getThanksMsgText()
	 * @description returns Thanks Message Text webElement from Receive Confirmation Page
	 * */
	public static WebElement getThanksMsgText() {
		return thanksMsgText;
	}

	/**
	 * @return WebElement
	 * @methodName getConfirmationNmbrText()
	 * @description returns Confirmation Number Text webElement from Receive Confirmation Page
	 * */
	public static WebElement getConfirmationNmbrText() {
		return confirmationNmbrText;
	}

	/**
	 * @return WebElement
	 * @methodName getBillAmountText()
	 * @description returns Bill Amount Text webElement from Receive Confirmation Page
	 * */
	public static WebElement getBillAmountText() {
		return billAmountText;
	}

	/**
	 * @return WebElement
	 * @methodName getConvenienceFeeText()
	 * @description returns Convenience Fee Text webElement from Receive Confirmation Page
	 * */
	public static WebElement getConvenienceFeeText() {
		return convenienceFeeText;
	}

	/**
	 * @return WebElement
	 * @methodName getTotalPayment()
	 * @description returns Total Payment Text webElement from Receive Confirmation Page
	 * */
	public static WebElement getTotalPayment() {
		return totalPayment;
	}

	/**
	 * @return WebElement
	 * @methodName getPaymentDateText()
	 * @description returns Payment Date Text webElement from Receive Confirmation Page
	 * */
	public static WebElement getPaymentDateText() {
		return paymentDateText;
	}

	/**
	 * @return WebElement
	 * @methodName getPaymentMethod()
	 * @description returns Card number Text  webElement from Receive Confirmation Page
	 * */
	public static WebElement getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * @return WebElement
	 * @methodName getBillAmountText()
	 * @description returns Bill Amount Text webElement from Receive Confirmation Page
	 * */
	public static WebElement getSpeedPayLogo() {
		return speedPayLogo;//
	}

}
