package com.tibco.automation.test.gsui.usersadmin.users;

	import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
	import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
	import com.tibco.automation.common.utils.RandomStringGenerator;
	import com.tibco.automation.page.admin.useradmin.RolePage;
	import com.tibco.automation.page.common.CommonFunctions;
	import com.tibco.automation.page.common.DataGrid;
	import com.tibco.automation.page.common.TemplatePage;

	public class Roles extends WebDriverTestCase{
		//ADMIN --> ROLE ADMIN
		public ExtendedWebDriver driver;
		public DataGrid datagrid;
		public TemplatePage templatepage;
		public String roleName=null;
		public RolePage rolepage;
		public String Manger_List;
		public CommonFunctions commonFunctions;
		public String data=null;
		
		@BeforeMethod
		public void beforeTest()
		{
			rolepage=new RolePage();
			commonFunctions=new CommonFunctions();
			Manger_List="*";
			rolepage.launchPage();
			rolepage.waitForPageToLoad();
		}
		
		@Test(priority=1,description="Verify add columns option is present on page")
		public void Grid_4537()
		{
			rolepage.addColumnPresent();
		}
		
		@Test(priority=2,description="Verify user is able to add/remove columns after clicking on Save button.")
		public void Grid_4538()
		{
			rolepage.removeColumn();
			rolepage.waitForPageToLoad();
			rolepage.verifyRemoveColumn();
			rolepage.addColumn();
			rolepage.waitForPageToLoad();
			rolepage.verifyAddColumn();
		}
		
		@Test(priority=3,description="Verify the functionality of revert button add columns popup.")
		public void Grid_4539()
		{
			rolepage.removeColumn();
			rolepage.waitForPageToLoad();
			rolepage.verifyRemoveColumn();
			rolepage.addColumn();
			rolepage.waitForPageToLoad();
			rolepage.revertButton();
			rolepage.waitForPageToLoad();
			rolepage.verifyRevertButton();
		}
		@Test(priority=4,description="Verify functionality of global action Create New Role")
	    public void Grid_4540()
	    {	
	    	rolepage.clickCreateNewRole();
	    	rolepage.maximizeCurrentWindow();
	    	rolepage.verifyGlobalAction();
	    	rolepage.cancelButton();
	    }
	    
		
		 @Test(priority=5,description="Verify the functionality of Save button of Create New Role popup")
	    public void Grid_4541()
	    {	
	    	roleName ="Role1"+RandomStringGenerator.get(3);
	    	rolepage.clickCreateNewRole();
	    	rolepage.maximizeCurrentWindow();
	    	rolepage.verifyGlobalAction();
	    	rolepage.insertData(roleName,Manger_List);
	    	rolepage.saveButton();
	    	rolepage.waitForPageToLoad();
	    	rolepage.verifySaveButton(roleName);
	    	rolepage.waitForPageToLoad();
	    	rolepage.selectRole(roleName);
	    	rolepage.waitForPageToLoad();
			rolepage.deleteRoleLocalAction(roleName);
			rolepage.acceptPopup();
			rolepage.waitForPageToLoad();
			rolepage.waitt();
			rolepage.verifyLocalActionDelete(roleName);
	    }
	    
		 @Test(priority=6 ,description="Verify the functionality of Enabled Permissions of Create New Role popup")
	    public void Grid_4546()
	    {	
			
			roleName ="Enablerole1"+RandomStringGenerator.get(3);
	    	rolepage.clickCreateNewRole();
	    	rolepage.maximizeCurrentWindow();
	    	rolepage.verifyGlobalAction();
	    	rolepage.insertData(roleName,Manger_List);
			rolepage.enabledPermission();
			rolepage.saveButton();
			rolepage.waitForPageToLoad();
			rolepage.selectRole(roleName);
			rolepage.waitForPageToLoad();
			commonFunctions.selectLocalAction("View/Edit");
			rolepage.maximizeCurrentWindow();
			rolepage.verifyEnabledPermission(roleName);
			rolepage.cancelButton();
			rolepage.waitForPageToLoad();
			rolepage.selectRole(roleName);
			rolepage.waitForPageToLoad();
			rolepage.deleteRoleLocalAction(roleName);
			rolepage.acceptPopup();
			rolepage.waitForPageToLoad();
			rolepage.waitt();
			rolepage.verifyLocalActionDelete(roleName);
	   }
		 @Test(priority=7,description="Verify the functionality of Copy Security Role on Create New Role popup")
	    public void Grid_4547()
	    {	
			roleName ="copyrole1"+RandomStringGenerator.get(3);
	    	rolepage.clickCreateNewRole();
	    	rolepage.maximizeCurrentWindow();
	    	rolepage.verifyGlobalAction();
	    	rolepage.insertData(roleName,Manger_List);
	        rolepage.copyRole();
			rolepage.saveButton();
			rolepage.waitForPageToLoad();
			rolepage.verifyCopySecurityRole(roleName);
			rolepage.selectRole(roleName);
			rolepage.waitForPageToLoad();
			rolepage.deleteRoleLocalAction(roleName);
			rolepage.acceptPopup();
			rolepage.waitForPageToLoad();
			rolepage.waitt();
			rolepage.verifyLocalActionDelete(roleName);
		 }
	    
	  @Test(priority=8,description="Verify after clicking on sub-table header arrow it will expand/collapse information on Create New Role") 
	      public void Grid_4545()
	    {
	    	rolepage.clickCreateNewRole();
	    	rolepage.maximizeCurrentWindow();
	    	rolepage.verifyGlobalAction();
	    	rolepage.sub_Table_Collapse();
	    	rolepage.waitForPageToLoad();
	    	rolepage.verifyCollapse_Detail();
	    	rolepage.sub_Table_Expand();
	    	rolepage.waitForPageToLoad();
	    	rolepage.verifyExpand_Detail();
	    	rolepage.cancelButton2();
	    }
		
	    @Test(priority=9,description="Verify the functionality of Collapse All button of Create New Role popup")
	    public void Grid_4544()
	    {	
	    	rolepage.clickCreateNewRole();
	    	rolepage.maximizeCurrentWindow();
	    	rolepage.verifyGlobalAction();
			rolepage.collapseAll();
			rolepage.waitForPageToLoad();
			rolepage.verifyCollapse_Detail();
			rolepage.waitForPageToLoad();
			rolepage.cancelButton();
	    }
		
		
		
	   @Test(priority=10,description="Verify the functionality of Expand All button of Create New Role popup")
	    public void Grid_4543()
	    {
	    	rolepage.clickCreateNewRole();
	    	rolepage.maximizeCurrentWindow();
	    	rolepage.verifyGlobalAction();
	    	rolepage.collapseAll();
	    	rolepage.waitForPageToLoad();
	    	rolepage.expandAll();
	    	rolepage.waitForPageToLoad();
	    	rolepage.verifyExpand_Detail();
	    	rolepage.cancelButton();
	    }
		
	   @Test(priority=11,description="Verify the functionality of Cancel button of Create New Role popup")
	    public void Grid_4542()
	    {	
			roleName ="CancelRole"+RandomStringGenerator.get(3);
	    	rolepage.clickCreateNewRole();
	    	rolepage.maximizeCurrentWindow();
	    	rolepage.verifyGlobalAction();
	    	rolepage.insertData(roleName,Manger_List);
			rolepage.cancelButton();
			rolepage.waitForPageToLoad();
			rolepage.verifyCancelButton(roleName);
			
	    }
	    
	  @Test(priority=12,description="Verify functionality of checkboxes on Create New Role popup")
	    public void Grid_4548()
	    {	
			roleName ="CancelRole"+RandomStringGenerator.get(3);
	    	rolepage.clickCreateNewRole();
	    	rolepage.maximizeCurrentWindow();
	    	rolepage.verifyGlobalAction();
	    	rolepage.insertData(roleName,Manger_List);
	    	rolepage.selectCheckboxFunction();
			rolepage.saveButton();
			rolepage.waitForPageToLoad();
			rolepage.selectRole(roleName);
			rolepage.waitForPageToLoad();
			rolepage.viewEditRole();
			rolepage.maximizeCurrentWindow();
			rolepage.verifyCheckboxIsSelected();
			rolepage.cancelButton();
			rolepage.waitForPageToLoad();
			rolepage.selectRole(roleName);
			rolepage.viewEditRole();
			rolepage.maximizeCurrentWindow();
			rolepage.deselectCheckboxFunction();
			rolepage.saveButton();
			rolepage.waitForPageToLoad();
			rolepage.selectRole(roleName);
			rolepage.waitForPageToLoad();
			rolepage.viewEditRole();
			rolepage.maximizeCurrentWindow();
			rolepage.waitForPageToLoad();
			rolepage.verifyCheckboxIsDeselected();
			rolepage.cancelButton();
			rolepage.waitForPageToLoad();
			rolepage.selectRole(roleName);
			rolepage.waitForPageToLoad();
			rolepage.deleteRoleLocalAction(roleName);
			rolepage.acceptPopup();
			rolepage.waitForPageToLoad();
			rolepage.waitt();
			rolepage.verifyLocalActionDelete(roleName);
		}
	    
	    
		@Test(priority=13,description="Verify simple search by using Create Description.")
		public void Grid_4574()
		{
			
			commonFunctions.performSimpleSearch("Role Name","INVALID");
			rolepage.waitForPageToLoad();
			rolepage.verifySimpleSearch();
			rolepage.clearSearch();
		}
		
		@Test(priority=14,description="Verify query search by using Create Description.")
		public void Grid_4575()
		{
			
			commonFunctions.performQuerySearch("\"Description\" == \"INVALID\"");
			rolepage.waitForPageToLoad();
			rolepage.verifyPerformQuerySearch();
			rolepage.clearSearch();
			
		}
		
		@Test(priority=15,description="Verify query builder search by using Create Description.")
		public void Grid_4576()
		{
			
			commonFunctions.performQueryBuilderSearch("Role Name", "==", "INVALID");
			commonFunctions.clickSearchOnQueryBuilder();
			rolepage.waitForPageToLoad();
			rolepage.verifyPerformQuerySearch();
			rolepage.clearSearch();
		}
		
		@Test(priority=16,description="Verify the functionality Close button of Query Builder popup")
		public void Grid_4577()
		{
			
			commonFunctions.performQueryBuilderSearch("Role Name", "==", "View");
			commonFunctions.clickCloseOnQueryBuilder();
			rolepage.waitForPageToLoad();
			rolepage.verifyClickCloseOnQueryBuilder();
		}
		
		@Test(priority=17,description="Verify change in results per page value changes the number of rows in table")
		public void Grid_4581()
		{
			
			commonFunctions.updateAndVerifyResultsPerPage(2);
		}
		
		@Test(priority=18,description="Verify functionality of move to last page button")
		public void Grid_4585()
		{
			
			rolepage.waitt();
			commonFunctions.goToLastPage();
		}
		
		@Test(priority=19,description="Verify functionality of move to first page button")
		public void Grid_4584()
		{
			
			rolepage.waitt();
			rolepage.waitForPageToLoad();
			commonFunctions.goToFirstPage();
		}
		
		@Test(priority=20,description="Verify functionality of next page button in pagination")
		 public void Grid_4582()
		{
			
			rolepage.waitt();
			rolepage.waitForPageToLoad();
			commonFunctions.goToNextPage();
		}
		
		@Test(priority=21,description="Verify functionality of previous  page button in pagination")
		 public void Grid_4583()
		{

			rolepage.waitForPageToLoad();
			rolepage.waitt();
			commonFunctions.goToPreviousPage();
			rolepage.waitForPageToLoad();
			rolepage.waitt();
			commonFunctions.updateResultsPerPage(20);
			
		}
		
		 
		 
		@Test(priority=22,description="Verify selecting a Role enables the local action")
		 public void Grid_4549()
		{
			rolepage.selectCheckbox();
			rolepage.waitForPageToLoad();
			rolepage.verifyEnableLocalAction();
			rolepage.selectCheckbox();
			
		}
		
		@Test(priority=23,description="Verify deselecting a selected Role disables local action and enables global action.")
		 public void Grid_4550()
		{
			rolepage.selectCheckbox();
			rolepage.selectCheckbox();
			rolepage.waitForPageToLoad();
			rolepage.verifyEnableGlobalAction();
			
		}
		@Test(priority=24,description="Verify functionality of Save button View/Edit local action")
	    public void Grid_4551()
	    {
	    	roleName ="DATA"+RandomStringGenerator.get(3);
			rolepage.selectCheckbox();
			rolepage.waitForPageToLoad();
			rolepage.viewEditRole();
			rolepage.maximizeCurrentWindow();
			rolepage.enterdata(roleName);
			rolepage.localActionSave();
			rolepage.waitForPageToLoad();
			rolepage.verifyViewEditRole(roleName);
	    }
	    
	 @Test(priority=25,description="Verify the functionality of Expand All button of View/Edit popup")
	    public void Grid_4554()
	    {
			rolepage.selectCheckbox();
			rolepage.waitForPageToLoad();
			rolepage.viewEditRole();
			rolepage.maximizeCurrentWindow();
	    	rolepage.collapseAll();
	    	rolepage.waitForPageToLoad();
	    	rolepage.expandAll();
	    	rolepage.waitForPageToLoad();
	    	rolepage.verifyExpand_Detail();
	    	rolepage.cancelButton();
		 }
	  
	  @Test(priority=26,description="Verify the functionality of Collapse All button of View/Edit popup")
	    public void Grid_4555()
	    {
			rolepage.selectCheckbox();
			rolepage.waitForPageToLoad();
			rolepage.viewEditRole();
			rolepage.maximizeCurrentWindow();
			rolepage.collapseAll();
			rolepage.waitForPageToLoad();
			rolepage.verifyCollapse_Detail();
			rolepage.cancelButton();
		 }
	    
	    @Test(priority=27,description="Verify after clicking on sub-table header arrow it will expand/collapse information on View/Edit popup")
	    public void Grid_4556()
	    {
	    	rolepage.selectCheckbox();
	    	rolepage.waitForPageToLoad();
			rolepage.viewEditRole();
			rolepage.maximizeCurrentWindow();
			rolepage.waitForPageToLoad();
	    	rolepage.sub_Table_Collapse();
	    	rolepage.waitForPageToLoad();
	    	rolepage.verifyCollapse_Detail();
	    	rolepage.waitForPageToLoad();
	    	rolepage.sub_Table_Expand();
	    	rolepage.verifyExpand_Detail();
	    	rolepage.cancelButton2();
		 }
	    
	    
	    @Test(priority=28 ,description="Verify the functionality of Enabled Permissions on View/Edit popup")
	    public void Grid_4557()
	    {
	    	roleName ="ViewEditRole"+RandomStringGenerator.get(3);
	    	rolepage.clickCreateNewRole();
	    	rolepage.maximizeCurrentWindow();
	    	rolepage.verifyGlobalAction();
	    	rolepage.insertData(roleName,Manger_List);
	    	rolepage.saveButton();
	    	rolepage.waitForPageToLoad();
	    	rolepage.selectRole(roleName);
	    	rolepage.waitForPageToLoad();
	    	rolepage.viewEditRole();
			rolepage.maximizeCurrentWindow();
			rolepage.waitForPageToLoad();
			rolepage.enabledPermission();
			rolepage.saveButton();
			rolepage.waitForPageToLoad();
	    	rolepage.selectRole(roleName);
	    	rolepage.waitForPageToLoad();
	    	rolepage.viewEditRole();
	    	rolepage.maximizeCurrentWindow();
	    	rolepage.waitForPageToLoad();
			rolepage.verifyEnabledPermission(roleName);
			rolepage.cancelButton();
			rolepage.waitForPageToLoad();
			rolepage.selectRole(roleName);
			rolepage.waitForPageToLoad();
			rolepage.deleteRoleLocalAction(roleName);
			rolepage.acceptPopup();
			rolepage.waitForPageToLoad();
			rolepage.waitt();
			rolepage.verifyLocalActionDelete(roleName);
	   }
	    
	    
	  @Test(priority=29,description="Verify the functionality of Copy Security Role on View/Edit popup")
	    public void Grid_4558()
	    {	
			roleName ="ViewEditRole"+RandomStringGenerator.get(3);
	    	rolepage.clickCreateNewRole();
	    	rolepage.maximizeCurrentWindow();
	    	rolepage.verifyGlobalAction();
	    	rolepage.insertData(roleName,Manger_List);
	        rolepage.saveButton();
	        rolepage.waitForPageToLoad();
			rolepage.selectRole(roleName);
			rolepage.waitForPageToLoad();
			rolepage.viewEditRole();
			rolepage.maximizeCurrentWindow();
			rolepage.copyRole();
			rolepage.saveButton();
			rolepage.waitForPageToLoad();
			rolepage.verifyCopySecurityRole(roleName);
			rolepage.selectRole(roleName);
			rolepage.waitForPageToLoad();
			rolepage.deleteRoleLocalAction(roleName);
			rolepage.acceptPopup();
			rolepage.waitForPageToLoad();
			rolepage.deleteMessage(roleName);
		 }
	    
	  @Test(priority=30,description="Verify functionality of checkboxes on View/Edit popup")
	    public void Grid_4559()
	    {
		  roleName ="ViewEditRole"+RandomStringGenerator.get(3);
	    	rolepage.clickCreateNewRole();
	    	rolepage.maximizeCurrentWindow();
	    	rolepage.verifyGlobalAction();
	    	rolepage.insertData(roleName,Manger_List);
	        rolepage.saveButton();
	        rolepage.waitForPageToLoad();
			rolepage.selectRole(roleName);
			rolepage.waitForPageToLoad();
			rolepage.viewEditRole();
			rolepage.maximizeCurrentWindow();
			rolepage.selectCheckboxFunction();
			rolepage.saveButton();
			rolepage.waitForPageToLoad();
			rolepage.selectRole(roleName);
			rolepage.waitForPageToLoad();
			rolepage.viewEditRole();
			rolepage.maximizeCurrentWindow();
			rolepage.verifyCheckboxIsSelected();
			rolepage.cancelButton();
			rolepage.waitForPageToLoad();
			rolepage.selectRole(roleName);
			rolepage.waitForPageToLoad();
			rolepage.viewEditRole();
			rolepage.maximizeCurrentWindow();
			rolepage.deselectCheckboxFunction();
			rolepage.saveButton();
			rolepage.waitForPageToLoad();
			rolepage.selectRole(roleName);
			rolepage.waitForPageToLoad();
			rolepage.viewEditRole();
			rolepage.maximizeCurrentWindow();
			rolepage.verifyCheckboxIsDeselected();
			rolepage.cancelButton();
			rolepage.waitForPageToLoad();
			rolepage.selectRole(roleName);
			rolepage.waitForPageToLoad();
			rolepage.deleteRoleLocalAction(roleName);
			rolepage.acceptPopup();
			rolepage.waitForPageToLoad();
			rolepage.deleteMessage(roleName);
	    }
	    @Test(priority=31,description="Verify the functionality of Cancel button of View/Edit popup")
		public void Grid_4553()
		{
			roleName ="CANCEL"+RandomStringGenerator.get(3);
			rolepage.selectCheckbox();
			rolepage.waitForPageToLoad();
			rolepage.viewEditRole();
			rolepage.maximizeCurrentWindow();
			rolepage.enterdata(roleName);
			rolepage.cancelButton();
			rolepage.waitForPageToLoad();
			rolepage.verifyViewEditRoleCancel(roleName);
		}
		
		@Test(priority=32,description="Verify functionality of Copy local action")
		public void Grid_4560()
		{
			roleName ="COPY"+RandomStringGenerator.get(3);
			rolepage.selectCheckbox();
			rolepage.waitForPageToLoad();
			rolepage.copyRoleLocalAction();
			rolepage.maximizeCurrentWindow();
			rolepage.enterData_CopyRole(roleName);
			rolepage.localActionSave();
			rolepage.waitForPageToLoad();
			rolepage.verifyCopyRoleLocalAction(roleName);
			rolepage.selectRole(roleName);
			rolepage.waitForPageToLoad();
			rolepage.deleteRoleLocalAction(roleName);
			rolepage.acceptPopup();
			rolepage.waitForPageToLoad();
			rolepage.waitt();
			rolepage.verifyLocalActionDelete(roleName);
			rolepage.deleteMessage(roleName);
		}
		
		
		@Test(priority=33,description="Verify the functionality of Expand All button of Copy  popup")
	    public void Grid_4563()
	    {
			rolepage.selectCheckbox();
			rolepage.waitForPageToLoad();
			rolepage.copyRoleLocalAction();
			rolepage.maximizeCurrentWindow();
	    	rolepage.collapseAll();
	    	rolepage.waitForPageToLoad();
	    	rolepage.expandAll();
	    	rolepage.waitForPageToLoad();
	    	rolepage.verifyExpand_Detail();
	    	rolepage.cancelButton();
	    }
	  
	  @Test(priority=34,description="Verify the functionality of Collapse All button of Copy popup")
	    public void Grid_4564()
	    {
			rolepage.selectCheckbox();
			rolepage.waitForPageToLoad();
			rolepage.copyRoleLocalAction();
			rolepage.waitForPageToLoad();
			rolepage.maximizeCurrentWindow();
			rolepage.waitForPageToLoad();
			rolepage.collapseAll();
			rolepage.waitForPageToLoad();
			rolepage.verifyCollapse_Detail();
			rolepage.cancelButton();
		 }
	    
	    @Test(priority=35,description="Verify after clicking on sub-table header arrow it will expand/collapse information on Copy popup")
	    public void Grid_4565()
	    {
	    	rolepage.selectCheckbox();
	    	rolepage.waitForPageToLoad();
			rolepage.copyRoleLocalAction();
			rolepage.waitForPageToLoad();
			rolepage.maximizeCurrentWindow();
			rolepage.waitForPageToLoad();
	    	rolepage.sub_Table_Collapse();
	    	rolepage.waitForPageToLoad();
	    	rolepage.verifyCollapse_Detail();
	    	rolepage.sub_Table_Expand();
	    	rolepage.waitForPageToLoad();
	    	rolepage.verifyExpand_Detail();
	    	rolepage.cancelButton2();
		 }
	    
		
	    
	  @Test(priority=36 ,description="Verify the functionality of Enabled Permissions on Copy popup")
	    public void Grid_4608()
	    {
	    	roleName ="CopyRole"+RandomStringGenerator.get(3);
	    	rolepage.selectCheckbox();
	    	rolepage.waitForPageToLoad();
	    	rolepage.copyRoleLocalAction();
	    	rolepage.waitForPageToLoad();
	    	rolepage.maximizeCurrentWindow();
	    	rolepage.waitForPageToLoad();
			rolepage.enterData_CopyRole(roleName);
			rolepage.waitForPageToLoad();
			rolepage.enabledPermission();
			rolepage.saveButton();
			rolepage.waitForPageToLoad();
			rolepage.selectRole(roleName);
			rolepage.waitForPageToLoad();
			rolepage.viewEditRole();
			rolepage.waitForPageToLoad();
			rolepage.maximizeCurrentWindow();
			rolepage.waitForPageToLoad();
			rolepage.verifyEnabledPermission(roleName);
			rolepage.waitForPageToLoad();
			rolepage.cancelButton();
			rolepage.waitForPageToLoad();
			rolepage.selectRole(roleName);
			rolepage.waitForPageToLoad();
			rolepage.deleteRoleLocalAction(roleName);
			rolepage.acceptPopup();
			rolepage.waitForPageToLoad();
			rolepage.waitt();
			rolepage.verifyLocalActionDelete(roleName);
	   }
		
	    
	  @Test(priority=37,description="Verify the functionality of Copy Security Role on Copy popup")
	    public void Grid_4567()
	    {	
			roleName ="CopyRole"+RandomStringGenerator.get(3);
	    	rolepage.selectCheckbox();
	    	rolepage.waitForPageToLoad();
	    	rolepage.copyRoleLocalAction();
	    	rolepage.maximizeCurrentWindow();
	    	rolepage.verifyGlobalAction();
	    	rolepage.enterData_CopyRole(roleName);
	    	rolepage.copyRole();
	    	rolepage.saveButton();
	    	rolepage.waitForPageToLoad();
	    	rolepage.verifyCopySecurityRole(roleName);
			rolepage.selectRole(roleName);
			rolepage.waitForPageToLoad();
			rolepage.deleteRoleLocalAction(roleName);
			rolepage.acceptPopup();
			rolepage.waitForPageToLoad();
			rolepage.deleteMessage(roleName);
	       
		 }
		
	 @Test(priority=38,description="Verify functionality of checkboxes on Copy popup")
	    public void Grid_4568()
	    {
		  	roleName ="CopyRole"+RandomStringGenerator.get(3);
	    	rolepage.selectCheckbox();
	    	rolepage.waitForPageToLoad();
	    	rolepage.copyRoleLocalAction();
	    	rolepage.maximizeCurrentWindow();
	    	rolepage.verifyGlobalAction();
	    	rolepage.enterData_CopyRole(roleName);
	    	rolepage.selectCheckboxFunction();
	    	rolepage.saveButton();
	    	rolepage.waitForPageToLoad();
	    	rolepage.selectRole(roleName);
	    	rolepage.waitForPageToLoad();
	    	rolepage.viewEditRole();
			rolepage.maximizeCurrentWindow();
			rolepage.verifyCheckboxIsSelected();
			rolepage.cancelButton();
			rolepage.selectRole(roleName);
			rolepage.waitForPageToLoad();
			rolepage.deleteRoleLocalAction(roleName);
			rolepage.acceptPopup();
			rolepage.waitForPageToLoad();
			rolepage.deleteMessage(roleName);
			
			roleName ="CopyRole_"+RandomStringGenerator.get(3);
	    	rolepage.selectCheckbox();
	    	rolepage.waitForPageToLoad();
	    	rolepage.copyRoleLocalAction();
	    	rolepage.maximizeCurrentWindow();
	    	rolepage.verifyGlobalAction();
	    	rolepage.enterData_CopyRole(roleName);
	    	rolepage.deselectCheckboxFunction();
	    	rolepage.saveButton();
	    	rolepage.waitForPageToLoad();
	    	rolepage.selectRole(roleName);
	    	rolepage.waitForPageToLoad();
	    	rolepage.viewEditRole();
			rolepage.maximizeCurrentWindow();
			rolepage.verifyCheckboxIsDeselected();
			rolepage.cancelButton();
			rolepage.selectRole(roleName);
			rolepage.waitForPageToLoad();
			rolepage.deleteRoleLocalAction(roleName);
			rolepage.acceptPopup();
			rolepage.waitForPageToLoad();
			rolepage.deleteMessage(roleName);
	    }
		@Test(priority=39,description="Verify the functionality of Cancel button of Copy popup")
		public void Grid_4562()
		{
			roleName ="CANCELCOPY"+RandomStringGenerator.get(3);
			rolepage.selectCheckbox();
			rolepage.waitForPageToLoad();
			rolepage.copyRoleLocalAction();
			rolepage.maximizeCurrentWindow();
			rolepage.enterData_CopyRole(roleName);
			rolepage.cancelButton();
			rolepage.waitForPageToLoad();
			rolepage.verifyCancelCopyRoleLocalAction(roleName);
		}
	    	
	
		@Test(priority=40,description="Verify functionality of Delete local action")
		public void Grid_4569()
		{
			roleName ="DELETE"+RandomStringGenerator.get(3);
			rolepage.selectCheckbox();
			rolepage.waitForPageToLoad();
			rolepage.copyRoleLocalAction();
			rolepage.maximizeCurrentWindow();
			rolepage.enterData_CopyRole(roleName);
			rolepage.localActionSave();
			rolepage.waitForPageToLoad();
			rolepage.verifyRoleCreated(roleName);	
			rolepage.selectRole(roleName);
			rolepage.waitForPageToLoad();
			rolepage.deleteRoleLocalAction(roleName);
			rolepage.acceptPopup();
			rolepage.waitForPageToLoad();
			rolepage.waitt();
			rolepage.verifyLocalActionDelete(roleName);
			
		}
		
		
		
		@Test(priority=41,description="Verify the functionality of Cancel button of Delete popup")
		public void Grid_4571()
		{
			roleName ="CANCELDELETE"+RandomStringGenerator.get(3);
			rolepage.selectCheckbox();
			rolepage.waitForPageToLoad();
			rolepage.copyRoleLocalAction();
			rolepage.maximizeCurrentWindow();
			rolepage.enterData_CopyRole(roleName);
			rolepage.localActionSave();
			rolepage.waitForPageToLoad();
			rolepage.verifyRoleCreated(roleName);
			rolepage.selectRole(roleName);
			rolepage.waitForPageToLoad();
			rolepage.deleteRoleLocalAction(roleName);
			rolepage.dismissPopup();
			rolepage.waitForPageToLoad();
			rolepage.waitt();
			rolepage.verifyLocalActionDeleteCancelButton(roleName);
			rolepage.selectRole(roleName);
			rolepage.waitForPageToLoad();
			rolepage.deleteRoleLocalAction(roleName);
			rolepage.acceptPopup();
			rolepage.waitForPageToLoad();
			rolepage.waitt();
			rolepage.verifyLocalActionDelete(roleName);
			
		}	
	}



