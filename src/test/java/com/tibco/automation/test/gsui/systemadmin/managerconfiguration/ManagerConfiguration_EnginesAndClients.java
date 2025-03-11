package com.tibco.automation.test.gsui.systemadmin.managerconfiguration;

import org.testng.annotations.Test;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import com.tibco.automation.page.admin.systemadmin.ManagerConfiguration_EnginesAndClients_Page;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.TemplatePage;

public class ManagerConfiguration_EnginesAndClients extends WebDriverTestCase{
	
	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public TemplatePage templatepage;
	public ManagerConfiguration_EnginesAndClients_Page managerConfig_EnginesAndClientsPage;
	public String value;
	
	
	@Test(description="Verify the functionality of Expand All")
	public void Grid_4335()
	{
		managerConfig_EnginesAndClientsPage=new ManagerConfiguration_EnginesAndClients_Page();
		managerConfig_EnginesAndClientsPage.launchPage();
		managerConfig_EnginesAndClientsPage.waitForPageToLoad();
		managerConfig_EnginesAndClientsPage.launchEnginesAndClientsPage();
		managerConfig_EnginesAndClientsPage.collapseAll();
		managerConfig_EnginesAndClientsPage.expandAll();
	}
	
	@Test(description="Verify the functionality of Collapse All")
	public void Grid_4336()
	{
		managerConfig_EnginesAndClientsPage=new ManagerConfiguration_EnginesAndClients_Page();
		managerConfig_EnginesAndClientsPage.launchPage();
		managerConfig_EnginesAndClientsPage.waitForPageToLoad();
		managerConfig_EnginesAndClientsPage.launchEnginesAndClientsPage();
		managerConfig_EnginesAndClientsPage.collapseAll();
	}
	
	@Test(description="Verify the functionality of Save")
	public void Grid_4337()
	{
		managerConfig_EnginesAndClientsPage=new ManagerConfiguration_EnginesAndClients_Page();
		managerConfig_EnginesAndClientsPage.launchPage();
		managerConfig_EnginesAndClientsPage.waitForPageToLoad();
		managerConfig_EnginesAndClientsPage.launchEnginesAndClientsPage();
		value="true";
		managerConfig_EnginesAndClientsPage.selectLoginWithExpiredPassword(value);
		managerConfig_EnginesAndClientsPage.clickSave();
		managerConfig_EnginesAndClientsPage.verifySavedValue(value);
		managerConfig_EnginesAndClientsPage.selectLoginWithExpiredPassword("false");
		managerConfig_EnginesAndClientsPage.clickSave();
		managerConfig_EnginesAndClientsPage.verifySavedValue("false");
	}
	
	@Test(description="Verify functionality of Cancel Button")
	public void Grid_4338()
	{
		managerConfig_EnginesAndClientsPage=new ManagerConfiguration_EnginesAndClients_Page();
		managerConfig_EnginesAndClientsPage.launchPage();
		managerConfig_EnginesAndClientsPage.waitForPageToLoad();
		managerConfig_EnginesAndClientsPage.launchEnginesAndClientsPage();
		value="true";
		managerConfig_EnginesAndClientsPage.selectLoginWithExpiredPassword(value);
		managerConfig_EnginesAndClientsPage.clickCancel();
		managerConfig_EnginesAndClientsPage.verifyCancelledValue(value);
	}
	
	@Test(description="Verify after clicking on sub-table header it will expand and collapse information")
	public void Grid_4339()
	{
		managerConfig_EnginesAndClientsPage=new ManagerConfiguration_EnginesAndClients_Page();
		managerConfig_EnginesAndClientsPage.launchPage();
		managerConfig_EnginesAndClientsPage.waitForPageToLoad();
		managerConfig_EnginesAndClientsPage.launchEnginesAndClientsPage();
		managerConfig_EnginesAndClientsPage.collapseHeader();
		managerConfig_EnginesAndClientsPage.expandHeader();
	}
	
	@Test(description="Verify tooltip is provided for description")
	public void Grid_4343()
	{
		managerConfig_EnginesAndClientsPage=new ManagerConfiguration_EnginesAndClients_Page();
		managerConfig_EnginesAndClientsPage.launchPage();
		managerConfig_EnginesAndClientsPage.waitForPageToLoad();
		managerConfig_EnginesAndClientsPage.launchEnginesAndClientsPage();
		managerConfig_EnginesAndClientsPage.verifyDescriptionTooltip();
	}
	
	@Test(description="Verify tooltip is provided for numeric values")
	public void Grid_4341()
	{
		managerConfig_EnginesAndClientsPage=new ManagerConfiguration_EnginesAndClients_Page();
		managerConfig_EnginesAndClientsPage.launchPage();
		managerConfig_EnginesAndClientsPage.waitForPageToLoad();
		managerConfig_EnginesAndClientsPage.launchEnginesAndClientsPage();
		managerConfig_EnginesAndClientsPage.verifyNumericDataTooltip();
	}
}
