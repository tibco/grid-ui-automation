package com.tibco.automation.test.gsui.gridcomponents.engines;

import java.awt.AWTException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import com.tibco.automation.common.utils.RandomStringGenerator;
import com.tibco.automation.common.utils.RandomStringGenerator.RandomizerTypes;
import com.tibco.automation.page.admin.useradmin.RolePage;
import com.tibco.automation.page.common.CommonFunctions;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.gridcomponents.engines.DaemonAdminPage;
import com.tibco.automation.page.gridcomponents.engines.EngineAdminPage;
import com.tibco.automation.page.gridcomponents.engines.EngineConfigurationPage;

public class DaemonAdmin extends WebDriverTestCase {
	public ExtendedWebDriver driver;
	public TemplatePage templatepage;
	public EngineConfigurationPage enginepage;
	public CommonFunctions commonFunctions;
	public DaemonAdminPage daemonadmin;
	public RolePage rolepage;
	public String configValue=null;
	public EngineAdminPage engineadminpage;
	public String definitionName="";
	public String description="";
	@BeforeMethod
	public void beforeMethod()
	{
		rolepage=new RolePage();
		engineadminpage=new EngineAdminPage();
		daemonadmin=new DaemonAdminPage();
		daemonadmin.launchPage();
		daemonadmin.waitForPageToLoad();
		commonFunctions=new CommonFunctions();
		definitionName=RandomStringGenerator.get(5, RandomizerTypes.MIXED);
		description="description"+definitionName;
		daemonadmin.waitForPageToLoad();
		
	}
	@Test(priority=0,description="Verify local action- delete repository entry for an offline daemon.")
	 public void Grid_4196()
	{
		
		daemonadmin.selectOfflineEngineCheckbox();
		commonFunctions.selectLocalAction("Delete Repository Entry");
		daemonadmin.switchToNewlyOpenedWindow();
		daemonadmin.waitForPageToLoad();
		daemonadmin.verifyDeleteRepository();
		
	}

	@Test(priority=1,description="Verify refresh button is present and it shows last refresh on tooltip")
	public void Grid_4136()
	{
		daemonadmin.refreshButton();
		commonFunctions.verifyLastRefresh();
		
	}
	
	 @Test(priority=1,description="Verify functionality of global action-purge offline daemons on page")
	 public void Grid_4160()
	{
	
		    daemonadmin.clickGlobalAction();
		    daemonadmin.selectGlobalAction("Purge Offline Daemons on Page");
		    daemonadmin.acceptAlert();
			daemonadmin.waitForPageToLoad();
			daemonadmin.waitToVerify();
			daemonadmin.switchToParentWindow();
			daemonadmin.VerifyPurgeOfflineEngine();
			daemonadmin.switchToParentWindow();
		
		    
		    
	}
	 
	 @Test(priority=2,description="Verify functionality of global action-purge all offline daemons")
	 public void Grid_4172()
	{
		 daemonadmin.waitForPageToLoad();
	
		  commonFunctions.verifyGlobalActionLinkIsPresent();
		  daemonadmin.waitForPageToLoad();
		  commonFunctions.selectGlobalAction("Purge all Offline Daemons");
		    daemonadmin.acceptAlert();
			daemonadmin.waitForPageToLoad();
			
		    
		    
	}
	 
	@Test(priority=2,description="Verify clicking on refresh button disables it.")
	public void Grid_4137()
	{
		commonFunctions.clickRefreshButton();
		commonFunctions.verifyRefreshDisabled();
	}
	
	@Test(priority=3,description="Verify add columns option is present on page.")
	public void Grid_4138()
	{
		daemonadmin.addColumnOption();
	}
	
	@Test(priority=4,description="Verify the functionality of revert button add columns popup")
	public void Grid_4140()
	{
		 
		daemonadmin.addColumnOption();
		daemonadmin.waitForPageToLoad();
		daemonadmin.verifyRevert();
		daemonadmin.SaveColumn();
		
		
	}
	@Test(priority=5,description="Verify user is able to add columns after clicking on save button")
	public void Grid_4139()
	{
		
		daemonadmin.addColumnOption();
		daemonadmin.addEngineColumn();
		
		daemonadmin.SaveColumn();
		daemonadmin.waitForPageToLoad();
		daemonadmin.verifyColumnAdded();
		 
	}
	



