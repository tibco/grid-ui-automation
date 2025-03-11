package com.tibco.automation.page.admin.systemadmin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.Locators;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.common.TopPaginate;

public class ManagerConfiguration_Logging_Page extends TemplatePage implements Locators.ManagerConfiguration_LoggingPageLocators{
	
	public DataGrid datagrid; // these are class references
	public ExtendedWebDriver driver;
	public String pageTitle ="System Admin";
	public TemplatePage templatePage;
	public TopPaginate topPaginate;

	public ManagerConfiguration_Logging_Page() {
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

	public void launchLoggingPage()
	{
		driver.getAssertionService().addAssertionLog("Launching logging page", MessageTypes.Info);
		new ExtendedWebElement(LOGGING_SIDE_MENU_LOC).click();
		driver.getWaitUtility().waitForElementPresent(EXPAND_COLLAPSE_VERIFICATION_TEXT_LOC);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(EXPAND_COLLAPSE_VERIFICATION_TEXT_LOC).isPresent(), "Logging page is not launched", "Logging page is launched");
	}
	
	public void expandAll()
	{
		driver.getWaitUtility().waitForElementPresent(EXPAND_ALL_LOC);
		new ExtendedWebElement(EXPAND_ALL_LOC).click();
		driver.getWaitUtility().waitForElementVisible(DEFAULT_DEBUG_LEVEL_SELECT_LOC);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(DEFAULT_DEBUG_LEVEL_SELECT_LOC).isDisplayed(), "Expand all button is not clicked", "Expand all button is clicked");
	}
	
	public void collapseAll()
	{
		driver.getWaitUtility().waitForElementPresent(COLLAPSE_ALL_LOC);
		new ExtendedWebElement(COLLAPSE_ALL_LOC).click();
		driver.getAssertionService().assertFalse(new ExtendedWebElement(DEFAULT_DEBUG_LEVEL_SELECT_LOC).isDisplayed(), "Collapse all button is not clicked", "Collapse all button is clicked");
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

	public void selectDefaultDebugLevel(String logLevel)
	{
		Select logLevelSelect=new Select(new ExtendedWebElement(DEFAULT_DEBUG_LEVEL_SELECT_LOC));
		logLevelSelect.selectByValue(logLevel);
		WebElement option=logLevelSelect.getFirstSelectedOption();
		driver.getAssertionService().assertTrue((option.getText()).equalsIgnoreCase(logLevel), "Default log level is not set to "+logLevel, "Default log level is set to "+logLevel);
	}
	
	public void verifySavedDefaultDebugLevel(String logLevel)
	{
		Select logLevelSelect=new Select(new ExtendedWebElement(DEFAULT_DEBUG_LEVEL_SELECT_LOC));
		WebElement option=logLevelSelect.getFirstSelectedOption();
		driver.getAssertionService().assertTrue((option.getText()).equalsIgnoreCase(logLevel), "Default log level is not saved to "+logLevel, "Default log level is saved to "+logLevel);
	}
	
	public void verifyCancelledDefaultDebugLevel(String customLogLevel)
	{
		Select logLevelSelect=new Select(new ExtendedWebElement(DEFAULT_DEBUG_LEVEL_SELECT_LOC));
		WebElement option=logLevelSelect.getFirstSelectedOption();
		driver.getAssertionService().assertFalse((option.getText()).equalsIgnoreCase(customLogLevel), "Default log level is saved to "+customLogLevel, "Default log level is not saved to "+customLogLevel);
	}
	
	public void collapseGeneralHeader()
	{
		new ExtendedWebElement(GENERAL_HEADER_LOC).click();
		driver.getWaitUtility().waitForElementNotPresent(DEFAULT_DEBUG_LEVEL_SELECT_LOC);
		driver.getAssertionService().assertFalse(new ExtendedWebElement(DEFAULT_DEBUG_LEVEL_SELECT_LOC).isDisplayed(), "Collapse from header is not working", "Collapse from header is working fine");
	}
	
	public void expandGeneralHeader()
	{
		new ExtendedWebElement(GENERAL_HEADER_LOC).click();
		driver.getWaitUtility().waitForElementVisible(DEFAULT_DEBUG_LEVEL_SELECT_LOC);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(DEFAULT_DEBUG_LEVEL_SELECT_LOC).isDisplayed(), "Expand from header is not working", "Expand from header is working fine");
	}
	
	public void verifyDescriptionTooltip()
	{
		driver.getWaitUtility().waitForElementPresent(DEBUG_LEVEL_DESCRIPTION_TOOLTIP);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(DEBUG_LEVEL_DESCRIPTION_TOOLTIP).isDisplayed(), "Tooltip for debug level's description is not present", "Tooltip for debug level description is present");
	}
	
	public void verifyNumericDataTooltip()
	{
		driver.getWaitUtility().waitForElementPresent(MAX_FILE_LENGTH_TOOLTIP_LOC);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(MAX_FILE_LENGTH_TOOLTIP_LOC).isDisplayed(), "Tooltip for max file length is not present", "Tooltip for max file length is present");
	}
}
