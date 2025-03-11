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
import com.tibco.automation.page.services.batch.BatchDefinitionPage;

public class BatchDefinition extends WebDriverTestCase{
	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public TemplatePage templatepage;
	public BatchDefinitionPage batchDefinitions;
	public CommonFunctions commonFunctions;
	public String definitionName;
	public String description;
	public String renameDefinition;
	public String copyDefinition;
	
	@BeforeMethod
	public void beforeMethod()
	{
		batchDefinitions=new BatchDefinitionPage();
		commonFunctions=new CommonFunctions();
		batchDefinitions.launchPage();
		batchDefinitions.waitForPageToLoad();
		definitionName=RandomStringGenerator.get(5, RandomizerTypes.MIXED);
		description="description"+definitionName;
		renameDefinition="rename"+definitionName;
		copyDefinition="copy"+definitionName;
	}
	
	@Test(description="Verify functionality of Add button on batch definition page")
	public void Grid_4197()
	{
		batchDefinitions.clickAddDefinitionButton();
		batchDefinitions.setDefinitionName(definitionName);
		batchDefinitions.getCurrentWindowHandle();
		batchDefinitions.clickAddOnPopup();
		batchDefinitions.switchToNewlyOpenedWindow();
		batchDefinitions.clickSaveButton();
		batchDefinitions.switchToParentWindow();
		batchDefinitions.waitForPageToLoad();
		batchDefinitions.verifyDefinitionIsPresent(definitionName);
	}
	
	@Test(description="Verify functionality of Cancel button on batch definition popup")
	public void Grid_4199()
	{
		batchDefinitions.clickAddDefinitionButton();
		batchDefinitions.setDefinitionName(definitionName);
		batchDefinitions.getCurrentWindowHandle();
		batchDefinitions.clickCancelOnPopup();
		batchDefinitions.waitForPageToLoad();
		batchDefinitions.verifyDefinitionIsNotPresent(definitionName);
	}
	
