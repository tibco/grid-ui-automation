package com.tibco.automation.test.gsui.systemadmin;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import java.awt.*;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import com.tibco.automation.page.admin.systemadmin.ManagerImportExportPage;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.TemplatePage;

public class ManagerImportExport extends WebDriverTestCase {
	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public TemplatePage templatepage;
	public String userName = null;
	ManagerImportExportPage importexport=new ManagerImportExportPage();
	
	
@Test(priority=1 ,description="Verify functionality of Collapse All") 
	public void Grid_4398()
	{
		importexport.launchPage();
		importexport.waitForPageToLoad();
		importexport.clickonCollapseAll();
		
		
	}

	
	@Test(priority=2 ,description="Verify functionality of Expand All") 
    public void Grid_4397()
	{
		importexport.launchPage();
		importexport.waitForPageToLoad();
		importexport.clickonExpandAll();
		
	}
	@Test(priority=3 ,description="Verify after clicking on sub-table header arrow it will expand/collapse information") 
	public void Grid_4403()
	{
		importexport.launchPage();
		importexport.waitForPageToLoad();
		importexport.verifyArrow();
		
		
	}

	@Test(priority=4 ,description="Verify functionality of checkbox on page") 
	public void Grid_4401()
	{
		importexport.launchPage();
		importexport.waitForPageToLoad();
		importexport.verifyAllCheckbox();
		
		
	}
	
	@Test(priority=5 ,description="Verify functionality of Export File button") 
	public void Grid_4399()
	{
		importexport.launchPage();
		importexport.waitForPageToLoad();
		importexport.verifyExport();
		
	}
	
	
	@Test(priority=6 ,description="Verify the functionality of Import button for black upload.") 
	public void Grid_4786()
	{
		importexport.launchPage();
		importexport.waitForPageToLoad();
		importexport.verifyBlankUpload();
		
	}

	@Test(priority=7 ,description="Verify the functionality of import button without importing or overwriting jar file.") 
	 
	public void Grid_4787() throws AWTException, InterruptedException
	{
		importexport.launchPage();
		importexport.waitForPageToLoad();
		importexport.verifyImportWithoutJar();
		
	}
	@Test(priority=8 ,description="Verify the functionality of cancel button") 
	public void Grid_4788() throws AWTException, InterruptedException
	{
		importexport.launchPage();
		importexport.waitForPageToLoad();
		importexport.verifyCancleImport();
	}
	
	@Test(priority=9 ,description="Verify functionality of Import File button with import all.") 
	public void Grid_4400() throws AWTException, InterruptedException
	{
		importexport.launchPage();
		importexport.waitForPageToLoad();
		
	   importexport.verifyImportUpload();
		
	}
	
 	
	

	
	
	
	
}