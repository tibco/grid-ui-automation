package com.tibco.automation.test.gsui.gridcomponents.brokers;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import com.tibco.automation.common.utils.RandomStringGenerator;
import com.tibco.automation.common.utils.RandomStringGenerator.RandomizerTypes;
import com.tibco.automation.page.common.CommonFunctions;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.gridcomponents.brokers.BrokerConfigurationPage;

public class BrokerConfiguration extends WebDriverTestCase{
	
	
	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public TemplatePage templatepage;
	public BrokerConfigurationPage brokerConfig;
	public CommonFunctions commonFunctions;
	
	@BeforeMethod
	public void beforeMethod()
	{
		brokerConfig=new BrokerConfigurationPage();
		commonFunctions=new CommonFunctions();
		brokerConfig.launchPage();
		brokerConfig.waitForPageToLoad();
	}
	
	@Test(description="Verify add columns option is present on page.")
	public void Grid_3797()
	{
		brokerConfig.verifyAddColumnIsPresent();
	}
	
	@Test(description="Verify user is able to add columns after clicking on save button.")
	public void Grid_3798()
	{
		brokerConfig.verifyAddColumnIsPresent();
		brokerConfig.clickAddColumn();
		brokerConfig.addNewColumn("Max Engines");
		brokerConfig.clickSaveOnAddColumn();
		brokerConfig.waitForPageToLoad();
		brokerConfig.verifyColumnPresent("Max Engines");
		brokerConfig.clickAddColumn();
		brokerConfig.removeColumn("Max Engines");
		brokerConfig.clickSaveOnAddColumn();
		brokerConfig.waitForPageToLoad();
		brokerConfig.verifyColumnNotPresent("Max Engines");
	}
	
	@Test(description="Verify the functionality of revert button add columns popup.")
	public void Grid_3799()
	{
		brokerConfig.verifyAddColumnIsPresent();
		brokerConfig.clickAddColumn();
		brokerConfig.addNewColumn("Max Engines");
		brokerConfig.clickSaveOnAddColumn();
		brokerConfig.waitForPageToLoad();
		brokerConfig.verifyColumnPresent("Max Engines");
		brokerConfig.clickAddColumn();
		brokerConfig.clickRevertOnAddColumn();
		brokerConfig.clickSaveOnAddColumn();
		brokerConfig.waitForPageToLoad();
		brokerConfig.verifyColumnNotPresent("Max Engines");
	}
	
	@Test(description="Verify simple search using brokerID")
	public void Grid_3800()
	{
		commonFunctions.performSimpleSearch("Broker ID", "invalidID");
		brokerConfig.waitForPageToLoad();
		brokerConfig.verifySearchResult("0");
		commonFunctions.clearSearchResults();
	}
	
	@Test(description="Verify query search using broker name.")
	public void Grid_3801()
	{
		commonFunctions.performQuerySearch("\"Broker Name\" matches \"testname\"");
		brokerConfig.waitForPageToLoad();
		brokerConfig.verifySearchResult("0");
		commonFunctions.clearSearchResults();
	}
	
	@Test(description="Verify query builder search using URL.")
	public void Grid_3802()
	{
		commonFunctions.performQueryBuilderSearch("URL", "matches", "invalidURL");
		commonFunctions.clickSearchOnQueryBuilder();
		brokerConfig.waitForPageToLoad();
		brokerConfig.verifySearchResult("0");
		commonFunctions.clearSearchResults();
		
	}
	
	@Test(description="verify change in results per page value changes the number of rows in table.")
	public void Grid_3803()
	{
		brokerConfig.updateAndVerifyResultsPerPage(1);
	}
	
	@Test(description="Verify functionality of next page button in pagination.")
	public void Grid_3804()
	{
		brokerConfig.updateAndVerifyResultsPerPage(1);
		brokerConfig.waitForPageToLoad();
		commonFunctions.goToNextPage();
	}
	
	@Test(description="Verify functionality of previous page button in pagination")
	public void Grid_3805()
	{
		brokerConfig.updateAndVerifyResultsPerPage(1);
		brokerConfig.waitForPageToLoad();
		commonFunctions.goToNextPage();
		brokerConfig.waitForPageToLoad();
		commonFunctions.goToPreviousPage();
	}
	
	@Test(description="Verify functionality of move to first page button.")
	public void Grid_3806()
	{
		brokerConfig.updateAndVerifyResultsPerPage(1);
		brokerConfig.waitForPageToLoad();
		commonFunctions.goToNextPage();
		brokerConfig.waitForPageToLoad();
		commonFunctions.goToNextPage();
		brokerConfig.waitForPageToLoad();
		commonFunctions.goToFirstPage();
	}
	
	@Test(description="Verify functionality of move to last page button.")
	public void Grid_3807()
	{
		brokerConfig.updateAndVerifyResultsPerPage(1);
		brokerConfig.waitForPageToLoad();
		commonFunctions.goToNextPage();
		brokerConfig.waitForPageToLoad();
		commonFunctions.goToPreviousPage();
		brokerConfig.waitForPageToLoad();
		commonFunctions.goToLastPage();
	}
	
	@Test(description="Verify functionality of save button after updating a value.")
	public void Grid_3808()
	{
		String brokerName="b"+RandomStringGenerator.get(3, RandomizerTypes.MIXED);
		String existingName=brokerConfig.updateBrokerName(brokerName);
		brokerConfig.clickSaveButton();
		brokerConfig.waitForPageToLoad();
		
	}
	
	@Test(description="verify functionality of revert button after updating a value.")
	public void Grid_3809()
	{
		String brokerName="b"+RandomStringGenerator.get(3, RandomizerTypes.MIXED);
		brokerConfig.updateBrokerName(brokerName);
		brokerConfig.clickResetButton();
		brokerConfig.waitForPageToLoad();
		brokerConfig.verifyBrokerNameIsNotUpdated(brokerName);
	}
	
	@Test(description="Verify purge broker functionality for an offline broker.")
	public void Grid_4790()
	{
		brokerConfig.updateResultsPerPage(20);
		brokerConfig.selectFirstOfflineBroker();
		commonFunctions.selectLocalAction("Purge Broker");
		brokerConfig.waitForPageToLoad();
	}
}
