package com.ilad.topqteamwork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewTaskListModuleElements extends PageElements {
	
	@FindBy(id = "newTaskListName")
	private WebElement newTaskListNameTextBox;
	
	@FindBy(id = "btnCreateTaskList")
	private WebElement addThisTaskListButton;
	
	//Constructor
	public NewTaskListModuleElements(WebDriver driver_) {
		driver = driver_;
		PageFactory.initElements(driver, this);
	}
	
	//Getter
	public WebDriver getDriver() {
		return driver;
	}

	//Setter
	public void setDriver(WebDriver driver_) {
		driver = driver_;
	}
	
	public void sendKeysToNewTaskListNameTextBox(String newTaskListName) {
		newTaskListNameTextBox.sendKeys(newTaskListName);
	}
	
	public TasksPageElements clickOnAddThisTaskListButtonAndPassToTasksPageElements() {
		addThisTaskListButton.click();
		return new TasksPageElements(driver);
	}
	
	
}
