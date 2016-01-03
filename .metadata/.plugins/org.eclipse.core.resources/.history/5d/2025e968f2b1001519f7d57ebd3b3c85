package com.ilad.topqteamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class AddTaskPageElements extends PageElements {

	//Constructor
	public AddTaskPageElements(AndroidDriver<WebElement> driver_) {
		driver = driver_;
		PageFactory.initElements(driver, this);
	}
	
	public void sendKeysToTitleTextBox(String title) {
		By titleTextBox = By.xpath("//android.widget.EditText"
				+ "[@text='Title accepts #tag or #[big tag]']");
		sendKeysToTextBox(titleTextBox, title);
	}
	
	public SpecificTaskListPageElements clickOnSaveButtonAndPassToSpecificTaskListPage() {
		findElementByAccessibilityId("Save").click();
		return new SpecificTaskListPageElements(driver);
	}
}
