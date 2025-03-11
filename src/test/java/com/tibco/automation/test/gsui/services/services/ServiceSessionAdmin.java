package com.tibco.automation.test.gsui.services.services;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import com.tibco.automation.common.utils.RandomStringGenerator;
import com.tibco.automation.common.utils.RandomStringGenerator.RandomizerTypes;
import com.tibco.automation.page.common.CommonFunctions;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.services.services.ServiceConditionsPage;
import com.tibco.automation.page.services.services.ServiceSessionAdminPage;
import com.tibco.automation.page.services.services.ServiceTestPage;

public class ServiceSessionAdmin extends WebDriverTestCase{
	
	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public TemplatePage templatepage;
	public ServiceSessionAdminPage servicesession;
	public CommonFunctions commonFunctions;
	public String conditionName;
	public String copiedConditionName;
	public String renameConditionName;
	ServiceTestPage servicetestpage;
	@BeforeMethod
	public void beforeMethod()
	{
		servicetestpage=new ServiceTestPage();
		servicesession=new ServiceSessionAdminPage();
		commonFunctions=new CommonFunctions();
		servicesession.launchPage();
		servicesession.waitForPageToLoad();
		conditionName=RandomStringGenerator.get(5, RandomizerTypes.MIXED);
		copiedConditionName="copy"+conditionName;
		renameConditionName="rename"+conditionName;
	}
	@Test(priority=1,description="Verify refresh button is present and it shows last refresh on tooltip")
	public void Grid_3988()
	{
		servicesession.verifyRefreshButton();
		commonFunctions.verifyLastRefresh();
    }

	 @Test(priority=2,description="Verify clicking on refresh button disables it.")
	public void Grid_3989()
	{
		commonFunctions.clickRefreshButton();
		commonFunctions.verifyRefreshDisabled();
	}

	
	
	
	  @Test(priority=3,description="Verify the functionality of add columns option")
	public void Grid_3990()
	{
		
	
		servicesession.verifyAddColumn();
	
	
	}
	
	
	@Test(priority=4,description="Verify the functionality of revert button add columns popup")
	public void Grid_3992()
	{
		servicesession.verifyRevertColumn();
	
		
	
	}

	@Test(priority=5,description="Verify simple search by using hostname")
	public void Grid_3995()
	{
		commonFunctions.performSimpleSearch("Hostname","INVALID");
		servicesession.verifySimpleSearch();
		servicesession.clearSearch();

	}
	
	@Test(priority=6,description="Verify query search using username.")
	public void Grid_3996()
	{
		
		commonFunctions.performQuerySearch("\"Username\" == \"INVALID\"");
		servicesession.verifyPerformQuerySearch();
		servicesession.clearSearch();
		
	}
	
	@Test(priority=7,description="Verify query builder search using Status")
	public void Grid_3997()
	{
		
		commonFunctions.performQueryBuilderSearch("Status", "==", "INVALID");
		commonFunctions.clickSearchOnQueryBuilder();
		servicesession.verifySimpleSearch();
		servicesession.clearSearch();
	}
	
	
	
	@Test(priority=8,description="Verify the functionality Close button of Query Builder popup ")
	public void Grid_3998()
   {
	commonFunctions.performQueryBuilderSearch("Status", "==", "INVALID");
	commonFunctions.clickCloseOnQueryBuilder();

	
   }
	
	@Test(priority=9,description="Verify change in results per page value changes the number of rows in table")
	public void Grid_4002()
	{
		
		commonFunctions.updateResultsPerPage(1);
	}
		
	 
	 @Test(priority=10,description="Verify functionality of next page button in pagination.")
	 public void Grid_4003()
	{
		
		servicesession.waitforElement();
		commonFunctions.goToNextPage();
	}
	
	 @Test(priority=11,description="Verify functionality of previous page button in pagination")
	 public void Grid_4004()
	{
		
		 servicesession.waitforElement();
		commonFunctions.goToPreviousPage();
		servicesession.waitforElement();
		commonFunctions.updateResultsPerPage(20);
		
	}
	 
	 @Test(priority=12,description="Verify functionality of move to first page button")
		public void Grid_4005()
		{
			
		    servicesession.waitforElement();
			commonFunctions.goToFirstPage();
		}
	 
	 @Test(priority=13,description="Verify functionality of move to last page button")
		public void Grid_4006()
		{
			
		    servicesession.waitforElement();
			commonFunctions.goToLastPage();
		}
	 
	 
	
	 @Test(priority=14,description="Verify functionality of Expand View of All global action")
		public void Grid_4009()
		{
        
		  servicesession.clickonGlobalAction();
		  servicesession.clickOnExpandAll();
		  servicesession.waitForPageToLoad();
		  
		 
		}
		 
	 @Test(priority=15,description="Verify functionality of Collapse View of All global action")
		public void Grid_4008()
		{
		 
		  servicesession.clickonGlobalAction();
		
		  servicesession.clickOnCollapseAll();
		  servicesession.waitForPageToLoad();
		  servicesession.verifyCollapseAll();
		} 


	 @Test(priority=16 , description="Verify selecting service session enables the local action")
		public void Grid_4016()
		{
			
		  servicesession.clickonServiceSession();
		  servicesession.waitForPageToLoad();
		  servicesession.verifyLocalAction();
			
		}
		@Test(priority=17 , description="Verify deselecting a selected service session disables local action and enables global action.")
		public void Grid_4017()
		{
			
			  servicesession.doubleClickOnServiceSession();
			  servicesession.waitForPageToLoad();
			  servicesession.clickonGlobalAction();		
		}
		  @Test(priority=18 , description="Verify functionality of Remove Service Session local action")
			
