package com.ilad.topqteamwork;

import org.openqa.selenium.By;

abstract class SomeElements extends PageElements {

	protected By menuButton = By.className("android.widget.ImageButton");
	protected By optionsButton = By.className("android.widget.ImageView");
	protected By saveButton = By.xpath("//android.widget.TextView[@text='Save']");
	
	protected void clickOnMenuButton() {
		clickOnButton(menuButton);
	}
	
	protected void clickOnOptionsButton() {
		clickOnButton(optionsButton);
	}
	
	protected void clickOnSaveButton() {
		clickOnButton(saveButton);
	}
}
