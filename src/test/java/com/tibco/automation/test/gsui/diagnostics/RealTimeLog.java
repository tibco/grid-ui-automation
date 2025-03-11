package com.tibco.automation.test.gsui.diagnostics;




import java.awt.AWTException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.Locators;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.diagnostics.RealTimeLog_Page;





public class RealTimeLog {
	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public TemplatePage templatepage;
	public RealTimeLog_Page realtimelog;
	@BeforeMethod
	public void beforeMethod()
	{
		 realtimelog = new RealTimeLog_Page();
		realtimelog.clickTopMenuItem("Diagnostics");
		realtimelog.waitForPageToLoad();
		realtimelog.clickRealTimeLogLink();
		realtimelog.waitForPageToLoad();
	}
	
   @Test(priority=1 ,description="Verify the real time logs") 
    public void Grid_4628() throws InterruptedException 
	  {
	   realtimelog.switchToNewlyOpenedWindow();
	realtimelog.verifyRealTimeLogWindow();
	realtimelog.waitForPageToLoad();
	realtimelog.closeWindow();
	realtimelog.switchToParentWindow();

	} 
  
   @Test(priority=2 ,description="Verify the functionality of clear button") 
   public void Grid_4629() throws InterruptedException 
	  {
	   realtimelog.switchToNewlyOpenedWindow();
	realtimelog.verifyClearButton();
	realtimelog.waitForPageToLoad();
	realtimelog.closeWindow();
	realtimelog.switchToParentWindow();
	}
  
   
   @Test(priority=3 ,description="Verify the functionality of snapshot button") 
   public void Grid_4630() throws InterruptedException 
	  {
	   realtimelog.switchToNewlyOpenedWindow();
	realtimelog.verifySpanshotButton();
	realtimelog.waitForPageToLoad();
	realtimelog.closeWindow();
	realtimelog.switchToParentWindow();
	}
   
  
   
}