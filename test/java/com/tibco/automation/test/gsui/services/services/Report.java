package com.tibco.automation.test.gsui.services.services;

import org.testng.annotations.Test;



import java.awt.AWTException;

import org.testng.annotations.Test;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.Locators;
import com.tibco.automation.page.common.TemplatePage;

import com.tibco.automation.page.services.services.ReportsPage;




public class Report extends WebDriverTestCase implements Locators{
	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public TemplatePage templatepage;
	ReportsPage report = new ReportsPage();
@Test(priority=6 ,description="Verify functionality of Export Result button on reports page") 
 public void Grid_4133() 
	  {
	     report.launchPage();
	     report.waitForPageToLoad();
	     report.verifyExportResult();

	}

	
@Test(priority=2 ,description="Verify functionality of Display Result button on reports page") 
	public void Grid_4132() 
	{
	report.launchPage();
	report.waitForPageToLoad();
	report.verifyDisplayResult();

	}

@Test(priority=3 ,description="Verify functionality of Summaries on reports page") 
	public void Grid_4134() 
	{
	report.launchPage();
	report.waitForPageToLoad();
	report.verifySummariesResult();

	}



@Test(priority=4,description="Verify the functionality of Display Result/Export Result/Summaries after changing the period to within last Month") 
  	public void Grid_4693() 
	{
	report.launchPage();
	report.waitForPageToLoad();
	report.verifyLastMonthResult();

}
@Test(priority=5,description="Verify the functionality of Display Result/Export Result/Summaries after changing the calendar date") 
	public void Grid_4695() throws InterruptedException 
	{
	report.launchPage();
	report.waitForPageToLoad();
	report.verifyBetweenResult();

}
@Test(priority=1,description="Verify the service name click on Reports page.") 
	public void Grid_4797() throws InterruptedException 
	{
	report.launchPage();
	report.waitForPageToLoad();
	report.verifyServiceLink();

}

}




