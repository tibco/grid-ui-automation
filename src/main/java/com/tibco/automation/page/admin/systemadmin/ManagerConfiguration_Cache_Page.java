package com.tibco.automation.page.admin.systemadmin;

import com.tibco.automation.page.common.Locators;
import com.tibco.automation.page.common.TemplatePage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.TopPaginate;

public class ManagerConfiguration_Cache_Page extends TemplatePage implements Locators.ManagerConfiguration_CachePageLocators{

	
	public DataGrid datagrid; // these are class references
	public ExtendedWebDriver driver;
	public String pageTitle ="System Admin";
	public TemplatePage templatePage;
	public TopPaginate topPaginate;

	public ManagerConfiguration_Cache_Page() {
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

	public void launchCachePage()
	{
		driver.getAssertionService().addAssertionLog("Launching Cache page", MessageTypes.Info);
		new ExtendedWebElement(CACHE_SIDE_MENU_LOC).click();
		driver.getWaitUtility().waitForElementPresent(EXPAND_COLLAPSE_VERIFICATION_TEXT_LOC);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(EXPAND_COLLAPSE_VERIFICATION_TEXT_LOC).isPresent(), "Cache page is not launched", "Cache page is launched");
	}
	
	public void expandAll()
	{
		driver.getWaitUtility().waitForElementPresent(EXPAND_ALL_LOC);
		new ExtendedWebElement(EXPAND_ALL_LOC).click();
		driver.getWaitUtility().waitForElementVisible(MEMORY_SIZE_LOC);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(MEMORY_SIZE_LOC).isDisplayed(), "Expand all button is not clicked", "Expand all button is clicked");
	}
	
	public void collapseAll()
	{
		driver.getWaitUtility().waitForElementPresent(COLLAPSE_ALL_LOC);
		new ExtendedWebElement(COLLAPSE_ALL_LOC).click();
		driver.getAssertionService().assertFalse(new ExtendedWebElement(MEMORY_SIZE_LOC).isDisplayed(), "Collapse all button is not clicked", "Collapse all button is clicked");
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

	public void passMemorySize(String value)
	{
		//driver.findElement(By.xpath(MEMORY_SIZE_LOC)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath(MEMORY_SIZE_LOC)).sendKeys(value);
	}
	
	public void verifySavedValue(String value)
	{
		driver.getWaitUtility().waitForElementPresent(ALERT_LOC);
		driver.getAssertionService().assertTrue((new ExtendedWebElement(MEMORY_SIZE_LOC).getAttribute("value")).equalsIgnoreCase(value), "Value is not saved to  "+value, "Value is saved to "+value);
	}
	
	public void verifyCancelledValue(String value)
	{
		driver.getWaitUtility().waitForElementPresent(ALERT_LOC);
		driver.getAssertionService().assertFalse((new ExtendedWebElement(MEMORY_SIZE_LOC).getAttribute("value")).equalsIgnoreCase(value), "Value is saved to  "+value, "Value is not saved to "+value);
	}
	public void collapseHeader()
	{
		new ExtendedWebElement(GRIDCACHE_HEADER_LOC).click();
		driver.getWaitUtility().waitForElementNotPresent(EXPAND_COLLAPSE_VERIFICATION_TEXT_LOC);
		driver.getAssertionService().assertFalse(new ExtendedWebElement(EXPAND_COLLAPSE_VERIFICATION_TEXT_LOC).isDisplayed(), "Collapse from header is not working", "Collapse from header is working fine");
	}
	
	public void expandHeader()
	{
		new ExtendedWebElement(GRIDCACHE_HEADER_LOC).click();
		driver.getWaitUtility().waitForElementVisible(EXPAND_COLLAPSE_VERIFICATION_TEXT_LOC);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(EXPAND_COLLAPSE_VERIFICATION_TEXT_LOC).isDisplayed(), "Expand from header is not working", "Expand from header is working fine");
	}
	
	public void verifyDescriptionTooltip()
	{
		driver.getWaitUtility().waitForElementPresent(MEMORY_SIZE_DESCRIPTION_TOOLTIP);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(MEMORY_SIZE_DESCRIPTION_TOOLTIP).isDisplayed(), "Tooltip for description is not present", "Tooltip for description is present");
	}
	
	public void verifyNumericDataTooltip()
	{
		driver.getWaitUtility().waitForElementPresent(MEMORY_SIZE_TOOLTIP_LOC);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(MEMORY_SIZE_TOOLTIP_LOC).isDisplayed(), "Tooltip for numeric data is not present", "Tooltip for numeric data is present");
	}
}
