package com.tibco.automation.page.services.services;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.Locators;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.common.TopPaginate;
import com.tibco.automation.page.common.TemplatePage.GSMenu;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;	
	public class ServiceSessionAdminPage extends TemplatePage implements Locators,Locators.CommonLocators,Locators.ServiceSessionAdmin{

		public DataGrid datagrid; // these are class references
		public ExtendedWebDriver driver;
		public String pageTitle ="Services";
		public TemplatePage templatePage;
		public TopPaginate topPaginate;
		public static String parentHandle="";
		public static String winHandleBefore;
		public String parentWinHandle;
		public ServiceSessionAdminPage() {
			super("Service Session Admin", GSMenu.ServiceSessionAdmin);
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


		public void verifyRefreshButton() {
			
				driver.getAssertionService().assertTrue((new ExtendedWebElement((REFRESHBUTTON)).isPresent()), "Refresh Button is not present on page", "Refresh Button is present on page");
			}


		public void verifyRemoveColumn() {
			
				driver.getWaitUtility().waitForElementPresent(ADD_COL_LOC);
				driver.getAssertionService().assertTrue((new ExtendedWebElement((ADD_COL_LOC)).isPresent()), "Add column option is not present on page", "Add column option is present on page");
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", new ExtendedWebElement(REMOVE_SESSIONID_LOC));
				//driver.findElement(REMOVE_SESSIONID_LOC).click();
				
				
			}


		  public void verifySimpleSearch() 
		  {
			boolean X=new ExtendedWebElement(String.format(INVALID)).isPresent();
			driver.getAssertionService().assertTrue(X, "Simple search fail", "Performed simple search successfully");
			
		
		}
	  public void clearSearch()
		{
			driver.getWaitUtility().waitForElementPresent(CLEAR);
			driver.findElement(CLEAR).click();
			
		}
	  
	  public void verifyPerformQuerySearch()
		{
			boolean X=new ExtendedWebElement(String.format(INVALID)).isPresent();
			driver.getAssertionService().assertTrue(X, "Query search fail", "Performed Query search successfully");
		}


	public void waitforElement()
	{
		driver.getWaitUtility().waitForElementPresent(GLOBAL_ACTION);
	
	}


	public void clickonGlobalAction() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(GLOBAL_ACTION);
		driver.findElement(By.xpath(GLOBAL_ACTION)).click();	
		driver.getAssertionService().assertTrue(new ExtendedWebElement(GLOBAL_ACTION).isPresent(), "Global actions link is not present", "Global actions link is present");
		
	}


	public void clickOnExpandAll() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(EXPAND_ALL_LOC);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(EXPAND_ALL_LOC).isPresent(), "Expand all is not present", "Expand all  is present");
		
		driver.findElement(By.xpath(EXPAND_ALL_LOC)).click();	
		
	}


	public void verifyExpandAll() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(VERIFY_EXPAND_ALL_LOC);
		driver.findElement(By.xpath(VERIFY_EXPAND_ALL_LOC)).click();	
		driver.getAssertionService().assertTrue(new ExtendedWebElement(VERIFY_EXPAND_ALL_LOC).isPresent(), "Expand all is not working", "Expand all  is working");
		
	}


	public void clickOnCollapseAll() {
		// TODO Auto-generated method stub		
		driver.getWaitUtility().waitForElementPresent(COLLAPSE_ALL_LOC);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(COLLAPSE_ALL_LOC).isPresent(), "Collapse all is not present", "Collapse all  is present");
		
		driver.findElement(By.xpath(COLLAPSE_ALL_LOC)).click();
	}


	public void verifyCollapseAll() {
		// TODO Auto-generated method stub
		
		driver.getAssertionService().assertFalse(new ExtendedWebElement(VERIFY_EXPAND_ALL_LOC).isPresent(), "Collapse all is not working", "Collapse all  is working");

		
		
	}


	public void clickOnRemoveFinishServices() {
		// TODO Auto-generated method stub
		
		driver.getWaitUtility().waitForElementPresent(REMOVE_FINISH_SERVICE_SESSION_LOC);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(REMOVE_FINISH_SERVICE_SESSION_LOC).isPresent(), "Remove finish services session is not present", "Remove finish services session is present");
		
		driver.findElement(By.xpath(REMOVE_FINISH_SERVICE_SESSION_LOC)).click();	

	}


	public void verifyRemoveFinishServiceOnPage() {
		// TODO Auto-generated method stub
		driver.getAssertionService().assertFalse(new ExtendedWebElement(SERVICE_STATUS_LOC).isPresent(), "Finish service sessions are not removed ", "Finish service sessions are removed");

		
	}


	public void clickonServiceSession() {
		// TODO Auto-generated method stub
		
		driver.getWaitUtility().waitForElementPresent(SERVICE_SESSION_CHECKBOX);
		new ExtendedWebElement(SERVICE_SESSION_CHECKBOX).click();
		driver.getAssertionService().assertTrue(new ExtendedWebElement(SERVICE_SESSION_CHECKBOX).isPresent(), "Service session is not present", "Service session is present");
		
	}


	public void verifyLocalAction() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(LOCAL_ACTION_LOC);
		new ExtendedWebElement(LOCAL_ACTION_LOC).click();
		driver.getAssertionService().assertTrue(new ExtendedWebElement(LOCAL_ACTION_LOC).isPresent(), "Local actions link is not present", "Local actions link is present");
		
	
		
	}	
	
	public boolean isAlertPresent(){
		try{
		driver.switchTo().alert();
		return true;
		}catch(NoAlertPresentException ex){
		return false;
		}
	}


	public void doubleClickOnServiceSession() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(SERVICE_SESSION_CHECKBOX);
		new ExtendedWebElement(SERVICE_SESSION_CHECKBOX).click();
		new ExtendedWebElement(SERVICE_SESSION_CHECKBOX).click();
	}


	public void clickOnCancelAllSessionOnPage() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(CANCEL_ALL_SESSION_ON_PAGE);
		new ExtendedWebElement(CANCEL_ALL_SESSION_ON_PAGE).click();
		
		if(isAlertPresent()){
			driver.getAssertionService().addAssertionLog("Alert is present", MessageTypes.Info);
			
			Alert alert = driver.switchTo().alert();
		
			System.out.println(alert.getText());
		
			alert.accept();
			
			}
	}


	public void verifyCancelOnPage() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(CANCEL_STATUS);
		new ExtendedWebElement(CANCEL_STATUS).click();
		driver.getAssertionService().assertTrue(new ExtendedWebElement(CANCEL_STATUS).isPresent(), "Cancel session on page is not working", "Cancel session on page is working" );
		
	}


	public void clickOnCancelAllSession() {
		// TODO Auto-generated method stub
		
		
		if(isAlertPresent()){
			driver.getAssertionService().addAssertionLog("Alert is present", MessageTypes.Info);
			
			Alert alert = driver.switchTo().alert();
		
			System.out.println(alert.getText());
		
			alert.accept();
			
			}

	}


	public void verifyCancelAllSession() {
		// TODO Auto-generated method stub
	//	driver.getWaitUtility().waitForElementPresent(RUNNING_STATUS);
		driver.getAssertionService().assertFalse(new ExtendedWebElement(RUNNING_STATUS).isPresent(), "Cancel all service session is not working", "Cancel all service session is working");
		
	
	}


	public void setPriorityOnPage() {
		// TODO Auto-generated method stub
	
		
		driver.getWaitUtility().waitForElementPresent(URGENT_PRIORITY_LOC);
		new ExtendedWebElement(URGENT_PRIORITY_LOC).click();
		driver.getAssertionService().assertTrue(new ExtendedWebElement(SET_PRIORITY_ON_PAGE).isPresent(), "Urgent priority radio button is not working", "Urgent priority radio button is working" );

		
		driver.getWaitUtility().waitForElementPresent(SAVE_BUTTON_LOC);
		new ExtendedWebElement(SAVE_BUTTON_LOC).click();
		
	}


	public void verifyPrioritySet() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(PRIORITY_LOC);
	
		driver.getAssertionService().assertTrue(new ExtendedWebElement(PRIORITY_LOC).isPresent(), "Urgent priority is not set", "Urgent priority is set" );	
	}


	public void clickOnLocalAction() {
		// TODO Auto-generated method stub
		
		driver.getWaitUtility().waitForElementPresent(LOCAL_ACTION_LOC);
     	new ExtendedWebElement(LOCAL_ACTION_LOC).click();
		driver.getAssertionService().assertTrue(new ExtendedWebElement(LOCAL_ACTION_LOC).isPresent(), "Local Action Link is not clicked", "Local action link is clicked" );	
		
	}
	

	public void verifySeviceSessionDetails() {
		// TODO Auto-generated method stub
		
		driver.getAssertionService().assertTrue(new ExtendedWebElement(VERIFY_EXPAND_ALL_LOC).isPresent(), "Service Session Details are not displayed", "Service Session Details are displayed");

		
		
	}


	public void verifyViewServiceSession() {
		// TODO Auto-generated method stub
		winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); 
		    driver.manage().window().maximize();
		}
		 driver.manage().timeouts().setScriptTimeout(3, TimeUnit.MINUTES);
		 addStaticWait(30000);
		driver.getWaitUtility().waitForElementPresent(CHART_LOC);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(CHART_LOC).isPresent(), "View Service Session Details is not working", "View Service Sessions is working");

		
	}
	public void switchToMainWindow()
	{
		driver.switchTo().window(winHandleBefore);
		driver.getAssertionService().addAssertionLog("Navigated to parent window", MessageTypes.Info);
	}

	public void verifySearchLogs() {
		// TODO Auto-generated method stub
		driver.manage().window().maximize();
		String winHandleBefore = driver.getWindowHandle();

	    for (String winHandle : driver.getWindowHandles()) {
	        driver.switchTo().window(winHandle);
	    }
	    
	    driver.manage().timeouts().setScriptTimeout(3, TimeUnit.MINUTES);
		 addStaticWait(30000);

			driver.getWaitUtility().waitForElementPresent(SEARCH_LOGS_LOC);
			driver.getAssertionService().assertTrue(new ExtendedWebElement(SEARCH_LOGS_LOC).isPresent(), "Search logs is not working", "Search logs is working");

	}


	public void verifyRemoveFinishService() {
		// TODO Auto-generated method stub
		
		if(isAlertPresent()){
			driver.getAssertionService().addAssertionLog("Alert is present", MessageTypes.Info);
			
			Alert alert = driver.switchTo().alert();
		
			System.out.println(alert.getText());
		
			alert.accept();
			
			}

		driver.getAssertionService().assertTrue(new ExtendedWebElement(SERVICE_STATUS_LOC).isPresent(), "Finish service sessions are not removed ", "Finish service sessions are removed");

		
	}


	public void clickOnServiceTestPage() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(SERVICE_TEST_PAGE_LINK);
		new ExtendedWebElement(SERVICE_TEST_PAGE_LINK).click();
		
	}


	public void verifyTaskAdmin() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(SERVICE_NAME_LOC);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(SERVICE_NAME_LOC).isPresent(), "Task Admin is not working", "Task Admin is working");

		
	}


	public void verifyCancelServiceSession() {
		// TODO Auto-generated method stub
		if(isAlertPresent()){
			driver.getAssertionService().addAssertionLog("Alert is present", MessageTypes.Info);
			
			Alert alert = driver.switchTo().alert();
		
			System.out.println(alert.getText());
		
			alert.accept();
			
			}
		driver.getWaitUtility().waitForElementPresent(CANCEL_SERVICE_STATUS);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(CANCEL_SERVICE_STATUS).isPresent(), "Cancel service session is not working", "Cancel service session is working");
		
	}


	public void setPriority() {
		// TODO Auto-generated method stub

		driver.getWaitUtility().waitForElementPresent(URGENT_PRIORITY_LOC);
		new ExtendedWebElement(URGENT_PRIORITY_LOC).click();
		driver.getAssertionService().assertTrue(new ExtendedWebElement(SET_PRIORITY_ON_PAGE).isPresent(), "Urgent priority radio button is not working", "Urgent priority radio button is working" );

		driver.getWaitUtility().waitForElementPresent(SAVE_BUTTON_LOC);
		new ExtendedWebElement(SAVE_BUTTON_LOC).click();
		
	}
	public void switchToParentWindow()
	{
		driver.switchTo().window(parentHandle);
	}
	
	public void switchToNewlyOpenedWindow()
	{
		winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		    driver.manage().window().maximize();
		}
	}


	public void verifyAddColumn() {
		// TODO Auto-generated method stub
		
		driver.getWaitUtility().waitForElementPresent(ADD_COL_LOC);
		driver.getAssertionService().assertTrue((new ExtendedWebElement((ADD_COL_LOC)).isPresent()), "Add column option is not present on page", "Add column option is present on page");
		driver.findElement(ADD_COL_LOC).click();
		driver.getWaitUtility().waitForElementPresent(ADD_APPLICATION_DESCRIPTION_LOC);
		
		driver.getWaitUtility().waitForElementPresent(ADD_APPLICATION_DESCRIPTION_LOC);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", new ExtendedWebElement(ADD_APPLICATION_DESCRIPTION_LOC));
		//new ExtendedWebElement(ADD_APPLICATION_DESCRIPTION_LOC).click();
		driver.getAssertionService().assertTrue(new ExtendedWebElement(REMOVE_APPLICATION_DESCRIPTION_LOC).isPresent(), "Application description is not added", "Application description is added" );
		driver.getWaitUtility().waitForElementPresent(SAVE_BUTTON);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(SAVE_BUTTON).isPresent(), "Save button is not working", "Save button is working"); 
		new ExtendedWebElement(SAVE_BUTTON).click();
		
	}


	public void verifyRevertColumn() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(ADD_COL_LOC);
		driver.getAssertionService().assertTrue((new ExtendedWebElement((ADD_COL_LOC)).isPresent()), "Add column option is not present on page", "Add column option is present on page");
		driver.findElement(ADD_COL_LOC).click();
		driver.getWaitUtility().waitForElementPresent(REMOVE_APPLICATION_DESCRIPTION_LOC);
		driver.getAssertionService().assertTrue((new ExtendedWebElement((REMOVE_APPLICATION_DESCRIPTION_LOC)).isPresent()), "Remove opt is not working", "Remove opt is working");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", new ExtendedWebElement(REMOVE_APPLICATION_DESCRIPTION_LOC));
		//driver.findElement(REMOVE_APPLICATION_DESCRIPTION_LOC).click();
		waitForPageToLoad();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        driver.getWaitUtility().waitForElementPresent(ADD_APPLICATION_DESCRIPTION_LOC);
		
		driver.getWaitUtility().waitForElementPresent(ADD_APPLICATION_DESCRIPTION_LOC);
		//JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", new ExtendedWebElement(ADD_APPLICATION_DESCRIPTION_LOC));
		//new ExtendedWebElement(ADD_APPLICATION_DESCRIPTION_LOC).click();
		driver.getWaitUtility().waitForElementPresent(REVERT_BUTTON_LOC);
		new ExtendedWebElement(REVERT_BUTTON_LOC).click();
		
		driver.getAssertionService().assertTrue(new ExtendedWebElement(ADD_APPLICATION_DESCRIPTION_LOC).isPresent(), "Revert button is not working", "Revert button is working" );
		
	}


	public void clickOnSetPriorityOnPage() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(SET_PRIORITY_ON_PAGE);
		new ExtendedWebElement(SET_PRIORITY_ON_PAGE).click();
		driver.getAssertionService().assertTrue(new ExtendedWebElement(SET_PRIORITY_ON_PAGE).isPresent(), "Set priority on page is not working", "Set priority on page is working" );
	}

public void closeWindow()
{
	driver.close();
}
 
	
	}
	

