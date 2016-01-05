package com.ilad.sugarcrm;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

abstract class ModuleListElements extends PageElements {
	
	@FindBy(id = "grouptab_0")
	protected WebElement salesTab;
	
	@FindBy(xpath = "//*[contains(., Marketing)]/a")
	protected WebElement marketingTab;
	
	@FindBy(xpath = "//*[contains(., Support)]/a")
	protected WebElement supportTab;
	
	@FindBy(xpath = "//*[contains(., Activities)]/a")
	protected WebElement activitiesTab;
	
	@FindBy(xpath = "//*[contains(., Collaboration)]/a")
	protected WebElement collaborationTab;
	
	@FindBy(xpath = "//*[contains(., All)]/a")
	protected WebElement allTab;
	
	private void clickOnSomeTab(WebElement someTab) {
		someTab.click();
	}
	
	public void clickOnSalesTab() {
		clickOnSomeTab(salesTab);
	}
	
	public void clickOnMarketingTab() {
		clickOnSomeTab(marketingTab);
	}
	
	public void clickOnSupportTab() {
		clickOnSomeTab(supportTab);
	}
	
	public void clickOnActivitiesTab() {
		clickOnSomeTab(activitiesTab);
	}
	
	public void clickOnCollaborationTab() {
		clickOnSomeTab(collaborationTab);
	}
	
	public void clickOnAllTab() {
		clickOnSomeTab(allTab);
	}
}