	@Test(priority=6,description="Verify simple search using username")
	public void Grid_4141()
	{
		
		commonFunctions.performSimpleSearch("User Name","INVALID");
		daemonadmin.verifySimpleSearch();
		daemonadmin.clearSearch();
	
	}

	@Test(priority=7,description="Verify query search using IP")
	public void Grid_4142()
	{
		commonFunctions.performQuerySearch("\"IP\" == \"INVALID\"");
		daemonadmin.verifyPerformQuerySearch();
		daemonadmin.clearSearch();
		
	}
	
	@Test(priority=8,description="Verify query builder search using OS")
	public void Grid_4143()
	{
		commonFunctions.performQueryBuilderSearch("OS", "==", "INVALID");
		commonFunctions.clickSearchOnQueryBuilder();
		daemonadmin.verifySimpleSearch();
		daemonadmin.clearSearch();
		
	}
	@Test(priority=10,description="verify change in results per page value changes the number of rows in table")
	public void Grid_4144()
	{
		commonFunctions.updateResultsPerPage(1);
		
	}
	@Test(priority=11,description="Verify functionality of next page button in pagination")
	public void Grid_4145()
	{

		daemonadmin.waitforElement();
		commonFunctions.goToNextPage();
		
	}
	@Test(priority=12,description="Verify functionality of previous page button in pagination")
	public void Grid_4146()
	{
		daemonadmin.waitforElement();
		commonFunctions.goToPreviousPage();
		daemonadmin.waitforElement();
		commonFunctions.updateResultsPerPage(20);
	}
	
	@Test(priority=13,description="Verify functionality of move to first page button")
	public void Grid_4147()
	{
		
		daemonadmin.waitforElement();
		commonFunctions.goToFirstPage();
	}
	
	@Test(priority=14,description="Verify functionality of move to last page button")
	public void Grid_4148()
	{
	
		daemonadmin.waitforElement();
		commonFunctions.goToLastPage();
		
	}
	
	
	 @Test(priority=15,description="Verify global action- expand view of all")
	 public void Grid_4149()
	{
		daemonadmin.clickGlobalAction();
		commonFunctions.selectGlobalAction("Expand View of All");
		daemonadmin.verifyExpandViewOfAll();
	}
	@Test(priority=16,description="Verify global action- collapse view of all")
	 public void Grid_4150()
	{
		daemonadmin.clickGlobalAction();
		commonFunctions.selectGlobalAction("Collapse View of All");
		daemonadmin.verifyCollapseViewOfAll();
	}
	
	@Test(priority=18,description="Verify functionality of global action- manual mode for engines on page")
	 public void Grid_4151()
	{
	
		daemonadmin.clickGlobalAction();
		daemonadmin.selectGlobalAction("Manual Mode for Engines on Page");
		commonFunctions.acceptAlert();
	}
	@Test(priority=17,description="Verify functionality of global action- Auto mode for engines on page")
	 public void Grid_4152()
	{
	
		daemonadmin.clickGlobalAction();
		daemonadmin.selectGlobalAction("Auto Mode for Engines on Page");
		commonFunctions.acceptAlert();
	}
	@Test(priority=18,description="Verify functionality of global action-disable engines on page")
	 public void Grid_4154()
	{
	
		daemonadmin.clickGlobalAction();
		daemonadmin.selectGlobalAction("Disable Engines on Page");
		daemonadmin.waitForPageToLoad();
		daemonadmin.verifyDisableEngineOnPage();
	}
		@Test(priority=19,description="Verify functionality of global action-Enable engines on page")
	 public void Grid_4153()
	{
	
		daemonadmin.clickGlobalAction();
		daemonadmin.selectGlobalAction("Enable Engines on Page");
		daemonadmin.waitForPageToLoad();
		daemonadmin.verifyEnableEngineOnPage();
	}
		