	@Test(description="Verify functionality of Cancel button on add batch definition page")
	public void Grid_4201()
	{
		batchDefinitions.clickAddDefinitionButton();
		batchDefinitions.setDefinitionName(definitionName);
		batchDefinitions.getCurrentWindowHandle();
		batchDefinitions.clickAddOnPopup();
		batchDefinitions.switchToNewlyOpenedWindow();
		batchDefinitions.clickCancelOnPage();
		batchDefinitions.switchToParentWindow();
		batchDefinitions.clickCancelOnPopup();
		batchDefinitions.waitForPageToLoad();
		batchDefinitions.verifyDefinitionIsNotPresent(definitionName);
	}
	
	
	@Test(description="verify selecting a Batch Definition enables the local action")
	public void Grid_4203()
	{
		batchDefinitions.clickAddDefinitionButton();
		batchDefinitions.setDefinitionName(definitionName);
		batchDefinitions.getCurrentWindowHandle();
		batchDefinitions.clickAddOnPopup();
		batchDefinitions.switchToNewlyOpenedWindow();
		batchDefinitions.clickSaveButton();
		batchDefinitions.switchToParentWindow();
		batchDefinitions.waitForPageToLoad();
		batchDefinitions.verifyDefinitionIsPresent(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		commonFunctions.verifyLocalActionLinkIsPresent();
	}
	
	@Test(description="verify deselecting a Batch Definition disables the local action")
	public void Grid_4697()
	{
		batchDefinitions.clickAddDefinitionButton();
		batchDefinitions.setDefinitionName(definitionName);
		batchDefinitions.getCurrentWindowHandle();
		batchDefinitions.clickAddOnPopup();
		batchDefinitions.switchToNewlyOpenedWindow();
		batchDefinitions.clickSaveButton();
		batchDefinitions.switchToParentWindow();
		batchDefinitions.waitForPageToLoad();
		batchDefinitions.verifyDefinitionIsPresent(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		commonFunctions.verifyGlobalActionLinkIsPresent();
	}
	
	@Test(description="Verify functionality of View/Edit Batch definition local action")
	public void Grid_4204()
	{
		batchDefinitions.clickAddDefinitionButton();
		batchDefinitions.setDefinitionName(definitionName);
		batchDefinitions.getCurrentWindowHandle();
		batchDefinitions.clickAddOnPopup();
		batchDefinitions.switchToNewlyOpenedWindow();
		batchDefinitions.clickSaveButton();
		batchDefinitions.switchToParentWindow();
		batchDefinitions.waitForPageToLoad();
		batchDefinitions.verifyDefinitionIsPresent(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.getCurrentWindowHandle();
		commonFunctions.selectLocalAction("View/Edit Batch Definition");
		batchDefinitions.switchToNewlyOpenedWindow();
		batchDefinitions.fillDescription(description);
		batchDefinitions.clickSaveButton();
		batchDefinitions.switchToParentWindow();
		batchDefinitions.verifyDescriptionIsPresent(definitionName,description);
	}
	
	@Test(description="Verify functionality of Cancel button on View/Edit Batch definition popup")
	public void Grid_4206()
	{
		batchDefinitions.clickAddDefinitionButton();
		batchDefinitions.setDefinitionName(definitionName);
		batchDefinitions.getCurrentWindowHandle();
		batchDefinitions.clickAddOnPopup();
		batchDefinitions.switchToNewlyOpenedWindow();
		batchDefinitions.clickSaveButton();
		batchDefinitions.switchToParentWindow();
		batchDefinitions.waitForPageToLoad();
		batchDefinitions.verifyDefinitionIsPresent(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.getCurrentWindowHandle();
		commonFunctions.selectLocalAction("View/Edit Batch Definition");
		batchDefinitions.switchToNewlyOpenedWindow();
		batchDefinitions.fillDescription(description);
		batchDefinitions.clickCancelOnPage();
		batchDefinitions.switchToParentWindow();
		batchDefinitions.waitForPageToLoad();
		batchDefinitions.verifyDescriptionIsNotPresent(definitionName,description);
	}
	
	@Test(description="Verify functionality of Rename Batch Definition local action")
	public void Grid_4208()
	{
		batchDefinitions.clickAddDefinitionButton();
		batchDefinitions.setDefinitionName(definitionName);
		batchDefinitions.getCurrentWindowHandle();
		batchDefinitions.clickAddOnPopup();
		batchDefinitions.switchToNewlyOpenedWindow();
		batchDefinitions.clickSaveButton();
		batchDefinitions.switchToParentWindow();
		batchDefinitions.waitForPageToLoad();
		batchDefinitions.verifyDefinitionIsPresent(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.getCurrentWindowHandle();
		commonFunctions.selectLocalAction("Rename Batch Definition");
		batchDefinitions.updateDefinitionName(renameDefinition);
		batchDefinitions.clickSaveOnBatchDefinitionUpdatePopup();
		batchDefinitions.waitForPageToLoad();
		batchDefinitions.verifyDefinitionIsPresent(renameDefinition);
	}
	
	@Test(description="Verify functionality of Cancel button on Rename Batch definition popup")
	public void Grid_4210()
	{
		batchDefinitions.clickAddDefinitionButton();
		batchDefinitions.setDefinitionName(definitionName);
		batchDefinitions.getCurrentWindowHandle();
		batchDefinitions.clickAddOnPopup();
		batchDefinitions.switchToNewlyOpenedWindow();
		batchDefinitions.clickSaveButton();
		batchDefinitions.switchToParentWindow();
		batchDefinitions.waitForPageToLoad();
		batchDefinitions.verifyDefinitionIsPresent(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.getCurrentWindowHandle();
		commonFunctions.selectLocalAction("Rename Batch Definition");
		batchDefinitions.updateDefinitionName(renameDefinition);
		batchDefinitions.clickCancelOnBatchDefinitionUpdatePopup();
		batchDefinitions.waitForPageToLoad();
		batchDefinitions.verifyDefinitionIsNotPresent(renameDefinition);
	}
	

	@Test(description="Verify functionality of Copy Batch Definition local action")
	public void Grid_4211()
	{
		batchDefinitions.clickAddDefinitionButton();
		batchDefinitions.setDefinitionName(definitionName);
		batchDefinitions.getCurrentWindowHandle();
		batchDefinitions.clickAddOnPopup();
		batchDefinitions.switchToNewlyOpenedWindow();
		batchDefinitions.clickSaveButton();
		batchDefinitions.switchToParentWindow();
		batchDefinitions.waitForPageToLoad();
		batchDefinitions.verifyDefinitionIsPresent(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.getCurrentWindowHandle();
		commonFunctions.selectLocalAction("Copy Batch Definition");
		batchDefinitions.updateDefinitionName(copyDefinition);
		batchDefinitions.clickSaveOnBatchDefinitionUpdatePopup();
		batchDefinitions.waitForPageToLoad();
		batchDefinitions.verifyDefinitionIsPresent(copyDefinition);
	}
	
	@Test(description="Verify functionality of Cancel button on Copy Batch definition popup")
	public void Grid_4213()
	{
		batchDefinitions.clickAddDefinitionButton();
		batchDefinitions.setDefinitionName(definitionName);
		batchDefinitions.getCurrentWindowHandle();
		batchDefinitions.clickAddOnPopup();
		batchDefinitions.switchToNewlyOpenedWindow();
		batchDefinitions.clickSaveButton();
		batchDefinitions.switchToParentWindow();
		batchDefinitions.waitForPageToLoad();
		batchDefinitions.verifyDefinitionIsPresent(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.getCurrentWindowHandle();
		commonFunctions.selectLocalAction("Copy Batch Definition");
		batchDefinitions.updateDefinitionName(copyDefinition);
		batchDefinitions.clickCancelOnBatchDefinitionUpdatePopup();
		batchDefinitions.waitForPageToLoad();
		batchDefinitions.verifyDefinitionIsNotPresent(copyDefinition);
	}
	
	
	@Test(description="Verify functionality of Delete Batch Definition local action")
	public void Grid_4214()
	{
		batchDefinitions.clickAddDefinitionButton();
		batchDefinitions.setDefinitionName(definitionName);
		batchDefinitions.getCurrentWindowHandle();
		batchDefinitions.clickAddOnPopup();
		batchDefinitions.switchToNewlyOpenedWindow();
		batchDefinitions.clickSaveButton();
		batchDefinitions.switchToParentWindow();
		batchDefinitions.waitForPageToLoad();
		batchDefinitions.verifyDefinitionIsPresent(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.getCurrentWindowHandle();
		commonFunctions.selectLocalAction("Delete Batch Definition");
		commonFunctions.acceptAlert();
		batchDefinitions.waitForPageToLoad();
		batchDefinitions.verifyDefinitionIsNotPresent(definitionName);
	}
	
	@Test(description="Verify functionality of Cancel button on Delete Batch definition popup")
	public void Grid_4216()
	{
		batchDefinitions.clickAddDefinitionButton();
		batchDefinitions.setDefinitionName(definitionName);
		batchDefinitions.getCurrentWindowHandle();
		batchDefinitions.clickAddOnPopup();
		batchDefinitions.switchToNewlyOpenedWindow();
		batchDefinitions.clickSaveButton();
		batchDefinitions.switchToParentWindow();
		batchDefinitions.waitForPageToLoad();
		batchDefinitions.verifyDefinitionIsPresent(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.getCurrentWindowHandle();
		commonFunctions.selectLocalAction("Delete Batch Definition");
		commonFunctions.dismissAlert();
		batchDefinitions.waitForPageToLoad();
		batchDefinitions.verifyDefinitionIsPresent(definitionName);
	}
	
	
	@Test(description="Verify functionality of Export Batch Definition local action")
	public void Grid_4217()
	{
		batchDefinitions.clickAddDefinitionButton();
		batchDefinitions.setDefinitionName(definitionName);
		batchDefinitions.getCurrentWindowHandle();
		batchDefinitions.clickAddOnPopup();
		batchDefinitions.switchToNewlyOpenedWindow();
		batchDefinitions.clickSaveButton();
		batchDefinitions.switchToParentWindow();
		batchDefinitions.waitForPageToLoad();
		batchDefinitions.verifyDefinitionIsPresent(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		//batchDefinitions.getCurrentWindowHandle();
		/*commonFunctions.selectLocalAction("Export Batch Definition");
		batchDefinitions.exportDefinition();
		batchDefinitions.switchToParentWindow();*/
	}
	
	
	@Test(description="Verify functionality of Schedule Batch Definition local action")
	public void Grid_4218()
	{
		batchDefinitions.clickAddDefinitionButton();
		batchDefinitions.setDefinitionName(definitionName);
		batchDefinitions.getCurrentWindowHandle();
		batchDefinitions.clickAddOnPopup();
		batchDefinitions.switchToNewlyOpenedWindow();
		batchDefinitions.clickSaveButton();
		batchDefinitions.switchToParentWindow();
		batchDefinitions.waitForPageToLoad();
		batchDefinitions.verifyDefinitionIsPresent(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.getCurrentWindowHandle();
		commonFunctions.selectLocalAction("Schedule Batch Definition");
		batchDefinitions.waitForPageToLoad();
		batchDefinitions.verifyBatchSchedulePageIsLaunched();
	}
	
	
	@Test(description="Verify functionality of Batch View local action")
	public void Grid_4219()
	{
		batchDefinitions.clickAddDefinitionButton(); 
		batchDefinitions.setDefinitionName(definitionName);
		batchDefinitions.getCurrentWindowHandle();
		batchDefinitions.clickAddOnPopup();
		batchDefinitions.switchToNewlyOpenedWindow();
		batchDefinitions.clickSaveButton();
		batchDefinitions.switchToParentWindow();
		batchDefinitions.waitForPageToLoad();
		batchDefinitions.verifyDefinitionIsPresent(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.selectDefinition(definitionName);
		batchDefinitions.getCurrentWindowHandle();
		commonFunctions.selectLocalAction("Batch View");
		batchDefinitions.switchToNewlyOpenedWindow();
		batchDefinitions.verifyBatchViewIsLaunched();
		batchDefinitions.switchToParentWindow();
		batchDefinitions.waitForPageToLoad();
	}
}
