package com.tibco.automation.test.gsui.gridcomponents.brokers;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import com.tibco.automation.page.common.CommonFunctions;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.gridcomponents.brokers.BrokerAdminPage;

public class BrokerAdmin extends WebDriverTestCase{

	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public TemplatePage templatepage;
	public BrokerAdminPage brokerAdmin;
	public CommonFunctions commonFunctions;
	
	@BeforeMethod
	public void beforeMethod()
	{
		brokerAdmin=new BrokerAdminPage();
		commonFunctions=new CommonFunctions();
		brokerAdmin.launchPage();
		brokerAdmin.waitForPageToLoad();
	}
	
	@Test(description="Verify refresh button is present and it shows last refresh on tooltip.")
	public void Grid_3917()
	{
		commonFunctions.verifyLastRefresh();
	}
	
	@Test(description="Verify clicking on refresh button disables it.")
	public void Grid_3918()
	{
		commonFunctions.verifyLastRefresh();
		commonFunctions.clickRefreshButton();
		commonFunctions.verifyRefreshDisabled();
		commonFunctions.clickRefreshButton();
		commonFunctions.verifyLastRefresh();
	}
	
	@Test(description="Verify add columns option is present on page.")
	public void Grid_3919()
	{
		brokerAdmin.verifyAddColumnIsPresent();
	}
	
	@Test(description="Verify user is able to add columns after clicking on save button.")
	public void Grid_3920()
	{
		
		brokerAdmin.verifyAddColumnIsPresent();
		brokerAdmin.clickAddColumn();
		brokerAdmin.waitForPageToLoad();
		brokerAdmin.addNewColumn("Max Engines");
		brokerAdmin.clickSaveOnAddColumn();
		brokerAdmin.waitForPageToLoad();
		brokerAdmin.verifyColumnPresent("Max Engines");
		brokerAdmin.clickAddColumn();
		brokerAdmin.removeColumn("Max Engines");
		brokerAdmin.clickSaveOnAddColumn();
		brokerAdmin.waitForPageToLoad();
		brokerAdmin.verifyColumnNotPresent("Max Engines");
		
	}
	
	@Test(description="Verify the functionality of revert button add columns popup.")
	public void Grid_3921()
	{
		
		brokerAdmin.verifyAddColumnIsPresent();
		brokerAdmin.clickAddColumn();
		brokerAdmin.addNewColumn("Max Engines");
		brokerAdmin.clickSaveOnAddColumn();
		brokerAdmin.waitForPageToLoad();
		brokerAdmin.verifyColumnPresent("Max Engines");
		brokerAdmin.clickAddColumn();
		brokerAdmin.clickRevertOnAddColumn();
		brokerAdmin.clickSaveOnAddColumn();
		brokerAdmin.waitForPageToLoad();
		brokerAdmin.verifyColumnNotPresent("Max Engines");
		
	}
	
	
	@Test(description="Verify simple search using status column.")
	public void Grid_3922()
	{
		commonFunctions.performSimpleSearch("Status", "invalidStatus");
		brokerAdmin.waitForPageToLoad();
		brokerAdmin.verifySearchResult("0");
		commonFunctions.clearSearchResults();
	}
	
	@Test(description="Verify query search using broker ID column.")
	public void Grid_3923()
	{
		commonFunctions.performQuerySearch("\"Broker ID\" matches \"invalidID\"");
		brokerAdmin.waitForPageToLoad();
		brokerAdmin.verifySearchResult("0");
		commonFunctions.clearSearchResults();
	}
	
	
	@Test(description="Verify query builder search using url column.")
	public void Grid_3924()
	{
		commonFunctions.performQueryBuilderSearch("URL", "matches", "invalidURL");
		commonFunctions.clickSearchOnQueryBuilder();
		brokerAdmin.waitForPageToLoad();
		brokerAdmin.verifySearchResult("0");
		commonFunctions.clearSearchResults();
	}
	
	@Test(description="verify change in results per page value changes the number of rows in table.")
	public void Grid_3925()
	{
		commonFunctions.updateAndVerifyResultsPerPage(1);
		brokerAdmin.waitForPageToLoad();
	}
	
	@Test(description="Verify functionality of next page button in pagination.")
	public void Grid_3926()
	{
		commonFunctions.updateAndVerifyResultsPerPage(1);
		brokerAdmin.waitForPageToLoad();
		commonFunctions.goToNextPage();
		brokerAdmin.waitForPageToLoad();
		
	}
	
