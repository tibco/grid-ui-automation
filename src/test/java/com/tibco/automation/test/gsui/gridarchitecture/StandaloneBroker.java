package com.tibco.automation.test.gsui.gridarchitecture;

import org.testng.annotations.Test;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import com.tibco.automation.page.common.CommonFunctions;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.gridarchitecture.SecondaryDirectorPage;
import com.tibco.automation.page.gridarchitecture.StandaloneBrokerPage;

public class StandaloneBroker extends WebDriverTestCase{

	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public TemplatePage templatepage;
	public StandaloneBrokerPage standaloneBroker;
	public CommonFunctions commonFunctions;
	
	
	@Test(description="Verify enabled and disabled pages on dashboard")
	public void Grid_4733()
	{
		standaloneBroker=new StandaloneBrokerPage();
		standaloneBroker.waitForPageToLoad();
		standaloneBroker.clickTopMenuItem("Dashboard");
		standaloneBroker.waitForPageToLoad();
		standaloneBroker.verifyLinkIsDisabled("Overview");
		standaloneBroker.verifyLinkIsDisabled("Director Monitor");
		standaloneBroker.verifyLinkIsDisabled("Grid Search");
		standaloneBroker.verifyLinkIsEnabled("Broker Monitor");
	}
	
	@Test(description="Verify enabled and disabled pages on grid components --> drivers")
	public void Grid_4734()
	{
		standaloneBroker=new StandaloneBrokerPage();
		standaloneBroker.waitForPageToLoad();
		standaloneBroker.clickTopMenuItem("Grid Components");
		standaloneBroker.waitForPageToLoad();
		standaloneBroker.clickSideMenuTitle("Drivers");
		standaloneBroker.waitForPageToLoad(); 
		standaloneBroker.verifyLinkIsEnabled("Web Services");
		standaloneBroker.verifyLinkIsEnabled("Driver Admin");
	}
	
	@Test(description="Verify enabled and disabled pages on Grid components --> Brokers")
	public void Grid_4735()
	{
		standaloneBroker=new StandaloneBrokerPage();
		standaloneBroker.waitForPageToLoad();
		standaloneBroker.clickTopMenuItem("Grid Components");
		standaloneBroker.waitForPageToLoad();
		standaloneBroker.clickSideMenuTitle("Brokers");
		standaloneBroker.waitForPageToLoad();
		standaloneBroker.verifyLinkIsDisabled("Broker Configuration");
		standaloneBroker.verifyLinkIsDisabled("Broker Routing");
		standaloneBroker.verifyLinkIsDisabled("Broker Admin");
	}
	
	@Test(description="Verify enabled and disabled pages on Grid components --> Engines")
	public void Grid_4736()
	{
		standaloneBroker=new StandaloneBrokerPage();
		standaloneBroker.waitForPageToLoad();
		standaloneBroker.clickTopMenuItem("Grid Components");
		standaloneBroker.waitForPageToLoad();
		standaloneBroker.clickSideMenuTitle("Engines");
		standaloneBroker.waitForPageToLoad();
		standaloneBroker.verifyLinkIsDisabled("Engine Configurations");
		standaloneBroker.verifyLinkIsDisabled("Engine Properties");
		standaloneBroker.verifyLinkIsDisabled("Daemon Admin");
		standaloneBroker.verifyLinkIsEnabled("Engine Admin");
	}
	
	
	@Test(description="Verify enabled and disabled pages on Services --> Services")
	public void Grid_4737()
	{
		standaloneBroker=new StandaloneBrokerPage();
		standaloneBroker.waitForPageToLoad();
		standaloneBroker.clickTopMenuItem("Services");
		standaloneBroker.waitForPageToLoad();
		standaloneBroker.clickSideMenuTitle("Services");
		standaloneBroker.waitForPageToLoad();
		standaloneBroker.verifyLinkIsEnabled("Service Types");
		standaloneBroker.verifyLinkIsEnabled("Service Conditions");
		standaloneBroker.verifyLinkIsDisabled("Spanned Services Admin");
		standaloneBroker.verifyLinkIsDisabled("Cache Schemas");
		standaloneBroker.verifyLinkIsEnabled("Service Group Admin");
		standaloneBroker.verifyLinkIsEnabled("Service Session Admin");
		standaloneBroker.verifyLinkIsEnabled("Cache Regions");
		standaloneBroker.verifyLinkIsEnabled("Service Test");
		standaloneBroker.verifyLinkIsEnabled("Grid Libraries");
	}
	
	
	@Test(description="Verify enabled and disabled pages on Services --> Batch")
	public void Grid_4738()
	{
		standaloneBroker=new StandaloneBrokerPage();
		standaloneBroker.waitForPageToLoad();
		standaloneBroker.clickTopMenuItem("Services");
		standaloneBroker.waitForPageToLoad();
		standaloneBroker.clickSideMenuTitle("Batch");
		standaloneBroker.waitForPageToLoad();
		standaloneBroker.verifyLinkIsEnabled("Batch Schedule");
		standaloneBroker.verifyLinkIsEnabled("Batch Admin");	
		standaloneBroker.verifyLinkIsEnabled("Batch Definitions");
		standaloneBroker.verifyLinkIsEnabled("Service Runners");
	}
	
	
	@Test(description="Verify enabled and disabled pages on Admin --> System Admin")
	public void Grid_4739()
	{
		standaloneBroker=new StandaloneBrokerPage();
		standaloneBroker.waitForPageToLoad();
		standaloneBroker.clickTopMenuItem("Admin");
		standaloneBroker.waitForPageToLoad();
		standaloneBroker.clickSideMenuTitle("System Admin");
		standaloneBroker.waitForPageToLoad();
		standaloneBroker.verifyLinkIsEnabled("Manager Configuration");
		standaloneBroker.verifyLinkIsEnabled("Manager Import/Export");	
		standaloneBroker.verifyLinkIsEnabled("Manager Hooks");
		standaloneBroker.verifyLinkIsEnabled("Email Notifications");	
		standaloneBroker.verifyLinkIsEnabled("SNMP Event Traps");
		standaloneBroker.verifyLinkIsEnabled("License Information");	
		standaloneBroker.verifyLinkIsEnabled("Manager Reinstall");
	}
	
	
	@Test(description="Verify enabled and disabled pages on Admin --> User Admin")
	public void Grid_4740()
	{
		standaloneBroker=new StandaloneBrokerPage();
		standaloneBroker.waitForPageToLoad();
		standaloneBroker.clickTopMenuItem("Admin");
		standaloneBroker.waitForPageToLoad();
		standaloneBroker.clickSideMenuTitle("User Admin");
		standaloneBroker.waitForPageToLoad();
		standaloneBroker.verifyLinkIsDisabled("User Admin");
		standaloneBroker.verifyLinkIsDisabled("Role Admin");	
		standaloneBroker.verifyLinkIsDisabled("Authentication");
		standaloneBroker.verifyLinkIsDisabled("Run-As Credentials");	
	}
	
	
	@Test(description="Verify enabled and disabled pages on diagnostics page")
	public void Grid_4741()
	{
		standaloneBroker=new StandaloneBrokerPage();
		standaloneBroker.waitForPageToLoad();
		standaloneBroker.clickTopMenuItem("Diagnostics");
		standaloneBroker.waitForPageToLoad();
		standaloneBroker.verifyLinkIsEnabled("Manager Diagnostics");
		standaloneBroker.verifyLinkIsEnabled("Real Time Log");
		standaloneBroker.verifyLinkIsEnabled("Service Diagnostics");
		standaloneBroker.verifyLinkIsEnabled("Scheduler Instrumentation");
	}
}
