package TestCases.CreditCard;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import BusinessSpecific.Methods;
import GenericLib.BrowserSpecific;
import GenericLib.CommonMethods;
import GenericLib.CommonValues;
import GenericLib.ExcelUtils;
import GenericLib.ExtendingCC;
import PageFactory.CCPayByCreditCardPage;
import PageFactory.CCPaymentInformationPage;
import PageFactory.CCVerifyInfo;

/*
 * *******************************************************************************************
 * This class is implemented to verify that the payment should be populated in the method of payment dropdown after
 * saving the payment successfully.
 ********************************************************************************************/
public class VerifyPaymentWithSaveCheckCC extends ExtendingCC  {
@Test
public static void VerifyPaymentWithSave(XmlTest myxml)throws Exception
{
	
	Methods.handleServicePopUp();
	
	 Methods.navigateToPayBill();
	    
	 Methods.navigateToPayCreditCard();
	 
	 String numOfAccToSelect = ExcelUtils.getCellData("TestSheet", 1, 8);
	 String billAmount = ExcelUtils.getCellData("TestSheet", 1, 9);
	 
	 Methods.selectAccount(numOfAccToSelect, billAmount, 1);
	 
	 Methods.authorizeAndProceed();
	 
	 CCPayByCreditCardPage.getAgreeBtn().click();
	 CommonMethods.waitTillPageLoad();
	 BrowserSpecific.driver.switchTo().defaultContent();
	 BrowserSpecific.driver.switchTo().frame("epwfpageId");
	 String cardNumber = ExcelUtils.getCellData("TestSheet", 1, 10);
	 String zipCode = ExcelUtils.getCellData("TestSheet", 1, 14);
	  Select select = new Select(CCPaymentInformationPage.getMethodOfPaymentDrpDwn());
	  select.selectByVisibleText(CommonValues.crdDbtPymt);

	 CCPaymentInformationPage.Creditcardno().sendKeys(cardNumber);
	    
	    Select mnthDrpdwn=new Select(CCPaymentInformationPage.monthDropdown());
	    mnthDrpdwn.selectByIndex(2);
	    Select yearDrpdwn=new Select(CCPaymentInformationPage.yearDropdown());
	    yearDrpdwn.selectByIndex(4);
	    CCPaymentInformationPage.zipcodetxt().sendKeys(zipCode);
	    
	    CCPaymentInformationPage.getagreeCheckbox().click();
	    
	    CCPaymentInformationPage.getSavePaymentMethodChkbox().click();
	    
	    CommonMethods.WaitForElement(CCPaymentInformationPage.getNextBtn());
	    CCPaymentInformationPage.getNextBtn().click();
	 
	 CCVerifyInfo.getSubmitPaymentBtn().submit();
	 
	 BrowserSpecific.driver.close();
	 

	 	//2ND TIME NAVIGATION START..
	 
	 ExtendingCC.beforeMethod(myxml.getParameter("browser"));
	
	
		  /*String browserName = ExcelUtils.getCellData("TestSheet", 1, 3);
		  String controlCentreUrlStr = ExcelUtils.getCellData("TestSheet", 1, 4);
		  BrowserSpecific.navigateToURL(browserName, controlCentreUrlStr);
		  
		  //initiate the pageFactory
		  BrowserSpecific.initiatePageFactory();
		  
		  //Login
		  String userName = ExcelUtils.getCellData("TestSheet", 1, 5);
		  String password = ExcelUtils.getCellData("TestSheet", 1, 6);
		  CommonMethods.login(userName,password);
		  */
		  Methods.navigateToPayBill();
		    
			 Methods.navigateToPayCreditCard();
			 
			 
			  numOfAccToSelect = ExcelUtils.getCellData("TestSheet", 1, 8);
			  billAmount = ExcelUtils.getCellData("TestSheet", 1, 9);
			 float mobbillAmount=(float) (Float.parseFloat(billAmount)+0.01);
			 billAmount= String.format("%.2f", mobbillAmount);
			 
			 
			 
			Methods.selectAccount(numOfAccToSelect, billAmount, 1);
			 
			 Methods.authorizeAndProceed();
			 
			 CCPayByCreditCardPage.getAgreeBtn().click();
			 
			  cardNumber = ExcelUtils.getCellData("TestSheet", 1, 10);
			 
			  String expectedCardno="Visa ending****"+cardNumber.substring(12, 16);
			 
			  int count1=0;
			  BrowserSpecific.driver.switchTo().parentFrame();
			  BrowserSpecific.driver.switchTo().frame("epwfpageId");
			  Select select1 = new Select(CCPaymentInformationPage.getMethodOfPaymentDrpDwn());
			  List<WebElement> dropdownlist = select1.getOptions();
				for(int k=0;k<dropdownlist.size();k++)
				{
					System.out.println(dropdownlist.get(k).getText());
					if(dropdownlist.get(k).getText().equals(expectedCardno))
					{
						count1++;
					}
				}
			  
			Assert.assertEquals( count1,1);
			
			}
		
	}