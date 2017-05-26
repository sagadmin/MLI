package claims;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.testng.annotations.Test;

import mli.appmethods.com.CSEMethods;
import mli.appmethods.com.ClaimMethods;
import mli.appmethods.com.GrvMethods;
import mli.appmethods.com.LoginMethod;
import mli.appmethods.com.TicketSearchMethods;
import mli.pom.com.ClaimPage;
public class ClaimModule extends ClaimMethods {
	String caseOwner;
	String CaseId;
	CSEMethods cs = new CSEMethods();
	GrvMethods grv = new GrvMethods();
	
	@Test
	public void NaviagtetoClaim() throws InterruptedException {
		
		
	

//		LoginMethod lg= new LoginMethod() ;
		
		QuickSearchModule qs = new QuickSearchModule();
		
		qs.QuickSearch();
		
		clickClaimLink();

		enterCallerName("Test");
		enterClaimantName("Test");
		enterContactNumber("9856314789");
		click_SSCSearch();
		enterSSCNameforSearch("Claim Status Inquiry");
		selectssc();
		clickSSCNextbtn();
		
		cs.ProblemBox("TEST");
		
		String action ="No";
		IfFCRYes(action);
		if(action.equalsIgnoreCase("Yes")){
			
			
			grv.resolution_comment("resolved");
			grv.SaveAndProceed();
			
			String status=GetStatus();
			String substatus=GetSubStatus();
			assertEquals(substatus, "Closed");
			assertEquals(status, "Closed");
	        CaseId=GetCaseId();
	        assertNotEquals(CaseId, null,"Msg");
		}else{
			
		
			
			
			grv.SaveAndProceed();
			
			String status=GetStatus();
			String substatus=GetSubStatus();
			assertEquals(substatus, "New");
			assertEquals(status, "New");
		    CaseId=GetCaseId();
		    assertNotEquals(CaseId, null,"Msg");
		    
		    caseOwner=ClaimPage.getcaseOwner.getText();
		    
		    driver.close();
			
		}

	
	}
	
	@Test
	public void loginwithbackend() throws InterruptedException{
		
		EnterUserName("ARajesh");
		EnterPassword("acid_qa");
		Login();
		
		TicketSearchMethods	ts = new TicketSearchMethods();
		
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
		grv.SaveAndProceed();
//		grv.resolution_by();
//		assertEquals(actual, "Resolved");
		
	}

}
