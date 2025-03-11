package com.tibco.automation.page.admin.systemadmin;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.common.utils.PropertiesUtil;
import com.tibco.automation.page.common.CommonFunctions;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.Locators;
import com.tibco.automation.page.common.LoginPage;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.common.TopPaginate;
import com.tibco.automation.page.common.TemplatePage.GSMenu;

public class Manager_Reinstall_Page extends TemplatePage implements Locators.ManagerReinstallLocators{

	public DataGrid datagrid; // these are class references
	public ExtendedWebDriver driver;
	public String pageTitle ="System Admin";
	public TemplatePage templatePage;
	public TopPaginate topPaginate;
	public static String parentHandle;
	public CommonFunctions commonFunctions=new CommonFunctions();
	public String filePath;
	public LoginPage loginPage;
	public String userName=PropertiesUtil.getBundle().getPropertyValue("application.username").toString();
	public String password=PropertiesUtil.getBundle().getPropertyValue("application.password").toString();
	public String url=PropertiesUtil.getBundle().getPropertyValue("application.url").toString();
	
	public Manager_Reinstall_Page() {
		super("Manager Hooks", GSMenu.ManagerHooks);
		
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
	
	public void clickTopMenuItem(String itemName)
	{
		
		driver.getWaitUtility().waitForElementPresent(By.xpath(String.format(TOP_MENU_LINK_LOC, itemName)));
		new ExtendedWebElement(By.xpath(String.format(TOP_MENU_LINK_LOC, itemName))).click();
		driver.getAssertionService().addAssertionLog("Top menu item "+itemName+" is clicked", MessageTypes.Info);
	}
	
	public void clickManagerReinstallLink()
	{
		driver.getWaitUtility().waitForElementPresent(MANAGER_REINSTALL_LINK_LOC);
		new ExtendedWebElement(MANAGER_REINSTALL_LINK_LOC).click();
		driver.getAssertionService().addAssertionLog("Clicking manager reinstall link", MessageTypes.Info);
	}
	
	public void clickOnNextButton()
	{
		driver.getWaitUtility().waitForElementPresent(NEXT_BUTTON_LOC);
		driver.getAssertionService().addAssertionLog("Next button is present", MessageTypes.Info);
		new ExtendedWebElement(NEXT_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Next button is clicked", MessageTypes.Info);
	}
	
	public void clickOnPreviousButton()
	{
		driver.getWaitUtility().waitForElementPresent(PREVIOUS_BUTTON_LOC);
		driver.getAssertionService().addAssertionLog("Previous button is present", MessageTypes.Info);
		new ExtendedWebElement(PREVIOUS_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Previous button is clicked", MessageTypes.Info);
	}
	
	public void clickOnStartOver()
	{
		driver.getWaitUtility().waitForElementPresent(START_OVER_BUTTON_LOC);
		driver.getAssertionService().addAssertionLog("Start over button is present", MessageTypes.Info);
		new ExtendedWebElement(START_OVER_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Start over button is clicked", MessageTypes.Info);
	}
	
	public void verifyNextIsClicked()
	{
		driver.getWaitUtility().waitForElementPresent(SECOND_PAGE_VERIFICATION_TEXT_LOC);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(SECOND_PAGE_VERIFICATION_TEXT_LOC).isPresent(), "User is moved to next page");
	}
	
	public void verifyPreviousIsClicked()
	{
		driver.getWaitUtility().waitForElementPresent(FIRST_PAGE_VERIFICATION_TEXT_LOC);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(FIRST_PAGE_VERIFICATION_TEXT_LOC).isPresent(), "User is moved to previous page");
	}
	
	public void verifyStartOverIsClicked()
	{
		driver.getWaitUtility().waitForElementPresent(FIRST_PAGE_VERIFICATION_TEXT_LOC);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(FIRST_PAGE_VERIFICATION_TEXT_LOC).isPresent(), "User is moved to first page");
	}
}
