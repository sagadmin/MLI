package grv1;

import org.testng.annotations.Test;

import mli.appmethods.com.CSEMethods;
import mli.appmethods.com.ClaimMethods;
public class ClaimModule extends ClaimMethods {

	@Test
	public void NaviagtetoClaim() throws InterruptedException {

		QuickSearchModule qs = new QuickSearchModule();
		
		qs.QuickSearch();
		
		clickClaimLink();

		enterCallerName("Test");
		enterClaimantName("Test");
		enterContactNumber("9856314789");
		click_SSCSearch();
		enterSSCNameforSearch("claim");
		selectssc();
		clickSSCNextbtn();
		IfFCRYes();

		CSEMethods cs = new CSEMethods();
		cs.ProblemBox("TEST");

	}

}