	@Test(priority=20,description="verify functionality of cancel button on configure daemons page")
	 public void Grid_4156()
	{
	
		daemonadmin.clickGlobalAction();
		daemonadmin.selectGlobalAction("Configure Daemons on Page");
		daemonadmin.waitForPageToLoad();
		daemonadmin.switchToNewlyOpenedWindow();
		daemonadmin.changeInstances();
		daemonadmin.clickOnConfigCancelButton();
		daemonadmin.switchToNewlyOpenedWindow();
		daemonadmin.waitForPageToLoad();
		daemonadmin.verifyCancelDaemonsOnPage();
		daemonadmin.switchToParentWindow();
	}
	@Test(priority=21,description="verify functionality of save button on configure daemons page")
	 public void Grid_4157()
	{
	
		daemonadmin.clickGlobalAction();
		daemonadmin.selectGlobalAction("Configure Daemons on Page");
		daemonadmin.waitForPageToLoad();
		daemonadmin.switchToNewlyOpenedWindow();
		daemonadmin.changeInstances();
		daemonadmin.selectInstanceCheckbox();
		daemonadmin.clickOnConfigSaveButton();

		daemonadmin.waitForPageToLoad();
		daemonadmin.waitToVerify();
		daemonadmin.clickOnOkButton();
		daemonadmin.switchToParentWindow();
		daemonadmin.verifyConfigureDaemonsOnPage();
		
		daemonadmin.switchToParentWindow();
	}
	
	@Test(priority=22,description="Verify functionality of global action- configure daemons on page")
	 public void Grid_4155()
	{
	
		daemonadmin.clickGlobalAction();
		commonFunctions.selectGlobalAction("Configure Daemons on Page");
		daemonadmin.waitForPageToLoad();
		daemonadmin.switchToNewlyOpenedWindow();
		daemonadmin.setDefaultInstances();
		daemonadmin.selectInstanceCheckbox();
		daemonadmin.clickOnConfigSaveButton();
		daemonadmin.waitForPageToLoad();
		daemonadmin.waitToVerify();
		daemonadmin.clickOnOkButton();
		daemonadmin.switchToParentWindow();
		daemonadmin.waitToVerify();
		daemonadmin.verifyDefaultConfigureDaemonsOnPage();
		daemonadmin.switchToParentWindow();
		
		
	}
	
	@Test(priority=23,description="Verify functionality of global action-manual mode for all engines")
	 public void Grid_4162()
	{
	
		daemonadmin.clickGlobalAction();
		daemonadmin.selectGlobalAction("Manual Mode for All Engines");
		commonFunctions.acceptAlert();
		
		
	}
	
	@Test(priority=24,description="Verify functionality of global action- Auto mode for all engines on page")
	 public void Grid_4163()
	{
			
		daemonadmin.clickGlobalAction();
		daemonadmin.waitForPageToLoad();
		daemonadmin.selectGlobalAction("Auto Mode for All Engines");
		commonFunctions.acceptAlert();
		
	}
	
	
	@Test(priority=25,description="Verify functionality of global action-disable all engines")
	 public void Grid_4165()
	{
	
		
		daemonadmin.clickGlobalAction();
		daemonadmin.selectGlobalAction("Disable All Engines");
		daemonadmin.waitForPageToLoad();
		daemonadmin.verifyDisableEngineOnPage();
		daemonadmin.switchToParentWindow();
		
	}
	@Test(priority=26,description="Verify functionality of global action-enable all engines")
	 public void Grid_4164()
	{
		
		daemonadmin.clickGlobalAction();
		daemonadmin.selectGlobalAction("Enable All Engines");
		daemonadmin.waitForPageToLoad();
		daemonadmin.verifyEnableEngineOnPage();
		daemonadmin.switchToParentWindow();
	}
	
	
	
	
	@Test(priority=27,description="verify functionality of cancel button on global action configure all daemons")
	 public void Grid_4167 ()
	{
	
		daemonadmin.clickGlobalAction();
		daemonadmin.selectGlobalAction("Configure All Daemons");
		daemonadmin.waitForPageToLoad();
		daemonadmin.switchToNewlyOpenedWindow();
		daemonadmin.changeInstances();
		daemonadmin.clickOnCancelButton();
	
		daemonadmin.switchToNewlyOpenedWindow();
		daemonadmin.waitForPageToLoad();
		daemonadmin.verifyCancelDaemonsOnPage();
		daemonadmin.switchToParentWindow();
	}
	
	
	@Test(priority=28,description="verify functionality of save button on global action configure all daemons.")
	 public void Grid_4168()
	{
	
		
		daemonadmin.clickGlobalAction();
		daemonadmin.selectGlobalAction("Configure All Daemons");
		daemonadmin.waitForPageToLoad();
		daemonadmin.switchToNewlyOpenedWindow();
		daemonadmin.changeInstances();
		daemonadmin.selectInstanceCheckbox();
		daemonadmin.clickOnConfigAllSaveButton();
		daemonadmin.acceptAlert();
		daemonadmin.waitForPageToLoad();
		daemonadmin.waitToVerify();
		daemonadmin.clickOnOkButton();
		daemonadmin.switchToParentWindow();
		daemonadmin.waitToVerify();
		daemonadmin.verifyConfigureDaemonsOnPage();
		
		daemonadmin.switchToParentWindow();
		
	}
	
