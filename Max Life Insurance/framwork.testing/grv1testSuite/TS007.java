package grv1testSuite;

import org.testng.annotations.Test;

import grv1.GRV1_TS007_Methods;

public class TS007 extends GRV1_TS007_Methods
{
	@Test

	public void GRV1_TS007 () throws InterruptedException
	{
		    CSEFlow();
			ScrutinyFlow();
			ITFlow();
			Financeppf();
			NonGrvFlow();
	}
}
