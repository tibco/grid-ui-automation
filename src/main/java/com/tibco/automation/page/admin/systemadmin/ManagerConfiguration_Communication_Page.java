package com.tibco.automation.page.admin.systemadmin;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.Locators;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.common.TopPaginate;

public class ManagerConfiguration_Communication_Page extends TemplatePage implements Locators.ManagerConfiguration_CommunicationPageLocators{

	public DataGrid datagrid; // these are class references
	public ExtendedWebDriver driver;
	public String pageTitle ="System Admin";
	public TemplatePage templatePage;
	public TopPaginate topPaginate;

	public ManagerConfiguration_Communication_Page() {
		super("Manager Configuration", GSMenu.ManagerConfiguration);
		System.out.println("GSMenu..!!");
		datagrid = new DataGrid(); // as already defined above we are just intializing
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

	public void launchCommunicationPage()
	{
		driver.getAssertionService().addAssertionLog("Launching Communication page", MessageTypes.Info);
		new ExtendedWebElement(COMMUNICATION_SIDE_MENU_LOC).click();
		driver.getWaitUtility().waitForElementPresent(EXPAND_COLLAPSE_VERIFICATION_TEXT_LOC);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(EXPAND_COLLAPSE_VERIFICATION_TEXT_LOC).isPresent(), "Communication page is not launched", "Communication page is launched");
	}
	
	public void expandAll()
	{
		driver.getWaitUtility().waitForElementPresent(EXPAND_ALL_LOC);
		new ExtendedWebElement(EXPAND_ALL_LOC).click();
		driver.getWaitUtility().waitForElementVisible(EXPAND_COLLAPSE_VERIFICATION_TEXT_LOC);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(EXPAND_COLLAPSE_VERIFICATION_TEXT_LOC).isDisplayed(), "Expand all button is not clicked", "Expand all button is clicked");
	}
	
	public void collapseAll()
	{
		driver.getWaitUtility().waitForElementPresent(COLLAPSE_ALL_LOC);
		new ExtendedWebElement(COLLAPSE_ALL_LOC).click();
		driver.getAssertionService().assertFalse(new ExtendedWebElement(EXPAND_COLLAPSE_VERIFICATION_TEXT_LOC).isDisplayed(), "Collapse all button is not clicked", "Collapse all button is clicked");
	}
	
	public void clickSave()
	{
		driver.getWaitUtility().waitForElementPresent(SAVE_BUTTON_LOC);
		new ExtendedWebElement(SAVE_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Save button clicked", MessageTypes.Info);
	}
	
	public void clickCancel()
	{
		driver.getWaitUtility().waitForElementPresent(CANCEL_BUTTON_LOC);
		new ExtendedWebElement(CANCEL_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Cancel button clicked", MessageTypes.Info);
	}

	public void selectTranslateInsideRange(String value)
	{
		((JavascriptExecutor) driver).executeScript(
				"window.scrollBy(0,250)", "");
		Select logLevelSelect=new Select(new ExtendedWebElement(TRANSLATE_INSIDE_RANGE_SELECT_LOC));
		logLevelSelect.selectByValue(value);
		WebElement option=logLevelSelect.getFirstSelectedOption();
		driver.getAssertionService().assertTrue((option.getText()).equalsIgnoreCase(value), "Translate inside range is not set to "+value, "Translate inside range is set to "+value);
	}
	
	public void verifySavedValue(String value)
	{
		Select logLevelSelect=new Select(new ExtendedWebElement(TRANSLATE_INSIDE_RANGE_SELECT_LOC));
		((JavascriptExecutor) driver).executeScript(
				"window.scrollBy(0,250)", "");
		WebElement option=logLevelSelect.getFirstSelectedOption();
		driver.getAssertionService().assertTrue((option.getText()).equalsIgnoreCase(value), "Value is not saved to  "+value, "Value is saved to "+value);
	}
	
	public void verifyCancelledValue(String value)
	{
		Select logLevelSelect=new Select(new ExtendedWebElement(TRANSLATE_INSIDE_RANGE_SELECT_LOC));
		((JavascriptExecutor) driver).executeScript(
				"window.scrollBy(0,250)", "");
		WebElement option=logLevelSelect.getFirstSelectedOption();
		driver.getAssertionService().assertFalse((option.getText()).equalsIgnoreCase(value), "Value is saved to "+value, "Value is not saved to "+value);
	}
	
	public void collapseHeader()
	{
		new ExtendedWebElement(NAT_TRANSLATION_MANAGEMENT_HEADER_LOC).click();
		driver.getWaitUtility().waitForElementNotPresent(EXPAND_COLLAPSE_VERIFICATION_TEXT_LOC);
		driver.getAssertionService().assertFalse(new ExtendedWebElement(EXPAND_COLLAPSE_VERIFICATION_TEXT_LOC).isDisplayed(), "Collapse from header is not working", "Collapse from header is working fine");
	}
	
	public void expandHeader()
	{
		new ExtendedWebElement(NAT_TRANSLATION_MANAGEMENT_HEADER_LOC).click();
		driver.getWaitUtility().waitForElementVisible(EXPAND_COLLAPSE_VERIFICATION_TEXT_LOC);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(EXPAND_COLLAPSE_VERIFICATION_TEXT_LOC).isDisplayed(), "Expand from header is not working", "Expand from header is working fine");
	}
	
	public void verifyDescriptionTooltip()
	{
		driver.getWaitUtility().waitForElementPresent(MANAGER_ID_DESCRIPTION_TOOLTIP);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(MANAGER_ID_DESCRIPTION_TOOLTIP).isDisplayed(), "Tooltip for description is not present", "Tooltip for description is present");
	}
	
	public void verifyNumericDataTooltip()
	{
		((JavascriptExecutor) driver).executeScript(
				"window.scrollBy(0,1000)", "");
		driver.getWaitUtility().waitForElementPresent(SELF_PING_PERIOD_TOOLTIP_LOC);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(SELF_PING_PERIOD_TOOLTIP_LOC).isDisplayed(), "Tooltip for numeric data is not present", "Tooltip for numeric data is present");
	}
	
}
