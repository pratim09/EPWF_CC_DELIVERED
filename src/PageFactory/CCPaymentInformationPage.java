package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * *******************************************************************************************
 * This class includes all the webElements required to add , edit and delete the existing or
 *  new accounts
 ********************************************************************************************/
public class CCPaymentInformationPage {
	/*
	 * *******************************************************************************************
	 * 							WebElement Declaration
	 ********************************************************************************************/

	// Payment amount value TextBox in the Payment Information Page
	@FindBy(id = "PaymentAmount")
	private static WebElement paymentAmountTextBox;

	// Payment Date TextBox in the Payment Information Page
	@FindBy(id = "paymentDate")
	private static WebElement paymentDateTextBox;
	
	
	//Met of payment dropdown in payment information page
	@FindBy(id="MethodOfPayment")
	private static WebElement methodOfPaymentDrpDwn;

	// Total Payment Amount Value Text in the Payment Information Page
	@FindBy(id = "totalAmtWithFeeValue")
	private static WebElement totalPaymentAmountValueText;

	// Convenience Fee Text in the Payment Information Page
	@FindBy(xpath = "(//b[contains(text(),'convenience fee')])[1]")
	private static WebElement convenienceFeeText;

	// Terms And Condition Link in the Payment Information Page
	@FindBy(xpath = "//a[text()='Speedpay Terms and Conditions']")
	private static WebElement termsAndConditionLink;

	// SpeedPay Logo Image in the Payment Information Page
	@FindBy(xpath = "//div[@class='speedPayLogoFooter speedPayFloatRight desktop-font-style3 mobile-font-style3']")
	private static WebElement speedPayLogoImage;

	// Edit Button in the Payment Information Page
	@FindBy(xpath = "(//a[text()='Edit'])[1]")
	private static WebElement editBtn;

	// Delete Button in the Payment Information Page
	@FindBy(xpath = "(//a[text()='Delete'])[1]")
	private static WebElement deleteBtn;

	
	//Edit PopUp in Payment Information page
	@FindBy(xpath = "//div[@class='jh-content']")
	private static WebElement methodOfPaymentPopUp;

	// ZipCode TextBox after click on edit button in the Payment Information Page
	@FindBy(id = "cardZipCode")
	private static WebElement editZipCodeTextBox;

	//Save button in module popUp While editing payment
	@FindBy(id = "Update")
	private static WebElement popUpsaveBtn;

	//Delete button in Payment Information PAge
	@FindBy(id = "Delete")
	private static WebElement popUpDeleteBtn;

	// No Keep Button after click on delete button in the Payment Information Page
	@FindBy(id = "Cancel")
	private static WebElement deleteNoKeepBtn;

	// ZipCode Error message in Edit payment popUp
	@FindBy(id = "cardZipCode.errors")
	private static WebElement zipCodeErrorMsgText;

	// ExpiryMonth Error message in the Edit payment popUp
	@FindBy(id = "expiryMonth.errors")
	private static WebElement expiryMonthErrorMsgText;

	@FindBy(xpath = "(//a[text()='Edit'])[1]/preceding-sibling::label")
	private static WebElement updatedExpirationDate;//

	// Save Payment Method Checkbox in the Payment Information Page
	@FindBy(xpath = "//p[contains(text(),'Save this payment method ')]/preceding-sibling::a/span")
	private static WebElement savePaymentMethodCheckbox;

	
	//Card Number filled after selecting New Credit or Debit Card
	@FindBy(id = "cardNum")
	private static WebElement cardNumFiled;

	//Month Expiry field in modal popUp
	@FindBy(id = "expiryMonth")
	private static WebElement monthExpiry;

	
	//Year Expiry field in modal opUp
	@FindBy(id = "expiryYear")
	private static WebElement yearExpiry;

	
	//Zip Code field in modal popUp
	@FindBy(id = "cardZip")
	private static WebElement zipCode;

	// Agree Checkbox in the Payment Information Page
	@FindBy(xpath = "(//span[@class='checkbox-disable-icon'])[2]")
	private static WebElement agreeCheckbox;

	// Next Button in the Payment Information Page
	@FindBy(id = "ValidatePaymentInfo")
	private static WebElement nextBtn;
	
	// Routing number text box in the Payment Information Page - written by ManiRaj
	@FindBy(id = "routingNum")
	private static WebElement routingNoTextBox;
	
	// Account number text box in the Payment Information Page - written by ManiRaj
	@FindBy(id = "bankAccntNum")
	private static WebElement accountNoTextBox;
	
	// Terms And Condition Link in the Payment Information Page
	@FindBy(xpath = "//p/a[text()='Terms and Conditions']")
	private static WebElement termsAndConditionFooterLink;
	
	
	//Close Button in modal PopUp
	@FindBy(id = "Close")
	private static WebElement popUpCloseButtonAfterDelete;
	
