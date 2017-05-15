package grv1testSuite;

import org.testng.annotations.Test;

import grv1.GRV1_TS004_Methods;

public class TS004 extends GRV1_TS004_Methods
{
 @Test ()
 public void GRV1_TS004 () throws InterruptedException
 {
	CSEFlow();
	ScrutinyFlow();
	posFlow();
	GrvFlow();
	 
 }
	
}
