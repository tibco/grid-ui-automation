package com.tibco.automation.page.gridcomponents.engines;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.Locators.EngineConfigurationLocators;
import com.tibco.automation.page.common.Locators.EnginePropertiesPageLocators;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.common.TopPaginate;
import com.tibco.automation.page.common.TemplatePage.GSMenu;

public class EngineConfigurationPage extends TemplatePage implements EngineConfigurationLocators, EnginePropertiesPageLocators{
	
	public ExtendedWebDriver driver;
	public String pageTitle ="Role Admin";
	public TemplatePage templatePage;
	public TopPaginate topPaginate;
	public String winHandleBefore;
	public String parentWinHandle;
	public Select select;
	public JavascriptExecutor js = (JavascriptExecutor) driver;
	
	
	public EngineConfigurationPage()
	{
		super("Engine Configurations", GSMenu.EngineConfiguration);
		driver = getDriver();
		templatePage = new TemplatePage();
		topPaginate = new TopPaginate();
	}
	
	@Override
	public void waitForPageToLoad() 
	{
	addStaticWait(1000);
	super.waitForPageToLoad();
	}	
	
	public void clickAddButoon()
	{
		driver.getWaitUtility().waitForElementPresent(ADD_BUTTON_LOC);
		driver.getAssertionService().assertTrue((new ExtendedWebElement((ADD_BUTTON_LOC)).isDisplayed()), "Add button is not present on page", "Add button is present on page");
	}
	
	public void enterConfigValue(String configValue)
	{
		driver.findElement(ADD_BUTTON_LOC).click();
		driver.getWaitUtility().waitForElementPresent(CONFIGDROPDOWN);
		select = new Select(driver.findElement(CONFIGDROPDOWN)); 
		select.selectByIndex(1);
		driver.findElement(VALUE).sendKeys(configValue);
	}
	public void create()
	{
		driver.findElement(CREATE).click();
	}
	public void cancelCreate()
	{
		driver.findElement(CANCEL_PROPERTY_BUTTON_LOC).click();
	}
	public void configSave()
	{
		driver.getWaitUtility().waitForElementPresent(CONFIGSAVE);
		driver.findElement(CONFIGSAVE).click();
	}
	public void configCancel()
	{
		driver.findElement(CONFIGCANCEL).click();
	}
	public void selectCheckBox()
	{
		WebElement option1 = driver.findElement(CONFIGCHECKBOX);
		if(option1.isSelected())
		{
			driver.getAssertionService().addAssertionLog("Checkbox is already Selected", MessageTypes.Info);
			driver.getAssertionService().addAssertionLog("Dselecting Checkbox to perform select checkbox function", MessageTypes.Info);
		    option1.click();
		    option1.click();
		}
		else
		{
			driver.getAssertionService().addAssertionLog("Checkbox is not selected...performing select checkbox function", MessageTypes.Info);
			option1.click();
		}
	}
	public void deselectCheckbox()
	{
		WebElement option1 = driver.findElement(CONFIGCHECKBOX);
		if(option1.isSelected())
		{
			driver.getAssertionService().addAssertionLog("Checkbox is already Selected", MessageTypes.Info);
			driver.getAssertionService().addAssertionLog("Dselecting Checkbox ", MessageTypes.Info);
		    option1.click();
		    
		}
		else
		{
			driver.getAssertionService().addAssertionLog("Checkbox is not selected...performing select checkbox twice function to deselect checkbox", MessageTypes.Info);
			option1.click();
			option1.click();
		}
	}
	public void clickEngineConfigName(String configValue)
	{
		driver.findElement(String.format(CONFIGURATION,configValue)).click();
		super.waitForPageToLoad();
		
	}
	//Select Linux64 config for copy operation
	public void clickLinuxEngineConfig()
	{
		driver.findElement(LINUX64CONFIG).click();
	}
	//click on Engine >Engine Configurations 
	public void clickEngineConfig()
	{
		waitForPageToLoad();
		driver.getWaitUtility().waitForElementPresent(ENGINECONFIG);
		//driver.getWaitUtility().waitForElementPresent(CREATE);
		driver.findElement(ENGINECONFIG).click();
		waitForPageToLoad();
		//driver.findElement(ENGINECONFIG).click();
		driver.getWaitUtility().waitForElementPresent(SIDELINK);
	}
	public void clickCopy()
	{
		driver.findElement(CONFIGCOPY).click();
	}
	//Enter new config name for copied configuration
	public void enterCopyData(String configValue)
	{
		WebElement toClear = driver.findElement(COPYNAME);
		toClear.sendKeys(Keys.CONTROL + "a");
		toClear.sendKeys(Keys.DELETE);
		driver.findElement(COPYNAME).sendKeys(configValue);
	}
	public void saveCopyConfig()
	{
		driver.findElement(SAVECOPYCONFIG).click();
	}	
	public void clickDelete()
	{
		driver.findElement(CONFIGDELETE).click();
	}
	public void clickExpandAll()
	{
		if(new ExtendedWebElement(CONFIGCHECKBOX).isPresent())
		{
			driver.getAssertionService().addAssertionLog("Data already in expanded format..clicking on Collapse All first to perform Expand operation", MessageTypes.Info);
			driver.findElement(CONFIGCOLLAPSEALL).click();
			driver.findElement(CONFIGEXPANDALL).click();
		}
		else
		{
		driver.findElement(CONFIGEXPANDALL).click();
		}
	}
	public void clickCollapseAll()
	{
		if(new ExtendedWebElement(CONFIGCHECKBOX).isPresent())
		{
			driver.findElement(CONFIGCOLLAPSEALL).click();
		}
		else
		{
			driver.getAssertionService().addAssertionLog("Data already is is in collapsed format..clicking on Expand All first to perform Collapse operation", MessageTypes.Info);
			driver.findElement(CONFIGEXPANDALL).click();
			driver.findElement(CONFIGCOLLAPSEALL).click();
		}
	}
	public void verifyExpandAll()
	{
		driver.getAssertionService().assertTrue((new ExtendedWebElement(CONFIGCHECKBOX).isDisplayed()), "Data is not expanded", "Data displyed in Expanded format");
	}
	public void verifyCollapseAll()
	{
		driver.getAssertionService().assertFalse((new ExtendedWebElement(CONFIGCHECKBOX).isDisplayed()), "Data is not Collapsed", "Data displyed in Collapsed format");
	}
	public void deleteLogMsg()
	{
		driver.getAssertionService().addAssertionLog("Deleting newly created configuration", MessageTypes.Info);
		
	}
	