	//Zip Code in modal PopUp
	@FindBy(id="cardZipCode")
	private static WebElement popupZipCode;
	
	//ZipCode Error in Modal PopUp
	@FindBy(id="cardZipCode.errors")
	private static WebElement zipCodeError;
	
	//Month zipcode in modal PopUp
	@FindBy(id="expiryMonth.errors")
	private static WebElement monthZipCodeError;
	
	
	//Cancel button in modal PopUp
	@FindBy(id="Cancel")
	private static WebElement cancelbutton;
	
	//Close button in modal PopUp
	@FindBy(id="Close")
	private static WebElement closebutton;

	/*
	 * *******************************************************************************************
	 * 							Call To WebElements 
	 ********************************************************************************************/
	
	
	/**
	 * @return WebElement
	 * @methodName getPaymentAmountTextBox()
	 * @description returns Payment Amount TextBox webElement from Payment
	 *              Information Page
	 * */
	public static WebElement getPaymentAmountTextBox() {
		return paymentAmountTextBox;
	}

	/**
	 * @return WebElement
	 * @methodName getPaymentDateTextBox()
	 * @description returns Payment Date TextBox webElement from Payment
	 *              Information Page
	 * */
	public static WebElement getPaymentDateTextBox() {
		return paymentDateTextBox;
	}

	/**
	 * @return WebElement
	 * @methodName getMethodOfPaymentDrpDwn()
	 * @description returns Method Of Payment DropDown webElement from Payment
	 *              Information Page
	 * */
	public static WebElement getMethodOfPaymentDrpDwn() {
		return methodOfPaymentDrpDwn;
	}

	/**
	 * @return WebElement
	 * @methodName getTotalPaymentAmountValueText()
	 * @description returns Total Payment Amount Value Text webElement from
	 *              Payment Information Page
	 * */
	public static WebElement getTotalPaymentAmountValueText() {
		return totalPaymentAmountValueText;
	}

	/**
	 * @return WebElement
	 * @methodName getConvenienceFeeText()
	 * @description returns Convenience Fee Text webElement from Payment
	 *              Information Page
	 * */
	public static WebElement getConvenienceFeeText() {
		return convenienceFeeText;
	}

