package mli.appmethods.com;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import mli.pom.com.TicketSearchObjects;

public class TicketSearchMethods extends ScrutinyMethods
{
  public void quicklink()
  {
	  TicketSearchObjects.quicklink.click();
  }
  
  public void ticketsearchicon()
  {
	  TicketSearchObjects.ticketsearch.click();
  }
  
  public void ticketnumpicker()
  {
	  TicketSearchObjects.ticketnumpicker.click();
  }
  
  String Basewindow=null;
  String Childwindow=null;
  String SearchWindow=null;
  public void tctSearchWindowHandling() throws InterruptedException
  {
	  Thread.sleep(2000);
		Set<String> window = driver.getWindowHandles();
		Iterator<String> I1 = window.iterator();
		Basewindow = I1.next();
		System.out.println(Basewindow);
		Childwindow = I1.next();
		System.out.println(Childwindow);
		SearchWindow= I1.next();
		System.out.println(SearchWindow);
		driver.switchTo().window(SearchWindow);
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOf(TicketSearchObjects.ticketnumtxtbox));

  }
  public void ticketnumtxt(String ar)
  {
	  TicketSearchObjects.ticketnumtxtbox.sendKeys(ar);
	  TicketSearchObjects.ticketnumtxtboxarrow.click();
  }
  
  public void searchedcase()
  {
	  String str=TicketSearchObjects.searchedcase.getText();
	  if(str.equalsIgnoreCase("Data does not exist"))
	  {
		  
	  }
	  TicketSearchObjects.searchedcase.click();  
  }	
  
  public void fetchcase()
  {
	  System.out.println(Childwindow);
	  driver.switchTo().window(Childwindow);
	  TicketSearchObjects.fetchcase.click();  
  }	
  
  public void action()
  {
	  TicketSearchObjects.action.click();  
  }	
  
  /*****************************************
	 * 
	 * Written date : 24 april
	 * Written By : Kajali
	 * 
	 *************************************/
  
  public void case1()
  {
	  TicketSearchObjects.case1.click();
  }
  
  public void showall()
  {
	  String ar= TicketSearchObjects.datanot.getText();
	  System.out.println(ar);
	  if(ar.equalsIgnoreCase("Data does not exist"))
	  {
	  TicketSearchObjects.showall.click();
	  }
  }
}
