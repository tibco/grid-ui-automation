package com.tibco.automation.page.gridcomponents.drivers;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.concurrent.TimeUnit;

import com.sun.corba.se.spi.orbutil.fsm.Action;
import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.Locators;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.common.TopPaginate;
import com.tibco.automation.page.common.TemplatePage.GSMenu;

public class WebServicesPage extends TemplatePage implements Locators.UsersPageLocators, Locators.WebServices

{
	public DataGrid datagrid;
	public ExtendedWebDriver driver;
	public String pageTitle = "Authentication";
	public TemplatePage templatePage;
	public TopPaginate topPaginate;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	 
	public WebServicesPage() {
		
		super("Web Services", GSMenu.WebServices);
		datagrid = new DataGrid();
		driver = getDriver();
		templatePage = new TemplatePage();
		topPaginate = new TopPaginate();		
	}

	@Override
	public boolean isPageActive(Object... object) {
		return super.verifyPageTitle(pageTitle);
		
	}

	@Override
	public void waitForPageToLoad() {
		super.waitForPageToLoad();
	}
	
	public void verifyExpandAll()
	{
		new ExtendedWebElement(By.xpath(EXPAND_ALL_LOC)).click();
		driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(EXPAND_ALL_LOC))).isPresent(), "Information is not expanded", "Information is expanded");		
	}
	
	public void verifyCollapseAll()
	{
		
		new ExtendedWebElement(By.xpath(COLLAPSE_ALL_LOC)).click();
		driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(COLLAPSE_ALL_LOC))).isPresent(), "Information is not collapsed", "Information is collapsed");			
	}
	public void verifyServiceExpand()
	{
		driver.findElement(By.xpath(BATCH_ADMIN_LOC)).click();
		
		driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(OPERATIONS_LOC))).isDisplayed(), "Batch Admin details are not expanded", "Batch Admin detail are expanded");		
	
	}
	public void verifyServiceCollapse()
	{
		driver.getWaitUtility().waitForElementPresent(BATCH_ADMIN_LOC);
		driver.findElement(By.xpath(BATCH_ADMIN_LOC)).click();
		driver.findElement(By.xpath(BATCH_ADMIN_LOC)).click();
		driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(OPERATIONS_LOC))).isDisplayed(),"Batch Admin details are not Collapse", "Batch Admin detail are Collapse");		
		
	}
	
	public void verifyLocalAction()
	{
		
		driver.getWaitUtility().waitForElementPresent(BATCH_ADMIN_CHECKBOX);
		driver.findElement(By.xpath(BATCH_ADMIN_CHECKBOX)).click();
		driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(LOCAL_ACTION_LOC))).isDisplayed(),"Local Action is not enabled", "Local Action is enabled");		
   }
	
	public void verifyGenerateWSDL() throws InterruptedException, AWTException
	{
		driver.getWaitUtility().waitForElementPresent(BATCH_ADMIN_CHECKBOX);
		driver.findElement(By.xpath(BATCH_ADMIN_CHECKBOX)).click();
		driver.findElement(By.xpath(MORE_ACTION_LOC)).click();
		WebElement myElement = driver.findElement(By.xpath(GENERATE_WSDL_LOC));
		driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(GENERATE_WSDL_LOC))).isDisplayed(),"More Action is not enabled", "More Action is enabled");		
		driver.findElement(By.xpath(GENERATE_WSDL_LOC)).click();
		
		}
	}
	
