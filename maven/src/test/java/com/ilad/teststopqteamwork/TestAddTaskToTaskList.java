package com.ilad.teststopqteamwork;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ilad.topqteamwork.OverviewPageElements;
import com.ilad.topqteamwork.SpecificTaskListPageElements;
import com.ilad.topqteamwork.FirstTaskModuleElements;
import com.ilad.topqteamwork.LoginPageElements;
import com.ilad.topqteamwork.MilestonesPageElements;
import com.ilad.topqteamwork.NewTaskListModuleElements;
import com.ilad.topqteamwork.TasksPageElements;

public class TestAddTaskToTaskList {

	private WebDriver driver;
	private long time;
	private String userName;
	private String userPassword;
	private String newTaskListName;
	private String newTaskListFullName;
	private String who;
	
	
	@BeforeMethod
	public void setDriver() {
		driver = new FirefoxDriver();
		time = System.currentTimeMillis();
		userName = "fake05@fake.com";
		userPassword = "fake";
		newTaskListName = "BotTaskList";
		newTaskListFullName = newTaskListName + time;
		who = "fake05 fake05 (me)";
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://topq.teamwork.com/");
	}
	
//	@AfterMethod
	public void quitDriver() {
		driver.quit();
	}
	
	@Test(description = "Tests the functioning of TopQ Teamwork Website")
	public void test() throws InterruptedException {
		LoginPageElements loginPage = new LoginPageElements(driver);
		
		loginPage.sendKeysToUserNameTextBox(userName);
		loginPage.sendKeysToUserPasswordTextBox(userPassword);
		
		OverviewPageElements overviewPage =
				loginPage.clickOnLoginButtonAndPassToOverviewPage();
		
		Thread.sleep(5000);
		
		TasksPageElements tasksPage =
				overviewPage.clickOnTasksTabAndPassToTasksPage();
		
		Thread.sleep(5000);
		
		NewTaskListModuleElements newTaskListModule =
				tasksPage.clickOnAddTaskListButtonAndPassToNewTaskListModule();
		
		newTaskListModule.sendKeysToNewTaskListNameTextBox(newTaskListFullName);
		
		tasksPage =
				newTaskListModule.clickOnAddThisTaskListButtonAndPassToTasksPageElements();
		
		Thread.sleep(5000);
		
		SpecificTaskListPageElements specificTaskListPage =
				tasksPage.clickOnSpecificTaskListAndPassToItsPage(newTaskListFullName);
		
		FirstTaskModuleElements firstTaskModule =
				specificTaskListPage.clickOnAddTheFirstTaskButtonAndPassToFirstTaskModule();
		
		firstTaskModule.sendKeysToTaskNameTextBox("" + time);
		firstTaskModule.selectWhoShouldDoThisInTaskAssignedToUserIdTextBox(who);
		firstTaskModule.clickOnSaveMyChangesButton();
		
		Thread.sleep(5000);
		
		firstTaskModule.sendKeysToTaskNameTextBox("1" + time);
		firstTaskModule.clickOnSaveMyChangesButton();
		
		MilestonesPageElements milestonesPage =
				firstTaskModule.clickOnMilestonesTabAndPassToMilestonesPage();
		
		Thread.sleep(5000);
		
		tasksPage = milestonesPage.clickOnTasksTabAndPassToTasksPage();
		
		Assert.assertTrue(tasksPage.isThisTaskListExist(newTaskListFullName));
		
		specificTaskListPage = tasksPage.
				clickOnSpecificTaskListAndPassToItsPage(newTaskListFullName);
		
		Assert.assertTrue(2 == specificTaskListPage.sizeOfThisTaskList());
		
		specificTaskListPage.clickOnOptionsButton();
//		specificTaskListPage.clickOnDeleteButton();
	}
}
