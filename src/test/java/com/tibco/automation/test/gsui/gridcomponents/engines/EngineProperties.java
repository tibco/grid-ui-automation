package com.tibco.automation.test.gsui.gridcomponents.engines;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import com.tibco.automation.common.utils.RandomStringGenerator;
import com.tibco.automation.common.utils.RandomStringGenerator.RandomizerTypes;
import com.tibco.automation.page.common.CommonFunctions;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.gridcomponents.engines.EnginePropertiesPage;
import com.tibco.automation.page.common.Locators;
public class EngineProperties extends WebDriverTestCase implements Locators.EnginePropertiesPageLocators{

	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public TemplatePage templatepage;
	public EnginePropertiesPage engineProps;
	public CommonFunctions commonFunctions;
	public String propertyName;
	public String description;
	public String updatedDescription;
	
	@BeforeMethod
	public void beforeMethod()
	{
		engineProps=new EnginePropertiesPage();
		commonFunctions=new CommonFunctions();
		engineProps.launchPage();
		engineProps.waitForPageToLoad();
		propertyName=RandomStringGenerator.get(5, RandomizerTypes.MIXED);
		description="description "+ RandomStringGenerator.get(5, RandomizerTypes.MIXED);
		updatedDescription="edited description "+RandomStringGenerator.get(4, RandomizerTypes.MIXED);
	}
	
	@Test(description="Verify add button is present on engine properties page.")
	public void Grid_3945()
	{
		engineProps.verifyAddButtonIsPresent();
	}
	
	
	@Test(description="Verify functionality of cancel button on add engine property popup.")
	public void Grid_3946()
	{
		engineProps.clickAddButton();
		engineProps.waitForPageToLoad();
		engineProps.updatePropertyDetails(propertyName, description);
		engineProps.clickCancelButton();
		engineProps.waitForPageToLoad();
		engineProps.verifyPropertyNotPresent(propertyName);
	}
	
	@Test(description="Verify functionality of add button on add engine property popup.")
	public void Grid_3947()
	{
		engineProps.clickAddButton();
		engineProps.waitForPageToLoad();
		engineProps.updatePropertyDetails(propertyName, description);
		engineProps.clickAddPropertiesButton();
		engineProps.waitForPageToLoad();
		engineProps.verifyPropertyPresent(propertyName);
	}
	
	@Test(description="Verify functionality of close 'x' button on add engine property popup.")
	public void Grid_3948()
	{
		engineProps.clickAddButton();
		engineProps.waitForPageToLoad();
		engineProps.updatePropertyDetails(propertyName, description);
		engineProps.clickCloseIcon();
		engineProps.waitForPageToLoad();
		engineProps.verifyPropertyNotPresent(propertyName);
	}
	
	@Test(description="Verify selecting an existing property enables edit and delete option.")
	public void Grid_3949()
	{
		engineProps.clickAddButton();
		engineProps.waitForPageToLoad();
		engineProps.updatePropertyDetails(propertyName, description);
		engineProps.clickAddPropertiesButton();
		engineProps.waitForPageToLoad();
		engineProps.verifyPropertyPresent(propertyName);
		engineProps.selectProperty(propertyName);
		engineProps.selectProperty(propertyName);
		engineProps.selectProperty(propertyName);
		engineProps.verifyEditAndDeleteButtonIsPresent();
	}
	
	
	@Test(description="Verify functionality of edit button on properties page.")
	public void Grid_3950()
	{
		engineProps.clickAddButton();
		engineProps.waitForPageToLoad();
		engineProps.updatePropertyDetails(propertyName, description);
		engineProps.clickAddPropertiesButton();
		engineProps.waitForPageToLoad();
		engineProps.verifyPropertyPresent(propertyName);
		engineProps.selectProperty(propertyName);
		engineProps.selectProperty(propertyName);
		engineProps.selectProperty(propertyName);
		engineProps.clickEditButton();
		engineProps.waitForPageToLoad();
		engineProps.clickUpdateButton();
	}
	
	@Test(description="Verify functionality of update button on edit page.")
	public void Grid_3951()
	{
		engineProps.clickAddButton();
		engineProps.waitForPageToLoad();
		engineProps.updatePropertyDetails(propertyName, description);
		engineProps.clickAddPropertiesButton();
		engineProps.waitForPageToLoad();
		engineProps.verifyPropertyPresent(propertyName);
		engineProps.selectProperty(propertyName);
		engineProps.selectProperty(propertyName);
		engineProps.selectProperty(propertyName);
		engineProps.clickEditButton();
		engineProps.waitForPageToLoad();
		engineProps.editDescription(description, updatedDescription);
		engineProps.clickUpdateButton();
		engineProps.waitForPageToLoad();
		engineProps.verifyPropertyPresent(updatedDescription);
	}
	
	@Test(description="Verify functionality of remove button on properties page")
	public void Grid_3952()
	{
		engineProps.clickAddButton();
		engineProps.waitForPageToLoad();
		engineProps.updatePropertyDetails(propertyName, description);
		engineProps.clickAddPropertiesButton();
		engineProps.waitForPageToLoad();
		engineProps.verifyPropertyPresent(propertyName);
		engineProps.selectProperty(propertyName);
		engineProps.selectProperty(propertyName);
		engineProps.selectProperty(propertyName);
		engineProps.clickDeleteButton();
		engineProps.waitForPageToLoad();
		engineProps.verifyPropertyNotPresent(propertyName);
	}
}
