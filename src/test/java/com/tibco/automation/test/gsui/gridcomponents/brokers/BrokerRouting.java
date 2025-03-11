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
import com.tibco.automation.page.gridcomponents.brokers.BrokerRoutingPage;

public class BrokerRouting extends WebDriverTestCase{

	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public TemplatePage templatepage;
	public BrokerRoutingPage brokerRouting;
	public CommonFunctions commonFunctions;
	public String engineValue;
	public String driverPropertyName;
	public String driverValue;
	public String editedEngineValue;
	public String editedDriverValue;
	
	@BeforeMethod
	public void beforeMethod()
	{
		brokerRouting=new BrokerRoutingPage();
		commonFunctions=new CommonFunctions();
		brokerRouting.launchPage();
		brokerRouting.waitForPageToLoad();
		engineValue=RandomStringGenerator.get(7, RandomizerTypes.MIXED);
		driverPropertyName=RandomStringGenerator.get(7, RandomizerTypes.MIXED);
		driverValue=RandomStringGenerator.get(5, RandomizerTypes.LETTERS_ONLY);
		editedEngineValue="edited"+RandomStringGenerator.get(3, RandomizerTypes.MIXED);
		editedDriverValue="edited"+RandomStringGenerator.get(3, RandomizerTypes.MIXED);
	}
	
	@Test(description="Verify functionality of edit button on broker routing page, add engine rules.")
	public void Grid_3913()
	{
		brokerRouting.clickEditButton();
		brokerRouting.waitForPageToLoad();
		brokerRouting.updateEngineProperty("IP");
		brokerRouting.updateEngineComparator("equals");
		brokerRouting.updateEngineValue(engineValue);
		brokerRouting.clickOnPlusIconOnEngineRules();
		brokerRouting.clickCancelButton();
		brokerRouting.waitForPageToLoad();
		brokerRouting.verifyValueNotPresent(engineValue);
		brokerRouting.clickEditButton();
		brokerRouting.waitForPageToLoad();
		brokerRouting.updateEngineProperty("IP");
		brokerRouting.updateEngineComparator("equals");
		brokerRouting.updateEngineValue(engineValue);
		brokerRouting.clickOnPlusIconOnEngineRules();
		brokerRouting.clickSaveButton();
		brokerRouting.waitForPageToLoad();
		brokerRouting.verifyValuePresent(engineValue);
		brokerRouting.clickEditButton();
		brokerRouting.waitForPageToLoad();
		brokerRouting.clickDeleteForRules(engineValue);
		brokerRouting.waitForPageToLoad();
		brokerRouting.clickSaveButton();
		brokerRouting.waitForPageToLoad();
		brokerRouting.verifyValueNotPresent(engineValue);
	}
	
	@Test(description="Verify functionality of edit button on broker routing page, add driver rules rules.")
	public void Grid_3914()
	{
		brokerRouting.clickEditButton();
		brokerRouting.waitForPageToLoad();
		brokerRouting.updateDriverProperty(driverPropertyName);
		brokerRouting.updateDriverComparator("equals");
		brokerRouting.updateDriverValue(driverValue);
		brokerRouting.clickOnPlusIconOnEngineRules();
		brokerRouting.clickCancelButton();
		brokerRouting.waitForPageToLoad();
		brokerRouting.verifyValueNotPresent(driverValue);
		brokerRouting.clickEditButton();
		brokerRouting.waitForPageToLoad();
		brokerRouting.updateDriverProperty(driverPropertyName);
		brokerRouting.updateDriverComparator("equals");
		brokerRouting.updateDriverValue(driverValue);
		brokerRouting.clickOnPlusIconOnDriverRules();
		brokerRouting.clickSaveButton();
		brokerRouting.waitForPageToLoad();
		brokerRouting.verifyValuePresent(driverValue);
	}
	
	@Test(description="Verify functionality of edit button for engine rules")
	public void Grid_4791()
	{
		brokerRouting.clickEditButton();
		brokerRouting.waitForPageToLoad();
		brokerRouting.updateEngineProperty("AMIAvailZone");
		brokerRouting.updateEngineComparator("equals");
		brokerRouting.updateEngineValue(engineValue);
		brokerRouting.clickOnPlusIconOnEngineRules();
		brokerRouting.clickSaveButton();
		brokerRouting.waitForPageToLoad();
		brokerRouting.verifyValuePresent(engineValue);
		brokerRouting.clickEditButton();
		brokerRouting.waitForPageToLoad();
		brokerRouting.clickEditForRules(engineValue);
		brokerRouting.clickCancelButton();
		brokerRouting.waitForPageToLoad();
		brokerRouting.clickEditButton();
		brokerRouting.waitForPageToLoad();
		brokerRouting.clickDeleteForRules(engineValue);
		brokerRouting.waitForPageToLoad();
		brokerRouting.clickSaveButton();
		brokerRouting.waitForPageToLoad();
		brokerRouting.verifyValueNotPresent(engineValue);

	}
	
