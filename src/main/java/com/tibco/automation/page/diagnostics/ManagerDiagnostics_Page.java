package com.tibco.automation.page.diagnostics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.common.utils.PropertiesUtil;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.Locators;
import com.tibco.automation.page.common.LoginPage;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.common.TopPaginate;

public class ManagerDiagnostics_Page extends TemplatePage implements Locators.ManagerDiagnostics {
	public DataGrid datagrid;
	public ExtendedWebDriver driver;
	public static String parentHandle="";
	public TemplatePage templatePage;
	public TopPaginate topPaginate;
	public String mainWindowHandle;
	public LoginPage loginPage;
	public String userName = PropertiesUtil.getBundle().getPropertyValue("application.username").toString();
	public String password = PropertiesUtil.getBundle().getPropertyValue("application.password").toString();
	public String url = PropertiesUtil.getBundle().getPropertyValue("application.url").toString();

	public ManagerDiagnostics_Page() {

		loginPage = new LoginPage();
		loginPage.openPage(url);
		loginPage.login(userName, password);
		loginPage.verifyLoggedInCredentials();
		System.out.println("GSMenu..!!");
		datagrid = new DataGrid(); // as already defined above we are just
									// intializing
		driver = getDriver();
		templatePage = new TemplatePage();
		topPaginate = new TopPaginate();
		System.out.println(" After GSMenu..!!");

	}
	
	
	
	public void switchToParentWindow()
	{
		driver.switchTo().window(parentHandle);
	}
	public void clickTopMenuItem(String itemName) {
		
		String winHandleBefore1 = driver.getWindowHandle();

	    for (String winHandle : driver.getWindowHandles()) {
	        driver.switchTo().window(winHandle);
	        driver.manage().window().maximize();
	    }

		driver.getWaitUtility().waitForElementPresent(By.xpath(String.format(TOP_MENU_LINK_LOC, itemName)));
		new ExtendedWebElement(By.xpath(String.format(TOP_MENU_LINK_LOC, itemName))).click();
		
	}

	
	public void clickManagerDiagnosticsLink() {
		String winHandleBefore1 = driver.getWindowHandle();

	    for (String winHandle : driver.getWindowHandles()) {
	        driver.switchTo().window(winHandle);
	        driver.manage().window().maximize();
	    }
		driver.getWaitUtility().waitForElementPresent(MANAGER_DIAGNOSTICS_LINK_LOC);
		new ExtendedWebElement(MANAGER_DIAGNOSTICS_LINK_LOC).click();
	
	}

	public void verifyDownloadButton() {

		driver.findElement(By.xpath(DOWNLOAD_BUTTON_LOC)).click();
		waitForPageToLoad();
		driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(DOWNLOAD_BUTTON_LOC))).isPresent(),
				"Download button is not clicked", "Download button is clicked .");

		try {
			clickonok();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
	public void verifyDisplayButton() {
		// TODO Auto-generated method stub
		String currentTab = driver.getWindowHandle();
		driver.findElement(By.xpath(MANAGER_LOGS_CHECKBOX_LOC)).click();
		driver.findElement(By.xpath(ENV_LOG_CHECKBOX_LOC)).click();
		
		driver.findElement(By.xpath(DISPLAY_BUTTON_LOC)).click();
		driver.getAssertionService().addAssertionLog("Alert", MessageTypes.Info);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath(MANAGER_LOGS_CHECKBOX_LOC)).click();
		driver.findElement(By.xpath(ENV_LOG_CHECKBOX_LOC)).click();
		
		driver.findElement(By.xpath(DISPLAY_BUTTON_LOC)).click();

		for (String tab : driver.getWindowHandles()) {
			 
	         if (!tab.equals(currentTab)) 
	         {
	 
	         driver.switchTo().window(tab);
	 
	         // Perform operation on new Tab
	 
	         }
		}
		driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(VERIFY_DISPLAY_BUTTON))).isPresent(),
				"Display button is not clicked", "Display button is clicked .");
		waitForPageToLoad();
		
		driver.close();
		 

		
		    
		  }
	
	
