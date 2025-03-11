package com.tibco.automation.test.gsui.services.batch;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import com.tibco.automation.common.utils.RandomStringGenerator;
import com.tibco.automation.common.utils.RandomStringGenerator.RandomizerTypes;
import com.tibco.automation.page.admin.useradmin.RolePage;
import com.tibco.automation.page.common.CommonFunctions;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.gridcomponents.engines.EngineAdminPage;
import com.tibco.automation.page.services.batch.BatchDefinitionPage;
import com.tibco.automation.page.services.batch.BatchSchedulePage;

public class BatchSchedule extends WebDriverTestCase{
	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public TemplatePage templatepage;
	public BatchSchedulePage batchSchedule;
	public EngineAdminPage engineadminpage;
	public CommonFunctions commonFunctions;
	public String definitionName;
	public String description;
	public String renameDefinition;
	public String copyDefinition;
	public RolePage rolepage;
	public BatchDefinitionPage batchDefinitions;
	
	@BeforeMethod
	public void beforeMethod()
	{
		batchSchedule=new BatchSchedulePage();
		engineadminpage=new EngineAdminPage();
		rolepage= new RolePage();
		batchDefinitions=new BatchDefinitionPage();
		commonFunctions=new CommonFunctions();
		batchSchedule.launchPage();
		batchSchedule.waitForPageToLoad();
		definitionName=RandomStringGenerator.get(5, RandomizerTypes.MIXED);
		description="description"+definitionName;
		renameDefinition="rename"+definitionName;
		copyDefinition="copy"+definitionName;
	}
	
@Test(priority=1,description="Verify refresh button is present and it shows last refresh on tooltip")
	public void Grid_4246()
	{
		batchSchedule.verifyRefreshButton();
		commonFunctions.verifyLastRefresh();
	}
	@Test(priority=2,description="Verify clicking on refresh button disables it.")
	public void Grid_4247()
	{
		commonFunctions.clickRefreshButton();
		commonFunctions.verifyRefreshDisabled();
	}
	
	@Test(priority=3,description="Verify the functionality of add columns option")
	public void Grid_4248()
	{
		batchSchedule.verifyRemoveColumn();
	
		batchSchedule.verifyAddColumn();
	
	
	}	
	@Test(priority=3,description="Verify the functionality of revert button add columns popup")
	public void Grid_4250()
	{
		batchSchedule.verifyRevertColumn();
	
		
	
	}
	
	
	@Test(priority=4,description="Verify change in results per page value changes the number of rows in table")
	public void Grid_4259()
	{
		
		commonFunctions.updateResultsPerPage(1);
	}
		
	 
	 
	@Test(priority=5,description="Verify functionality of move to last page button")
	public void Grid_4263()
	{
		
		batchSchedule.waitforElement();
		commonFunctions.goToLastPage();
	}
	@Test(priority=6,description="Verify functionality of move to first page button")
	public void Grid_4262()
	{
		
		batchSchedule.waitforElement();
		commonFunctions.goToFirstPage();
	}
	
	
	@Test(priority=7,description="Verify functionality of next page button in pagination")
	 public void Grid_4260()
	{
		
		batchSchedule.waitforElement();
		commonFunctions.goToNextPage();
	}
	@Test(priority=8,description="Verify functionality of previous  page button in pagination")
	 public void Grid_4261()
	{
		
		batchSchedule.waitforElement();
		commonFunctions.goToPreviousPage();
		batchSchedule.waitforElement();
		commonFunctions.updateResultsPerPage(20);
		
	}

	
	
	@Test(priority=9,description="verify simple search.")
	public void Grid_4252()
	{
		commonFunctions.performSimpleSearch("Batch Definition","INVALID");
		batchSchedule.verifySimpleSearch();
		batchSchedule.clearSearch();
	
		
	
	}
	@Test(priority=10,description="Verify query search.")
		public void Grid_4253()
		{
			
			commonFunctions.performQuerySearch("\"Batch Description\" == \"INVALID\"");
			batchSchedule.verifyPerformQuerySearch();
			batchSchedule.clearSearch();
			
		}
	@Test(priority=11,description="Verify query builder search")
		public void Grid_4254()
		{
			
			commonFunctions.performQueryBuilderSearch("Type", "==", "INVALID");
			commonFunctions.clickSearchOnQueryBuilder();
			batchSchedule.verifySimpleSearch();
			batchSchedule.clearSearch();
		}
		
		
		
	@Test(priority=12,description="Verify the functionality Close button of Query Builder popup ")
	public void Grid_4255()
	{
		commonFunctions.performQueryBuilderSearch("Type", "==", "INVALID");
	
		commonFunctions.clickCloseOnQueryBuilder();
	
		
	}
	
	

