package com.tibco.automation.test.gsui.usersadmin.users;

import org.openqa.selenium.By;
import org.testng.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import com.tibco.automation.common.utils.PropertiesUtil;
import com.tibco.automation.common.utils.RandomStringGenerator;
import com.tibco.automation.common.utils.RandomStringGenerator.RandomizerTypes;
import com.tibco.automation.page.admin.useradmin.UsersPage;
import com.tibco.automation.page.common.CommonFunctions;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.DataGrid.Actions;
import com.tibco.automation.page.common.Locators.ColumnNames;
import com.tibco.automation.page.common.TemplatePage;

//This JAVA file contain the User Admin functionalities like create user,edit user,delete user and change password. 

public class Users extends WebDriverTestCase {

	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public TemplatePage templatepage;
	public UsersPage usersPage;
	public CommonFunctions cf;
	public String userName;
	
	@BeforeMethod
	public void beforeMethod()
	{
		usersPage=new UsersPage();
		cf=new CommonFunctions();
		usersPage.launchPage();
		usersPage.waitForPageToLoad();
	}
	
	@Test(description="Verify add columns option is present on page")
	public void Grid_4482()
	{
		usersPage.verifyAddColumnPresent();
	}

	
	@Test(description="Verify user is able to add columns after clicking on Save button.")
	public void Grid_4483()
	{
		usersPage.verifyAddColumnPresent();
		usersPage.clickAddColumn();
		usersPage.waitForPageToLoad();
		usersPage.removeColumn("Full Name");
		usersPage.waitForPageToLoad();
		usersPage.addNewColumn("Full Name");
		usersPage.clickSaveOnAddColumn();
		usersPage.waitForPageToLoad();
		usersPage.verifyColumnPresent("Full Name");
	}
	
	@Test(description="Verify the functionality of revert button add columns popup.")
	public void Grid_4484()
	{
		usersPage.verifyAddColumnPresent();
		usersPage.clickAddColumn();
		usersPage.waitForPageToLoad();
		usersPage.removeColumn("Full Name");
		usersPage.waitForPageToLoad();
		usersPage.clickRevertOnAddColumn();
		usersPage.waitForPageToLoad();
		usersPage.clickSaveOnAddColumn();
		usersPage.waitForPageToLoad();
		usersPage.verifyColumnPresent("Full Name");
	}
	
	@Test(description="Verify functionality of global action Create New User")
	public void Grid_4485()
	{
		cf.verifyGlobalActionLinkIsPresent();
		cf.selectGlobalAction("Create New User");
		usersPage.navigateToNewlyOpenedPage();
		usersPage.clickCancel();
		usersPage.switchToMainWindow();
	}
	
	@Test(description="Verify the functionality of Save button of Create New User popup")
	public void Grid_4486()
	{
		userName="user"+RandomStringGenerator.get(3);
		cf.verifyGlobalActionLinkIsPresent();
		cf.selectGlobalAction("Create New User");
		usersPage.navigateToNewlyOpenedPage();
		usersPage.fillUserDetails(userName);
		usersPage.clickSave();
		usersPage.switchToMainWindow();
		usersPage.waitForPageToLoad();
		usersPage.verifyUserNameIsPresent(userName);
	}
	
	@Test(description="Verify the functionality of Cancel button of Create New User popup")
	public void Grid_4487()
	{
		userName="user"+RandomStringGenerator.get(3);
		cf.verifyGlobalActionLinkIsPresent();
		cf.selectGlobalAction("Create New User");
		usersPage.navigateToNewlyOpenedPage();
		usersPage.clickCancel();
		usersPage.switchToMainWindow();
		usersPage.waitForPageToLoad();
		usersPage.verifyUserNameIsNotPresent(userName);
	}
	
	@Test(description="Verify the functionality of Assign Role button of Create New User popup")
	public void Grid_4488()
	{
		userName="user"+RandomStringGenerator.get(3);
		cf.verifyGlobalActionLinkIsPresent();
		cf.selectGlobalAction("Create New User");
		usersPage.navigateToNewlyOpenedPage();
		usersPage.fillUserDetails(userName);
		usersPage.clickCancel();
		usersPage.switchToMainWindow();
		usersPage.waitForPageToLoad();
		usersPage.verifyUserNameIsNotPresent(userName);
	}
	
