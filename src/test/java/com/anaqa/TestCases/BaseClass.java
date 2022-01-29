package com.anaqa.TestCases;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.anaqa.Utilities.ReadConfig;

public class BaseClass {
	
 ReadConfig readConfig= new ReadConfig();
	
	public static WebDriver driver;
	public String baseurl= readConfig.getApplicationURL();
	public String username= readConfig.getUsername();
	public String password= readConfig.getPassword();
	public static Logger logger;

    @Parameters("browser")
	@BeforeTest
	
	public void setUp(String br) {
		
	logger=Logger.getLogger("AnaqaTest");
	PropertyConfigurator.configure("Log4j.properties");
	
	//WebDriverManager.chromedriver.setup();
	ChromeOptions chromeoption=new ChromeOptions();
	chromeoption.addArguments("headless");
	
	chromeoption.addArguments("window-size=1980,1080");
	
		if(br.equals("chrome")) {
	System.setProperty("webdriver.chrome.driver",readConfig.getChromepath());
		driver=new ChromeDriver(chromeoption);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",readConfig.getFFpath());
				driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				}				
	}
	
	@AfterTest
	public void tearDown() {
		
		driver.quit();
	}
		
	public void captureScreenshot(WebDriver drive,String tname) throws IOException  {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
		
		
		
	}
	
	
	
}
