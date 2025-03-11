package com.tibco.automation.test.gsui.systemadmin.managerconfiguration;

import org.testng.annotations.Test;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import com.tibco.automation.page.admin.systemadmin.ManagerConfiguration_Logging_Page;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.TemplatePage;

public class ManagerConfiguration_Logging extends WebDriverTestCase{
	
	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public TemplatePage templatepage;
	public ManagerConfiguration_Logging_Page managerConfig_LoggingPage;
	public String customLogLevel;
	
	
	@Test(description="Verify the functionality of Expand All")
	public void Grid_4326()
	{
		managerConfig_LoggingPage=new ManagerConfiguration_Logging_Page();
		managerConfig_LoggingPage.launchPage();
		managerConfig_LoggingPage.launchLoggingPage();
		managerConfig_LoggingPage.collapseAll();
		managerConfig_LoggingPage.expandAll();
	}
	
	@Test(description="Verify the functionality of Collapse All")
	public void Grid_4320()
	{
		managerConfig_LoggingPage=new ManagerConfiguration_Logging_Page();
		managerConfig_LoggingPage.launchPage();
		managerConfig_LoggingPage.launchLoggingPage();
		managerConfig_LoggingPage.collapseAll();
	}
	
	@Test(description="Verify the functionality of Save")
	public void Grid_4321()
	{
		managerConfig_LoggingPage=new ManagerConfiguration_Logging_Page();
		managerConfig_LoggingPage.launchPage();
		managerConfig_LoggingPage.launchLoggingPage();
		customLogLevel="FINE";
		managerConfig_LoggingPage.selectDefaultDebugLevel(customLogLevel);
		managerConfig_LoggingPage.clickSave();
		managerConfig_LoggingPage.verifySavedDefaultDebugLevel(customLogLevel);
		managerConfig_LoggingPage.selectDefaultDebugLevel("INFO");
		managerConfig_LoggingPage.clickSave();
		managerConfig_LoggingPage.verifySavedDefaultDebugLevel("INFO");
	}
	
	@Test(description="Verify functionality of Cancel Button")
	public void Grid_4342()
	{
		managerConfig_LoggingPage=new ManagerConfiguration_Logging_Page();
		managerConfig_LoggingPage.launchPage();
		managerConfig_LoggingPage.launchLoggingPage();
		customLogLevel="FINER";
		managerConfig_LoggingPage.selectDefaultDebugLevel(customLogLevel);
		managerConfig_LoggingPage.clickCancel();
		managerConfig_LoggingPage.verifyCancelledDefaultDebugLevel(customLogLevel);
	}
	
	@Test(description="Verify after clicking on sub-table header it will expand and collapse information")
	public void Grid_4322()
	{
		managerConfig_LoggingPage=new ManagerConfiguration_Logging_Page();
		managerConfig_LoggingPage.launchPage();
		managerConfig_LoggingPage.launchLoggingPage();
		managerConfig_LoggingPage.collapseGeneralHeader();
		managerConfig_LoggingPage.expandGeneralHeader();
	}
	
	@Test(description="Verify tooltip is provided for description")
	public void Grid_4323()
	{
		managerConfig_LoggingPage=new ManagerConfiguration_Logging_Page();
		managerConfig_LoggingPage.launchPage();
		managerConfig_LoggingPage.launchLoggingPage();
		managerConfig_LoggingPage.verifyDescriptionTooltip();
	}
	
	@Test(description="Verify tooltip is provided for numeric values")
	public void Grid_4324()
	{
		managerConfig_LoggingPage=new ManagerConfiguration_Logging_Page();
		managerConfig_LoggingPage.launchPage();
		managerConfig_LoggingPage.launchLoggingPage();
		managerConfig_LoggingPage.verifyNumericDataTooltip();
	}
}
