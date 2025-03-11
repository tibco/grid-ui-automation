package com.tibco.automation.test.gsui.services.batch;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import com.tibco.automation.common.utils.RandomStringGenerator;
import com.tibco.automation.common.utils.RandomStringGenerator.RandomizerTypes;
import com.tibco.automation.page.common.CommonFunctions;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.services.batch.ServiceRunnerPage;

public class ServiceRunner extends WebDriverTestCase{
	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public TemplatePage templatepage;
	public ServiceRunnerPage serviceRunner;
	public CommonFunctions commonFunctions;
	public String serviceRunnerName;
	public String description;
	public String renameServiceRunner;
	public String copyServiceRunner;
	
	@BeforeMethod
	public void beforeMethod()
	{
		serviceRunner=new ServiceRunnerPage();
		commonFunctions=new CommonFunctions();
		serviceRunner.launchPage();
		serviceRunner.waitForPageToLoad();
		serviceRunnerName=RandomStringGenerator.get(5, RandomizerTypes.MIXED);
		description="description"+serviceRunnerName;
		renameServiceRunner="rename"+serviceRunnerName;
		copyServiceRunner="copy"+serviceRunnerName;
	}
	
	@Test(description="Verify functionality of Add button on Service Runners page")
	public void Grid_4222()
	{
		serviceRunner.clickAddServiceRunnerButton();
		serviceRunner.setServiceRunnerName(serviceRunnerName);
		serviceRunner.getCurrentWindowHandle();
		serviceRunner.clickAddOnPopup();
		serviceRunner.switchToNewlyOpenedWindow();
		serviceRunner.clickSaveButton();
		serviceRunner.switchToParentWindow();
		serviceRunner.waitForPageToLoad();
		serviceRunner.verifyServiceRunnerIsPresent(serviceRunnerName);
	}
	
	@Test(description="Verify functionality of Cancel button on Service Runners popup")
	public void Grid_4224()
	{
		serviceRunner.clickAddServiceRunnerButton();
		serviceRunner.setServiceRunnerName(serviceRunnerName);
		serviceRunner.clickCancelOnPopup();
		serviceRunner.waitForPageToLoad();
		serviceRunner.verifyServiceRunnerIsNotPresent(serviceRunnerName);
	}
	
	@Test(description="Verify functionality of Cancel button on add Service Runners page")
	public void Grid_4226()
	{
		serviceRunner.clickAddServiceRunnerButton();
		serviceRunner.setServiceRunnerName(serviceRunnerName);
		serviceRunner.getCurrentWindowHandle();
		serviceRunner.clickAddOnPopup();
		serviceRunner.switchToNewlyOpenedWindow();
		serviceRunner.clickCancelOnPage();
		serviceRunner.switchToParentWindow();
		serviceRunner.clickCancelOnPopup();
		serviceRunner.waitForPageToLoad();
		serviceRunner.verifyServiceRunnerIsNotPresent(serviceRunnerName);
	}
	
	@Test(description="Verify selecting a Service Runners enables the local action")
	public void Grid_4228()
	{
		serviceRunner.clickAddServiceRunnerButton();
		serviceRunner.setServiceRunnerName(serviceRunnerName);
		serviceRunner.getCurrentWindowHandle();
		serviceRunner.clickAddOnPopup();
		serviceRunner.switchToNewlyOpenedWindow();
		serviceRunner.clickSaveButton();
		serviceRunner.switchToParentWindow();
		serviceRunner.waitForPageToLoad();
		serviceRunner.verifyServiceRunnerIsPresent(serviceRunnerName);
		serviceRunner.selectServiceRunner(serviceRunnerName);
		serviceRunner.selectServiceRunner(serviceRunnerName);
		serviceRunner.selectServiceRunner(serviceRunnerName);
		commonFunctions.verifyLocalActionLinkIsPresent();
	}
	
