package com.ilad.topqteamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class AllProjectsPageElements extends PageElements {

	//Constructor
	public AllProjectsPageElements(AndroidDriver<WebElement> driver_) {
		driver = driver_;
		PageFactory.initElements(driver, this);
	}
	
	public ProjectHomePageElements clickOnWebDriverTrainingButtonAndPassToProjectHomePage() {
		By WebDriverTrainingButton = By.className("android.widget.ImageView");
		clickOnButton(WebDriverTrainingButton);
		return new ProjectHomePageElements(driver);
	}
}
