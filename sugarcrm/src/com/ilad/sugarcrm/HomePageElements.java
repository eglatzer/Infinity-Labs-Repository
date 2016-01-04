package com.ilad.sugarcrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageElements extends ModuleListElements {
	
	@FindBy(id = "moduleTab_0_Leads")
	private WebElement leadsTab;
	
	@FindBy(xpath = "//span[contains(.,'Create Lead')]/a")
	private WebElement createLeadButton;
		
	//Constructor
	public HomePageElements(WebDriver driver_) {
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
	
	public void clickOnLeadsTab() {
		leadsTab.click();
	}
	
	public CreateLeadPageElements clickOnCreateLeadButtonAndPassToCreateLeadPage() {
		By createLeadButton = By.xpath("//span[contains(.,'Create Lead')]/a");
		driver.findElement(createLeadButton).click();
		return new CreateLeadPageElements(driver);
	}
}
