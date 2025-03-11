package com.tibco.automation.page.admin.systemadmin;

import com.tibco.automation.page.common.Locators;
import com.tibco.automation.page.common.TemplatePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.TopPaginate;
import com.tibco.automation.page.common.TemplatePage.GSMenu;

public class ManagerConfiguration_Database_Page extends TemplatePage implements Locators.ManagerConfiguration_DatabasePageLocators{
	
	public DataGrid datagrid; // these are class references
	public ExtendedWebDriver driver;
	public String pageTitle ="System Admin";
	public TemplatePage templatePage;
	public TopPaginate topPaginate;

	public ManagerConfiguration_Database_Page() {
		super("Manager Configuration", GSMenu.ManagerConfiguration);
		System.out.println("GSMenu..!!");
		datagrid = new DataGrid(); // as already defined above we are just intializing
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

	public void launchDatabasePage()
	{
		driver.getAssertionService().addAssertionLog("Launching Database page", MessageTypes.Info);
		new ExtendedWebElement(DATABASE_SIDE_MENU_LOC).click();
		driver.getWaitUtility().waitForElementPresent(EXPAND_COLLAPSE_VERIFICATION_TEXT_LOC);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(EXPAND_COLLAPSE_VERIFICATION_TEXT_LOC).isPresent(), "Database page is not launched", "Database page is launched");
	}
	
	public void expandAll()
	{
		driver.getWaitUtility().waitForElementPresent(EXPAND_ALL_LOC);
		new ExtendedWebElement(EXPAND_ALL_LOC).click();
		driver.getWaitUtility().waitForElementVisible(CONNECTION_SUSPENDED_SELECT_LOC);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(CONNECTION_SUSPENDED_SELECT_LOC).isDisplayed(), "Expand all button is not clicked", "Expand all button is clicked");
	}
	
	public void collapseAll()
	{
		driver.getWaitUtility().waitForElementPresent(COLLAPSE_ALL_LOC);
		new ExtendedWebElement(COLLAPSE_ALL_LOC).click();
		driver.getAssertionService().assertFalse(new ExtendedWebElement(CONNECTION_SUSPENDED_SELECT_LOC).isDisplayed(), "Collapse all button is not clicked", "Collapse all button is clicked");
	}
	
	public void clickSave()
	{
		driver.getWaitUtility().waitForElementPresent(SAVE_BUTTON_LOC);
		new ExtendedWebElement(SAVE_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Save button clicked", MessageTypes.Info);
	}
	
	public void clickCancel()
	{
		driver.getWaitUtility().waitForElementPresent(CANCEL_BUTTON_LOC);
		new ExtendedWebElement(CANCEL_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Cancel button clicked", MessageTypes.Info);
	}

	public void selectConnectionSuspended(String value)
	{
		Select logLevelSelect=new Select(new ExtendedWebElement(CONNECTION_SUSPENDED_SELECT_LOC));
		logLevelSelect.selectByValue(value);
		WebElement option=logLevelSelect.getFirstSelectedOption();
		driver.getAssertionService().assertTrue((option.getText()).equalsIgnoreCase(value), "Connection suspended is not set to "+value, "Connection suspended is set to "+value);
	}
	
	public void verifySavedValue(String value)
	{
		Select logLevelSelect=new Select(new ExtendedWebElement(CONNECTION_SUSPENDED_SELECT_LOC));
		WebElement option=logLevelSelect.getFirstSelectedOption();
		driver.getAssertionService().assertTrue((option.getText()).equalsIgnoreCase(value), "Value is not saved to  "+value, "Value is saved to "+value);
	}
	
	public void verifyCancelledValue(String value)
	{
		Select logLevelSelect=new Select(new ExtendedWebElement(CONNECTION_SUSPENDED_SELECT_LOC));
		WebElement option=logLevelSelect.getFirstSelectedOption();
		driver.getAssertionService().assertFalse((option.getText()).equalsIgnoreCase(value), "Value is saved to "+value, "Value is not saved to "+value);
	}
	
	public void collapseHeader()
	{
		new ExtendedWebElement(BROKER_REPORTING_HEADER_LOC).click();
		driver.getWaitUtility().waitForElementNotPresent(EXPAND_COLLAPSE_VERIFICATION_TEXT_LOC);
		driver.getAssertionService().assertFalse(new ExtendedWebElement(EXPAND_COLLAPSE_VERIFICATION_TEXT_LOC).isDisplayed(), "Collapse from header is not working", "Collapse from header is working fine");
	}
	
	public void expandHeader()
	{
		new ExtendedWebElement(BROKER_REPORTING_HEADER_LOC).click();
		driver.getWaitUtility().waitForElementVisible(EXPAND_COLLAPSE_VERIFICATION_TEXT_LOC);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(EXPAND_COLLAPSE_VERIFICATION_TEXT_LOC).isDisplayed(), "Expand from header is not working", "Expand from header is working fine");
	}
	
	public void verifyDescriptionTooltip()
	{
		driver.getWaitUtility().waitForElementPresent(STATISTIC_PERIOD_DESCRIPTION_TOOLTIP);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(STATISTIC_PERIOD_DESCRIPTION_TOOLTIP).isDisplayed(), "Tooltip for description is not present", "Tooltip for description is present");
	}
	
	public void verifyNumericDataTooltip()
	{
		driver.getWaitUtility().waitForElementPresent(STATISTIC_PERIOD_TOOLTIP_LOC);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(STATISTIC_PERIOD_TOOLTIP_LOC).isDisplayed(), "Tooltip for numeric data is not present", "Tooltip for numeric data is present");
	}
}
