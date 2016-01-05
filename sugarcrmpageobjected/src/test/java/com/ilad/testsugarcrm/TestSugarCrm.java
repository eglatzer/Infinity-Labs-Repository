package com.ilad.testsugarcrm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ilad.sugarcrm.CreateLeadPageElements;
import com.ilad.sugarcrm.HomePageElements;
import com.ilad.sugarcrm.LeadDetailsPageElements;
import com.ilad.sugarcrm.LoginPageElements;
import com.ilad.sugarcrm.SearchLeadsPageElements;

public class TestSugarCrm {

	private WebDriver driver;
	private String userName;
	private String password;
	private String salutation;
	private String firstName;
	private String lastName;
	private String fullName;

	@BeforeMethod
	public void setDriver() {
		System.setProperty("webdriver.chrome.driver",
				"/home/developer/Desktop/chromedriver");
		driver = new ChromeDriver();
		userName = "admin";
		password = "ct,h kvmkhj";
		salutation = "Prof.";
		firstName = "Albus";
		lastName = "Dumbledore";
		fullName = salutation + " " + firstName + " " + lastName;

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://localhost/sugar/");
	}

	@AfterMethod
	public void quitDriver() {
		driver.quit();
	}

	@Test(description = "Tests the functioning of SugarCrm Website")
	public void test() {
		LoginPageElements loginPage = new LoginPageElements(driver);

		loginPage.sendKeysToUserNameTextBox(userName);
		loginPage.sendKeysToUserPasswordTextBox(password);

		HomePageElements homePage =
				loginPage.clickOnLoginButtonAndPassToHomePage();

		homePage.clickOnSalesTab();
		homePage.clickOnLeadsTab();

		CreateLeadPageElements createLeadPage =
				homePage.clickOnCreateLeadButtonAndPassToCreateLeadPage();

		createLeadPage.selectSalutationInSalutationSelectBox(salutation);
		createLeadPage.sendKeysToFirstNameTextBox(firstName);
		createLeadPage.sendKeysToLastNameTextBox(lastName);
		createLeadPage.clickOnCopyAddressCheckBox();
		
		LeadDetailsPageElements leadDetailsPage =
				createLeadPage.clickOnSaveButtonAndPassToLeadDetailsPage();

		SearchLeadsPageElements searchLeadsPage =
				leadDetailsPage.clickOnLeadsTabAndPassToSearchLeadsPage();
		
		searchLeadsPage.clearSearchTextBox();
		searchLeadsPage.sendKeysToSearchTextBox(lastName);
		searchLeadsPage.clickOnSearchButton();
		
		Assert.assertTrue(searchLeadsPage.isThisLeadInListView(fullName));
	}
}
