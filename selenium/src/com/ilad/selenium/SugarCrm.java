package com.ilad.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class SugarCrm {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		final String firstName = "Evyatar";
		final String lastName = "Glatzer";
		final String userName = "eglatzer";
		final String password = "dmhdmh";

		driver.get("localhost:8080");
        
		Thread.sleep(3000);
        
		driver.findElement(By.className("btn-link")).click();
 		
		Thread.sleep(3000);
		
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		driver.findElement(By.name("lastName")).sendKeys(lastName);
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);

		Thread.sleep(3000);
		
		driver.findElement(By.className("btn-primary")).click();

		Thread.sleep(3000);
		
		Assert.assertTrue(driver.findElement(By.className("alert-success")).getText().equals("Registration successful"));
				
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		
		Thread.sleep(3000);
		
		driver.findElement(By.className("btn-primary")).click();
				
		Thread.sleep(3000);
		
		Assert.assertTrue(driver.findElement(By.cssSelector("p.ng-scope")).getText().equals("You're logged in!!"));
		
		driver.findElement(By.xpath("//*[contains(., 'eglatzer')]/a")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.className("btn-primary")).click();
		
		Thread.sleep(3000);
		
		Assert.assertTrue(driver.getCurrentUrl().equals("http://localhost:8080/#/login"));
				
		driver.quit();
	}
}
