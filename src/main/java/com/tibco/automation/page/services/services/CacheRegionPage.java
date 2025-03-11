package com.tibco.automation.page.services.services;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.Locators;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.common.Locators.CacheRegionLocators;
import com.tibco.automation.page.common.Locators.CommonLocators;
import com.tibco.automation.page.common.Locators.EngineAdminPageLocators;
import com.tibco.automation.page.common.Locators.RolePageLocators;
import com.tibco.automation.page.common.TemplatePage.GSMenu;

public class CacheRegionPage extends TemplatePage implements Locators.CacheRegionLocators,EngineAdminPageLocators,RolePageLocators,CommonLocators{
	public DataGrid datagrid; // these are class references
	public ExtendedWebDriver driver;
	
	public Select select;
	
	
	public CacheRegionPage()
	{
		super("Cache Region", GSMenu.CacheRegions);
		driver = getDriver();
	}
	public void waitForPageToLoad() 
	{
	super.waitForPageToLoad();
	}
	public void refreshButton()
	{
		driver.getAssertionService().assertTrue((new ExtendedWebElement((REFRESHBUTTON)).isPresent()), "Refresh Button is not present on page", "Refresh Button is present on page");
	}
	public void removeColumn()
	{
		driver.getWaitUtility().waitForElementPresent(ADD_COL_OPTION);
		driver.getAssertionService().assertTrue((new ExtendedWebElement((ADD_COL_OPTION)).isPresent()), "Add column option is not present on page", "Add column option is present on page");
		driver.findElement(ADD_COL_OPTION).click();
		driver.getWaitUtility().waitForElementPresent(REMOVECOL);
		driver.findElement(REMOVECOL).click();
		driver.getWaitUtility().waitForElementPresent(ADDCOLUMNSAVE);
	    driver.findElement(ADDCOLUMNSAVE).click();
		
	}
	public void verifyColumnRemove()
	{
		driver.getAssertionService().assertFalse((new ExtendedWebElement((NAME)).isPresent()), "Column is not removed from the page", "Column is removed from the page");
		
	}
	public void addColumn()
	{
		driver.getWaitUtility().waitForElementPresent(ADD_COL_OPTION);
		driver.getAssertionService().assertTrue((new ExtendedWebElement((ADD_COL_OPTION)).isPresent()), "Add column option is not present on page", "Add column option is present on page");
		driver.findElement(ADD_COL_OPTION).click();
		driver.getWaitUtility().waitForElementPresent(ADDCOL);
	    driver.findElement(ADDCOL).click();
	    driver.getWaitUtility().waitForElementPresent(ADDCOLUMNSAVE);
	    driver.findElement(ADDCOLUMNSAVE).click();
	}
	public void verifyColumnAdded()
	{
		driver.getAssertionService().assertTrue((new ExtendedWebElement((NAME)).isPresent()), "Column is not added", "Column is added to the page");
		
	}
	public void revertColumn()
	{
		driver.getWaitUtility().waitForElementPresent(ADD_COL_OPTION);
		driver.findElement(ADD_COL_OPTION).click();
		driver.getWaitUtility().waitForElementPresent(REMOVECOL);
		driver.findElement(REMOVECOL).click();
		driver.getWaitUtility().waitForElementPresent(ADDCOLUMNSAVE);
	    driver.findElement(ADDCOLUMNSAVE).click();
	    driver.getAssertionService().assertFalse((new ExtendedWebElement((NAME)).isPresent()), "Column is not removed from the page", "Column is removed from the page");
	    driver.getWaitUtility().waitForElementPresent(ADD_COL_OPTION);
		driver.findElement(ADD_COL_OPTION).click();
		driver.getWaitUtility().waitForElementPresent(REVERT);
		driver.findElement(REVERT).click();
		driver.findElement(ADDCOLUMNSAVE).click();
		
		
	}
	public void verifyRevert()
	{
		driver.getAssertionService().assertTrue((new ExtendedWebElement((CACHEREGIONREVERT)).isPresent()), "Column is not reverted", "Column is reverted on page");
	}
	public void verifyDsetroyAllRegion()
	{
		addStaticWait(10000);
		driver.getAssertionService().assertTrue((new ExtendedWebElement((INVALID)).isPresent()), "All region are not destroyed", "Regions are destroyed successfully");
		
	}
	public void selectQueryBuilder()
	{
		driver.getAssertionService().addAssertionLog("Performing query builder search", MessageTypes.Info);
		driver.getAssertionService().assertElementPresent(By.xpath(SEARCH_TYPE_BUTTON_LOC), "Search Type Button");
		new ExtendedWebElement(SEARCH_TYPE_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Search Type button is clicked", MessageTypes.Info);
		driver.getWaitUtility().waitForElementPresent(String.format(SEARCH_TYPE_ITEM_LOC, "Query Builder"));
		driver.getAssertionService().assertElementPresent(By.xpath(String.format(SEARCH_TYPE_ITEM_LOC, "Query Builder")), "Query Builder search type");
		new ExtendedWebElement(String.format(SEARCH_TYPE_ITEM_LOC, "Query Builder")).click();
		driver.getAssertionService().addAssertionLog("Query Builder search type is selected", MessageTypes.Info);
	}
	
}
