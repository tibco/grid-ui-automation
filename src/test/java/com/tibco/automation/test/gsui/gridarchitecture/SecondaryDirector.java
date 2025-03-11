package com.tibco.automation.test.gsui.gridarchitecture;

import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import org.testng.annotations.Test;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import com.tibco.automation.page.common.CommonFunctions;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.gridarchitecture.SecondaryDirectorPage;

public class SecondaryDirector extends WebDriverTestCase{
	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public TemplatePage templatepage;
	public SecondaryDirectorPage secondaryDirector;
	public CommonFunctions commonFunctions;

	
	
	@Test(description="Verify enabled and disabled pages on dashboard")
	public void Grid_4751()
	{
		secondaryDirector=new SecondaryDirectorPage();
		secondaryDirector.waitForPageToLoad();
		secondaryDirector.clickTopMenuItem("Dashboard");
		secondaryDirector.waitForPageToLoad();
		secondaryDirector.verifyLinkIsEnabled("Overview");
		secondaryDirector.verifyLinkIsEnabled("Director Monitor");
		secondaryDirector.verifyLinkIsEnabled("Grid Search");
		secondaryDirector.verifyLinkIsDisabled("Broker Monitor");
	}
	
	@Test(description="Verify enabled and disabled pages on grid components --> drivers")
	public void Grid_4752()
	{
		secondaryDirector=new SecondaryDirectorPage();
		secondaryDirector.waitForPageToLoad();
		secondaryDirector.clickTopMenuItem("Grid Components");
		secondaryDirector.waitForPageToLoad();
		secondaryDirector.clickSideMenuTitle("Drivers");
		secondaryDirector.waitForPageToLoad(); 
		secondaryDirector.verifyLinkIsEnabled("Web Services");
		secondaryDirector.verifyLinkIsEnabled("Driver Admin");
	}
	
	@Test(description="Verify enabled and disabled pages on Grid components --> Brokers")
	public void Grid_4753()
	{
		secondaryDirector=new SecondaryDirectorPage();
		secondaryDirector.waitForPageToLoad();
		secondaryDirector.clickTopMenuItem("Grid Components");
		secondaryDirector.waitForPageToLoad();
		secondaryDirector.clickSideMenuTitle("Brokers");
		secondaryDirector.waitForPageToLoad();
		secondaryDirector.verifyLinkIsEnabled("Broker Configuration");
		secondaryDirector.verifyLinkIsEnabled("Broker Routing");
		secondaryDirector.verifyLinkIsEnabled("Broker Admin");
	}
	
	@Test(description="Verify enabled and disabled pages on Grid components --> Engines")
	public void Grid_4754()
	{
		secondaryDirector=new SecondaryDirectorPage();
		secondaryDirector.waitForPageToLoad();
		secondaryDirector.clickTopMenuItem("Grid Components");
		secondaryDirector.waitForPageToLoad();
		secondaryDirector.clickSideMenuTitle("Engines");
		secondaryDirector.waitForPageToLoad();
		secondaryDirector.verifyLinkIsDisabled("Engine Configurations");
		secondaryDirector.verifyLinkIsEnabled("Engine Properties");
		secondaryDirector.verifyLinkIsEnabled("Daemon Admin");
		secondaryDirector.verifyLinkIsDisabled("Engine Admin");
	}
	
	
	@Test(description="Verify enabled and disabled pages on Services --> Services")
	public void Grid_4755()
	{
		secondaryDirector=new SecondaryDirectorPage();
		secondaryDirector.waitForPageToLoad();
		secondaryDirector.clickTopMenuItem("Services");
		secondaryDirector.waitForPageToLoad();
		secondaryDirector.clickSideMenuTitle("Services");
		secondaryDirector.waitForPageToLoad();
		secondaryDirector.verifyLinkIsEnabled("Service Types");
		secondaryDirector.verifyLinkIsEnabled("Service Conditions");
		secondaryDirector.verifyLinkIsEnabled("Spanned Services Admin");
		secondaryDirector.verifyLinkIsEnabled("Cache Schemas");
		secondaryDirector.verifyLinkIsDisabled("Service Group Admin");
		secondaryDirector.verifyLinkIsDisabled("Service Session Admin");
		secondaryDirector.verifyLinkIsDisabled("Cache Regions");
		secondaryDirector.verifyLinkIsDisabled("Service Test");
		secondaryDirector.verifyLinkIsDisabled("Grid Libraries");
	}
	
	
	@Test(description="Verify enabled and disabled pages on Services --> Batch")
	public void Grid_4756()
	{
		secondaryDirector=new SecondaryDirectorPage();
		secondaryDirector.waitForPageToLoad();
		secondaryDirector.clickTopMenuItem("Services");
		secondaryDirector.waitForPageToLoad();
		secondaryDirector.clickSideMenuTitle("Batch");
		secondaryDirector.waitForPageToLoad();
		secondaryDirector.verifyLinkIsEnabled("Batch Schedule");
		secondaryDirector.verifyLinkIsEnabled("Batch Admin");	
		secondaryDirector.verifyLinkIsDisabled("Batch Definitions");
		secondaryDirector.verifyLinkIsDisabled("Service Runners");
	}
	
	
	@Test(description="Verify enabled and disabled pages on Admin --> System Admin")
	public void Grid_4757()
	{
		secondaryDirector=new SecondaryDirectorPage();
		secondaryDirector.waitForPageToLoad();
		secondaryDirector.clickTopMenuItem("Admin");
		secondaryDirector.waitForPageToLoad();
		secondaryDirector.clickSideMenuTitle("System Admin");
		secondaryDirector.waitForPageToLoad();
		secondaryDirector.verifyLinkIsEnabled("Manager Configuration");
		secondaryDirector.verifyLinkIsEnabled("Manager Import/Export");	
		secondaryDirector.verifyLinkIsEnabled("Manager Hooks");
		secondaryDirector.verifyLinkIsEnabled("Email Notifications");	
		secondaryDirector.verifyLinkIsEnabled("SNMP Event Traps");
		secondaryDirector.verifyLinkIsEnabled("License Information");	
		secondaryDirector.verifyLinkIsEnabled("Manager Reinstall");
	}
	
	
	@Test(description="Verify enabled and disabled pages on Admin --> User Admin")
	public void Grid_4758()
	{
		secondaryDirector=new SecondaryDirectorPage();
		secondaryDirector.waitForPageToLoad();
		secondaryDirector.clickTopMenuItem("Admin");
		secondaryDirector.waitForPageToLoad();
		secondaryDirector.clickSideMenuTitle("User Admin");
		secondaryDirector.waitForPageToLoad();
		secondaryDirector.verifyLinkIsEnabled("User Admin");
		secondaryDirector.verifyLinkIsEnabled("Role Admin");	
		secondaryDirector.verifyLinkIsEnabled("Authentication");
		secondaryDirector.verifyLinkIsDisabled("Run-As Credentials");	
	}
	
	
	@Test(description="Verify enabled and disabled pages on diagnostics page")
	public void Grid_4759()
	{
		secondaryDirector=new SecondaryDirectorPage();
		secondaryDirector.waitForPageToLoad();
		secondaryDirector.clickTopMenuItem("Diagnostics");
		secondaryDirector.waitForPageToLoad();
		secondaryDirector.verifyLinkIsEnabled("Manager Diagnostics");
		secondaryDirector.verifyLinkIsEnabled("Real Time Log");
		secondaryDirector.verifyLinkIsDisabled("Service Diagnostics");
		secondaryDirector.verifyLinkIsDisabled("Scheduler Instrumentation");
	}
}

