package com.tibco.automation.test.gsui.systemadmin.managerconfiguration;

import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import org.testng.annotations.Test;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.page.admin.systemadmin.ManagerConfiguration_Admin_Page;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.TemplatePage;
public class ManagerConfiguration_Admin extends WebDriverTestCase{
	
	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public TemplatePage templatepage;
	public ManagerConfiguration_Admin_Page managerConfig_AdminPage;
	public String value;
	
	
	@Test(description="Verify the functionality of Expand All")
	public void Grid_4344()
	{
		managerConfig_AdminPage=new ManagerConfiguration_Admin_Page();
		managerConfig_AdminPage.launchPage();
		managerConfig_AdminPage.waitForPageToLoad();
		managerConfig_AdminPage.launchAdminPage();
		managerConfig_AdminPage.collapseAll();
		managerConfig_AdminPage.expandAll();
	}
	
	@Test(description="Verify the functionality of Collapse All")
	public void Grid_4345()
	{
		managerConfig_AdminPage=new ManagerConfiguration_Admin_Page();
		managerConfig_AdminPage.launchPage();
		managerConfig_AdminPage.waitForPageToLoad();
		managerConfig_AdminPage.launchAdminPage();
		managerConfig_AdminPage.collapseAll();
	}
	
	@Test(description="Verify the functionality of Save")
	public void Grid_4346()
	{
		managerConfig_AdminPage=new ManagerConfiguration_Admin_Page();
		managerConfig_AdminPage.launchPage();
		managerConfig_AdminPage.waitForPageToLoad();
		managerConfig_AdminPage.launchAdminPage();
		value="true";
		managerConfig_AdminPage.selectHostnameForEngineLogURL(value);
		managerConfig_AdminPage.clickSave();
		managerConfig_AdminPage.verifySavedValue(value);
		managerConfig_AdminPage.selectHostnameForEngineLogURL("false");
		managerConfig_AdminPage.clickSave();
		managerConfig_AdminPage.verifySavedValue("false");
	}
	
	@Test(description="Verify functionality of Cancel Button")
	public void Grid_4347()
	{
		managerConfig_AdminPage=new ManagerConfiguration_Admin_Page();
		managerConfig_AdminPage.launchPage();
		managerConfig_AdminPage.waitForPageToLoad();
		managerConfig_AdminPage.launchAdminPage();
		value="true";
		managerConfig_AdminPage.selectHostnameForEngineLogURL(value);
		managerConfig_AdminPage.clickCancel();
		managerConfig_AdminPage.verifyCancelledValue(value);
	}
	
	@Test(description="Verify after clicking on sub-table header it will expand and collapse information")
	public void Grid_4348()
	{
		managerConfig_AdminPage=new ManagerConfiguration_Admin_Page();
		managerConfig_AdminPage.launchPage();
		managerConfig_AdminPage.waitForPageToLoad();
		managerConfig_AdminPage.launchAdminPage();
		managerConfig_AdminPage.collapseHeader();
		managerConfig_AdminPage.expandHeader();
	}
	
	@Test(description="Verify tooltip is provided for description")
	public void Grid_4349()
	{
		managerConfig_AdminPage=new ManagerConfiguration_Admin_Page();
		managerConfig_AdminPage.launchPage();
		managerConfig_AdminPage.waitForPageToLoad();
		managerConfig_AdminPage.launchAdminPage();
		managerConfig_AdminPage.verifyDescriptionTooltip();
	}
	
	@Test(description="Verify tooltip is provided for numeric values")
	public void Grid_4350()
	{
		managerConfig_AdminPage=new ManagerConfiguration_Admin_Page();
		managerConfig_AdminPage.launchPage();
		managerConfig_AdminPage.waitForPageToLoad();
		managerConfig_AdminPage.launchAdminPage();
		managerConfig_AdminPage.verifyNumericDataTooltip();
	}

}
