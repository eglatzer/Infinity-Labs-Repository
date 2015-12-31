package com.ilad.topqteamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class MenuModuleElements extends PageElements {

	//Constructor
	public MenuModuleElements(AndroidDriver<WebElement> driver_) {
		driver = driver_;
		PageFactory.initElements(driver, this);
	}
	
	public AllProjectsPageElements clickOnProjectsTabAndPassToAllProjectsPage() {
		By projectsTab = By.xpath("//android.widget.TextView[@text='Projects']");
		clickOnButton(projectsTab);
		return new AllProjectsPageElements(driver);
	}	
}
