package com.tibco.automation.page.services.services;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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
	public class ServiceTypesPage extends TemplatePage implements Locators,Locators.CommonLocators,Locators.ServiceTypes{

		public DataGrid datagrid; // these are class references
		public ExtendedWebDriver driver;
		public String pageTitle ="Services";
		public TemplatePage templatePage;
		public TopPaginate topPaginate;
		public static String parentHandle="";
		
		public ServiceTypesPage() {
			super("Service Session Admin", GSMenu.ServiceTypes);
			System.out.println("GSMenu..!!");
			datagrid = new DataGrid();
			driver = getDriver();
			templatePage = new TemplatePage();
			topPaginate = new TopPaginate();
			System.out.println(" After GSMenu..!!");
		}
		

		
		
		@Override
		public boolean isPageActive(Object... object) {
			return super.verifyPageTitle(pageTitle);
			
		}

		@Override
		public void waitForPageToLoad() {
			super.waitForPageToLoad();
		}
		
		
	
		
		
		 public void verifyLocalActionDisable()
		 {
			 
			
			driver.getAssertionService().assertFalse(new ExtendedWebElement((LOCAL_ACTIONS)).isDisplayed(),"Local action is added", "Local action is not added");		
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




			public void clickOnSaveButton() {
				// TODO Auto-generated method stub
				driver.getWaitUtility().waitForElementPresent(SERVICETYPE_SAVE_BUTTON_LOC);
				 driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(SERVICETYPE_SAVE_BUTTON_LOC))).isDisplayed(),"Save button is not present", "Save button is present");		
					
				 driver.findElement(By.xpath(SERVICETYPE_SAVE_BUTTON_LOC)).click();
					
					
				}




			public void verifyAddedServiceTypeRegistry() {
				// TODO Auto-generated method stub
				driver.getWaitUtility().waitForElementPresent(SERVICE_TYPE_LOC);
				 driver.getAssertionService().assertTrue(new ExtendedWebElement(((SERVICE_TYPE_LOC))).isPresent(),"Service type is not present", "Service type is present");		
					
			}
				
			
	public void closeWindow()
	{
		
		driver.close();
	}
	public void provideServiceName(String servicetypeName) 
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//driver.getWaitUtility().waitForElementDisplayed(SERVICETYPENAME_INPUTBOX);
		driver.getWaitUtility().waitForElementVisible(SERVICETYPENAME_INPUTBOX);

		driver.findElement(By.xpath(SERVICETYPENAME_INPUTBOX)).sendKeys(servicetypeName);
		driver.getAssertionService().addAssertionLog("Setting service type name to "+servicetypeName, MessageTypes.Info);
		
		
	}
	public void clickOnAdd() 
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.getWaitUtility().waitForElementPresent(ADD_BUTTON_LOC);
		driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(ADD_BUTTON_LOC))).isPresent(),"Add button is not present", "Add button is present");		
		driver.findElement(By.xpath(ADD_BUTTON_LOC)).click();
	}
	public void verifyServiceTypeRegistryAdded(String servicetypeName) 
	{
		// TODO Auto-generated method stub
			driver.getWaitUtility().waitForElementPresent(String.format(SERVICE_TYPE_LOC, servicetypeName));
			driver.getAssertionService().assertElementPresent(By.xpath(String.format(SERVICE_TYPE_LOC, servicetypeName)), servicetypeName);
		}
		
	public void verifyServiceTypeRegistryNotAdded(String servicetypeName) 
	{
		driver.getAssertionService().assertElementNotPresent(By.xpath(String.format(SERVICE_TYPE_LOC, servicetypeName)), servicetypeName);
	}
	
	public void verifyExpandAllonAdd()
	{
	
	
		driver.getWaitUtility().waitForElementPresent(COLLAPSE_ALL_LOC);
		driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(COLLAPSE_ALL_LOC))).isPresent(),"Collapse all button is not present", "collapse All button is present");		
		
		driver.findElement(By.xpath(COLLAPSE_ALL_LOC)).click();
		driver.getWaitUtility().waitForElementPresent(EXPAND_ALL_LOC);
		driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(EXPAND_ALL_LOC))).isPresent(),"Expand all button is not present", "Expand All button is present");		
		
		driver.findElement(By.xpath(EXPAND_ALL_LOC)).click();
		driver.getWaitUtility().waitForElementPresent(INIT_METHOD_LOC);
		driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(INIT_METHOD_LOC))).isPresent(),"Service type is not Expanded", "Service type is Expanded");		
		
	}
	public void clickOnCancel()
  {
		driver.getWaitUtility().waitForElementPresent(SERVICETYPE_CANCLE_LOC);
		driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(SERVICETYPE_CANCLE_LOC))).isPresent(),"Cancel button is not present", "Cancel button is present");		
		
		driver.findElement(By.xpath(SERVICETYPE_CANCLE_LOC)).click();
		
  }
	public void verifyCollapseAllAdd() throws InterruptedException
	{
		driver.getWaitUtility().waitForElementPresent(COLLAPSE_ALL_LOC);
		driver.findElement(By.xpath(COLLAPSE_ALL_LOC)).click();
		driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(INIT_METHOD_LOC))).isPresent(),"Service type is  not Collapsed", "Service type is Collapsed");		
		
	}




	public void clickOnServiceTypesCheckbox(String servicetypeName) {
		// TODO Auto-generated method stub
		//driver.getWaitUtility().waitForElementPresent(String.format(NEW_SERVICE_TYPE_CHECKBOX, servicetypeName));
			new ExtendedWebElement(String.format(NEW_SERVICE_TYPE_CHECKBOX, servicetypeName)).click();
			driver.getAssertionService().addAssertionLog("Selecting checkbox for service type "+servicetypeName, MessageTypes.Info);
		}
		
	public void clickOnLocalAction()
	{
		driver.getWaitUtility().waitForElementPresent(LOCAL_ACTIONS);
		driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(LOCAL_ACTIONS))).isPresent(),"Local Action is not present", "Local Action is present");		
		 driver.findElement(By.xpath(LOCAL_ACTIONS)).click();
			
	}

	public void verifySidebar()
	{
		
		
		driver.findElement(By.xpath(SCROLLBAR)).click();
		driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(BATCH_DEF_LOC))).isPresent(),"Scrollbar is not clicked", "Scrollbar is clicked");		
		
	}
	public void verifyTooltip()
	{
		
		driver.getWaitUtility().waitForElementPresent(INITIALIZION_METHID_DESCRIPTION);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(INITIALIZION_METHID_DESCRIPTION).isDisplayed(), "Tooltip for description is not present", "Tooltip for description is present");
		
	}
	




	public void provideClassName(String className) {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(CLASS_NAME_LOC);
		driver.findElement(By.xpath(CLASS_NAME_LOC)).sendKeys(className);
		driver.getAssertionService().addAssertionLog("Setting service type class name to "+className, MessageTypes.Info);
	}




	public void editDescription(String description) {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(DESCRIPTION_INPUTBOX);
		new ExtendedWebElement(DESCRIPTION_INPUTBOX).sendKeys(description);
		driver.getAssertionService().addAssertionLog("Description set to "+description, MessageTypes.Info);
	}




	public void verifyDescriptionIsPresent(String servicetypeName, String description) {
		// TODO Auto-generated method stub
		
			driver.getAssertionService().assertElementPresent(By.xpath(String.format(DESCRIPTION_VALUE_LOC, description)), description);
		}



	public void getCurrentWindowHandle()
	{
		parentHandle = driver.getWindowHandle();
	}
	
	
	




	public void renameServiceType(String renameservicetype) {

		driver.getWaitUtility().waitForElementPresent(RENAME_INPUT_LOX);
		new ExtendedWebElement(RENAME_INPUT_LOX).clear();
		new ExtendedWebElement(RENAME_INPUT_LOX).sendKeys(renameservicetype);
		driver.getAssertionService().addAssertionLog("Service type is set to "+renameservicetype, MessageTypes.Info);
	}




	public void renameSave() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(RENAME_SAVE_BUTON_LOC);
		driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(RENAME_SAVE_BUTON_LOC))).isPresent(),"Save button is not present", "Save button is present");		
		
		new ExtendedWebElement(RENAME_SAVE_BUTON_LOC).click();
		
	}




	public void renameCancel() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(RENAME_CANCEL_LOC);
		driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(RENAME_CANCEL_LOC))).isPresent(),"Cancel button is not present", "Cancel button is present");			
		new ExtendedWebElement(RENAME_CANCEL_LOC).click();
		
	}




	
	}
	
	
	
	






		
