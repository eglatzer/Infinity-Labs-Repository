package com.ilad.sugarcrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateLeadPageElements extends ModuleListElements {

	@FindBy(id = "salutation")
	private WebElement salutationSelectBox;
	
	@FindBy(id = "first_name")
	private WebElement firstNameTextBox;
	
	@FindBy(id = "last_name")
	private WebElement lastNameTextBox;
	
	@FindBy(id = "alt_checkbox")
	private WebElement copyAddressCheckBox;
	
	@FindBy(id = "SAVE_FOOTER")
	private WebElement saveButton;
	
	@FindBy(id = "moduleTab_0_Leads")
	private WebElement leadsTab;
	
	//Constructor
	public CreateLeadPageElements(WebDriver driver_) {
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
	
	public void selectSalutationInSalutationSelectBox(String salutation) {
		Select select = new Select(salutationSelectBox);
		select.selectByValue(salutation);
	}
	
	public void sendKeysToFirstNameTextBox(String firstName) {
		firstNameTextBox.sendKeys(firstName);
	}
	
	public void sendKeysToLastNameTextBox(String lastName) {
		lastNameTextBox.sendKeys(lastName);
	}
	
	public void clickOnCopyAddressCheckBox() {
		copyAddressCheckBox.click();
	}
	
	public LeadDetailsPageElements clickOnSaveButtonAndPassToLeadDetailsPage() {
		saveButton.click();
		return new LeadDetailsPageElements(driver);
	}	
}
