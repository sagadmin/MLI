package grv1testSuite;

import org.testng.annotations.Test;

import grv1.GRV1_TS006_Methods;

public class TS006 extends GRV1_TS006_Methods
{
	@Test (enabled=false)
 public void GRV1_TS006 () throws InterruptedException
 {
	    CSEFlow();
		ScrutinyFlow();
		ITFlow();
		Financeppf();
		GrvFlow();
 }
	

}
