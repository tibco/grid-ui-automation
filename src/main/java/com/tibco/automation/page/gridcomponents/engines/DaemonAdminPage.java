package com.tibco.automation.page.gridcomponents.engines;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.Locators;
import com.tibco.automation.page.common.Locators.RolePageLocators;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.common.TopPaginate;
import com.tibco.automation.page.common.TemplatePage.GSMenu;
import java.util.concurrent.TimeUnit;
public class DaemonAdminPage extends TemplatePage implements Locators.DaemonAdminLocators,RolePageLocators,Locators.CommonLocators{  
	public ExtendedWebDriver driver;
	//public String pageTitle ="Role Admin";
	public TemplatePage templatePage;
	public TopPaginate topPaginate;
	public String winHandleBefore;
	public String description;
	public Select select;
	public static String parentHandle="";
	public JavascriptExecutor js = (JavascriptExecutor) driver;
	public DataGrid datagrid; // these are class references
	
	public String pageTitle ="Daemon admin";
	
	
	public DaemonAdminPage()
	{
		super("Daemon Admin", GSMenu.DaemonAdmin);
		datagrid = new DataGrid(); // as already defined above we are just initializing
		driver = getDriver();
		templatePage = new TemplatePage();
		topPaginate = new TopPaginate();
		System.out.println(" After GSMenu..!!");
		
	}
	
	@Override
	public void waitForPageToLoad() 
	{
	super.waitForPageToLoad();
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
	public void selectGlobalAction(String actionLocator)
	{
		driver.getWaitUtility().waitForElementPresent(GLOBAL_ACTION_LINK_LOCATOR);
		WebElement ele = driver.findElement(By.xpath(GLOBAL_ACTION_LINK_LOCATOR));
		 
		JavascriptExecutor je = (JavascriptExecutor) driver;
		 
	
		 
		//Identify the WebElement which will appear after scrolling down
		 String s="//li[contains(text(),'%s')]";
		
		 WebElement element = driver.findElement(String.format(s,actionLocator));
		
		je.executeScript("arguments[0].scrollIntoView(true);",element);
	
		
		driver.getAssertionService().assertElementPresent(By.xpath(GLOBAL_ACTION_NAME), "Global action item "+actionLocator);
		
		new ExtendedWebElement(String.format(GLOBAL_ACTION_NAME, actionLocator)).click();
	
	}
	public void refreshButton()
	{
		driver.getAssertionService().assertTrue((new ExtendedWebElement((REFRESH_BUTTON)).isPresent()), "Refresh Button is not present on page", "Refresh Button is present on page");
	}
	
	public void addColumnOption()
	{
		driver.findElement(By.xpath(ADD_COL_OPT));
		driver.getAssertionService().assertTrue((new ExtendedWebElement((ADD_COL_OPT)).isPresent()), "Add column option is not present on page", "Add column option is present on page");
		
		driver.findElement(By.xpath(ADD_COL_OPT)).click();
}

	public void addEngineColumn() {
		// TODO Auto-generated method stub
		
		driver.getAssertionService().assertTrue((new ExtendedWebElement((DESCRIPTION_ADD)).isPresent()), "Description option is not present on page", "Description option is present on page");
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		 
		 js.executeScript("arguments[0].click();", new ExtendedWebElement(DESCRIPTION_ADD));
		//driver.findElement(By.xpath(DESCRIPTION_ADD)).click();
		
	}
	public void SaveColumn() {
		
		driver.getAssertionService().assertTrue((new ExtendedWebElement((ADDCOLUMNSAVE_BUTTON)).isPresent()), "Save Button is not present on page", "Save Button is present on page");
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		js.executeScript("arguments[0].click();", new ExtendedWebElement(ADDCOLUMNSAVE_BUTTON));
		//driver.findElement(By.xpath(ADDCOLUMNSAVE_BUTTON)).click();
		
	}

	public void verifyColumnAdded() {
		// TODO Auto-generated method stub
		
	
		driver.getAssertionService().assertTrue((new ExtendedWebElement((VERIFY_ADD)).isPresent()), "Description option is not added on page", "Description option is added on page");
		
		
		
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

	public void clickGlobalAction() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(GLOBAL_ACTION_LOC);
		new ExtendedWebElement(GLOBAL_ACTION_LOC).click(); 
		
		driver.getAssertionService().assertTrue(new ExtendedWebElement(GLOBAL_ACTION_LOC).isPresent(), "Global actions link is not present", "Global actions link is present");
		
	}

	public void verifyExpandViewOfAll() {
		// TODO Auto-generated method stub
		
		driver.getWaitUtility().waitForElementPresent(AVAILABLE_DISK_LOC);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(AVAILABLE_DISK_LOC).isPresent(), "Expand View of All is not working", "Expand View of All is working");
		
	}

