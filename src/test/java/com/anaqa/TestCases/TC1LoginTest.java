package com.anaqa.TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.anaqa.PageObjects.LoginPO;

public class TC1LoginTest extends BaseClass{

	
	@Test
	public void LoginTest() throws IOException {
		
		driver.get(baseurl);
		logger.info("URL opened");
		
		LoginPO lp= new LoginPO(driver);
		
		lp.setUsername(username);
		logger.info("Username entered");
		lp.setPassword(password);
		logger.info("Password Entered");
		lp.ClickSubmit();
		

		if(driver.getTitle().equals("My Account"))
				{
			Assert.assertTrue(true);
			logger.info("Login test Passed");
		}
		else {
			captureScreenshot(driver,"LoginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