	@Test(priority=29,description="Verify functionality of global action-configure all daemons")
	 public void Grid_4166()
	{
	
		
		
		daemonadmin.clickGlobalAction();
		daemonadmin.selectGlobalAction("Configure All Daemons");
		daemonadmin.waitForPageToLoad();
		daemonadmin.switchToNewlyOpenedWindow();
		daemonadmin.setDefaultInstances();
		daemonadmin.selectInstanceCheckbox();
		daemonadmin.clickOnConfigAllSaveButton();
		daemonadmin.acceptAlert();
		daemonadmin.waitForPageToLoad();
		daemonadmin.waitToVerify();
		daemonadmin.clickOnOkButton();
		
		daemonadmin.switchToParentWindow();
		daemonadmin.waitToVerify();
		daemonadmin.verifyDefaultConfigureDaemonsOnPage();
		daemonadmin.switchToParentWindow();
		
	}
	
	
	@Test(priority=30,description="Verify local action- daemon details")
	 public void Grid_4175()
	{
		daemonadmin.selectEngineCheckbox();
		commonFunctions.selectLocalAction("Engine Daemon Details");
		daemonadmin.verifyExpandViewOfAll();
		daemonadmin.selectEngineCheckbox();
		commonFunctions.selectLocalAction("Engine Daemon Details");
}
	
	@Test(priority=31,description="Verify local action - log files")
	 public void Grid_4176()
	{
		daemonadmin.selectEngineCheckbox();
		commonFunctions.selectLocalAction("Log Files");
		daemonadmin.switchToNewlyOpenedWindow();
		daemonadmin.waitForPageToLoad();
		daemonadmin.verifyLogFile();
		daemonadmin.quit();
		daemonadmin.switchToParentWindow();	
	}
	
	@Test(priority=32,description="Verify local action- search logs")
	 public void Grid_4178()
	{

		daemonadmin.selectEngineCheckbox();
		commonFunctions.selectLocalAction("Search Logs");
		daemonadmin.switchToNewlyOpenedWindow();
		daemonadmin.waitForPageToLoad();
		daemonadmin.verifySearchLogs();
		daemonadmin.quit();
		daemonadmin.switchToParentWindow();	
	}
	
	

		@Test(priority=33,description="Verify back button on search logs page")
	 public void Grid_4179()
	{
		daemonadmin.selectEngineCheckbox();
		commonFunctions.selectLocalAction("Search Logs");
		daemonadmin.switchToNewlyOpenedWindow();
		daemonadmin.waitForPageToLoad();
		daemonadmin.selectYear();
		
		daemonadmin.clickOnNextButton();
		daemonadmin.waitForPageToLoad();
		daemonadmin.clickOnBackButton();
		daemonadmin.verifyResults();
		
		daemonadmin.closeWindow();
		daemonadmin.switchToParentWindow();	
	
		
	}
	
