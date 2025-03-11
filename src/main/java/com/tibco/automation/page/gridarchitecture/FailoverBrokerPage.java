package com.tibco.automation.page.gridarchitecture;

import org.openqa.selenium.By;

import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.common.utils.PropertiesUtil;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.Locators;
import com.tibco.automation.page.common.LoginPage;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.common.TopPaginate;

public class FailoverBrokerPage extends TemplatePage implements Locators,Locators.GridArchitectureLocators{

	public DataGrid datagrid; // these are class references
	public ExtendedWebDriver driver;
	public String pageTitle ="System Admin";
	public TemplatePage templatePage;
	public TopPaginate topPaginate;

	public LoginPage loginPage;
	public String userName=PropertiesUtil.getBundle().getPropertyValue("application.username").toString();
	public String password=PropertiesUtil.getBundle().getPropertyValue("application.password").toString();
	public String url=PropertiesUtil.getBundle().getPropertyValue("failover.broker.url").toString();
	
	public FailoverBrokerPage() {
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
		
		//driver.getWaitUtility().waitForElementPresent(By.xpath(String.format(TOP_MENU_LINK_LOC, itemName)));
		new ExtendedWebElement(By.xpath(String.format(TOP_MENU_LINK_LOC, itemName))).click();
		driver.getAssertionService().addAssertionLog("Top menu item "+itemName+" is clicked", MessageTypes.Info);
	}
	
	public void clickSideMenuTitle(String itemName)
	{
		driver.getWaitUtility().waitForElementPresent(String.format(SIDE_MENU_TITLE_LINK_LOC, itemName));
		new ExtendedWebElement(String.format(SIDE_MENU_TITLE_LINK_LOC, itemName)).click();
		driver.getAssertionService().addAssertionLog("Side menu item title "+itemName+" is clicked", MessageTypes.Info);
	}
	
	public void verifyLinkIsEnabled(String itemName)
	{
		driver.getWaitUtility().waitForElementPresent(String.format(SIDE_MENU_ITEM_ENABLED_LINK_LOC, itemName));
		driver.getAssertionService().assertTrue(new ExtendedWebElement(String.format(SIDE_MENU_ITEM_ENABLED_LINK_LOC, itemName)).isPresent(), "Link "+itemName+" is disabled","Link "+itemName+" is enabled");
	}
	
	public void verifyLinkIsDisabled(String itemName)
	{
		driver.getWaitUtility().waitForElementPresent(String.format(SIDE_MENU_ITEM_DISABLED_LINK_LOC, itemName));
		driver.getAssertionService().assertTrue(new ExtendedWebElement(String.format(SIDE_MENU_ITEM_DISABLED_LINK_LOC, itemName)).isPresent(), "Link "+itemName+" is enabled","Link "+itemName+" is disabled");
	}
	
}
