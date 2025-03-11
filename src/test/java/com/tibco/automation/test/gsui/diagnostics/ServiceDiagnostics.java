package com.tibco.automation.test.gsui.diagnostics;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.Locators;
import com.tibco.automation.page.common.TemplatePage;

import com.tibco.automation.page.diagnostics.ServiceDiagnostics_Page;
import org.testng.annotations.Test;
@Test
public class ServiceDiagnostics extends WebDriverTestCase implements Locators{


public ExtendedWebDriver driver;
public DataGrid datagrid;
public TemplatePage templatepage;
public ServiceDiagnostics_Page servicediagnostics;

@BeforeMethod
public void beforeMethod()
{
	servicediagnostics = new ServiceDiagnostics_Page();
	servicediagnostics.clickTopMenuItem("Diagnostics");
	servicediagnostics.waitForPageToLoad();
	servicediagnostics.clickServiceDiagnoticsLink();
	servicediagnostics.waitForPageToLoad();
}

@Test(priority=0 ,description="Verify the functionality of Search button")
public void Grid_4631() throws InterruptedException 
	  {
	 servicediagnostics.clickOnEmptySearch();
	 
	  }
@Test(priority=1 ,description="Verify the functionality of Search button after adding the session id")
public void Grid_4632() throws InterruptedException 
	  {
	    servicediagnostics.selectServiceId();
	    servicediagnostics.waitForPageToLoad();
	    servicediagnostics.clickOnSearch();
	    servicediagnostics.waitForPageToLoad();
	    
	  } 
@Test(priority=2 ,description="Verify the help page for Service diagnostics")
public void Grid_4708() throws InterruptedException 
	  {
	
	    servicediagnostics.clickOnHelp();
	    servicediagnostics.verifyPageHelp();
	  } 





}