package com.tibco.automation.page.services.batch;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.page.common.CommonFunctions;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.Locators;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.common.TopPaginate;

public class BatchDefinitionPage extends TemplatePage implements Locators,Locators.BatchDefinitionLocators{

	
	public DataGrid datagrid; // these are class references
	public ExtendedWebDriver driver;
	public String pageTitle ="Services";
	public TemplatePage templatePage;
	public TopPaginate topPaginate;
	public static String parentHandle;
	
	public BatchDefinitionPage() {
		super("Batch Definitions", GSMenu.BatchDefinitions);
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
	
	
	public void clickAddDefinitionButton()
	{
		driver.getWaitUtility().waitForElementPresent(ADD_BUTTON_LOC);
		new ExtendedWebElement(ADD_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Clicking on add definition button", MessageTypes.Info);
	}
	
	
	public void clickSaveButton()
	{
		driver.getWaitUtility().waitForElementPresent(SAVE_BUTTON_LOC);
		new ExtendedWebElement(SAVE_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Clicking on save button", MessageTypes.Info);
	}
	
	
	public void clickCancelOnPopup()
	{
		driver.getWaitUtility().waitForElementPresent(CANCEL_BUTTON_LOC);
		new ExtendedWebElement(CANCEL_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Clicking on cancel button", MessageTypes.Info);
	}
	
	
	public void clickAddOnPopup()
	{
		driver.getWaitUtility().waitForElementPresent(ADD_BUTTON_ON_POPUP_LOC);
		new ExtendedWebElement(ADD_BUTTON_ON_POPUP_LOC).click();
		driver.getAssertionService().addAssertionLog("Clicking add on popup", MessageTypes.Info);
	}
	
	public void setDefinitionName(String definitionName)
	{
		driver.getWaitUtility().waitForElementPresent(BATCH_DEFINITION_INPUT_BOX);
		new ExtendedWebElement(BATCH_DEFINITION_INPUT_BOX).sendKeys(definitionName);
		driver.getAssertionService().addAssertionLog("Setting definition name to "+definitionName, MessageTypes.Info);
	}
	
	public void verifyDefinitionIsPresent(String definitionName)
	{
		driver.getAssertionService().assertElementPresent(By.xpath(String.format(DEFINITION_NAME_LOC, definitionName)), definitionName);
	}
	
	public void verifyDefinitionIsNotPresent(String definitionName)
	{
		driver.getAssertionService().assertElementNotPresent(By.xpath(String.format(DEFINITION_NAME_LOC, definitionName)), definitionName);
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
	
	public void clickCancelOnPage()
	{
		driver.getWaitUtility().waitForElementPresent(CANCEL_BUTTON_ON_EDIT_PAGE_LOC);
		new ExtendedWebElement(CANCEL_BUTTON_ON_EDIT_PAGE_LOC).click();
		driver.getAssertionService().addAssertionLog("Clicking cancel on definition edit page", MessageTypes.Info);
	}
	
	public void selectDefinition(String definitionName)
	{
		driver.getWaitUtility().waitForElementPresent(String.format(DEFINITION_CHECKBOX_LOC, definitionName));
		new ExtendedWebElement(String.format(DEFINITION_CHECKBOX_LOC, definitionName)).click();
		driver.getAssertionService().addAssertionLog("Selecting checkbox for definition "+definitionName, MessageTypes.Info);
	}
	
	public void fillDescription(String description)
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
	
	public void updateDefinitionName(String definitionName)
	{
		driver.getWaitUtility().waitForElementPresent(NEW_BATCH_DEFINITION_INPUT_LOC);
		new ExtendedWebElement(NEW_BATCH_DEFINITION_INPUT_LOC).clear();
		new ExtendedWebElement(NEW_BATCH_DEFINITION_INPUT_LOC).sendKeys(definitionName);
		driver.getAssertionService().addAssertionLog("Definition name is set to "+definitionName, MessageTypes.Info);
	}
	
	public void clickSaveOnBatchDefinitionUpdatePopup()
	{
		driver.getWaitUtility().waitForElementPresent(NEW_BATCH_SAVE_LOC);
		new ExtendedWebElement(NEW_BATCH_SAVE_LOC).click();
		driver.getAssertionService().addAssertionLog("Clicking on save button", MessageTypes.Info);
	}
	
	public void clickCancelOnBatchDefinitionUpdatePopup()
	{
		driver.getWaitUtility().waitForElementPresent(NEW_BATCH_CANCEL_LOC);
		new ExtendedWebElement(NEW_BATCH_CANCEL_LOC).click();
		driver.getAssertionService().addAssertionLog("Clicking on cancel button", MessageTypes.Info);
	}
	

	public void exportDefinition()
	{
		String mainWindowHandle = driver.getWindowHandle();
		
		try {
		    WebDriverWait wait = new WebDriverWait(driver, 2);
		    wait.until(ExpectedConditions.alertIsPresent());
		    Alert alert = driver.switchTo().alert();
		    System.out.println(alert.getText());
		    driver.getAssertionService().assertTrue(alert.getText().contains("xml"), mainWindowHandle);
		  //  alert.dismiss();
		} catch (Exception e) {
		    System.out.println(e);
		}
		 waitForPageToLoad(); 
		  for (String winHandle : driver.getWindowHandles()) 
		  {
			  Robot robotObj = null;
				driver.switchTo().window(winHandle);
				String uploadFileWindow = driver.getWindowHandle();
				try {
					robotObj = new Robot();
				} catch (AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
				
				robotObj.keyPress(KeyEvent.VK_ALT);
				robotObj.keyPress(KeyEvent.VK_SPACE);
				robotObj.keyPress(KeyEvent.VK_C);
			}
	}
	
	
	public void verifyBatchSchedulePageIsLaunched()
	{
		driver.getWaitUtility().waitForElementPresent(BATCH_SCHEDULE_VERIFICATION_LOC);
		driver.getAssertionService().assertElementPresent(By.xpath(BATCH_SCHEDULE_VERIFICATION_LOC), "Batch Schedule Page");
	}
	
	public void verifyBatchViewIsLaunched()
	{
		driver.getWaitUtility().waitForElementPresent(BATCH_VIEW_PAGE_LOC);
		driver.getAssertionService().assertElementPresent(By.xpath(BATCH_VIEW_PAGE_LOC), "Batch View Page");
		driver.close();
	}
}
