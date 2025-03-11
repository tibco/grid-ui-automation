package com.tibco.automation.test.gsui.systemadmin;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import com.tibco.automation.page.admin.systemadmin.Manager_Reinstall_Page;
import com.tibco.automation.page.common.CommonFunctions;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.TemplatePage;

public class Manager_Reinstall extends WebDriverTestCase{

	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public TemplatePage templatepage;
	public Manager_Reinstall_Page managerReinstall;
	public CommonFunctions commonFunctions;
	
	@BeforeMethod
	public void beforeMethod()
	{
		managerReinstall=new Manager_Reinstall_Page();
		//managerReinstall.clickTopMenuItem("Admin");
		managerReinstall.launchPage();
		managerReinstall.waitForPageToLoad();
		managerReinstall.clickManagerReinstallLink();
		managerReinstall.waitForPageToLoad();
	}
	
	@Test(description="Verify the functionality of Next button")
	public void Grid_4475()
	{
		managerReinstall.clickOnNextButton();
		managerReinstall.waitForPageToLoad();
		managerReinstall.verifyNextIsClicked();
	}
	
	@Test(description="Verify the functionality of Previous button")
	public void Grid_4476()
	{
		managerReinstall.clickOnNextButton();
		managerReinstall.waitForPageToLoad();
		managerReinstall.verifyNextIsClicked();
		managerReinstall.clickOnPreviousButton();
		managerReinstall.verifyPreviousIsClicked();
	}
	
	@Test(description="Verify the functionality of Start Over Button")
	public void Grid_4477()
	{
		managerReinstall.clickOnNextButton();
		managerReinstall.waitForPageToLoad();
		managerReinstall.verifyNextIsClicked();
		managerReinstall.clickOnStartOver();
		managerReinstall.verifyStartOverIsClicked();
	}
}
