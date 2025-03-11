package com.tibco.automation.test.gsui.services.batch;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import com.tibco.automation.page.common.CommonFunctions;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.services.batch.BatchAdminPage;

public class BatchAdmin extends WebDriverTestCase{
	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public BatchAdminPage batchAdmin;
	public CommonFunctions commonFunctions;
	@BeforeMethod
	public void beforeMethod()
	{
		batchAdmin=new BatchAdminPage();
		commonFunctions=new CommonFunctions();
		batchAdmin.launchPage();
		batchAdmin.waitForPageToLoad();
	}
	
	@Test(priority=1,description="Verify refresh button is present and it shows last refresh on tooltip")
	public void Grid_4287()
	{
		batchAdmin.verifyRefreshButton();
		commonFunctions.verifyLastRefresh();
	}
	@Test(priority=2,description="Verify clicking on refresh button disables it.")
	public void Grid_4288()
	{
		commonFunctions.clickRefreshButton();
		commonFunctions.verifyRefreshDisabled();
	}
}
