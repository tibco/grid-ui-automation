package com.tibco.automation.page.admin.useradmin;

import org.openqa.selenium.By;

import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.common.utils.PropertiesUtil;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.Locators;
import com.tibco.automation.page.common.Locators.UsersPageLocators;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.common.TopPaginate;
import com.tibco.automation.page.common.TemplatePage.GSMenu;
import com.tibco.automation.page.common.TopPaginate.MoreActions;
import org.openqa.selenium.support.ui.Select;

public class UsersPage extends TemplatePage implements Locators.UsersPageLocators {
	public DataGrid datagrid; // these are class references
	public ExtendedWebDriver driver;
	public String pageTitle ="User Admin";
	public TemplatePage templatePage;
	public TopPaginate topPaginate;
	public static String winHandleBefore;
	public String parentWinHandle;
	public UsersPage() {
		super("Users", GSMenu.Users);
		System.out.println("GSMenu..!!");
		datagrid = new DataGrid(); // as already defined above we are just intilizing
		driver = getDriver();
		templatePage = new TemplatePage();
		topPaginate = new TopPaginate();
		System.out.println(" After GSMenu..!!");
	}

	@Override
	public boolean isPageActive(Object... object) {
		System.out.println("isPageActive..!!");
		return super.verifyPageTitle(pageTitle);
		
		
	}

	@Override
	public void waitForPageToLoad() {
		super.waitForPageToLoad();
	}
	
	public void verifyAddColumnPresent()
	{
		driver.getWaitUtility().waitForElementPresent(ADD_COLUMN_LOC);
	}
	
	public void clickAddColumn()
	{
		driver.getAssertionService().assertTrue((new ExtendedWebElement(ADD_COLUMN_LOC)).isPresent(), "Add column option is not present", "Add column option is present");
		new ExtendedWebElement(ADD_COLUMN_LOC).click();
		driver.getAssertionService().assertTrue((new ExtendedWebElement(SAVE_BUTTON_ADD_COLUMN_LOC)).isDisplayed(), "Add column option is not clicked", "Add column option is clicked");
	}
	
	public void addNewColumn(String columnName)
	{
		String value=null;
		switch(columnName)
		{
		case "Full Name":
		{
			value="userfullname";
			break;
		}
		
		}
		driver.getAssertionService().assertTrue(new ExtendedWebElement(String.format(ADD_COLUMN_BUTTON_LOC, value)).isPresent(), "Column name "+columnName+" is already added",  "Column name "+columnName+" can be added");
		new ExtendedWebElement(String.format(ADD_COLUMN_BUTTON_LOC, value)).click();
		driver.getAssertionService().assertTrue(new ExtendedWebElement(String.format(REMOVE_COLUMN_BUTTON_LOC, columnName)).isPresent(), "Column name "+columnName+" is not added", "Column name "+columnName+" is added");
	}
	
	public void removeColumn(String columnName)
	{
		String value=null;
		switch(columnName)
		{
		case "Full Name":
		{
			value="userfullname";
			break;
		}
		
		}
		new ExtendedWebElement(String.format(REMOVE_COLUMN_BUTTON_LOC, columnName)).click();
		driver.getAssertionService().assertTrue(new ExtendedWebElement(String.format(ADD_COLUMN_BUTTON_LOC, value)).isDisplayed(), "Column name "+columnName+" is not removed",  "Column name "+columnName+" is removed");
	}
	
	
	
	public void clickSaveOnAddColumn()
	{
		driver.getAssertionService().assertTrue(new ExtendedWebElement(SAVE_BUTTON_ADD_COLUMN_LOC).isPresent(), "Save button is not being displayed", "Save button is displayed");
		new ExtendedWebElement(SAVE_BUTTON_ADD_COLUMN_LOC).click();
	}
	
	
	public void clickRevertOnAddColumn()
	{
		driver.getAssertionService().assertTrue(new ExtendedWebElement(REVERT_BUTTON_ADD_COLUMN_LOC).isPresent(), "Revert button is not being displayed", "revert button is displayed");
		new ExtendedWebElement(REVERT_BUTTON_ADD_COLUMN_LOC).click();
	}
	
	

