package com.tibco.automation.test.gsui.services.services;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import com.tibco.automation.common.utils.RandomStringGenerator;
import com.tibco.automation.common.utils.RandomStringGenerator.RandomizerTypes;
import com.tibco.automation.page.common.CommonFunctions;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.services.services.ServiceConditionsPage;

public class ServiceConditions extends WebDriverTestCase{
	
	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public TemplatePage templatepage;
	public ServiceConditionsPage serviceConditions;
	public CommonFunctions commonFunctions;
	public String conditionName;
	public String copiedConditionName;
	public String renameConditionName;
	
	@BeforeMethod
	public void beforeMethod()
	{
		serviceConditions=new ServiceConditionsPage();
		commonFunctions=new CommonFunctions();
		serviceConditions.launchPage();
		serviceConditions.waitForPageToLoad();
		conditionName=RandomStringGenerator.get(5, RandomizerTypes.MIXED);
		copiedConditionName="copy"+conditionName;
		renameConditionName="rename"+conditionName;
	}
	
	@Test(description="Verify the functionality of Add columns option")
	public void Grid_3852()
	{
		serviceConditions.verifyAddColumnIsPresent();
		serviceConditions.clickAddColumn();
		serviceConditions.waitForPageToLoad();
		serviceConditions.removeColumn("Name");
		serviceConditions.clickSaveOnAddColumn();
		serviceConditions.waitForPageToLoad();
		serviceConditions.verifyColumnNotPresent("Name");
		serviceConditions.clickAddColumn();
		serviceConditions.waitForPageToLoad();
		serviceConditions.addNewColumn("Name");
		serviceConditions.clickSaveOnAddColumn();
		serviceConditions.waitForPageToLoad();
		serviceConditions.verifyColumnPresent("Name");
		
	}
	
	@Test(description="Verify the functionality of Revert button of add column popup")
	public void Grid_3854()
	{
		serviceConditions.verifyAddColumnIsPresent();
		serviceConditions.clickAddColumn();
		serviceConditions.waitForPageToLoad();
		serviceConditions.removeColumn("Name");
		serviceConditions.clickSaveOnAddColumn();
		serviceConditions.waitForPageToLoad();
		serviceConditions.verifyColumnNotPresent("Name");
		serviceConditions.clickAddColumn();
		serviceConditions.waitForPageToLoad();
		serviceConditions.clickRevertOnAddColumn();
		serviceConditions.clickSaveOnAddColumn();
		serviceConditions.verifyColumnPresent("Name");
	}
	
	@Test(description="verify the functionality of Add Service condition button")
	public void Grid_3855()
	{
		serviceConditions.setConditionNameAndType(conditionName, "Affinity");
		serviceConditions.getCurrentWindowHandle();
		serviceConditions.clickAddButton();
		serviceConditions.waitForPageToLoad();
		serviceConditions.switchToNewlyOpenedWindow();
		commonFunctions.maximizeCurrentWindow();
		serviceConditions.clickSaveButton();
		commonFunctions.acceptAlert();
		//serviceConditions.waitForPageToLoad();
		serviceConditions.switchToParentWindow();
		serviceConditions.waitForPageToLoad();
		serviceConditions.verifyConditionIsPresent(conditionName);
	}

	
	@Test(description="Verify the functionality of Cancel button of Add Service Condition popup")
	public void Grid_3858()
	{
		serviceConditions.setConditionNameAndType(conditionName, "Affinity");
		serviceConditions.getCurrentWindowHandle();
		serviceConditions.clickAddButton();
		serviceConditions.waitForPageToLoad();
		serviceConditions.switchToNewlyOpenedWindow();
		commonFunctions.maximizeCurrentWindow();
		serviceConditions.waitForPageToLoad();
		serviceConditions.clickCancelButton();
		serviceConditions.switchToParentWindow();
		serviceConditions.waitForPageToLoad();
		serviceConditions.verifyConditionIsNotPresent(conditionName);
	}
	
