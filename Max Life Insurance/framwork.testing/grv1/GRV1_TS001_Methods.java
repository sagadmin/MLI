package grv1;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import mli.appmethods.com.ContractSearchMethods;
import mli.appmethods.com.GrvMethods;

public class GRV1_TS001_Methods extends GrvMethods {
	ContractSearchMethods cs = new ContractSearchMethods();
	@Test (enabled=false)
	public void Login_Method() throws InterruptedException 
	{
		EnterUserName("cse");
		EnterPassword("acid_qa");
		Login();
	}

	@Test (enabled=false)
	public void ContractSearch(String ar) throws InterruptedException 
	{
		cs.ContractObject();
		cs.Quicklink();
		cs.PolicyNumberTxt(ar);
		cs.ValidatePolicyNumber();
		cs.CheckboxTick();
		cs.Validate();
	}
	String caseId=null;
	String assignedTo=null;
	
	@Test (enabled=false)
	public void CSEFlow() throws InterruptedException 
	{
		EnterUserName("cse");
		EnterPassword("acid_qa");
		Login();
//		ContractSearch("100472893");
		ClickOnPolicy();
		returnflag();
		BeginJourney();
		SwitchToChildWindow();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		EnterCallerType("Customer");
		EnterCallerName("kajali");
		ProblemBox("cse problem box");
		SSC("POS Request Delay / Error");
		Next();
		alertHandling();
		SaveAndProceed();
		Thread.sleep(800);
		caseId= CaseId();
		System.out.println(caseId);
		assignedTo=assignedTo();
		System.out.println(assignedTo);
	}
	
	/* Written By : Kajali Agrawal
	 * Written On : 21 Apr'17
	  */
	
	public void ticketsearch() throws InterruptedException
	{
		   quicklink();
		   ticketsearchicon();
		   ticketnumpicker();
		   tctSearchWindowHandling();
		   ticketnumtxt(caseId);
		   searchedcase();
		   fetchcase();
		   action();
	}
	
	public void ScrutinyFlow() throws InterruptedException
	{
	   Logout();
	   EnterUserName("scrutiny");
	   EnterPassword("acid_qa");
	   Login();
	   ticketsearch();
	   edit();
	   ScrutinySection();
	   EnterCD("Non-receipt of Duplicate policy");   // OR : Request for Servicing Branch transfer is not effected
	   RCAType("ECS Issue");
	   RCAComment("commnts by scrutiny....");
	   SaveAndProceed();
	   for(int i=0;i<3;i++)
	   {
		   try
		   {
			   assignedTo=assignedTo();  
			   break;
		   }
		   catch(Exception e)
		   {
			   System.out.println("entered catch");
		   }
		   
	   }
	   System.out.println("Assignee is "+" "+assignedTo);
	   while(assignedTo.equalsIgnoreCase("scrutiny"))
	   {
		 refresh();
		 Thread.sleep(3000);
		 assignedTo=assignedTo();
	   }
	   System.out.println(assignedTo);
	}
	
	public void GrvFlow() throws InterruptedException
	{
		Logout();
		EnterUserName("grv");
		EnterPassword("acid_qa");
		Login();
		ticketsearch();
		edit();
		ownerSection();
		resolution_ud();
		resolution_by();
		is_forwarding();
		acceptance_status();
		resolution_comment("resolution comment by grv");
		SaveAndProceed();
	}
	
	
	/* Written By : Kajali Agrawal
	 * Written On : 24 Apr'17
	  */
}