	public void verifyColumnPresent(String columnName)
	{
		driver.getAssertionService().assertTrue(new ExtendedWebElement(String.format(COLUMN_ON_TABLE, columnName)).isPresent(), "Column "+columnName+"is not present on page", "Column "+columnName+"is present on page");
	}
	
	
	public void verifyColumnNotPresent(String columnName)
	{
		driver.getAssertionService().assertFalse(new ExtendedWebElement(String.format(COLUMN_ON_TABLE, columnName)).isPresent(), "Column "+columnName+"is present on page", "Column "+columnName+"is not present on page");
	}
	
	public void navigateToNewlyOpenedPage()
	{
		winHandleBefore = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()){
		driver.switchTo().window(winHandle);
		driver.manage().window().maximize();
		}
		driver.getAssertionService().addAssertionLog("Navigated to newly opened window", MessageTypes.Info);
	}
	
	public void switchToMainWindow()
	{
		driver.switchTo().window(winHandleBefore);
		driver.getAssertionService().addAssertionLog("Navigated to parent window", MessageTypes.Info);
	}
	
	public void clickCancel()
	{
		driver.getWaitUtility().waitForElementPresent(CANCEL_BUTTON);
		driver.findElement(CANCEL_BUTTON).click();
		driver.getAssertionService().addAssertionLog("Cancel Button is clicked", MessageTypes.Pass);
	}
	public void clickSave()
	{
		driver.getWaitUtility().waitForElementPresent(SAVE_BUTTON_LOC);
		driver.findElement(SAVE_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Save Button is clicked", MessageTypes.Pass);
	}
	
	public void fillUserDetails(String userName)
	{
		driver.getWaitUtility().waitForElementPresent(USERNAME_LOC);
		driver.findElement(USERNAME_LOC).sendKeys(userName);
		driver.getAssertionService().addAssertionLog("Username is updated to "+userName, MessageTypes.Info);
		driver.findElement(EMAIL_LOC).sendKeys(userName+"@gmail.com");
		driver.getAssertionService().addAssertionLog("Mail is updated to "+userName+"@gmail.com", MessageTypes.Info);
		driver.findElement(CONFIGURE_ROLE_LOC).click();
		driver.getAssertionService().addAssertionLog("Selected configure role", MessageTypes.Info);
		driver.findElement(ADD_ROLE_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Add role button is clicked", MessageTypes.Info);
		driver.findElement(REMOVE_ROLE_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Remove role button is clicked", MessageTypes.Info);
		driver.findElement(ADD_ROLE_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Add role button is clicked", MessageTypes.Info);
		driver.findElement(PASSWORD_LOC).sendKeys("admin");
		driver.getAssertionService().addAssertionLog("Password is set", MessageTypes.Info);
		driver.findElement(CONFIRM_PASSWORD_LOC).sendKeys("admin");
		driver.getAssertionService().addAssertionLog("Confirm Password is set", MessageTypes.Info);
	}
	
	public void verifyUserNameIsPresent(String userName)
	{
		driver.getAssertionService().assertTrue(new ExtendedWebElement(String.format(ADDED_USERNAME, userName)).isPresent(), "User "+userName+" is present");
		
	}
	public void verifyUserNameIsNotPresent(String userName)
	{
		driver.getAssertionService().assertFalse(new ExtendedWebElement(String.format(ADDED_USERNAME, userName)).isPresent(), "User "+userName+" is not present");
	}
	
	public void verifyRoleToolTipIsPresent()
	{
		driver.getAssertionService().assertElementPresent(By.xpath(ROLE_TOOLTIP_LOC), "Security Role Tooltip");
	}
	public void verifyEmailEditPageIsLaunched()
	{
		driver.getAssertionService().assertTrue(new ExtendedWebElement(EMAIL_SUBJECT_TEMPLATE_LOC).isPresent(), "Edit Email Notification Template page is launched");
	}
	public void fillEmailSubject()
	{
		driver.findElement(EMAIL_SUBJECT_TEXTAREA_LOC).sendKeys("123");
		driver.getAssertionService().addAssertionLog("Email subject is updated", MessageTypes.Info);
	}
	public void clickSaveOnEmailPage()
	{
		driver.findElement(SAVE_EMAIL_BUTTON).click();
		driver.getAssertionService().addAssertionLog("Save button is clicked", MessageTypes.Info);
	}
	public void verifyUserEventsPageIsDisplayed()
	{
		driver.getAssertionService().assertTrue(new ExtendedWebElement(USER_EVENTS_PAGE_LOC).isPresent(), "User Events View is displayed successfully");
	}
	public void clickExportButton()
	{
		driver.getWaitUtility().waitForElementPresent(EXPORT_RESULTS_BUTTON_LOC);
		driver.findElement(EXPORT_RESULTS_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Export Results button is clicked", MessageTypes.Info);
	}
	
	public void clickDisplayButton()
	{
		driver.getWaitUtility().waitForElementPresent(DISPLAY_RESULTS_BUTTON_LOC);
		driver.findElement(DISPLAY_RESULTS_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Display Results button is clicked", MessageTypes.Info);
	}
	
	public void verifyDisplayResults()
	{
		driver.getAssertionService().assertTrue(new ExtendedWebElement(TIMESTAMP_COLUMN_LOC).isPresent(), "Display Results is working as expected.");
	}
	
	public void verifyBetweenRadioButton()
	{
		driver.findElement(BETWEEN_RADIO_BUTTON_LOC).click();
		boolean val=driver.findElement(WITHIN_RADIO_BUTTON_LOC).isSelected();
		if(val==false)
			driver.getAssertionService().addAssertionLog("Between radio button is checked and within is unchecked", MessageTypes.Pass);
		else
			driver.getAssertionService().addAssertionLog("Between radio button is unchecked and within is checked", MessageTypes.Fail);
	}
	
	public void verifyWithinRadioButton()
	{
		driver.findElement(WITHIN_RADIO_BUTTON_LOC).click();
		boolean val=driver.findElement(BETWEEN_RADIO_BUTTON_LOC).isSelected();
		
		if(val==false)
			driver.getAssertionService().addAssertionLog("Within radio button is checked and between is unchecked", MessageTypes.Pass);
		else
			driver.getAssertionService().addAssertionLog("Within radio button is unchecked and between is checked", MessageTypes.Fail);
	}
	
	public void verifyDriverEventsPageIsDisplayed()
	{
		driver.getAssertionService().assertTrue(new ExtendedWebElement(DRIVER_EVENTS_PAGE_TITLE).isPresent(), "Driver Events View is displayed successfully");
	}
	
	public void selectUserName(String userName)
	{
		driver.findElement(String.format(USERNAME_CHECKBOX_LOC, userName)).click();
		driver.getAssertionService().addAssertionLog("Username checkbox is clicked", MessageTypes.Info);
		waitForPageToLoad();
	}
	
	public void updateFirstName(String userName)
	{
		driver.findElement(FIRSTNAME_TEXTBOX_LOC).sendKeys("edit"+userName);
		driver.getAssertionService().addAssertionLog("First name is set to edit"+userName, MessageTypes.Info);
	}
	
	public void verifyFirstNameIsPresent(String userName)
	{
		String firstName="edit"+userName;
		driver.getAssertionService().assertTrue(new ExtendedWebElement(String.format(UPDATED_FIRSTNAME, firstName)).isPresent(), "First name is updated to "+firstName);
	}
	
	public void verifyFirstNameIsNotPresent(String userName)
	{
		String firstName="edit"+userName;
		driver.getAssertionService().assertFalse(new ExtendedWebElement(String.format(UPDATED_FIRSTNAME, firstName)).isPresent(), "First name is not updated to "+firstName);
	}
	
	public void verifyChangePassword()
	{
		driver.getAssertionService().assertTrue(new ExtendedWebElement(PASSWORD_LOC).isPresent(), "Change Password Page is launched successfully");
	}
	
	public void updatePassword()
	{
		driver.findElement(PASSWORD_LOC).sendKeys("password");
		driver.findElement(CONFIRM_PASSWORD_LOC).sendKeys("password");
		driver.getAssertionService().addAssertionLog("Updated password and confirm password", MessageTypes.Info);
	}
	
	public void verifySearchResults(String noOfRows)
	{
		driver.getAssertionService().assertTrue(new ExtendedWebElement(String.format(TOTAL_ROWS_AFTER_SEARCH_LOC, noOfRows)).isDisplayed(), "Number of rows is "+noOfRows);
	}
	
	public void verifyUsersDropdownIsPresent()
	{
		driver.getAssertionService().assertElementPresent(By.xpath(USERNAME_DROPDOWN_LOC), "Username Dropdown");
	}
	
	public void verifyDriverDropDownIsPresent()
	{
		driver.getAssertionService().assertElementPresent(By.xpath(DRIVER_DROPDOWN_LOC), "Username Dropdown");
	}
}