package com.ilad.topqteamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class ProjectHomePageElements extends PageElements {

	//Constructor
	public ProjectHomePageElements(AndroidDriver<WebElement> driver_) {
		driver = driver_;
		PageFactory.initElements(driver, this);
	}

	public ActiveTasksListPageElements clickOnTasksButtonAndPassToActiveTasksPage() {
		By tasksButton = By.xpath("//android.widget.TextView[@text='Tasks']");
		clickOnButton(tasksButton);
		return new ActiveTasksListPageElements(driver);
	}
}
