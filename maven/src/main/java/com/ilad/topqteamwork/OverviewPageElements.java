package com.ilad.topqteamwork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPageElements extends PageElements {
		
	@FindBy(id = "tab_tasks")
	protected WebElement tasksTab;
	
	//Constructor
	public OverviewPageElements(WebDriver driver_) {
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
	
	public TasksPageElements clickOnTasksTabAndPassToTasksPage() {
		tasksTab.click();
		return new TasksPageElements(driver);
	}
}