	@Test(description="Verify functionality of save button on engine rule")
	public void Grid_4792()
	{
		brokerRouting.clickEditButton();
		brokerRouting.waitForPageToLoad();
		brokerRouting.updateEngineProperty("GridLibs");
		brokerRouting.updateEngineComparator("equals");
		brokerRouting.updateEngineValue(engineValue);
		brokerRouting.clickOnPlusIconOnEngineRules();
		brokerRouting.clickSaveButton();
		brokerRouting.waitForPageToLoad();
		brokerRouting.verifyValuePresent(engineValue);
		brokerRouting.clickEditButton();
		brokerRouting.waitForPageToLoad();
		brokerRouting.clickEditForRules(engineValue);
		brokerRouting.editEngineValue(editedEngineValue);
		brokerRouting.clickSaveForRules();
		brokerRouting.waitForPageToLoad();
		brokerRouting.clickSaveButton();
		brokerRouting.waitForPageToLoad();
		brokerRouting.verifyValuePresent(editedEngineValue);
		brokerRouting.clickEditButton();
		brokerRouting.waitForPageToLoad();
		brokerRouting.clickDeleteForRules(editedEngineValue);
		brokerRouting.waitForPageToLoad();
		brokerRouting.clickSaveButton();
		brokerRouting.waitForPageToLoad();
		brokerRouting.verifyValueNotPresent(editedEngineValue);
	}
	
	
	@Test(description="Verify functionality of delete button on engine rules")
	public void Grid_4793()
	{
		brokerRouting.clickEditButton();
		brokerRouting.waitForPageToLoad();
		brokerRouting.updateEngineProperty("CUDAFirstGPUName");
		brokerRouting.updateEngineComparator("equals");
		brokerRouting.updateEngineValue(engineValue);
		brokerRouting.clickOnPlusIconOnEngineRules();
		brokerRouting.clickSaveButton();
		brokerRouting.waitForPageToLoad();
		brokerRouting.verifyValuePresent(engineValue);
		brokerRouting.clickEditButton();
		brokerRouting.waitForPageToLoad();
		brokerRouting.clickDeleteForRules(engineValue);
		brokerRouting.waitForPageToLoad();
		brokerRouting.clickSaveButton();
		brokerRouting.waitForPageToLoad();
		brokerRouting.verifyValueNotPresent(engineValue);
	}
	
	
	@Test(description="Verify functionality of edit button for driver rules")
	public void Grid_4794()
	{
		brokerRouting.clickEditButton();
		brokerRouting.waitForPageToLoad();
		brokerRouting.updateDriverProperty(driverPropertyName);
		brokerRouting.updateDriverComparator("equals");
		brokerRouting.updateDriverValue(driverValue);
		brokerRouting.clickOnPlusIconOnDriverRules();
		brokerRouting.clickSaveButton();
		brokerRouting.waitForPageToLoad();
		brokerRouting.verifyValuePresent(driverValue);
		brokerRouting.clickEditButton();
		brokerRouting.waitForPageToLoad();
		brokerRouting.clickEditForRules(driverValue);
		brokerRouting.clickCancelButton();
		brokerRouting.waitForPageToLoad();
	}
	
	
	@Test(description="Verify functionality of save button on driver rule")
	public void Grid_4795()
	{
		brokerRouting.clickEditButton();
		brokerRouting.waitForPageToLoad();
		brokerRouting.updateDriverProperty(driverPropertyName);
		brokerRouting.updateDriverComparator("equals");
		brokerRouting.updateDriverValue(driverValue);
		brokerRouting.clickOnPlusIconOnDriverRules();
		brokerRouting.clickSaveButton();
		brokerRouting.waitForPageToLoad();
		brokerRouting.verifyValuePresent(driverValue);
		brokerRouting.clickEditButton();
		brokerRouting.waitForPageToLoad();
		brokerRouting.clickEditForRules(driverValue);
		brokerRouting.editDriverValue(editedDriverValue);
		brokerRouting.clickSaveForRules();
		brokerRouting.waitForPageToLoad();
		brokerRouting.clickSaveButton();
		brokerRouting.waitForPageToLoad();
		brokerRouting.verifyValuePresent(editedDriverValue);
	}
	
	@Test(description="Verify functionality of delete button on driver rules")
	public void Grid_4796()
	{
		brokerRouting.clickEditButton();
		brokerRouting.waitForPageToLoad();
		brokerRouting.updateDriverProperty(driverPropertyName);
		brokerRouting.updateDriverComparator("equals");
		brokerRouting.updateDriverValue(driverValue);
		brokerRouting.clickOnPlusIconOnDriverRules();
		brokerRouting.clickSaveButton();
		brokerRouting.waitForPageToLoad();
		brokerRouting.verifyValuePresent(driverValue);
		brokerRouting.clickEditButton();
		brokerRouting.waitForPageToLoad();
		brokerRouting.clickDeleteForRules(driverValue);
		brokerRouting.waitForPageToLoad();
		brokerRouting.clickSaveButton();
		brokerRouting.waitForPageToLoad();
		brokerRouting.verifyValueNotPresent(driverValue);
	}
	
	
}
