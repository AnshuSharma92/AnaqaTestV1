package com.anaqa.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPO {

	
	//WebDriver ldriver;
	 
	public LoginPO(WebDriver rdriver) {
		
		//ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(id="email")
	@CacheLookup
	WebElement txtusername;
	
	
	@FindBy(id="password")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(id="submit")
	@CacheLookup
	WebElement btnsubmit;
	
	@FindBy(xpath="/html/body/section/section[1]/div/div/div[1]/div[1]/a[2]")
	@CacheLookup
	public
	WebElement btnlogout;
	
	@FindBy(xpath="/html/body/section/section[1]/div/div/div[1]/div[1]/a[1]")
	@CacheLookup
	WebElement btnlogin;
	
	@FindBy(xpath="//*[@class=\"warning\"]")
	@CacheLookup
	WebElement txtwarning;
	
	
	public void setUsername(String uname) {
		
		txtusername.sendKeys(uname);
	}
	
    public void setPassword(String pwd) {
		
    	txtpassword.sendKeys(pwd);
	}

    public void ClickSubmit() {
	
    	btnsubmit.click();
    	
}
    
    
	public void ClickLogout() {
		
		btnlogout.click();
	}
	
	
	public void ClickLogin() {
		
		btnlogin.click();
	}
	
	public boolean getwarningtxt() throws Exception {
		
		try {
		String waringtxt=txtwarning.getText();
		if(waringtxt.contains("Warning")) {
			return true;
		}
		return false;
		}
		catch(Exception e) {
			return false;
			
		}

	}
	
	
}