	@Test(priority=34,description="Verify next button on search logs page")
	 public void Grid_4180()
	{
		daemonadmin.selectEngineCheckbox();
		commonFunctions.selectLocalAction("Search Logs");
		daemonadmin.switchToNewlyOpenedWindow();
		daemonadmin.waitForPageToLoad();
		daemonadmin.selectYear();
		daemonadmin.clickOnNextButton();
        daemonadmin.verifyResults();	
        daemonadmin.closeWindow();
		daemonadmin.switchToParentWindow();	
	
	}
	

	
	
	@Test(priority=35,description="Verify local action- auto mode")
	 public void Grid_4183()
	{

		daemonadmin.selectEngineCheckbox();
		daemonadmin.waitForPageToLoad();
		commonFunctions.verifyLocalActionLinkIsPresent();
		commonFunctions.selectLocalAction("Auto Mode");
		daemonadmin.acceptAlert();
		
		daemonadmin.waitForPageToLoad();
		daemonadmin.waitForPageToLoad();
		daemonadmin.waitForPageToLoad();
	//	daemonadmin.addWait();
		daemonadmin.switchToParentWindow();
		daemonadmin.addWait();
		daemonadmin.verifyAutoMode();
	
	}

	@Test(priority=36,description="Verify local action- manual mode")
	 public void Grid_4181()
	{

		daemonadmin.selectEngineCheckbox();
		daemonadmin.waitForPageToLoad();
		commonFunctions.verifyLocalActionLinkIsPresent();
		commonFunctions.selectLocalAction("Manual Mode");
		daemonadmin.acceptAlert();
		daemonadmin.waitForPageToLoad();
		
		//daemonadmin.switchToParentWindow();
		daemonadmin.addWait();
		daemonadmin.verifyManualMode();
		daemonadmin.switchToParentWindow();
	
	}
	@Test(priority=37,description="Verify local action- disable engines")
	 public void Grid_4184()
	{
		
		daemonadmin.selectEngineCheckbox();
		daemonadmin.waitForPageToLoad();
		commonFunctions.verifyLocalActionLinkIsPresent();
		commonFunctions.selectLocalAction("Disable Engines");
		daemonadmin.acceptAlert();
		daemonadmin.acceptAlert();
		daemonadmin.switchToParentWindow();
		daemonadmin.addWait();
		daemonadmin.verifyDisableDaemon();
		
	}
	@Test(priority=38,description="Verify local action- enable engines")
	 public void Grid_4182()
	{
		
		daemonadmin.selectEngineCheckbox();
		daemonadmin.waitForPageToLoad();
		commonFunctions.verifyLocalActionLinkIsPresent();
		commonFunctions.selectLocalAction("Enable Engines");
		daemonadmin.acceptAlert();
		daemonadmin.acceptAlert();
		daemonadmin.switchToParentWindow();
		daemonadmin.addWait();
		daemonadmin.verifyEnableDaemon();
		
	}
	
	@Test(priority=39,description="Verify local action Engine Tracking")
	 public void Grid_4190()
	{
		daemonadmin.selectEngineCheckbox();
		daemonadmin.waitForPageToLoad();
		commonFunctions.verifyLocalActionLinkIsPresent();
		commonFunctions.selectLocalAction("Engine Tracking");
		daemonadmin.switchToNewlyOpenedWindow();
		daemonadmin.waitForPageToLoad();
		daemonadmin.selectCheckboxOnEngineTracking();
		daemonadmin.selectLocalActionOnEngineTracking();
		daemonadmin.clickOnEngineAdminLink();
		daemonadmin.closeWindow();
		daemonadmin.switchToNewlyOpenedWindow();
		daemonadmin.waitForPageToLoad();
		daemonadmin.verifyEngineAdminPageIsLaunched();	
		daemonadmin.closeWindow();
		daemonadmin.switchToParentWindow();
	
}
	
	@Test(priority=40,description="Verify selecting an engine on engine tracking page enables local action")
	 public void Grid_4191()
	{
		daemonadmin.selectEngineCheckbox();
		daemonadmin.waitForPageToLoad();
		commonFunctions.verifyLocalActionLinkIsPresent();
		commonFunctions.selectLocalAction("Engine Tracking");
		daemonadmin.switchToNewlyOpenedWindow();
		daemonadmin.waitForPageToLoad();
		daemonadmin.selectCheckboxOnEngineTracking();
		daemonadmin.selectLocalActionOnEngineTracking();
		daemonadmin.closeWindow();
		daemonadmin.switchToParentWindow();
		
	}
	
