package com.ilad.sugarcrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadDetailsPageElements extends ModuleListElements {
	
	@FindBy(id = "moduleTab_0_Leads")
	private WebElement leadsTab;
	
	//Constructor
	public LeadDetailsPageElements(WebDriver driver_) {
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
	
	public SearchLeadsPageElements clickOnLeadsTabAndPassToSearchLeadsPage() {
		leadsTab.click();
		return new SearchLeadsPageElements(driver);
	}
}
