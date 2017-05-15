package grv1;

import org.testng.annotations.Test;

import mli.appmethods.com.ApproverMethods;

public class GRV1_TS0010_Methods extends ApproverMethods
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
		tct_status();
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
//		case1();
		   
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
	   EnterCD("Payment of premium not acted upon or wrongly acted upon");  
	   submenu("Premium allocated towards error account");    
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
	   tct_status();
	}
  
	public void ScrutinyFlow2() throws InterruptedException
	{
	   Logout();
	   EnterUserName("scrutiny");
	   EnterPassword("acid_qa");
	   Login();
	   ticketsearch();
	   edit();
	   ScrutinySection();
	   EnterCD("Not applicable");  
	   submenu("Premium allocated towards error account");
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
	
	public void financeppf() throws InterruptedException
	{
		Logout();
		EnterUserName("financeppf");
		EnterPassword("acid_qa");
		Login();
		ticketsearch();
		edit();
		Forwardee_section();
		Forwardee1_comment("comment by finance PPF dept");
		Forwardee1_decision_picker();
		decision_search_box("Accept");
		SaveAndProceed();
		tct_status();
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
	}
	
	public void Pos() throws InterruptedException
	{
		Logout();
		EnterUserName("pos");
		EnterPassword("acid_qa");
		Login();
		ticketsearch();
		edit();
		Forwardee_section();
		Forwardee2_comment("comment by POS dept");
		Forwardee2_decision_picker();
		decision_search_box("accept");
		SaveAndProceed();
		tct_status();
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
		
	}
	
	public void NonGrvFlow() throws InterruptedException
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
		tct_status();
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
	
	public void approver(String ar) throws InterruptedException
	{
		Logout();
		EnterUserName("approver");
		EnterPassword("acid_qa");
		Login();
		ticketsearch();
		edit();
		Approvercomment("comments by approver");
		Approverdecision(ar);
		SaveAndProceed();
		tct_status();
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
	}

}