	@Test(priority=41,description="Verify login to admin functionality on engine tracking page")
	 public void Grid_4192()
	{
		daemonadmin.selectEngineCheckbox();
		daemonadmin.waitForPageToLoad();
		commonFunctions.verifyLocalActionLinkIsPresent();
		commonFunctions.selectLocalAction("Engine Tracking");
		daemonadmin.switchToNewlyOpenedWindow();
		daemonadmin.waitForPageToLoad();
		daemonadmin.selectCheckboxOnEngineTracking();
		daemonadmin.selectLocalActionOnEngineTracking();
		daemonadmin.clickOnEngineAdminLink();
		daemonadmin.closeWindow();
		daemonadmin.switchToNewlyOpenedWindow();
		daemonadmin.waitForPageToLoad();
		daemonadmin.verifyEngineAdminPageIsLaunched();	
		daemonadmin.closeWindow();
		daemonadmin.switchToParentWindow();
	
	}
	

	
	
	@Test(priority=42,description="verify functionality of cancel button on local action configure daemons page.")
	 public void Grid_4194()
	{

		
		daemonadmin.selectEngineCheckbox();
		daemonadmin.waitForPageToLoad();
		commonFunctions.verifyLocalActionLinkIsPresent();
		commonFunctions.selectLocalAction("Configure Daemon");
		daemonadmin.switchToNewlyOpenedWindow();
		//daemonadmin.waitForPageToLoad();
		daemonadmin.changeInstances();
		daemonadmin.clickOnCancelButton();
		daemonadmin.switchToNewlyOpenedWindow();
	}
	
		@Test(priority=43,description="verify functionality of save button on local action configure daemons page.")
	 public void Grid_4195()
	{
		
		
		
		daemonadmin.selectEngineCheckbox();
		daemonadmin.waitForPageToLoad();
		commonFunctions.verifyLocalActionLinkIsPresent();
		commonFunctions.selectLocalAction("Configure Daemon");
		daemonadmin.waitForPageToLoad();
		daemonadmin.switchToNewlyOpenedWindow();
		daemonadmin.changeInstances();
		daemonadmin.waitForPageToLoad();
		daemonadmin.clickOnConfigDaemonSaveButton();
		daemonadmin.waitForPageToLoad();
		daemonadmin.waitToVerify();
		daemonadmin.clickOnOkButtonOnConfigureDaemo();
		daemonadmin.switchToParentWindow();
		daemonadmin.waitToVerify();
		daemonadmin.verifyConfigureDaemonsOnPage();
		daemonadmin.switchToParentWindow();
		
	}
		
	@Test(priority=44,description="Verify local action- configure daemon")
	 public void Grid_4193()
	{
	
	
	daemonadmin.selectEngineCheckbox();
	daemonadmin.waitForPageToLoad();
	commonFunctions.verifyLocalActionLinkIsPresent();
	commonFunctions.selectLocalAction("Configure Daemon");
	daemonadmin.waitForPageToLoad();
	daemonadmin.switchToNewlyOpenedWindow();
	daemonadmin.setDefaultInstances();
	daemonadmin.clickOnConfigDaemonSaveButton();
	daemonadmin.waitForPageToLoad();
	daemonadmin.waitToVerify();
	daemonadmin.clickOnOkButtonOnConfigureDaemo();
	
	daemonadmin.switchToParentWindow();
	daemonadmin.waitToVerify();
	daemonadmin.verifyDefaultConfigureDaemonsOnPage();
	daemonadmin.switchToParentWindow();
	
	}
	
