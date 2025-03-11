package com.tibco.automation.page.dashboard;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.common.utils.PropertiesUtil;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.Locators;
import com.tibco.automation.page.common.LoginPage;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.common.TopPaginate;
import com.tibco.automation.page.common.TemplatePage.GSMenu;

import org.openqa.selenium.By;

import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;

public class OverviewPage extends TemplatePage implements Locators,Locators.OverviewPageLocators{
	public DataGrid datagrid; // these are class references
	public ExtendedWebDriver driver;
	public String pageTitle ="Services";
	public TemplatePage templatePage;
	public TopPaginate topPaginate;
	public static String parentHandle;
	public LoginPage loginPage;
	public String userName=PropertiesUtil.getBundle().getPropertyValue("application.username").toString();
	public String password=PropertiesUtil.getBundle().getPropertyValue("application.password").toString();
	public String url=PropertiesUtil.getBundle().getPropertyValue("application.url").toString();
	
	public OverviewPage() {
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
		
		driver.getWaitUtility().waitForElementPresent(By.xpath(String.format(TOP_MENU_LINK_LOC, itemName)));
		new ExtendedWebElement(By.xpath(String.format(TOP_MENU_LINK_LOC, itemName))).click();
		driver.getAssertionService().addAssertionLog("Top menu item "+itemName+" is clicked", MessageTypes.Info);
	}
	
	public void verifyPageTitleIsPresent(String title)
	{
		driver.getWaitUtility().waitForElementPresent(String.format(OPENED_PAGE_TITLE_LOC, title));
		driver.getAssertionService().assertElementPresent(By.xpath(String.format(OPENED_PAGE_TITLE_LOC, title)), title+" page");
	}
	
	public void clickLink(String linkText)
	{
		driver.getWaitUtility().waitForElementPresent(String.format(LINK_LOC, linkText));
		new ExtendedWebElement(String.format(LINK_LOC, linkText));
		driver.getAssertionService().addAssertionLog("Clicking on link "+linkText, MessageTypes.Info);
	}
	
	public void clickOverviewLink()
	{
		driver.getWaitUtility().waitForElementPresent(OVERVIEW_LINK_LOC);
		new ExtendedWebElement(OVERVIEW_LINK_LOC).click();
		driver.getAssertionService().addAssertionLog("Clicking overview link", MessageTypes.Info);
	}
	
	public void clickServiceGraph()
	{
		driver.getWaitUtility().waitForElementPresent(SERVICE_GRAPH_LOC);
		new ExtendedWebElement(SERVICE_GRAPH_LOC).click();
		driver.getAssertionService().addAssertionLog("Services graph is clicked", MessageTypes.Info);
	}
	
	public void clickServiceSessionAdminButton()
	{
		driver.getWaitUtility().waitForElementPresent(SERVICE_SESSION_ADMIN_BUTTON_LOC);
		new ExtendedWebElement(SERVICE_SESSION_ADMIN_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Service session admin button is clicked", MessageTypes.Info);
	}
	
	public void clickBrokerGraph()
	{
		driver.getWaitUtility().waitForElementPresent(BROKER_GRAPH_LOC);
		new ExtendedWebElement(BROKER_GRAPH_LOC).click();
		driver.getAssertionService().addAssertionLog("Broker graph is clicked", MessageTypes.Info);
	}
	
	public void clickBrokerAdminButton()
	{
		driver.getWaitUtility().waitForElementPresent(BROKER_ADMIN_BUTTON_LOC);
		new ExtendedWebElement(BROKER_ADMIN_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Broker admin button is clicked", MessageTypes.Info);
	}
	
	public void clickDriverGraph()
	{
		driver.getWaitUtility().waitForElementPresent(DRIVER_GRAPH_LOC);
		new ExtendedWebElement(DRIVER_GRAPH_LOC).click();
		driver.getAssertionService().addAssertionLog("Driver admin graph is clicked", MessageTypes.Info);
	}
	
	public void clickDriverAdminButton()
	{
		driver.getWaitUtility().waitForElementPresent(DRIVER_ADMIN_BUTTON_LOC);
		new ExtendedWebElement(DRIVER_ADMIN_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Driver admin button is clicked", MessageTypes.Info);
	}
	
	public void clickEnginesGraph()
	{
		driver.getWaitUtility().waitForElementPresent(ENGINE_GRAPH_LOC);
		new ExtendedWebElement(ENGINE_GRAPH_LOC).click();
		driver.getAssertionService().addAssertionLog("Engines admin graph is clicked", MessageTypes.Info);
	}
	
	public void clickEngineAdminButton()
	{
		driver.getWaitUtility().waitForElementPresent(ENGINE_ADMIN_BUTTON_LOC);
		new ExtendedWebElement(ENGINE_ADMIN_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Engine admin button is clicked", MessageTypes.Info);
	}
	
	public void clickDaemonGraph()
	{
		driver.getWaitUtility().waitForElementPresent(DAEMON_GRAPH_LOC);
		new ExtendedWebElement(DAEMON_GRAPH_LOC).click();
		driver.getAssertionService().addAssertionLog("Daemon admin graph is clicked", MessageTypes.Info);
	}
	
	public void clickDaemonAdminButton()
	{
		driver.getWaitUtility().waitForElementPresent(DAEMON_ADMIN_BUTTON_LOC);
		new ExtendedWebElement(DAEMON_ADMIN_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Daemon admin button is clicked", MessageTypes.Info);
	}
	
	public void clickHelpButton()
	{
		driver.getWaitUtility().waitForElementPresent(HELP_BUTTON_LOC);
		new ExtendedWebElement(HELP_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Help button is clicked", MessageTypes.Info);
	}
	
	public void verifyOverviewHelpIsPresent()
	{
		driver.getWaitUtility().waitForElementPresent(OVERVIEW_HELP_TITLE_LOC);
		driver.getAssertionService().assertElementPresent(By.xpath(OVERVIEW_HELP_TITLE_LOC), "Overview help title");
	}
	
	public void verifyOverviewHelpIsNotPresent()
	{
		driver.getWaitUtility().waitForElementNotPresent(OVERVIEW_HELP_TITLE_LOC);
		driver.getAssertionService().assertElementNotPresent(By.xpath(OVERVIEW_HELP_TITLE_LOC), "Overview help title");
	}
	
	public void clickDownloadButton()
	{
		driver.getWaitUtility().waitForElementPresent(DOWNLOAD_BUTTON_LOC);
		new ExtendedWebElement(DOWNLOAD_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Download button is clicked", MessageTypes.Info);
	}
	
	public void verifyDownloadTextIsPresent()
	{
		driver.getWaitUtility().waitForElementPresent(DOWNLOAD_VERIFICATION_TEXT_LOC);
		driver.getAssertionService().assertElementPresent(By.xpath(DOWNLOAD_VERIFICATION_TEXT_LOC), "Download verification text");
	}
	
	public void verifyDownloadTextIsNotPresent()
	{
		driver.getWaitUtility().waitForElementNotPresent(DOWNLOAD_VERIFICATION_TEXT_LOC);
		driver.getAssertionService().assertElementNotPresent(By.xpath(DOWNLOAD_VERIFICATION_TEXT_LOC), "Download verification text");
	}
}
