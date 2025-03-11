package com.tibco.automation.page.admin.systemadmin;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.page.common.CommonFunctions;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.Locators;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.common.TopPaginate;
import com.tibco.automation.page.common.TemplatePage.GSMenu;


public class ManagerHooksPage extends TemplatePage implements Locators.ManagerHooks
{
	public static String parentHandle="";
	public DataGrid datagrid; // these are class references
	public ExtendedWebDriver driver;
	public String pageTitle ="System Admin";
	public TemplatePage templatePage;
	public TopPaginate topPaginate;
    public String file;
    public CommonFunctions commonFunctions;
	
	public ManagerHooksPage() {
		super("Manager Hooks", GSMenu.ManagerHooks);
		
		datagrid = new DataGrid(); // as already defined above we are just intializing
		driver = getDriver();
		templatePage = new TemplatePage();
		topPaginate = new TopPaginate();
		commonFunctions=new CommonFunctions();
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
	
	public void clearSearch()
	{
		driver.getWaitUtility().waitForElementPresent(CLEAR);
		driver.findElement(CLEAR).click();
		
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

	public void verifyPerformQuerySearch()
	{
		boolean X=new ExtendedWebElement(String.format(INVALID)).isPresent();
		driver.getAssertionService().assertTrue(X, "Query search fail", "Performed Query search successfully");
	}

	public void verifyRemoveColumn()
	{
		
			driver.getWaitUtility().waitForElementPresent(ADD_BUTTON_LOC);
			driver.getAssertionService().assertTrue((new ExtendedWebElement((ADD_BUTTON_LOC)).isPresent()), "Add column option is not present on page", "Add column option is present on page");
			
			driver.findElement(ADD_BUTTON_LOC).click();
		
			driver.getWaitUtility().waitForElementPresent(REMOVE_COL_OPT_LOC);
			new ExtendedWebElement(REMOVE_COL_OPT_LOC).click();	
			
			
		}
	
	public void verifyAddColumn()
	{
		driver.getWaitUtility().waitForElementPresent(ADD_BUTTON_LOC);
		driver.getAssertionService().assertTrue((new ExtendedWebElement((ADD_BUTTON_LOC)).isPresent()), "Add column option is not present on page", "Add column option is present on page");
		driver.findElement(ADD_BUTTON_LOC).click();
		driver.getWaitUtility().waitForElementPresent(ADD_COL_LOC);
		driver.findElement(ADD_COL_LOC).click();
		driver.getWaitUtility().waitForElementPresent(SAVE_BUTTON);
		
	    driver.findElement(SAVE_BUTTON).click();
		 driver.getAssertionService().assertTrue((new ExtendedWebElement((OPTION)).isPresent()), "Option is not added", "Option is added");
				   
		
	}
	public void verifyRevertColumn()
	{
		
		driver.getWaitUtility().waitForElementPresent(ADD_BUTTON_LOC);
		driver.getAssertionService().assertTrue((new ExtendedWebElement((ADD_BUTTON_LOC)).isPresent()), "Add column option is not present on page", "Add column option is present on page");
		driver.findElement(ADD_BUTTON_LOC).click();
		driver.getWaitUtility().waitForElementPresent(REMOVE_COL_OPT_LOC);

		driver.findElement(REMOVE_COL_OPT_LOC).click();
	   driver.getWaitUtility().waitForElementPresent(REVERT_BUTTON);
		
	    driver.findElement(REVERT_BUTTON).click();
	    
		
		driver.getAssertionService().assertTrue((new ExtendedWebElement((REMOVE_COL_OPT_LOC)).isPresent()), "Revert is not successfull", "Revert is successfull");
		
	
	    
		
	}

	public void clickOnGLobalAction() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(GLOBAL_ACTION);
		driver.findElement(GLOBAL_ACTION).click();
		driver.getAssertionService().assertTrue((new ExtendedWebElement((GLOBAL_ACTION)).isPresent()), "Global action is not present on page", "Global action is present on page");
	}

	public void createNewHook() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(CREATE_NEW_HOOK);
		driver.getAssertionService().assertTrue((new ExtendedWebElement((CREATE_NEW_HOOK)).isPresent()), "Create New Hook is not present on page", "Create New Hook  is present on page");
	
		driver.findElement(CREATE_NEW_HOOK).click();
	}	
	public void getCurrentWindowHandle()
	{
		parentHandle = driver.getWindowHandle();
	}

