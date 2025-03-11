package com.tibco.automation.test.gsui.systemadmin;

import org.testng.annotations.Test;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import com.tibco.automation.page.admin.systemadmin.ManagerImportExportPage;
import com.tibco.automation.page.admin.systemadmin.ManagerHooksPage;

import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.TemplatePage;



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

public class ManagerHooks extends WebDriverTestCase{
	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public TemplatePage templatepage;
	public BatchSchedulePage batchSchedule;
	public EngineAdminPage engineadminpage;
	public CommonFunctions commonFunctions;
	public String definitionName;
	public String description="";
	
	public RolePage rolepage;
	public ManagerHooksPage hooks;
	
	@BeforeMethod
	public void beforeMethod()
	{
		commonFunctions=new CommonFunctions();
		rolepage=new RolePage();
		hooks=new ManagerHooksPage();
		hooks.launchPage();
		hooks.waitForPageToLoad();
		engineadminpage=new EngineAdminPage();
		description=RandomStringGenerator.get(5, RandomizerTypes.MIXED);
		
	}

	@Test(priority=1,description="verify the functionality of update properties button of create new hook popup")
	public void Grid_4410()
	{
		
	   	hooks.clickOnGLobalAction();
		
		 hooks.createNewHook();
		 hooks.waitForPageToLoad();
		 hooks.switchToNewlyOpenedWindow();
		 hooks.waitForPageToLoad();
		 hooks.provideInfotoHook();
		 hooks.waitForPageToLoad();
		 hooks.clickOnUpdateProperties();
		 hooks.verifyUpdateProperties();
		 hooks.closeWindow();
		 hooks.switchToParentWindow();
		 
	}
	@Test(priority=2,description="Verify functionality of global action Create New Hook")
	public void Grid_4407()
	{ 
	 
	hooks.verifyHookIsPresent();
    hooks.waitForPageToLoad();
	 hooks.clickOnGLobalAction();
	 hooks.createNewHook();
	 hooks.switchToNewlyOpenedWindow();
	 hooks.waitForPageToLoad();
	 hooks.provideInfotoHook();
	 hooks.waitForPageToLoad();
	 hooks.clickOnSave();
	 hooks.switchToNewlyOpenedWindow();
	 hooks.waitForPageToLoad();
	
	
	hooks.verifyHookAdded();
	 
	 
	} 
	@Test(priority=3,description="verify the functionality of Cancel button of create new hook popup")
	public void Grid_4409() throws InterruptedException
 { 
		 hooks.clickOnGLobalAction();
			
		 hooks.createNewHook();
		 hooks.switchToNewlyOpenedWindow();
		 hooks.waitForPageToLoad();
		
		 hooks.clickOnCancel();
		 hooks.switchToNewlyOpenedWindow();
		 hooks.waitForPageToLoad();
		
		
}
	
	 
		@Test(priority=4,description="Verify change in results per page value changes the number of rows in table")
		public void Grid_4434()
		{
			
			commonFunctions.updateResultsPerPage(1);
		}
			
		 
		 
		@Test(priority=5,description="Verify functionality of move to last page button")
		public void Grid_4438()
		{
			
			hooks.waitforElement();
			commonFunctions.goToLastPage();
		}
		@Test(priority=6,description="Verify functionality of move to first page button")
		public void Grid_4437()
		{
			
			hooks.waitforElement();
			commonFunctions.goToFirstPage();
		}
		
		
		@Test(priority=7,description="Verify functionality of next page button in pagination")
		 public void Grid_4435()
		{
			
			hooks.waitforElement();
			commonFunctions.goToNextPage();
		}
		@Test(priority=8,description="Verify functionality of previous  page button in pagination")
		 public void Grid_4436()
		{
			
		hooks.waitforElement();
			commonFunctions.goToPreviousPage();
			rolepage.waitt();
			commonFunctions.updateResultsPerPage(20);
			
		}
		
		
		
		@Test(priority=9,description="Verify simple search by using Description")
		public void Grid_4427()
		{
			commonFunctions.performSimpleSearch("Description","INVALID");
		    hooks.verifySimpleSearch();
		    hooks.clearSearch();
		
			
		
		}
		@Test(priority=10,description="Verify query search using Manager")
			public void Grid_4428()
			{
				
				commonFunctions.performQuerySearch("\"Manager\" == \"INVALID\"");
				hooks.verifyPerformQuerySearch();
				hooks.clearSearch();
				
			}
		@Test(priority=11,description="Verify query builder search using Local file")
			public void Grid_4429()
			{
				
				commonFunctions.performQueryBuilderSearch("Local File", "==", "INVALID");
				commonFunctions.clickSearchOnQueryBuilder();
				hooks.verifySimpleSearch();
				hooks.clearSearch();
			}
			
			
			
