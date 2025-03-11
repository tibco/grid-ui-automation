package com.tibco.automation.test.gsui.systemadmin.managerconfiguration;

import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import org.testng.annotations.Test;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.page.admin.systemadmin.ManagerConfiguration_Database_Page;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.TemplatePage;

public class ManagerConfiguration_Database extends WebDriverTestCase{

	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public TemplatePage templatepage;
	public ManagerConfiguration_Database_Page managerConfig_DatabasePage;
	public String value;
	
	
	@Test(description="Verify the functionality of Expand All")
	public void Grid_4352()
	{
		managerConfig_DatabasePage=new ManagerConfiguration_Database_Page();
		managerConfig_DatabasePage.launchPage();
		managerConfig_DatabasePage.waitForPageToLoad();
		managerConfig_DatabasePage.launchDatabasePage();
		managerConfig_DatabasePage.collapseAll();
		managerConfig_DatabasePage.expandAll();
	}
	
	@Test(description="Verify the functionality of Collapse All")
	public void Grid_4353()
	{
		managerConfig_DatabasePage=new ManagerConfiguration_Database_Page();
		managerConfig_DatabasePage.launchPage();
		managerConfig_DatabasePage.waitForPageToLoad();
		managerConfig_DatabasePage.launchDatabasePage();
		managerConfig_DatabasePage.collapseAll();
	}
	
	@Test(description="Verify the functionality of Save")
	public void Grid_4354()
	{
		managerConfig_DatabasePage=new ManagerConfiguration_Database_Page();
		managerConfig_DatabasePage.launchPage();
		managerConfig_DatabasePage.waitForPageToLoad();
		managerConfig_DatabasePage.launchDatabasePage();
		value="true";
		managerConfig_DatabasePage.selectConnectionSuspended(value);
		managerConfig_DatabasePage.clickSave();
		managerConfig_DatabasePage.verifySavedValue(value);
		managerConfig_DatabasePage.selectConnectionSuspended("false");
		managerConfig_DatabasePage.clickSave();
		managerConfig_DatabasePage.verifySavedValue("false");
	}
	
	@Test(description="Verify functionality of Cancel Button")
	public void Grid_4355()
	{
		managerConfig_DatabasePage=new ManagerConfiguration_Database_Page();
		managerConfig_DatabasePage.launchPage();
		managerConfig_DatabasePage.waitForPageToLoad();
		managerConfig_DatabasePage.launchDatabasePage();
		value="true";
		managerConfig_DatabasePage.selectConnectionSuspended(value);
		managerConfig_DatabasePage.clickCancel();
		managerConfig_DatabasePage.verifyCancelledValue(value);
	}
	
	@Test(description="Verify after clicking on sub-table header it will expand and collapse information")
	public void Grid_4356()
	{
		managerConfig_DatabasePage=new ManagerConfiguration_Database_Page();
		managerConfig_DatabasePage.launchPage();
		managerConfig_DatabasePage.waitForPageToLoad();
		managerConfig_DatabasePage.launchDatabasePage();
		managerConfig_DatabasePage.collapseHeader();
		managerConfig_DatabasePage.expandHeader();
	}
	
	@Test(description="Verify tooltip is provided for description")
	public void Grid_4357()
	{
		managerConfig_DatabasePage=new ManagerConfiguration_Database_Page();
		managerConfig_DatabasePage.launchPage();
		managerConfig_DatabasePage.waitForPageToLoad();
		managerConfig_DatabasePage.launchDatabasePage();
		managerConfig_DatabasePage.verifyDescriptionTooltip();
	}
	
	@Test(description="Verify tooltip is provided for numeric values")
	public void Grid_4358()
	{
		managerConfig_DatabasePage=new ManagerConfiguration_Database_Page();
		managerConfig_DatabasePage.launchPage();
		managerConfig_DatabasePage.waitForPageToLoad();
		managerConfig_DatabasePage.launchDatabasePage();
		managerConfig_DatabasePage.verifyNumericDataTooltip();
	}
}
