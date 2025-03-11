package com.tibco.automation.test.gsui.gridcomponents.engines;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import com.tibco.automation.common.utils.RandomStringGenerator;
import com.tibco.automation.page.admin.useradmin.RolePage;
import com.tibco.automation.page.common.CommonFunctions;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.gridcomponents.engines.EngineConfigurationPage;

public class EngineConfiguration extends WebDriverTestCase{
	public ExtendedWebDriver driver;
	public TemplatePage templatepage;
	public EngineConfigurationPage enginepage;
	public CommonFunctions commonFunctions;
	public RolePage rolepage;
	public String configValue=null;
	
	@BeforeMethod
	public void beforeTest()
	{
		enginepage=new EngineConfigurationPage();
		enginepage.launchPage();
		enginepage.waitForPageToLoad();
		commonFunctions=new CommonFunctions();
		rolepage=new RolePage();
	}
	
	@Test(priority=1,description="Verify add button is present on engine configurations page")
	public void Grid_3935()
	{	
		enginepage.clickAddButoon();
		
	}

	@Test(priority=2,description="Verify functionality of cancel button on create new configuration popup")
	public void Grid_3936()
	{
		String configValue = "CANCEL"+RandomStringGenerator.get(3);
		enginepage.clickAddButoon();
		enginepage.waitForPageToLoad();
		enginepage.enterConfigValue(configValue);
		enginepage.waitForPageToLoad();
		enginepage.cancelCreate();
		enginepage.waitForPageToLoad();
		enginepage.verifyCancelConfiguration(configValue);
		enginepage.clickEngineConfig();
	}
	
	@Test(priority=3,description="Verify new configuration can be created for linux64")
	public void Grid_3937()
	{
		String configValue = "VALUE"+RandomStringGenerator.get(3);
		enginepage.clickEngineConfig();
		enginepage.waitForPageToLoad();
		enginepage.clickAddButoon();
		enginepage.waitForPageToLoad();
		enginepage.enterConfigValue(configValue);
		enginepage.create();
		enginepage.configSave();
		commonFunctions.acceptAlert();
		enginepage.waitForPageToLoad();
		enginepage.clickEngineConfig();
		enginepage.verifyCreateConfiguration(configValue);
		enginepage.deleteLogMsg();
		enginepage.clickEngineConfig();
		enginepage.clickEngineConfigName(configValue);
		enginepage.clickDelete();
		commonFunctions.acceptAlert();
		enginepage.waitForPageToLoad();
		enginepage.clickEngineConfig();
		enginepage.verifyDelete(configValue);
		enginepage.clickEngineConfig();

	}
	
	
	@Test(priority=5,description="Verify functionality of cancel button on engine configurations/platform:configname page.")
	public void Grid_3938()
	{
		
		String configValue = "VALUE"+RandomStringGenerator.get(3);
		enginepage.clickEngineConfig();
		enginepage.clickAddButoon();
		enginepage.enterConfigValue(configValue);
		enginepage.create();
		enginepage.selectCheckBox();
		enginepage.configSave();
		commonFunctions.acceptAlert();
		enginepage.waitForPageToLoad();
		enginepage.clickEngineConfig();
		enginepage.verifyCreateConfiguration(configValue);
		enginepage.clickEngineConfig();
		enginepage.clickEngineConfigName(configValue);
		enginepage.deselectCheckbox();
		enginepage.configCancel();
		enginepage.clickEngineConfig();
		enginepage.clickEngineConfigName(configValue);
		enginepage.verifyCancelConfig();
		enginepage.deleteLogMsg();
		enginepage.clickEngineConfig();
		enginepage.clickEngineConfigName(configValue);
		enginepage.clickDelete();
		commonFunctions.acceptAlert();
		enginepage.waitForPageToLoad();
		enginepage.clickEngineConfig();
		enginepage.verifyDelete(configValue);
		enginepage.clickEngineConfig();
	
	}
	@Test(priority=5,description="Verify functionality of save button on engine configurations/platform:configname page")
	public void Grid_3939()
	{
		String configValue = "VALUE"+RandomStringGenerator.get(3);
		enginepage.clickEngineConfig();
		enginepage.clickAddButoon();
		enginepage.enterConfigValue(configValue);
		enginepage.create();
		enginepage.configSave();
		commonFunctions.acceptAlert();
		enginepage.waitForPageToLoad();
		enginepage.clickEngineConfig();
		enginepage.verifyCreateConfiguration(configValue);
		enginepage.clickEngineConfigName(configValue);
		enginepage.selectCheckBox();
		enginepage.configSave();
		commonFunctions.acceptAlert();
		enginepage.waitForPageToLoad();
		enginepage.clickEngineConfig();
		enginepage.clickEngineConfig();
		enginepage.clickEngineConfigName(configValue);
		enginepage.verifySaveConfiguration();
		enginepage.deleteLogMsg();
		enginepage.clickEngineConfig();
		enginepage.clickEngineConfig();
		enginepage.clickEngineConfigName(configValue);
		enginepage.clickDelete();
		commonFunctions.acceptAlert();
		enginepage.waitForPageToLoad();
		enginepage.clickEngineConfig();
		enginepage.verifyDelete(configValue);
		enginepage.clickEngineConfig();
		
	}	
	
	
	@Test(priority=6,description="Verify functionality of copy button on engine configurations/platform:configname page.")
	public void Grid_3940()
	{
		String configValue="COPY"+RandomStringGenerator.get(3);
		enginepage.clickEngineConfig();	
		enginepage.clickLinuxEngineConfig();
		enginepage.clickCopy();
		enginepage.enterCopyData(configValue);
		enginepage.saveCopyConfig();
		enginepage.clickEngineConfig();
		enginepage.verifyCopyConfiguration(configValue);
		enginepage.deleteLogMsg();
		enginepage.clickEngineConfig();
		enginepage.clickEngineConfigName(configValue);
		enginepage.clickDelete();
		commonFunctions.acceptAlert();
		enginepage.waitForPageToLoad();
		enginepage.clickEngineConfig();
		enginepage.verifyDelete(configValue);
		
	}
	