	@Test(description="Verify the functionality of Remove Role button of Create New User popup")
	public void Grid_4489()
	{
		userName="user"+RandomStringGenerator.get(3);
		cf.verifyGlobalActionLinkIsPresent();
		cf.selectGlobalAction("Create New User");
		usersPage.navigateToNewlyOpenedPage();
		usersPage.fillUserDetails(userName);
		usersPage.clickCancel();
		usersPage.switchToMainWindow();
		usersPage.waitForPageToLoad();
		usersPage.verifyUserNameIsNotPresent(userName);
	}
	
	@Test(description="Verify tooltip is present for Security Role on Create New User popup")
	public void Grid_4490()
	{
		cf.verifyGlobalActionLinkIsPresent();
		cf.selectGlobalAction("Create New User");
		usersPage.navigateToNewlyOpenedPage();
		usersPage.verifyRoleToolTipIsPresent();
		usersPage.clickCancel();
		usersPage.switchToMainWindow();
		usersPage.waitForPageToLoad();
	}
	
	@Test(description="Verify functionality of global action Edit Email Notification Template")
	public void Grid_4491()
	{
		cf.verifyGlobalActionLinkIsPresent();
		cf.selectGlobalAction("Edit Email Notification Template");
		usersPage.navigateToNewlyOpenedPage();
		usersPage.verifyEmailEditPageIsLaunched();
		usersPage.clickCancel();
		usersPage.switchToMainWindow();
		usersPage.waitForPageToLoad();
	}
	
	@Test(description="Verify the functionality of Save button of Edit Email Notification Template popup")
	public void Grid_4492()
	{
		cf.verifyGlobalActionLinkIsPresent();
		cf.selectGlobalAction("Edit Email Notification Template");
		usersPage.navigateToNewlyOpenedPage();
		usersPage.verifyEmailEditPageIsLaunched();
		usersPage.fillEmailSubject();
		usersPage.clickSaveOnEmailPage();
		usersPage.switchToMainWindow();
		usersPage.waitForPageToLoad();
	}
	
	@Test(description="Verify the functionality of Cancel button of Edit Email Notification Template popup")
	public void Grid_4493()
	{
		cf.verifyGlobalActionLinkIsPresent();
		cf.selectGlobalAction("Edit Email Notification Template");
		usersPage.navigateToNewlyOpenedPage();
		usersPage.verifyEmailEditPageIsLaunched();
		usersPage.fillEmailSubject();
		usersPage.clickCancel();
		usersPage.switchToMainWindow();
		usersPage.waitForPageToLoad();
	}
	
	@Test(description="Verify functionality of global action View User Event")
	public void Grid_4494()
	{
		cf.verifyGlobalActionLinkIsPresent();
		cf.selectGlobalAction("View User Events");
		usersPage.waitForPageToLoad();
		usersPage.verifyUserEventsPageIsDisplayed();
	}
	
	@Test(description="Verify functionality of Export Result button of View User Event popup")
	public void Grid_4496()
	{
		cf.verifyGlobalActionLinkIsPresent();
		cf.selectGlobalAction("View User Events");
		usersPage.waitForPageToLoad();
		usersPage.verifyUserEventsPageIsDisplayed();
		usersPage.clickExportButton();
	}
	
	@Test(description="Verify functionality of Display Result button of View User Event popup")
	public void Grid_4497()
	{
		cf.verifyGlobalActionLinkIsPresent();
		cf.selectGlobalAction("View User Events");
		usersPage.waitForPageToLoad();
		usersPage.verifyUserEventsPageIsDisplayed();
		usersPage.clickDisplayButton();
		usersPage.waitForPageToLoad();
		usersPage.verifyDisplayResults();
	}
	
	@Test(description="Verify functionality of Checkbox on View User Event popup")
	public void Grid_4498()
	{
		cf.verifyGlobalActionLinkIsPresent();
		cf.selectGlobalAction("View User Events");
		usersPage.waitForPageToLoad();
		usersPage.verifyUserEventsPageIsDisplayed();
		usersPage.verifyBetweenRadioButton();
		usersPage.verifyWithinRadioButton();
	}
	
	@Test(description="Verify functionality of global action View Driver Event")
	public void Grid_4499()
	{
		cf.verifyGlobalActionLinkIsPresent();
		cf.selectGlobalAction("View Driver Events");
		usersPage.waitForPageToLoad();
		usersPage.verifyDriverEventsPageIsDisplayed();
	}
	
	@Test(description="Verify functionality of Export Result button of View Driver Event popup")
	public void Grid_4501()
	{
		cf.verifyGlobalActionLinkIsPresent();
		cf.selectGlobalAction("View Driver Events");
		usersPage.waitForPageToLoad();
		usersPage.verifyDriverEventsPageIsDisplayed();
		usersPage.clickExportButton();
	}
	
