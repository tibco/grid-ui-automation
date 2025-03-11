package com.tibco.automation.page.common;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;
import com.tibco.automation.common.framework.webdriver.ExtendedExpectedCondition;
import com.tibco.automation.common.framework.webdriver.ExtendedExpectedConditions;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.common.framework.webdriver.WebDriverManager;

public class CommonFunctions extends TemplatePage implements Locators.TemplatePageLocators, Locators.CommonLocators,Locators{
	public ExtendedWebDriver driver;
	public ExtendedWebElement element;
	
	
	public CommonFunctions() {
		ExtendedWebDriver driver = WebDriverManager.getDriver();
		this.driver = driver;
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
	
	public void addStaticWait(int waitTimeInMillis) {
		try {
			Thread.sleep(waitTimeInMillis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	//select global action using its name
	public void selectGlobalAction(String actionLocator)
	{
		
		driver.getWaitUtility().waitForElementPresent(GLOBAL_ACTION_LINK_LOCATOR);
		WebElement ele = driver.findElement(By.xpath(GLOBAL_ACTION_LINK_LOCATOR));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		driver.getAssertionService().assertElementPresent(By.xpath(GLOBAL_ACTION_NAME), "Global action item "+actionLocator);
		executor.executeScript("arguments[0].click();", new ExtendedWebElement(String.format(GLOBAL_ACTION_NAME, actionLocator)));
		//new ExtendedWebElement(String.format(GLOBAL_ACTION_NAME, actionLocator)).click();
	}
	
	//check whether a particular local action is present or not
	public void localActionIsPresent(String actionLocator)
	{
		driver.getWaitUtility().waitForElementPresent(LOCAL_ACTION_LINK_LOC);
		WebElement ele = driver.findElement(By.xpath(LOCAL_ACTION_LINK_LOC));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		driver.getAssertionService().assertElementPresent(By.xpath(LOCAL_ACTION_ITEM_LOC), "Local action item "+actionLocator);
		executor.executeScript("arguments[0].click();", ele);
	}
	//select local action using its name
	public void selectLocalAction(String actionLocator)
	{
		driver.getWaitUtility().waitForElementPresent(LOCAL_ACTION_LINK_LOC);
		WebElement ele = driver.findElement(By.xpath(LOCAL_ACTION_LINK_LOC));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		driver.getAssertionService().assertElementPresent(By.xpath(LOCAL_ACTION_ITEM_LOC), "Local action item "+actionLocator);
		//new ExtendedWebElement(String.format(LOCAL_ACTION_ITEM_LOC, actionLocator)).click();
		executor.executeScript("arguments[0].click();", new ExtendedWebElement(String.format(LOCAL_ACTION_ITEM_LOC, actionLocator)));
		driver.getAssertionService().addAssertionLog("Local action "+actionLocator+" is selected", MessageTypes.Info);
	}
	
	//verify global action link is present
	public void verifyGlobalActionLinkIsPresent()
	{
		driver.getAssertionService().assertTrue(new ExtendedWebElement(GLOBAL_ACTION_LINK_LOCATOR).isPresent(), "Global actions link is not present", "Global actions link is present");
	}
	
	//verify local action link is present
	public void verifyLocalActionLinkIsPresent()
	{
		driver.getAssertionService().assertTrue(new ExtendedWebElement(LOCAL_ACTION_LINK_LOC).isPresent(), "Local actions link is not present", "Local actions link is present");
	}
	
	
	//maximize current window
	public void maximizeCurrentWindow()
	{
		driver.manage().window().maximize();
	}
	
	//accept an alert
	public void acceptAlert()
	{
		if(isAlertPresent()){
			driver.getAssertionService().addAssertionLog("Alert is present", MessageTypes.Info);
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
			}
	}
	
	//cancel an alert
	public void dismissAlert()
	{
		if(isAlertPresent()){
			driver.getAssertionService().addAssertionLog("Alert is present", MessageTypes.Info);
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.dismiss();
			}
	}
	
	//check if alert is present
	public boolean isAlertPresent(){
		try{
		driver.switchTo().alert();
		return true;
		}catch(NoAlertPresentException ex){
		return false;
		}
}
	
	//perform simple search providing a search string and a column name
	public void performSimpleSearch(String columnName,String searchString)
	{
		System.out.println("inside simple search");
		driver.getAssertionService().addAssertionLog("Performing simple search", MessageTypes.Info);
		driver.getAssertionService().assertElementPresent(By.xpath(SEARCH_TYPE_BUTTON_LOC), "Search Type Button");
		new ExtendedWebElement(SEARCH_TYPE_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Search Type button is clicked", MessageTypes.Info);
		driver.getWaitUtility().waitForElementPresent(String.format(SEARCH_TYPE_ITEM_LOC, "Simple"));
		driver.getAssertionService().assertElementPresent(By.xpath(String.format(SEARCH_TYPE_ITEM_LOC, "Simple")), "Simple search type");
		new ExtendedWebElement(String.format(SEARCH_TYPE_ITEM_LOC, "Simple")).click();
		driver.getAssertionService().addAssertionLog("Simple search type is selected", MessageTypes.Info);
		driver.getWaitUtility().waitForElementPresent(SEARCH_STRING_LOC);
		Select select=new Select(new ExtendedWebElement(SEARCH_COLUMN_NAME_LOC));
		select.selectByVisibleText(columnName);
		String selectedColumnName=select.getFirstSelectedOption().getText();
		driver.getAssertionService().assertTrue(columnName.equals(selectedColumnName), "Column name "+columnName+" is not selected", "Column name "+columnName+"is selected");
		driver.getAssertionService().assertElementPresent(By.xpath(SEARCH_STRING_LOC), "Simple search string text box");
		new ExtendedWebElement(SEARCH_STRING_LOC).sendKeys(searchString);
		driver.getAssertionService().addAssertionLog("Search string provided in input box", MessageTypes.Info);
		new ExtendedWebElement(SEARCH_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Search button is clicked", MessageTypes.Info);
	}
	
	
	//perform query search by providing search query
	public void performQuerySearch(String query)
	{
		driver.getAssertionService().addAssertionLog("Performing query search", MessageTypes.Info);
		driver.getAssertionService().assertElementPresent(By.xpath(SEARCH_TYPE_BUTTON_LOC), "Search Type Button");
		new ExtendedWebElement(SEARCH_TYPE_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Search Type button is clicked", MessageTypes.Info);
		driver.getWaitUtility().waitForElementPresent(String.format(SEARCH_TYPE_ITEM_LOC, "Query"));
		driver.getAssertionService().assertElementPresent(By.xpath(String.format(SEARCH_TYPE_ITEM_LOC, "Query")), "Query search type");
		new ExtendedWebElement(String.format(SEARCH_TYPE_ITEM_LOC, "Query")).click();
		driver.getAssertionService().addAssertionLog("Query search type is selected", MessageTypes.Info);
		driver.getWaitUtility().waitForElementPresent(SEARCH_STRING_LOC);
		new ExtendedWebElement(SEARCH_STRING_LOC).sendKeys(query);
		driver.getAssertionService().addAssertionLog("Search query provided in input box", MessageTypes.Info);
		new ExtendedWebElement(SEARCH_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Search button is clicked", MessageTypes.Info);
	}
	
	
	//clear search results
	public void clearSearchResults()
	{
		driver.getWaitUtility().waitForElementPresent(CLEAR_SEARCH_RESULTS_LOC);
		driver.getAssertionService().assertElementPresent(By.xpath(CLEAR_SEARCH_RESULTS_LOC), "Clear Button");
		new ExtendedWebElement(CLEAR_SEARCH_RESULTS_LOC).click();
		driver.getAssertionService().addAssertionLog("Clear search button is clicked", MessageTypes.Info);
	}
	
	//QUERY BUILDER SEARCH FUNCTIONS
	//perform query builder search by selecting query
		public void performQueryBuilderSearch(String columnName, String condition, String value)
		{
			driver.getAssertionService().addAssertionLog("Performing query builder search", MessageTypes.Info);
			driver.getAssertionService().assertElementPresent(By.xpath(SEARCH_TYPE_BUTTON_LOC), "Search Type Button");
			new ExtendedWebElement(SEARCH_TYPE_BUTTON_LOC).click();
			driver.getAssertionService().addAssertionLog("Search Type button is clicked", MessageTypes.Info);
			driver.getWaitUtility().waitForElementPresent(String.format(SEARCH_TYPE_ITEM_LOC, "Query Builder"));
			driver.getAssertionService().assertElementPresent(By.xpath(String.format(SEARCH_TYPE_ITEM_LOC, "Query Builder")), "Query Builder search type");
			new ExtendedWebElement(String.format(SEARCH_TYPE_ITEM_LOC, "Query Builder")).click();
			driver.getAssertionService().addAssertionLog("Query Builder search type is selected", MessageTypes.Info);
			
			Select columnSelect=new Select(new ExtendedWebElement(QUERY_BUILDER_COLUMN_NAME_SELECT_LOC));
			columnSelect.selectByVisibleText(columnName);
			Select columnEdited=new Select(new ExtendedWebElement(QUERY_BUILDER_COLUMN_NAME_SELECT_LOC));
			String columnSet=columnEdited.getFirstSelectedOption().getText();
			driver.getAssertionService().assertTrue(columnSet.equals(columnName), "Column name is set to "+columnName);
			
			Select conditionSelect=new Select(new ExtendedWebElement(QUERY_BUILDER_CONDITION_SELECT_LOC));
			conditionSelect.selectByValue(condition);
			String conditionSet=conditionSelect.getFirstSelectedOption().getText();
			driver.getAssertionService().assertTrue(conditionSet.equals(condition), "Condition is set to "+condition);
			
			new ExtendedWebElement(QUERY_BUILDER_VALUE_LOC).sendKeys(value);
			driver.getAssertionService().addAssertionLog("Value input box is set to "+value, MessageTypes.Info);
		}
		
		//click search on query builder popup
		public void clickSearchOnQueryBuilder()
		{
			new ExtendedWebElement(QUERY_BUILDER_COLUMN_NAME_SELECT_LOC).click();
			ExpectedConditions.elementToBeClickable(By.xpath(QUERY_BUILDER_SEARCH_BUTTON_LOC));
			new ExtendedWebElement(QUERY_BUILDER_SEARCH_BUTTON_LOC).click();
			driver.getAssertionService().addAssertionLog("Search button is clicked on query builder popup", MessageTypes.Info);
		}
		
		//click close on query builder popup
		public void clickCloseOnQueryBuilder()
		{
			new ExtendedWebElement(QUERY_BUILDER_COLUMN_NAME_SELECT_LOC).click();
			ExpectedConditions.elementToBeClickable(By.xpath(QUERY_BUILDER_CLOSE_BUTTON_LOC));
			driver.getAssertionService().assertElementPresent(By.xpath(QUERY_BUILDER_CLOSE_BUTTON_LOC), "Close Button");
			new ExtendedWebElement(QUERY_BUILDER_CLOSE_BUTTON_LOC).click();
			driver.getAssertionService().addAssertionLog("Close button is clicked on query builder popup", MessageTypes.Info);
		}
		
		//update and verify results per page
		public void updateAndVerifyResultsPerPage(int results) 
		{

			updateResultsPerPage(results);
			int r=resultsPerPage();
			if (r==results)
				driver.getAssertionService().addAssertionLog("Results per page is updated to "+results, MessageTypes.Pass);
			else
				driver.getAssertionService().addAssertionLog("Results per page is not updated to "+results, MessageTypes.Fail);
		}
		
		//update results per page
		public void updateResultsPerPage(int noOfRows) 
		{
			addStaticWait(3000);
			waitForPageToLoad();
			driver.findElement(By.xpath(RESULTS_PER_PAGE_LOC)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			if (isAlertPresent())
			acceptAlert();
	        driver.findElement(By.xpath(RESULTS_PER_PAGE_LOC)).sendKeys(""+noOfRows);
	        addStaticWait(1000);
	        driver.findElement(By.xpath(RESULTS_PER_PAGE_LOC)).sendKeys(Keys.ENTER);
			driver.getAssertionService().addAssertionLog("Results per page is set to "+noOfRows, MessageTypes.Info);
			addStaticWait(5000);
		}
		
		//get results per page
		public int resultsPerPage()
		{
			waitForPageToLoad();
			List<WebElement> rows=driver.findElements(By.xpath(ROW_CHECKBOX_ARRAY_LOC));
			int size=rows.size();
			return size;
		}
		
		
		//PAGINATION
		//click on next page button
		public void goToNextPage()
		{
			addStaticWait(2000);
			if (new ExtendedWebElement(PAGINATION_NEXT_BUTTON_BOTTOM_ENABLED_LOC).isPresent())
			{
				driver.getAssertionService().addAssertionLog("Next button is enabled, clicking on it", MessageTypes.Pass);
				new ExtendedWebElement(PAGINATION_NEXT_BUTTON_BOTTOM_ENABLED_LOC).click();
			}
			else if (new ExtendedWebElement(PAGINATION_NEXT_BUTTON_BOTTOM_DISABLED_LOC).isPresent())
			{
				driver.getAssertionService().addAssertionLog("Next button is not enabled, already on last page", MessageTypes.Pass);
			}
			else
			{
				driver.getAssertionService().addAssertionLog("Something went wrong, please check", MessageTypes.Fail);
			}
		}
		
		
		//click on previous page button
		public void goToPreviousPage()
		{
			addStaticWait(2000);
			if (new ExtendedWebElement(PAGINATION_PREVIOUS_BUTTON__BOTTOM_ENABLED_LOC).isPresent())
			{
				driver.getAssertionService().addAssertionLog("Previous button is enabled, clicking on it", MessageTypes.Pass);
				new ExtendedWebElement(PAGINATION_PREVIOUS_BUTTON__BOTTOM_ENABLED_LOC).click();
			}
			else if (new ExtendedWebElement(PAGINATION_PREVIOUS_BUTTON_BOTTOM_DISABLED_LOC).isPresent())
			{
				driver.getAssertionService().addAssertionLog("Previous button is not enabled, already on first page", MessageTypes.Pass);
			}
			else
			{
				driver.getAssertionService().addAssertionLog("Something went wrong, please check", MessageTypes.Fail);
			}
		}
		
		
		//click on first page button
		public void goToFirstPage()
		{
			addStaticWait(2000);
			if (new ExtendedWebElement(PAGINATION_FIRST_BUTTON_BOTTOM_ENABLED_LOC).isPresent())
			{
				driver.getAssertionService().addAssertionLog("Move to first page button is enabled, clicking on it", MessageTypes.Pass);
				new ExtendedWebElement(PAGINATION_FIRST_BUTTON_BOTTOM_ENABLED_LOC).click();
			}
			else if (new ExtendedWebElement(PAGINATION_FIRST_BUTTON_BOTTOM_DISABLED_LOC).isPresent())
			{
				driver.getAssertionService().addAssertionLog("Move to first page button is not enabled, already on first page", MessageTypes.Pass);
			}
			else
			{
				driver.getAssertionService().addAssertionLog("Something went wrong, please check", MessageTypes.Fail);
			}
		}
		
		//click on last page button
		public void goToLastPage()
		{
			addStaticWait(2000);
			if (new ExtendedWebElement(PAGINATION_LAST_BUTTON_BOTTOM_ENABLED_LOC).isPresent())
			{
				driver.getAssertionService().addAssertionLog("Move to last page button is enabled, clicking on it", MessageTypes.Pass);
				new ExtendedWebElement(PAGINATION_LAST_BUTTON_BOTTOM_ENABLED_LOC).click();
			}
			else if (new ExtendedWebElement(PAGINATION_LAST_BUTTON_BOTTOM_DISABLED_LOC).isPresent())
			{
				driver.getAssertionService().addAssertionLog("Move to last page button is not enabled, already on last page", MessageTypes.Pass);
			}
			else
			{
				driver.getAssertionService().addAssertionLog("Something went wrong, please check", MessageTypes.Fail);
			}
		}
		
		//verifyLastRefresh is present on page
		public void verifyLastRefresh()
		{
			for (int i=1;i<=30;i++)
			{
				if (new ExtendedWebElement(LAST_REFRESH_BUTTON_LOC).isPresent())
				{
					driver.getAssertionService().addAssertionLog("Last refresh is present on page", MessageTypes.Pass);
					break;
				}
				else
				{
					addStaticWait(1000);
					driver.getAssertionService().addAssertionLog("Waiting for last refresh", MessageTypes.Info);
				}
			}
		}
		
		public void clickRefreshButton()
		{
			driver.getAssertionService().assertElementPresent(By.xpath(REFRESH_BUTTON_LOC), "Refresh Button");
			new ExtendedWebElement(REFRESH_BUTTON_LOC).click();
			driver.getAssertionService().addAssertionLog("Refresh button is clicked", MessageTypes.Info);
		}
		
		public void verifyRefreshDisabled()
		{
			driver.getAssertionService().assertElementPresent(By.xpath(REFRESH_BUTTON_DISABLED_LOC), "Disabled Refresh Button");
		}
		
}