	@Test(priority=45,description="Verify functionality of 'x' button on engine properties popup")
	 public void Grid_4189()
	{
		daemonadmin.selectEngineCheckbox();
		daemonadmin.waitForPageToLoad();
		commonFunctions.verifyLocalActionLinkIsPresent();
		commonFunctions.selectLocalAction("Edit/View Properties");
		daemonadmin.switchToNewlyOpenedWindow();
		
		daemonadmin.waitForPageToLoad();
		daemonadmin.waitToVerify();
		daemonadmin.clickRemoveQauntineStatus();
		daemonadmin.verifyRemoveQauntineStatus();
		daemonadmin.closeEnginePropretiesPopup();
		daemonadmin.switchToParentWindow();
		
	}
	
	@Test(priority=46,description="Verify local action edit/view properties")
	 public void Grid_4187()
	{
		daemonadmin.selectEngineCheckbox();
		daemonadmin.waitForPageToLoad();
		commonFunctions.verifyLocalActionLinkIsPresent();
		commonFunctions.selectLocalAction("Edit/View Properties");
		daemonadmin.switchToNewlyOpenedWindow();
		daemonadmin.waitForPageToLoad();
		daemonadmin.waitToVerify();
		daemonadmin.clickRemoveQauntineStatus();
		daemonadmin.selectDescriptionOpt();
		
		daemonadmin.clickOnPluseButton();
		daemonadmin.setDescription(description);
		daemonadmin.saveDescription();
		daemonadmin.switchToParentWindow();
		daemonadmin.verifyAddedDescription(description);
		
		}
	@Test(priority=47,description="Verify functionality of save button on engine properties popup")
	 public void Grid_4188()
	 
	{
		daemonadmin.selectEngineCheckbox();
		daemonadmin.waitForPageToLoad();
		commonFunctions.verifyLocalActionLinkIsPresent();
		commonFunctions.selectLocalAction("Edit/View Properties");
		daemonadmin.switchToNewlyOpenedWindow();
		daemonadmin.waitForPageToLoad();
		daemonadmin.waitToVerify();
		daemonadmin.clickRemoveQauntineStatus();
		daemonadmin.selectDescriptionOpt();
		
		daemonadmin.clickOnPluseButton();
		daemonadmin.setDescription(description);
		daemonadmin.saveDescription();
		daemonadmin.switchToParentWindow();
		daemonadmin.verifyAddedDescription(description);
		
		}
	
	
	@Test(priority=48,description="Verify local action- restart daemon")
	 public void Grid_4186()
	{
		daemonadmin.selectEngineCheckbox();
		daemonadmin.waitForPageToLoad();
		commonFunctions.verifyLocalActionLinkIsPresent();
		commonFunctions.selectLocalAction("Restart Daemon");
		daemonadmin.acceptAlert();
		daemonadmin.waitForPageToLoad();
		//daemonadmin.waitForPageToLoad();
		daemonadmin.waitToVerify();
		daemonadmin.switchToParentWindow();
		//daemonadmin.verifyRestartDaemon();
	}

	@Test(priority=49,description="Verify local action- clear from blacklist")
	public void Grid_4185()
	{
	daemonadmin.selectEngineCheckbox();
	daemonadmin.waitForPageToLoad();
	commonFunctions.verifyLocalActionLinkIsPresent();
	commonFunctions.selectLocalAction("Clear from Blacklists");
	
	}
	
	 @Test(priority=50,description="Verify functionality of global action-set property for all daemons")
	 public void Grid_4169()
	{

			commonFunctions.verifyGlobalActionLinkIsPresent();
			commonFunctions.selectGlobalAction("Set Property for Daemons on Page");
			daemonadmin.waitForPageToLoad();
			daemonadmin.switchToNewlyOpenedWindow();
		    daemonadmin.selectDescriptionOptOnPage();
		    daemonadmin.setDescriptionOnPage(description);
			daemonadmin.clickOnSubmitButton();
			daemonadmin.clickOnSubmitButton();
			daemonadmin.closeWindow();
			
			//daemonadmin.clickOnCloseButton();
			daemonadmin.waitToVerify();
			daemonadmin.switchToParentWindow();
			daemonadmin.verifyAddedDescription(description);
			daemonadmin.switchToParentWindow();
			
	}
	 @Test(priority=51,description=" Verify functionality of submit button on global action properties page")
	 public void Grid_4170()
	{
		 commonFunctions.verifyGlobalActionLinkIsPresent();
			commonFunctions.selectGlobalAction("Set Property for Daemons on Page");
			daemonadmin.waitForPageToLoad();
			daemonadmin.switchToNewlyOpenedWindow();
		    daemonadmin.selectDescriptionOptOnPage();
		    daemonadmin.setDescriptionOnPage(description);
			daemonadmin.clickOnSubmitButton();
			daemonadmin.clickOnSubmitButton();
			daemonadmin.closeWindow();
			daemonadmin.waitToVerify();
			daemonadmin.switchToParentWindow();
			daemonadmin.verifyAddedDescription(description);
			daemonadmin.switchToParentWindow();
			
			
	}
	
