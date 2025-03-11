package com.tibco.automation.test.gsui.systemadmin;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import com.tibco.automation.page.admin.systemadmin.License_Information_Page;
import com.tibco.automation.page.common.CommonFunctions;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.TemplatePage;

public class License_Information extends WebDriverTestCase{

	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public TemplatePage templatepage;
	public License_Information_Page licenseInfo;
	public CommonFunctions commonFunctions;
	
	@Test(description="Verify the functionality of Choose File")
	public void Grid_4473() 
	{
		licenseInfo=new License_Information_Page();
		licenseInfo.launchPage();
		licenseInfo.waitForPageToLoad();
		try {
			licenseInfo.uploadLicense();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
