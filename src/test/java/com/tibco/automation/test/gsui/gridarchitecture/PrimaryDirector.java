package com.tibco.automation.test.gsui.gridarchitecture;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import com.tibco.automation.page.common.CommonFunctions;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.gridarchitecture.PrimaryDirectorPage;

public class PrimaryDirector extends WebDriverTestCase{

	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public TemplatePage templatepage;
	public PrimaryDirectorPage primaryDirector;
	public CommonFunctions commonFunctions;

	
	
	@Test(description="Verify enabled and disabled pages on dashboard")
	public void Grid_4724()
	{
		primaryDirector=new PrimaryDirectorPage();
		primaryDirector.waitForPageToLoad();
		primaryDirector.clickTopMenuItem("Dashboard");
		primaryDirector.waitForPageToLoad();
		primaryDirector.verifyLinkIsEnabled("Overview");
		primaryDirector.verifyLinkIsEnabled("Director Monitor");
		primaryDirector.verifyLinkIsEnabled("Grid Search");
		primaryDirector.verifyLinkIsDisabled("Broker Monitor");
	}
	
	@Test(description="Verify enabled and disabled pages on grid components --> drivers")
	public void Grid_4725()
	{
		primaryDirector=new PrimaryDirectorPage();
		primaryDirector.waitForPageToLoad();
		primaryDirector.clickTopMenuItem("Grid Components");
		primaryDirector.waitForPageToLoad();
		primaryDirector.clickSideMenuTitle("Drivers");
		primaryDirector.waitForPageToLoad(); 
		primaryDirector.verifyLinkIsEnabled("Web Services");
		primaryDirector.verifyLinkIsEnabled("Driver Admin");
	}
	
	@Test(description="Verify enabled and disabled pages on Grid components --> Brokers")
	public void Grid_4726()
	{
		primaryDirector=new PrimaryDirectorPage();
		primaryDirector.waitForPageToLoad();
		primaryDirector.clickTopMenuItem("Grid Components");
		primaryDirector.waitForPageToLoad();
		primaryDirector.clickSideMenuTitle("Brokers");
		primaryDirector.waitForPageToLoad();
		primaryDirector.verifyLinkIsEnabled("Broker Configuration");
		primaryDirector.verifyLinkIsEnabled("Broker Routing");
		primaryDirector.verifyLinkIsEnabled("Broker Admin");
	}
	
	@Test(description="Verify enabled and disabled pages on Grid components --> Engines")
	public void Grid_4727()
	{
		primaryDirector=new PrimaryDirectorPage();
		primaryDirector.waitForPageToLoad();
		primaryDirector.clickTopMenuItem("Grid Components");
		primaryDirector.waitForPageToLoad();
		primaryDirector.clickSideMenuTitle("Engines");
		primaryDirector.waitForPageToLoad();
		primaryDirector.verifyLinkIsEnabled("Engine Configurations");
		primaryDirector.verifyLinkIsEnabled("Engine Properties");
		primaryDirector.verifyLinkIsEnabled("Daemon Admin");
		primaryDirector.verifyLinkIsDisabled("Engine Admin");
	}
	
	
	@Test(description="Verify enabled and disabled pages on Services --> Services")
	public void Grid_4728()
	{
		primaryDirector=new PrimaryDirectorPage();
		primaryDirector.waitForPageToLoad();
		primaryDirector.clickTopMenuItem("Services");
		primaryDirector.waitForPageToLoad();
		primaryDirector.clickSideMenuTitle("Services");
		primaryDirector.waitForPageToLoad();
		primaryDirector.verifyLinkIsEnabled("Grid Libraries");
		primaryDirector.verifyLinkIsEnabled("Service Types");
		primaryDirector.verifyLinkIsEnabled("Service Conditions");
		primaryDirector.verifyLinkIsEnabled("Spanned Services Admin");
		primaryDirector.verifyLinkIsEnabled("Cache Schemas");
		primaryDirector.verifyLinkIsDisabled("Service Group Admin");
		primaryDirector.verifyLinkIsDisabled("Service Session Admin");
		primaryDirector.verifyLinkIsDisabled("Cache Regions");
		primaryDirector.verifyLinkIsDisabled("Service Test");
	}
	
	
	@Test(description="Verify enabled and disabled pages on Services --> Batch")
	public void Grid_4729()
	{
		primaryDirector=new PrimaryDirectorPage();
		primaryDirector.waitForPageToLoad();
		primaryDirector.clickTopMenuItem("Services");
		primaryDirector.waitForPageToLoad();
		primaryDirector.clickSideMenuTitle("Batch");
		primaryDirector.waitForPageToLoad();
		primaryDirector.verifyLinkIsEnabled("Batch Schedule");
		primaryDirector.verifyLinkIsEnabled("Batch Admin");	
		primaryDirector.verifyLinkIsDisabled("Batch Definitions");
		primaryDirector.verifyLinkIsDisabled("Service Runners");
	}
	
	
	@Test(description="Verify enabled and disabled pages on Admin --> System Admin")
	public void Grid_4730()
	{
		primaryDirector=new PrimaryDirectorPage();
		primaryDirector.waitForPageToLoad();
		primaryDirector.clickTopMenuItem("Admin");
		primaryDirector.waitForPageToLoad();
		primaryDirector.clickSideMenuTitle("System Admin");
		primaryDirector.waitForPageToLoad();
		primaryDirector.verifyLinkIsEnabled("Manager Configuration");
		primaryDirector.verifyLinkIsEnabled("Manager Import/Export");	
		primaryDirector.verifyLinkIsEnabled("Manager Hooks");
		primaryDirector.verifyLinkIsEnabled("Email Notifications");	
		primaryDirector.verifyLinkIsEnabled("SNMP Event Traps");
		primaryDirector.verifyLinkIsEnabled("License Information");	
		primaryDirector.verifyLinkIsEnabled("Manager Reinstall");
	}
	
	
	@Test(description="Verify enabled and disabled pages on Admin --> User Admin")
	public void Grid_4731()
	{
		primaryDirector=new PrimaryDirectorPage();
		primaryDirector.waitForPageToLoad();
		primaryDirector.clickTopMenuItem("Admin");
		primaryDirector.waitForPageToLoad();
		primaryDirector.clickSideMenuTitle("User Admin");
		primaryDirector.waitForPageToLoad();
		primaryDirector.verifyLinkIsEnabled("User Admin");
		primaryDirector.verifyLinkIsEnabled("Role Admin");	
		primaryDirector.verifyLinkIsEnabled("Authentication");
		primaryDirector.verifyLinkIsEnabled("Run-As Credentials");	
	}
	
	
	@Test(description="Verify enabled and disabled pages on diagnostics page")
	public void Grid_4732()
	{
		primaryDirector=new PrimaryDirectorPage();
		primaryDirector.waitForPageToLoad();
		primaryDirector.clickTopMenuItem("Diagnostics");
		primaryDirector.waitForPageToLoad();
		primaryDirector.verifyLinkIsEnabled("Manager Diagnostics");
		primaryDirector.verifyLinkIsEnabled("Real Time Log");
		primaryDirector.verifyLinkIsDisabled("Service Diagnostics");
		primaryDirector.verifyLinkIsDisabled("Scheduler Instrumentation");
	}
}
