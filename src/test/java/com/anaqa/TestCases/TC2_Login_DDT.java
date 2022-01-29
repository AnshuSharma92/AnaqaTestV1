package com.anaqa.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.anaqa.PageObjects.LoginPO;
import com.anaqa.Utilities.XLUtils;

public class TC2_Login_DDT extends BaseClass
{

	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwds) throws Exception
	{
		driver.get(baseurl);
		logger.info("URL opened");
		
		LoginPO lp= new LoginPO(driver);
		
		lp.setUsername(user);
		logger.info("Username entered");
		lp.setPassword(pwds);
		logger.info("Password Entered");
		lp.ClickSubmit();
		Thread.sleep(3000);
		
		if(warning(lp)==true)
		{
			driver.navigate();
			Assert.assertTrue(false);
			logger.warn("Invalid Login");
		}
		else {
			logger.info("Successful Login");
			Assert.assertTrue(true);
			
			lp.ClickLogout();
			Thread.sleep(3000);
			lp.ClickLogin();
		}
					
	}
public boolean warning(LoginPO lp) throws Exception {
	
	logger.info("warining check");
	if (lp.getwarningtxt()==true) {
		return true;
	}
	logger.info("Warining false");
	return false;
	
}
			
		
		
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/anaqa/testData/LoginTestDatat.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return logindata;
	}
	
	
	
}
