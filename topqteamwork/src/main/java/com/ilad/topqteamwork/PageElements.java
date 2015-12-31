package com.ilad.topqteamwork;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.appium.java_client.android.AndroidDriver;

abstract class PageElements {
	
	protected AndroidDriver<WebElement> driver;
	
	protected void clickOnButton(By button) {
		driver.findElement(button).click();
	}
		
	protected void clickOnButton(WebElement button) {
		button.click();
	}
	
	protected void submitOnButton(By button) {
		driver.findElement(button).submit();
	}
	
	protected void submitOnButton(WebElement button) {
		button.click();
	}
	
	protected void sendKeysToTextBox(By textBox, String keys) {
		driver.findElement(textBox).sendKeys(keys);
	}
		
	protected void sendKeysToTextBox(WebElement textBox, String keys) {
		textBox.sendKeys(keys);
	}
		
	protected void selectInSelectBox(By selectBox, String selection) {
		new Select(driver.findElement(selectBox)).selectByVisibleText(selection);
	}
	
	protected void selectInSelectBox(WebElement selectBox, String selection) {
		new Select(selectBox).selectByVisibleText(selection);
	}
	
	protected void scrollToFindTextualElementAndClickOnIt(String element) {
		driver.scrollTo(element).click();
	}
			
	protected WebElement findElement(By locator) {
		return driver.findElement(locator);
	}
	
	protected WebElement findElementByAccessibilityId(String accessibilityId) {
		return driver.findElementByAccessibilityId(accessibilityId);
	}
		
	protected List<WebElement> findElements(By locator) {
		return driver.findElements(locator);
	}
}