			public void Grid_4021()
				{
				 
				 servicesession.clickonServiceSession();
				 commonFunctions.selectLocalAction("Remove Service Session");
			//	 commonFunctions.acceptAlert();
				 servicesession.waitForPageToLoad();
				 servicesession.verifyRemoveFinishService();
				 
				}
	
	@Test(priority=19 , description="Verify functionality of Cancel all service Sessions on Page global action")
		public void Grid_4014()
		{
		
		     servicesession.clickOnServiceTestPage();
		 	 servicetestpage.clickLinpackSubmit();
		 	 servicetestpage.verifyClickLinpackSubmit();
		 	servicesession.waitForPageToLoad();
			  servicesession.clickonGlobalAction();		
			  servicesession.clickOnCancelAllSessionOnPage();
			  servicesession.waitForPageToLoad();
			  servicesession.verifyCancelOnPage();
			  
		}
	
	@Test(priority=20 , description="Verify functionality of Cancel all service Sessions global action")
	public void Grid_4015()
	{
	     servicesession.clickOnServiceTestPage();
		 servicetestpage.clickLinpackSubmit();
		 servicetestpage.verifyClickLinpackSubmit();
		 commonFunctions.verifyGlobalActionLinkIsPresent();
		 commonFunctions.selectGlobalAction("Cancel All Service Sessions");
		 commonFunctions.acceptAlert();
		// servicesession.clickOnCancelAllSession();
		 servicesession.waitForPageToLoad();
		  servicesession.verifyCancelAllSession();
		  
	}
		 
	  @Test(priority=21 , description="Verify functionality of Set Priority of All Sessions on page global action")
	public void Grid_4013()
	{  
	   
	    
	     servicesession.clickOnServiceTestPage();
		 servicetestpage.clickLinpackSubmit();
		 servicesession.waitForPageToLoad();
		 servicetestpage.verifyClickLinpackSubmit();	 
		 servicesession.clickonGlobalAction();
		 servicesession.clickOnSetPriorityOnPage();
		 
		 servicesession.switchToNewlyOpenedWindow();
		 servicesession.setPriorityOnPage();
		 servicesession.waitForPageToLoad();
		 servicesession.verifyPrioritySet();
		
	}
	
	
		
	
	 @Test(priority=22 , description="Verify functionality of service session details local action")
		public void Grid_4018()
		{ 
		
		 servicesession.clickOnServiceTestPage();
		 servicetestpage.clickLinpackSubmit();
		 servicesession.waitForPageToLoad();
		 servicetestpage.verifyClickLinpackSubmit();
		 servicesession.clickonServiceSession();
		 commonFunctions.selectLocalAction("Service Session Details");
		 servicesession.verifySeviceSessionDetails();
		 
		}
	

	
	 @Test(priority=23 , description="Verify functionality of view service session local action")
		public void Grid_4019()
		{	 
		 
		
		 servicesession.clickonServiceSession();
		 commonFunctions.selectLocalAction("View Service Session");
		 servicesession.switchToNewlyOpenedWindow();
		 servicesession.waitForPageToLoad();
		
		 servicesession.waitForPageToLoad();
		 
		 servicesession.verifyViewServiceSession();	
		 servicesession.closeWindow();
		 servicesession.switchToParentWindow();
		}
	 
	

	 @Test(priority=24 , description="Verify functionality of search logs local action")
		public void Grid_4020()
		{	
		
	
		 servicesession.clickonServiceSession();
		 commonFunctions.selectLocalAction("Search Logs");
		 servicesession.switchToNewlyOpenedWindow();
		 servicesession.waitForPageToLoad();
		 servicesession.verifySearchLogs();
		 servicesession.closeWindow();
		 servicesession.switchToParentWindow();
		 
	    }
	    
	
	 @Test(priority=25 , description="Verify the functionality of Task admin on Local Action")
		public void Grid_5251()
		{
		
		 servicesession.clickonServiceSession();
		 commonFunctions.selectLocalAction("Task Admin");
		 servicesession.waitForPageToLoad();
		 servicesession.verifyTaskAdmin();
		
}

	
 @Test(priority=26 , description="Verify functionality of change priority local action")
		public void Grid_4022()
		{
		 servicesession.clickOnServiceTestPage();
		 servicetestpage.clickLinpackSubmit();
		 servicesession.waitForPageToLoad();
		 servicetestpage.verifyClickLinpackSubmit();
		 servicesession.clickonServiceSession();
		 commonFunctions.selectLocalAction("Change Priority");
		 servicesession.switchToNewlyOpenedWindow();
		 servicesession.setPriority();
		 servicesession.waitForPageToLoad();
		servicesession.verifyPrioritySet();
		 
		}
	
	
	 @Test(priority=27 , description="Verify functionality of cancel service session local action")
		public void Grid_4023()
		{

		 servicesession.clickOnServiceTestPage();
		 servicetestpage.clickLinpackSubmit();
		 servicesession.waitForPageToLoad();
		 servicetestpage.verifyClickLinpackSubmit();
		 servicesession.clickonServiceSession();
		 commonFunctions.selectLocalAction("Cancel Service Session");
		 servicesession.waitForPageToLoad();
		 servicesession.verifyCancelServiceSession();
		
}
	 
	 @Test(priority=28,description="Verify functionality of Remove Finished Service Session global action.")
		public void Grid_4010()
		{
		 
		  commonFunctions.verifyGlobalActionLinkIsPresent();
		  commonFunctions.selectGlobalAction("Remove Finished Service Sessions");
		  commonFunctions.acceptAlert();
		  servicesession.waitForPageToLoad();
		  servicesession.verifyRemoveFinishServiceOnPage();
		  
		}
 
}
