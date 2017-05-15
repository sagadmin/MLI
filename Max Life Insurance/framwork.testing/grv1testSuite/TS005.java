package grv1testSuite;

import org.testng.annotations.Test;

import grv1.GRV1_TS005_Methods;

public class TS005 extends GRV1_TS005_Methods
{
	@Test()
	public void GRV1_TS005() throws InterruptedException
	{
		CSEFlow();
		ScrutinyFlow();
		posFlow();
		nonGrvFlow();
	}

}
