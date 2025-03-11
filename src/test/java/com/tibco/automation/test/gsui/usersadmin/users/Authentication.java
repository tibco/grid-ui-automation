package com.tibco.automation.test.gsui.usersadmin.users;


import org.testng.annotations.Test;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import com.tibco.automation.page.admin.useradmin.AuthenticationPage;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.TemplatePage;



public class Authentication extends WebDriverTestCase {
	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public TemplatePage templatepage;
	AuthenticationPage authentication = new AuthenticationPage();


	 @Test(priority=0 ,description="Verify the functionality Internal DB Mode") 
    public void Grid_4781() 
	{
		authentication.launchPage();
		authentication.waitForPageToLoad();
		authentication.selectinternaldbmode();		
	}
	
	@Test(priority=1 ,description="Verify the functionality of Expand All button on Internal DB page")
	public void Grid_4778()
	{
		authentication.launchPage();
		authentication.waitForPageToLoad();
		authentication.selectinternaldbmode();	
		authentication.clickdbexpandAll();
			

		authentication.waitForPageToLoad();
	}
	
	@Test(priority=2 ,description="Verify the functionality of Collapse All button")
	public void Grid_4589()
	{
		authentication.launchPage();
		authentication.waitForPageToLoad();
		authentication.clickcollapseAll();
		authentication.waitForPageToLoad();
	}
	
	
     
	@Test(priority=3 ,description="Verify the functionality of Cancel button")
    public void Grid_4591() throws InterruptedException
     {
		authentication.launchPage();
		authentication.waitForPageToLoad();
    	 authentication.clickCancel();
     
     }
	 
	@Test(priority=4 ,description="Verify the functionality of Windows Mode")
	public void Grid_4780() throws InterruptedException
	   {
		
		  authentication.launchPage();
		  authentication.waitForPageToLoad();
		  authentication.selectwindowsmode();
	   }
	     
	@Test(priority=5 ,description="Verify the functionality of Expand All button on Windows page")
	public void Grid_4779() throws InterruptedException
	   {
		authentication.launchPage();
		authentication.waitForPageToLoad();
		 authentication.selectwindowsmode();
		authentication.clickwindowsexpandAll();
		authentication.clickcollapseAll();	
	   } 
	  

	  
	@Test(priority=6 ,description="Verify the functionality LDAP Mode")
	public void Grid_4682() throws InterruptedException
	   {
		
		authentication.launchPage();
		authentication.waitForPageToLoad();
     	authentication.selectldapmode();
   	   
	   } 
	 
	 
	 @Test(priority=7 ,description="Verify property gear action")
	public void Grid_4593() throws InterruptedException
	   {
		 authentication.launchPage();
			authentication.waitForPageToLoad();
		authentication.clickproperty();
		
	   } 

	@Test(priority=8 ,description="Verify the functionality of Test Connection")
	 public void Grid_4596() throws InterruptedException
	   {
		authentication.launchPage();
		authentication.waitForPageToLoad();
		authentication.selectldapmode();
		 authentication.testConnection();   
	    
		 
	   } 
	
	@Test(priority=14 ,description="Verify the test connection button for wrong password")
		public void Grid_4785() throws InterruptedException
		   {
		authentication.launchPage();
		authentication.waitForPageToLoad();
	
			authentication.invalidPassConnectionTest();
			authentication.launchPage();
			authentication.waitForPageToLoad();
			authentication.selectinternaldbmode();

			authentication.clickSave();
		   } 
	

	@Test(priority=9 ,description="Verify the functionality of Save button")
	public void Grid_4590() throws InterruptedException
	   {
		authentication.launchPage();
		authentication.waitForPageToLoad();
		//authentication.createldapserver();
		
		authentication.clickSave();
	   
	   } 
	
	@Test(priority=10 ,description="Verify the functionality of Expand All button on LDAP page")
	public void Grid_4588() throws InterruptedException
	   {
		authentication.launchPage();
		authentication.waitForPageToLoad();
     	authentication.selectldapmode();
		 authentication.clickldapexpandAll();
		 authentication.clickcollapseAll();
		 authentication.clickldapexpandAll();
		
	   }
	
	 @Test(priority=11 ,description="Verify tooltip for CACHE_TTL")
	  public void Grid_4784()
	  {
		 authentication.launchPage();
			authentication.waitForPageToLoad();
			authentication.selectldapmode();
		  authentication.verifytooltip();
	  }
	
	 @Test(priority=12 ,description="Verify Global action Add LDAP server")
	 public void Grid_4592() throws InterruptedException
	   {
		 authentication.launchPage();
			authentication.waitForPageToLoad();
			authentication.selectldapmode();
		 authentication.addldapServer();
		 authentication.waitForPageToLoad();
	
	   } 
	
	/* @Test(priority=13 ,description="Verify remove LDAP")
	 public void Grid_4597() throws InterruptedException
	   {
		 authentication.launchPage();
			authentication.waitForPageToLoad();
		 authentication.removeldapServer();
		 authentication.waitForPageToLoad();
		 
	   } */
	  
	
		
		
	}
	

