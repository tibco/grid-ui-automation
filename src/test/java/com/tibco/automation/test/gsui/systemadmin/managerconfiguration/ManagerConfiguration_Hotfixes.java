package com.tibco.automation.test.gsui.systemadmin.managerconfiguration;

import org.testng.annotations.Test;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import com.tibco.automation.page.admin.systemadmin.ManagerConfiguration_Hotfixes_Page;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.TemplatePage;

public class ManagerConfiguration_Hotfixes extends WebDriverTestCase{

	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public TemplatePage templatepage;
	public ManagerConfiguration_Hotfixes_Page managerConfig_Hotfixes;
	
	@Test(description="Verify the functionality of Expand All")
	public void Grid_4396()
	{
		managerConfig_Hotfixes=new ManagerConfiguration_Hotfixes_Page();
		managerConfig_Hotfixes.launchPage();
		managerConfig_Hotfixes.waitForPageToLoad();
		managerConfig_Hotfixes.launchHotfixesPage();
		managerConfig_Hotfixes.collapseAll();
		managerConfig_Hotfixes.expandAll();
	}
	
	@Test(description="Verify the functionality of Collapse All")
	public void Grid_4392()
	{
		managerConfig_Hotfixes=new ManagerConfiguration_Hotfixes_Page();
		managerConfig_Hotfixes.launchPage();
		managerConfig_Hotfixes.waitForPageToLoad();
		managerConfig_Hotfixes.launchHotfixesPage();
		managerConfig_Hotfixes.collapseAll();
	}
}