	@Test(description="verify deselecting a Service Runner disables the local action")
	public void Grid_4699()
	{
		serviceRunner.clickAddServiceRunnerButton();
		serviceRunner.setServiceRunnerName(serviceRunnerName);
		serviceRunner.getCurrentWindowHandle();
		serviceRunner.clickAddOnPopup();
		serviceRunner.switchToNewlyOpenedWindow();
		serviceRunner.clickSaveButton();
		serviceRunner.switchToParentWindow();
		serviceRunner.waitForPageToLoad();
		serviceRunner.verifyServiceRunnerIsPresent(serviceRunnerName);
		serviceRunner.selectServiceRunner(serviceRunnerName);
		serviceRunner.selectServiceRunner(serviceRunnerName);
		serviceRunner.selectServiceRunner(serviceRunnerName);
		serviceRunner.selectServiceRunner(serviceRunnerName);
		commonFunctions.verifyGlobalActionLinkIsPresent();
	}
	
	@Test(description="Verify functionality of Edit Service Runner local action")
	public void Grid_4229()
	{
		serviceRunner.clickAddServiceRunnerButton();
		serviceRunner.setServiceRunnerName(serviceRunnerName);
		serviceRunner.getCurrentWindowHandle();
		serviceRunner.clickAddOnPopup();
		serviceRunner.switchToNewlyOpenedWindow();
		serviceRunner.clickSaveButton();
		serviceRunner.switchToParentWindow();
		serviceRunner.waitForPageToLoad();
		serviceRunner.verifyServiceRunnerIsPresent(serviceRunnerName);
		serviceRunner.selectServiceRunner(serviceRunnerName);
		serviceRunner.selectServiceRunner(serviceRunnerName);
		serviceRunner.selectServiceRunner(serviceRunnerName);
		serviceRunner.getCurrentWindowHandle();
		commonFunctions.selectLocalAction("Edit Service Runner");
		serviceRunner.switchToNewlyOpenedWindow();
		serviceRunner.fillDescription(description);
		serviceRunner.clickSaveButton();
		serviceRunner.switchToParentWindow();
		serviceRunner.waitForPageToLoad();
		serviceRunner.verifyDescriptionIsPresent(serviceRunnerName, description);
	}
	
	@Test(description="Verify functionality of Cancel button on Edit Service Runner popup")
	public void Grid_4231()
	{
		serviceRunner.clickAddServiceRunnerButton();
		serviceRunner.setServiceRunnerName(serviceRunnerName);
		serviceRunner.getCurrentWindowHandle();
		serviceRunner.clickAddOnPopup();
		serviceRunner.switchToNewlyOpenedWindow();
		serviceRunner.clickSaveButton();
		serviceRunner.switchToParentWindow();
		serviceRunner.waitForPageToLoad();
		serviceRunner.verifyServiceRunnerIsPresent(serviceRunnerName);
		serviceRunner.selectServiceRunner(serviceRunnerName);
		serviceRunner.selectServiceRunner(serviceRunnerName);
		serviceRunner.selectServiceRunner(serviceRunnerName);
		serviceRunner.getCurrentWindowHandle();
		commonFunctions.selectLocalAction("Edit Service Runner");
		serviceRunner.switchToNewlyOpenedWindow();
		serviceRunner.fillDescription(description);
		serviceRunner.clickCancelOnPage();
		serviceRunner.switchToParentWindow();
		serviceRunner.waitForPageToLoad();
		serviceRunner.verifyDescriptionIsNotPresent(serviceRunnerName, description);
	}
	
	@Test(description="Verify functionality of Rename Service Runner local action")
	public void Grid_4233()
	{
		serviceRunner.clickAddServiceRunnerButton();
		serviceRunner.setServiceRunnerName(serviceRunnerName);
		serviceRunner.getCurrentWindowHandle();
		serviceRunner.clickAddOnPopup();
		serviceRunner.switchToNewlyOpenedWindow();
		serviceRunner.clickSaveButton();
		serviceRunner.switchToParentWindow();
		serviceRunner.waitForPageToLoad();
		serviceRunner.verifyServiceRunnerIsPresent(serviceRunnerName);
		serviceRunner.selectServiceRunner(serviceRunnerName);
		serviceRunner.selectServiceRunner(serviceRunnerName);
		serviceRunner.selectServiceRunner(serviceRunnerName);
		commonFunctions.selectLocalAction("Rename Service Runner");
		serviceRunner.updateServiceRunnerName(renameServiceRunner);
		serviceRunner.clickSaveOnServiceRunnerUpdatePopup();
		serviceRunner.waitForPageToLoad();
		serviceRunner.verifyServiceRunnerIsPresent(renameServiceRunner);
	}
	
