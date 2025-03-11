package com.tibco.automation.test.gsui.gridcomponents.drivers;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.awt.*;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import com.tibco.automation.page.admin.systemadmin.ManagerImportExportPage;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.Locators;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.gridcomponents.drivers.WebServicesPage;

public class WebServices extends WebDriverTestCase implements Locators.WebServices{
	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public TemplatePage templatepage;
	WebServicesPage webservice;
	
@Test(priority=1 ,description="Verify functionality of expand all button on web services page") 
	public void Grid_3887()
	{
		webservice=new WebServicesPage();
		webservice.launchPage();
		webservice.waitForPageToLoad();
		webservice.verifyExpandAll();
		
  }
  
	@Test(priority=2 ,description="VVerify functionality of collapse all button on web services page") 
	public void Grid_3888()
	{
		webservice=new WebServicesPage();
		webservice.launchPage();
		webservice.waitForPageToLoad();
		webservice.verifyCollapseAll();
		
  }
  
	
	@Test(priority=3 ,description="Verify the details expand when user clicks on name of web service") 
	public void Grid_3889()
	{
		webservice=new WebServicesPage();
		webservice.launchPage();
		webservice.waitForPageToLoad();
		webservice.verifyServiceExpand();
		
	}
	
	
	@Test(priority=4 ,description="Verify the details collapse when user clicks on name of web service if details are in expanded state") 
	public void Grid_3890()
	{
		webservice=new WebServicesPage();
		webservice.launchPage();
		webservice.waitForPageToLoad();
		webservice.verifyServiceCollapse();
   }
	
	@Test(priority=6 ,description="Verify local action is enabled as soon as user checks a web service checkbox") 
	public void Grid_3891()
	{
		webservice=new WebServicesPage();
		webservice.launchPage();
		webservice.waitForPageToLoad();
	webservice.verifyLocalAction();
		
		
	}
	
	@Test(priority=5 ,description="Verify functionality of local action- generate WSDL") 
	public void Grid_3892() throws InterruptedException, AWTException
	{
		webservice=new WebServicesPage();
		webservice.launchPage();
		webservice.waitForPageToLoad();
	  webservice.verifyGenerateWSDL();
	}
	
	
	
	
	
}