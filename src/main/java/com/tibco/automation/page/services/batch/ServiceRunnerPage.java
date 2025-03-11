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
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.Locators;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.common.TopPaginate;

public class ServiceRunnerPage extends TemplatePage implements Locators,Locators.ServiceRunnerPageLocators{

	
	public DataGrid datagrid; // these are class references
	public ExtendedWebDriver driver;
	public String pageTitle ="Services";
	public TemplatePage templatePage;
	public TopPaginate topPaginate;
	public static String parentHandle;
	
	public ServiceRunnerPage() {
		super("Service Runner", GSMenu.ServiceRunner);
		System.out.println("GSMenu..!!");
		datagrid = new DataGrid(); // as already defined above we are just initializing
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
	
	public void clickAddServiceRunnerButton()
	{
		driver.getWaitUtility().waitForElementPresent(ADD_BUTTON_LOC);
		new ExtendedWebElement(ADD_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Clicking on add service runner button", MessageTypes.Info);
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
	
	public void setServiceRunnerName(String serviceRunnerName)
	{
		driver.getWaitUtility().waitForElementPresent(SERVICE_RUNNER_INPUT_BOX_LOC);
		new ExtendedWebElement(SERVICE_RUNNER_INPUT_BOX_LOC).sendKeys(serviceRunnerName);
		driver.getAssertionService().addAssertionLog("Setting service runner name to "+serviceRunnerName, MessageTypes.Info);
	}
	
	public void verifyServiceRunnerIsPresent(String serviceRunnerName)
	{
		driver.getAssertionService().assertElementPresent(By.xpath(String.format(SERVICE_RUNNER_NAME_LOC, serviceRunnerName)), serviceRunnerName);
	}
	
	public void verifyServiceRunnerIsNotPresent(String serviceRunnerName)
	{
		driver.getAssertionService().assertElementNotPresent(By.xpath(String.format(SERVICE_RUNNER_NAME_LOC, serviceRunnerName)), serviceRunnerName);
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
		driver.getAssertionService().addAssertionLog("Clicking cancel on service runner edit page", MessageTypes.Info);
	}
	
	public void selectServiceRunner(String serviceRunnerName)
	{
		driver.getWaitUtility().waitForElementPresent(String.format(SERVICE_RUNNER_CHECKBOX_LOC, serviceRunnerName));
		new ExtendedWebElement(String.format(SERVICE_RUNNER_CHECKBOX_LOC, serviceRunnerName)).click();
		driver.getAssertionService().addAssertionLog("Selecting checkbox for service runner "+serviceRunnerName, MessageTypes.Info);
	}
	
	public void fillDescription(String description)
	{
		driver.getWaitUtility().waitForElementPresent(DESCRIPTION_INPUT_LOC);
		new ExtendedWebElement(DESCRIPTION_INPUT_LOC).sendKeys(description);
		driver.getAssertionService().addAssertionLog("Description set to "+description, MessageTypes.Info);
	}
	
	public void verifyDescriptionIsPresent(String serviceRunnerName,String description)
	{
		driver.getAssertionService().assertElementPresent(By.xpath(String.format(DESCRIPTION_VALUE_LOC, description)), description+"is added for "+serviceRunnerName);
	}
	
	public void verifyDescriptionIsNotPresent(String serviceRunnerName,String description)
	{
		driver.getAssertionService().assertElementNotPresent(By.xpath(String.format(DESCRIPTION_VALUE_LOC, description)), description+"is not added for "+serviceRunnerName);
	}
	
	public void updateServiceRunnerName(String serviceRunnerName)
	{
		driver.getWaitUtility().waitForElementPresent(NEW_SERVICE_RUNNER_INPUT_LOC);
		new ExtendedWebElement(NEW_SERVICE_RUNNER_INPUT_LOC).clear();
		new ExtendedWebElement(NEW_SERVICE_RUNNER_INPUT_LOC).sendKeys(serviceRunnerName);
		driver.getAssertionService().addAssertionLog("Service Runner name is set to "+serviceRunnerName, MessageTypes.Info);
	}
	
	public void clickSaveOnServiceRunnerUpdatePopup()
	{
		driver.getWaitUtility().waitForElementPresent(NEW_SERVICE_RUNNER_SAVE_LOC);
		new ExtendedWebElement(NEW_SERVICE_RUNNER_SAVE_LOC).click();
		driver.getAssertionService().addAssertionLog("Clicking on save button", MessageTypes.Info);
	}
	
	public void clickCancelServiceRunnerUpdatePopup()
	{
		driver.getWaitUtility().waitForElementPresent(NEW_SERVICE_RUNNER_CANCEL_LOC);
		new ExtendedWebElement(NEW_SERVICE_RUNNER_CANCEL_LOC).click();
		driver.getAssertionService().addAssertionLog("Clicking on cancel button", MessageTypes.Info);
	}
	

	public void exportServiceRunner()
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
	
	public void verifyServiceSessionAdminPageIsLaunched()
	{
		driver.getWaitUtility().waitForElementPresent(LAUNCH_SERVICE_RUNNER_VERIFICATION_LOC);
		driver.getAssertionService().assertElementPresent(By.xpath(LAUNCH_SERVICE_RUNNER_VERIFICATION_LOC), "Service Session Admin Page");
	}
}
