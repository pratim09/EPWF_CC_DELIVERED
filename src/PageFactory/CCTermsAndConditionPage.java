
package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * *******************************************************************************************
 * This class includes all the webElements present in the Terms And Condition Page,which comes 
 * once the Terms And Condition Link is clicked
 ********************************************************************************************/
public class CCTermsAndConditionPage {
	
	/*
	 * *******************************************************************************************
	 * 							WebElement Declaration
	 ********************************************************************************************/
	
	// Termination Text in the Terms And Condition Page
	@FindBy(xpath = "//p[text()='TERMINATION/CHANGES']")
	private static WebElement terminationText;
	
	/*
	 * *******************************************************************************************
	 * 							Call To WebElements 
	 ********************************************************************************************/
	
	/**
	 * @return WebElement
	 * @methodName getTerminationText()
	 * @description returns Termination Text webElement from Terms And Condition
	 *              Page
	 * */
	
	@FindBy(xpath = "//div[contains(text(),' PAYMENT TERMS AND CONDITIONS ')]")
	private static WebElement pymtTermsAndCondnText;
	
	
	public static WebElement getTerminationText() {
		return terminationText;
	}
	
	public static WebElement getpymtTermsAndCondnText() {
		return pymtTermsAndCondnText;
	}


}
