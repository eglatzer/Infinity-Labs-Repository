package com.ilad.topqteamwork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageElements extends PageElements {

	@FindBy(id = "userLogin")
	private WebElement userNameTextBox;
	
	@FindBy(id = "password")
	private WebElement userPasswordTextBox;
	
	@FindBy(id = "ordLoginSubmitBtn")
	private WebElement loginButton;
	
	//Constructor
	public LoginPageElements(WebDriver driver_) {
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

	public void sendKeysToUserNameTextBox(String userName) {
		userNameTextBox.sendKeys(userName);
	}

	public void sendKeysToUserPasswordTextBox(String userPassword) {
		userPasswordTextBox.sendKeys(userPassword);
	}
	
	public OverviewPageElements clickOnLoginButtonAndPassToOverviewPage() {
		loginButton.click();
		return new OverviewPageElements(driver);
	}
	
	public void clickOnLoginButtonAndStayAtLoginPage() {
		loginButton.click();
	}
}
