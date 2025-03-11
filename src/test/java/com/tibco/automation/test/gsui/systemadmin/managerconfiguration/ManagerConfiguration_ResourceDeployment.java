package com.tibco.automation.test.gsui.systemadmin.managerconfiguration;

import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import org.testng.annotations.Test;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.page.admin.systemadmin.ManagerConfiguration_ResourceDeployment_Page;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.TemplatePage;

public class ManagerConfiguration_ResourceDeployment extends WebDriverTestCase{

	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public TemplatePage templatepage;
	public ManagerConfiguration_ResourceDeployment_Page managerConfig_ResourceDeploymentPage;
	public String value;
	
	
	@Test(description="Verify the functionality of Expand All")
	public void Grid_4360()
	{
		managerConfig_ResourceDeploymentPage=new ManagerConfiguration_ResourceDeployment_Page();
		managerConfig_ResourceDeploymentPage.launchPage();
		managerConfig_ResourceDeploymentPage.waitForPageToLoad();
		managerConfig_ResourceDeploymentPage.launchResourceDeploymentPage();
		managerConfig_ResourceDeploymentPage.collapseAll();
		managerConfig_ResourceDeploymentPage.expandAll();
	}
	
	@Test(description="Verify the functionality of Collapse All")
	public void Grid_4361()
	{
		managerConfig_ResourceDeploymentPage=new ManagerConfiguration_ResourceDeployment_Page();
		managerConfig_ResourceDeploymentPage.launchPage();
		managerConfig_ResourceDeploymentPage.waitForPageToLoad();
		managerConfig_ResourceDeploymentPage.launchResourceDeploymentPage();
		managerConfig_ResourceDeploymentPage.collapseAll();
	}
	
	@Test(description="Verify the functionality of Save")
	public void Grid_4362()
	{
		managerConfig_ResourceDeploymentPage=new ManagerConfiguration_ResourceDeployment_Page();
		managerConfig_ResourceDeploymentPage.launchPage();
		managerConfig_ResourceDeploymentPage.waitForPageToLoad();
		managerConfig_ResourceDeploymentPage.launchResourceDeploymentPage();
		value="true";
		managerConfig_ResourceDeploymentPage.selectConnectionSuspended(value);
		managerConfig_ResourceDeploymentPage.clickSave();
		managerConfig_ResourceDeploymentPage.verifySavedValue(value);
		managerConfig_ResourceDeploymentPage.selectConnectionSuspended("false");
		managerConfig_ResourceDeploymentPage.clickSave();
		managerConfig_ResourceDeploymentPage.verifySavedValue("false");
	}
	
	@Test(description="Verify functionality of Cancel Button")
	public void Grid_4363()
	{
		managerConfig_ResourceDeploymentPage=new ManagerConfiguration_ResourceDeployment_Page();
		managerConfig_ResourceDeploymentPage.launchPage();
		managerConfig_ResourceDeploymentPage.waitForPageToLoad();
		managerConfig_ResourceDeploymentPage.launchResourceDeploymentPage();
		value="true";
		managerConfig_ResourceDeploymentPage.selectConnectionSuspended(value);
		managerConfig_ResourceDeploymentPage.clickCancel();
		managerConfig_ResourceDeploymentPage.verifyCancelledValue(value);
	}
	
	@Test(description="Verify after clicking on sub-table header it will expand and collapse information")
	public void Grid_4364()
	{
		managerConfig_ResourceDeploymentPage=new ManagerConfiguration_ResourceDeployment_Page();
		managerConfig_ResourceDeploymentPage.launchPage();
		managerConfig_ResourceDeploymentPage.waitForPageToLoad();
		managerConfig_ResourceDeploymentPage.launchResourceDeploymentPage();
		managerConfig_ResourceDeploymentPage.collapseHeader();
		managerConfig_ResourceDeploymentPage.expandHeader();
	}
	
	@Test(description="Verify tooltip is provided for description")
	public void Grid_4365()
	{
		managerConfig_ResourceDeploymentPage=new ManagerConfiguration_ResourceDeployment_Page();
		managerConfig_ResourceDeploymentPage.launchPage();
		managerConfig_ResourceDeploymentPage.waitForPageToLoad();
		managerConfig_ResourceDeploymentPage.launchResourceDeploymentPage();
		managerConfig_ResourceDeploymentPage.verifyDescriptionTooltip();
	}
	
	@Test(description="Verify tooltip is provided for numeric values")
	public void Grid_4366()
	{
		managerConfig_ResourceDeploymentPage=new ManagerConfiguration_ResourceDeployment_Page();
		managerConfig_ResourceDeploymentPage.launchPage();
		managerConfig_ResourceDeploymentPage.waitForPageToLoad();
		managerConfig_ResourceDeploymentPage.launchResourceDeploymentPage();
		managerConfig_ResourceDeploymentPage.verifyNumericDataTooltip();
	}
}
