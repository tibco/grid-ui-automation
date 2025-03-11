package com.tibco.automation.page.gridcomponents.brokers;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;

import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.Locators;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.common.TopPaginate;

public class BrokerConfigurationPage extends TemplatePage implements Locators,Locators.BrokerConfigurationPageLocators{

	
	public DataGrid datagrid; // these are class references
	public ExtendedWebDriver driver;
	public String pageTitle ="Driver Admin";
	public TemplatePage templatePage;
	public TopPaginate topPaginate;
	
	public BrokerConfigurationPage() {
		super("Broker Configuration", GSMenu.BrokerConfiguration);
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
		driver.getAssertionService().assertTrue(new ExtendedWebElement(String.format(ADD_COLUMN_BUTTON_LOC, value)).isPresent(), "Column name "+columnName+" is already added",  "Column name "+columnName+" can be added");
		new ExtendedWebElement(String.format(ADD_COLUMN_BUTTON_LOC, value)).click();
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
	
	public void updateAndVerifyResultsPerPage(int results) 
	{
		  addStaticWait(3000);
		updateResultsPerPage(results);
		
		addStaticWait(5000);
		
		int r=resultsPerPage();
		System.out.println(""+r);
		if (r==results)
			driver.getAssertionService().addAssertionLog("Results per page is updated to "+results, MessageTypes.Pass);
		else
			driver.getAssertionService().addAssertionLog("Results per page is not updated to "+results, MessageTypes.Fail);
	}
	
	public void updateResultsPerPage(int noOfRows) 
	{
		waitForPageToLoad();
		driver.findElement(By.xpath(RESULTS_PER_PAGE_LOC)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		if (isAlertPresent())
		acceptAlert();
        driver.findElement(By.xpath(RESULTS_PER_PAGE_LOC)).sendKeys(""+noOfRows);
        addStaticWait(1000);
        driver.findElement(By.xpath(RESULTS_PER_PAGE_LOC)).sendKeys(Keys.ENTER);
		driver.getAssertionService().addAssertionLog("Results per page is set to "+noOfRows, MessageTypes.Info);
	}
	
	private void acceptAlert() {
		// TODO Auto-generated method stub
		if(isAlertPresent()){
			driver.getAssertionService().addAssertionLog("Alert is present", MessageTypes.Info);
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
			}
	}


	//get results per page
	public int resultsPerPage()
	{
		waitForPageToLoad();
		List<WebElement> rows=driver.findElements(By.xpath(ROW_BROKER_NAME_ARRAY_LOC));
		int size=rows.size();
		return size;
	}
	public boolean isAlertPresent(){
		try{
		driver.switchTo().alert();
		return true;
		}catch(NoAlertPresentException ex){
		return false;
		}	
}
	
	public String updateBrokerName(String brokerName)
	{
		String existingName=driver.findElement(By.xpath(FIRST_BROKER_NAME)).getText();
		driver.findElement(By.xpath(FIRST_BROKER_NAME)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        driver.findElement(By.xpath(FIRST_BROKER_NAME)).sendKeys(brokerName);
        driver.getAssertionService().addAssertionLog("Updating broker name", MessageTypes.Info);
        return existingName;
	}
	
	public void clickSaveButton()
	{
		driver.getWaitUtility().waitForElementPresent(SAVE_BUTTON_LOC);
		new ExtendedWebElement(SAVE_BUTTON_LOC).click();
	}
	
	public void clickResetButton()
	{
		driver.getWaitUtility().waitForElementPresent(RESET_BUTTON_LOC);
		new ExtendedWebElement(RESET_BUTTON_LOC).click();
	}
	
	public void verifyBrokerNameIsUpdated(String brokerName)
	{
		if (brokerName.equals(new ExtendedWebElement(FIRST_BROKER_NAME).getAttribute("value")))
		{
			driver.getAssertionService().addAssertionLog("Broker Name is updated", MessageTypes.Pass);
		}
		else
			driver.getAssertionService().addAssertionLog("Broker Name is not updated", MessageTypes.Fail);
	}
	
	
	public void verifyBrokerNameIsNotUpdated(String brokerName)
	{
		if (brokerName.equals(new ExtendedWebElement(FIRST_BROKER_NAME).getAttribute("value")))
		{
			driver.getAssertionService().addAssertionLog("Broker Name is updated", MessageTypes.Fail);
		}
		else
			driver.getAssertionService().addAssertionLog("Broker Name is not updated", MessageTypes.Pass);
	}
	
	public void selectFirstOfflineBroker()
	{
		if (new ExtendedWebElement(FIRST_OFFLINE_BROKER_LOC).isPresent())
		{
			new ExtendedWebElement(FIRST_OFFLINE_BROKER_LOC).click();
			driver.getAssertionService().addAssertionLog("First offline broker is selected", MessageTypes.Pass);
		}
		else
			driver.getAssertionService().addAssertionLog("No offline broker is present", MessageTypes.Info);
	}
}
