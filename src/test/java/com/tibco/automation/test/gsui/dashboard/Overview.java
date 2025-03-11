package com.tibco.automation.test.gsui.dashboard;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import com.tibco.automation.page.common.CommonFunctions;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.dashboard.OverviewPage;

public class Overview extends WebDriverTestCase{

	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public TemplatePage templatepage;
	public OverviewPage overview;
	public CommonFunctions commonFunctions;
	
	@BeforeMethod
	public void beforeMethod()
	{
		overview=new OverviewPage();
		commonFunctions=new CommonFunctions();
		overview.clickTopMenuItem("Dashboard");
		overview.waitForPageToLoad();
		overview.clickOverviewLink();
		overview.waitForPageToLoad();
	}
	//
	@Test(description="Verify the functionality of the Overview page")
	public void Grid_4651()
	{
		overview.verifyPageTitleIsPresent("Overview");
	}
	
	@Test(description="Verify the functionality of Service link")
	public void Grid_4652()
	{
		overview.clickLink("Services");
		overview.waitForPageToLoad();
		overview.verifyPageTitleIsPresent("Service Session Admin");
	}
	
	@Test(description="Verify the functionality of Brokers link")
	public void Grid_4653()
	{
		overview.clickLink("Brokers");
		overview.waitForPageToLoad();
		overview.verifyPageTitleIsPresent("Broker Admin");
	}
	
	@Test(description="Verify the functionality of Drivers link")
	public void Grid_4654()
	{
		overview.clickLink("Drivers");
		overview.waitForPageToLoad();
		overview.verifyPageTitleIsPresent("Driver Admin");
	}
	
	@Test(description="Verify the functionality of Engines link")
	public void Grid_4655()
	{
		overview.clickLink("Engines");
		overview.waitForPageToLoad();
		overview.verifyPageTitleIsPresent("Engine Admin");
	}
	
	@Test(description="Verify the functionality of Daemons link")
	public void Grid_4656()
	{
		overview.clickLink("Daemons");
		overview.waitForPageToLoad();
		overview.verifyPageTitleIsPresent("Daemon Admin");
	}
	
	@Test(description="Verify the service graph")
	public void Grid_4677()
	{
		overview.clickServiceGraph();
		overview.clickServiceSessionAdminButton();
		overview.verifyPageTitleIsPresent("Service Session Admin");
	}
	
	@Test(description="Verify the brokers graph")
	public void Grid_4678()
	{
		overview.clickBrokerGraph();
		overview.clickBrokerAdminButton();
		overview.verifyPageTitleIsPresent("Broker Admin");
	}
	
	@Test(description="Verify the Drivers graph.")
	public void Grid_4679()
	{
		overview.clickDriverGraph();
		overview.clickDriverAdminButton();
		overview.verifyPageTitleIsPresent("Driver Admin");
	}
	
	@Test(description="Verify the Engines graph")
	public void Grid_4680()
	{
		overview.clickEnginesGraph();
		overview.clickEngineAdminButton();
		overview.verifyPageTitleIsPresent("Engine Admin");
	}
	
	@Test(description="Verify the Daemon graph")
	public void Grid_4681()
	{
		overview.clickDaemonGraph();
		overview.clickDaemonAdminButton();
		overview.verifyPageTitleIsPresent("Daemon Admin");
	}
	
	@Test(description="Verify the help page for Overview page")
	public void Grid_4710()
	{
		overview.clickHelpButton();
		overview.verifyOverviewHelpIsPresent();
		overview.clickHelpButton();
		overview.verifyOverviewHelpIsNotPresent();
	}
	
	@Test(description="Verify downloads option on page")
	public void Grid_4762()
	{
		overview.clickDownloadButton();
		overview.verifyDownloadTextIsPresent();
		overview.clickDownloadButton();
		overview.verifyDownloadTextIsNotPresent();
	}
}
