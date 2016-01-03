package com.ilad.topqteamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class AddTaskListPageElements extends SomeElements {

	//Constructor
	public AddTaskListPageElements(AndroidDriver<WebElement> driver_) {
		driver = driver_;
		PageFactory.initElements(driver, this);
	}
	
	public void sendKeysToTitleTextBox(String title) {
		By titleTextBox = By.xpath("//android.widget.Button[@text='Cancel']");
		sendKeysToTextBox(titleTextBox, title);
	}
	
	public ActiveTasksListPageElements clickOnSaveButtonAndPassToActiveTasksListPage() {
		clickOnSaveButton();
		return new ActiveTasksListPageElements(driver);
	}

}
