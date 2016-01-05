package com.ilad.topqteamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class LoginPageElements extends PageElements {
	
	private By loginButton = By.className("android.widget.Button");
	
	//Constructor
	public LoginPageElements(AndroidDriver<WebElement> driver_) {
		driver = driver_;
		PageFactory.initElements(driver, this);
	}
	
	public void sendKeysToUserNameTextBox(String userName) {
		By userNameTextBox = By.xpath
				("//android.widget.TextView[@text='Email Address or API Key']");
		sendKeysToTextBox(userNameTextBox, userName);
	}

	public void sendKeysToUserPasswordTextBox(String userPassword) {
		By userPasswordTextBox = By.xpath
				("//android.widget.TextView[@text='Password']");
		sendKeysToTextBox(userPasswordTextBox, userPassword);
	}
	
	public AllActivityPageElements clickOnLoginButtonAndPassToAllActivityPage() {
		clickOnButton(loginButton);
		return new AllActivityPageElements(driver);
	}
	
	public void clickOnLoginButtonAndStayAtLoginPage() {
		clickOnButton(loginButton);
	}
}
