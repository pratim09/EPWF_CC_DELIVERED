package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * *******************************************************************************************
 * This class includes all the webElements present in the control center Login page
 ********************************************************************************************/
public class CCLoginPage {
	/*
	 * *******************************************************************************************
	 * 							WebElement Declaration
	 ********************************************************************************************/
	
	// User Name TextBox in login page
	@FindBy(id = "userId")
	private static WebElement userNameTextBox;

	// Password TextBox in login page
	@FindBy(id = "password")
	private static WebElement passwordTextBox;

	// Login Button in login Page
	@FindBy(id = "LoginFormSubmit")
	private static WebElement loginBtn;
	
	/*
	 * *******************************************************************************************
	 * 							Call To WebElements 
	 ********************************************************************************************/
	
	/**
	 * @return WebElement
	 * @methodName getUserName()
	 * @description returns User Name TextBox webElement from login page
	 * */
	public static WebElement getUserNameTextBox() {
		return userNameTextBox;
	}

	/**
	 * @return WebElement
	 * @methodName getPassword()
	 * @description returns Password TextBox webElement from login page
	 * */
	public static WebElement getPasswordTextBox() {
		return passwordTextBox;
	}

	/**
	 * @return WebElement
	 * @methodName getLoginButton()
	 * @description returns Login Button webelement from login page
	 * */
	public static WebElement getLoginBtn() {
		return loginBtn;
	}

}