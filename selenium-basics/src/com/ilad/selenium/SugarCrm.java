package com.ilad.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SugarCrm {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
			"/home/developer/Desktop/chromedriver");
		WebDriver driver = new ChromeDriver();
		final String userName = "admin";
		final String password = "ct,h kvmkhj";
		final String firstName = "Evyatar";
		final String lastName = "Glatzer";
		final String salutation = "Dr.";

		driver.navigate().to("http://localhost/sugar/");
        
		WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("login_button")));
		
		driver.findElement(By.id("user_name")).sendKeys(userName);
		driver.findElement(By.id("user_password")).sendKeys(password);
 		driver.findElement(By.id("login_button")).click();
 		
        wait.until(ExpectedConditions.elementToBeClickable(By.id("grouptab_0")));
        
        driver.findElement(By.id("grouptab_0")).click();
        driver.findElement(By.id("moduleTab_0_Leads")).click();
        
		wait.until(ExpectedConditions.elementToBeClickable
			(By.xpath("//span[contains(.,'Create Lead')]/a")));
        
        driver.findElement(By.xpath("//span[contains(.,'Create Lead')]/a")).
        	click();
        driver.findElement(By.id("first_name")).sendKeys(firstName);
		driver.findElement(By.id("last_name")).sendKeys(lastName);
		
		org.openqa.selenium.support.ui.Select select =
			new org.openqa.selenium.support.ui.Select
			(driver.findElement(By.id("salutation")));
		select.selectByValue(salutation);
		driver.findElement(By.id("alt_checkbox")).click();
		driver.findElement(By.id("SAVE_FOOTER")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable
			(By.id("moduleTab_0_Leads")));
		
		driver.findElement(By.id("moduleTab_0_Leads")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated
			(By.id("search_form_clear")));
		
		driver.findElement(By.id("search_form_clear")).click();
		driver.findElement(By.id("search_name_basic")).sendKeys(lastName);
		driver.findElement(By.id("search_form_submit")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//*[contains(., 'Dr. Evyatar Glatzer')]/a")) != null);
		
		Thread.sleep(5000);
		
		driver.quit();
	}
}
