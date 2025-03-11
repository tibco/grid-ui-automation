package com.tibco.automation.test.gsui.systemadmin.managerconfiguration;

import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;

import org.testng.annotations.Test;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.page.admin.systemadmin.ManagerConfiguration_Security_Page;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.TemplatePage;

public class ManagerConfiguration_Security extends WebDriverTestCase{

	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public TemplatePage templatepage;
	public ManagerConfiguration_Security_Page managerConfig_SecurityPage;
	public String value;
	
	
	@Test(description="Verify the functionality of Expand All")
	public void Grid_4376()
	{
		managerConfig_SecurityPage=new ManagerConfiguration_Security_Page();
		managerConfig_SecurityPage.launchPage();
		managerConfig_SecurityPage.waitForPageToLoad();
		managerConfig_SecurityPage.launchSecurityPage();
		managerConfig_SecurityPage.collapseAll();
		managerConfig_SecurityPage.expandAll();
	}
	
	@Test(description="Verify the functionality of Collapse All")
	public void Grid_4377()
	{
		managerConfig_SecurityPage=new ManagerConfiguration_Security_Page();
		managerConfig_SecurityPage.launchPage();
		managerConfig_SecurityPage.waitForPageToLoad();
		managerConfig_SecurityPage.launchSecurityPage();
		managerConfig_SecurityPage.collapseAll();
	}
	
	@Test(description="Verify the functionality of Save")
	public void Grid_4378()
	{
		managerConfig_SecurityPage=new ManagerConfiguration_Security_Page();
		managerConfig_SecurityPage.launchPage();
		managerConfig_SecurityPage.waitForPageToLoad();
		managerConfig_SecurityPage.launchSecurityPage();
		value="true";
		managerConfig_SecurityPage.selectGridSingleSignOn(value);
		managerConfig_SecurityPage.clickSave();
		managerConfig_SecurityPage.verifySavedValue(value);
		managerConfig_SecurityPage.selectGridSingleSignOn("false");
		managerConfig_SecurityPage.clickSave();
		managerConfig_SecurityPage.verifySavedValue("false");
	}
	
	@Test(description="Verify functionality of Cancel Button")
	public void Grid_4379()
	{
		managerConfig_SecurityPage=new ManagerConfiguration_Security_Page();
		managerConfig_SecurityPage.launchPage();
		managerConfig_SecurityPage.waitForPageToLoad();
		managerConfig_SecurityPage.launchSecurityPage();
		value="true";
		managerConfig_SecurityPage.selectGridSingleSignOn(value);
		managerConfig_SecurityPage.clickCancel();
		managerConfig_SecurityPage.verifyCancelledValue(value);
	}
	
	@Test(description="Verify after clicking on sub-table header it will expand and collapse information")
	public void Grid_4380()
	{
		managerConfig_SecurityPage=new ManagerConfiguration_Security_Page();
		managerConfig_SecurityPage.launchPage();
		managerConfig_SecurityPage.waitForPageToLoad();
		managerConfig_SecurityPage.launchSecurityPage();
		managerConfig_SecurityPage.collapseHeader();
		managerConfig_SecurityPage.expandHeader();
	}
	
	@Test(description="Verify tooltip is provided for description")
	public void Grid_4381()
	{
		managerConfig_SecurityPage=new ManagerConfiguration_Security_Page();
		managerConfig_SecurityPage.launchPage();
		managerConfig_SecurityPage.waitForPageToLoad();
		managerConfig_SecurityPage.launchSecurityPage();
		managerConfig_SecurityPage.verifyDescriptionTooltip();
	}
	
	@Test(description="Verify tooltip is provided for numeric values")
	public void Grid_4382()
	{
		managerConfig_SecurityPage=new ManagerConfiguration_Security_Page();
		managerConfig_SecurityPage.launchPage();
		managerConfig_SecurityPage.waitForPageToLoad();
		managerConfig_SecurityPage.launchSecurityPage();
		managerConfig_SecurityPage.verifyNumericDataTooltip();
	}
	
}
