package com.tibco.automation.page.admin.useradmin;

import org.testng.Assert;

import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.Locators;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.common.TopPaginate;

public class RunAsPage extends TemplatePage implements Locators.RunAsPageLocators{
	
	public DataGrid datagrid;
	public ExtendedWebDriver driver;
	public String pageTitle ="Run-As Credentials";
	public TemplatePage templatePage;
	public TopPaginate topPaginate;
	
	public RunAsPage()
	{
		super("Run-As Credentials", GSMenu.RunAs);
		System.out.println("GSMenu..!!");
		datagrid = new DataGrid();
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
	
	//Add button functionality verification on runAs page
	public void addRunAsUser()
	{
		driver.getAssertionService().addAssertionLog("Creating New User.", MessageTypes.Pass);
		driver.getWaitUtility().waitForElementPresent(ADD_BUTTON_LOC);
		ExtendedWebElement add_Button=new ExtendedWebElement(ADD_BUTTON_LOC);
		add_Button.click();
		driver.getWaitUtility().waitForElementPresent(CREDENTIAL_LOC);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(CREDENTIAL_LOC).isDisplayed(), "Add user popup is not displayed", "Add user popup is displayed");
		
	}
	
	//Save button functionality verification on runAs page
	public void saveRunAsUser(String runAsUsername,String runAsPassword)
	{
		new ExtendedWebElement(CREDENTIAL_LOC).sendKeys(runAsUsername);
		driver.getAssertionService().assertTrue(((new ExtendedWebElement(CREDENTIAL_LOC).getAttribute("value")).compareTo(runAsUsername))==0, "Username is not updated to "+runAsUsername, "Username is updated to "+runAsUsername);
		new ExtendedWebElement(PASSWORD_LOC).sendKeys(runAsPassword);
		driver.getAssertionService().assertTrue(((new ExtendedWebElement(PASSWORD_LOC).getAttribute("value")).compareTo(runAsPassword))==0, "Password is not updated", "Password is updated");
		new ExtendedWebElement(CONFIRM_PASSWORD_LOC).sendKeys(runAsPassword);
		driver.getAssertionService().assertTrue(((new ExtendedWebElement(CONFIRM_PASSWORD_LOC).getAttribute("value")).compareTo(runAsPassword))==0, "Confirm Password is not updated", "Confirm Password is updated");
		new ExtendedWebElement(SAVE_BUTTON_LOC).click();	
	}
	
	//Verify user added on page
	public void verifyUserAdded(String runAsUsername)
	{
		
		driver.getWaitUtility().waitForElementPresent(String.format(ADDED_CREDENTIAL_NAME_LOC,runAsUsername));
		driver.getAssertionService().assertTrue(((new ExtendedWebElement(String.format(ADDED_CREDENTIAL_NAME_LOC, runAsUsername)).getText()).compareTo(runAsUsername))==0, "Run-As User "+runAsUsername+" is not added", "Run as user "+runAsUsername+" is added");
		driver.getAssertionService().assertTrue((new ExtendedWebElement(String.format(ADDED_CREDENTIAL_NAME_LOC, runAsUsername)).isDisplayed()), "User "+runAsUsername+"is not added", "User "+runAsUsername+"is added");
	}
	
	//Remove button functionality verification on runAs page
	public void removeRunAsUser(String runAsUsername)
	{
		driver.getAssertionService().addAssertionLog("Removing runas user "+runAsUsername, MessageTypes.Info);
		new ExtendedWebElement(String.format(REMOVE_BUTTON_LOC, runAsUsername)).click();
		driver.switchTo().alert().accept();
		driver.getWaitUtility().waitForElementPresent(ADD_BUTTON_LOC);

	}
	
	//Verify user is not present on runAs page
	public void verifyUserNotPresent(String runAsUsername)
	{
		
		driver.getWaitUtility().waitForElementNotPresent(String.format(ADDED_CREDENTIAL_NAME_LOC,runAsUsername));
		driver.getAssertionService().addAssertionLog("Run As user "+runAsUsername+"is not present", MessageTypes.Info);
	
	}
	
	//Verify user is present on runAs page
		public void verifyUserPresent(String runAsUsername)
		{
			
			driver.getWaitUtility().waitForElementPresent(String.format(ADDED_CREDENTIAL_NAME_LOC,runAsUsername));
			driver.getAssertionService().addAssertionLog("Run As user "+runAsUsername+"is present", MessageTypes.Info);
		
		}
	
	//Close button functionality verification on add user popup
	public void clickCloseButtonWithValues(String runAsUsername,String runAsPassword)
	{
		
		driver.getWaitUtility().waitForElementPresent(CREDENTIAL_LOC);
		driver.getAssertionService().addAssertionLog("Popup for adding user is launched", MessageTypes.Info);
		new ExtendedWebElement(CREDENTIAL_LOC).sendKeys(runAsUsername);
		driver.getAssertionService().assertTrue(((new ExtendedWebElement(CREDENTIAL_LOC).getAttribute("value")).compareTo(runAsUsername))==0, "Username is not updated", "Username is updated");
		new ExtendedWebElement(PASSWORD_LOC).sendKeys(runAsPassword);
		driver.getAssertionService().assertTrue(((new ExtendedWebElement(PASSWORD_LOC).getAttribute("value")).compareTo(runAsPassword))==0, "Password is not updated", "Password is updated");
		new ExtendedWebElement(CONFIRM_PASSWORD_LOC).sendKeys(runAsPassword);
		driver.getAssertionService().assertTrue(((new ExtendedWebElement(CONFIRM_PASSWORD_LOC).getAttribute("value")).compareTo(runAsPassword))==0, "Confirm Password is not updated", "Confirm Password is updated");
		new ExtendedWebElement(CLOSE_BUTTON_LOC).click();
		driver.getWaitUtility().waitForElementPresent(ADD_BUTTON_LOC);
	
	}
	
	public void clickCloseButton()
	{
		new ExtendedWebElement(CLOSE_BUTTON_LOC).click();
		driver.getWaitUtility().waitForElementPresent(ADD_BUTTON_LOC);
	}
	
	//Cancel button functionality verification on remove user popup
	public void cancelUserRemoval(String runAsUsername)
	{
		driver.getAssertionService().addAssertionLog("Removing runas user "+runAsUsername, MessageTypes.Info);
		new ExtendedWebElement(String.format(REMOVE_BUTTON_LOC, runAsUsername)).click();
		driver.getAssertionService().addAssertionLog("Clicking on cancel button on remove user alert", MessageTypes.Info);
		driver.switchTo().alert().dismiss();
		driver.getWaitUtility().waitForElementPresent(String.format(REMOVE_BUTTON_LOC, runAsUsername));
		Boolean present=new ExtendedWebElement(String.format(REMOVE_BUTTON_LOC, runAsUsername)).isPresent();
		driver.getAssertionService().assertTrue(present, "Run as user "+runAsUsername+" is removed", "Run as user "+runAsUsername+" is not removed");
		
		
	}
}
