package com.tibco.automation.test.gsui.services.services;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import com.tibco.automation.page.admin.useradmin.RolePage;
import com.tibco.automation.page.common.CommonFunctions;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.gridcomponents.engines.EngineAdminPage;
import com.tibco.automation.page.services.services.CacheRegionPage;

public class CacheRegion extends WebDriverTestCase {
	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public TemplatePage templatepage;
	public CacheRegionPage cacheregion;
	public CommonFunctions commonFunctions;
	public EngineAdminPage engineadminpage;
	public RolePage rolepage;
	
	
	
	@BeforeMethod
	public void beforeTest()
	{	
		cacheregion=new CacheRegionPage();
		cacheregion.launchPage();
		cacheregion.waitForPageToLoad();
		commonFunctions=new CommonFunctions();
		engineadminpage=new EngineAdminPage();
		rolepage=new RolePage();
	}	
	@Test(priority=1,description="Verify refresh button is present and it shows last refresh on tooltip")
	public void Grid_4088()
	{
		cacheregion.refreshButton();
		commonFunctions.verifyLastRefresh();
	}
	@Test(priority=2,description="Verify clicking on refresh button disables it.")
	public void Grid_4089()
	{
		commonFunctions.clickRefreshButton();
		commonFunctions.verifyRefreshDisabled();
	}
	
	@Test(priority=3,description="Verify the functionality of add columns option")
	public void Grid_4090()
	{
		cacheregion.removeColumn();
		cacheregion.verifyColumnRemove();
		cacheregion.addColumn();
		cacheregion.verifyColumnAdded();
	}	
	@Test(priority=4,description="Verify the functionality of revert button of add column option")
	public void Grid_4092()
	{
		cacheregion.revertColumn();
		cacheregion.verifyRevert();
		
	}
	
	@Test(priority=5,description="Verify simple search by using Name")
	public void Grid_4094()
	{
		commonFunctions.performSimpleSearch("Entries","INVALID");
		engineadminpage.verifySimpleSearch();
		rolepage.clearSearch();
	}
	@Test(priority=6,description="Verify query search ")
	public void Grid_4095()
	{
		
		commonFunctions.performQuerySearch("\"Name\" == \"INVALID\"");
		engineadminpage.verifyPerformQuerySearch();
		rolepage.clearSearch();
		
	}
	@Test(priority=7,description="Verify query builder search ")
	public void Grid_4096()
	{
		
		commonFunctions.performQueryBuilderSearch("Type", "==", "INVALID");
		commonFunctions.clickSearchOnQueryBuilder();
		engineadminpage.verifySimpleSearch();
		rolepage.clearSearch();
	}
	@Test(priority=8,description="Verify the functionality Close button of Query Builder popup ")
	public void Grid_4097()
	{
		//commonFunctions.performQueryBuilderSearch("Type", "==", "INVALID");
		cacheregion.selectQueryBuilder();
		commonFunctions.clickCloseOnQueryBuilder();
		engineadminpage.VerifyQueryBuilderClose();
		
	}
	@Test(priority=9,description="Verify change in results per page value changes the number of rows in table")
	public void Grid_4101()
	{
		
		commonFunctions.updateResultsPerPage(1);
	}
	@Test(priority=10,description="Verify functionality of move to last page button")
	public void Grid_4102()
	{
		
		rolepage.waitt();
		commonFunctions.goToLastPage();
	}
	@Test(priority=11,description="Verify functionality of move to first page button")
	public void Grid_4103()
	{
		
		rolepage.waitt();
		commonFunctions.goToFirstPage();
	}
	@Test(priority=12,description="Verify functionality of next page button in pagination")
	 public void Grid_4104()
	{
		
		rolepage.waitt();
		commonFunctions.goToNextPage();
	}
	@Test(priority=13,description="Verify functionality of previous  page button in pagination")
	 public void Grid_4105()
	{
		
		rolepage.waitt();
		commonFunctions.goToPreviousPage();
		rolepage.waitt();
		commonFunctions.updateResultsPerPage(20);
		
	}

	
	
}
