package grv1;

import org.testng.annotations.Test;

import mli.appmethods.com.PoscfMethods;

public class GRV1_TS004_Methods extends PoscfMethods
{
	String caseId=null;
	String assignedTo1=null;
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
		assignedTo1=assignedTo();
		System.out.println(assignedTo1);
	}
	
	public void ticketsearch() throws InterruptedException
	{
		   quicklink();
		   ticketsearchicon();
		   ticketnumpicker();
		   tctSearchWindowHandling();
		   ticketnumtxt(caseId);
		   showall();
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
	   EnterCD("Payment of premium not acted upon or wrongly acted upon");  //or : Policy conversion option not effected ,  Reinstatement denied
	   submenu("premium lying unallocated"); // or Premium incorrectly allocated
	   RCAComment("commnts by scrutiny...."); 
	   SaveAndProceed();
	   for(int i=0;i<3;i++)
	   {
		   try
		   {
			   assignedTo1=assignedTo();  
			   break;
		   }
		   catch(Exception e)
		   {
			   System.out.println("entered catch");
		   }
		   
	   }
	   System.out.println("Assignee is "+" "+assignedTo1);
	   while(assignedTo1.equalsIgnoreCase("scrutiny"))
	   {
		 refresh();
		 Thread.sleep(3000);
		 assignedTo1=assignedTo();
	   }
	   System.out.println(assignedTo1);
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
		assignedTo1=assignedTo();
		System.out.println(assignedTo1);
	}
	
	
	/* Written By : Kajali Agrawal
	 * Written On : 25 Apr'17
	  */

}