	@Test(description="Verify selecting Service Condition enables local action")
	public void Grid_3860()
	{
		serviceConditions.setConditionNameAndType(conditionName, "Affinity");
		serviceConditions.getCurrentWindowHandle();
		serviceConditions.clickAddButton();
		serviceConditions.waitForPageToLoad();
		serviceConditions.switchToNewlyOpenedWindow();
		commonFunctions.maximizeCurrentWindow();
		serviceConditions.waitForPageToLoad();
		serviceConditions.clickSaveButton();
		commonFunctions.acceptAlert();
		//serviceConditions.waitForPageToLoad();
		serviceConditions.switchToParentWindow();
		serviceConditions.waitForPageToLoad();
		serviceConditions.verifyConditionIsPresent(conditionName);
		serviceConditions.selectConditionCheckbox(conditionName);
		serviceConditions.selectConditionCheckbox(conditionName);
		serviceConditions.selectConditionCheckbox(conditionName);
		commonFunctions.verifyLocalActionLinkIsPresent();
	}
	
	@Test(description="Verify deselecting Service Condition disables local action")
	public void Grid_3861()
	{
		serviceConditions.setConditionNameAndType(conditionName, "Affinity");
		serviceConditions.getCurrentWindowHandle();
		serviceConditions.clickAddButton();
		serviceConditions.waitForPageToLoad();
		serviceConditions.switchToNewlyOpenedWindow();
		commonFunctions.maximizeCurrentWindow();
		serviceConditions.waitForPageToLoad();
		serviceConditions.clickSaveButton();
		commonFunctions.acceptAlert();
		//serviceConditions.waitForPageToLoad();
		serviceConditions.switchToParentWindow();
		serviceConditions.waitForPageToLoad();
		serviceConditions.verifyConditionIsPresent(conditionName);
		serviceConditions.selectConditionCheckbox(conditionName);
		serviceConditions.selectConditionCheckbox(conditionName);
		serviceConditions.selectConditionCheckbox(conditionName);
		serviceConditions.selectConditionCheckbox(conditionName);
		commonFunctions.verifyGlobalActionLinkIsPresent();
	}
	
	@Test(description="Verify change in results per page value changes the number of rows in table.")
	public void Grid_3862()
	{
		serviceConditions.setConditionNameAndType(conditionName, "Affinity");
		serviceConditions.getCurrentWindowHandle();
		serviceConditions.clickAddButton();
		serviceConditions.waitForPageToLoad();
		serviceConditions.switchToNewlyOpenedWindow();
		commonFunctions.maximizeCurrentWindow();
		serviceConditions.waitForPageToLoad();
		serviceConditions.clickSaveButton();
		commonFunctions.acceptAlert();
		//serviceConditions.waitForPageToLoad();
		serviceConditions.switchToParentWindow();
		serviceConditions.waitForPageToLoad();
		serviceConditions.verifyConditionIsPresent(conditionName);
		commonFunctions.updateAndVerifyResultsPerPage(1);
		serviceConditions.waitForPageToLoad();
		commonFunctions.updateResultsPerPage(20);
		serviceConditions.waitForPageToLoad();
	}
	
	
	
