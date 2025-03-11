package com.tibco.automation.test.gsui.systemadmin.managerconfiguration;

import org.testng.annotations.Test;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import com.tibco.automation.page.admin.systemadmin.ManagerConfiguration_Services_Page;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.TemplatePage;

public class ManagerConfiguration_Services extends WebDriverTestCase{

	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public TemplatePage templatepage;
	public ManagerConfiguration_Services_Page managerConfig_ServicePage;
	public String caseSensitiveName;
	
	
	@Test(description="Verify the functionality of Expand All")
	public void Grid_4327()
	{
		managerConfig_ServicePage=new ManagerConfiguration_Services_Page();
		managerConfig_ServicePage.launchPage();
		managerConfig_ServicePage.waitForPageToLoad();
		managerConfig_ServicePage.launchServicesPage();
		managerConfig_ServicePage.collapseAll();
		managerConfig_ServicePage.expandAll();
	}
	
	@Test(description="Verify the functionality of Collapse All")
	public void Grid_4328()
	{
		managerConfig_ServicePage=new ManagerConfiguration_Services_Page();
		managerConfig_ServicePage.launchPage();
		managerConfig_ServicePage.waitForPageToLoad();
		managerConfig_ServicePage.launchServicesPage();
		managerConfig_ServicePage.collapseAll();
	}
	
	@Test(description="Verify the functionality of Save")
	public void Grid_4329()
	{
		managerConfig_ServicePage=new ManagerConfiguration_Services_Page();
		managerConfig_ServicePage.launchPage();
		managerConfig_ServicePage.waitForPageToLoad();
		managerConfig_ServicePage.launchServicesPage();
		caseSensitiveName="false";
		managerConfig_ServicePage.selectCaseSensitiveServiceName(caseSensitiveName);
		managerConfig_ServicePage.clickSave();
		managerConfig_ServicePage.verifySavedValue(caseSensitiveName);
		managerConfig_ServicePage.selectCaseSensitiveServiceName("true");
		managerConfig_ServicePage.clickSave();
		managerConfig_ServicePage.verifySavedValue("true");
	}
	
	@Test(description="Verify functionality of Cancel Button")
	public void Grid_4330()
	{
		managerConfig_ServicePage=new ManagerConfiguration_Services_Page();
		managerConfig_ServicePage.launchPage();
		managerConfig_ServicePage.waitForPageToLoad();
		managerConfig_ServicePage.launchServicesPage();
		caseSensitiveName="false";
		managerConfig_ServicePage.selectCaseSensitiveServiceName(caseSensitiveName);
		managerConfig_ServicePage.clickCancel();
		managerConfig_ServicePage.verifyCancelledValue(caseSensitiveName);
	}
	
	@Test(description="Verify after clicking on sub-table header it will expand and collapse information")
	public void Grid_4331()
	{
		managerConfig_ServicePage=new ManagerConfiguration_Services_Page();
		managerConfig_ServicePage.launchPage();
		managerConfig_ServicePage.waitForPageToLoad();
		managerConfig_ServicePage.launchServicesPage();
		managerConfig_ServicePage.collapseHeader();
		managerConfig_ServicePage.expandHeader();
	}
	
	@Test(description="Verify tooltip is provided for description")
	public void Grid_4332()
	{
		managerConfig_ServicePage=new ManagerConfiguration_Services_Page();
		managerConfig_ServicePage.launchPage();
		managerConfig_ServicePage.waitForPageToLoad();
		managerConfig_ServicePage.launchServicesPage();
		managerConfig_ServicePage.verifyDescriptionTooltip();
	}
	
	@Test(description="Verify tooltip is provided for numeric values")
	public void Grid_4333()
	{
		managerConfig_ServicePage=new ManagerConfiguration_Services_Page();
		managerConfig_ServicePage.launchPage();
		managerConfig_ServicePage.waitForPageToLoad();
		managerConfig_ServicePage.launchServicesPage();
		managerConfig_ServicePage.verifyNumericDataTooltip();
	}
}