	@Test(description="Verify functionality of Display Result button of View Driver Event popup")
	public void Grid_4502()
	{
		cf.verifyGlobalActionLinkIsPresent();
		cf.selectGlobalAction("View Driver Events");
		usersPage.waitForPageToLoad();
		usersPage.verifyDriverEventsPageIsDisplayed();
		usersPage.clickDisplayButton();
		usersPage.waitForPageToLoad();
		usersPage.verifyDisplayResults();
	}
	
	@Test(description="Verify functionality of Checkbox on View Driver Event popup")
	public void Grid_4503()
	{
		cf.verifyGlobalActionLinkIsPresent();
		cf.selectGlobalAction("View Driver Events");
		usersPage.waitForPageToLoad();
		usersPage.verifyDriverEventsPageIsDisplayed();
		usersPage.verifyBetweenRadioButton();
		usersPage.verifyWithinRadioButton();
	}
	
	@Test(description="Verify selecting a User enables the local action")
	public void Grid_4504()
	{
		cf.verifyGlobalActionLinkIsPresent();
		userName="user"+RandomStringGenerator.get(3);
		cf.verifyGlobalActionLinkIsPresent();
		cf.selectGlobalAction("Create New User");
		usersPage.navigateToNewlyOpenedPage();
		usersPage.fillUserDetails(userName);
		usersPage.clickSave();
		usersPage.switchToMainWindow();
		usersPage.waitForPageToLoad();
		usersPage.verifyUserNameIsPresent(userName);
		usersPage.selectUserName(userName);
		usersPage.selectUserName(userName);
		usersPage.selectUserName(userName);
		usersPage.waitForPageToLoad();
		cf.verifyLocalActionLinkIsPresent();
	}
	
	@Test(description="Verify de-selecting a selected User disables local action and enables global action.")
	public void Grid_4505()
	{
		cf.verifyGlobalActionLinkIsPresent();
		userName="user"+RandomStringGenerator.get(3);
		cf.verifyGlobalActionLinkIsPresent();
		cf.selectGlobalAction("Create New User");
		usersPage.navigateToNewlyOpenedPage();
		usersPage.fillUserDetails(userName);
		usersPage.clickSave();
		usersPage.switchToMainWindow();
		usersPage.waitForPageToLoad();
		usersPage.verifyUserNameIsPresent(userName);
		usersPage.selectUserName(userName);
		usersPage.selectUserName(userName);
		usersPage.selectUserName(userName);
		usersPage.selectUserName(userName);
		usersPage.waitForPageToLoad();
		cf.verifyGlobalActionLinkIsPresent();
	}
	
	@Test(description="Verify functionality of Edit user local action")
	public void Grid_4506()
	{
		cf.verifyGlobalActionLinkIsPresent();
		userName="user"+RandomStringGenerator.get(3);
		cf.verifyGlobalActionLinkIsPresent();
		cf.selectGlobalAction("Create New User");
		usersPage.navigateToNewlyOpenedPage();
		usersPage.fillUserDetails(userName);
		usersPage.clickSave();
		usersPage.switchToMainWindow();
		usersPage.waitForPageToLoad();
		usersPage.verifyUserNameIsPresent(userName);
		usersPage.selectUserName(userName);
		usersPage.selectUserName(userName);
		usersPage.selectUserName(userName);
		usersPage.waitForPageToLoad();
		cf.verifyLocalActionLinkIsPresent();
		cf.selectLocalAction("Edit User");
		usersPage.navigateToNewlyOpenedPage();
		usersPage.clickCancel();
		usersPage.switchToMainWindow();
	}
	
	@Test(description="Verify functionality of Save button of Edit User popup")
	public void Grid_4507()
	{
		cf.verifyGlobalActionLinkIsPresent();
		userName="user"+RandomStringGenerator.get(3);
		cf.verifyGlobalActionLinkIsPresent();
		cf.selectGlobalAction("Create New User");
		usersPage.navigateToNewlyOpenedPage();
		usersPage.fillUserDetails(userName);
		usersPage.clickSave();
		usersPage.switchToMainWindow();
		usersPage.waitForPageToLoad();
		usersPage.verifyUserNameIsPresent(userName);
		usersPage.selectUserName(userName);
		usersPage.selectUserName(userName);
		usersPage.selectUserName(userName);
		usersPage.waitForPageToLoad();
		cf.verifyLocalActionLinkIsPresent();
		cf.selectLocalAction("Edit User");
		usersPage.navigateToNewlyOpenedPage();
		usersPage.updateFirstName(userName);
		usersPage.clickSave();
		usersPage.switchToMainWindow();
		usersPage.waitForPageToLoad();
		usersPage.verifyFirstNameIsPresent(userName);
	}
	
