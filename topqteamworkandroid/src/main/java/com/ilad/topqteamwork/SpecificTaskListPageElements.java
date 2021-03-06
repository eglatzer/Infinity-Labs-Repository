package com.ilad.topqteamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class SpecificTaskListPageElements extends SomeElements {

	//Constructor
	public SpecificTaskListPageElements(AndroidDriver<WebElement> driver_) {
		driver = driver_;
		PageFactory.initElements(driver, this);
	}
	
	public AddTaskPageElements clickOnCreateTheFirstTaskButtonAndPassToAddTaskPage() {
		By createTheFirstTaskButton = By.className("android.widget.Button");
		clickOnButton(createTheFirstTaskButton);
		return new AddTaskPageElements(driver);
	}
	
	public AddTaskPageElements clickOnAddTaskButtonAndPassToAddTaskPage() {
		By addTaskButton = By.xpath("//android.widget.TextView[@text='Add Task']");
		clickOnButton(addTaskButton);
		return new AddTaskPageElements(driver);
	}
	
	public MenuModuleElements clickOnMenuButtonAndPassToMenuModule() {
		clickOnMenuButton();
		return new MenuModuleElements(driver);
	}
	
	public OptionsModuleElements clickOnOptionsButtonAndPassToOptionsModule() {
		clickOnOptionsButton();
		return new OptionsModuleElements(driver);
	}
	
	public int sizeOfSpecificTaskList() {
		By taskIndicator = By.className("android.widget.Button");
		return findElements(taskIndicator).size();
	}
}
