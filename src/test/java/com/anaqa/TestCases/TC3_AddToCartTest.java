package com.anaqa.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.anaqa.PageObjects.AddToCart;
import com.anaqa.PageObjects.LoginPO;

public class TC3_AddToCartTest extends BaseClass{

	

	@Test
	public void addtocart() throws InterruptedException, IOException {
		driver.get(baseurl);
		logger.info("URL opened");
		
		
		
		LoginPO lp= new LoginPO(driver);
		
		lp.setUsername(username);
		logger.info("Username entered");
		lp.setPassword(password);
		logger.info("Password Entered");
		lp.ClickSubmit();
		logger.info("Logged In");
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		 System.out.println("Perform actions for Add to cart");
		 
		AddToCart ac=new AddToCart(driver);
		
		ac.HoverElectronics();
		logger.info("hovered on Electronic");
		ac.ClickAirConditioner();
		driver.getTitle().equals("Air Conditioner");
		ac.getProduct1().contains("AC");
		ac.ClickbtnAddtoCart();
		ac.getSuccessMsg().contains("Success");
	
		//System.out.println(getSuccessMsg());
		ac.Clickbtncart();
		
		ac.Clickbtnviewcart();
		
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		 boolean Shopcart=driver.getPageSource().contains("Shopping Cart");
		 if(Shopcart==true) {
			 Assert.assertTrue(true);
             logger.info("Successfully Added item in cart");
		 }

	         else {
	        	 captureScreenshot(driver,"addtocart");
	        	 Assert.assertTrue(false);
	        	 logger.info("Test Failed");
	         }
		
	}
	
	
	
	
	
	
	
}
