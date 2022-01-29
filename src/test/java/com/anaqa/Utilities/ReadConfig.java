package com.anaqa.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties Pro;
	
	public  ReadConfig(){
		
		File src=new File("./Configurations/config.properties");
		
		try {
			
			FileInputStream fis=new FileInputStream(src);
			Pro =new Properties();
			Pro.load(fis);	
			
		}
		catch(Exception ex){
			System.out.println("Exception is"+ ex.getMessage());
			
		}
		
	}
	
public String getApplicationURL() {
		
		String url=Pro.getProperty("baseurl");
		return url;
	}

public String getUsername() {
		
		String username=Pro.getProperty("username");
		return username;
	}
	
public String getPassword() {
	
	String password=Pro.getProperty("password");
	return password;
}
	public String getChromepath() {
		String chromepath=Pro.getProperty("chromepath");
		return chromepath;
	}
	public String getFFpath() {
		String firefoxpath=Pro.getProperty("firefoxpath");
		return firefoxpath;
	}
	
	public String safaripath() {
	
		String safaripath=Pro.getProperty("safaripath");
		return safaripath;
		
	}
}
