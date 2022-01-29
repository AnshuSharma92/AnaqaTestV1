package com.anaqa.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;

public class AddToCart {
	
	WebDriver driver;

	public AddToCart(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how = How.XPATH,using ="/html/body/section/section[2]/div/div/div[2]/div[1]/div/nav/div[2]/ul/li[2]/a")
	@CacheLookup
	WebElement Electronics;
	
	@FindBy(how = How.XPATH,using ="/html/body/section/section[2]/div/div/div[2]/div[1]/div/nav/div[2]/ul/li[2]/ul/li[1]/a")
	@CacheLookup
	WebElement AirConditioner;
	
	@FindBy(how = How.XPATH,using ="//*[@id=\"content\"]/div[3]/div/div[1]/div[1]/div/div[2]/h4/a")
	@CacheLookup
	WebElement Product1;
	
	@FindBy(how = How.XPATH ,using ="(//input[@value=\"Add to Cart\"])[1]")
	@CacheLookup
	WebElement btnAddtoCart;
	
	@FindBy(how = How.CLASS_NAME,using ="success")
	@CacheLookup
	WebElement msgsuccess;
	
	@FindBy(how = How.ID, using ="cart")
	@CacheLookup
	WebElement btncart;
	
	@FindBy(how = How.XPATH,using ="//*[@id=\"cart\"]/div[2]/div[3]/a[1]")
	@CacheLookup
	WebElement btnviewcart;
	
	@FindBy(how = How.CLASS_NAME, using ="total")
	@CacheLookup
	WebElement totalprice ;
	
	
	public void HoverElectronics() {
		
		((JavascriptExecutor)driver).executeScript("$('#mainmenutop > div.collapse.navbar-collapse.navbar-ex1-collapse > ul > li:nth-child(2) > a').hover();");


	

	}
	
	
public void ClickAirConditioner() {
		
	AirConditioner.click();
	}
public String getProduct1() {
	
	String txtproduct1=Product1.getText();
	return txtproduct1;
}

public void ClickbtnAddtoCart() {
	
	btnAddtoCart.click();
}
public String getSuccessMsg() {
	
	String successmsg=msgsuccess.getText();
	return successmsg;
}

public void Clickbtncart() {
	
	btncart.click();
}
public void Clickbtnviewcart() {
	
	btnviewcart.click();
	
}

public String gettotalprice() {
	
	String Totalprice= totalprice.getText();
	return Totalprice;
}




	
}
