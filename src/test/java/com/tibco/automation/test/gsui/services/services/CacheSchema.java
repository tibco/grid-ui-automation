package com.tibco.automation.test.gsui.services.services;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import com.tibco.automation.common.utils.RandomStringGenerator;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.services.services.CacheSchemaPage;
import org.testng.annotations.Test;


import com.tibco.automation.page.admin.useradmin.RolePage;



public class CacheSchema  extends WebDriverTestCase {
	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public TemplatePage templatepage;
	public CacheSchemaPage cacheschema;
	public String schemaName=null;
	public RolePage rolepage; 
	
	
	@BeforeMethod
	public void beforeTest()
	{	
		rolepage=new RolePage();
		cacheschema=new CacheSchemaPage();
		cacheschema.launchPage();
		cacheschema.waitForPageToLoad();
	}

	@Test(priority=1,description="Verify the functionality of Add button on Cache schemas page")
	public void Grid_4115()
	{ 
		schemaName ="Schema"+RandomStringGenerator.get(3);
		cacheschema.addButton(schemaName);
		rolepage.maximizeCurrentWindow();
		cacheschema.clickSaveButton();
		rolepage.switchToParentWindow();
		cacheschema.verifyAddButton(schemaName);
		rolepage.switchToParentWindow();
		cacheschema.log(schemaName);
		cacheschema.removeSchema(schemaName);
		rolepage.acceptPopup();
		cacheschema.waitForPageToLoad();
		rolepage.switchToParentWindow();
		cacheschema.verifyRemoveSchema(schemaName);
	}
	@Test(priority=2,description="Verify the functionality of Cancel button on Cache schemas page")
	public void Grid_4119()
	{
		schemaName ="Schema"+RandomStringGenerator.get(3);
		cacheschema.addButton(schemaName);
		rolepage.maximizeCurrentWindow();
		cacheschema.clickCancelButton();
		rolepage.switchToParentWindow();
		cacheschema.verifyCancelButton(schemaName);
	}
	@Test(priority=3,description="Verify tooltip is provided for Value and Description on cache schemas popup")
	public void Grid_4121()
	{
		schemaName ="Schema"+RandomStringGenerator.get(3);
		cacheschema.addButton(schemaName);
		rolepage.maximizeCurrentWindow();
		cacheschema.verifyDescriptionTooltip();
		cacheschema.clickCancelButton();
		rolepage.switchToParentWindow();
	}
	@Test(priority=4,description="Verify functionality of Edit Schema local action")
	public void Grid_4122()
	{
		schemaName ="SchemaX"+RandomStringGenerator.get(3);
		cacheschema.addButton(schemaName);
		rolepage.maximizeCurrentWindow();
		cacheschema.clickSaveButton();
		rolepage.switchToParentWindow();
		cacheschema.verifyAddButton(schemaName);
		cacheschema.editSchema(schemaName);
		rolepage.maximizeCurrentWindow();
		cacheschema.enterData_EditSchema();
		cacheschema.clickSaveButton();
		
		rolepage.switchToParentWindow();
		cacheschema.editSchema(schemaName);
		rolepage.maximizeCurrentWindow();
		cacheschema.verifyEditSchema(schemaName);
		cacheschema.clickCancelButton();
		rolepage.switchToParentWindow();
		cacheschema.log(schemaName);
		cacheschema.removeSchema(schemaName);
		rolepage.acceptPopup();
		cacheschema.waitForPageToLoad();
		rolepage.switchToParentWindow();
		cacheschema.verifyRemoveSchema(schemaName);
	}	
	@Test(priority=5,description="Verify functionality of cancel button of Edit Schema popup")
	public void Grid_4684()
	{
		schemaName ="SchemaX"+RandomStringGenerator.get(3);
		cacheschema.addButton(schemaName);
		rolepage.maximizeCurrentWindow();
		cacheschema.clickSaveButton();
		
		rolepage.switchToParentWindow();
		cacheschema.verifyAddButton(schemaName);
		cacheschema.editSchema(schemaName);
		rolepage.maximizeCurrentWindow();
		cacheschema.enterData_EditSchema();
		cacheschema.clickCancelButton();
		rolepage.switchToParentWindow();
		cacheschema.editSchema(schemaName);
		rolepage.maximizeCurrentWindow();
		cacheschema.verifyEditCancelSchema(schemaName);
		cacheschema.clickCancelButton();
		rolepage.switchToParentWindow();
		cacheschema.log(schemaName);
		cacheschema.removeSchema(schemaName);
		rolepage.acceptPopup();
		cacheschema.waitForPageToLoad();
		rolepage.switchToParentWindow();
		cacheschema.verifyRemoveSchema(schemaName);
	}
	