	@Test(description="Verify the functionality of Cancel button of Edit Affinity/Discriminator popup.")
	public void Grid_3866()
	{
		serviceConditions.setConditionNameAndType(conditionName, "Affinity");
		serviceConditions.getCurrentWindowHandle();
		serviceConditions.clickAddButton();
		serviceConditions.waitForPageToLoad();
		serviceConditions.switchToNewlyOpenedWindow();
		commonFunctions.maximizeCurrentWindow();
		serviceConditions.clickSaveButton();
		commonFunctions.acceptAlert();
		//serviceConditions.waitForPageToLoad();
		serviceConditions.switchToParentWindow();
		serviceConditions.waitForPageToLoad();
		serviceConditions.verifyConditionIsPresent(conditionName);
		serviceConditions.selectConditionCheckbox(conditionName);
		serviceConditions.selectConditionCheckbox(conditionName);
		serviceConditions.selectConditionCheckbox(conditionName);
		serviceConditions.getCurrentWindowHandle();
		commonFunctions.selectLocalAction("Edit Affinity");
		serviceConditions.waitForPageToLoad();
		serviceConditions.switchToNewlyOpenedWindow();
		commonFunctions.maximizeCurrentWindow();
		serviceConditions.waitForPageToLoad();
		serviceConditions.clickCancelButton();
		serviceConditions.switchToParentWindow();
		serviceConditions.waitForPageToLoad();
	}
	
	@Test(description="Verify the functionality of local action Copy Affinity/Discriminator")
	public void Grid_3868()
	{
		serviceConditions.setConditionNameAndType(conditionName, "Affinity");
		serviceConditions.getCurrentWindowHandle();
		serviceConditions.clickAddButton();
		serviceConditions.waitForPageToLoad();
		serviceConditions.switchToNewlyOpenedWindow();
		commonFunctions.maximizeCurrentWindow();
		serviceConditions.waitForPageToLoad();
		serviceConditions.clickSaveButton();
		commonFunctions.acceptAlert();
		//serviceConditions.waitForPageToLoad();
		serviceConditions.switchToParentWindow();
		serviceConditions.waitForPageToLoad();
		serviceConditions.verifyConditionIsPresent(conditionName);
		serviceConditions.selectConditionCheckbox(conditionName);
		serviceConditions.selectConditionCheckbox(conditionName);
		serviceConditions.selectConditionCheckbox(conditionName);
		serviceConditions.getCurrentWindowHandle();
		commonFunctions.selectLocalAction("Copy Affinity");
		serviceConditions.setNewConditionName(copiedConditionName);
		serviceConditions.clickSaveOnPopup();
		serviceConditions.waitForPageToLoad();
		serviceConditions.verifyConditionIsPresent(copiedConditionName);
	}
	
