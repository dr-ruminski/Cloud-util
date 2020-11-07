package com.dr.cloud.manager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertiesUtil {

	private final Properties prop;
	
	/* keyword ensures that multiple threads handle instance correctly */
	private volatile static PropertiesUtil instance;

	private PropertiesUtil() {
		prop = new Properties();
		loadProperties();
	}
	
	private void loadProperties() {
		InputStream input = PropertiesUtil.class.getClassLoader().getResourceAsStream("config.properties");

		// load a properties file from class path
		try {
			prop.load(input);
		} catch (IOException e) {
			System.err.println("Unable to find config.properties within classpath");
			e.printStackTrace();
		}
	}
	
	public String getGceSdkPath() {
		return prop.getProperty("google-cloud-sdk.path");
	}	
	
	public static PropertiesUtil getInstance() {
		if (instance == null)
			synchronized (PropertiesUtil.class) {
				instance = new PropertiesUtil();
			}
			
		return instance;
	}
}
