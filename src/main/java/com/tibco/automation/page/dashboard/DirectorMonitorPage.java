package com.tibco.automation.page.dashboard;

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

public class DirectorMonitorPage extends TemplatePage implements Locators,Locators.DirectorMonitorPageLocators{

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
	
	public DirectorMonitorPage() {
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
	
	public void clickDirectorMonitorLink()
	{
		driver.getWaitUtility().waitForElementPresent(DIRECTOR_MONITOR_LINK_LOC);
		new ExtendedWebElement(DIRECTOR_MONITOR_LINK_LOC).click();
		driver.getAssertionService().addAssertionLog("Clicking director monitor link", MessageTypes.Info);
	}
	
	public void verifyAllCheckboxesAreChecked()
	{
		driver.getWaitUtility().waitForElementPresent(ENGINE_CHECKBOX_LOC);
		String checkedEngineStatus=new ExtendedWebElement(ENGINE_CHECKBOX_LOC).getAttribute("checked");
		String checkedTaskStatus=new ExtendedWebElement(TASK_CHECKBOX_LOC).getAttribute("checked");
		String checkedServicesStatus=new ExtendedWebElement(SERVICES_CHECKBOX_LOC).getAttribute("checked");
		String checkedSystemStatus=new ExtendedWebElement(SYSTEM_CHECKBOX_LOC).getAttribute("checked");
		if (checkedEngineStatus.equalsIgnoreCase("true") && checkedTaskStatus.equalsIgnoreCase("true") && checkedServicesStatus.equalsIgnoreCase("true") && checkedSystemStatus.equalsIgnoreCase("true"))
			driver.getAssertionService().addAssertionLog("All checkboxes are checked by default", MessageTypes.Pass);
		else
			driver.getAssertionService().addAssertionLog("All checkboxes are not checked by default", MessageTypes.Fail);
	}
	
	
	public void verifyAllGraphsArePresent()
	{
		driver.getWaitUtility().waitForElementPresent(ENGINE_GRAPH_LOC);
		driver.getAssertionService().assertElementPresent(By.xpath(ENGINE_GRAPH_LOC), "Engine Graph");
		driver.getAssertionService().assertElementPresent(By.xpath(TASK_GRAPH_LOC), "Task Graph");
		driver.getAssertionService().assertElementPresent(By.xpath(SERVICES_GRAPH_LOC), "Services Graph");
		driver.getAssertionService().assertElementPresent(By.xpath(SYSTEM_GRAPH_LOC), "System Graph");
	}
	
	public void clickEngineCheckBox()
	{
		driver.getWaitUtility().waitForElementPresent(ENGINE_CHECKBOX_LOC);
		new ExtendedWebElement(ENGINE_CHECKBOX_LOC).click();
		driver.getAssertionService().addAssertionLog("Engine checkbox is clicked", MessageTypes.Info);
	}
	
	public void clickTaskCheckBox()
	{
		driver.getWaitUtility().waitForElementPresent(TASK_CHECKBOX_LOC);
		new ExtendedWebElement(TASK_CHECKBOX_LOC).click();
		driver.getAssertionService().addAssertionLog("Task checkbox is clicked", MessageTypes.Info);
	}
	
	public void clickServicesCheckBox()
	{
		driver.getWaitUtility().waitForElementPresent(SERVICES_CHECKBOX_LOC);
		new ExtendedWebElement(SERVICES_CHECKBOX_LOC).click();
		driver.getAssertionService().addAssertionLog("Services checkbox is clicked", MessageTypes.Info);
	}
	
	public void clickSystemCheckBox()
	{
		driver.getWaitUtility().waitForElementPresent(SYSTEM_CHECKBOX_LOC);
		new ExtendedWebElement(SYSTEM_CHECKBOX_LOC).click();
		driver.getAssertionService().addAssertionLog("System checkbox is clicked", MessageTypes.Info);
	}
	
	public void verifyEngineGraphIsPresent()
	{
		driver.getWaitUtility().waitForElementPresent(ENGINE_GRAPH_LOC);
		driver.getAssertionService().assertElementPresent(By.xpath(ENGINE_GRAPH_LOC), "Engine Graph");
	}
	
	public void verifyEngineGraphIsNotPresent()
	{
		driver.getWaitUtility().waitForElementNotPresent(ENGINE_GRAPH_LOC);
		driver.getAssertionService().assertElementNotPresent(By.xpath(ENGINE_GRAPH_LOC), "Engine Graph");
	}
	
	public void verifyTaskGraphIsPresent()
	{
		driver.getWaitUtility().waitForElementPresent(TASK_GRAPH_LOC);
		driver.getAssertionService().assertElementPresent(By.xpath(TASK_GRAPH_LOC), "Task Graph");
	}
	
	public void verifyTaskGraphIsNotPresent()
	{
		driver.getWaitUtility().waitForElementNotPresent(TASK_GRAPH_LOC);
		driver.getAssertionService().assertElementNotPresent(By.xpath(TASK_GRAPH_LOC), "Task Graph");
	}
	
	public void verifyServicesGraphIsPresent()
	{
		driver.getWaitUtility().waitForElementPresent(SERVICES_GRAPH_LOC);
		driver.getAssertionService().assertElementPresent(By.xpath(SERVICES_GRAPH_LOC), "Services Graph");
	}
	
	public void verifyServicesGraphIsNotPresent()
	{
		driver.getWaitUtility().waitForElementNotPresent(SERVICES_GRAPH_LOC);
		driver.getAssertionService().assertElementNotPresent(By.xpath(SERVICES_GRAPH_LOC), "Services Graph");
	}
	
	public void verifySystemGraphIsPresent()
	{
		driver.getWaitUtility().waitForElementPresent(SYSTEM_GRAPH_LOC);
		driver.getAssertionService().assertElementPresent(By.xpath(SYSTEM_GRAPH_LOC), "System Graph");
	}
	
	public void verifySystemGraphIsNotPresent()
	{
		driver.getWaitUtility().waitForElementNotPresent(SYSTEM_GRAPH_LOC);
		driver.getAssertionService().assertElementNotPresent(By.xpath(SYSTEM_GRAPH_LOC), "System Graph");
	}
}
