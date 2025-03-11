package com.tibco.automation.test.gsui.services.services;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.awt.*;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import com.tibco.automation.page.admin.systemadmin.ManagerImportExportPage;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.Locators;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.services.services.GridLibrariesPage;

public class GridLibraries extends WebDriverTestCase implements Locators.GridLibraries{
	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public TemplatePage templatepage;
	GridLibrariesPage gridlib;
	
	@BeforeMethod
	public void beforeMethod()
	{
		gridlib = new GridLibrariesPage();
		gridlib.launchPage();
		gridlib.waitForPageToLoad();
	}
	
	@Test(priority=1 ,description="Verify functionality of Upload Grid Library button on Grid Libraries page") 
	public void Grid_3810() throws AWTException
	{
		
		gridlib.verifyUploadGridlib();
	}
	
	
	@Test(priority=2,description="Verify functionality of Deploy button on Grid Libraries page") 
	public void Grid_3811() throws AWTException, InterruptedException
	{
		
		gridlib.verifyDeploy();
	}
	@Test(priority=3,description="Verify functionality of Update button on Grid Libraries page") 
	public void Grid_3813() throws AWTException
	{
		
		gridlib.verifyUpadte();
	}
	

	@Test(priority=4,description="Verify functionality of Grid library details link on Grid Libraries pag") 
	public void Grid_3814() throws AWTException
	{
		
		gridlib.verifyDetails();
	}
	

   @Test(priority=5,description="Verify after clicking checkbox on table head it will automatically check all the checkbox on Grid Libraries page") 
	public void Grid_3816() throws AWTException
	{
		
		gridlib.verifyCheckbox();
	}
	
  
 	
	
    @Test(priority=6,description="Verify functionality of Delete button on Grid Libraries page") 
	public void Grid_3812() throws AWTException
	{
		
		gridlib.verifyDelete();
	}
	
   @Test(priority=7,description="Verify functionality of Download Grid library link on Grid Libraries page") 
 	public void Grid_3815()throws AWTException
 	{
 		
 		gridlib.verifyDownload();
 	}
 	
}