	/**
	 * @return WebElement
	 * @methodName getTermsAndConditionLink()
	 * @description returns Terms And Condition Link webElement from Payment
	 *              Information Page
	 * */
	public static WebElement getTermsAndConditionLink() {
		return termsAndConditionLink;
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

	/**
	 * @return WebElement
	 * @methodName getEditBtn()
	 * @description returns Edit Button webElement from Payment Information Page
	 * */
	public static WebElement getEditBtn() {
		return editBtn;
	}

	/**
	 * @return WebElement
	 * @methodName getDeleteBtn()
	 * @description returns Delete Button webElement from Payment Information
	 *              Page
	 * */
	public static WebElement getDeleteBtn() {
		return deleteBtn;
	}

	/**
	 * @return WebElement
	 * @methodName getPaySelectedBillsBtn()
	 * @description returns Pay Selected Bills Button webElement from Payment
	 *              Information Page
	 * */
	public static WebElement getmethodOfPaymentPopUp() {
		return methodOfPaymentPopUp;//
	}

	/**
	 * @return WebElement
	 * @methodName getEditZipCodeTextBox()
	 * @description returns ZipCode TextBox webElement from Edit Payment PopUp
	 * */
	public static WebElement getEditZipCodeTextBox() {
		return editZipCodeTextBox;
	}

	/**
	 * @return WebElement
	 * @methodName getPaySelectedBillsBtn()
	 * @description returns Pay Selected Bills Button webElement from Payment
	 *              Information Page
	 * */
	public static WebElement getpopUpSaveButton() {
		return popUpsaveBtn;//
	}

	/**
	 * @return WebElement
	 * @methodName getPaySelectedBillsBtn()
	 * @description returns Pay Selected Bills Button webElement from Payment
	 *              Information Page
	 * */
	public static WebElement getpopUpDeleteButton() {
		return popUpDeleteBtn;//
	}

	/**
	 * @return WebElement
	 * @methodName getDeleteNoKeepBtn()
	 * @description returns No Keep Button webElement from Edit payment popUp
	 * */
	public static WebElement getDeleteNoKeepBtn() {
		return deleteNoKeepBtn;
	}

	/**
	 * @return WebElement
	 * @methodName getZipCodeErrorMsgText()
	 * @description returns ZipCode Error Messag Text webElement from Edit
	 *              payment popUp
	 * */
	public static WebElement getZipCodeErrorMsgText() {
		return zipCodeErrorMsgText;
	}

	/**
	 * @return WebElement
	 * @methodName getExpiryMonthErrorMsgText()
	 * @description returns Expiry Month Error Messag Text webElement from Edit
	 *              payment popUp
	 * */
	public static WebElement getExpiryMonthErrorMsgText() {
		return expiryMonthErrorMsgText;
	}

	/**
	 * @return WebElement
	 * @methodName getupdatedExpirationDate()
	 * @description returns getupdatedExpirationDate webElement from Payment
	 *              Information Page
	 * */
	public static WebElement getupdatedExpirationDate() {
		return updatedExpirationDate;//
	}

	/**
	 * @return WebElement
	 * @methodName getSavePaymentMethodChkbox()
	 * @description returns Save Payment Method Chekbox webElement from Payment
	 *              Information Page
	 * */
	public static WebElement getSavePaymentMethodChkbox() {
		return savePaymentMethodCheckbox;
	}

	/**
	 * @return WebElement
	 * @methodName getPaySelectedBillsBtn()
	 * @description returns Pay Selected Bills Button webElement from Payment
	 *              Information Page
	 * */
	public static WebElement Creditcardno() {
		return cardNumFiled;//
	}

	/**
	 * @return WebElement
	 * @methodName getPaySelectedBillsBtn()
	 * @description returns Pay Selected Bills Button webElement from Payment
	 *              Information Page
	 * */
	public static WebElement monthDropdown() {
		return monthExpiry;//
	}

	/**
	 * @return WebElement
	 * @methodName getPaySelectedBillsBtn()
	 * @description returns Pay Selected Bills Button webElement from Payment
	 *              Information Page
	 * */
	public static WebElement yearDropdown() {
		return yearExpiry;//
	}

	/**
	 * @return WebElement
	 * @methodName getPaySelectedBillsBtn()
	 * @description returns Pay Selected Bills Button webElement from Payment
	 *              Information Page
	 * */
	public static WebElement zipcodetxt() {
		return zipCode;//
	}

	/**
	 * @return WebElement
	 * @methodName getagreeCheckbox()
	 * @description returns agree Checkbox webElement from PPayment Information
	 *              Page
	 * */
	public static WebElement getagreeCheckbox() {
		return agreeCheckbox;
	}

	/**
	 * @return WebElement
	 * @methodName getNextBtn()
	 * @description returns Next Button webElement from Payment Information Page
	 * */
	public static WebElement getNextBtn() {
		return nextBtn;
	}
	
	/**
	 * @return WebElement
	 * @methodName getRoutingNoTextBox()
	 * @description returns Routing Number Text Box webElement from Payment Information Page
	 * */
	public static WebElement getRoutingNoTextBox() {
		return routingNoTextBox;
	}
	
	/**
	 * @return WebElement
	 * @methodName getNextBtn()
	 * @description returns Account Number Text Box webElement from Payment Information Page
	 * */
	public static WebElement getAccountNoTextBox() {
		return accountNoTextBox;
	}	
	
	/**
	 * @return WebElement
	 * @methodName gettermsAndConditionFooterLink()
	 * @description returns Next Button webElement from Payment Information Page
	 * */
	public static WebElement gettermsAndConditionFooterLink() {
		return termsAndConditionFooterLink;
	}
	
	
	
	/**
	 * @return WebElement
	 * @methodName getPopUpZipCode()
	 * @description returns PopUp ZipCode webElement from Payment Information Page
	 * */
	public static WebElement getPopUpZipCode()
	{
		return popupZipCode;
	}

	/**
	 * @return WebElement
	 * @methodName getpopUpZipCodeError()
	 * @description returns PopUp ZipCode Error webElement from Payment
	 *              Information Page
	 * */
	public static WebElement getpopUpZipCodeError() {
		return zipCodeError;
	}

	/**
	 * @return WebElement
	 * @methodName getpopUpExpiryMonthError()
	 * @description returns PopUp ZipCode webElement from Payment Information
	 *              Page
	 * */
	public static WebElement getpopUpExpiryMonthError() {
		return monthZipCodeError;
	}

	/**
	 * @return WebElement
	 * @methodName getpopUpNoKeepButton()
	 * @description returns PopUp NoKeep webElement from Payment Information
	 *              Page
	 * */
	public static WebElement getpopUpNoKeepButton() {

		return cancelbutton;
	}

	/**
	 * @return WebElement
	 * @methodName getPopUpCloseButton()
	 * @description returns PopUp close Button webElement from Payment
	 *              Information Page
	 * */
	public static WebElement getPopUpCloseButton() {
		return closebutton;
	}

	/**
	 * @return WebElement
	 * @methodName getDeleteACHCloseButton()
	 * @description returns PopUp close button webElement from Payment
	 *              Information Page
	 * */
	public static WebElement getDeleteACHCloseButton() {
		return popUpCloseButtonAfterDelete;
	}
}
