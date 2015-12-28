package com.ilad.topqteamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MilestonesPageElements extends PageElements {

//	@FindBy(xpath = "//li[@id='tab_tasks']/a")
//	private WebElement tasksTab;
	
	//Constructor
	public MilestonesPageElements(WebDriver driver_) {
		driver = driver_;
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
		By tasksTab = By.id("tab_tasks");
		driver.findElement(tasksTab).click();
		return new TasksPageElements(driver);
	}

}
