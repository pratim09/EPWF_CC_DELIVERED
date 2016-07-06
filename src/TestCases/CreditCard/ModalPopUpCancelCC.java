package TestCases.CreditCard;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import BusinessSpecific.Methods;
import GenericLib.BrowserSpecific;
import GenericLib.CommonMethods;
import GenericLib.ExcelUtils;
import GenericLib.ExtendingCC;
import PageFactory.CCPayByCreditCardPage;
import PageFactory.CCPaymentInformationPage;

/*
 * ****************************************************************************************************************
 * This class is implemented to verify that saved payment option should not be edited after click on cancel button
 ******************************************************************************************************************/
public class ModalPopUpCancelCC extends ExtendingCC {
	@Test
	public static void PopupCancel() throws Exception
	{
		Methods.handleServicePopUp();
		
		 Methods.navigateToPayBill();
		    
		 Methods.navigateToPayCreditCard();
		 
		 
		 String numOfAccToSelect = ExcelUtils.getCellData("TestSheet", 1, 8);
		 String billAmount = ExcelUtils.getCellData("TestSheet", 1, 9);
		 
		 
		 Methods.selectAccount(numOfAccToSelect, billAmount, 1);
		 
		 Methods.authorizeAndProceed();
		 JavascriptExecutor executor = (JavascriptExecutor)BrowserSpecific.driver;
			executor.executeScript("arguments[0].click();",  CCPayByCreditCardPage.getAgreeBtn());
			CommonMethods.waitTillPageLoad();
			BrowserSpecific.driver.switchTo().defaultContent();
			 BrowserSpecific.driver.switchTo().frame("epwfpageId");
		 

		 Select select = new Select(CCPaymentInformationPage.getMethodOfPaymentDrpDwn());
			select.selectByIndex(1);
			String expectedPaymentAccount = select.getFirstSelectedOption().getText();
			if(expectedPaymentAccount.contains("New Credit or Debit Account")){
				System.out.println("No saved payment method found");
			}else{
		 String expectedMessage =BrowserSpecific. driver.findElement(By.xpath("//label[contains(text(),'"+expectedPaymentAccount+"')]")).getText();
		BrowserSpecific.driver.findElement(By.xpath("//label[contains(text(),'"+expectedPaymentAccount+"')]//following-sibling::a[text()='Edit']")).click();
		
		try{
			if(CCPaymentInformationPage.getmethodOfPaymentPopUp().isDisplayed()){
				WebElement frame =BrowserSpecific. driver.findElement(By.xpath("(//iframe[@id='UpdateWalletIframe'])[2]"));
			BrowserSpecific.driver.switchTo().frame(frame);
				Thread.sleep(5000);	
				if(CCPaymentInformationPage.getpopUpNoKeepButton().isDisplayed()){
					JavascriptExecutor executor1 = (JavascriptExecutor)BrowserSpecific.driver;
					executor1.executeScript("arguments[0].click();", CCPaymentInformationPage.getpopUpNoKeepButton());
					CommonMethods.waitTime();
				}else{
					System.out.println("not displayed");
				}
				BrowserSpecific.driver.switchTo().defaultContent();
				Thread.sleep(5000);
				BrowserSpecific.driver.switchTo().frame("epwfpageId");
				String actualMessage = BrowserSpecific.driver.findElement(By.xpath("//label[contains(text(),'"+expectedPaymentAccount+"')]")).getText();
				Assert.assertEquals(actualMessage, expectedMessage, "Values are updated");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
			}
	}
}