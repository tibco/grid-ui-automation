package com.tibco.automation.test.gsui.gridarchitecture;

import org.testng.annotations.Test;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import com.tibco.automation.page.common.CommonFunctions;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.gridarchitecture.FailoverBrokerPage;

public class FailoverBroker extends WebDriverTestCase{

	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public TemplatePage templatepage;
	public FailoverBrokerPage failoverBroker;
	public CommonFunctions commonFunctions;
	
	
	@Test(description="Verify enabled and disabled pages on dashboard")
	public void Grid_4742()
	{
		failoverBroker=new FailoverBrokerPage();
		failoverBroker.waitForPageToLoad();
		failoverBroker.clickTopMenuItem("Dashboard");
		failoverBroker.waitForPageToLoad();
		failoverBroker.verifyLinkIsDisabled("Overview");
		failoverBroker.verifyLinkIsDisabled("Director Monitor");
		failoverBroker.verifyLinkIsDisabled("Grid Search");
		failoverBroker.verifyLinkIsEnabled("Broker Monitor");
	}
	
	@Test(description="Verify enabled and disabled pages on grid components --> drivers")
	public void Grid_4743()
	{
		failoverBroker=new FailoverBrokerPage();
		failoverBroker.waitForPageToLoad();
		failoverBroker.clickTopMenuItem("Grid Components");
		failoverBroker.waitForPageToLoad();
		failoverBroker.clickSideMenuTitle("Drivers");
		failoverBroker.waitForPageToLoad(); 
		failoverBroker.verifyLinkIsEnabled("Web Services");
		failoverBroker.verifyLinkIsEnabled("Driver Admin");
	}
	
	@Test(description="Verify enabled and disabled pages on Grid components --> Brokers")
	public void Grid_4744()
	{
		failoverBroker=new FailoverBrokerPage();
		failoverBroker.waitForPageToLoad();
		failoverBroker.clickTopMenuItem("Grid Components");
		failoverBroker.waitForPageToLoad();
		failoverBroker.clickSideMenuTitle("Brokers");
		failoverBroker.waitForPageToLoad();
		failoverBroker.verifyLinkIsDisabled("Broker Configuration");
		failoverBroker.verifyLinkIsDisabled("Broker Routing");
		failoverBroker.verifyLinkIsDisabled("Broker Admin");
	}
	
	@Test(description="Verify enabled and disabled pages on Grid components --> Engines")
	public void Grid_4745()
	{
		failoverBroker=new FailoverBrokerPage();
		failoverBroker.waitForPageToLoad();
		failoverBroker.clickTopMenuItem("Grid Components");
		failoverBroker.waitForPageToLoad();
		failoverBroker.clickSideMenuTitle("Engines");
		failoverBroker.waitForPageToLoad();
		failoverBroker.verifyLinkIsDisabled("Engine Configurations");
		failoverBroker.verifyLinkIsDisabled("Engine Properties");
		failoverBroker.verifyLinkIsDisabled("Daemon Admin");
		failoverBroker.verifyLinkIsEnabled("Engine Admin");
	}
	
	
	@Test(description="Verify enabled and disabled pages on Services --> Services")
	public void Grid_4746()
	{
		failoverBroker=new FailoverBrokerPage();
		failoverBroker.waitForPageToLoad();
		failoverBroker.clickTopMenuItem("Services");
		failoverBroker.waitForPageToLoad();
		failoverBroker.clickSideMenuTitle("Services");
		failoverBroker.waitForPageToLoad();
		failoverBroker.verifyLinkIsEnabled("Service Types");
		failoverBroker.verifyLinkIsEnabled("Service Conditions");
		failoverBroker.verifyLinkIsDisabled("Spanned Services Admin");
		failoverBroker.verifyLinkIsDisabled("Cache Schemas");
		failoverBroker.verifyLinkIsEnabled("Service Group Admin");
		failoverBroker.verifyLinkIsEnabled("Service Session Admin");
		failoverBroker.verifyLinkIsEnabled("Cache Regions");
		failoverBroker.verifyLinkIsEnabled("Service Test");
		failoverBroker.verifyLinkIsEnabled("Grid Libraries");
	}
	
	
	@Test(description="Verify enabled and disabled pages on Services --> Batch")
	public void Grid_4747()
	{
		failoverBroker=new FailoverBrokerPage();
		failoverBroker.waitForPageToLoad();
		failoverBroker.clickTopMenuItem("Services");
		failoverBroker.waitForPageToLoad();
		failoverBroker.clickSideMenuTitle("Batch");
		failoverBroker.waitForPageToLoad();
		failoverBroker.verifyLinkIsEnabled("Batch Schedule");
		failoverBroker.verifyLinkIsEnabled("Batch Admin");	
		failoverBroker.verifyLinkIsEnabled("Batch Definitions");
		failoverBroker.verifyLinkIsEnabled("Service Runners");
	}
	
	
	@Test(description="Verify enabled and disabled pages on Admin --> System Admin")
	public void Grid_4748()
	{
		failoverBroker=new FailoverBrokerPage();
		failoverBroker.waitForPageToLoad();
		failoverBroker.clickTopMenuItem("Admin");
		failoverBroker.waitForPageToLoad();
		failoverBroker.clickSideMenuTitle("System Admin");
		failoverBroker.waitForPageToLoad();
		failoverBroker.verifyLinkIsEnabled("Manager Configuration");
		failoverBroker.verifyLinkIsEnabled("Manager Import/Export");	
		failoverBroker.verifyLinkIsEnabled("Manager Hooks");
		failoverBroker.verifyLinkIsEnabled("Email Notifications");	
		failoverBroker.verifyLinkIsEnabled("SNMP Event Traps");
		failoverBroker.verifyLinkIsEnabled("License Information");	
		failoverBroker.verifyLinkIsEnabled("Manager Reinstall");
	}
	
	
	@Test(description="Verify enabled and disabled pages on Admin --> User Admin")
	public void Grid_4749()
	{
		failoverBroker=new FailoverBrokerPage();
		failoverBroker.waitForPageToLoad();
		failoverBroker.clickTopMenuItem("Admin");
		failoverBroker.waitForPageToLoad();
		failoverBroker.clickSideMenuTitle("User Admin");
		failoverBroker.waitForPageToLoad();
		failoverBroker.verifyLinkIsDisabled("User Admin");
		failoverBroker.verifyLinkIsDisabled("Role Admin");	
		failoverBroker.verifyLinkIsDisabled("Authentication");
		failoverBroker.verifyLinkIsDisabled("Run-As Credentials");	
	}
	
	
	@Test(description="Verify enabled and disabled pages on diagnostics page")
	public void Grid_4750()
	{
		failoverBroker=new FailoverBrokerPage();
		failoverBroker.waitForPageToLoad();
		failoverBroker.clickTopMenuItem("Diagnostics");
		failoverBroker.waitForPageToLoad();
		failoverBroker.verifyLinkIsEnabled("Manager Diagnostics");
		failoverBroker.verifyLinkIsEnabled("Real Time Log");
		failoverBroker.verifyLinkIsEnabled("Service Diagnostics");
		failoverBroker.verifyLinkIsEnabled("Scheduler Instrumentation");
	}
}