	@Test(description="Verify functionality of Cancel button of Edit User popup")
	public void Grid_4508()
	{
		cf.verifyGlobalActionLinkIsPresent();
		userName="user"+RandomStringGenerator.get(3);
		cf.verifyGlobalActionLinkIsPresent();
		cf.selectGlobalAction("Create New User");
		usersPage.navigateToNewlyOpenedPage();
		usersPage.fillUserDetails(userName);
		usersPage.clickSave();
		usersPage.switchToMainWindow();
		usersPage.waitForPageToLoad();
		usersPage.verifyUserNameIsPresent(userName);
		usersPage.selectUserName(userName);
		usersPage.selectUserName(userName);
		usersPage.selectUserName(userName);
		usersPage.waitForPageToLoad();
		cf.verifyLocalActionLinkIsPresent();
		cf.selectLocalAction("Edit User");
		usersPage.navigateToNewlyOpenedPage();
		usersPage.updateFirstName(userName);
		usersPage.clickCancel();;
		usersPage.switchToMainWindow();
		usersPage.waitForPageToLoad();
		usersPage.verifyFirstNameIsNotPresent(userName);
	}
	
	@Test(description="Verify functionality of Change Password local action")
	public void Grid_4509()
	{
		cf.verifyGlobalActionLinkIsPresent();
		userName="user"+RandomStringGenerator.get(3);
		cf.verifyGlobalActionLinkIsPresent();
		cf.selectGlobalAction("Create New User");
		usersPage.navigateToNewlyOpenedPage();
		usersPage.fillUserDetails(userName);
		usersPage.clickSave();
		usersPage.switchToMainWindow();
		usersPage.waitForPageToLoad();
		usersPage.verifyUserNameIsPresent(userName);
		usersPage.selectUserName(userName);
		usersPage.selectUserName(userName);
		usersPage.selectUserName(userName);
		usersPage.waitForPageToLoad();
		cf.verifyLocalActionLinkIsPresent();
		cf.selectLocalAction("Change Password");
		usersPage.navigateToNewlyOpenedPage();
		usersPage.verifyChangePassword();
		usersPage.clickCancel();;
		usersPage.switchToMainWindow();
		usersPage.waitForPageToLoad();
	}
	
	@Test(description="Verify functionality of Save button of Change Password popup")
	public void Grid_4510()
	{
		cf.verifyGlobalActionLinkIsPresent();
		userName="user"+RandomStringGenerator.get(3);
		cf.verifyGlobalActionLinkIsPresent();
		cf.selectGlobalAction("Create New User");
		usersPage.navigateToNewlyOpenedPage();
		usersPage.fillUserDetails(userName);
		usersPage.clickSave();
		usersPage.switchToMainWindow();
		usersPage.waitForPageToLoad();
		usersPage.verifyUserNameIsPresent(userName);
		usersPage.selectUserName(userName);
		usersPage.selectUserName(userName);
		usersPage.selectUserName(userName);
		usersPage.waitForPageToLoad();
		cf.verifyLocalActionLinkIsPresent();
		cf.selectLocalAction("Change Password");
		usersPage.navigateToNewlyOpenedPage();
		usersPage.verifyChangePassword();
		usersPage.updatePassword();
		usersPage.clickSaveOnEmailPage();
		usersPage.switchToMainWindow();
		usersPage.waitForPageToLoad();
	}
	
	@Test(description="Verify delete user functionality while creating new user")
	public void Grid_4511()
	{
		cf.verifyGlobalActionLinkIsPresent();
		userName="user"+RandomStringGenerator.get(3);
		cf.verifyGlobalActionLinkIsPresent();
		cf.selectGlobalAction("Create New User");
		usersPage.navigateToNewlyOpenedPage();
		usersPage.fillUserDetails(userName);
		usersPage.clickSave();
		usersPage.switchToMainWindow();
		usersPage.waitForPageToLoad();
		usersPage.verifyUserNameIsPresent(userName);
		usersPage.selectUserName(userName);
		usersPage.selectUserName(userName);
		usersPage.selectUserName(userName);
		usersPage.waitForPageToLoad();
		cf.verifyLocalActionLinkIsPresent();
		cf.selectLocalAction("Delete User");
		cf.acceptAlert();
		usersPage.waitForPageToLoad();
		usersPage.verifyUserNameIsNotPresent(userName);
	}
	
