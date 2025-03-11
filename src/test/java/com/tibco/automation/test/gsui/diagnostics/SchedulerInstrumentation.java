package com.tibco.automation.test.gsui.diagnostics;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import com.tibco.automation.page.common.CommonFunctions;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.Locators;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.diagnostics.SchedulerInstrumentation_Page;
import com.tibco.automation.page.diagnostics.ServiceDiagnostics_Page;
import org.testng.annotations.Test;
@Test
public class SchedulerInstrumentation extends WebDriverTestCase implements Locators{


public ExtendedWebDriver driver;
public DataGrid datagrid;
public TemplatePage templatepage;
public SchedulerInstrumentation_Page intrumentation;
public CommonFunctions commonFunctions;
@BeforeMethod
public void beforeMethod()
{
	intrumentation=new SchedulerInstrumentation_Page();
	 commonFunctions=new CommonFunctions();
	intrumentation.clickTopMenuItem("Diagnostics");
	intrumentation.waitForPageToLoad();
	intrumentation.clickInstrumentationLink();
	intrumentation.waitForPageToLoad();
}

@Test(priority=1 ,description="Verify the functionality of start date calendar")
public void Grid_4599() throws InterruptedException 
	  {
	intrumentation.clickonStartDateCalender();
	 
	  }
@Test(priority=2 ,description="Verify the functionality of end  date calendar")
public void Grid_4600() throws InterruptedException 
	  {
	intrumentation.clickonEndDateCalender();
	 
	  }

@Test(priority=3 ,description="Verify the functionality of Showing Results Per Page by changing the value.")
public void Grid_4609() throws InterruptedException 
	  {

	intrumentation.updateResultsPerPage(1);
	  }

@Test(priority=4,description="Verify functionality of move to last page button")
	public void Grid_5254()
	{
		
	 intrumentation.waitForPageToLoad();
	 intrumentation.goToLastPage();
	}

@Test(priority=5,description="Verify functionality of move to first page button")
public void Grid_5285()
{
	
	intrumentation.waitForPageToLoad();
	intrumentation.goToLastPage();
	intrumentation.goToFirstPage();
}


@Test(priority=6,description="Verify the functionality of CheckPoints checkbox for Level 1")
public void Grid_4613()
{
	intrumentation.clickOnAdminPage();
	intrumentation.selectLevel1();
	intrumentation.clickOnDiagnosticsPage();
	intrumentation.verifyCheckPoints();
	
}
@Test(priority=7,description="Verify the functionality of Match Items checkbox for Level 1")
public void Grid_4614()
{
	intrumentation.clickOnAdminPage();
	intrumentation.selectLevel1();
	intrumentation.clickOnDiagnosticsPage();
	intrumentation.verifyMatchItems();
	
}

@Test(priority=8,description="Verify the functionality of Waiting List checkbox for Level 1")
public void Grid_4615()
{
	intrumentation.clickOnAdminPage();
	intrumentation.selectLevel1();
	intrumentation.clickOnDiagnosticsPage();
	intrumentation.verifyWaitingList();
	
}
@Test(priority=9,description="Verify the functionality of Engine Info checkbox for Level 1")
public void Grid_4616()
{
	intrumentation.clickOnAdminPage();
	intrumentation.selectLevel1();
	intrumentation.clickOnDiagnosticsPage();
	intrumentation.verifyEngineInfo();
	
}

@Test(priority=10,description="Verify the functionality of more info button for Level 1")
public void Grid_4617()
{
	intrumentation.clickOnAdminPage();
	intrumentation.selectLevel1();
	intrumentation.clickOnDiagnosticsPage();
	intrumentation.verifyMoreinfo();
}



@Test(priority=11,description="Verify the functionality of keyword search")
public void Grid_4607()
{
	intrumentation.provideSearchString();
	intrumentation.clickOnSearch();
	intrumentation.verifySearch();
	intrumentation.verifyClearButton();
	
	
  } 
@Test(priority=12,description="Verify the functionality of clear button")
public void Grid_5299()
{
	intrumentation.provideSearchString();
	
	intrumentation.verifyClearButton();

}
}