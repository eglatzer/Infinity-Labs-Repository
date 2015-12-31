package com.ilad.testtopqteamwork;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
	
	private static Properties properties;
	
	private static Configuration configuration = null;
	
	//Constructor
	private Configuration() {
		properties = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream
					("/home/developer/svn/Proj/src/Java/topqteamwork/src/test/"
				   + "java/com/ilad/testtopqteamwork/config.properties");
			properties.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(null != input) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//Getters
	private static Configuration getInstance() {
		if(null == configuration) {
			configuration = new Configuration();
		}
		return configuration;
	}
	
	public static String getApkFileName() {
		getInstance();
		return properties.getProperty("apkFileName");
	}
	
	public static String getUrl() {
		getInstance();
		return properties.getProperty("url");
	}
	
	public static String getUserName() {
		getInstance();
		return properties.getProperty("userName");
	}
	
	public static String getUserPassword() {
		getInstance();
		return properties.getProperty("userPassword");
	}
	
	public static String getTaskListName() {
		getInstance();
		return properties.getProperty("taskListName");
	}
}
