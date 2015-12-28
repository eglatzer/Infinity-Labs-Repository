package com.ilad.topqteamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TasksPageElements extends PageElements {
	
	@FindBy(xpath = "//ul[@class='options']/descendant::span[@class='btn-addIcon']")
	private WebElement addTaskListButton;
		
	//Constructor
	public TasksPageElements(WebDriver driver_) {
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
	
	public NewTaskListModuleElements clickOnAddTaskListButtonAndPassToNewTaskListModule() {
		addTaskListButton.click();
		return new NewTaskListModuleElements(driver);
	}
	
	public SpecificTaskListPageElements clickOnSpecificTaskListAndPassToItsPage(String name) {
		By specificTaskListPage = By.xpath
				("//span[contains(text(), '" + name + "')]");
		driver.findElement(specificTaskListPage).click();
		return new SpecificTaskListPageElements(driver);
	}
	
	public boolean isThisTaskListExist(String name) {
		return !driver.findElements
				(By.xpath("//span[contains(text(), '" + name + "')]")).isEmpty();
	}
}
