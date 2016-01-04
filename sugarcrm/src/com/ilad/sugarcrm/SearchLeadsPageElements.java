package com.ilad.sugarcrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchLeadsPageElements extends ModuleListElements {
	
	@FindBy(id = "search_name_basic")
	private WebElement searchTextBox;
	
	@FindBy(id = "search_form_submit")
	private WebElement searchButton;
	
	//Constructor
	public SearchLeadsPageElements(WebDriver driver_) {
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
	
	public void sendKeysToSearchTextBox(String searchText) {
		searchTextBox.sendKeys(searchText);
	}

	public void clickOnSearchButton() {
		searchButton.click();
	}
	
	public void clearSearchTextBox() {
		searchTextBox.clear();
	}
	
	public boolean isThisLeadInListView(String lead) {
		return !driver.findElements(By.xpath
				("//table[@class='list view']/descendant::a[contains(text(), '"
				+ lead + "')]")).isEmpty();
	}
}
