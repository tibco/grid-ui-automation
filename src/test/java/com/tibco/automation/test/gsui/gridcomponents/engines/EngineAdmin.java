package com.tibco.automation.test.gsui.gridcomponents.engines;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import com.tibco.automation.page.admin.useradmin.RolePage;
import com.tibco.automation.page.common.CommonFunctions;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.gridcomponents.engines.EngineAdminPage;
import com.tibco.automation.page.gridcomponents.engines.EngineConfigurationPage;

public class EngineAdmin extends WebDriverTestCase {
	public ExtendedWebDriver driver;
	public TemplatePage templatepage;
	public EngineConfigurationPage enginepage;
	public CommonFunctions commonFunctions;
	public EngineAdminPage engineadminpage;
	public RolePage rolepage;
	public String configValue=null;
	
	@BeforeMethod
	public void beforeMethod()
	{
		engineadminpage=new EngineAdminPage();
		engineadminpage.launchPage();
		engineadminpage.waitForPageToLoad();
		commonFunctions=new CommonFunctions();
		rolepage=new RolePage();
	}
	
	@Test(priority=1,description="Verify refresh button is present and it shows last refresh on tooltip")
	public void Grid_4026()
	{
		engineadminpage.refreshButton();
		commonFunctions.verifyLastRefresh();
		
	}
	@Test(priority=2,description="Verify clicking on refresh button disables it.")
	public void Grid_4027()
	{
		commonFunctions.clickRefreshButton();
		commonFunctions.verifyRefreshDisabled();
	}
	
	@Test(priority=3,description="Verify add columns option is present on page.")
	public void Grid_4028()
	{
		engineadminpage.addColumnOption();
	}
	@Test(priority=4,description="Verify user is able to add columns after clicking on save button")
	public void Grid_4029()
	{
		engineadminpage.addEngineColumn();
		engineadminpage.waitForPageToLoad();
		engineadminpage.verifyColumnAdded();
		
	}

	@Test(priority=5,description="Verify the functionality of revert button add columns popup")
	public void Grid_4030()
	{
		engineadminpage.revert();
		engineadminpage.waitForPageToLoad();
		engineadminpage.verifyColumnRevert();
	}
	@Test(priority=6,description="Verify simple search using user name.")
		public void Grid_4031()
		{
			commonFunctions.performSimpleSearch("OS","INVALID");
			engineadminpage.verifySimpleSearch();
			rolepage.clearSearch();
		}
	@Test(priority=7,description="Verify query search ")
	public void Grid_4032()
	{
		
		commonFunctions.performQuerySearch("\"OS Name\" == \"INVALID\"");
		engineadminpage.verifyPerformQuerySearch();
		rolepage.clearSearch();
		
	}
	@Test(priority=8,description="Verify query builder search ")
	public void Grid_4033()
	{
		
		commonFunctions.performQueryBuilderSearch("OS", "==", "INVALID");
		commonFunctions.clickSearchOnQueryBuilder();
		engineadminpage.verifySimpleSearch();
		rolepage.clearSearch();
	}
	
	@Test(priority=9,description="Verify change in results per page value changes the number of rows in table")
	public void Grid_4034()
	{
		
		commonFunctions.updateAndVerifyResultsPerPage(2);
	}
	@Test(priority=10,description="Verify functionality of move to last page button")
	public void Grid_4035()
	{
		
		rolepage.waitt();
		commonFunctions.goToLastPage();
	}
	@Test(priority=11,description="Verify functionality of move to first page button")
	public void Grid_4036()
	{
		
		rolepage.waitt();
		commonFunctions.goToFirstPage();
	}
	
	@Test(priority=12,description="Verify functionality of next page button in pagination")
	 public void Grid_4037()
	{
		
		rolepage.waitt();
		commonFunctions.goToNextPage();
	}
	
	@Test(priority=13,description="Verify functionality of previous  page button in pagination")
	 public void Grid_4038()
	{
		
		rolepage.waitt();
		commonFunctions.goToPreviousPage();
		rolepage.waitt();
		commonFunctions.updateResultsPerPage(20);
		
	}
	 @Test(priority=14,description="Verify global action- expand view of all")
	 public void Grid_4039()
	{
		engineadminpage.clickGlobalAction();
		commonFunctions.selectGlobalAction("Expand View of All");
		engineadminpage.verifyExpandViewOfAll();
	}
	@Test(priority=15,description="Verify global action- collapse view of all")
	 public void Grid_4040()
	{
		engineadminpage.clickGlobalAction();
		commonFunctions.selectGlobalAction("Collapse View of All");
		engineadminpage.verifyCollapseViewOfAll();
	}
	
