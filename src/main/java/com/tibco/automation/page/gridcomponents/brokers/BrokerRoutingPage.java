package com.tibco.automation.page.gridcomponents.brokers;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.Locators;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.common.TopPaginate;

public class BrokerRoutingPage extends TemplatePage implements Locators,Locators.BrokerRoutingPageLocators{

	
	public DataGrid datagrid; // these are class references
	public ExtendedWebDriver driver;
	public String pageTitle ="Driver Admin";
	public TemplatePage templatePage;
	public TopPaginate topPaginate;
	
	public BrokerRoutingPage() {
		super("Broker Routing", GSMenu.BrokerRouting);
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
	
	public void clickEditButton()
	{
		driver.getWaitUtility().waitForElementPresent(EDIT_BUTTON_LOC);
		new ExtendedWebElement(EDIT_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Edit button is clicked", MessageTypes.Info);
	}
	
	public void clickSaveButton()
	{
		driver.getWaitUtility().waitForElementPresent(SAVE_BUTTON_LOC);
		new ExtendedWebElement(SAVE_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Save button is clicked", MessageTypes.Info);
	}
	
	public void clickCancelButton()
	{
		driver.getWaitUtility().waitForElementPresent(CANCEL_BUTTON_LOC);
		new ExtendedWebElement(CANCEL_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Cancel button is clicked", MessageTypes.Info);
	}
	
	public void updateEngineProperty(String propertyName)
	{
		Select select=new Select(new ExtendedWebElement(ENGINE_PROPERTY_LOC));
		select.selectByVisibleText(propertyName);
		driver.getAssertionService().addAssertionLog("Engine property is selected to "+propertyName, MessageTypes.Info);
	}
	
	public void updateEngineComparator(String comparator)
	{
		Select select=new Select(new ExtendedWebElement(ENGINE_COMPARATOR_LOC));
		select.selectByVisibleText(comparator);
		driver.getAssertionService().addAssertionLog("Engine comparator is selected to "+comparator, MessageTypes.Info);
	}
	
	public void updateEngineValue(String value)
	{
		new ExtendedWebElement(ENGINE_VALUE_LOC).sendKeys(value);
		driver.getAssertionService().addAssertionLog("Engine property value is set to "+value, MessageTypes.Info);
	}
	
	public void updateDriverProperty(String propertyName)
	{
		new ExtendedWebElement(DRIVER_PROPERTY_LOC).sendKeys(propertyName);
		driver.getAssertionService().addAssertionLog("Driver property name is set to "+propertyName, MessageTypes.Info);
	}
	
	public void updateDriverComparator(String comparator)
	{
		Select select=new Select(new ExtendedWebElement(DRIVER_COMPARATOR_LOC));
		select.selectByVisibleText(comparator);
		driver.getAssertionService().addAssertionLog("Driver comparator is selected to "+comparator, MessageTypes.Info);
	}
	
	public void updateDriverValue(String value)
	{
		new ExtendedWebElement(DRIVER_VALUE_LOC).sendKeys(value);
		driver.getAssertionService().addAssertionLog("Driver property value is set to "+value, MessageTypes.Info);
	}
	
	public void clickOnPlusIconOnEngineRules()
	{
		driver.getWaitUtility().waitForElementPresent(ADD_ICON_FOR_ENGINE_LOC);
		new ExtendedWebElement(ADD_ICON_FOR_ENGINE_LOC).click();
		driver.getAssertionService().addAssertionLog("+ icon is clicked for engine rule", MessageTypes.Info);
	}
	
	public void clickOnPlusIconOnDriverRules()
	{
		driver.getWaitUtility().waitForElementPresent(ADD_ICON_FOR_DRIVER_LOC);
		new ExtendedWebElement(ADD_ICON_FOR_DRIVER_LOC).click();
		driver.getAssertionService().addAssertionLog("+ icon is clicked for driver rule", MessageTypes.Info);
	}
	
	public void verifyValuePresent(String value)
	{
		addStaticWait(5000);
		driver.getAssertionService().assertElementPresent(By.xpath(String.format(VERIFICATION_TEXT_LOC,value)), "value "+value);
	}
	
	public void verifyValueNotPresent(String value)
	{
		addStaticWait(5000);
		driver.getAssertionService().assertElementNotPresent(By.xpath(String.format(VERIFICATION_TEXT_LOC,value)), "value "+value);
	}
	
	public void clickEditForRules(String value)
	{
		driver.getWaitUtility().waitForElementPresent(String.format(EDIT_BUTTON_ON_RULE_LOC, value));
		new ExtendedWebElement(String.format(EDIT_BUTTON_ON_RULE_LOC, value)).click();
		driver.getAssertionService().addAssertionLog("Edit button is clicked for rule with value "+value, MessageTypes.Info);
	}
	
	public void clickDeleteForRules(String value)
	{
		driver.getWaitUtility().waitForElementPresent(String.format(REMOVE_BUTTON_ON_RULE_LOC, value));
		new ExtendedWebElement(String.format(REMOVE_BUTTON_ON_RULE_LOC, value)).click();
		driver.getAssertionService().addAssertionLog("Remove button is clicked for rule with value "+value, MessageTypes.Info);
	}
	
	public void clickSaveForRules()
	{
		driver.getWaitUtility().waitForElementPresent(SAVE_BUTTON_ON_RULE_LOC);
		new ExtendedWebElement(SAVE_BUTTON_ON_RULE_LOC).click();
		driver.getAssertionService().addAssertionLog("Save button is clicked for rule", MessageTypes.Info);
	}
	
	public void editEngineValue(String value)
	{
		driver.getWaitUtility().waitForElementPresent(EDITED_ENGINE_VALUE_LOC);
		new ExtendedWebElement(EDITED_ENGINE_VALUE_LOC).clear();
		new ExtendedWebElement(EDITED_ENGINE_VALUE_LOC).sendKeys(value);
		driver.getAssertionService().addAssertionLog("Engine value is updated to "+value, MessageTypes.Info);
	}
	
	public void editDriverValue(String value)
	{
		driver.getWaitUtility().waitForElementPresent(EDITED_DRIVER_VALUE_LOC);
		new ExtendedWebElement(EDITED_DRIVER_VALUE_LOC).clear();
		new ExtendedWebElement(EDITED_DRIVER_VALUE_LOC).sendKeys(value);
		driver.getAssertionService().addAssertionLog("Driver value is updated to "+value, MessageTypes.Info);
	}
}