	@Test(description="Verify functionality of previous page button in pagination")
	public void Grid_3927()
	{
		commonFunctions.updateAndVerifyResultsPerPage(1);
		brokerAdmin.waitForPageToLoad();
		commonFunctions.goToNextPage();
		brokerAdmin.waitForPageToLoad();
		commonFunctions.goToPreviousPage();
		brokerAdmin.waitForPageToLoad();
	}
	
	
	@Test(description="Verify functionality of move to first page button.")
	public void Grid_3928()
	{
		commonFunctions.updateAndVerifyResultsPerPage(1);
		brokerAdmin.waitForPageToLoad();
		commonFunctions.goToNextPage();
		brokerAdmin.waitForPageToLoad();
		commonFunctions.goToNextPage();
		brokerAdmin.waitForPageToLoad();
		commonFunctions.goToFirstPage();
		brokerAdmin.waitForPageToLoad();
	}
	
	
	@Test(description="Verify functionality of move to last page button.")
	public void Grid_3929()
	{
		commonFunctions.updateAndVerifyResultsPerPage(1);
		brokerAdmin.waitForPageToLoad();
		commonFunctions.goToNextPage();
		brokerAdmin.waitForPageToLoad();
		commonFunctions.goToPreviousPage();
		brokerAdmin.waitForPageToLoad();
		commonFunctions.goToLastPage();
		brokerAdmin.waitForPageToLoad();
	}
	
	
	@Test(description="Verify selecting a broker enables local action.")
	public void Grid_3930()
	{
		commonFunctions.updateResultsPerPage(20);
		brokerAdmin.waitForPageToLoad();
		brokerAdmin.selectFirstBroker();
		brokerAdmin.selectFirstBroker();
		brokerAdmin.selectFirstBroker();
		brokerAdmin.waitForPageToLoad();
		commonFunctions.verifyLocalActionLinkIsPresent();
	}
	
	
	@Test(description="Verify deselecting a broker disables local action.")
	public void Grid_3931()
	{
		commonFunctions.updateResultsPerPage(20);
		brokerAdmin.waitForPageToLoad();
		brokerAdmin.selectFirstBroker();
		brokerAdmin.selectFirstBroker();
		brokerAdmin.waitForPageToLoad();
		commonFunctions.verifyGlobalActionLinkIsPresent();
	}
	
	
	@Test(description="Verify functionality of login to admin local action.")
	public void Grid_3932()
	{
		commonFunctions.updateResultsPerPage(20);
		brokerAdmin.waitForPageToLoad();
		brokerAdmin.selectFirstBroker();
		brokerAdmin.selectFirstBroker();
		brokerAdmin.selectFirstBroker();
		brokerAdmin.waitForPageToLoad();
		commonFunctions.selectLocalAction("Login to Admin");
		brokerAdmin.waitForPageToLoad();
		brokerAdmin.verifyPageIsLaunched("Engine Admin");
	}
	
	
	@Test(description="Verify functionality of launch monitor local action")
	public void Grid_3933()
	{
		commonFunctions.updateResultsPerPage(20);
		brokerAdmin.waitForPageToLoad();
		brokerAdmin.selectFirstBroker();
		brokerAdmin.selectFirstBroker();
		brokerAdmin.selectFirstBroker();
		brokerAdmin.waitForPageToLoad();
		commonFunctions.selectLocalAction("Launch Monitor");
		brokerAdmin.waitForPageToLoad();
		brokerAdmin.verifyBrokerMonitorPageIsLaunched();
	}
	
	@Test(description="Verify functionality of broker routing local action.")
	public void Grid_3934()
	{
		commonFunctions.updateResultsPerPage(20);
		brokerAdmin.waitForPageToLoad();
		brokerAdmin.selectFirstBroker();
		brokerAdmin.selectFirstBroker();
		brokerAdmin.selectFirstBroker();
		brokerAdmin.waitForPageToLoad();
		commonFunctions.selectLocalAction("Broker Routing");
		brokerAdmin.waitForPageToLoad();
		brokerAdmin.verifyPageTitle("Broker Routing");
	}
	
	@Test(description="Verify purge broker functionality for an offline broker.")
	public void Grid_3953()
	{
		commonFunctions.updateResultsPerPage(20);
		brokerAdmin.waitForPageToLoad();
		brokerAdmin.selectFirstOfflineBroker();
		brokerAdmin.selectFirstOfflineBroker();
		brokerAdmin.selectFirstOfflineBroker();
		brokerAdmin.waitForPageToLoad();
		commonFunctions.selectLocalAction("Purge Broker");
		brokerAdmin.waitForPageToLoad();
	}
}