	@Test(description="Verify the functionality of Cancel button of Copy Affinity/Discriminator popup.")
	public void Grid_3869()
	{
		serviceConditions.setConditionNameAndType(conditionName, "Affinity");
		serviceConditions.getCurrentWindowHandle();
		serviceConditions.clickAddButton();
		serviceConditions.waitForPageToLoad();
		serviceConditions.switchToNewlyOpenedWindow();
		commonFunctions.maximizeCurrentWindow();
		serviceConditions.clickSaveButton();
		commonFunctions.acceptAlert();
		//serviceConditions.waitForPageToLoad();
		serviceConditions.switchToParentWindow();
		serviceConditions.waitForPageToLoad();
		serviceConditions.verifyConditionIsPresent(conditionName);
		serviceConditions.selectConditionCheckbox(conditionName);
		serviceConditions.selectConditionCheckbox(conditionName);
		serviceConditions.selectConditionCheckbox(conditionName);
		serviceConditions.getCurrentWindowHandle();
		commonFunctions.selectLocalAction("Copy Affinity");
		serviceConditions.setNewConditionName(copiedConditionName);
		serviceConditions.clickCancelOnPopup();
		serviceConditions.waitForPageToLoad();
		serviceConditions.verifyConditionIsNotPresent(copiedConditionName);
	}
	
	
	@Test(description="Verify the functionality of local action Rename Affinity/Discriminator")
	public void Grid_3870()
	{
		serviceConditions.setConditionNameAndType(conditionName, "Affinity");
		serviceConditions.getCurrentWindowHandle();
		serviceConditions.clickAddButton();
		serviceConditions.waitForPageToLoad();
		serviceConditions.switchToNewlyOpenedWindow();
		commonFunctions.maximizeCurrentWindow();
		serviceConditions.clickSaveButton();
		commonFunctions.acceptAlert();
		//serviceConditions.waitForPageToLoad();
		serviceConditions.switchToParentWindow();
		serviceConditions.waitForPageToLoad();
		serviceConditions.verifyConditionIsPresent(conditionName);
		serviceConditions.selectConditionCheckbox(conditionName);
		serviceConditions.selectConditionCheckbox(conditionName);
		serviceConditions.selectConditionCheckbox(conditionName);
		serviceConditions.getCurrentWindowHandle();
		commonFunctions.selectLocalAction("Rename Affinity");
		serviceConditions.setNewConditionName(renameConditionName);
		serviceConditions.clickSaveOnPopup();
		serviceConditions.waitForPageToLoad();
		serviceConditions.verifyConditionIsPresent(renameConditionName);
	}
	
	
	@Test(description="Verify the functionality of Cancel button of Rename Affinity/Discriminator popup.")
	public void Grid_3871()
	{
		serviceConditions.setConditionNameAndType(conditionName, "Affinity");
		serviceConditions.getCurrentWindowHandle();
		serviceConditions.clickAddButton();
		serviceConditions.waitForPageToLoad();
		serviceConditions.switchToNewlyOpenedWindow();
		commonFunctions.maximizeCurrentWindow();
		serviceConditions.clickSaveButton();
		commonFunctions.acceptAlert();
		//serviceConditions.waitForPageToLoad();
		serviceConditions.switchToParentWindow();
		serviceConditions.waitForPageToLoad();
		serviceConditions.verifyConditionIsPresent(conditionName);
		serviceConditions.selectConditionCheckbox(conditionName);
		serviceConditions.selectConditionCheckbox(conditionName);
		serviceConditions.selectConditionCheckbox(conditionName);
		serviceConditions.getCurrentWindowHandle();
		commonFunctions.selectLocalAction("Rename Affinity");
		serviceConditions.setNewConditionName(renameConditionName);
		serviceConditions.clickCancelOnPopup();
		serviceConditions.waitForPageToLoad();
		serviceConditions.verifyConditionIsNotPresent(renameConditionName);
	}
	
	@Test(description="Verify the functionality of local action Remove Discriminator/Affinity.")
	public void Grid_3872()
	{
		serviceConditions.setConditionNameAndType(conditionName, "Affinity");
		serviceConditions.getCurrentWindowHandle();
		serviceConditions.clickAddButton();
		serviceConditions.waitForPageToLoad();
		serviceConditions.switchToNewlyOpenedWindow();
		commonFunctions.maximizeCurrentWindow();
		serviceConditions.clickSaveButton();
		commonFunctions.acceptAlert();
		//serviceConditions.waitForPageToLoad();
		serviceConditions.switchToParentWindow();
		serviceConditions.waitForPageToLoad();
		serviceConditions.verifyConditionIsPresent(conditionName);
		serviceConditions.selectConditionCheckbox(conditionName);
		serviceConditions.selectConditionCheckbox(conditionName);
		serviceConditions.selectConditionCheckbox(conditionName);
		serviceConditions.getCurrentWindowHandle();
		commonFunctions.selectLocalAction("Remove Affinity");
		commonFunctions.acceptAlert();
		serviceConditions.waitForPageToLoad();
		serviceConditions.verifyConditionIsNotPresent(conditionName);
	}
	
	
	@Test(description="Verify the functionality of Cancel button of Remove Discriminator/Affinity popup.")
	public void Grid_3873()
	{
		serviceConditions.setConditionNameAndType(conditionName, "Affinity");
		serviceConditions.getCurrentWindowHandle();
		serviceConditions.clickAddButton();
		serviceConditions.waitForPageToLoad();
		serviceConditions.switchToNewlyOpenedWindow();
		commonFunctions.maximizeCurrentWindow();
		serviceConditions.clickSaveButton();
		commonFunctions.acceptAlert();
		//serviceConditions.waitForPageToLoad();
		serviceConditions.switchToParentWindow();
		serviceConditions.waitForPageToLoad();
		serviceConditions.verifyConditionIsPresent(conditionName);
		serviceConditions.selectConditionCheckbox(conditionName);
		serviceConditions.selectConditionCheckbox(conditionName);
		serviceConditions.selectConditionCheckbox(conditionName);
		//serviceConditions.getCurrentWindowHandle();
		commonFunctions.selectLocalAction("Remove Affinity");
		commonFunctions.dismissAlert();
		serviceConditions.waitForPageToLoad();
		serviceConditions.verifyConditionIsPresent(conditionName);
	}
	
	
	@Test(description="Verify functionality of next page button in pagination.")
	public void Grid_3874()
	{
		commonFunctions.updateAndVerifyResultsPerPage(1);
		serviceConditions.waitForPageToLoad();
		commonFunctions.goToNextPage();
		serviceConditions.waitForPageToLoad();
		commonFunctions.updateResultsPerPage(20);
		serviceConditions.waitForPageToLoad();
		
	}
	
