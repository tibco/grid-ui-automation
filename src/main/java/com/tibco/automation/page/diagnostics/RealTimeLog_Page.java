
package com.tibco.automation.page.diagnostics;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.common.utils.PropertiesUtil;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.Locators;
import com.tibco.automation.page.common.LoginPage;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.common.TopPaginate;
import com.tibco.automation.page.common.TemplatePage.GSMenu;

public class RealTimeLog_Page extends TemplatePage implements  Locators.RealTimeLogs
{
	public DataGrid datagrid;
	public ExtendedWebDriver driver;
	public static String parentHandle="";
	public TemplatePage templatePage;
	public TopPaginate topPaginate;
	public String mainWindowHandle;
	public LoginPage loginPage;
	public String userName=PropertiesUtil.getBundle().getPropertyValue("application.username").toString();
	public String password=PropertiesUtil.getBundle().getPropertyValue("application.password").toString();
	public String url=PropertiesUtil.getBundle().getPropertyValue("application.url").toString();
	public RealTimeLog_Page() {
		
		

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
	public void closeWindow()
	{
		driver.close();
	}
	
	public void clickTopMenuItem(String itemName)
	{
		
		driver.manage().window().maximize();
		String winHandleBefore = driver.getWindowHandle();

	    for (String winHandle : driver.getWindowHandles()) {
	        driver.switchTo().window(winHandle);
	    }
			
		driver.getWaitUtility().waitForElementPresent(By.xpath(String.format(TOP_MENU_LINK_LOC, itemName)));
		new ExtendedWebElement(By.xpath(String.format(TOP_MENU_LINK_LOC, itemName))).click();
	}
	
	
	public void clickRealTimeLogLink()
	{
		
		driver.getWaitUtility().waitForElementPresent(REALTIMELOG_LINK_LOC);
		new ExtendedWebElement(REALTIMELOG_LINK_LOC).click();
	}
	public void verifyRealTimeLogWindow()
	{
		 driver.manage().timeouts().setScriptTimeout(3, TimeUnit.MINUTES);
		 addStaticWait(30000);

	    
		driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(CLEAR_BUTTON_LOC))).isPresent(),"Real time log is not open", "Real time log window is open successfully.");		
	
	
	}

	public void switchToParentWindow()
	{
		driver.switchTo().window(parentHandle);
	}
    public void verifyClearButton()
    {
    	 driver.manage().timeouts().setScriptTimeout(3, TimeUnit.MINUTES);
		 addStaticWait(30000);
    	
	    driver.getWaitUtility().waitForElementPresent(CLEAR_BUTTON_LOC);
    	driver.findElement(By.xpath(CLEAR_BUTTON_LOC)).click();
   
		driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(CLEAR_BUTTON_LOC))).isPresent(),"Clear button is not clicked", "Clear button is clicked .");		
	
	
		
    }
    
    public void switchToNewlyOpenedWindow()
	{
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		    driver.manage().window().maximize();
		}
	}

    public void verifySpanshotButton()
    { 
    	
    	driver.manage().timeouts().setScriptTimeout(2, TimeUnit.MINUTES);
	 addStaticWait(20000);
    
    	
		driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(SNAPSHOT_BUTTON_LOC))).isPresent(),"Snapshot button is not clicked", "Snapshot button is clicked .");		
		
		}
		
    }