	@Test(description="Verify functionality of Cancel button on Rename Service Runner popup")
	public void Grid_4235()
	{
		serviceRunner.clickAddServiceRunnerButton();
		serviceRunner.setServiceRunnerName(serviceRunnerName);
		serviceRunner.getCurrentWindowHandle();
		serviceRunner.clickAddOnPopup();
		serviceRunner.switchToNewlyOpenedWindow();
		serviceRunner.clickSaveButton();
		serviceRunner.switchToParentWindow();
		serviceRunner.waitForPageToLoad();
		serviceRunner.verifyServiceRunnerIsPresent(serviceRunnerName);
		serviceRunner.selectServiceRunner(serviceRunnerName);
		serviceRunner.selectServiceRunner(serviceRunnerName);
		serviceRunner.selectServiceRunner(serviceRunnerName);
		commonFunctions.selectLocalAction("Rename Service Runner");
		serviceRunner.updateServiceRunnerName(renameServiceRunner);
		serviceRunner.clickCancelServiceRunnerUpdatePopup();
		serviceRunner.waitForPageToLoad();
		serviceRunner.verifyServiceRunnerIsNotPresent(renameServiceRunner);
	}
	
	@Test(description="Verify functionality of Copy Service Runner local action")
	public void Grid_4236()
	{
		serviceRunner.clickAddServiceRunnerButton();
		serviceRunner.setServiceRunnerName(serviceRunnerName);
		serviceRunner.getCurrentWindowHandle();
		serviceRunner.clickAddOnPopup();
		serviceRunner.switchToNewlyOpenedWindow();
		serviceRunner.clickSaveButton();
		serviceRunner.switchToParentWindow();
		serviceRunner.waitForPageToLoad();
		serviceRunner.verifyServiceRunnerIsPresent(serviceRunnerName);
		serviceRunner.selectServiceRunner(serviceRunnerName);
		serviceRunner.selectServiceRunner(serviceRunnerName);
		serviceRunner.selectServiceRunner(serviceRunnerName);
		commonFunctions.selectLocalAction("Copy Service Runner");
		serviceRunner.updateServiceRunnerName(copyServiceRunner);
		serviceRunner.clickSaveOnServiceRunnerUpdatePopup();
		serviceRunner.waitForPageToLoad();
		serviceRunner.verifyServiceRunnerIsPresent(copyServiceRunner);
	}
	
	@Test(description="Verify functionality of Cancel button on Copy Service Runner popup")
	public void Grid_4238()
	{
		serviceRunner.clickAddServiceRunnerButton();
		serviceRunner.setServiceRunnerName(serviceRunnerName);
		serviceRunner.getCurrentWindowHandle();
		serviceRunner.clickAddOnPopup();
		serviceRunner.switchToNewlyOpenedWindow();
		serviceRunner.clickSaveButton();
		serviceRunner.switchToParentWindow();
		serviceRunner.waitForPageToLoad();
		serviceRunner.verifyServiceRunnerIsPresent(serviceRunnerName);
		serviceRunner.selectServiceRunner(serviceRunnerName);
		serviceRunner.selectServiceRunner(serviceRunnerName);
		serviceRunner.selectServiceRunner(serviceRunnerName);
		commonFunctions.selectLocalAction("Copy Service Runner");
		serviceRunner.updateServiceRunnerName(copyServiceRunner);
		serviceRunner.clickCancelServiceRunnerUpdatePopup();
		serviceRunner.waitForPageToLoad();
		serviceRunner.verifyServiceRunnerIsNotPresent(copyServiceRunner);
	}
	
