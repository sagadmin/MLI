package mli.pom.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClaimPage extends LoginObjects{

	public ClaimPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
@FindBy(linkText="Claims")
public static WebElement link_Claim;

@FindBy(id="Cas_ex1_38") //Caller Name
public static WebElement EnterCallerName;

@FindBy(id="cas_ex9_60") //Claimant Name
public static WebElement EnterClaimantName;

@FindBy(id="Cas_ex5_38") //Contact Number
public static WebElement EnterContactNumber;

//Select Sub Sub Category

@FindBy(id="SubCategory1imgpick") //Sub Sub Category
public static WebElement link_ClickSearchSSC;

@FindBy(id="TxtSearch") //Enter Sub Sub Category
public static WebElement txt_EnterSSC;

@FindBy(id="iv_0")//Select Sub Sub Category
public static WebElement drpdwn_SelectSSC;

@FindBy(xpath="//i[@class='icon icon-next']") //Click on Next Button
public static WebElement btn_SSCNext;

@FindBy(id="cas_ex10_59")//Is FCR=Yes/No
public static WebElement IsFCR;
 
@FindBy(id="cke_1_contents") //Click on Problem Box
public static WebElement ProblemBox; 

@FindBy(xpath=".//*[@id='collap-on1_2']/div[1]/div[1]/div")
public static WebElement Status;

@FindBy(xpath=".//*[@id='collap-on1_2']/div[1]/div[2]/div")
public static WebElement SubStatus;

@FindBy(xpath=".//*[@id='divContents']/div[1]/div[3]/div[1]/span")
public static WebElement CaseId;


@FindBy(xpath ="//*[@id='collap-on1_1']/div[2]/div[2]/div/a")
public static WebElement getcaseOwner;
}
