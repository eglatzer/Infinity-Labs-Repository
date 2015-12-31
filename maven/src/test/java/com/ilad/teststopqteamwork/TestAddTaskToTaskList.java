package com.ilad.teststopqteamwork;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ilad.topqteamwork.OverviewPageElements;
import com.ilad.topqteamwork.SetConfiguration;
import com.ilad.topqteamwork.SpecificTaskListPageElements;
import com.ilad.topqteamwork.ActionBot;
import com.ilad.topqteamwork.FirstTaskModuleElements;
import com.ilad.topqteamwork.LoginPageElements;
import com.ilad.topqteamwork.MilestonesPageElements;
import com.ilad.topqteamwork.NewTaskListModuleElements;
import com.ilad.topqteamwork.TasksPageElements;
import com.ilad.topqteamwork.WebDriverFactory;
import com.ilad.topqteamwork.WebDriverFactory.KindOfWebDriver;

public class TestAddTaskToTaskList {

	private WebDriver driver;
	private ActionBot actionBot;
	private SetConfiguration config = new SetConfiguration();
	private String userName;
	private String userPassword;
	private String who;
	private String taskListName;
		
	@BeforeMethod
	public void setDriver() {
		driver = new WebDriverFactory(KindOfWebDriver.FIREFOX).getDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(config.getUrl());
		actionBot = new ActionBot(driver);
		userName = config.getUsername();
		userPassword = config.getUserPassword();
		taskListName = config.getTaskListName() + System.currentTimeMillis();
		who = config.getWho();
	}
	
	@AfterMethod
	public void quitDriver() {
		driver.quit();
	}
	
	@Test(description = "Tests the functioning of TopQ Teamwork Website")
	public void test() throws InterruptedException {
		LoginPageElements loginPage = new LoginPageElements(driver, actionBot);
		
		loginPage.sendKeysToUserNameTextBox(userName);
		loginPage.sendKeysToUserPasswordTextBox(userPassword);
		
		OverviewPageElements overviewPage =
				loginPage.clickOnLoginButtonAndPassToOverviewPage();
		
		TasksPageElements tasksPage =
				overviewPage.clickOnTasksTabAndPassToTasksPage();

		Thread.sleep(5000);

		NewTaskListModuleElements newTaskListModule =
				tasksPage.clickOnAddTaskListButtonAndPassToNewTaskListModule();
		
		newTaskListModule.sendKeysToNewTaskListNameTextBox(taskListName);
		
		tasksPage =
				newTaskListModule.clickOnAddThisTaskListButtonAndPassToTasksPageElements();
		
		SpecificTaskListPageElements specificTaskListPage =
				tasksPage.clickOnSpecificTaskListAndPassToItsPage(taskListName);
		
		FirstTaskModuleElements firstTaskModule =
				specificTaskListPage.clickOnAddTheFirstTaskButtonAndPassToFirstTaskModule();
		
		firstTaskModule.sendKeysToTaskNameTextBox("" + System.currentTimeMillis());
		firstTaskModule.selectWhoShouldDoThisInTaskAssignedToUserIdTextBox(who);
		firstTaskModule.clickOnSaveMyChangesButton();

		Thread.sleep(5000);
		
		firstTaskModule.sendKeysToTaskNameTextBox("" + System.currentTimeMillis());
		firstTaskModule.clickOnSaveMyChangesButton();
		
		MilestonesPageElements milestonesPage =
				firstTaskModule.clickOnMilestonesTabAndPassToMilestonesPage();
		
		tasksPage = milestonesPage.clickOnTasksTabAndPassToTasksPage();
		
		Assert.assertTrue(tasksPage.isThisTaskListExist(taskListName));
		
		specificTaskListPage = tasksPage.
				clickOnSpecificTaskListAndPassToItsPage(taskListName);
		
		Assert.assertTrue(2 == specificTaskListPage.sizeOfThisTaskList());
		
		specificTaskListPage.clickOnOptionsButton();
		specificTaskListPage.clickOnDeleteButton();
	}
}