	@Test(priority=6,description="Verify functionality of Remove Schema local action")
	public void Grid_4125()
	{
		schemaName ="RemoveSchemaX"+RandomStringGenerator.get(3);
		cacheschema.addButton(schemaName);
		rolepage.maximizeCurrentWindow();
		cacheschema.clickSaveButton();
		
		rolepage.switchToParentWindow();
		cacheschema.verifyAddButton(schemaName);
		cacheschema.removeSchema(schemaName);
		rolepage.acceptPopup();
		cacheschema.waitForPageToLoad();
		rolepage.switchToParentWindow();
		cacheschema.verifyRemoveSchema(schemaName);
	}		

	@Test(priority=7,description="Verify functionality of cancel button of \"Remove Schema\" popup")
	public void Grid_4686
	()
	{
		schemaName ="RemoveSchemaX"+RandomStringGenerator.get(3);
		cacheschema.addButton(schemaName);
		rolepage.maximizeCurrentWindow();
		cacheschema.clickSaveButton();
		
		rolepage.switchToParentWindow();
		cacheschema.verifyAddButton(schemaName);
		cacheschema.removeSchema(schemaName);
		rolepage.dismissPopup();
		rolepage.switchToParentWindow();
		cacheschema.verifyRemoveCancelSchema(schemaName);
		cacheschema.log(schemaName);
		cacheschema.removeSchema(schemaName);
		rolepage.acceptPopup();
		cacheschema.waitForPageToLoad();
		rolepage.switchToParentWindow();
		cacheschema.verifyRemoveSchema(schemaName);
	}
	@Test(priority=8,description="Verify functionality of Copy Schema local action")
	public void Grid_4126()
	{
		schemaName ="CopySchema"+RandomStringGenerator.get(3);
		cacheschema.copySchema();
		cacheschema.enterData(schemaName);
		cacheschema.clickPopupSaveButton();
		cacheschema.verifyCopySchema(schemaName);
		cacheschema.log(schemaName);
		cacheschema.removeSchema(schemaName);
		rolepage.acceptPopup();
		cacheschema.waitForPageToLoad();
		//rolepage.switchToParentWindow();
		cacheschema.verifyRemoveSchema(schemaName);
		
	}
	@Test(priority=9,description="Verify functionality of cancel button of Copy Schema popup")
	public void Grid_4683()
	{
		schemaName ="CopySchema"+RandomStringGenerator.get(3);
		cacheschema.copySchema();
		cacheschema.enterData(schemaName);
		cacheschema.clickPopupCancelButton();
		cacheschema.verifyCancelCopySchema(schemaName);
	}
	@Test(priority=10,description="Verify functionality of Rename Schema local action")
	public void Grid_4123()
	{
		schemaName ="Schema"+RandomStringGenerator.get(3);
		cacheschema.addButton(schemaName);
		rolepage.maximizeCurrentWindow();
		cacheschema.clickSaveButton();
		
		rolepage.switchToParentWindow();
		cacheschema.verifyAddButton(schemaName);
		cacheschema.renameSchema(schemaName);
		schemaName ="RenameSchema"+RandomStringGenerator.get(3);
		cacheschema.enterData(schemaName);
		cacheschema.clickPopupSaveButton();
		
		cacheschema.verifyRenameSchema(schemaName);
		cacheschema.log(schemaName);
		cacheschema.removeSchema(schemaName);
		rolepage.acceptPopup();
		cacheschema.waitForPageToLoad();
		rolepage.switchToParentWindow();
		cacheschema.verifyRemoveSchema(schemaName);
	}
	@Test(priority=11,description="Verify functionality of cancel button of Rename Schema popup")
	public void Grid_4685()
	{
		schemaName ="RenameSchema"+RandomStringGenerator.get(3);
		cacheschema.renameSchema();
		cacheschema.enterData(schemaName);
		cacheschema.clickPopupCancelButton();
		cacheschema.verifyCancelRenameSchema(schemaName);
	}
		
		
}