	@Test(priority=16,description="Verify selecting an engine enables local action.")
	public void Grid_4043()
	{
		engineadminpage.selectCheckbox();
		commonFunctions.verifyLocalActionLinkIsPresent();
	}
	@Test(priority=17,description="Verify deselcting an engine disables local action and enables global action.")
	public void Grid_4044()
	{
		engineadminpage.selectCheckbox();
		commonFunctions.verifyGlobalActionLinkIsPresent();
	}
	@Test(priority=18,description="Verify local action- engine details.")
	public void Grid_4045()
	{
		engineadminpage.selectCheckbox();
		commonFunctions.selectLocalAction("Engine Details");
		engineadminpage.verifyEngineDetails();
		
	}
	@Test(priority=19,description="Verify local action- Search logs")
	public void Grid_4046()
	{
		engineadminpage.selectCheckbox();
		commonFunctions.selectLocalAction("Search Logs");
		rolepage.maximizeCurrentWindow();
		engineadminpage.verifySearchLogs();
		rolepage.quit();
		rolepage.switchToParentWindow();	
	}
	@Test(priority=20,description="Verify back button on search logs page")
	public void Grid_4047()
	{
		engineadminpage.selectCheckbox();
		commonFunctions.selectLocalAction("Search Logs");
		rolepage.maximizeCurrentWindow();
		engineadminpage.selectYear();
		engineadminpage.clickBack();
		engineadminpage.waitForPageToLoad();
		rolepage.quit();
		rolepage.switchToParentWindow();
		
	}
	@Test(priority=21,description="Verify next button on search logs page")
	public void Grid_4048()
	{
		engineadminpage.selectCheckbox();
		commonFunctions.selectLocalAction("Search Logs");
		rolepage.maximizeCurrentWindow();
		engineadminpage.selectYear();
		engineadminpage.clikNext();
		
		rolepage.quit();
		rolepage.switchToParentWindow();
		
	}
	@Test(priority=22,description="Verify back to top option on search logs page")
	public void Grid_4049()
	{
		
		engineadminpage.selectCheckbox();
		commonFunctions.selectLocalAction("Search Logs");
		rolepage.maximizeCurrentWindow();
		engineadminpage.clickBackToTopLink();
		engineadminpage.verifySearchLogs();
		rolepage.quit();
		rolepage.switchToParentWindow();
	}
	@Test(priority=23,description="Verify search manager logs back 1hr, 1 day, 1week, 1 month, 1 year")
	public void Grid_4050()
	{
		engineadminpage.selectCheckbox();
		commonFunctions.selectLocalAction("Search Logs");
		rolepage.maximizeCurrentWindow();
		engineadminpage.selectHour();
		engineadminpage.selectDay();
		engineadminpage.selectWeek();
		engineadminpage.selectMonth();
		engineadminpage.selectYear();
		rolepage.quit();
		rolepage.switchToParentWindow();
	}
	
	@Test(priority=24,description="Verify local action- remote log.")
	public void Grid_4051()
	{	
		engineadminpage.selectCheckbox();
		commonFunctions.selectLocalAction("Remote Log");
		rolepage.maximizeCurrentWindow();
		engineadminpage.verifyRemoteLog();
		rolepage.quit();
		rolepage.switchToParentWindow();
	}
	@Test(priority=25,description="Verify functionality of clear button on remote log page.")
	public void Grid_4052()
	{	
		engineadminpage.selectCheckbox();
		commonFunctions.selectLocalAction("Remote Log");
		rolepage.maximizeCurrentWindow();
		engineadminpage.verifyRemoteLog();
		engineadminpage.verifyClickClear();
		rolepage.quit();
		rolepage.switchToParentWindow();
		

	}
/*	@Test(priority=26,description="Verify functionality of snapshot button on remote log page.")
	public void Grid_4053()
	{	
		engineadminpage.selectCheckbox();
		commonFunctions.selectLocalAction("Remote Log");
		rolepage.maximizeCurrentWindow();
		engineadminpage.verifyRemoteLog();
		engineadminpage.clickSnapshot();
		rolepage.maximizeCurrentWindow();
		engineadminpage.verifyClickSnapshot();
		rolepage.closeChildWindow();
	}*/
	
	@Test(priority=27,description="Verify local action- log files")
	public void Grid_4054()
	{
		engineadminpage.selectCheckbox();
		commonFunctions.selectLocalAction("Log Files");
		rolepage.maximizeCurrentWindow();
		engineadminpage.verifyLogFiles();
		rolepage.quit();
		rolepage.switchToParentWindow();
	}
	
	@Test(priority=28,description="Verify download of log files from log files page")
	public void Grid_4055()
	{
		engineadminpage.selectCheckbox();
		commonFunctions.selectLocalAction("Log Files");
		rolepage.maximizeCurrentWindow();
		engineadminpage.verifyLogFiles();
		engineadminpage.clickDownloadLogLink();
		rolepage.quit();
		rolepage.switchToParentWindow();
	}
	
	@Test(priority=29,description="Verify local action- kill engine")
	public void Grid_4056()
	{	
		engineadminpage.selectCheckbox();
		commonFunctions.selectLocalAction("Kill Engine");
		rolepage.acceptPopup();
	}
	@Test(priority=30,description="Verify global action- kill all engines on page")
	 public void Grid_4041()
	{
		
		engineadminpage.clickGlobalAction();
		commonFunctions.selectGlobalAction("Kill All Engines on Page");
		rolepage.acceptPopup();
		
	}
	@Test(priority=31,description="Verify global action- kill all engines")
	public void Grid_4042()
	{
		
		engineadminpage.clickGlobalAction();
		commonFunctions.selectGlobalAction("Kill All Engines");
		rolepage.acceptPopup();
			
	}
	
}
