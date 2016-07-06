package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * *******************************************************************************************
 * This class includes all the webElements requited to select the accounts,authorize the accounts
 * and cancel the accounts and verify the accounts details 
 ********************************************************************************************/
public class CCPayByCreditCardPage {
	/*
	 * *******************************************************************************************
	 * 							WebElement Declaration
	 ********************************************************************************************/
	
	// Pay Selected Bills Button in Pay By Credit Card Page
	@FindBy(xpath = "//span[text()='Pay Selected Bills']")
	private static WebElement paySelectedBillsBtn;

	// Authorization CheckBox in Pay By Credit Card Page
	@FindBy(xpath = "//div[@id='bottomDiv']/span/div/div/div[2]")
	private static WebElement authorizationCheckBox;

	// Proceed Button in Pay By Credit Card Page
	@FindBy(xpath = "//span[text()='Proceed']")
	private static WebElement proceedBtn;
	
	// Cancel Button in Pay By Credit Card Page
	@FindBy(id = "Cancel")
	private static WebElement cancelBtn;

	// Ok Button in Pay By Credit Card Page
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	private static WebElement okBtn;

	// Cancellation Message after clicking on cancel Button
	@FindBy(xpath = "//div[contains(text(),'payment has been cancelled')]")
	private static WebElement cancellationMsgText;

	// Agree Button in Pay By Credit Card Page
	@FindBy(xpath = "//a[text()='I Agree']")
	private static WebElement agreeBtn;

	// SpeedPay Logo Image in Pay By Credit Card Page
	@FindBy(xpath = "//span[@class='speedPayLogo mobile-align-center']")
	private static WebElement speedPayLogoImage;

	// Terms And Condition Link in Pay By Credit Card Page
	@FindBy(xpath = "//a[contains(text(),'Terms and Conditions')][1]")
	private static WebElement termsAndConditionLink;

	// Convenience Fee Text in Pay By Credit Card Page
	@FindBy(xpath = "//span[contains(text(),'convenience fee')]")
	private static WebElement convenienceFeeText;

	// Pending Account PopUp in Pay By Credit Card Page
	@FindBy(xpath = "//div[@id='_PayByCreditcard_WAR_EBillingWebportlet_:paybyerrorOverlayDupId']")
	private static WebElement pendingAccountMsgPopUp;

	// Ok Button in Pending Account PopUp
	@FindBy(xpath = "//span[text()='OK']")
	private static WebElement popUpOkBtn;

	/*
	 * *******************************************************************************************
	 * 							Call To WebElements 
	 ********************************************************************************************/
	
	/**
	 * @return WebElement
	 * @methodName getPaySelectedBillsBtn()
	 * @description returns Pay Selected Bills Button webElement from Pay By
	 *              Credit Card Page
	 * */
	public static WebElement getPaySelectedBillsBtn() {
		return paySelectedBillsBtn;
	}

	/**
	 * @return WebElement
	 * @methodName getAuthorizationCheckBox()
	 * @description returns Authorization CheckBox webElement from Pay By Credit
	 *              Card Page
	 * */
	public static WebElement getAuthorizationCheckBox() {
		return authorizationCheckBox;
	}

	/**
	 * @return WebElement
	 * @methodName getProceedBtn()
	 * @description returns Proceed Button webElement from Pay By Credit Card
	 *              Page
	 * */
	public static WebElement getProceedBtn() {
		return proceedBtn;
	}

	/**
	 * @return WebElement
	 * @methodName getOkBtn()
	 * @description returns Ok Button webElement from Pay By Credit Card Page
	 * */
	public static WebElement getOkBtn() {
		return okBtn;
	}

	/**
	 * @return WebElement
	 * @methodName getCancellationMsgText()
	 * @description returns Cancellation Message Text webElement on clicking
	 *              Cancel Button from Pay By Credit Card Page
	 * */
	public static WebElement getCancellationMsgText() {
		return cancellationMsgText;
	}

	/**
	 * @return WebElement
	 * @methodName getCancelBtn()
	 * @description returns Cancel Button webElement from Pay By Credit Card
	 *              Page
	 * */
	public static WebElement getCancelBtn() {
		return cancelBtn;
	}

	/**
	 * @return WebElement
	 * @methodName getAgreeBtn()
	 * @description returns Agree Button webElement from Pay By Credit Card Page
	 * */
	public static WebElement getAgreeBtn() {
		return agreeBtn;
	}

	/**
	 * @return WebElement
	 * @methodName getSpeedPayLogoImage()
	 * @description returns SpeedPayLogo Image webElement from Pay By Credit
	 *              Card Pagee
	 * */
	public static WebElement getSpeedPayLogoImage() {
		return speedPayLogoImage;
	}

	/**
	 * @return WebElement
	 * @methodName getTermsAndConditionlink()
	 * @description returns Terms And Condition Link webElement from Pay By
	 *              Credit Card Page
	 * */
	public static WebElement getTermsAndConditionLink() {
		return termsAndConditionLink;
	}

	/**
	 * @return WebElement
	 * @methodName getConvenienceFeeText()
	 * @description returns Convenience Fee Text webElement from Pay By Credit
	 *              Card Page
	 * */
	public static WebElement getConvenienceFeeText() {
		return convenienceFeeText;
	}

	/**
	 * @return WebElement
	 * @methodName pendingAccountMsgPopUp()
	 * @description returns Pending Account message webElement from Pay By
	 *              Credit Card Page
	 * */
	public static WebElement getPendingAccountMsgPopUp() {
		return pendingAccountMsgPopUp;
	}

	/**
	 * @return WebElement
	 * @methodName getPopUpOkBtn()
	 * @description returns Ok Button webElement present in account pending
	 *              message PopUp
	 * */
	public static WebElement getPopUpOkBtn() {
		return popUpOkBtn;
	}
}