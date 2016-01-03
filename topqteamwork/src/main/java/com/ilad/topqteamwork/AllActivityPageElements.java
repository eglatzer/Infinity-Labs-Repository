package com.ilad.topqteamwork;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class AllActivityPageElements extends SomeElements {
	
	//Constructor
	public AllActivityPageElements(AndroidDriver<WebElement> driver_) {
		driver = driver_;
		PageFactory.initElements(driver, this);
	}
	
	public MenuModuleElements clickOnMenuButtonAndPassToMenuModule() {
		clickOnMenuButton();
		return new MenuModuleElements(driver);
	}
}