	@Test(description="Verify Email user local action is present")
	public void Grid_4512()
	{
		cf.verifyGlobalActionLinkIsPresent();
		userName="user"+RandomStringGenerator.get(3);
		cf.verifyGlobalActionLinkIsPresent();
		cf.selectGlobalAction("Create New User");
		usersPage.navigateToNewlyOpenedPage();
		usersPage.fillUserDetails(userName);
		usersPage.clickSave();
		usersPage.switchToMainWindow();
		usersPage.waitForPageToLoad();
		usersPage.verifyUserNameIsPresent(userName);
		usersPage.selectUserName(userName);
		usersPage.selectUserName(userName);
		usersPage.selectUserName(userName);
		usersPage.waitForPageToLoad();
		cf.verifyLocalActionLinkIsPresent();
		cf.localActionIsPresent("Email User");
	}
	
	@Test(description="Verify functionality of User Events local action")
	public void Grid_4513()
	{
		cf.verifyGlobalActionLinkIsPresent();
		userName="user"+RandomStringGenerator.get(3);
		cf.verifyGlobalActionLinkIsPresent();
		cf.selectGlobalAction("Create New User");
		usersPage.navigateToNewlyOpenedPage();
		usersPage.fillUserDetails(userName);
		usersPage.clickSave();
		usersPage.switchToMainWindow();
		usersPage.waitForPageToLoad();
		usersPage.verifyUserNameIsPresent(userName);
		usersPage.selectUserName(userName);
		usersPage.selectUserName(userName);
		usersPage.selectUserName(userName);
		usersPage.waitForPageToLoad();
		cf.verifyLocalActionLinkIsPresent();
		cf.selectLocalAction("User Events");
		usersPage.waitForPageToLoad();
		usersPage.verifyUserEventsPageIsDisplayed();
		usersPage.clickExportButton();
		usersPage.clickDisplayButton();
		usersPage.waitForPageToLoad();
		usersPage.verifyDisplayResults();
	}
	
	@Test(description="Verify the functionality of User Events: Display Result,Export Result within last 1hr,1 day, 1week,1 month, 1 year")
	public void Grid_4516()
	{
		cf.verifyGlobalActionLinkIsPresent();
		userName="user"+RandomStringGenerator.get(3);
		cf.verifyGlobalActionLinkIsPresent();
		cf.selectGlobalAction("Create New User");
		usersPage.navigateToNewlyOpenedPage();
		usersPage.fillUserDetails(userName);
		usersPage.clickSave();
		usersPage.switchToMainWindow();
		usersPage.waitForPageToLoad();
		usersPage.verifyUserNameIsPresent(userName);
		usersPage.waitForPageToLoad();
		usersPage.selectUserName(userName);
		usersPage.selectUserName(userName);
		usersPage.selectUserName(userName);
		usersPage.waitForPageToLoad();
		cf.verifyLocalActionLinkIsPresent();
		cf.selectLocalAction("User Events");
		usersPage.waitForPageToLoad();
		usersPage.verifyUserEventsPageIsDisplayed();
		usersPage.clickExportButton();
		usersPage.clickDisplayButton();
		usersPage.waitForPageToLoad();
		usersPage.verifyDisplayResults();
	}
	
	@Test(description="Verify functionality of Driver Events local action")
	public void Grid_4517()
	{
		cf.verifyGlobalActionLinkIsPresent();
		userName="user"+RandomStringGenerator.get(3);
		cf.verifyGlobalActionLinkIsPresent();
		cf.selectGlobalAction("Create New User");
		usersPage.navigateToNewlyOpenedPage();
		usersPage.fillUserDetails(userName);
		usersPage.clickSave();
		usersPage.switchToMainWindow();
		usersPage.waitForPageToLoad();
		usersPage.verifyUserNameIsPresent(userName);
		usersPage.selectUserName(userName);
		usersPage.selectUserName(userName);
		usersPage.selectUserName(userName);
		usersPage.waitForPageToLoad();
		cf.verifyLocalActionLinkIsPresent();
		cf.selectLocalAction("Driver Events");
		usersPage.waitForPageToLoad();
		usersPage.verifyDriverEventsPageIsDisplayed();
		usersPage.clickExportButton();
		usersPage.clickDisplayButton();
		usersPage.waitForPageToLoad();
		usersPage.verifyDisplayResults();
	}
	
