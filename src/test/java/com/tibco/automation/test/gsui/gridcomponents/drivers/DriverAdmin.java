package com.tibco.automation.test.gsui.gridcomponents.drivers;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import com.tibco.automation.page.common.CommonFunctions;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.gridcomponents.drivers.DriverAdminPage;

public class DriverAdmin extends WebDriverTestCase{

	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public TemplatePage templatepage;
	public DriverAdminPage driverAdmin;
	public CommonFunctions commonFunctions;
	
	@BeforeMethod
	public void beforeMethod()
	{
		driverAdmin=new DriverAdminPage();
		commonFunctions=new CommonFunctions();
		driverAdmin.launchPage();
		driverAdmin.waitForPageToLoad();
	}
	
	@Test(description="Verify refresh button is present and it shows last refresh on tooltip.")
	public void Grid_3894()
	{
		 commonFunctions.verifyLastRefresh();
	}
	
	
	@Test(description="Verify clicking on refresh button disables it.")
	public void Grid_3895()
	{
		commonFunctions.verifyLastRefresh();
		commonFunctions.clickRefreshButton();
		commonFunctions.verifyRefreshDisabled();
		commonFunctions.clickRefreshButton();
		commonFunctions.verifyLastRefresh();
	}
	
	
	@Test(description="Verify add columns option is present on page.")
	public void Grid_3896()
	{
		driverAdmin.verifyAddColumnIsPresent();
	}
	
	@Test(description="Verify user is able to add columns after clicking on save button.")
	public void Grid_3897()
	{
		driverAdmin.verifyAddColumnIsPresent();
		driverAdmin.clickAddColumn();
		driverAdmin.addNewColumn("Max Priority");
		driverAdmin.addNewColumn("Roles");
		driverAdmin.clickSaveOnAddColumn();
		driverAdmin.waitForPageToLoad();
		driverAdmin.verifyColumnPresent("Max Priority");
		driverAdmin.verifyColumnPresent("Roles");
		driverAdmin.clickAddColumn();
		driverAdmin.removeColumn("Max Priority");
		driverAdmin.removeColumn("Roles");
		driverAdmin.clickSaveOnAddColumn();
		driverAdmin.verifyColumnNotPresent("Max Priority");
		driverAdmin.verifyColumnNotPresent("Roles");
	}
	
	
	@Test(description="Verify the functionality of revert button add columns popup.")
	public void Grid_3898()
	{
		driverAdmin.verifyAddColumnIsPresent();
		driverAdmin.clickAddColumn();
		driverAdmin.addNewColumn("Max Priority");
		driverAdmin.addNewColumn("Roles");
		driverAdmin.clickSaveOnAddColumn();
		driverAdmin.waitForPageToLoad();
		driverAdmin.verifyColumnPresent("Max Priority");
		driverAdmin.verifyColumnPresent("Roles");
		driverAdmin.clickAddColumn();
		driverAdmin.clickRevertOnAddColumn();
		driverAdmin.clickSaveOnAddColumn();
		driverAdmin.verifyColumnNotPresent("Max Priority");
		driverAdmin.verifyColumnNotPresent("Roles");
	}
	
	@Test(description="verify simple search by using hostname.")
	public void Grid_3899()
	{
		commonFunctions.performSimpleSearch("Hostname", "invalidhostname");
		driverAdmin.waitForPageToLoad();
		driverAdmin.verifySearchResult("0");
		commonFunctions.clearSearchResults();
	}
	
	
	@Test(description="Verify query search using username")
	public void Grid_3900()
	{
		commonFunctions.performQuerySearch("Username=invalidusername");
		driverAdmin.waitForPageToLoad();
		driverAdmin.verifySearchResult("0");
		commonFunctions.clearSearchResults();
	}
	