	@Test(description="Verify functionality of Delete Service Runner local action")
	public void Grid_4239()
	{
		serviceRunner.clickAddServiceRunnerButton();
		serviceRunner.setServiceRunnerName(serviceRunnerName);
		serviceRunner.getCurrentWindowHandle();
		serviceRunner.clickAddOnPopup();
		serviceRunner.switchToNewlyOpenedWindow();
		serviceRunner.clickSaveButton();
		serviceRunner.switchToParentWindow();
		serviceRunner.waitForPageToLoad();
		serviceRunner.verifyServiceRunnerIsPresent(serviceRunnerName);
		serviceRunner.selectServiceRunner(serviceRunnerName);
		serviceRunner.selectServiceRunner(serviceRunnerName);
		serviceRunner.selectServiceRunner(serviceRunnerName);
		commonFunctions.selectLocalAction("Delete Service Runner");
		commonFunctions.acceptAlert();
		serviceRunner.waitForPageToLoad();
		serviceRunner.verifyServiceRunnerIsNotPresent(serviceRunnerName);
	}
	
	@Test(description="Verify functionality of Cancel button on Delete Delete Service Runner popup")
	public void Grid_4241()
	{
		serviceRunner.clickAddServiceRunnerButton();
		serviceRunner.setServiceRunnerName(serviceRunnerName);
		serviceRunner.getCurrentWindowHandle();
		serviceRunner.clickAddOnPopup();
		serviceRunner.switchToNewlyOpenedWindow();
		serviceRunner.clickSaveButton();
		serviceRunner.switchToParentWindow();
		serviceRunner.waitForPageToLoad();
		serviceRunner.verifyServiceRunnerIsPresent(serviceRunnerName);
		serviceRunner.selectServiceRunner(serviceRunnerName);
		serviceRunner.selectServiceRunner(serviceRunnerName);
		serviceRunner.selectServiceRunner(serviceRunnerName);
		commonFunctions.selectLocalAction("Delete Service Runner");
		commonFunctions.dismissAlert();
		serviceRunner.waitForPageToLoad();
		serviceRunner.verifyServiceRunnerIsPresent(serviceRunnerName);
	}
	
	@Test(description="Verify functionality of Export Service Runner local action")
	public void Grid_4242()
	{
		serviceRunner.clickAddServiceRunnerButton();
		serviceRunner.setServiceRunnerName(serviceRunnerName);
		serviceRunner.getCurrentWindowHandle();
		serviceRunner.clickAddOnPopup();
		serviceRunner.switchToNewlyOpenedWindow();
		serviceRunner.clickSaveButton();
		serviceRunner.switchToParentWindow();
		serviceRunner.waitForPageToLoad();
		serviceRunner.verifyServiceRunnerIsPresent(serviceRunnerName);
		serviceRunner.selectServiceRunner(serviceRunnerName);
		serviceRunner.selectServiceRunner(serviceRunnerName);
		serviceRunner.selectServiceRunner(serviceRunnerName);
		//commonFunctions.selectLocalAction("Export Service Runner");
		//serviceRunner.exportServiceRunner();
		//serviceRunner.waitForPageToLoad();
	}
	
	@Test(description="Verify functionality of Launch Service Runner global action")
	public void Grid_4243()
	{
		serviceRunner.clickAddServiceRunnerButton();
		serviceRunner.setServiceRunnerName(serviceRunnerName);
		serviceRunner.getCurrentWindowHandle();
		serviceRunner.clickAddOnPopup();
		serviceRunner.switchToNewlyOpenedWindow();
		serviceRunner.clickSaveButton();
		serviceRunner.switchToParentWindow();
		serviceRunner.waitForPageToLoad();
		serviceRunner.verifyServiceRunnerIsPresent(serviceRunnerName);
		serviceRunner.selectServiceRunner(serviceRunnerName);
		serviceRunner.selectServiceRunner(serviceRunnerName);
		serviceRunner.selectServiceRunner(serviceRunnerName);
		commonFunctions.selectLocalAction("Launch Service Runner");
		serviceRunner.verifyServiceSessionAdminPageIsLaunched();
	}
	
}
