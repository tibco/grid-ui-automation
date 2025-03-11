package com.tibco.automation.page.services.services;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.*;
import java.util.concurrent.TimeUnit;

import com.sun.corba.se.spi.orbutil.fsm.Action;
import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.common.utils.PropertiesUtil;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.Locators;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.common.TopPaginate;
import com.tibco.automation.page.common.TemplatePage.GSMenu;

public class ReportsPage extends TemplatePage implements  Locators.Reports
{
	public DataGrid datagrid;
	public ExtendedWebDriver driver;
	
	public TemplatePage templatePage;
	public TopPaginate topPaginate;
	public String mainWindowHandle;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public ReportsPage() {
		
		super("Reports", GSMenu.Report);
		datagrid = new DataGrid();
		driver = getDriver();
		templatePage = new TemplatePage();
		topPaginate = new TopPaginate();	

		
	}
	public void verifyDisplayResult()
	{
		waitForPageToLoad();
	   driver.findElement(By.xpath(DISPLAYRESULT_BUTTON_LOC)).click();
	   waitForPageToLoad();
	   driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(DISPLAY_RESULT_LOC))).isPresent(), "Result is not displayed", "Result is displayed");			
	}
	   

	
	public void verifySummariesResult()
	{
		driver.findElement(By.xpath(SUMMARIES_LOC)).click();
		driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(SUMMERIES_RESULT_LOC))).isPresent(), "Result is not displayed", "Result is displayed");			
	}
	
	public void verifyExportResult() 
	{
		//String parentHandle=driver.getWindowHandle();
		
     	driver.findElement(By.xpath(EXPORT_BUTTON_LOC)).click();
     	driver.getAssertionService().addAssertionLog("Export Button is clicked", MessageTypes.Pass);
     
		 // driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(EXPORT_BUTTON_LOC))).isDisplayed(), "Link is not clickable", "Link is clicked");		
			
	}
		
		
	
	public void verifyLastMonthResult()
	{
		
		driver.findElement(By.xpath(MONTH_LOC)).click();
		verifyDisplayResult();
		
	}
		
	public void verifyBetweenResult() throws InterruptedException
	{
		
		driver.findElement(By.xpath(BETWEEN_LOC)).click();
		waitForPageToLoad();
		//verifyDisplayResult();
	}
	
	public void verifyServiceLink() 
	{
		driver.findElement(By.xpath(DISPLAYRESULT_BUTTON_LOC)).click();
		driver.findElement(By.xpath(DISPLAY_RESULT_LOC)).click();
		
		driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(BACK_LINK_LOC))).isDisplayed(), "Link is not clickable", "Link is clicked");		
		 
		
	}
	
	
	}
	
