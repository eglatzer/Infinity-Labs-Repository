package com.ilad.topqteamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class ConfirmationFrameElements extends PageElements {

	//Constructor
	public ConfirmationFrameElements(AndroidDriver<WebElement> driver_) {
		driver = driver_;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnDeleteButton() {
		By deleteButton = By.xpath("//android.widget.Button[@text='Delete']");
		clickOnButton(deleteButton);
	}
}
