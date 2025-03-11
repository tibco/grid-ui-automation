package com.tibco.automation.test.gsui.dashboard;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import com.tibco.automation.page.common.CommonFunctions;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.dashboard.BrokerMonitorPage;

public class BrokerMonitor extends WebDriverTestCase{
	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public TemplatePage templatepage;
	public BrokerMonitorPage brokerMonitor;
	public CommonFunctions commonFunctions;
	
	@BeforeMethod
	public void beforeMethod()
	{
		brokerMonitor=new BrokerMonitorPage();
		commonFunctions=new CommonFunctions();
		brokerMonitor.clickTopMenuItem("Dashboard");
		brokerMonitor.waitForPageToLoad();
		brokerMonitor.clickBrokerMonitorLink();
		brokerMonitor.waitForPageToLoad();
	}
	
	@Test(description="Verify the functionality of Broker Monitor page")
	public void Grid_4663()
	{
		brokerMonitor.verifyAllCheckboxesAreChecked();
		brokerMonitor.verifyAllGraphsArePresent();
	}
	
	@Test(description="Verify the functionality of Engines checkbox")
	public void Grid_4664()
	{
		brokerMonitor.clickEngineCheckBox();
		brokerMonitor.waitForPageToLoad();
		brokerMonitor.verifyEngineGraphIsNotPresent();
		brokerMonitor.clickEngineCheckBox();
		brokerMonitor.waitForPageToLoad();
		brokerMonitor.verifyEngineGraphIsPresent();
	}
	
	@Test(description="Verify the functionality of Service View checkbox")
	public void Grid_4665()
	{
		brokerMonitor.clickServiceViewCheckBox();
		brokerMonitor.waitForPageToLoad();
		brokerMonitor.verifyServiceViewGraphIsNotPresent();
		brokerMonitor.clickServiceViewCheckBox();
		brokerMonitor.waitForPageToLoad();
		brokerMonitor.verifyServiceViewGraphIsPresent();
	}
	
	
	@Test(description="Verify the functionality of Tasks checkbox")
	public void Grid_4666()
	{
		brokerMonitor.clickTaskCheckBox();
		brokerMonitor.waitForPageToLoad();
		brokerMonitor.verifyTaskGraphIsNotPresent();
		brokerMonitor.clickTaskCheckBox();
		brokerMonitor.waitForPageToLoad();
		brokerMonitor.verifyTaskGraphIsPresent();
	}
	
	
	@Test(description="Verify the functionality of Services checkbox")
	public void Grid_4667()
	{
		brokerMonitor.clickServicesCheckBox();
		brokerMonitor.waitForPageToLoad();
		brokerMonitor.verifyServiceGraphIsPresent();
		brokerMonitor.clickServicesCheckBox();
		brokerMonitor.waitForPageToLoad();
		brokerMonitor.verifyServiceGraphIsNotPresent();
	}
	
	
	@Test(description="Verify the functionality of System checkbox")
	public void Grid_4668()
	{
		brokerMonitor.clickSystemCheckBox();
		brokerMonitor.waitForPageToLoad();
		brokerMonitor.verifySystemGraphIsNotPresent();
		brokerMonitor.clickSystemCheckBox();
		brokerMonitor.waitForPageToLoad();
		brokerMonitor.verifySystemGraphIsPresent();
	}
}