	public void switchToNewlyOpenedWindow()
	{
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		    driver.manage().window().maximize();
		}
	}
	public void provideInfotoHook() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(FILE_NAME_LOC);
		driver.findElement(FILE_NAME_LOC).sendKeys("BasicBrokerHook");
		driver.getAssertionService().assertTrue((new ExtendedWebElement((FILE_NAME_LOC)).isPresent()), "File Name is not present on page", "File Name  is present on page");
		driver.getWaitUtility().waitForElementPresent(HOOK_TYPE);
		driver.findElement(HOOK_TYPE).click();
		driver.getAssertionService().assertTrue((new ExtendedWebElement((HOOK_TYPE)).isPresent()), "Hook Type is not selected", "Hook Type  is selected");
	    
		
		driver.getWaitUtility().waitForElementPresent(CLASS_NAME);
		driver.findElement(CLASS_NAME).sendKeys("com.datasynapse.testharness.server.hook.broker.BasicBrokerHook");
		driver.getAssertionService().assertTrue((new ExtendedWebElement((CLASS_NAME)).isPresent()), "Class Name is not present on page", "Class Name  is present on page");
		
	}

	public void clickOnSave() {
		// TODO Auto-generated method stub
		

		driver.getWaitUtility().waitForElementPresent(SAVE_HOOK_BUTTON);
		driver.getAssertionService().assertTrue((new ExtendedWebElement((SAVE_HOOK_BUTTON)).isPresent()), "Save button is not present on page", "Save button  is present on page");
		
		driver.findElement(SAVE_HOOK_BUTTON).click();
		
	}
	public void verifyHookAdded()
	{
		
	driver.getWaitUtility().waitForElementPresent(LOCAL_FILE_NAME);
		
		driver.getAssertionService().assertElementPresent(By.xpath(LOCAL_FILE_NAME), "Present");
	}
		
	

	public void verifyHookIsPresent() {
		// TODO Auto-generated method stub
		
		boolean X=new ExtendedWebElement(String.format(LOCAL_FILE_NAME)).isPresent();
		if(X==true)
		{
			selectHook();
			selectLocalAction("Delete Hook");
			
			commonFunctions.acceptAlert();
		}
		
		
	}
	public void selectLocalAction(String actionLocator)
	{
		driver.getWaitUtility().waitForElementPresent(LOCAL_ACTION_LINK_LOC);
		WebElement ele = driver.findElement(By.xpath(LOCAL_ACTION_LINK_LOC));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		driver.getAssertionService().assertElementPresent(By.xpath(LOCAL_ACTION_ITEM_LOC), "Local action item "+actionLocator);
		new ExtendedWebElement(String.format(LOCAL_ACTION_ITEM_LOC, actionLocator)).click();
		driver.getAssertionService().addAssertionLog("Local action "+actionLocator+" is selected", MessageTypes.Info);
	}
		
		public void selectHook()
		{
			
			driver.getWaitUtility().waitForElementPresent(HOOK_LOC);
			driver.findElement(HOOK_LOC).click();
			driver.getAssertionService().assertTrue((new ExtendedWebElement((HOOK_LOC)).isPresent()), "Hook checkbox is not selected", "Hook checkbox is selected");
		    
			
		}

		public void clickOnCancel() {
			// TODO Auto-generated method stub
			waitForPageToLoad();
			driver.getWaitUtility().waitForElementPresent(CANCEL_HOOK_BUTTON);
			driver.getAssertionService().assertTrue((new ExtendedWebElement((CANCEL_HOOK_BUTTON)).isPresent()), "Cancel button is not present on page", "Cancel button  is present on page");
			
			driver.findElement(CANCEL_HOOK_BUTTON).click();
			
			
		}

		public void verifyCancel() {
			// TODO Auto-generated method stub
			String x=driver.findElement(By.xpath(LOCAL_FILE_NAME)).getText();
			driver.getAssertionService().assertElementPresent(By.xpath(String.format(x, x)), x);
			
		}
		

		public void clickOnUpdateProperties() {
			// TODO Auto-generated method stub
			driver.getWaitUtility().waitForElementPresent(UPDATE_PROPERTIES_BUTTON);
			
			driver.findElement(UPDATE_PROPERTIES_BUTTON).click();
			driver.getAssertionService().assertTrue((new ExtendedWebElement((UPDATE_PROPERTIES_BUTTON)).isPresent()), "Update properties button is not present on page", "Update properties button is present on page");
			
		}

		public void verifyUpdateProperties() {
			// TODO Auto-generated method stub
			
			driver.getWaitUtility().waitForElementPresent(DESCRIPTION);		
			driver.findElement(DESCRIPTION).click();
			driver.getAssertionService().assertTrue((new ExtendedWebElement((DESCRIPTION)).isPresent()), "Description is not present on page", "Description is present on page");
			
		}

		public void closeWindow()
		{
			driver.close();
		}
		public void selectXMLView() {
			// TODO Auto-generated method stub
			
			
			
			
			driver.getWaitUtility().waitForElementPresent(XML_VIEW_LOC);		
			driver.findElement(XML_VIEW_LOC).click();
			driver.getAssertionService().assertTrue((new ExtendedWebElement((XML_VIEW_LOC)).isPresent()), "XML View is not present on page", "XML View is present on page");
			
		}

		public void clickOnGenerateXML() {
			// TODO Auto-generated method stub
			driver.getWaitUtility().waitForElementPresent(GENERATE_XML_BUTTON_LOC);		
			driver.findElement(GENERATE_XML_BUTTON_LOC).click();
			driver.getAssertionService().assertTrue((new ExtendedWebElement((GENERATE_XML_BUTTON_LOC)).isPresent()), "Generate XML button is not present", "Generate XML button is present");
			
		}

		public void VerifyGenerateXML() {
			// TODO Auto-generated method stub
			driver.getWaitUtility().waitForElementPresent(XML_AREA_LOC);		
			driver.findElement(XML_AREA_LOC).click();
			driver.getAssertionService().assertTrue((new ExtendedWebElement((XML_AREA_LOC)).isPresent()), "XML file is not generated", "XML file is generated");
			
			
		}

		public void verifyLocalAction()
		{
			driver.getWaitUtility().waitForElementPresent(LOCAL_ACTION_LOC);
			new ExtendedWebElement(LOCAL_ACTION_LOC).click();
			
	     	driver.getAssertionService().assertTrue(new ExtendedWebElement(LOCAL_ACTION_LOC).isPresent(), "Local actions link is not present", "Local actions link is present");
			
		
		}

		public void doubleClickOnHook() {
			// TODO Auto-generated method stub
			driver.getWaitUtility().waitForElementPresent(HOOK_LOC);
			new ExtendedWebElement(HOOK_LOC).click(); 
			new ExtendedWebElement(HOOK_LOC).click(); 
			
		}

		public void verifyDisableHook() {
			// TODO Auto-generated method stub
		
			
			driver.findElement(By.xpath(FALSE_LOC));
			driver.getAssertionService().assertTrue(new ExtendedWebElement(FALSE_LOC).isPresent(), "Disable is not present", "Disable is present");
		}

		public void switchToParentWindow()
		{
			driver.switchTo().window(parentHandle);
		}

		public void verifyEnableHook() {
			// TODO Auto-generated method stub
			 
			
			driver.findElement(By.xpath(TRUE_LOC));
			driver.getAssertionService().assertTrue(new ExtendedWebElement(TRUE_LOC).isPresent(), "Enable is not present", "Enable is present");
		}
		
		public void setDescription(String description)
		{
			
			driver.getWaitUtility().waitForElementPresent(DESCRIPTION_INPUT);
			new ExtendedWebElement(DESCRIPTION_INPUT).clear();
			new ExtendedWebElement(DESCRIPTION_INPUT).sendKeys(description);
			driver.getAssertionService().addAssertionLog("Description set to "+description, MessageTypes.Info);
		}
		public void verifyDescriptionIsPresent(String description)
		{
			
			
			driver.getAssertionService().assertElementPresent(By.xpath(String.format(DESCRIPTION_LOC, description)), description);
		}

		public void verifyDeleteHook() {
			// TODO Auto-generated method stub
			driver.getAssertionService().assertFalse((new ExtendedWebElement((HOOK_LOC)).isPresent()), "Hook is not  delected", "Hook is delected");
			
			
		}

		public void verifyDescriptionIsNotPresent(String description) {
			// TODO Auto-generated method stub
			
			driver.getAssertionService().assertElementNotPresent(By.xpath(String.format(DESCRIPTION_LOC, description)), description);
		
		}
		
		public void clickOnHelp() {
			// TODO Auto-generated method stub
			driver.getWaitUtility().waitForElementPresent(PAGE_HELP);
			new ExtendedWebElement(PAGE_HELP).click();
			driver.getAssertionService().assertTrue(new ExtendedWebElement(PAGE_HELP).isPresent(), "Page help is not present", "Page help is present" );
		}


		public void verifyPageHelp() {
			// TODO Auto-generated method stub
			driver.getWaitUtility().waitForElementPresent(HELP_PAGE_TITLE);
			driver.getAssertionService().assertElementPresent(By.xpath(HELP_PAGE_TITLE), "Manager hook help title");
		
			
		}
			
		
		}
	
		
		
