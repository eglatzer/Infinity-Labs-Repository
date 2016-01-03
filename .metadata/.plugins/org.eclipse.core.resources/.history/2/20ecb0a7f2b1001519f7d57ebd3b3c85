package com.ilad.topqteamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class AllActivityPageElements extends PageElements {
	
	//Constructor
	public AllActivityPageElements(AndroidDriver<WebElement> driver_) {
		driver = driver_;
		PageFactory.initElements(driver, this);
	}
	
	public MenuModuleElements clickOnMenuButtonAndPassToMenuModule() {
		By menuButton = By.className("android.widget.ImageButton");
		clickOnButton(menuButton);
		return new MenuModuleElements(driver);
	}
}