	public void verifyCollapseViewOfAll() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(AVAILABLE_DISK_LOC);
		driver.getAssertionService().assertFalse((new ExtendedWebElement((AVAILABLE_DISK_LOC)).isPresent()), "Collapse View of All is not working", "Collapse View of All is working");
	
	}

	public void verifyManualModeOnPage() {
		// TODO Auto-generated method stub
		
		driver.getWaitUtility().waitForElementPresent(VERIRY_MANUAL_MODE_ON_PAGE);
		if(isAlertPresent()){
			driver.getAssertionService().addAssertionLog("Alert is present", MessageTypes.Info);
			
			Alert alert = driver.switchTo().alert();
		
			System.out.println(alert.getText());
		
			alert.accept();
			driver.getAssertionService().assertTrue((new ExtendedWebElement((VERIRY_MANUAL_MODE_ON_PAGE)).isPresent()), "Manual mode is not selected on page", "Manual mode is selected on the page");
			
			}
	}
	public boolean isAlertPresent(){
		try{
		driver.switchTo().alert();
		return true;
		}catch(NoAlertPresentException ex){
		return false;
		}
	}

	public void verifyAutoModeOnPage() {
		// TODO Auto-generated method stub

		driver.getWaitUtility().waitForElementPresent(VERIFY_AUTO_MODE_ON_PAGE);
		if(isAlertPresent()){
			driver.getAssertionService().addAssertionLog("Alert is present", MessageTypes.Info);
			
			Alert alert = driver.switchTo().alert();
		
			System.out.println(alert.getText());
		
			alert.accept();
			driver.getAssertionService().assertTrue((new ExtendedWebElement((VERIFY_AUTO_MODE_ON_PAGE)).isPresent()), "Auto mode is not selected on page", "Auto mode is selected on the page");
			
			}
	}

	public void verifyDisableEngineOnPage() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(VERIFY_DISABLE_ENGINE_ON_PAGE);
		if(isAlertPresent()){
			driver.getAssertionService().addAssertionLog("Alert is present", MessageTypes.Info);
			
			Alert alert = driver.switchTo().alert();
		
			System.out.println(alert.getText());
		
			alert.accept();
			driver.getAssertionService().assertTrue((new ExtendedWebElement((VERIFY_DISABLE_ENGINE_ON_PAGE)).isPresent()), "Engines are not disabled on page", "Engines are disabled on the page");
			
			}
	}

	public void verifyEnableEngineOnPage() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(VERIFY_ENABLE_ENGINE_ON_PAGE);
		if(isAlertPresent()){
			driver.getAssertionService().addAssertionLog("Alert is present", MessageTypes.Info);
			
			Alert alert = driver.switchTo().alert();
		
			System.out.println(alert.getText());
		
			alert.accept();
			driver.getAssertionService().assertTrue((new ExtendedWebElement((VERIFY_ENABLE_ENGINE_ON_PAGE)).isPresent()), "Engines are not enables on page", "Engines are enabled on the page");
			
			}
	}
	
	public void acceptAlert()
	{
		if(isAlertPresent()){
			driver.getAssertionService().addAssertionLog("Alert is present", MessageTypes.Info);
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
			}
	}
	public void verifyConfigureDaemonsOnPage() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(VERIFY_CONFIGURE_DAEMON);
		driver.getAssertionService().assertTrue((new ExtendedWebElement((VERIFY_CONFIGURE_DAEMON)).isPresent()), "Configure daemon on page is not working", "Configure daemon on page is working");
		
	}

	public void changeInstances() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(CONFIGURE_DAEMON_INSTANCES_INPUT_BOX);
		
		addStaticWait(3000);
		waitForPageToLoad();
		driver.findElement(By.xpath(CONFIGURE_DAEMON_INSTANCES_INPUT_BOX)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		if (isAlertPresent())
		acceptAlert();
        driver.findElement(By.xpath(CONFIGURE_DAEMON_INSTANCES_INPUT_BOX)).sendKeys(""+1);
        addStaticWait(1000);
        //driver.findElement(By.xpath(CONFIGURE_DAEMON_INSTANCES_INPUT_BOX)).sendKeys(Keys.ENTER);
        
	}
	public void selectInstanceCheckbox()
	{
		  driver.getWaitUtility().waitForElementPresent(ENABLE_INSTANCE_CHECKBOX); 
		   new ExtendedWebElement(ENABLE_INSTANCE_CHECKBOX).click(); 
		   driver.getAssertionService().assertTrue((new ExtendedWebElement((ENABLE_INSTANCE_CHECKBOX)).isPresent()), "Checkbox is not present on page", "Checkbox is present on page");
			
	}
	
	public void clickOnConfigSaveButton() {
		
		driver.getWaitUtility().waitForElementPresent(SAVE_BUTTON);
		
		
	
		driver.getAssertionService().assertTrue((new ExtendedWebElement((SAVE_BUTTON)).isPresent()), "Save button is not present on page", "Save button is present on page");
		
		new ExtendedWebElement(SAVE_BUTTON).click(); 
    
	}
	public void clickOnOkButton() {
		   driver.getWaitUtility().waitForElementPresent(OK_BUTTON_LOC);
		  
			driver.getAssertionService().assertTrue((new ExtendedWebElement((OK_BUTTON_LOC)).isPresent()), "Ok button is not present on page", "Ok button is present on page");
			
			 new ExtendedWebElement(OK_BUTTON_LOC).click(); 
	}
	public void clickOnOkButtonOnConfigureDaemo() {
		   driver.getWaitUtility().waitForElementPresent(CONFIGURE_DAEMON_ON_PAGE_OK_BUTTON_LOC);
		  
			driver.getAssertionService().assertTrue((new ExtendedWebElement((CONFIGURE_DAEMON_ON_PAGE_OK_BUTTON_LOC)).isPresent()), "Ok button is not present on page", "Ok button is present on page");
			
			 new ExtendedWebElement(CONFIGURE_DAEMON_ON_PAGE_OK_BUTTON_LOC).click(); 
	}

	public void clickOnCancelButton() {
		// TODO Auto-generated method stub
      driver.getWaitUtility().waitForElementPresent(CANCEL_BUTTON_LOC);
		
		driver.getAssertionService().assertTrue((new ExtendedWebElement((CANCEL_BUTTON_LOC)).isPresent()), "Cancel button is not present on page", "Cancel button is present on page");
		
		new ExtendedWebElement(CANCEL_BUTTON_LOC).click(); 
		
	}

	public void verifyCancelDaemonsOnPage() {
		// TODO Auto-generated method stub
		driver.getAssertionService().assertFalse((new ExtendedWebElement((VERIFY_CONFIGURE_DAEMON)).isPresent()), "Cancel button is not working", "Cancel Button is working");
	}

	public void selectEngineCheckbox() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(ENGINE_CHECKBOX);
		
		driver.getAssertionService().assertTrue((new ExtendedWebElement((ENGINE_CHECKBOX)).isPresent()), "Engine checkbox is not clicked", "Engine checkbox is clicked");
		
		new ExtendedWebElement(ENGINE_CHECKBOX).click();
	}

	public void verifyLogFile() {
		// TODO Auto-generated method stub
       driver.getWaitUtility().waitForElementPresent(DAEMON_LOGFILES_TABLE);
		
		driver.getAssertionService().assertTrue((new ExtendedWebElement((DAEMON_LOGFILES_TABLE)).isPresent()), "Daemon Engine logfiles window is not opened", "Daemon Engine logfiles window is opened");
		 driver.getWaitUtility().waitForElementPresent(ENGINED_LOG_FILE_LINK);
		 driver.getAssertionService().assertTrue((new ExtendedWebElement((ENGINED_LOG_FILE_LINK)).isPresent()), "Engined log file is not present", "Engined log file is  present");
			
		new ExtendedWebElement(ENGINED_LOG_FILE_LINK).click();
		 driver.getWaitUtility().waitForElementPresent(ENGINED_LOGS_DISPLAY);
		 driver.getAssertionService().assertTrue((new ExtendedWebElement((ENGINED_LOGS_DISPLAY)).isPresent()), "Engined log file is not opened", "Engined log file is open");
			
		
	}
	
	public void quit()
	{
		driver.close();
	}

	public void verifySearchLogs() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(VERIFY_SEARCH_LOGS);
		
		driver.getAssertionService().assertTrue((new ExtendedWebElement((VERIFY_SEARCH_LOGS)).isPresent()), "Search logs window is not opened", "Search log window is opened");
		
		
	}

	public void verifyAutoMode() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(AUTO_MODE);
		driver.getAssertionService().assertTrue((new ExtendedWebElement((AUTO_MODE)).isPresent()), "Auto mode is not selected for the engine", "Auto mode is selected for the engine");
		
	}

	public void verifyManualMode() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(MANUAL_MODE);
		driver.getAssertionService().assertTrue((new ExtendedWebElement((MANUAL_MODE)).isPresent()), "Manual mode is not selected for the engine", "Manual mode is selected for the engine");
		
	}

	public void verifyDisableDaemon() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(DISABLE_DAEMON);
		driver.getAssertionService().assertTrue((new ExtendedWebElement((DISABLE_DAEMON)).isPresent()), "Engine is not disable", "Engine is disable");
		
		
	}

	public void verifyEnableDaemon() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(ENABLE_DAEMON);
		driver.getAssertionService().assertTrue((new ExtendedWebElement((ENABLE_DAEMON)).isPresent()), "Engine is not enabled", "Engine is enabled");
		
	}

	public void verifyRestartDaemon() {
		// TODO Auto-generated method stub
		 
		driver.getWaitUtility().waitForElementPresent(VERIFY_RESTART_DAEMON);
		driver.getAssertionService().assertTrue((new ExtendedWebElement((VERIFY_RESTART_DAEMON)).isPresent()), "Engine Daemon is not Restarted", "Engine Daemon is restarted");
		
	}

	

	
	public void verifyEngineAdminPageIsLaunched() {
		// TODO Auto-generated method stub
		 
		driver.getWaitUtility().waitForElementPresent(ENGINE_ADMIN_PAGE_VERIFICATION_LOC);
		driver.getAssertionService().assertElementPresent(By.xpath(ENGINE_ADMIN_PAGE_VERIFICATION_LOC), "Engine Admin Page");
	}
	
	
	public void  addWait()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void selectCheckboxOnEngineTracking() {
		// TODO Auto-generated method stub
		 String CHECKBOX="//input[@name='4[]']";
		 driver.getWaitUtility().waitForElementPresent(CHECKBOX);
		 driver.getAssertionService().assertTrue((new ExtendedWebElement((CHECKBOX)).isPresent()), "Engine checkbox is not clicked", "Engine checkbox is clicked");
	    new ExtendedWebElement(CHECKBOX).click();
	}

	public void selectLocalActionOnEngineTracking() {
		// TODO Auto-generated method stub
		 driver.getWaitUtility().waitForElementPresent(LOCAL_ACTION_ENGINE_EVENT);
			
			driver.getAssertionService().assertTrue((new ExtendedWebElement((LOCAL_ACTION_ENGINE_EVENT)).isPresent()), "Local Action is not clicked", "Local Action is clicked");
			
			new ExtendedWebElement(LOCAL_ACTION_ENGINE_EVENT).click();
	}

	public void clickOnEngineAdminLink() {
		// TODO Auto-generated method stub
		 String LOGIN_TO_ADMIN="//li[contains(text(),'Login to Admin')]";
			
			
         driver.getWaitUtility().waitForElementPresent(LOGIN_TO_ADMIN);
			
			driver.getAssertionService().assertTrue((new ExtendedWebElement((LOGIN_TO_ADMIN)).isPresent()), "Local Action is not clicked", "Local Action is clicked");
			
			new ExtendedWebElement(LOGIN_TO_ADMIN).click();
	}
	
	public void closeWindow()
	{
	driver.close();
	
	}

	public void clickRemoveQauntineStatus() {
		 driver.getWaitUtility().waitForElementPresent(REMOVE_BUTTON);
			driver.getAssertionService().assertTrue((new ExtendedWebElement((REMOVE_BUTTON)).isPresent()), "Remove button is not clicked", "Remove Button is clicked");
			
		 new ExtendedWebElement(REMOVE_BUTTON).click();
		  
	}

	public void verifyRemoveQauntineStatus() {
		// TODO Auto-generated method stub
		
			driver.getAssertionService().assertElementNotPresent(By.xpath(String.format(QUARANTNE_STATUS, "presenmt ")), "not present");
		}

	public void closeEnginePropretiesPopup() {
		// TODO Auto-generated method stub
		 driver.getWaitUtility().waitForElementPresent(CLOSE_ENGINE_PROPERTIES);
		 new ExtendedWebElement(CLOSE_ENGINE_PROPERTIES).click();
		
	}

	public void selectDescriptionOpt() {
		
		//public String DROP_DOWNLIST_ON_ENGINEPROPRTIES="//button[@class='toggleList comboToggle glyphicon glyphicon-chevron-down ui-corner-right']";
		driver.getWaitUtility().waitForElementPresent(DROP_DOWNLIST_ON_ENGINEPROPRTIES);
		driver.getAssertionService().assertTrue((new ExtendedWebElement((DROP_DOWNLIST_ON_ENGINEPROPRTIES)).isPresent()), "Drop down is not selected", "Drop down is selected");	
	     new ExtendedWebElement(DROP_DOWNLIST_ON_ENGINEPROPRTIES).click();
		// TODO Auto-generated method stub
	      new ExtendedWebElement(DESCRIPTION_TEXTBOX1).sendKeys("Description");
	  
	}

	public void setDescription(String description2) {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(DESCRIPTION_TEXTBOX);
		new ExtendedWebElement(DESCRIPTION_TEXTBOX).sendKeys(description2);
		driver.getAssertionService().addAssertionLog("Description set to "+description2, MessageTypes.Info);
	}

	public void clickOnPluseButton() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(PLUS_BUTTON);
		driver.getAssertionService().assertTrue((new ExtendedWebElement((PLUS_BUTTON)).isPresent()), "Plus button is not clicked", "Plus button is clicked");	
	     new ExtendedWebElement(PLUS_BUTTON).click();
	}

	public void clickOnConfigAllSaveButton() {
		// TODO Auto-generated method stub

		driver.getWaitUtility().waitForElementPresent(CONFIG_ALL_SAVE_BUTTON);
		
		
	
		driver.getAssertionService().assertTrue((new ExtendedWebElement((CONFIG_ALL_SAVE_BUTTON)).isPresent()), "Save button is not present on page", "Save button is present on page");
		
		new ExtendedWebElement(CONFIG_ALL_SAVE_BUTTON).click(); 
	
	
	}

	public void clickOnConfigCancelButton() {
		// TODO Auto-generated method stub
		
		
		 driver.getWaitUtility().waitForElementPresent(CONFIG_CANCEL_BUTTON);
			
			driver.getAssertionService().assertTrue((new ExtendedWebElement((CONFIG_CANCEL_BUTTON)).isPresent()), "Cancel button is not present on page", "Cancel button is present on page");
			
			new ExtendedWebElement(CONFIG_CANCEL_BUTTON).click(); 
			
	}

	public void setDefaultInstances() {
		// TODO Auto-generated method stub
		
			driver.getWaitUtility().waitForElementPresent(CONFIGURE_DAEMON_INSTANCES_INPUT_BOX);
			
			addStaticWait(3000);
			waitForPageToLoad();
			driver.findElement(By.xpath(CONFIGURE_DAEMON_INSTANCES_INPUT_BOX)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			if (isAlertPresent())
			acceptAlert();
	        driver.findElement(By.xpath(CONFIGURE_DAEMON_INSTANCES_INPUT_BOX)).sendKeys(""+"default");
	        addStaticWait(1000);
	       // driver.findElement(By.xpath(CONFIGURE_DAEMON_INSTANCES_INPUT_BOX)).sendKeys(Keys.ENTER);
	        
	
	}

	public void verifyDefaultConfigureDaemonsOnPage() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(VERIFY_DEFAULT_INSTANCE);
		driver.getAssertionService().assertTrue((new ExtendedWebElement((VERIFY_DEFAULT_INSTANCE)).isPresent()), "Configure daemon on page is not working", "Configure daemon on page is working");
		
	}

	public void waitToVerify() {
		// TODO Auto-generated method stub
		driver.manage().timeouts().setScriptTimeout(1, TimeUnit.MINUTES);
		 addStaticWait(10000);
	}

	public void saveDescription() {
		// TODO Auto-generated method stub
	
			driver.getWaitUtility().waitForElementPresent(SAVE_BUTTON_ON_ENGINEPROPRTIES);
			
			
		
			driver.getAssertionService().assertTrue((new ExtendedWebElement((SAVE_BUTTON_ON_ENGINEPROPRTIES)).isPresent()), "Save button is not present on page", "Save button is present on page");
			
			new ExtendedWebElement(SAVE_BUTTON_ON_ENGINEPROPRTIES).click(); 
	    
		}

	public void verifyAddedDescription(String description2) {
		
		// TODO Auto-generated method stub
		
		driver.getAssertionService().assertElementNotPresent(By.xpath(String.format(DESCRIPTION_VALUE_LOC, description2)), description2+"is added ");
		}

	public void selectOfflineEngineCheckbox() {
		// TODO Auto-generated method stub
				
	   driver.getWaitUtility().waitForElementPresent(OFFLINE_ENGINE_CHECKBOX);
		
		driver.getAssertionService().assertTrue((new ExtendedWebElement((OFFLINE_ENGINE_CHECKBOX)).isPresent()), "Engine checkbox is not clicked", "Engine checkbox is clicked");
		
		new ExtendedWebElement(OFFLINE_ENGINE_CHECKBOX).click();
	}

	public void verifyDeleteRepository() {
		// TODO Auto-generated method stub
				driver.getAssertionService().assertElementNotPresent(By.xpath((VERIFY_PURGE_OFFLINE_ENGINE)),"present");
			}

	public void selectDescriptionOptOnPage() {
		// TODO Auto-generated method stub
		String drop="//select[@id='item']";
		new ExtendedWebElement(drop).click();
		Select dropdown = new Select(driver.findElement(By.id("item")));
		 dropdown.selectByValue("Description");
	}

	public void setDescriptionOnPage(String description2) {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(DESCIPTION_VALUE_ON_PAGE);
		driver.findElement(By.xpath(DESCIPTION_VALUE_ON_PAGE)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		
		new ExtendedWebElement(DESCIPTION_VALUE_ON_PAGE).sendKeys(description2);
		driver.getAssertionService().addAssertionLog("Description set to "+description2, MessageTypes.Info);
	}

	public void clickOnSubmitButton() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(SUBMIT_BUTTON);
		driver.getAssertionService().assertTrue((new ExtendedWebElement((SUBMIT_BUTTON)).isPresent()), "Submit button is not present on page", "Submit button is present on page");
		
		new ExtendedWebElement(SUBMIT_BUTTON).click(); 
    
	}

	public void clickOnCloseButton() {
		// TODO Auto-generated method stub
      driver.getWaitUtility().waitForElementPresent(CLOSE_BUTTON);
		
		driver.getAssertionService().assertTrue((new ExtendedWebElement((CLOSE_BUTTON)).isPresent()), "Close button is not present on page", "Close button is present on page");
		
		new ExtendedWebElement(CLOSE_BUTTON).click(); 
        
	}

	public void verifyRestartDaemonOnPage() {
		// TODO Auto-generated method stub
		
		 driver.getWaitUtility().waitForElementPresent(VERIFY_RESTART_DAEMON_ON_PAGE);
		driver.getAssertionService().assertTrue((new ExtendedWebElement((VERIFY_RESTART_DAEMON_ON_PAGE)).isPresent()), "Engine Daemon is not Restarted", "Engine Daemon is restarted");
			
	}
	public void clickOnRestartOkButton() {
		   driver.getWaitUtility().waitForElementPresent(RESTART_OK_BUTTON);
		  
			driver.getAssertionService().assertTrue((new ExtendedWebElement((RESTART_OK_BUTTON)).isPresent()), "Ok button is not present on page", "Ok button is present on page");
			
			 new ExtendedWebElement(RESTART_OK_BUTTON).click(); 
	}

	public void VerifyPurgeOfflineEngine() {
		// TODO Auto-generated method stub
		driver.getAssertionService().assertElementNotPresent(By.xpath((VERIFY_PURGE_OFFLINE_ENGINE)),"Offile Engine");
	
	}

	public void selectYear() {
		// TODO Auto-generated method stub
		Select dropdown=new Select(driver.findElement(By.id("back")));
		dropdown.selectByValue("year");
	    String q= driver.findElement(By.xpath("//select[@id='back']")).getText();
	    
	   System.out.print(q);
	//	driver.getAssertionService().assertTrue((new ExtendedWebElement((NEXT_BUTTON)).isPresent()), "Next button is not present on page", "Next button is present on page");
		
	}

	public void clickOnNextButton() {
		// TODO Auto-generated method stub
		
		driver.getWaitUtility().waitForElementPresent(NEXT_BUTTON);
		  
		driver.getAssertionService().assertTrue((new ExtendedWebElement((NEXT_BUTTON)).isPresent()), "Next button is not present on page", "Next button is present on page");
		
		 new ExtendedWebElement(NEXT_BUTTON).click(); 
	}

	public void clickOnBackButton() {
		// TODO Auto-generated method stub
		

		if(new ExtendedWebElement(BACK_BUTTON).isEnabled())
		{
		 new ExtendedWebElement(BACK_BUTTON).click();
		 driver.getAssertionService().addAssertionLog("back button is clicked", MessageTypes.Info);
		}
		else
			driver.getAssertionService().addAssertionLog("back button is disabled", MessageTypes.Info);
			
	}

	public void verifyResults() {
		// TODO Auto-generated method stub
		
		driver.getWaitUtility().waitForElementPresent(SEARCH_LOGS_LOC);
		driver.getAssertionService().assertTrue((new ExtendedWebElement((SEARCH_LOGS_LOC)).isPresent()), "Search logs are not displayed on page", "Search logs are displayed on page");
		
	}

	public void selectHour() {
		// TODO Auto-generated method stub
		Select dropdown=new Select(driver.findElement(By.id("back")));
		dropdown.selectByValue("hour");
	   
	}

	public void selectDay() {
		// TODO Auto-generated method stub
		Select dropdown=new Select(driver.findElement(By.id("back")));
		dropdown.selectByValue("day");
	}

	public void selectWeek() {
		// TODO Auto-generated method stub
		Select dropdown=new Select(driver.findElement(By.id("back")));
		dropdown.selectByValue("week");
	}

	public void selectMonth() {
		// TODO Auto-generated method stub
		Select dropdown=new Select(driver.findElement(By.id("back")));
		dropdown.selectByValue("month");
	}
	 
	public void verifyLocalAction()
	{
	driver.getWaitUtility().waitForElementPresent(LOCAL_ACTION_LOC);
	new ExtendedWebElement(LOCAL_ACTION_LOC).click();
	driver.getAssertionService().assertTrue(new ExtendedWebElement(LOCAL_ACTION_LOC).isPresent(), "Local actions link is not present", "Local actions link is present");
	
	}

	public void clickOnConfigDaemonSaveButton() {
		// TODO Auto-generated method stub

		//driver.getWaitUtility().waitForElementPresent(CONFIGURE_DAEMON_SAVE_BUTTON);
		
		//waitForPageToLoad();
	
		//driver.getAssertionService().assertTrue((new ExtendedWebElement((CONFIGURE_DAEMON_SAVE_BUTTON)).isPresent()), "Save button is not present on page", "Save button is present on page");
		
		new ExtendedWebElement(CONFIGURE_DAEMON_SAVE_BUTTON).click(); 
	
	}

	public void zoomOut() throws AWTException {
		// TODO Auto-generated method stub
		Robot robot = new Robot();
		  for (int i = 1; i <=2; i++) {
			   robot.keyPress(KeyEvent.VK_CONTROL);
			   robot.keyPress(KeyEvent.VK_SUBTRACT);
			  
		  }
			   }
	public void zoomIn() throws AWTException {
		// TODO Auto-generated method stub
		Robot robot = new Robot();
		  for (int i = 1; i <=2; i++) {
			   robot.keyPress(KeyEvent.VK_CONTROL);
			   robot.keyPress(KeyEvent.VK_ADD);
			 
		  }
			   }
	public void verifyRestartAllDaemonOnPage() {
		// TODO Auto-generated method stub
		
		 driver.getWaitUtility().waitForElementPresent(VERIFY_RESTART_ALL_DAEMON_ON_PAGE);
		driver.getAssertionService().assertTrue((new ExtendedWebElement((VERIFY_RESTART_ALL_DAEMON_ON_PAGE)).isPresent()), "All Engine Daemon is not Restarted", "All Engine Daemon is restarted");
			
	}

	public void verifyRevert() {
		// TODO Auto-generated method stub
		driver.getAssertionService().assertTrue((new ExtendedWebElement((DESCRIPTION_ADD)).isPresent()), "Description option is not present on page", "Description option is present on page");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		 
		 js.executeScript("arguments[0].click();", new ExtendedWebElement(DESCRIPTION_ADD));
		 try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		driver.findElement(By.xpath(REVERT_BUTTON)).click();
		 driver.getAssertionService().assertTrue((new ExtendedWebElement((DESCRIPTION_ADD)).isPresent()), "Revert button is not working", "Revert button is working");
			
			
			
	}
	
	
	public void ZoomOutNew()
	{
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
		 executor.executeScript("document.body.style.zoom = '80%'");
	}
	
	public void ZoomInNew()
	{
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
		 executor.executeScript("document.body.style.zoom = '80%'");
	}
}
	
	
	
