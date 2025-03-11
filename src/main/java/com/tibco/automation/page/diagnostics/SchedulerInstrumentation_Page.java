
package com.tibco.automation.page.diagnostics;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
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

public class SchedulerInstrumentation_Page extends TemplatePage implements  Locators.SchedulerInstrumentation
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
	public SchedulerInstrumentation_Page() {
		
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
	public void clickInstrumentationLink()
	{
		driver.manage().window().maximize();
	String winHandleBefore = driver.getWindowHandle();

    for (String winHandle : driver.getWindowHandles()) {
        driver.switchTo().window(winHandle);
    }
		
		driver.getWaitUtility().waitForElementPresent(SCHEDULER_INSTRUMENATION_LINK_LOC);
		new ExtendedWebElement(SCHEDULER_INSTRUMENATION_LINK_LOC).click();
	}


	public void clickOnSearch() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(SEARCH_BUTTON);
		new ExtendedWebElement(SEARCH_BUTTON).click();
		driver.getAssertionService().assertTrue(new ExtendedWebElement(SEARCH_BUTTON).isPresent(), "Search button on page is not present", "Search button on page is present" );
	}


	

	public void switchToParentWindow()
	{
		driver.switchTo().window(parentHandle);
	}
	
	public void switchToNewlyOpenedWindow()
	{
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle);
		    driver.manage().window().maximize();
		}
	}


	public void clickonStartDateCalender() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(START_DATE_CALENDAR);
		new ExtendedWebElement(START_DATE_CALENDAR).click();
		driver.getAssertionService().assertTrue(new ExtendedWebElement(START_DATE_TEXBOX_LOC).isPresent(), "Page help is not present", "Page help is present" );
	
     List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='datetimepicker1']//td"));
		
		for(WebElement ele:allDates)
		{
			
			String date=ele.getText();
			
			if(date.equalsIgnoreCase("28"))
			{
				ele.click();
				break;
			}
			
	}

	
}
	public void clickonEndDateCalender() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(END_DATE_CALENDAR);
		new ExtendedWebElement(END_DATE_CALENDAR).click();
		driver.getAssertionService().assertTrue(new ExtendedWebElement(END_DATE_TEXBOX_LOC).isPresent(), "End calender button is not present", "End calender button is present" );
	