	@Test(description="Verify query builder search using type.")
	public void Grid_3901()
	{
		commonFunctions.performQueryBuilderSearch("Type", "matches", "invalidtype");
		commonFunctions.clickSearchOnQueryBuilder();
		driverAdmin.waitForPageToLoad();
		driverAdmin.verifySearchResult("0");
		commonFunctions.clearSearchResults();
	}
	
	
	@Test(description="verify change in results per page value changes the number of rows in table.")
	public void Grid_3902()
	{
		commonFunctions.updateAndVerifyResultsPerPage(1);
	}
	
	
	@Test(description="Verify functionality of next page button in pagination.")
	public void Grid_3903()
	{
		commonFunctions.updateAndVerifyResultsPerPage(1);
		driverAdmin.waitForPageToLoad();
		commonFunctions.goToNextPage();
	}
	
	@Test(description="Verify functionality of previous page button in pagination")
	public void Grid_3904()
	{
		commonFunctions.updateAndVerifyResultsPerPage(1);
		driverAdmin.waitForPageToLoad();
		commonFunctions.goToNextPage();
		driverAdmin.waitForPageToLoad();
		commonFunctions.goToPreviousPage();
	}
	
	@Test(description="Verify functionality of move to first page button")
	public void Grid_3905()
	{
		commonFunctions.updateAndVerifyResultsPerPage(1);
		driverAdmin.waitForPageToLoad();
		commonFunctions.goToNextPage();
		driverAdmin.waitForPageToLoad();
		commonFunctions.goToNextPage();
		driverAdmin.waitForPageToLoad();
		commonFunctions.goToFirstPage();
	}
	
	@Test(description="Verify functionality of move to last page button.")
	public void Grid_3906()
	{
		commonFunctions.updateAndVerifyResultsPerPage(1);
		driverAdmin.waitForPageToLoad();
		commonFunctions.goToPreviousPage();
		driverAdmin.waitForPageToLoad();
		commonFunctions.goToLastPage();
	}
	
	@Test(description="Verify functionality of expand view global action")
	public void Grid_3907()
	{
		commonFunctions.selectGlobalAction("Expand View of All");
		driverAdmin.waitForPageToLoad();
		driverAdmin.verifyDataExpanded();
		commonFunctions.selectGlobalAction("Collapse View of All");
		driverAdmin.waitForPageToLoad();
		driverAdmin.verifyDataCollapsed();
	}
	
	
	
	@Test(description="verify selecting a driver enables the local action")
	public void Grid_3909()
	{
		driverAdmin.selectInternalDriver();
		driverAdmin.selectInternalDriver();
		driverAdmin.selectInternalDriver();
		commonFunctions.verifyLocalActionLinkIsPresent();
	}
	
	@Test(description="Verify functionality of collapse view global action")
	public void Grid_3908()
	{
		commonFunctions.selectGlobalAction("Expand View of All");
		driverAdmin.waitForPageToLoad();
		driverAdmin.verifyDataExpanded();
		commonFunctions.selectGlobalAction("Collapse View of All");
		driverAdmin.waitForPageToLoad();
		driverAdmin.verifyDataCollapsed();
	}
	
	@Test(description="verify deselecting a selected driver disables local action and enables global action.")
	public void Grid_3910()
	{
		driverAdmin.selectInternalDriver();
		driverAdmin.selectInternalDriver();
		commonFunctions.verifyGlobalActionLinkIsPresent();
	}
	
	@Test(description="Verify local action driver properties")
	public void Grid_3911()
	{
		driverAdmin.selectInternalDriver();
		driverAdmin.selectInternalDriver();
		driverAdmin.selectInternalDriver();
		commonFunctions.verifyLocalActionLinkIsPresent();
		commonFunctions.selectLocalAction("Driver Properties");
		driverAdmin.waitForPageToLoad();
		driverAdmin.verifyDataExpanded();
	}
	
	@Test(description="Verify local action disconnect driver.")
	public void Grid_3912()
	{
		driverAdmin.selectInternalDriver();
		driverAdmin.selectInternalDriver();
		driverAdmin.selectInternalDriver();
		commonFunctions.verifyLocalActionLinkIsPresent();
		commonFunctions.selectLocalAction("Disconnect Driver");
		driverAdmin.waitForPageToLoad();
		commonFunctions.acceptAlert();
	}
}