	@Test(priority=7,description="Verify functionality of delete button on engine configurations/platform:configname page")
	public void Grid_3941()
	{
		String configValue="DELETE"+RandomStringGenerator.get(3);
		enginepage.clickEngineConfig();	
		enginepage.clickLinuxEngineConfig();
		enginepage.clickCopy();
		enginepage.enterCopyData(configValue);
		enginepage.saveCopyConfig();
		enginepage.clickEngineConfig();
		enginepage.verifyCopyConfiguration(configValue);
		//enginepage.clickEngineConfig();
		enginepage.deleteLogMsg();
		enginepage.clickEngineConfig();
		enginepage.clickEngineConfigName(configValue);
		enginepage.clickDelete();
		commonFunctions.acceptAlert();
		enginepage.waitForPageToLoad();
		enginepage.clickEngineConfig();
		enginepage.waitForPageToLoad();
		enginepage.verifyDelete(configValue);
	
	}
	
	@Test(priority=8,description="Verify functionality of expand all button on engine configurations/platform:configname page")
	public void Grid_3942()
	{
		enginepage.clickEngineConfig();	
		enginepage.clickLinuxEngineConfig();
		enginepage.clickExpandAll();
		enginepage.verifyExpandAll();
		enginepage.clickEngineConfig();
		
	}
	@Test(priority=9,description="Verify functionality of expand all button on engine configurations/platform:configname page")
	public void Grid_3943()
	{
		enginepage.clickEngineConfig();	
		enginepage.clickLinuxEngineConfig();
		enginepage.clickCollapseAll();
		enginepage.verifyCollapseAll();
		enginepage.clickEngineConfig();
		
	}
	
	@Test(priority=10,description="Verify clicking on engine configurations link in side menu bar navigates user to list of configuration")
	public void Grid_3944()
	{
		String configValue = "VALUE"+RandomStringGenerator.get(3);
		enginepage.clickEngineConfig();
		enginepage.clickAddButoon();
		enginepage.enterConfigValue(configValue);
		enginepage.create();
		enginepage.clickEngineConfig();
		enginepage.verifySideLink();
		enginepage.deleteLogMsg();
		enginepage.clickEngineConfig();
		enginepage.clickEngineConfigName(configValue);
		enginepage.clickDelete();
		commonFunctions.acceptAlert();
		enginepage.waitForPageToLoad();
		enginepage.clickEngineConfig();
		enginepage.verifyDelete(configValue);
	}
}