List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='datetimepicker2']//td"));
		
		for(WebElement ele:allDates)
		{
			
			String date=ele.getText();
			
			if(date.equalsIgnoreCase("1"))
			{
				ele.click();
				break;
			}
			
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
	public boolean isAlertPresent(){
		try{
		driver.switchTo().alert();
		return true;
		}catch(NoAlertPresentException ex){
		return false;
		}
}
	public void updateResultsPerPage(int noOfRows) 
	{
		addStaticWait(3000);
		waitForPageToLoad();
		driver.findElement(By.xpath(RESULTS_PER_PAGE_LOC)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		if (isAlertPresent())
		acceptAlert();
        driver.findElement(By.xpath(RESULTS_PER_PAGE_LOC)).sendKeys(""+noOfRows);
        addStaticWait(1000);
        driver.findElement(By.xpath(RESULTS_PER_PAGE_LOC)).sendKeys(Keys.ENTER);
		driver.getAssertionService().addAssertionLog("Results per page is set to "+noOfRows, MessageTypes.Info);
		addStaticWait(5000);
		driver.findElement(By.xpath(RESULTS_PER_PAGE_LOC)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		 addStaticWait(1000);
		driver.findElement(By.xpath(RESULTS_PER_PAGE_LOC)).sendKeys("50");
		 addStaticWait(1000);
	        driver.findElement(By.xpath(RESULTS_PER_PAGE_LOC)).sendKeys(Keys.ENTER);
	}
	public void waitforElement()
	{
		driver.getWaitUtility().waitForElementPresent(GLOBAL_ACTION);
	}
	public void goToLastPage()
	{
		addStaticWait(2000);
		if (new ExtendedWebElement(PAGINATION_LAST_BUTTON_BOTTOM_ENABLED_LOC).isPresent())
		{
			driver.getAssertionService().addAssertionLog("Move to last page button is enabled, clicking on it", MessageTypes.Pass);
			new ExtendedWebElement(PAGINATION_LAST_BUTTON_BOTTOM_ENABLED_LOC).click();
		}
		else if (new ExtendedWebElement(PAGINATION_LAST_BUTTON_BOTTOM_DISABLED_LOC).isPresent())
		{
			driver.getAssertionService().addAssertionLog("Move to last page button is not enabled, already on last page", MessageTypes.Pass);
		}
		else
		{
			driver.getAssertionService().addAssertionLog("Something went wrong, please check", MessageTypes.Fail);
		}
	}

	
	public void goToFirstPage()
	{
		addStaticWait(2000);
		if (new ExtendedWebElement(PAGINATION_FIRST_BUTTON_BOTTOM_ENABLED_LOC).isPresent())
		{
			driver.getAssertionService().addAssertionLog("Move to last page button is enabled, clicking on it", MessageTypes.Pass);
			new ExtendedWebElement(PAGINATION_FIRST_BUTTON_BOTTOM_ENABLED_LOC).click();
		}
		else if (new ExtendedWebElement(PAGINATION_FIRST_BUTTON_BOTTOM_DISABLED_LOC).isPresent())
		{
			driver.getAssertionService().addAssertionLog("Move to first page button is not enabled, already on first page", MessageTypes.Pass);
		}
		else
		{
			driver.getAssertionService().addAssertionLog("Something went wrong, please check", MessageTypes.Fail);
		}
	}

	public void clickOnAdminPage() {
		// TODO Auto-generated method stub
	
		driver.getWaitUtility().waitForElementPresent(ADMIN_PAGE_LINK);
		new ExtendedWebElement(ADMIN_PAGE_LINK).click();
		driver.getAssertionService().assertTrue(new ExtendedWebElement(ADMIN_PAGE_LINK).isPresent(), "Admin Page is not present", "Admin Page  is present" );
	
		
		
		driver.getWaitUtility().waitForElementPresent(SYS_ADMIN);
		new ExtendedWebElement(SYS_ADMIN).click();
		driver.getAssertionService().assertTrue(new ExtendedWebElement(SYS_ADMIN).isPresent(), "System admin is not present", "system admin Page  is present" );
	
		
		
		driver.getWaitUtility().waitForElementPresent(MANAGER_CONFIGURATION_LINK);
		new ExtendedWebElement(MANAGER_CONFIGURATION_LINK).click();
		driver.getAssertionService().assertTrue(new ExtendedWebElement(MANAGER_CONFIGURATION_LINK).isPresent(), "Manager config page is not present", "Manager config page is present" );
		driver.getWaitUtility().waitForElementPresent(SERVICES_SIDE_MENU_LOC);
		new ExtendedWebElement(SERVICES_SIDE_MENU_LOC).click();
		driver.getAssertionService().assertTrue(new ExtendedWebElement(SERVICES_SIDE_MENU_LOC).isPresent(), "Scheduler instrumentation is not present", "Scheduler instrumentation is present" );
	
		
	}


	public void selectLevel1() {
		// TODO Auto-generated method stub
		WebElement testDropDown = driver.findElement(By.name("new-61"));  
		Select dropdown = new Select(testDropDown); 
		dropdown.selectByIndex(1);
		driver.getWaitUtility().waitForElementPresent(SAVE_BUTTON);
		new ExtendedWebElement(SAVE_BUTTON).click();
		driver.getAssertionService().assertTrue(new ExtendedWebElement(SAVE_BUTTON).isPresent(), "Save button is not clicked", "Save button is clicked" );
		
	}


	public void verifyCheckPoints() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(CHECK_POINTS_CHEKBOX);
		new ExtendedWebElement(CHECK_POINTS_CHEKBOX).click();
		driver.getAssertionService().assertElementNotPresent(By.xpath(CHECKPOINTS_LOC), "Check point is not present");
		 driver.getWaitUtility().waitForElementPresent(CHECK_POINTS_CHEKBOX);
		new ExtendedWebElement(CHECK_POINTS_CHEKBOX).click();
		driver.getAssertionService().assertTrue(new ExtendedWebElement(CHECKPOINTS_LOC).isPresent(), "checknot is not present","Check point is present");
			
	}


	public void clickOnDiagnosticsPage() {
		// TODO Auto-generated method stub
		
		driver.getWaitUtility().waitForElementPresent(DIAGNOSTICS_LINK);
		new ExtendedWebElement(DIAGNOSTICS_LINK).click();
		driver.getAssertionService().assertTrue(new ExtendedWebElement(DIAGNOSTICS_LINK).isPresent(), "Diagnostics page is not opened", "Diagnostics page is opened" );
		
		
		driver.getWaitUtility().waitForElementPresent(SCHEDULER_INSTRUMENTAION_LINK);
		new ExtendedWebElement(SCHEDULER_INSTRUMENTAION_LINK).click();
		driver.getAssertionService().assertTrue(new ExtendedWebElement(SCHEDULER_INSTRUMENTAION_LINK).isPresent(), "Scheduler instrumentation page is not opened", "Scheduler instrumentation page is opened" );
		
	}


	public void verifyMatchItems() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(MATCH_ITEMS_CHECKBOX);
		new ExtendedWebElement(MATCH_ITEMS_CHECKBOX).click();
		driver.getAssertionService().assertElementNotPresent(By.xpath(MATCHITEMS_LOC), "Match items is not present");
		 driver.getWaitUtility().waitForElementPresent(MATCH_ITEMS_CHECKBOX);
		new ExtendedWebElement(MATCH_ITEMS_CHECKBOX).click();
		driver.getAssertionService().assertTrue(new ExtendedWebElement(MATCHITEMS_LOC).isPresent(), "Match items are not present","Match items are present");
			
	}


	public void verifyWaitingList() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(WAITING_LIST_CHECKBOX);
		new ExtendedWebElement(WAITING_LIST_CHECKBOX).click();
		driver.getAssertionService().assertElementNotPresent(By.xpath(WAITINGLIST_LOC), "Waiting list is not present");
		 driver.getWaitUtility().waitForElementPresent(WAITING_LIST_CHECKBOX);
		new ExtendedWebElement(WAITING_LIST_CHECKBOX).click();
		driver.getAssertionService().assertTrue(new ExtendedWebElement(WAITINGLIST_LOC).isPresent(), "Waiting list is not present","Waiting list is present");
			
	}


	public void verifyEngineInfo() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(ENGINE_INFO_CHECKBOX);
		new ExtendedWebElement(ENGINE_INFO_CHECKBOX).click();
		driver.getAssertionService().assertElementNotPresent(By.xpath(ENGINEINFO_LOC), "Engine info is not present");
		 driver.getWaitUtility().waitForElementPresent(ENGINE_INFO_CHECKBOX);
		new ExtendedWebElement(ENGINE_INFO_CHECKBOX).click();
		driver.getAssertionService().assertTrue(new ExtendedWebElement(ENGINEINFO_LOC).isPresent(), "Engine info is not present","Engine info is present");
			
	}


	public void verifyMoreinfo() {
		// TODO Auto-generated method stub
		driver.getWaitUtility().waitForElementPresent(MORE_INFO_BUTTON);
		new ExtendedWebElement(MORE_INFO_BUTTON).click();
		driver.getAssertionService().assertTrue(new ExtendedWebElement(MORE_INFO_LOC).isPresent(), "More info is not present","Engine info is present");
		
		 driver.getWaitUtility().waitForElementPresent(MORE_INFO_BUTTON);
		new ExtendedWebElement(MORE_INFO_BUTTON).click();
		driver.getAssertionService().assertElementNotPresent(By.xpath(MORE_INFO_LOC), "More info is not present");
			
	}




	public void provideSearchString() {
		// TODO Auto-generated method stub
		
		driver.findElement(By.xpath(KEYWORDSEARCH_LOC)).sendKeys("lin");
	
		 addStaticWait(1000);
		 
	}


	public void verifySearch() {
		// TODO Auto-generated method stub
		driver.getAssertionService().assertTrue(new ExtendedWebElement(WAITINGLIST_LOC).isPresent(), "Search is not working","Search is working");
		
	}


	public void verifyClearButton() {
		// TODO Auto-generated method stub
		
		
		driver.findElement(By.xpath(CLEAR_BUTTON)).click();
		boolean flag =driver.findElement(By.xpath(KEYWORDSEARCH_LOC)).getText().equals("");
		driver.getAssertionService().assertTrue(flag, "Clear button is not working", "Clear button is working");
		
		}


	


}