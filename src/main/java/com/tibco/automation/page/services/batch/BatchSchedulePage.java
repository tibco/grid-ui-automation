package com.tibco.automation.page.services.batch;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
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

public class BatchSchedulePage extends TemplatePage implements Locators.BatchScheduleLocators,Locators.EngineAdminPageLocators,Locators.ComponentsPageLocators, Locators.CommonLocators{


	public DataGrid datagrid; // these are class references
	public ExtendedWebDriver driver;
	public String pageTitle ="Services";
	public TemplatePage templatePage;
	public TopPaginate topPaginate;
	public static String parentHandle="";
	
	public BatchSchedulePage() {
		super("Batch Schedule", GSMenu.BatchSchedule);
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
	
	public void verifyRefreshButton()
	{
		driver.getAssertionService().assertTrue((new ExtendedWebElement((REFRESHBUTTON)).isPresent()), "Refresh Button is not present on page", "Refresh Button is present on page");
	}
	
	public void verifyRemoveColumn()
	{
		driver.getWaitUtility().waitForElementPresent(ADD_COL_LOC);
		driver.getAssertionService().assertTrue((new ExtendedWebElement((ADD_COL_LOC)).isPresent()), "Add column option is not present on page", "Add column option is present on page");
		
		driver.findElement(ADD_COL_LOC).click();
	
		driver.getWaitUtility().waitForElementPresent(REMOVE_COL_OPT_LOC);
		new ExtendedWebElement(REMOVE_COL_OPT_LOC).click();	
		
		
	}
	
	
	public void verifyAddColumn()
	{
		driver.getWaitUtility().waitForElementPresent(ADD_COL_LOC);
		driver.getAssertionService().assertTrue((new ExtendedWebElement((ADD_COL_LOC)).isPresent()), "Add column option is not present on page", "Add column option is present on page");
		driver.findElement(ADD_COL_LOC).click();
		driver.getWaitUtility().waitForElementPresent(ADD_OPT);
		;
		 driver.getAssertionService().assertTrue((new ExtendedWebElement((BATCH_ID)).isPresent()), "Option is not added", "Option is added");
			
		driver.getWaitUtility().waitForElementPresent(SAVE_COL_BUTTON_LOC);
		
	    driver.findElement(SAVE_COL_BUTTON_LOC).click();
	   
		
	}
	
	
	public void verifyRevertColumn()
	{
		
		driver.getWaitUtility().waitForElementPresent(ADD_COL_LOC);
		driver.getAssertionService().assertTrue((new ExtendedWebElement((ADD_COL_LOC)).isPresent()), "Add column option is not present on page", "Add column option is present on page");
		driver.findElement(ADD_COL_LOC).click();
		driver.getWaitUtility().waitForElementPresent(ADD_OPT);

		driver.findElement(ADD_OPT).click();
	   driver.getWaitUtility().waitForElementPresent(REVERT_BUTTON_LOC);
		
	    driver.findElement(REVERT_BUTTON_LOC).click();
	    
		
		driver.getAssertionService().assertTrue((new ExtendedWebElement((REMOVE_COL_OPT_LOC)).isPresent()), "Revert is not successfull", "Revert is successfull");
		
	
	    
		
	}
	public void verifyColumnRemove()
	{
		driver.getAssertionService().assertFalse((new ExtendedWebElement((BATCH_ID)).isPresent()), "Column is not removed from the page", "Column is removed from the page");
		
	}
	public void verifyLocalAction()
	{
		driver.getWaitUtility().waitForElementPresent(LOCAL_ACTION_LOC);
		new ExtendedWebElement(LOCAL_ACTION_LOC).click();
		
			driver.getAssertionService().assertTrue(new ExtendedWebElement(LOCAL_ACTION_LOC).isPresent(), "Local actions link is not present", "Local actions link is present");
		
	
	}
	
	public void clickGlobalAction()
	{
		
		driver.getWaitUtility().waitForElementPresent(GLOBAL_ACTION_LOC);
		new ExtendedWebElement(GLOBAL_ACTION_LOC).click(); 
		
		driver.getAssertionService().assertTrue(new ExtendedWebElement(GLOBAL_ACTION_LOC).isPresent(), "Global actions link is not present", "Global actions link is present");
		
	}
	public void verifyCreateNewBatch()	
	{
		
		driver.getWaitUtility().waitForElementPresent(CREATE_NEW_BATCH);
		new ExtendedWebElement(CREATE_NEW_BATCH).click(); 
		driver.getAssertionService().assertElementPresent(By.xpath(ADD_BUTTON_LOC), "ADD button is available");
		
	}
	
	public void verifyRemoveFinishedBatch()
	{
		
		driver.getWaitUtility().waitForElementPresent(REMOVE_FINISHED_BATCH_LOC);
		new ExtendedWebElement(REMOVE_FINISHED_BATCH_LOC).click(); 
		
		
	}
	
	public void verifySuspendBatchonPage()
	{

		driver.getWaitUtility().waitForElementPresent(SUSPEND_ALL_BATCH_ON_PAGE_LOC);
		new ExtendedWebElement(SUSPEND_ALL_BATCH_ON_PAGE_LOC).click(); 
		
		
	}
	public void verifySuspendBatch()
	{
		driver.getWaitUtility().waitForElementPresent(SUSPEND_ALL_BATCH_LOC);
		new ExtendedWebElement(SUSPEND_ALL_BATCH_LOC).click(); 
		driver.getAssertionService().assertElementPresent(By.xpath(SUSPEND_ALL_BATCH_LOC), "Suspend all batch ");
		
	}
	
	
	public void clickonBatchSchedule()
	{
		driver.getWaitUtility().waitForElementPresent(BATCH_SCHEDULE_LOC);
		new ExtendedWebElement(BATCH_SCHEDULE_LOC).click(); 
		
	}
	public void doubleLClickOnBatch()
	{
		driver.getWaitUtility().waitForElementPresent(BATCH_SCHEDULE_LOC);
		new ExtendedWebElement(BATCH_SCHEDULE_LOC).click(); 
		new ExtendedWebElement(BATCH_SCHEDULE_LOC).click(); 
		
	}
	
	
	
	
	public void verifySearchLogs()
	{
		
		driver.getWaitUtility().waitForElementPresent(SEARCH_LOGS_LOC);
		new ExtendedWebElement(SEARCH_LOGS_LOC).click();
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); 
		    driver.manage().window().maximize();
		}
		driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath("//code[@class='logExcerpts']"))).isDisplayed(), "Search log is not displayed", "Search log is displayed");				
	//driver.getAssertionService().assertElementPresent(By.xpath("//code[@class='logExcerpts']"), "CalculatorServiceExample");
		
	}
	public void switchToParentWindow()
	{
		driver.switchTo().window(parentHandle);
	}
	   
	
	

	
	public void selectQueryBuilder() {
		// TODO Auto-generated method stub
		
			driver.getAssertionService().addAssertionLog("Performing query builder search", MessageTypes.Info);
			driver.getAssertionService().assertElementPresent(By.xpath(SEARCH_TYPE_BUTTON_LOC), "Search Type Button");
			new ExtendedWebElement(SEARCH_TYPE_BUTTON_LOC).click();
			driver.getAssertionService().addAssertionLog("Search Type button is clicked", MessageTypes.Info);
			driver.getWaitUtility().waitForElementPresent(String.format(SEARCH_TYPE_ITEM_LOC, "Query Builder"));
			driver.getAssertionService().assertElementPresent(By.xpath(String.format(SEARCH_TYPE_ITEM_LOC, "Query Builder")), "Query Builder search type");
			new ExtendedWebElement(String.format(SEARCH_TYPE_ITEM_LOC, "Query Builder")).click();
			driver.getAssertionService().addAssertionLog("Query Builder search type is selected", MessageTypes.Info);
		}

	public boolean isAlertPresent(){
		try{
		driver.switchTo().alert();
		return true;
		}catch(NoAlertPresentException ex){
		return false;
		}
	}
	public void verifyRemoveBatch() {
		// TODO Auto-generated method stub
		
		
		driver.getWaitUtility().waitForElementPresent(REMOVE_BATCH_LOC);
	
		new ExtendedWebElement(REMOVE_BATCH_LOC).click();
		
		if(isAlertPresent()){
			driver.getAssertionService().addAssertionLog("Alert is present", MessageTypes.Info);
			
			Alert alert = driver.switchTo().alert();
		
			System.out.println(alert.getText());
		
			alert.accept();
			
			}
		
		
	}


	public void clickonBatchDefination() {
		// TODO Auto-generated method stub
		
	
		driver.getWaitUtility().waitForElementPresent(BATCH_DEFINATION_PAGE_LOC);
		new ExtendedWebElement(BATCH_DEFINATION_PAGE_LOC).click();
		
		
	}


	public void verifyBatchIsPresent(String definitionName) {
		// TODO Auto-generated method stub
		
	
			// TODO Auto-generated method stub
	
	
			driver.getAssertionService().assertElementPresent(By.xpath(BATCH_DEF), "Batch is removed");
			
		}


	public void clickonBatchSchedulePage() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent("//a[contains(text(),'Batch Schedule')]");
		new ExtendedWebElement("//a[contains(text(),'Batch Schedule')]").click();
	}


	public void selectBatch(String definitionName) {
		// TODO Auto-generated method stub
		
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(BATCH_LOC, definitionName))));
		
		new ExtendedWebElement(String.format(BATCH_LOC, definitionName)).click();
		
		driver.getAssertionService().addAssertionLog("Selecting checkbox for definition ", MessageTypes.Info);
	}
		
	
	
	
	public void removeBatch(String actionLocator)
	{
		
		
			driver.getWaitUtility().waitForElementPresent(LOCAL_ACTION_LINK_LOC);
			WebElement ele = driver.findElement(By.xpath(LOCAL_ACTION_LINK_LOC));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", ele);
			driver.getAssertionService().assertElementPresent(By.xpath(LOCAL_ACTION_ITEM_LOC), "Local action item "+actionLocator);
			new ExtendedWebElement(String.format(LOCAL_ACTION_ITEM_LOC, actionLocator)).click();
			driver.getAssertionService().addAssertionLog("Local action "+actionLocator+" is selected", MessageTypes.Info);
		
		
			
			}


	public void verifyBatchIsNotPresent(String definitionName) {
		// TODO Auto-generated method stub
		{
			
			
			driver.getAssertionService().assertElementNotPresent(By.xpath(String.format(BATCH_NAME_LOC, definitionName)), definitionName);
		}
	}
	
	public void verifyBatchAdminPageIsLaunched()
	{
		driver.getWaitUtility().waitForElementPresent(BATCH_ADMIN_VERIFICATION_LOC);
		driver.getAssertionService().assertElementPresent(By.xpath(BATCH_ADMIN_VERIFICATION_LOC), "Batch Admin Page");
	}

	
	
	
	public void addDescription(String description)
	{
		
	
		driver.getWaitUtility().waitForElementPresent(DESCRIPTION_INPUT_LOC);
		new ExtendedWebElement(DESCRIPTION_INPUT_LOC).sendKeys(description);
		driver.getAssertionService().addAssertionLog("Description set to "+description, MessageTypes.Info);
	}
	
	public void verifyDescriptionIsPresent(String definitionName,String description)
	{
		driver.getAssertionService().assertElementPresent(By.xpath(String.format(DESCRIPTION_VALUE_LOC, description)), description);
	}
	
	public void verifyDescriptionIsNotPresent(String definitionName,String description)
	{
		driver.getAssertionService().assertElementNotPresent(By.xpath(String.format(DESCRIPTION_VALUE_LOC, description)), description+"is added for "+definitionName);
	}
	
	
	public void clickOnSaveButton()
	{
		driver.getWaitUtility().waitForElementPresent(SAVE_BUTTON_LOC);
		new ExtendedWebElement(SAVE_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Save button clicked", MessageTypes.Info);
	}
	
	
	public void clickonCancel()
	{
		driver.getWaitUtility().waitForElementPresent(CANCEL_BUTTON_LOC);
		new ExtendedWebElement(CANCEL_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Save button clicked", MessageTypes.Info);
	}
	
	
	public void waitforElement()
	{
		driver.getWaitUtility().waitForElementPresent(GLOBAL_ACTION);
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


	public void closeWindow() {
		// TODO Auto-generated method stub
		driver.close();
	}
	}
	
	
	
	
	
	
	
	
	