	@Test(description="Verify the functionality of Driver events Display Result/Export Result within last 1 day")
	public void Grid_4520()
	{
		cf.verifyGlobalActionLinkIsPresent();
		userName="user"+RandomStringGenerator.get(3);
		cf.verifyGlobalActionLinkIsPresent();
		cf.selectGlobalAction("Create New User");
		usersPage.navigateToNewlyOpenedPage();
		usersPage.fillUserDetails(userName);
		usersPage.clickSave();
		usersPage.switchToMainWindow();
		usersPage.waitForPageToLoad();
		usersPage.verifyUserNameIsPresent(userName);
		usersPage.selectUserName(userName);
		usersPage.selectUserName(userName);
		usersPage.selectUserName(userName);
		usersPage.waitForPageToLoad();
		cf.verifyLocalActionLinkIsPresent();
		cf.selectLocalAction("Driver Events");
		usersPage.waitForPageToLoad();
		usersPage.verifyDriverEventsPageIsDisplayed();
		usersPage.clickExportButton();
		usersPage.clickDisplayButton();
		usersPage.waitForPageToLoad();
		usersPage.verifyDisplayResults();
	}
	
	@Test(description="Verify simple search by using Create Date.")
	public void Grid_4523()
	{
		cf.performSimpleSearch("Create Date", "3/4/19 1:51 AM");
		usersPage.waitForPageToLoad();
		usersPage.verifySearchResults("0");
		cf.clearSearchResults();
	}
	
	@Test(description="Verify query search using Email")
	public void Grid_4524()
	{
		cf.performQuerySearch("Email matches invalidemail");
		usersPage.verifySearchResults("0");
		cf.clearSearchResults();
	}
	
	@Test(description="Verify query builder search using Full Name")
	public void Grid_4525()
	{
		cf.performQueryBuilderSearch("Full Name", "matches", "invaliduser");
		cf.clickSearchOnQueryBuilder();
		usersPage.verifySearchResults("0");
		cf.clearSearchResults();
	}
	
	@Test(description="Verify the functionality Close button of Query Builder popup")
	public void Grid_4526()
	{
		cf.performQueryBuilderSearch("Full Name", "matches", "invaliduser");
		cf.clickCloseOnQueryBuilder();
	}
	
	@Test(description="Verify change in results per page value changes the number of rows in table")
	public void Grid_4530()
	{
		cf.updateAndVerifyResultsPerPage(1);
	}
	
	@Test(description="Verify functionality of next page button in pagination.")
	public void Grid_4531()
	{
		cf.updateAndVerifyResultsPerPage(1);
		usersPage.waitForPageToLoad();
		cf.goToNextPage();
	}
	
	@Test(description="Verify functionality of previous page button in pagination")
	public void Grid_4532()
	{
		cf.updateAndVerifyResultsPerPage(1);
		usersPage.waitForPageToLoad();
		cf.goToNextPage();
		usersPage.waitForPageToLoad();
		cf.goToPreviousPage();
	}
	
	@Test(description="Verify functionality of move to first page button.")
	public void Grid_4533()
	{
		cf.updateAndVerifyResultsPerPage(1);
		usersPage.waitForPageToLoad();
		cf.goToNextPage();
		usersPage.waitForPageToLoad();
		cf.goToNextPage();
		usersPage.waitForPageToLoad();
		cf.goToFirstPage();
	}
	
	@Test(description="Verify functionality of move to last page button.")
	public void Grid_4534()
	{
		cf.updateAndVerifyResultsPerPage(1);
		usersPage.waitForPageToLoad();
		cf.goToPreviousPage();
		usersPage.waitForPageToLoad();
		cf.goToLastPage();
	}
	
	@Test(description="Verify the User drop down list on User event page")
	public void Grid_4696()
	{
		cf.verifyGlobalActionLinkIsPresent();
		cf.selectGlobalAction("View User Events");
		usersPage.waitForPageToLoad();
		usersPage.verifyUserEventsPageIsDisplayed();
		usersPage.verifyUsersDropdownIsPresent();
	}
	
	@Test(description="Verify the Driver user drop down list.")
	public void Grid_4698()
	{
		cf.verifyGlobalActionLinkIsPresent();
		cf.selectGlobalAction("View Driver Events");
		usersPage.waitForPageToLoad();
		usersPage.verifyDriverEventsPageIsDisplayed();
		usersPage.verifyDriverDropDownIsPresent();
	}
}