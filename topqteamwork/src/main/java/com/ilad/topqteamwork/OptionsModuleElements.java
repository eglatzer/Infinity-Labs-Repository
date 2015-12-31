package com.ilad.topqteamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class OptionsModuleElements extends PageElements {

	//Constructor
	public OptionsModuleElements(AndroidDriver<WebElement> driver_) {
		driver = driver_;
		PageFactory.initElements(driver, this);
	}

	public ConfirmationFrameElements clickOnDeleteTab() {
		By deleteTab = By.xpath("//android.widget.TextView[@text='Delete']");
		clickOnButton(deleteTab);
		return new ConfirmationFrameElements(driver);
	}
}
