package claims;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import mli.appmethods.com.CSEMethods;
import mli.appmethods.com.ClaimMethods;
import mli.appmethods.com.GrvMethods;
//import mli.appmethods.com.LoginMethod;
import mli.appmethods.com.TicketSearchMethods;
import mli.pom.com.ClaimPage;
public class Claim_NGrv extends ClaimMethods {
	String caseOwner;
	String CaseId;
	String AssignedTo;
	String substatus;
	CSEMethods cs = new CSEMethods();
	GrvMethods grv = new GrvMethods();
	
	@Test (priority=0)
	public void NaviagtetoClaim() throws InterruptedException {
		
//		LoginMethod lg= new LoginMethod() ;
		
		QuickSearchModule qs = new QuickSearchModule();
		
		qs.QuickSearch();
		
		clickClaimLink();
		
		enterCallerName("Test");
		enterClaimantName("Test");
		enterContactNumber("9856314789");
		enterSSCNameforSearch("Investigator related complaint");
//		selectSearch();
		claimantEmail();
		clickSSCNextbtn();
		cs.ProblemBox("TEST");
		grv.SaveAndProceed();

	    
	  //For NFCR+Scrutiny Flow
		String status=GetStatus();
		substatus=GetSubStatus();
		assertEquals(substatus, "Assigned to Scrutiny");
		assertEquals(status, "New");
	    CaseId=GetCaseId();
	    assertNotEquals(CaseId, null,"Msg");
	    caseOwner=ClaimPage.getcaseOwner.getText();
	    System.err.println("Case owner is"+" "+caseOwner);
	    
	   //driver.close();
	}
	
	
	@Test (priority=1)
	public void scrutinylogin() throws InterruptedException{
		
		ClaimMethods cm= new ClaimMethods();
		AssignedTo=cm.LoginID(caseOwner, substatus);		
//		System.out.println("Assigned to ="+AssignedTo);
		EnterUserName(AssignedTo);
		EnterPassword("acid_qa");
		Login();
		Thread.sleep(2000);
		claimScrutinyRole();
		TicketSearchMethods	ts = new TicketSearchMethods();
		
		Thread.sleep(3000);
		ts.serviceObject();
		ts.caseitem();
		ts.quicklink();
		ts.ticketsearchicon();
		ts.enterticketno(CaseId);
		ts.fetchcase();
		ts.action();
		ts.case_edit();
		clickScrutinyTab();
		selectCT("Not Applicable");
//		selectCD();
		enterCD("Not Applicable");
//		selectSearch();
		complaintAgainstType();
		RCAType();
		GrvMethods gm= new GrvMethods();
		gm.RCAComment("Comments Entered by scrutiny....");
		IRDAProblemBox("...IRDA Comments Entered By Scrutiny");
		gm.SaveAndProceed();
		
		//Check for Acknowledgement
		
		do
		{
//			String status=GetStatus();
			substatus=GetSubStatus();
			refresh1();
				
//			assertEquals(substatus, "Assign to Grv");//For Grv
			//assertEquals(substatus, "Assigned to Backend");//For Non-Grv
//			assertEquals(status, "Pending");
//		    CaseId=GetCaseId();
		    assertNotEquals(CaseId, null,"Msg");
		    
		    caseOwner=ClaimPage.getcaseOwner.getText();
//		    System.err.println("Case owner is"+" "+caseOwner);
		}while(substatus.equalsIgnoreCase("Assigned to Scrutiny"));
		
		Thread.sleep(2000);
	}

	@Test (priority=2)
	public void backendlogin() throws InterruptedException{
		
		//caseOwner=ClaimPage.getcaseOwner.getText();
		ClaimMethods cm= new ClaimMethods();
		//AssignedTo=ClaimPage.getcaseOwner.getText();
		AssignedTo=cm.LoginID(caseOwner, substatus);
		EnterUserName(AssignedTo);
		EnterPassword("acid_qa");
		Login();

		Thread.sleep(2000);
		claimBackendRole();
		
		TicketSearchMethods	ts = new TicketSearchMethods();
		//GrvMethods gm= new GrvMethods();
		ts.serviceObject();
		ts.caseitem();
		ts.quicklink();
		ts.ticketsearchicon();
		ts.enterticketno(CaseId);
		ts.fetchcase();
		ts.action();
		ts.case_edit();
		cs.ProblemBox("Testing");
		grv.resolution_comment("Resolved");
		
		claimresolutionby();
		grv.SaveAndProceed();
		
		String status=StatusBknd();
		String substatus=SubStatusBknd();
		
		Assert.assertEquals(status, "Resolved");
		Assert.assertEquals(substatus, "Resolved");
        
//		assertEquals(actual, "Resolved");
		
		
		
	}
	
	
	

}