public void switchToMainWindow()
{
	for(String winHandle : driver.getWindowHandles())
	  {
	    if (winHandle == driver.getWindowHandles().toArray()[driver.getWindowHandles().size()-1])     
	     {
	      continue;
	    
	     }
	   
	    driver.switchTo().window(winHandle);
	    
	  }
}
	public void verifyManagerLogsCheckbox() {
		// TODO Auto-generated method stub
		
	    driver.getWaitUtility().waitForElementPresent(MANAGER_LOGS_CHECKBOX_LOC);
		driver.findElement(By.xpath(MANAGER_LOGS_CHECKBOX_LOC)).click();
		driver.findElement(By.xpath(MANAGER_LOGS_CHECKBOX_LOC)).click();
		driver.getAssertionService().assertTrue(
				new ExtendedWebElement((By.xpath(MANAGER_LOGS_CHECKBOX_LOC))).isSelected(),
				"Manager logs check box is not clicked", "Manager logs check box is clicked .");

	}

	public void verifyEnvLogsCheckbox() {
		 for (String winHandle : driver.getWindowHandles()) {
		        driver.switchTo().window(winHandle);
		        driver.manage().window().maximize();
		    }
		driver.findElement(By.xpath(MANAGER_LOGS_CHECKBOX_LOC)).click();
		driver.findElement(By.xpath(ENV_LOG_CHECKBOX_LOC)).click();
		driver.findElement(By.xpath(ENV_LOG_CHECKBOX_LOC)).click();
		driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(ENV_LOG_CHECKBOX_LOC))).isSelected(),
				"Env logs checkbox is not clicked", "Env logs checkbox is clicked .");
		
	}

	public void verifyTaskQueuesCheckbox() {
		 for (String winHandle : driver.getWindowHandles()) {
		        driver.switchTo().window(winHandle);
		        driver.manage().window().maximize();
		    }
		 driver.getWaitUtility().waitForElementPresent(TASK_QUEUE_CHECKBOX_LOC);
		driver.findElement(By.xpath(TASK_QUEUE_CHECKBOX_LOC)).click();
		driver.getAssertionService().assertTrue(
				new ExtendedWebElement((By.xpath(TASK_QUEUE_CHECKBOX_LOC))).isSelected(),
				"Task queues checkbox is not clicked", "Task queues checkbox is clicked .");

	}

	public void verifywithinlastButton() {;
		 driver.getWaitUtility().waitForElementPresent(BETWEEN_LOC);
		driver.findElement(By.xpath(BETWEEN_LOC)).click();
		driver.findElement(By.xpath(WITHIN_LOST_LOC)).click();
		driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(WITHIN_LOST_LOC))).isEnabled(),
				"Within last radio button is not clicked", "Within last radio button is clicked .");

	}

	public void verifyManagerLogsWithinLastMin() {
		String currentTab = driver.getWindowHandle();
		driver.findElement(By.xpath(ENV_LOG_CHECKBOX_LOC)).click();
		driver.findElement(By.xpath(WITHIN_LAST_MIN_LOC)).click();
		 
		driver.findElement(By.xpath(DISPLAY_BUTTON_LOC)).click();
		for (String tab : driver.getWindowHandles()) {
			 
	         if (!tab.equals(currentTab)) 
	         {
	 
	         driver.switchTo().window(tab);
	 
	         // Perform operation on new Tab
	 
	         }
		}
		driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(VERIFY_DISPLAY_BUTTON))).isPresent(),
				"Display button is not clicked", "Display button is clicked .");

		waitForPageToLoad();
		driver.close();
	}

	public void verifyManagerLogsWithinLastHr() {
		String currentTab = driver.getWindowHandle();
		driver.findElement(By.xpath(ENV_LOG_CHECKBOX_LOC)).click();
		driver.findElement(By.xpath(WITHIN_LAST_HOUR_LOC)).click();
		driver.findElement(By.xpath(DISPLAY_BUTTON_LOC)).click();
		for (String tab : driver.getWindowHandles()) {
			 
	         if (!tab.equals(currentTab)) 
	         {
	 
	         driver.switchTo().window(tab);
	 
	         // Perform operation on new Tab
	 
	         }
		}
		driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath("//a[@name='Manager Log']"))).isPresent(),
				"Display button is not clicked", "Display button is clicked .");
	waitForPageToLoad();
		
		driver.close();
		 
	}
	

	public void verifyManagerLogsWithinLastYears() throws InterruptedException {
		String currentTab = driver.getWindowHandle();
		driver.findElement(By.xpath(ENV_LOG_CHECKBOX_LOC)).click();
		driver.findElement(By.xpath(WITHIN_LAST_YEAR_LOC)).click();
		driver.findElement(By.xpath(DISPLAY_BUTTON_LOC)).click();
		for (String tab : driver.getWindowHandles()) {
			 
	         if (!tab.equals(currentTab)) 
	         {
	 
	         driver.switchTo().window(tab);
	 
	         // Perform operation on new Tab
	 
	         }
		}
		driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(VERIFY_DISPLAY_BUTTON))).isPresent(),
				"Display button is not clicked", "Display button is clicked .");
		waitForPageToLoad();
		
		driver.close();
		 
	}

	public void verifyDisplayEnvButton() {
		String currentTab = driver.getWindowHandle();
		 driver.getWaitUtility().waitForElementPresent(MANAGER_LOGS_CHECKBOX_LOC);
			driver.findElement(By.xpath(MANAGER_LOGS_CHECKBOX_LOC)).click();
		driver.findElement(By.xpath(DISPLAY_BUTTON_LOC)).click();
		for (String tab : driver.getWindowHandles()) {
			 
	         if (!tab.equals(currentTab)) 
	         {
	 
	         driver.switchTo().window(tab);
	 
	         // Perform operation on new Tab
	 
	         }
		}
		driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(VERIFY_DISPLAY_BUTTON))).isPresent(),
				"Display button is not clicked", "Display button is clicked .");
		waitForPageToLoad();
		
		driver.close();
		 
	}
	public void verifyDownloadEnvButton() throws InterruptedException {
		driver.findElement(By.xpath(ENV_LOG_CHECKBOX_LOC)).click();
		driver.findElement(By.xpath(DOWNLOAD_BUTTON_LOC)).click();
		//driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(DOWNLOAD_BUTTON_LOC))).isPresent(),
			//	"Download button is not clicked", "Download button is clicked.");
		clickonok();

	}
	public void verifyDisplayTaskQueuesButton()
	{
		String currentTab = driver.getWindowHandle();
		
		driver.findElement(By.xpath(ENV_LOG_CHECKBOX_LOC)).click();
		driver.findElement(By.xpath(MANAGER_LOGS_CHECKBOX_LOC)).click();
		driver.findElement(By.xpath(TASK_QUEUE_CHECKBOX_LOC)).click();
		driver.findElement(By.xpath(DISPLAY_BUTTON_LOC)).click();
		for (String tab : driver.getWindowHandles()) {
			 
	         if (!tab.equals(currentTab)) 
	         {
	 
	         driver.switchTo().window(tab);
	 
	         // Perform operation on new Tab
	 
	         }
		}
		driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath("//a[@name='Task Queues']"))).isPresent(),
				"Task Queues window is not displayed", "Task Queues window is displayed.");
		waitForPageToLoad();
		
		driver.close();
	}
	public  void clickonok() throws InterruptedException
	{
		waitForPageToLoad();
		for (String winHandle : driver.getWindowHandles()) {
			Robot robotObj = null;
			driver.switchTo().window(winHandle);
			String uploadFileWindow = driver.getWindowHandle();

		try {
				robotObj = new Robot();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
			driver.manage().window().maximize();
			  Thread.sleep(5000L);
			 
			  robotObj.keyRelease(KeyEvent.VK_DOWN);
			
			  robotObj.keyPress(KeyEvent.VK_ENTER);
		}
			}
	public void verifyDownloadTaskQueuesButton() throws InterruptedException
	{
		driver.findElement(By.xpath(ENV_LOG_CHECKBOX_LOC)).click();
		driver.findElement(By.xpath(MANAGER_LOGS_CHECKBOX_LOC)).click();
		driver.findElement(By.xpath(TASK_QUEUE_CHECKBOX_LOC)).click();
		driver.findElement(By.xpath(DOWNLOAD_BUTTON_LOC)).click();
		clickonok();
	}
	public void verifyMaxLine()
	{
		String currentTab = driver.getWindowHandle();
		
		driver.findElement(By.xpath(MAX_LOG_LINE_LOC)).clear();
		driver.findElement(By.xpath(MAX_LOG_LINE_LOC)).sendKeys("100000");
		driver.findElement(By.xpath(DISPLAY_BUTTON_LOC)).click();
		for (String tab : driver.getWindowHandles()) {
			 
	         if (!tab.equals(currentTab)) 
	         {
	 
	         driver.switchTo().window(tab);
	 
	         // Perform operation on new Tab
	 
	         }
		}
		driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(VERIFY_DISPLAY_BUTTON))).isPresent(),
				"Display button is not clicked", "Display button is clicked .");
		waitForPageToLoad();
		
		driver.close();
		
	}
		
	
}
