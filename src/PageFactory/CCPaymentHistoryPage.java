package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * *******************************************************************************************
 * This class includes all the webElements required to navigate different payment gateway 
 ********************************************************************************************/
public class CCPaymentHistoryPage {
	
	/*
	 * *******************************************************************************************
	 * 							WebElement Declaration
	 ********************************************************************************************/
	
	// Pay Bill link in the payment history page
	@FindBy(xpath = "//a[span[text()='Pay Bill']]")
	private static WebElement payBillLink;

	// Pay by Credit Card link in the payment history page
	@FindBy(xpath = "//a[span[text()='Pay by Credit Card']]")
	private static WebElement paybyCreditCardLink;

	// Pay By Bank Account Link in the payment history page
	@FindBy(xpath = "//span[text()='Pay by Bank Account']")
	private static WebElement payByBankAccountLink;
	
	/*
	 * *******************************************************************************************
	 * 							Call To WebElements 
	 ********************************************************************************************/
	
	/**
	 * @return WebElement
	 * @methodName getPayBillLink()
	 * @description returns Pay Bill Link webElement from Pay By Credit Card
	 *              Page
	 * */
	public static WebElement getPayBillLink() {
		return payBillLink;
	}

	/**
	 * @return WebElement
	 * @methodName getPaybyCreditCardLink()
	 * @description returns Pay by Credit Card Link webElement from Pay By
	 *              Credit Card Page
	 * */
	public static WebElement getPaybyCreditCardLink() {
		return paybyCreditCardLink;
	}

	/**
	 * @return WebElement
	 * @methodName getPayByBankAccountLink()
	 * @description returns Pay By Bank Account Link webElement from Pay By
	 *              Credit Card Page
	 * */
	public static WebElement getPayByBankAccountLink() {
		return payByBankAccountLink;

	}
}