		@Test(priority=12,description="Verify the functionality Close button of Query Builder popup ")
		public void Grid_4430()
		{
			commonFunctions.performQueryBuilderSearch("Name", "==", "INVALID");
		
			commonFunctions.clickCloseOnQueryBuilder();
		
			
		}
		


		@Test(priority=13,description="Verify the functionality of add columns option")
		public void Grid_4404()
		{
			hooks.verifyRemoveColumn();
		
			hooks.verifyAddColumn();
		
		
		}	
	
	   @Test(priority=14,description="Verify the functionality of revert button add columns popup")
		public void Grid_4406()
		{
			hooks.verifyRevertColumn();
		
			
		
		}
	   
		@Test(priority=15,description="Verify selecting Hook enables local action and disables global action.")
		public void Grid_4711()
		{
			hooks.selectHook();
			hooks.verifyLocalAction();
		}
	
		@Test(priority=16, description="Verify deselecting a selected Hook disables local action and enables global action.")
		public void Grid_4412()
		{
		
			hooks.doubleClickOnHook();
			hooks.clickOnGLobalAction();
			
		}
		
		 @Test(priority=17, description="Verify functionality of Disable Hook local action")
		  public void Grid_4414()
			{
					hooks.selectHook();
				
					hooks.selectLocalAction("Disable Hook");
					hooks.verifyDisableHook();
					
			}
	
	
		 @Test(priority=18,description="verify the functionality of Generate xml button of create new hook popup")
			public void Grid_4411()
			{
				 hooks.clickOnGLobalAction();
				 hooks.waitForPageToLoad();
				 hooks.createNewHook();
				 hooks.switchToNewlyOpenedWindow();
				 hooks.waitForPageToLoad();
				 hooks.provideInfotoHook();
				 hooks.waitForPageToLoad();
				 hooks.selectXMLView();
				 hooks.waitForPageToLoad();
				 hooks.clickOnGenerateXML();
				 hooks.waitForPageToLoad();
				 hooks.VerifyGenerateXML();
				 hooks.closeWindow();
				 hooks.switchToParentWindow();
				 
			}
		
		
			@Test(priority=19 , description="Verify functionality of Enable Hook local action")
			public void Grid_4413()
			{
				hooks.selectHook();
				hooks.selectLocalAction("Enable Hook");
				hooks.verifyEnableHook();
			
			}
		@Test(priority=20,description="Verify the functionality of Generate XML button of Edit hook popup")
			public void Grid_4419()
			{
			 hooks.selectHook();
				hooks.selectLocalAction("Edit Hook");
				hooks.switchToNewlyOpenedWindow();
			
				 hooks.waitForPageToLoad();
				 hooks.selectXMLView();
				 hooks.waitForPageToLoad();
				 hooks.clickOnGenerateXML();
				 hooks.waitForPageToLoad();
				 hooks.VerifyGenerateXML();
				 
				 hooks.closeWindow();
				 hooks.switchToParentWindow();
			}	

	@Test(priority=21 , description="Verify functionality of Edit Hook local action")
	public void Grid_4415()
	{
		hooks.selectHook();
		hooks.selectLocalAction("Edit Hook");
		hooks.switchToNewlyOpenedWindow();
		hooks.setDescription(description);
		 hooks.clickOnSave();
		
		 hooks.switchToNewlyOpenedWindow();
		 hooks.waitForPageToLoad();
		hooks.verifyDescriptionIsPresent(description);
		
		
	}
	
	
	 @Test(priority=22 , description="Verify the functionality of Cancel button of Edit hook popup")
		public void Grid_4417()
		{
		 hooks.selectHook();
		
		hooks.waitForPageToLoad();
			
			hooks.selectLocalAction("Edit Hook");
			
			hooks.switchToNewlyOpenedWindow();
			hooks.waitForPageToLoad();
			hooks.setDescription(description);
			
			hooks.waitForPageToLoad();
			
			hooks.clickOnCancel();
			 hooks.switchToNewlyOpenedWindow();
			 hooks.waitForPageToLoad();
			
		hooks.verifyDescriptionIsNotPresent(description);
		
		
}
	@Test(priority=23 , description="Verify functionality of Delete Hook local action")
		public void Grid_4422()
		{
			
		hooks.selectHook();
		hooks.selectLocalAction("Delete Hook");
		commonFunctions.acceptAlert();
		hooks.waitForPageToLoad();
		hooks.verifyDeleteHook();
		
		
}
	
	@Test(priority=24 , description="Verify functionality of Delete Hook local action")
		public void Grid_5300()
		{
		hooks.clickOnHelp();
		hooks.verifyPageHelp();
		
		
		}
	
}


