package grv1testSuite;

import org.testng.annotations.Test;

import grv1.GRV1_TS003_Methods;

public class TS003 extends GRV1_TS003_Methods
{
@Test
public void GRV1_TS003() throws InterruptedException
{
	CSEFlow();
	ScrutinyFlow();
	poscfFlow();
	GrvFlow();
}

}
