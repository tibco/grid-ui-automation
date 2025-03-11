package com.tibco.automation.test.gsui.systemadmin.managerconfiguration;

import org.testng.annotations.Test;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import com.tibco.automation.page.admin.systemadmin.ManagerConfiguration_Communication_Page;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.TemplatePage;

public class ManagerConfiguration_Communication extends WebDriverTestCase{

	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public TemplatePage templatepage;
	public ManagerConfiguration_Communication_Page managerConfig_CommunicationPage;
	public String value;
	
	
	@Test(description="Verify the functionality of Expand All")
	public void Grid_4384()
	{
		managerConfig_CommunicationPage=new ManagerConfiguration_Communication_Page();
		managerConfig_CommunicationPage.launchPage();
		managerConfig_CommunicationPage.waitForPageToLoad();
		managerConfig_CommunicationPage.launchCommunicationPage();
		managerConfig_CommunicationPage.collapseAll();
		managerConfig_CommunicationPage.expandAll();
	}
	
	@Test(description="Verify the functionality of Collapse All")
	public void Grid_4385()
	{
		managerConfig_CommunicationPage=new ManagerConfiguration_Communication_Page();
		managerConfig_CommunicationPage.launchPage();
		managerConfig_CommunicationPage.waitForPageToLoad();
		managerConfig_CommunicationPage.launchCommunicationPage();
		managerConfig_CommunicationPage.collapseAll();
	}
	
	@Test(description="Verify the functionality of Save")
	public void Grid_4386()
	{
		managerConfig_CommunicationPage=new ManagerConfiguration_Communication_Page();
		managerConfig_CommunicationPage.launchPage();
		managerConfig_CommunicationPage.waitForPageToLoad();
		managerConfig_CommunicationPage.launchCommunicationPage();
		value="false";
		managerConfig_CommunicationPage.selectTranslateInsideRange(value);
		managerConfig_CommunicationPage.clickSave();
		managerConfig_CommunicationPage.verifySavedValue(value);
		managerConfig_CommunicationPage.selectTranslateInsideRange("true");
		managerConfig_CommunicationPage.clickSave();
		managerConfig_CommunicationPage.verifySavedValue("true");
	}
	
	@Test(description="Verify functionality of Cancel Button")
	public void Grid_4387()
	{
		managerConfig_CommunicationPage=new ManagerConfiguration_Communication_Page();
		managerConfig_CommunicationPage.launchPage();
		managerConfig_CommunicationPage.waitForPageToLoad();
		managerConfig_CommunicationPage.launchCommunicationPage();
		value="false";
		managerConfig_CommunicationPage.selectTranslateInsideRange(value);
		managerConfig_CommunicationPage.clickCancel();
		managerConfig_CommunicationPage.verifyCancelledValue(value);
	}
	
	@Test(description="Verify after clicking on sub-table header it will expand and collapse information")
	public void Grid_4388()
	{
		managerConfig_CommunicationPage=new ManagerConfiguration_Communication_Page();
		managerConfig_CommunicationPage.launchPage();
		managerConfig_CommunicationPage.waitForPageToLoad();
		managerConfig_CommunicationPage.launchCommunicationPage();
		managerConfig_CommunicationPage.collapseHeader();
		managerConfig_CommunicationPage.expandHeader();
	}
	
	@Test(description="Verify tooltip is provided for description")
	public void Grid_4389()
	{
		managerConfig_CommunicationPage=new ManagerConfiguration_Communication_Page();
		managerConfig_CommunicationPage.launchPage();
		managerConfig_CommunicationPage.waitForPageToLoad();
		managerConfig_CommunicationPage.launchCommunicationPage();
		managerConfig_CommunicationPage.verifyDescriptionTooltip();
	}
	
	@Test(description="Verify tooltip is provided for numeric values")
	public void Grid_4390()
	{
		managerConfig_CommunicationPage=new ManagerConfiguration_Communication_Page();
		managerConfig_CommunicationPage.launchPage();
		managerConfig_CommunicationPage.waitForPageToLoad();
		managerConfig_CommunicationPage.launchCommunicationPage();
		managerConfig_CommunicationPage.verifyNumericDataTooltip();
	}
	
}
