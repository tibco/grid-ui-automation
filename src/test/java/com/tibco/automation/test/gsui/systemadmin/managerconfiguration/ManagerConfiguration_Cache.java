package com.tibco.automation.test.gsui.systemadmin.managerconfiguration;

import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import org.testng.annotations.Test;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.page.admin.systemadmin.ManagerConfiguration_Cache_Page;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.TemplatePage;

public class ManagerConfiguration_Cache extends WebDriverTestCase{

	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public TemplatePage templatepage;
	public ManagerConfiguration_Cache_Page managerConfig_CachePage;
	public String value;
	
	
	@Test(description="Verify the functionality of Expand All")
	public void Grid_4368()
	{
		managerConfig_CachePage=new ManagerConfiguration_Cache_Page();
		managerConfig_CachePage.launchPage();
		managerConfig_CachePage.waitForPageToLoad();
		managerConfig_CachePage.launchCachePage();
		managerConfig_CachePage.collapseAll();
		managerConfig_CachePage.expandAll();
	}
	
	@Test(description="Verify the functionality of Collapse All")
	public void Grid_4369()
	{
		managerConfig_CachePage=new ManagerConfiguration_Cache_Page();
		managerConfig_CachePage.launchPage();
		managerConfig_CachePage.waitForPageToLoad();
		managerConfig_CachePage.launchCachePage();
		managerConfig_CachePage.collapseAll();
	}
	
	@Test(description="Verify the functionality of Save")
	public void Grid_4370()
	{
		managerConfig_CachePage=new ManagerConfiguration_Cache_Page();
		managerConfig_CachePage.launchPage();
		managerConfig_CachePage.waitForPageToLoad();
		managerConfig_CachePage.launchCachePage();
		value="100";
		managerConfig_CachePage.passMemorySize(value);
		managerConfig_CachePage.clickSave();
		managerConfig_CachePage.waitForPageToLoad();
		managerConfig_CachePage.passMemorySize("0");
		managerConfig_CachePage.clickSave();
		managerConfig_CachePage.waitForPageToLoad();
		
	}
	
	@Test(description="Verify functionality of Cancel Button")
	public void Grid_4371()
	{
		managerConfig_CachePage=new ManagerConfiguration_Cache_Page();
		managerConfig_CachePage.launchPage();
		managerConfig_CachePage.waitForPageToLoad();
		managerConfig_CachePage.launchCachePage();
		value="200";
		managerConfig_CachePage.passMemorySize(value);
		managerConfig_CachePage.clickCancel();
		managerConfig_CachePage.verifyCancelledValue(value);
	}
	
	@Test(description="Verify after clicking on sub-table header it will expand and collapse information")
	public void Grid_4372()
	{
		managerConfig_CachePage=new ManagerConfiguration_Cache_Page();
		managerConfig_CachePage.launchPage();
		managerConfig_CachePage.waitForPageToLoad();
		managerConfig_CachePage.launchCachePage();
		managerConfig_CachePage.collapseHeader();
		managerConfig_CachePage.expandHeader();
	}
	
	@Test(description="Verify tooltip is provided for description")
	public void Grid_4373()
	{
		managerConfig_CachePage=new ManagerConfiguration_Cache_Page();
		managerConfig_CachePage.launchPage();
		managerConfig_CachePage.waitForPageToLoad();
		managerConfig_CachePage.launchCachePage();
		managerConfig_CachePage.verifyDescriptionTooltip();
	}
	
	@Test(description="Verify tooltip is provided for numeric values")
	public void Grid_4374()
	{
		managerConfig_CachePage=new ManagerConfiguration_Cache_Page();
		managerConfig_CachePage.launchPage();
		managerConfig_CachePage.waitForPageToLoad();
		managerConfig_CachePage.launchCachePage();
		managerConfig_CachePage.verifyNumericDataTooltip();
	}
}
