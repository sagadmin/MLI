package mli.appmethods.com;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

//import java.util.concurrent.TimeUnit;

import mli.pom.com.ClaimPage;

public class ClaimMethods extends LoginMethod {

	public static void clickSSCNextbtn() {
		ClaimPage.btn_SSCNext.click();
	}

	public static void selectssc() {

		ClaimPage.drpdwn_SelectSSC.click();
	}

	public static void enterCallerName(String name) {
		ClaimPage.EnterCallerName.sendKeys(name);
	}

	public static void enterClaimantName(String cn) {
		ClaimPage.EnterClaimantName.sendKeys(cn);
	}

	public void clickClaimLink() {

		ClaimPage.link_Claim.click();
	}

	public static void click_SSCSearch() {

		ClaimPage.link_ClickSearchSSC.click();
	}
	
	public static void enterSSCNameforSearch(String sscName) throws InterruptedException{
		Thread.sleep(2000);
		ClaimPage.txt_EnterSSC.sendKeys(sscName);
	}
	
	public static void enterContactNumber(String number){
		
		ClaimPage.EnterContactNumber.sendKeys(number);
	}
	
	public static void IfFCRYes(String action){
		Select s = new Select(ClaimPage.IsFCR);
		s.selectByVisibleText(action);	
		
	}
	

//	
//	public static void IfFCRNo(){
//		Select s = new Select(ClaimPage.IsFCR);
//		s.selectByVisibleText("No");
//	}
	
	public static void ProblemBox(){
		ClaimPage.ProblemBox.sendKeys("Hello");
	}
	
	
	public void clickJourneyButton() throws InterruptedException{
		if(driver.findElements(By.xpath(".//*[@id='ui-id-16']")).size()>0) ///Just to close the Pop-up at the time of Policy360 
		{
			
			driver.findElement(By.xpath("html/body/div[3]/div[1]/a/span")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='divmaterialButton']/a/i")).click();
			driver.findElement(By.xpath(".//*[@id='BTN_SCREENFLOW_0']/i")).click();
		}
		else
		{
			driver.findElement(By.xpath(".//*[@id='divmaterialButton']/a/i")).click();
			driver.findElement(By.xpath(".//*[@id='BTN_SCREENFLOW_0']/i")).click();
		}
	}

	public String GetStatus()
	{
		String status= ClaimPage.Status.getText();
		return status;
	}
	
	public String GetSubStatus()
	{
		String substatus= ClaimPage.SubStatus.getText();
		return substatus;
	}
	
	public String GetCaseId()
	{
		String CaseId=ClaimPage.CaseId.getText();
		return CaseId;
	}
}