	 @Test(priority=52,description="Verify functionality of global action-set property for daemons on page")
	 public void Grid_4158()
	{
	
		 commonFunctions.verifyGlobalActionLinkIsPresent();
			commonFunctions.selectGlobalAction("Set Property for all Daemons");
			daemonadmin.waitForPageToLoad();
			daemonadmin.switchToNewlyOpenedWindow();
		    daemonadmin.selectDescriptionOptOnPage();
		    daemonadmin.setDescriptionOnPage(description);
		  
			daemonadmin.clickOnSubmitButton();
			daemonadmin.clickOnSubmitButton();
			
			daemonadmin.closeWindow();
			
			daemonadmin.waitToVerify();
			daemonadmin.switchToParentWindow();
			daemonadmin.verifyAddedDescription(description);
			daemonadmin.switchToParentWindow();
			
	}
	 
	 @Test(priority=53,description="Verify functionality of submit button on properties page")
	 public void Grid_4159()
	{
	
		 commonFunctions.verifyGlobalActionLinkIsPresent();
			commonFunctions.selectGlobalAction("Set Property for all Daemons");
			daemonadmin.waitForPageToLoad();
			daemonadmin.switchToNewlyOpenedWindow();
		    daemonadmin.selectDescriptionOptOnPage();
		    daemonadmin.setDescriptionOnPage(description);
			daemonadmin.clickOnSubmitButton();
			daemonadmin.clickOnSubmitButton();
			daemonadmin.closeWindow();
			daemonadmin.waitToVerify();
			daemonadmin.switchToParentWindow();
			daemonadmin.verifyAddedDescription(description);
			daemonadmin.switchToParentWindow();
			
	}
	 
	 @Test(priority=54,description="Verify functionality of global action-restart daemons on page")
	 public void Grid_4161()
	{
	
		 commonFunctions.verifyGlobalActionLinkIsPresent();
			commonFunctions.selectGlobalAction("Restart Daemons on Page");
			daemonadmin.acceptAlert();
			daemonadmin.waitForPageToLoad();
			daemonadmin.waitToVerify();
	        daemonadmin.switchToParentWindow();
			daemonadmin.verifyRestartDaemonOnPage();
			daemonadmin.waitToVerify();
			daemonadmin.clickOnRestartOkButton();
			daemonadmin.switchToParentWindow();
			
	 
	}
	 @Test(priority=55,description="Verify functionality of global action- restart all daemons")
	 public void Grid_4173()
	{
	
		 
		 commonFunctions.verifyGlobalActionLinkIsPresent();
			commonFunctions.selectGlobalAction("Restart All Daemons");
			daemonadmin.acceptAlert();
			daemonadmin.waitForPageToLoad();
			daemonadmin.waitToVerify();
	        daemonadmin.switchToParentWindow();
			daemonadmin.verifyRestartAllDaemonOnPage();
			daemonadmin.waitToVerify();
			daemonadmin.clickOnRestartOkButton();
			daemonadmin.switchToParentWindow();
			
		
	}

	
	
	
	
	 @Test(priority=58 , description=" Verify selecting a daemon enables local actions for that daemon")
		public void Grid_4174()
		{
			
		 daemonadmin.selectEngineCheckbox();
		 daemonadmin.waitForPageToLoad();
		 commonFunctions.verifyLocalActionLinkIsPresent();
			
		}
		
	
	
}