package com.tibco.automation.page.gridcomponents.brokers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.Locators;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.common.TopPaginate;
import com.tibco.automation.page.common.TemplatePage.GSMenu;

public class BrokerAdminPage extends TemplatePage implements Locators,Locators.BrokerAdminPageLocators{

	public DataGrid datagrid; // these are class references
	public ExtendedWebDriver driver;
	public String pageTitle ="Driver Admin";
	public TemplatePage templatePage;
	public TopPaginate topPaginate;
	
	public BrokerAdminPage() {
		super("Broker Admin", GSMenu.BrokerAdmin);
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
	
	public void verifyAddColumnIsPresent()
	{
		driver.getWaitUtility().waitForElementPresent(ADD_COLUMN_LOC);
		driver.getAssertionService().assertElementPresent(By.xpath(ADD_COLUMN_LOC), "Add column option");
	}
	
	public void clickAddColumn()
	{
		driver.getAssertionService().assertTrue((new ExtendedWebElement(ADD_COLUMN_LOC)).isPresent(), "Add column option is not present", "Add column option is present");
		new ExtendedWebElement(ADD_COLUMN_LOC).click();
		waitForPageToLoad();
		//driver.getAssertionService().assertTrue((new ExtendedWebElement(SAVE_BUTTON_ADD_COLUMN_LOC)).isDisplayed(), "Add column option is not clicked", "Add column option is clicked");
	}
	
	public void addNewColumn(String columnName)
	{
		String value=null;
		switch(columnName)
		{
		case "Max Engines":
		{
			value="maxengines";
			break;
		}
		case "Min Engines":
		{
			value="minengines";
			break;
		}
		}
		driver.getWaitUtility().waitForElementPresent(String.format(ADD_COLUMN_BUTTON_LOC, value));
		driver.getAssertionService().assertTrue(new ExtendedWebElement(String.format(ADD_COLUMN_BUTTON_LOC, value)).isPresent(), "Column name "+columnName+" is already added",  "Column name "+columnName+" can be added");
		//new ExtendedWebElement(String.format(ADD_COLUMN_BUTTON_LOC, value)).click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", new ExtendedWebElement(String.format(ADD_COLUMN_BUTTON_LOC, value)));
		driver.getWaitUtility().waitForElementPresent(String.format(REMOVE_COLUMN_BUTTON_LOC, columnName));
		driver.getAssertionService().assertTrue(new ExtendedWebElement(String.format(REMOVE_COLUMN_BUTTON_LOC, columnName)).isPresent(), "Column name "+columnName+" is not added", "Column name "+columnName+" is added");
	}
	
	public void removeColumn(String columnName)
	{
		String value=null;
		switch(columnName)
		{
		case "Max Engines":
		{
			value="maxengines";
			break;
		}
		case "Min Engines":
		{
			value="minengines";
			break;
		}
		}
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", new ExtendedWebElement(String.format(REMOVE_COLUMN_BUTTON_LOC, columnName)));
		//new ExtendedWebElement(String.format(REMOVE_COLUMN_BUTTON_LOC, columnName)).click();
		driver.getAssertionService().assertTrue(new ExtendedWebElement(String.format(ADD_COLUMN_BUTTON_LOC, value)).isDisplayed(), "Column name "+columnName+" is not removed",  "Column name "+columnName+" is removed");
	}
	
	
	
	public void clickSaveOnAddColumn()
	{
		ExtendedWebElement element = driver.findElement(SAVE_BUTTON_ADD_COLUMN_LOC);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(SAVE_BUTTON_ADD_COLUMN_LOC).isPresent(), "Save button is not being displayed", "Save button is displayed");
		new ExtendedWebElement(SAVE_BUTTON_ADD_COLUMN_LOC).click();
	}
	
	
	public void clickRevertOnAddColumn()
	{
		ExtendedWebElement element = driver.findElement(SAVE_BUTTON_ADD_COLUMN_LOC);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
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
	
	public void verifySearchResult(String noOfRows)
	{
		driver.getAssertionService().assertElementPresent(By.xpath(ADD_COLUMN_LOC), "Add column option");
		driver.getAssertionService().assertTrue(new ExtendedWebElement(String.format(TOTAL_ROWS_AFTER_SEARCH_LOC, noOfRows)).isDisplayed(), "Number of rows is "+noOfRows);
	}
	
	public void selectFirstBroker()
	{
		driver.getWaitUtility().waitForElementPresent(ONLINE_BROKER_CHECKBOX_LOC);
		new ExtendedWebElement(ONLINE_BROKER_CHECKBOX_LOC).click();
		driver.getAssertionService().addAssertionsLog("Online Broker name checkbox is clicked");
	}
	
	public void selectFirstOfflineBroker()
	{
		driver.getWaitUtility().waitForElementPresent(OFFLINE_BROKER_CHECKBOX_LOC);
		new ExtendedWebElement(OFFLINE_BROKER_CHECKBOX_LOC).click();
		driver.getAssertionService().addAssertionsLog("Offline Broker name checkbox is clicked");
	}
	
	public void verifyPageIsLaunched(String pageTitle)
	{
		addStaticWait(2000);
		if (new ExtendedWebElement(String.format(PAGE_TITLE_LOCATOR, pageTitle)).isPresent() || new ExtendedWebElement(SIGN_IN_INPUT_LOC).isPresent() )
			{
				//driver.getWaitUtility().waitForElementPresent(String.format(PAGE_TITLE_LOCATOR, pageTitle));
				driver.getAssertionService().addAssertionsLog("Page is launched successfully");
			}
		else
			driver.getAssertionService().addAssertionsLog("Page is not launched");
		}
	
	public void verifyBrokerMonitorPageIsLaunched()
	{
		addStaticWait(2000);
		if (new ExtendedWebElement(BROKER_MONITOR_PAGE_LOC).isPresent() || new ExtendedWebElement(SIGN_IN_INPUT_LOC).isPresent() )
		{
			//driver.getWaitUtility().waitForElementPresent(String.format(PAGE_TITLE_LOCATOR, pageTitle));
			driver.getAssertionService().addAssertionsLog("Page is launched successfully");
		}
	else
		driver.getAssertionService().addAssertionsLog("Page is not launched");
		
	}
}
