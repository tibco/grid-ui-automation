package com.tibco.automation.page.services.services;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.Locators;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.common.TopPaginate;
import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;

public class ServiceConditionsPage extends TemplatePage implements Locators,Locators.ServiceConditionsLocators{

	public DataGrid datagrid; // these are class references
	public ExtendedWebDriver driver;
	public String pageTitle ="Services";
	public TemplatePage templatePage;
	public TopPaginate topPaginate;
	public static String parentHandle;
	
	public ServiceConditionsPage() {
		super("Service Conditions", GSMenu.ServiceConditions);
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
		driver.getAssertionService().assertTrue((new ExtendedWebElement(SAVE_BUTTON_ADD_COLUMN_LOC)).isDisplayed(), "Add column option is not clicked", "Add column option is clicked");
	}
	
	public void addNewColumn(String columnName)
	{
		String value=null;
		switch(columnName)
		{
		case "Name":
		{
			value="name";
			break;
		}
		case "Type":
		{
			value="type";
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
		case "Name":
		{
			value="name";
			break;
		}
		case "Type":
		{
			value="type";
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
	
	public void verifySearchResult(String noOfRows)
	{
		driver.getAssertionService().assertElementPresent(By.xpath(ADD_COLUMN_LOC), "Add column option");
		driver.getAssertionService().assertTrue(new ExtendedWebElement(String.format(TOTAL_ROWS_AFTER_SEARCH_LOC, noOfRows)).isDisplayed(), "Number of rows is "+noOfRows);
	}
	
	public void clickAddButton()
	{
		driver.getWaitUtility().waitForElementPresent(ADD_BUTTON_LOC);
		new ExtendedWebElement(ADD_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Clicking on add button", MessageTypes.Info);
	}
	
	public void clickSaveButton()
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.getWaitUtility().waitForElementPresent(SAVE_BUTTON_LOC);
		new ExtendedWebElement(SAVE_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Clicking on save button", MessageTypes.Info);
	}
	
	public void clickCancelButton()
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.getWaitUtility().waitForElementPresent(CANCEL_BUTTON_LOC);
		new ExtendedWebElement(CANCEL_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Clicking on cancel button", MessageTypes.Info);
	}
	
	public void setConditionNameAndType(String conditionName,String type)
	{
		driver.getWaitUtility().waitForElementPresent(NAME_INPUT_LOC);
		new ExtendedWebElement(NAME_INPUT_LOC).sendKeys(conditionName);
		driver.getAssertionService().addAssertionLog("updating name for service condition to "+conditionName, MessageTypes.Info);
		
		Select select=new Select(new ExtendedWebElement(TYPE_SELECT_LOC));
		select.selectByVisibleText(type);
		driver.getAssertionService().addAssertionLog("Selecting service condition type to "+type, MessageTypes.Info);
	}
	
	public void verifyConditionIsPresent(String conditionName)
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.getAssertionService().assertElementPresent(By.xpath(String.format(ADDED_SERVICE_CONDITION_LOC, conditionName)), "Condition "+conditionName);
	}
	
	public void verifyConditionIsNotPresent(String conditionName)
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.getAssertionService().assertElementNotPresent(By.xpath(String.format(ADDED_SERVICE_CONDITION_LOC, conditionName)), conditionName);
	}
	
	public void getCurrentWindowHandle()
	{
		parentHandle = driver.getWindowHandle();
	}
	
	
	public void switchToParentWindow()
	{
		driver.switchTo().window(parentHandle);
	}
	
	public void switchToNewlyOpenedWindow()
	{
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		    driver.manage().window().maximize();
		}
	}
	
	public void selectConditionCheckbox(String conditionName)
	{
		driver.getWaitUtility().waitForElementPresent(String.format(SERVICE_CONDITION_CHECKBOX_LOC, conditionName));
		new ExtendedWebElement(String.format(SERVICE_CONDITION_CHECKBOX_LOC, conditionName)).click();
		waitForPageToLoad();
	}
	
	public void setNewConditionName(String conditionName)
	{
		driver.getWaitUtility().waitForElementPresent(COPY_NAME_INPUTBOX_LOC);
		new ExtendedWebElement(COPY_NAME_INPUTBOX_LOC).clear();
		new ExtendedWebElement(COPY_NAME_INPUTBOX_LOC).sendKeys(conditionName);
		driver.getAssertionService().addAssertionLog("Passing copied condition name to "+conditionName, MessageTypes.Info);
	}
	
	public void clickSaveOnPopup()
	{
		driver.getWaitUtility().waitForElementPresent(COPY_SAVE_BUTTON_LOC);
		new ExtendedWebElement(COPY_SAVE_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Clicking save on popup", MessageTypes.Info);
	}
	
	public void clickCancelOnPopup()
	{
		driver.getWaitUtility().waitForElementPresent(COPY_CANCEL_BUTTON_LOC);
		new ExtendedWebElement(COPY_CANCEL_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Clicking cancel on popup", MessageTypes.Info);
	}
}
