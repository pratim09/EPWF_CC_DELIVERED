package TestCases.CreditCard;

import java.util.List;

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
 * *******************************************************************************************
 * This class is implemented to verify that after cancellation saved account should be present
 ********************************************************************************************/
public class NoKeepLinkCC extends ExtendingCC {
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
		BrowserSpecific.driver.findElement(By.xpath("//label[contains(text(),'"+expectedPaymentAccount+"')]//following-sibling::a[text()='Delete']")).click();
		
		try{
			if(CCPaymentInformationPage.getmethodOfPaymentPopUp().isDisplayed()){
				WebElement frame = BrowserSpecific.driver.findElement(By.xpath("(//iframe[@id='DeleteWalletIframe'])[2]"));
				 BrowserSpecific.driver.switchTo().frame(frame);
				Thread.sleep(5000);	
				if(CCPaymentInformationPage.getpopUpNoKeepButton().isDisplayed()){
					JavascriptExecutor executor1 = (JavascriptExecutor)BrowserSpecific.driver;
					executor1.executeScript("arguments[0].click();", CCPaymentInformationPage.getpopUpNoKeepButton());
					CommonMethods.waitTime();
				}else{
					System.out.println("not displayed");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			}
		 BrowserSpecific.driver.switchTo().defaultContent();
		 BrowserSpecific.driver.switchTo().frame("epwfpageId");
		 List<WebElement> paymentAccount = select.getOptions();
		 int count=0;
		   for(int i= 0; i<paymentAccount.size(); i++){
			   if(paymentAccount.get(i).getText().contains(expectedPaymentAccount)){
				  System.out.println("the instrument is not get deleted from the drop down");
				  count++;
				  break;
			   }
			   
		   }
		   Assert.assertEquals(count, 1);
	}
	}	
}