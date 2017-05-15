package grv1;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import mli.appmethods.com.PoscfMethods;

public class GRV1_TS005_Methods extends PoscfMethods
{

	String caseId=null;
	String assignedTo2=null;
	
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
		SSC("Premium Posting Error / Ptd Not Moved");
		Next();
		alertHandling();
		SaveAndProceed();
		Thread.sleep(800);
		caseId= CaseId();
		System.out.println(caseId);
		assignedTo2=assignedTo();
		System.out.println(assignedTo2);
		tct_status ();
	}
		
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
	   EnterCD("Not Applicable");  
	   submenu("premium lying unallocated or Premium incorrectly allocated");
	   RCAComment("commnts by scrutiny....");
	   SaveAndProceed();
	   for(int i=0;i<5;i++)
	   {
		   try
		   {
			   assignedTo2=assignedTo();  
			   break;
		   }
		   catch(Exception e)
		   {
			   System.out.println("entered catch");
		   }
		   
	   }
	   System.out.println("Assignee is "+" "+assignedTo2);
	   
	   while(assignedTo2.equalsIgnoreCase("scrutiny"))
	   {
		 refresh();
		 Thread.sleep(3000);
		 assignedTo2=assignedTo();
	   }
	   System.out.println(assignedTo2);
	   tct_status ();
	}
	
	public void nonGrvFlow() throws InterruptedException
	{
		Logout();
		EnterUserName("nongrv");
		EnterPassword("acid_qa");
		Login();
		ticketsearch();
		edit();
		nongrvSection();
		resolution_by();
		is_forwarding();
		acceptance_status();
		resolution_comment("resolution comment by grv");
		SaveAndProceed();
		tct_status ();
	}
	
	
	public void posFlow() throws InterruptedException
	{
		Logout();
		EnterUserName("pos");
		EnterPassword("acid_qa");
		Login();
		ticketsearch();
		edit();
		Forwardee_section();
		Forwardee1_comment("comment by poscf");
		Forwardee1_decision_picker();
		decision_search_box("accept");
		SaveAndProceed();
		assignedTo2=assignedTo();
		System.out.println(assignedTo2);
		tct_status ();
	}
	
	/* Written By : Kajali Agrawal
	 * Written On : 26 Apr'17
	  */

	
}
