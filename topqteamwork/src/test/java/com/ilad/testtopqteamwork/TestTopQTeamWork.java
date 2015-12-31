package com.ilad.testtopqteamwork;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ilad.topqteamwork.ActiveTasksListPageElements;
import com.ilad.topqteamwork.AddTaskListPageElements;
import com.ilad.topqteamwork.AddTaskPageElements;
import com.ilad.topqteamwork.AllActivityPageElements;
import com.ilad.topqteamwork.AllProjectsPageElements;
import com.ilad.topqteamwork.ConfirmationFrameElements;
import com.ilad.topqteamwork.LoginPageElements;
import com.ilad.topqteamwork.MenuModuleElements;
import com.ilad.topqteamwork.OptionsModuleElements;
import com.ilad.topqteamwork.ProjectHomePageElements;
import com.ilad.topqteamwork.SpecificTaskListPageElements;

import io.appium.java_client.android.AndroidDriver;

public class TestTopQTeamWork {
	
	private AndroidDriver<WebElement> driver;
	private String taskListName;
	
	@BeforeMethod
	public void setUp() throws Exception {
						
		File app = new File(Configuration.getApkFileName());
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability
				("deviceName", "google Galaxy Nexus - 4.2.2 - API 17 - 720x1280");
		capabilities.setCapability("platformVersion", "4.2.2");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "net.teamworkpm.phone");
		capabilities.setCapability("appActivity", ".ProjectsActivity");
		driver = new AndroidDriver<WebElement>
				(new URL(Configuration.getUrl()), capabilities);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test(description = "Tests the functioning of TopQ Teamwork Application")
	public void test() throws InterruptedException, IOException {
		
		taskListName =
				Configuration.getTaskListName() + System.currentTimeMillis();
		LoginPageElements loginPageElements = new LoginPageElements(driver);
		
		loginPageElements.sendKeysToUserNameTextBox(Configuration.getUserName());
		loginPageElements.sendKeysToUserPasswordTextBox
				(Configuration.getUserPassword());
		
		AllActivityPageElements allActivityPageElements =
				loginPageElements.clickOnLoginButtonAndPassToAllActivityPage();
		
		MenuModuleElements menuModuleElements =
				allActivityPageElements.clickOnMenuButtonAndPassToMenuModule();
		
		AllProjectsPageElements allProjectsPageElements = menuModuleElements.
				clickOnProjectsTabAndPassToAllProjectsPage();
		
		ProjectHomePageElements projectHomePageElements =
				allProjectsPageElements
				.clickOnWebDriverTrainingButtonAndPassToProjectHomePage();
		
		Thread.sleep(5000);
		
		ActiveTasksListPageElements activeTasksPageElements =
				projectHomePageElements.
				clickOnTasksButtonAndPassToActiveTasksPage();
				
		AddTaskListPageElements addTaskListPageElements =
				activeTasksPageElements.
				clickOnAddTaskListButtonAndPassToAddTaskListPage();
		
		addTaskListPageElements.sendKeysToTitleTextBox(taskListName);
		
		activeTasksPageElements = addTaskListPageElements.
				clickOnSaveButtonAndPassToActiveTasksListPage();
		
		SpecificTaskListPageElements specificTaskListPageElements =
				activeTasksPageElements.clickOnSpecificTaskListAndPassToItsPage
				(taskListName);
		
		AddTaskPageElements addTaskPageElements = specificTaskListPageElements.
				clickOnCreateTheFirstTaskButtonAndPassToAddTaskPage();
		
		addTaskPageElements.
				sendKeysToTitleTextBox("" + System.currentTimeMillis());
		
		specificTaskListPageElements = addTaskPageElements.
				clickOnSaveButtonAndPassToSpecificTaskListPage();
		
		Thread.sleep(5000);
		
		addTaskPageElements = specificTaskListPageElements.
				clickOnAddTaskButtonAndPassToAddTaskPage();
		
		addTaskPageElements.
				sendKeysToTitleTextBox("" + System.currentTimeMillis());
		
		specificTaskListPageElements = addTaskPageElements.
				clickOnSaveButtonAndPassToSpecificTaskListPage();
		
		menuModuleElements = specificTaskListPageElements.
				clickOnMenuButtonAndPassToMenuModule();
		
		allProjectsPageElements =
				menuModuleElements.clickOnProjectsTabAndPassToAllProjectsPage();
		
		projectHomePageElements = allProjectsPageElements.
				clickOnWebDriverTrainingButtonAndPassToProjectHomePage();
		
		Thread.sleep(5000);
		
		activeTasksPageElements = projectHomePageElements.
				clickOnTasksButtonAndPassToActiveTasksPage();
		
		specificTaskListPageElements = activeTasksPageElements.
				clickOnSpecificTaskListAndPassToItsPage(taskListName);
		
		Assert.assertEquals
				(specificTaskListPageElements.sizeOfSpecificTaskList(), 2);
		
		OptionsModuleElements optionsModuleElements =
				specificTaskListPageElements.
				clickOnOptionsButtonAndPassToOptionsModule();
		
		ConfirmationFrameElements confirmationFrameElements =
				optionsModuleElements.clickOnDeleteTab();
		
		confirmationFrameElements.clickOnDeleteButton();
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}
}