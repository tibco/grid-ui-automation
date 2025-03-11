package com.tibco.automation.page.admin.systemadmin;

import org.openqa.selenium.By;

import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.Locators;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.common.TopPaginate;

public class EmailNotificationsPage extends TemplatePage implements Locators.EmailNotificationPageLocators{

	public DataGrid datagrid; // these are class references
	public ExtendedWebDriver driver;
	public String pageTitle ="System Admin";
	public TemplatePage templatePage;
	public TopPaginate topPaginate;
	public static String parentHandle;
	public EmailNotificationsPage() {
		super("Email Notifications", GSMenu.EmailNotification);
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
	
	public void clickAddColumn()
	{
		driver.getAssertionService().assertTrue((new ExtendedWebElement(ADD_COLUMN_LOC)).isPresent(), "Add column option is not present", "Add column option is present");
		new ExtendedWebElement(ADD_COLUMN_LOC).click();
		driver.getAssertionService().assertTrue((new ExtendedWebElement(SAVE_BUTTON_ADD_COLUMN_LOC)).isDisplayed(), "Add column option is not clicked", "Add column option is clicked");
	}
	
	// get current window handle
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
		
		
	public void addNewColumn(String columnName)
	{
		String value=null;
		switch(columnName)
		{
		case "E-Mail Address":
		{
			value="subemail";
			break;
		}
		case "Filter":
		{
			value="subfilter";
			break;
		}
		case "Subscriptions":
		{
			value="subevents";
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
		case "E-Mail Address":
		{
			value="subemail";
			break;
		}
		case "Filter":
		{
			value="subfilter";
			break;
		}
		case "Subscriptions":
		{
			value="subevents";
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
	
	
	
	public void fillSubscriberDetails(String email,String filter)
	{
		driver.getWaitUtility().waitForElementPresent(EMAIL_CREATE_NEW_SUB_POPUP_LOC);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(EMAIL_CREATE_NEW_SUB_POPUP_LOC).isPresent(), "Create new subscriber page is launched");
		new ExtendedWebElement(EMAIL_CREATE_NEW_SUB_POPUP_LOC).sendKeys(email);
		new ExtendedWebElement(FILTER_CREATE_NEW_SUB_POPUP_LOC).sendKeys(filter);
		new ExtendedWebElement(SERVICE_CHECK_CREATE_NEW_SUB_LOC).click();
	}
	
	
	public void updateSubscriberDetails(String email)
	{
		driver.getWaitUtility().waitForElementPresent(BROKER_ADDED_CHECK_CREATE_NEW_SUB_LOC);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(BROKER_ADDED_CHECK_CREATE_NEW_SUB_LOC).isPresent(), "Create new subscriber page is launched");
		new ExtendedWebElement(BROKER_ADDED_CHECK_CREATE_NEW_SUB_LOC).click();
		driver.getAssertionService().addAssertionLog("Updated subscriber "+email+", selected event Broker Added", MessageTypes.Info);
	}
	
	
	public void verifyUpdatedSubscriberDetails(String email)
	{
		driver.getAssertionService().assertTrue(new ExtendedWebElement(String.format(UPDATED_EVENT_VERIFY_LOC, email)).isDisplayed(), "Subscriber with email "+email+" is not updated with event broker added", "Subscriber with email "+email+" is updated with event broker added");
	}
	
	
	public void verifySubscriberDetailsNotUpdated(String email)
	{
		driver.getAssertionService().assertFalse(new ExtendedWebElement(String.format(UPDATED_EVENT_VERIFY_LOC, email)).isPresent(), "Subscriber with email "+email+" is updated with event broker added", "Subscriber with email "+email+" is not updated with event broker added");
	}
	
	public void submitSubscriberDetails()
	{
		new ExtendedWebElement(SUBMIT_BUTTON_CREATE_NEW_SUB_POPUP_LOC).click();
	}
	
	
	public void clickCancelOnAddSubscriber()
	{
		new ExtendedWebElement(CANCEL_BUTTON_CREATE_NEW_SUB_POPUP_LOC).click();
	}
	
	
	public void verifySubscriberPresent(String email)
	{
		driver.getAssertionService().assertTrue(new ExtendedWebElement(String.format(ADDED_SUBSCRIBER_VALUE_LOC, email)).isDisplayed(), "Subscriber with email "+email+" is not present", "Subscriber with email "+email+" is present");
	}
	
	
	public void verifySubscriberNotPresent(String email)
	{
		driver.getAssertionService().assertElementNotPresent(By.xpath(ADDED_SUBSCRIBER_VALUE_LOC), email);
	}
	
	
	public void selectSubscriber(String email)
	{
		new ExtendedWebElement(String.format(SUBSCRIBER_CHECK_BOX_LOC, email)).click();
		driver.getAssertionService().addAssertionLog("Subscriber with mail "+email+"is selected", MessageTypes.Info);
	}
	
	
	public void verifySimpleSearchResult(String searchString,String noOfRows)
	{
		driver.getAssertionService().assertElementPresent(By.xpath(ADD_COLUMN_LOC), "Add column option");
		driver.getAssertionService().assertTrue(new ExtendedWebElement(String.format(ADDED_SUBSCRIBER_VALUE_LOC, searchString)).isDisplayed(), "Searched string "+searchString+"is filtered");
		driver.getAssertionService().assertTrue(new ExtendedWebElement(String.format(TOTAL_ROWS_AFTER_SEARCH_LOC, noOfRows)).isDisplayed(), "Number of rows is "+noOfRows);
	}
	
	public void verifyQuerySearchResult(String noOfRows)
	{
		driver.getAssertionService().assertElementPresent(By.xpath(ADD_COLUMN_LOC), "Add column option");
		driver.getAssertionService().assertTrue(new ExtendedWebElement(String.format(TOTAL_ROWS_AFTER_SEARCH_LOC, noOfRows)).isDisplayed(), "Number of rows is "+noOfRows);
	}
	
	public void verifyQueryBuilderSearchResult(String noOfRows)
	{
		driver.getAssertionService().assertTrue(new ExtendedWebElement(String.format(TOTAL_ROWS_AFTER_SEARCH_LOC, noOfRows)).isDisplayed(), "Number of rows is "+noOfRows);
	}
	
	public void showingResults()
	{
		driver.getWaitUtility().waitForElementPresent(SHOWING_RESULTS_LOC);
		String s= new ExtendedWebElement(SHOWING_RESULTS_LOC).getText();
		driver.getAssertionService().addAssertionLog("Showing "+s+" results", MessageTypes.Info);
	}
	
	
	
}
 