	@Test(priority=13 , description="Verify functionality of Create New Batch global action")
	public void Grid_4264()
	{
		batchSchedule.clickGlobalAction();
		batchSchedule.verifyCreateNewBatch();
		batchDefinitions.clickAddDefinitionButton();
		batchDefinitions.setDefinitionName(definitionName);
		batchDefinitions.getCurrentWindowHandle();
		batchDefinitions.clickAddOnPopup();
		batchDefinitions.switchToNewlyOpenedWindow();
		batchDefinitions.clickSaveButton();
		batchDefinitions.switchToParentWindow();
		batchDefinitions.waitForPageToLoad();
		batchDefinitions.verifyDefinitionIsPresent(definitionName);
	
	}
	
	
	@Test(priority=14, description="Verify functionality of Remove finished Batch global action")
	public void Grid_4265()
	{
		batchSchedule.clickGlobalAction();
		batchSchedule.verifyRemoveFinishedBatch();
	
	}
		
	@Test(priority=15 , description="Verify functionality of 'Suspend All Batches on Page' global action")
	public void Grid_4268()
	{
		batchSchedule.clickGlobalAction();
		batchSchedule.verifySuspendBatchonPage();
	
	}
	@Test(priority=16 , description="Verify functionality of Suspend All Batches global action")
	public void Grid_4271()
	{
		batchSchedule.clickGlobalAction();
		batchSchedule.verifySuspendBatch();
	
	}
	@Test(priority=17 , description="Verify functionality of View Execution local action")
	public void Grid_4283()
	{
		batchSchedule.clickonBatchDefination();
		batchDefinitions.clickAddDefinitionButton();
		batchDefinitions.setDefinitionName(definitionName);
		batchDefinitions.getCurrentWindowHandle();
		batchDefinitions.clickAddOnPopup();
		batchDefinitions.switchToNewlyOpenedWindow();
			batchDefinitions.waitForPageToLoad();
		batchDefinitions.clickSaveButton();
		batchDefinitions.switchToParentWindow();
		batchDefinitions.waitForPageToLoad();
		batchDefinitions.verifyDefinitionIsPresent(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.getCurrentWindowHandle();
		
		commonFunctions.selectLocalAction("Schedule Batch Definition");
		batchDefinitions.waitForPageToLoad();
		batchDefinitions.verifyBatchSchedulePageIsLaunched();
		
		batchSchedule.clickonBatchSchedulePage();
				batchDefinitions.waitForPageToLoad();

		batchSchedule.selectBatch(definitionName);
		
		commonFunctions.selectLocalAction("View Executions");
		batchDefinitions.waitForPageToLoad();

		
		batchSchedule.verifyBatchAdminPageIsLaunched();
}

	

	@Test(priority=18 , description="Verify functionality of Search Logs local action.")
	public void Grid_4284()
	{
		batchSchedule.clickonBatchDefination();
		batchDefinitions.clickAddDefinitionButton();
		batchDefinitions.setDefinitionName(definitionName);
		batchDefinitions.getCurrentWindowHandle();
		batchDefinitions.clickAddOnPopup();
		batchDefinitions.switchToNewlyOpenedWindow();
		batchDefinitions.waitForPageToLoad();
		batchDefinitions.clickSaveButton();
		batchDefinitions.switchToParentWindow();
		batchDefinitions.waitForPageToLoad();
		batchDefinitions.verifyDefinitionIsPresent(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.getCurrentWindowHandle();
		
		commonFunctions.selectLocalAction("Schedule Batch Definition");
		batchDefinitions.waitForPageToLoad();
		batchDefinitions.verifyBatchSchedulePageIsLaunched();
		
		batchSchedule.clickonBatchSchedulePage();
				batchDefinitions.waitForPageToLoad();

		batchSchedule.selectBatch(definitionName);
		
	
		batchSchedule.verifyLocalAction();
		batchSchedule.verifySearchLogs();
		batchSchedule.closeWindow();
		batchSchedule.switchToParentWindow();
		
	}
	
	
	
	@Test(priority=19 , description="Verify selecting a Batch enables the local action")
	public void Grid_4274()
	{
		
		batchSchedule.clickonBatchSchedule();
		batchSchedule.verifyLocalAction();
		
	}
	@Test(priority=20 , description="Verify deselecting a selected Batch disables local action and enables global action.")
	public void Grid_4275()
	{
		
		batchSchedule.doubleLClickOnBatch();
		
		batchSchedule.clickGlobalAction();
		
		
	}

	
	
		
	@Test(priority=21 , description="Verify functionality of Remove Batch local action.")
	public void Grid_4276()
	{
	
	batchSchedule.clickonBatchDefination();
	
	
	
	batchDefinitions.clickAddDefinitionButton();
	batchDefinitions.setDefinitionName(definitionName);
	batchDefinitions.getCurrentWindowHandle();
	batchDefinitions.clickAddOnPopup();
	batchDefinitions.switchToNewlyOpenedWindow();
		batchDefinitions.waitForPageToLoad();
	batchDefinitions.clickSaveButton();
	batchDefinitions.switchToParentWindow();
	batchDefinitions.waitForPageToLoad();
	batchDefinitions.verifyDefinitionIsPresent(definitionName);
	batchDefinitions.selectDefinition(definitionName);
	batchDefinitions.selectDefinition(definitionName);
	batchDefinitions.selectDefinition(definitionName);
	batchDefinitions.getCurrentWindowHandle();
	
	commonFunctions.selectLocalAction("Schedule Batch Definition");
	batchDefinitions.waitForPageToLoad();
	batchDefinitions.verifyBatchSchedulePageIsLaunched();
	
	batchSchedule.clickonBatchSchedulePage();
	//batchDefinitions.getCurrentWindowHandle();
	batchDefinitions.waitForPageToLoad();

	batchSchedule.selectBatch(definitionName);
	
	
	batchSchedule.removeBatch("Remove Batch");
	commonFunctions.acceptAlert();
	
	
	batchSchedule.verifyBatchIsNotPresent(definitionName);
	
	
}
	
	
	
	
		
	
	
	
	@Test(priority=22 , description=" Verify functionality of View/Edit Batch Services in Group local action.")
	public void Grid_4279()
	{
		batchSchedule.clickonBatchDefination();
		batchDefinitions.clickAddDefinitionButton();
		batchDefinitions.setDefinitionName(definitionName);
		batchDefinitions.getCurrentWindowHandle();
		batchDefinitions.clickAddOnPopup();
		batchDefinitions.switchToNewlyOpenedWindow();
		batchDefinitions.waitForPageToLoad();
		batchDefinitions.clickSaveButton();
		batchDefinitions.switchToParentWindow();
		batchDefinitions.waitForPageToLoad();
		batchDefinitions.verifyDefinitionIsPresent(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.getCurrentWindowHandle();
		commonFunctions.selectLocalAction("Schedule Batch Definition");
		batchDefinitions.waitForPageToLoad();
		batchDefinitions.verifyBatchSchedulePageIsLaunched();
		batchSchedule.clickonBatchSchedulePage();
	    batchDefinitions.waitForPageToLoad();

		batchSchedule.selectBatch(definitionName);
		
		commonFunctions.selectLocalAction("View/Edit Batch");
		batchDefinitions.waitForPageToLoad();
		batchDefinitions.switchToNewlyOpenedWindow();
		batchDefinitions.switchToNewlyOpenedWindow();
		batchSchedule.addDescription(description);
		batchSchedule.clickOnSaveButton();
		batchDefinitions.switchToParentWindow();
		batchDefinitions.verifyDescriptionIsPresent(definitionName,description);
	}
	
	
	
	@Test(priority=23 , description="Verify functionality of Cancel button on View/Edit Batch definition popup")
	public void Grid_4281()
	{
		batchSchedule.clickonBatchDefination();
		batchDefinitions.clickAddDefinitionButton();
		batchDefinitions.setDefinitionName(definitionName);
		batchDefinitions.getCurrentWindowHandle();
		batchDefinitions.clickAddOnPopup();
		batchDefinitions.switchToNewlyOpenedWindow();
		batchDefinitions.waitForPageToLoad();
		batchDefinitions.clickSaveButton();
		batchDefinitions.switchToParentWindow();
		batchDefinitions.waitForPageToLoad();
		batchDefinitions.verifyDefinitionIsPresent(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.getCurrentWindowHandle();
		commonFunctions.selectLocalAction("Schedule Batch Definition");
		batchDefinitions.waitForPageToLoad();
		batchDefinitions.verifyBatchSchedulePageIsLaunched();
		batchSchedule.clickonBatchSchedulePage();
	    batchDefinitions.waitForPageToLoad();

		batchSchedule.selectBatch(definitionName);
		
		commonFunctions.selectLocalAction("View/Edit Batch");
		batchDefinitions.waitForPageToLoad();
		batchDefinitions.switchToNewlyOpenedWindow();
		batchDefinitions.switchToNewlyOpenedWindow();
		batchSchedule.addDescription(description);
		batchSchedule.clickonCancel();
		batchDefinitions.switchToParentWindow();
		batchDefinitions.verifyDescriptionIsNotPresent(definitionName,description);
	}
	
	

	
}
