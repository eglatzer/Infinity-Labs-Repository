package com.ilad.topqteamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class ActiveTasksListPageElements extends PageElements {
	
	//Constructor
	public ActiveTasksListPageElements(AndroidDriver<WebElement> driver_) {
		driver = driver_;
		PageFactory.initElements(driver, this);
	}

	public AddTaskListPageElements clickOnAddTaskListButtonAndPassToAddTaskListPage() {
		By addTaskListButton = By.xpath("//android.widget.TextView[@text='Add Task List']");
		if(findElements(addTaskListButton).isEmpty()) {
			scrollToFindTextualElementAndClickOnIt("Add Task List");
		}
		else {
			clickOnButton(addTaskListButton);
		}
		return new AddTaskListPageElements(driver);
	}
	
	public SpecificTaskListPageElements clickOnSpecificTaskListAndPassToItsPage(String taskListName) {
		By specificTaskListButton = By.xpath
				("//android.widget.TextView[@text='" + taskListName + "']");
		if(findElements(specificTaskListButton).isEmpty()) {
			scrollToFindTextualElementAndClickOnIt(taskListName);
		}
		else {
			clickOnButton(specificTaskListButton);
		}
		return new SpecificTaskListPageElements(driver);
	}
}
