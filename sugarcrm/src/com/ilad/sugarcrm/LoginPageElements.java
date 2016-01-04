package com.ilad.sugarcrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageElements extends PageElements {

	@FindBy(id = "user_name")
	private WebElement userNameTextBox;
	
	@FindBy(id = "user_password")
	private WebElement userPasswordTextBox;
	
	@FindBy(id = "login_button")
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
	
	public HomePageElements clickOnLoginButtonAndPassToHomePage() {
		loginButton.click();
		return new HomePageElements(driver);
	}
	
	public void clickOnLoginButtonAndStayAtLoginPage() {
		loginButton.click();
	}
}
