package com.tibco.automation.page.gridcomponents.engines;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.Locators;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.common.TopPaginate;


public class EnginePropertiesPage extends TemplatePage implements Locators,Locators.EnginePropertiesPageLocators{

	public DataGrid datagrid; // these are class references
	public ExtendedWebDriver driver;
	public String pageTitle ="Driver Admin";
	public TemplatePage templatePage;
	public TopPaginate topPaginate;
	
	public EnginePropertiesPage() {
		super("Engine Properties", GSMenu.EngineProperties);
		System.out.println("GSMenu..!!");
		datagrid = new DataGrid(); // as already defined above we are just initializing
		driver = getDriver();
		templatePage = new TemplatePage();
		topPaginate = new TopPaginate();
		System.out.println(" After GSMenu..!!");
	}
	

	@Override
	public boolean isPageActive(Object... object) {
		System.out.println("isPageActive..!!");
		return super.verifyPageTitle(pageTitle);
		
		
	}

	@Override
	public void waitForPageToLoad() {
		super.waitForPageToLoad();
	}
	
	public void selectProperty(String propertyName)
	{
		new ExtendedWebElement(String.format(PROPERTIES_CHECKBOX_LOC, propertyName)).click();
		driver.getAssertionService().addAssertionLog("Property "+propertyName+" checkbox is selected", MessageTypes.Info);
	}
	
	public void verifyAddButtonIsPresent()
	{
		driver.getWaitUtility().waitForElementPresent(ADD_BUTTON_LOC);
		driver.getAssertionService().assertElementPresent(By.xpath(ADD_BUTTON_LOC), "Add Button");
	}
	
	public void clickAddButton()
	{
		driver.getWaitUtility().waitForElementPresent(ADD_BUTTON_LOC);
		new ExtendedWebElement(ADD_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Add button is clicked", MessageTypes.Info);
	}
	
	public void clickCancelButton()
	{
		driver.getWaitUtility().waitForElementPresent(CANCEL_PROPERTY_BUTTON_LOC);
		new ExtendedWebElement(CANCEL_PROPERTY_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Cancel Button is clicked on add properties popup", MessageTypes.Info);
	}
	
	public void clickAddPropertiesButton()
	{
		driver.getWaitUtility().waitForElementPresent(ADD_PROPERTY_BUTTON_LOC);
		new ExtendedWebElement(ADD_PROPERTY_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Add button is clicked on add properties popup", MessageTypes.Info);
	}
	
	public void clickCloseIcon()
	{
		driver.getWaitUtility().waitForElementPresent(CLOSE_ADD_PROPERTY_LOC);
		new ExtendedWebElement(CLOSE_ADD_PROPERTY_LOC).click();
		driver.getAssertionService().addAssertionLog("Close button is clicked", MessageTypes.Info);
	}
	
	public void clickEditButton()
	{
		driver.getWaitUtility().waitForElementPresent(EDIT_BUTTON_LOC);
		new ExtendedWebElement(EDIT_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Edit button is clicked", MessageTypes.Info);
	}
	
	public void verifyEditAndDeleteButtonIsPresent()
	{
		driver.getAssertionService().assertElementPresent(By.xpath(EDIT_BUTTON_LOC), "Edit button");
		driver.getAssertionService().assertElementPresent(By.xpath(REMOVE_BUTTON_LOC), "Remove button");
	}
	
	public void clickDeleteButton()
	{
		driver.getWaitUtility().waitForElementPresent(REMOVE_BUTTON_LOC);
		new ExtendedWebElement(REMOVE_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Remove button is clicked", MessageTypes.Info);
	}
	
	public void clickUpdateButton()
	{
		driver.getWaitUtility().waitForElementPresent(UPDATE_BUTTON_LOC);
		new ExtendedWebElement(UPDATE_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Update button is clicked", MessageTypes.Info);
	}
	
	public void updatePropertyDetails(String propertyName,String description)
	{
		driver.getWaitUtility().waitForElementPresent(ADD_PROPERTY_BUTTON_LOC);
		new ExtendedWebElement(PROPERTY_INPUT_BOX_LOC).sendKeys(propertyName);
		new ExtendedWebElement(DESCRIPTION_INPUT_BOX_LOC).sendKeys(description);
	}
	
	public void editDescription(String description,String updatedDescription)
	{
		driver.getWaitUtility().waitForElementPresent(String.format(EDIT_DESCRIPTION_INPUTBOX_LOC, description));
		new ExtendedWebElement(String.format(EDIT_DESCRIPTION_INPUTBOX_LOC, description)).clear();
		new ExtendedWebElement(String.format(EDIT_DESCRIPTION_INPUTBOX_LOC, description)).sendKeys(updatedDescription);
	}
	
	public void verifyPropertyPresent(String propertyName)
	{
		driver.getAssertionService().assertElementPresent(By.xpath(String.format(PROPERTY_NAME_LOC, propertyName)), "Property "+propertyName);
	}
	
	public void verifyPropertyNotPresent(String propertyName)
	{
		driver.getAssertionService().assertElementNotPresent(By.xpath(String.format(PROPERTY_NAME_LOC, propertyName)), "Property "+propertyName);
	}
}
