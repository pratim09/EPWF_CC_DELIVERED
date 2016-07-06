package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * *******************************************************************************************
 * This class includes all the webElements present in the home page after login to control
 * center
 ********************************************************************************************/
public class CCHomePage {
	
	/*
	 * *******************************************************************************************
	 * 							WebElement Declaration
	 ********************************************************************************************/

	
	
	
	// Billing Link present in the menu in home page
	@FindBy(xpath = "//span[text()='Billing ']")
	private static WebElement billingLink;
	
	// Pay Bill Link present under billing link in home page
	@FindBy(xpath = "//a[text()='Pay Bill']")
	private static WebElement payBillLink;
	
	// Service PopUp after login
	@FindBy(xpath = "(//span[text()='Go to Control Center'])[3]")
	private static WebElement cCservicePopUp;

	/*
	 * *******************************************************************************************
	 * 							Call To WebElements 
	 ********************************************************************************************/
	
	/**
	 * @return WebElement
	 * @methodName getBillingLink()
	 * @description returns Billing Link webElement from home page
	 * */
	public static WebElement getBillingLink() {
		return billingLink;
	}
	
	

	/**
	 * @return WebElement
	 * @methodName getPayBillLink()
	 * @description returns Pay Bill Link webElement from home page
	 * */
	public static WebElement getPayBillLink() {
		return payBillLink;
	}
	
	
	/**
	 * @return WebElement
	 * @methodName getcCservicePopUp()
	 * @description returns PopUp webElement from home page
	 * */
	public static WebElement getcCservicePopUp() {
		return cCservicePopUp;
	}
	
	@FindBy(xpath="(//span[@class='ui-icon ui-icon-closethick'])[3]")
	public static WebElement maintenancepopup;
	public static WebElement getmaintenancePopup()
	{
		return maintenancepopup;
	}
}