package com.mystore.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties properties;
	String path="D:\\AvinashSelenium\\MyStoreV1\\Configuration\\config.properties";
	
	public ReadConfig()
	{
		
		try {
			properties=new Properties();
			FileInputStream fis=new FileInputStream(path);
			properties.load(fis);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		
	}
	
	public String getBaseUrl()
	{
		String value=properties.getProperty("baseUrl");
		if(value!=null)
			return value;
		else 
			throw new RuntimeException("Url not specified in config file."); 			
		
	}
	
	public String getBrowser()
	{
		String value=properties.getProperty("browser");
		if(value!=null)
			return value;
		else 
			throw new RuntimeException("Browser not specified in config file."); 			
		
	}
	
	public String getEmail()
	{
		String value=properties.getProperty("email");
		if(value!=null)
			return value;
		else 
			throw new RuntimeException("Email not specified in config file."); 			
		
	}
	

}
