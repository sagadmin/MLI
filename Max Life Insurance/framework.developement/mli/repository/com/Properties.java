package mli.repository.com;

import mli.appmethods.com.ContractSearchMethods;

public interface Properties 
{
    
	String ChromeDriverPath_kajali= "C:\\Users\\Kajali Agrawal\\Desktop\\chromedriver.exe"; 
	String ChromeDriverPath_manish="D:\\New folder\\chromedriver.exe";
	String ChromeDriverPath_darshan= "C:\\Users\\deepak\\Desktop\\chromedriver.exe";
	String ChromeWebDriver = "webdriver.chrome.driver";
	String FirefoxDriverPath="";
    String MaxSAURL= "http://maxunosa/sn/app/login/login";
    String MaxQAURL= "http://maxqa/sn/app/login/login";
    
    ContractSearchMethods cs = new ContractSearchMethods();
	
}
