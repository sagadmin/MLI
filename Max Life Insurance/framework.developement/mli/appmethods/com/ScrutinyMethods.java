package mli.appmethods.com;

import org.openqa.selenium.Keys;

import mli.pom.com.ScrutinyObjects;

public abstract class ScrutinyMethods extends CSEMethods
{
 
	public void ScrutinySection()
	{
		ScrutinyObjects.link_ScrutinySection.click();

	}
		
	public void EnterCD(String ar) throws InterruptedException
	{
		ScrutinyObjects.txt_CD.sendKeys(ar);
		Thread.sleep(600);
		ScrutinyObjects.txt_CD.sendKeys(Keys.DOWN,Keys.ENTER);

	}
	
	public void RCAType(String ar) throws InterruptedException
	{
		ScrutinyObjects.txt_RCAType.sendKeys(ar);
		Thread.sleep(600);
		ScrutinyObjects.txt_RCAType.sendKeys(Keys.DOWN,Keys.ENTER);
		
	}
	
	public void RCAComment(String ar)
	{
	ScrutinyObjects.txt_RCAComment.sendKeys(ar);
	}
	
	public void edit()
	{
	ScrutinyObjects.btn_edit.click();
	}
	
	public void refresh()
	{
		driver.navigate().refresh();
	}
	
    public void submenu(String submenu) throws InterruptedException
    {
    ScrutinyObjects.txt_submenu.sendKeys(submenu);
    Thread.sleep(1000);
    ScrutinyObjects.txt_submenu.sendKeys(Keys.DOWN,Keys.ENTER);
    }
	
}
