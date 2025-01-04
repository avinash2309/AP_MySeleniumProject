package com.store.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {

	Properties properties;

	String path = "C:\\Users\\mravi\\eclipse-workspace\\MyStore\\Configuration\\config.properties";

	public ReadConfig() {

		try {
			properties = new Properties();
			FileInputStream fis = new FileInputStream(path);
			properties.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getBaseUrl() {
		String value = properties.getProperty("baseURL");
		
		if(value!=null) 
			return value;
		else
			throw new RuntimeException("URL is not Specified in Config File.");
	}
	
	public String getBrowser() {
		String value = properties.getProperty("browser");
		if (value!=null)
			return value;
		else
			throw new RuntimeException("Browser is not Specified in Config File.");
	}
}
