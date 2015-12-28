package com.ilad.topqteamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FirstTaskModuleElements extends PageElements {
	
	//Constructor
	public FirstTaskModuleElements(WebDriver driver_) {
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
	
	public void sendKeysToTaskNameTextBox(String taskName) {
		By taskNameTextBox = By.xpath("//div[@class='bootstrap-tagsinput']/"
				+ "descendant::input[@placeholder='What needs to be done?']");
		driver.findElement(taskNameTextBox).sendKeys(taskName);
	}
	
	public void selectWhoShouldDoThisInTaskAssignedToUserIdTextBox(String who) {
		By taskAssignedToUserIdTextBox = By.name("taskAssignedToUserId");
		Select select =
				new Select(driver.findElement(taskAssignedToUserIdTextBox));
		select.selectByVisibleText(who);
	}
	
	public void clickOnSaveMyChangesButton() {
		By saveMyChangesButton =
				By.xpath("//div[@class='formFooter']/descendant::input");
		driver.findElement(saveMyChangesButton).click();
	}
	
	public MilestonesPageElements clickOnMilestonesTabAndPassToMilestonesPage() {
		By milestonesTab = By.id("tab_milestones");
		driver.findElement(milestonesTab).click();
		return new MilestonesPageElements(driver);
	}
}