	public void verifyCreateConfiguration(String configValue)
	{
		driver.getWaitUtility().waitForElementPresent(ADD_BUTTON_LOC);
		driver.getAssertionService().assertTrue((new ExtendedWebElement(String.format(CONFIGURATION, configValue)).isPresent()), "New Engine Configuration is not added", "New Engine configuration is added successfully with value:'"+configValue+"'");
	}
	public void verifyCancelConfiguration(String configValue)
	{
		driver.getAssertionService().assertFalse((new ExtendedWebElement(String.format(CONFIGURATION, configValue)).isPresent()), "New Engine Configuration is added after clicking on cancel button", "New Engine configuration is not added after clicking on cancel button");
	}
	public void verifySaveConfiguration()
	{
		boolean X=new ExtendedWebElement(String.format(CONFIGCHECKBOX)).isSelected();
        driver.getAssertionService().assertTrue(X, "Changes was not saved", "Changes saved successfully on Engine Configuration");
		
	}
	public void verifyCancelConfig() 
	{
		boolean X=new ExtendedWebElement(String.format(CONFIGCHECKBOX)).isSelected();
        driver.getAssertionService().assertTrue(X, "Changes saved after clicking on cancel button", "Changes was not saved after clicking on Cancel button");
		
	}
	public void verifyCopyConfiguration(String configValue)
	{
		driver.getWaitUtility().waitForElementPresent(ADD_BUTTON_LOC);
		driver.getAssertionService().assertTrue((new ExtendedWebElement(String.format(CONFIGURATION, configValue)).isPresent()), "Engine Configuration is not copied", "Engine configuration is copied successfully copied value is :'"+configValue+"'");
	}
	public void verifyDelete(String configValue)
	{
		driver.getAssertionService().assertFalse((new ExtendedWebElement(String.format(CONFIGURATION, configValue)).isPresent()), "New Engine Configuration is not deleted after clicking on delete button", "New Engine configuration is deleted after clicking on delete button");
	}
	public void verifySideLink()
	{
		driver.getWaitUtility().waitForElementPresent(SIDELINK);
		driver.getAssertionService().assertTrue((new ExtendedWebElement(SIDELINK).isPresent()), "clicking on engine configurations link in side menu bar is not navigates user to list of configuration", "clicking on engine configurations link in side menu bar navigates user to list of configuration");
	}
	
}
