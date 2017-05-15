package grv1testSuite;

import grv1.GRV1_TS002_Methods;

import org.testng.annotations.Test;

public class TS002 extends GRV1_TS002_Methods
{
@Test
public void GRV1_TS002() throws InterruptedException
{
	CSEFlow();
	ScrutinyFlow();
	nonGrvFlow();
}
	
}