	@Test(description="Verify functionality of previous page button in pagination")
	public void Grid_3875()
	{
		commonFunctions.updateAndVerifyResultsPerPage(1);
		serviceConditions.waitForPageToLoad();
		commonFunctions.goToNextPage();
		serviceConditions.waitForPageToLoad();
		commonFunctions.goToPreviousPage();
		serviceConditions.waitForPageToLoad();
		commonFunctions.updateResultsPerPage(20);
		serviceConditions.waitForPageToLoad();
	}
	
	
	@Test(description="Verify functionality of move to first page button.")
	public void Grid_3876()
	{
		commonFunctions.updateAndVerifyResultsPerPage(1);
		serviceConditions.waitForPageToLoad();
		commonFunctions.goToNextPage();
		serviceConditions.waitForPageToLoad();
		commonFunctions.goToNextPage();
		serviceConditions.waitForPageToLoad();
		commonFunctions.goToFirstPage();
		serviceConditions.waitForPageToLoad();
		commonFunctions.updateResultsPerPage(20);
		serviceConditions.waitForPageToLoad();
	}
	
	
	@Test(description="Verify functionality of move to last page button.")
	public void Grid_3877()
	{
		commonFunctions.updateAndVerifyResultsPerPage(1);
		serviceConditions.waitForPageToLoad();
		commonFunctions.goToNextPage();
		serviceConditions.waitForPageToLoad();
		commonFunctions.goToPreviousPage();
		serviceConditions.waitForPageToLoad();
		commonFunctions.goToLastPage();
		serviceConditions.waitForPageToLoad();
		commonFunctions.updateResultsPerPage(20);
		serviceConditions.waitForPageToLoad();
	}
	
	
	@Test(description="Verify Simple Search by name")
	public void Grid_3878()
	{
		commonFunctions.performSimpleSearch("Name", "invalidName");
		serviceConditions.waitForPageToLoad();
		serviceConditions.verifySearchResult("0");
		commonFunctions.clearSearchResults();
	}
	
	@Test(description="Verify Query search by description")
	public void Grid_3879()
	{
		commonFunctions.performQuerySearch("\"Description\" matches \"invalidDescription\"");
		serviceConditions.waitForPageToLoad();
		serviceConditions.verifySearchResult("0");
		commonFunctions.clearSearchResults();
	}
	
	
	@Test(description="Verify Query Builder search by type")
	public void Grid_3880()
	{
		commonFunctions.performQueryBuilderSearch("Type", "matches", "invalidType");
		commonFunctions.clickSearchOnQueryBuilder();
		serviceConditions.waitForPageToLoad();
		serviceConditions.verifySearchResult("0");
		commonFunctions.clearSearchResults();
	}
	
}
