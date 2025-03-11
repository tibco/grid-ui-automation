package com.tibco.automation.test.gsui.usersadmin.users;

import org.testng.annotations.Test;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import com.tibco.automation.common.utils.RandomStringGenerator;
import com.tibco.automation.page.admin.useradmin.RunAsPage;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.TemplatePage;

public class RunAs extends WebDriverTestCase {
	
	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public TemplatePage templatepage;
	public String runAsUsername;
	public String runAsPassword;
	public RunAsPage runAsPage;
	
	
	@Test(description="Verify the functionality of Add button")
	public void Grid_4601()
	{
		runAsUsername="admin1"+RandomStringGenerator.get(3);
		runAsPassword="admin1"+RandomStringGenerator.get(3);
		runAsPage=new RunAsPage();
		runAsPage.launchPage();
		runAsPage.waitForPageToLoad();
		runAsPage.addRunAsUser();
		runAsPage.clickCloseButton();
	}
	
	
	
	@Test(description="Verify the functionality of Save button of Add button popup")
	public void Grid_4603()
	{
		runAsUsername="admin1"+RandomStringGenerator.get(3);
		runAsPassword="admin1"+RandomStringGenerator.get(3);
		runAsPage=new RunAsPage();
		runAsPage.launchPage();
		runAsPage.waitForPageToLoad();
		runAsPage.addRunAsUser();
		runAsPage.saveRunAsUser(runAsUsername, runAsPassword);
		runAsPage.verifyUserAdded(runAsUsername);
		runAsPage.waitForPageToLoad();
	}
	
	@Test(description="Verify the functionality of Remove button")
	public void Grid_4604()
	{
		runAsUsername="admin1"+RandomStringGenerator.get(3);
		runAsPassword="admin1"+RandomStringGenerator.get(3);
		runAsPage=new RunAsPage();
		runAsPage.launchPage();
		runAsPage.waitForPageToLoad();
		runAsPage.addRunAsUser();
		runAsPage.saveRunAsUser(runAsUsername, runAsPassword);
		runAsPage.verifyUserAdded(runAsUsername);
		runAsPage.removeRunAsUser(runAsUsername);
		runAsPage.verifyUserNotPresent(runAsUsername);
		runAsPage.waitForPageToLoad();
	}
	
	
	@Test(description="Verify the functionality of Close button of add user popup")
	public void Grid_4606()
	{
		runAsUsername="admin1"+RandomStringGenerator.get(3);
		runAsPassword="admin1"+RandomStringGenerator.get(3);
		runAsPage=new RunAsPage();
		runAsPage.launchPage();
		runAsPage.waitForPageToLoad();
		runAsPage.addRunAsUser();
		runAsPage.clickCloseButtonWithValues(runAsUsername,runAsPassword);
		runAsPage.verifyUserNotPresent(runAsUsername);
		
	}
	
	
	@Test(description="Verify the functionality of cancel button of remove user popup")
	public void Grid_4777()
	{
		runAsUsername="admin1"+RandomStringGenerator.get(3);
		runAsPassword="admin1"+RandomStringGenerator.get(3);
		runAsPage=new RunAsPage();
		runAsPage.launchPage();
		runAsPage.waitForPageToLoad();
		runAsPage.addRunAsUser();
		runAsPage.saveRunAsUser(runAsUsername, runAsPassword);
		runAsPage.waitForPageToLoad();
		runAsPage.verifyUserAdded(runAsUsername);
		runAsPage.cancelUserRemoval(runAsUsername);
		runAsPage.verifyUserPresent(runAsUsername);
	}
	
	
}
