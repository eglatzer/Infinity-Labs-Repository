package com.ilad.topqteamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpecificTaskListPageElements extends PageElements {
	
	@FindBy(xpath = "//button[@class='btn btn-success js-add-task btn-lg']")
	private WebElement addTheFirstTaskButton;
	
	@FindBy(xpath = "//li/child::button[@class='btn btn-default btn-hasIcon tipped']")
	private WebElement optionsButton;
	
	//Constructor
	public SpecificTaskListPageElements(WebDriver driver_) {
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
	
	public FirstTaskModuleElements clickOnAddTheFirstTaskButtonAndPassToFirstTaskModule() {
		addTheFirstTaskButton.click();
		return new FirstTaskModuleElements(driver);
	}
	
	public int sizeOfThisTaskList() {
		return driver.findElements(By.xpath("//span[@class='taskName']")).size();
	}
	
	public void clickOnOptionsButton() {
		optionsButton.click();
	}
	
/*	public void clickOnDeleteButton() {
		By deleteButton = By.xpath
				("//a[@href='javascript:tw.DeleteTaskList( 477127 , true )']");
		driver.findElement(deleteButton).click();
	}*/
}
