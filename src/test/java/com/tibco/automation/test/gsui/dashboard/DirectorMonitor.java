package com.tibco.automation.test.gsui.dashboard;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import com.tibco.automation.page.common.CommonFunctions;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.dashboard.DirectorMonitorPage;

public class DirectorMonitor extends WebDriverTestCase{
	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public TemplatePage templatepage;
	public DirectorMonitorPage directorMonitor;
	public CommonFunctions commonFunctions;
	
	@BeforeMethod
	public void beforeMethod()
	{
		directorMonitor=new DirectorMonitorPage();
		commonFunctions=new CommonFunctions();
		directorMonitor.clickTopMenuItem("Dashboard");
		directorMonitor.waitForPageToLoad();
		directorMonitor.clickDirectorMonitorLink();
		directorMonitor.waitForPageToLoad();
	}
	
	
	@Test(description="Verify the functionality of Director Monitor page.")
	public void Grid_4657()
	{
		directorMonitor.verifyAllCheckboxesAreChecked();
		directorMonitor.verifyAllGraphsArePresent();
	}
	
	
	@Test(description="Verify the functionality of Engines checkbox")
	public void Grid_4658()
	{
		directorMonitor.clickEngineCheckBox();
		directorMonitor.waitForPageToLoad();
		directorMonitor.verifyEngineGraphIsNotPresent();
		directorMonitor.clickEngineCheckBox();
		directorMonitor.waitForPageToLoad();
		directorMonitor.verifyEngineGraphIsPresent();
	}
	
	
	@Test(description="Check the functionality of Tasks checkbox.")
	public void Grid_4659()
	{
		directorMonitor.clickTaskCheckBox();
		directorMonitor.waitForPageToLoad();
		directorMonitor.verifyTaskGraphIsNotPresent();
		directorMonitor.clickTaskCheckBox();
		directorMonitor.waitForPageToLoad();
		directorMonitor.verifyTaskGraphIsPresent();
	}
	
	
	@Test(description="Verify the functionality of Services checkbox")
	public void Grid_4660()
	{
		directorMonitor.clickServicesCheckBox();
		directorMonitor.waitForPageToLoad();
		directorMonitor.verifyServicesGraphIsNotPresent();
		directorMonitor.clickServicesCheckBox();
		directorMonitor.waitForPageToLoad();
		directorMonitor.verifyServicesGraphIsPresent();
	}
	
	
	@Test(description="Verify the functionality of System checkbox")
	public void Grid_4662()
	{
		directorMonitor.clickSystemCheckBox();
		directorMonitor.waitForPageToLoad();
		directorMonitor.verifySystemGraphIsNotPresent();
		directorMonitor.clickSystemCheckBox();
		directorMonitor.waitForPageToLoad();
		directorMonitor.verifySystemGraphIsPresent();
	}
}
