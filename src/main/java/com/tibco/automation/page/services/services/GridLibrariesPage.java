package com.tibco.automation.page.services.services;

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
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.*;
import java.util.concurrent.TimeUnit;

import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.Locators;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.common.TopPaginate;
import com.tibco.automation.page.common.TemplatePage.GSMenu;

public class GridLibrariesPage extends TemplatePage implements Locators.UsersPageLocators, Locators.GridLibraries
{
	public DataGrid datagrid;
	public ExtendedWebDriver driver;
	public String pageTitle = "Grid Libraries";
	public TemplatePage templatePage;
	public TopPaginate topPaginate;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	public String filePath;
	public GridLibrariesPage() {
		
		super("Grid Libraries", GSMenu.GridLibraries);
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
	
	public void verifyUploadGridlib() throws AWTException
	{
		
		
		new ExtendedWebElement(By.xpath(UPLOAD_GRIDLIB_LOC)).click();
        driver.manage().window().maximize();
     
        WebElement element = driver.findElement(By.xpath(BROWSE_BUTTON_LOC));
       filePath= (new File("resources\\data\\commonData\\calculator-1.0.0.1.tar.gz").getAbsolutePath());
        element.sendKeys(filePath);
		new ExtendedWebElement(By.xpath(UPLOAD_BUTTON_LOC)).click();
	
		driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(UPLOAD_ALERT_LOC))).isDisplayed(), "Grid lib is not uploaded", "Grid lib is uploaded successfully");			
		
	}
	
	
	public void verifyDeploy() throws InterruptedException
	{
		driver.findElement(By.xpath(GRID_LIB_CHECKBOX_LOC)).click();
		driver.findElement(By.xpath(DEPLY_BUTTON_LOC)).click();
	
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String mainWindowHandle = driver.getWindowHandle();
         WebDriverWait wait = new WebDriverWait(driver,10);
         Thread.sleep(60);
	     Alert alt = driver.switchTo().alert();
				  alt.accept();
				  waitForPageToLoad(); 
				  for (String winHandle : driver.getWindowHandles()) 
				  {
						driver.switchTo().window(winHandle);
						// driver.manage().window().maximize();
						String uploadFileWindow = driver.getWindowHandle();
					}
				  
			    	driver.switchTo().window(mainWindowHandle);
			    	driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(UPLOAD_ALERT_LOC))).isDisplayed(), "Grid lib is not deployed", "Grid lib is deployed successfully");			
					driver.navigate().refresh();
	}
	
	public void verifyDelete()
	{
		driver.findElement(By.xpath(GRID_LIB_CHECKBOX_LOC)).click();
		driver.findElement(By.xpath(DELETE_BUTTON_LOC)).click();
		
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       String mainWindowHandle = driver.getWindowHandle();
       WebDriverWait wait = new WebDriverWait(driver,10);
		 Alert alt = driver.switchTo().alert();
		  alt.accept();
		  waitForPageToLoad(); 
		  for (String winHandle : driver.getWindowHandles()) 
		  {
				driver.switchTo().window(winHandle);
				// driver.manage().window().maximize();
				String uploadFileWindow = driver.getWindowHandle();
			}
	    	driver.switchTo().window(mainWindowHandle);
	    	driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(UPLOAD_ALERT_LOC))).isDisplayed(), "Grid lib is not deleted", "Grid lib is deleted successfully");			
			
			driver.navigate().refresh();
	}
	
	
	public void verifyUpadte()
	{
		driver.findElement(By.xpath(GRID_LIB_CHECKBOX_LOC)).click();
		driver.findElement(By.xpath(UPDATE_BUTTON_LOC)).click();
		driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(UPDATE_BUTTON_LOC))).isDisplayed(), "Update button is not present", "Update button is present");			
	}
	
	public void verifyDetails()
	{
		
		driver.findElement(By.xpath(CALC_GRIDLIB_LINK_LOC)).click();
		driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(GRIDLIB_DESC_LOC))).isDisplayed(), "Grid lib descrption is not displayed", "Grid lib descrption is displayed");			
		driver.findElement(By.xpath(CANCLE_BUTTON_LOC)).click();
			
	}
	public void verifyCheckbox()
	{
		
		driver.findElement(By.xpath(TABLE_HEADER_CHECKBOX)).click();
		driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(GRID_LIB_CHECKBOX_LOC))).isSelected(), "Checkbox is not working", "Checkbox is working");			
		driver.findElement(By.xpath(TABLE_HEADER_CHECKBOX)).click();
	}
	
	public void verifyDownload() throws AWTException
	{
		verifyUploadGridlib();
		driver.findElement(By.xpath(GRID_LIB_DOWNLOAD_LINK_LOC)).click();
		
	    
		String mainWindowHandle = driver.getWindowHandle();
		
		try {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		      
		       WebDriverWait wait = new WebDriverWait(driver,10);
				 Alert alt = driver.switchTo().alert();
				  alt.accept();
		    System.out.println(alt.getText());
		    Thread.sleep(60);
		  
		  //  driver.getAssertionService().assertTrue(alert.getText().contains("calculator-1.0.0.1.tar.gz"), mainWindowHandle);
		} catch (Exception e) {
		    System.out.println(e);
		}
		 waitForPageToLoad(); 
		  for (String winHandle : driver.getWindowHandles()) 
		  {
				driver.switchTo().window(winHandle);
				String uploadFileWindow = driver.getWindowHandle();
			}
	    	driver.switchTo().window(mainWindowHandle);
			driver.navigate().refresh();
	}
	
		

	}
	