package com.ilad.topqteamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class SpecificTaskListPageElements extends PageElements {

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
		By menuButton = By.className("android.widget.ImageButton");
		clickOnButton(menuButton);
		return new MenuModuleElements(driver);
	}
	
	public OptionsModuleElements clickOnOptionsButtonAndPassToOptionsModule() {
		By optionsButton = By.className("android.widget.ImageView");
		clickOnButton(optionsButton);
		return new OptionsModuleElements(driver);
	}
	
	public int sizeOfSpecificTaskList() {
		By taskIndicator = By.className("android.widget.Button");
		return findElements(taskIndicator).size();
	}
}
