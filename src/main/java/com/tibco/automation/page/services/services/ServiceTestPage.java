package com.tibco.automation.page.services.services;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;

import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.Locators;
import com.tibco.automation.page.common.Locators.ServiceTestLocators;
import com.tibco.automation.page.common.Locators.UsersPageLocators;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.common.TopPaginate;
import com.tibco.automation.page.common.TemplatePage.GSMenu;
import com.tibco.automation.page.common.TopPaginate.MoreActions;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ServiceTestPage extends TemplatePage implements ServiceTestLocators  {
	public DataGrid datagrid; // these are class references
	public ExtendedWebDriver driver;
	public String pageTitle ="Role Admin";
	public TemplatePage templatePage;
	public TopPaginate topPaginate;
	String winHandleBefore;
	public String parentWinHandle;
	public Select select;
	public JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public ServiceTestPage()
	{
		
		super("Service Test", GSMenu.ServiceTest);
		System.out.println("GSMenu..!!");
		datagrid = new DataGrid(); // as already defined above we are just initializing 
		driver = getDriver();
		templatePage = new TemplatePage();
		topPaginate = new TopPaginate();
		System.out.println(" After GSMenu..!!");
	}
	
		@Override
		public void waitForPageToLoad() {
		super.waitForPageToLoad();
		}
		public void clickServiceTest()
		{
			 driver.findElement(SERVICE).click();
			 boolean X=new ExtendedWebElement(String.format(LINPACK)).isPresent();
			 boolean X1=new ExtendedWebElement(String.format(PERFORMANCE)).isPresent();
			 if(X=true)
			 {
				if(X1=true)
				{
					driver.getAssertionService().assertTrue(X1, "After clicking on Service Test following option does not  appear on side bar:1.Linpack Test2.Performance Test", "After clicking on Service Test following option appear's on side bar:\r\n" + 
					 		"1.Linpack Test\r\n" + 
					 		"2.Performance Test");
				}
				
			 }
			 else
			 {
				 driver.getAssertionService().assertTrue(X, "After clicking on Service Test following option does not  appear on side bar:1.Linpack Test2.Performance Test", "After clicking on Service Test following option appear's on side bar:\r\n" + 
					 		"1.Linpack Test\r\n" + 
					 		"2.Performance Test");
			 }
		}
		
		public void clickLinpackSubmit()
		{
			driver.findElement(SERVICE).click();
			driver.getWaitUtility().waitForElementPresent(LINPACK);
			WebElement option1 = driver.findElement(LINPACK);
			option1.click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	        driver.findElement(SUBMIT).click();
	      
	       
		}
		public void verifyClickLinpackSubmit()
		{
			String text = driver.findElement(SESSION).getText();
			String lin="Linpack Test";
			driver.findElement(SERVICESESSIONADMIN).click();
			driver.getAssertionService().assertEquals(text, lin,"Submitted test is");
		}
		
		public void clickPerformanceSubmit()
		{
			driver.findElement(SERVICE).click();
			driver.getWaitUtility().waitForElementPresent(PERFORMANCE);
			WebElement option1 = driver.findElement(PERFORMANCE);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", option1);
			//option1.click();
	        driver.findElement(SUBMIT).click();
			}
		public void verifyClickPerformanceSubmit()
		{
			driver.getWaitUtility().waitForElementPresent(SERVICESESSIONADMIN);
			driver.findElement(SERVICESESSIONADMIN).click();
			String lin="Latency Test";
			String text = driver.findElement(SESSION).getText();
			driver.getAssertionService().assertEquals(text, lin,"Submitted test is");
		}

}
