
package com.tibco.automation.page.diagnostics;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.Select;

import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.common.utils.PropertiesUtil;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.Locators;
import com.tibco.automation.page.common.LoginPage;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.common.TopPaginate;
import com.tibco.automation.page.common.TemplatePage.GSMenu;

public class ServiceDiagnostics_Page extends TemplatePage implements  Locators.ServiceDiagnostics
{
	public DataGrid datagrid;
	public ExtendedWebDriver driver;
	public static String parentHandle;
	public TemplatePage templatePage;
	public TopPaginate topPaginate;
	public String mainWindowHandle;
	public LoginPage loginPage;
	public String userName=PropertiesUtil.getBundle().getPropertyValue("application.username").toString();
	public String password=PropertiesUtil.getBundle().getPropertyValue("application.password").toString();
	public String url=PropertiesUtil.getBundle().getPropertyValue("application.url").toString();
	public ServiceDiagnostics_Page() {
		
		loginPage=new LoginPage();
	
		loginPage.openPage(url);
		loginPage.login(userName, password);
		loginPage.verifyLoggedInCredentials();
		System.out.println("GSMenu..!!");
		datagrid = new DataGrid(); // as already defined above we are just intializing
		driver = getDriver();
		templatePage = new TemplatePage();
		topPaginate = new TopPaginate();
		System.out.println(" After GSMenu..!!");

		
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
	public void clickServiceDiagnoticsLink()
	{
		driver.manage().window().maximize();
	String winHandleBefore = driver.getWindowHandle();

    for (String winHandle : driver.getWindowHandles()) {
        driver.switchTo().window(winHandle);
    }
		
		driver.getWaitUtility().waitForElementPresent(SERVICEDIAGNOSTICS_LINK_LOC);
		new ExtendedWebElement(SERVICEDIAGNOSTICS_LINK_LOC).click();
	}


	public void clickOnSearch() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(SEARCH_BUTTON_LOC);
		new ExtendedWebElement(SEARCH_BUTTON_LOC).click();
		driver.getAssertionService().assertTrue(new ExtendedWebElement(SEARCH_BUTTON_LOC).isPresent(), "Search button on page is not present", "Search button on page is present" );
	}


	public void selectServiceId() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Select id=new Select(driver.findElement(By.id("idselect")));
		
		id.selectByIndex(1);
		
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

	public void verifySearch() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(ENGINE_TABLE_LOC);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(ENGINE_TABLE_LOC).isPresent(), "Search button on page is not working", "Search button on page is working" );
	}
	public boolean isAlertPresent(){
		try{
		driver.switchTo().alert();
		return true;
		}catch(NoAlertPresentException ex){
		return false;
		}
	}

	public void clickOnHelp() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(PAGE_HELP);
		new ExtendedWebElement(PAGE_HELP).click();
		driver.getAssertionService().assertTrue(new ExtendedWebElement(PAGE_HELP).isPresent(), "Page help is not present", "Page help is present" );
	}


	public void verifyPageHelp() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(PAGE_HELP_TITLE);
		driver.getAssertionService().assertElementPresent(By.xpath(PAGE_HELP_TITLE), "Service Diagnostics help title");
	
		
	}


	public void clickOnEmptySearch() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(SEARCH_BUTTON_LOC);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(SEARCH_BUTTON_LOC).isPresent(), "Search button is not present", "Search button is present" );
		
		new ExtendedWebElement(SEARCH_BUTTON_LOC).click();
		
		if(isAlertPresent()){
			driver.getAssertionService().addAssertionLog("Alert is present", MessageTypes.Info);
			
			Alert alert = driver.switchTo().alert();
		
			System.out.println(alert.getText());
		String msg=alert.getText();
			alert.accept();
			
			}
	}
}