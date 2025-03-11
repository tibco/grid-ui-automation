package com.tibco.automation.test.gsui.services.services;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.awt.*;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import com.tibco.automation.page.admin.systemadmin.ManagerImportExportPage;
import com.tibco.automation.page.admin.useradmin.RolePage;
import com.tibco.automation.page.common.CommonFunctions;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.Locators;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.services.services.ServiceTestPage;

public class ServiceTest  extends WebDriverTestCase{
	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public TemplatePage templatepage;
	public CommonFunctions commonFunctions;
	public ServiceTestPage servicetestpage; 
	
	@BeforeTest
	public void beforeTest()
	{
		servicetestpage=new ServiceTestPage();
		servicetestpage.launchPage();
		servicetestpage.waitForPageToLoad();
	}
	
	@Test(priority=1,description="Verify functionality of Service test")
	public void Grid_4127()
	{
		servicetestpage.clickServiceTest();
		
	}

	@Test(priority=2,description="Verify the functionality of Submit button on Linpack service Test")
	public void Grid_4128() 
	{
		servicetestpage.clickLinpackSubmit();
		servicetestpage.waitForPageToLoad();
		servicetestpage.verifyClickLinpackSubmit();
	}
	
	@Test(priority=3,description="Verify the functionality of Submit button on Performance service Test")
	public void Grid_4129() 
	{
		servicetestpage.clickPerformanceSubmit();
		servicetestpage.waitForPageToLoad();
		servicetestpage.verifyClickPerformanceSubmit();
	}
}
