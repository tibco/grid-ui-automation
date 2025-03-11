package com.tibco.automation.page.admin.systemadmin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.Locators;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.common.TopPaginate;
import com.tibco.automation.page.common.TemplatePage.GSMenu;

public class ManagerConfiguration_EnginesAndClients_Page extends TemplatePage implements Locators.ManagerConfiguration_EnginesAndClientsPageLocators{

	public DataGrid datagrid; // these are class references
	public ExtendedWebDriver driver;
	public String pageTitle ="System Admin";
	public TemplatePage templatePage;
	public TopPaginate topPaginate;

	public ManagerConfiguration_EnginesAndClients_Page() {
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

	public void launchEnginesAndClientsPage()
	{
		driver.getAssertionService().addAssertionLog("Launching Engines and Clients page", MessageTypes.Info);
		new ExtendedWebElement(ENGINES_AND_CLIENTS_SIDE_MENU_LOC).click();
		driver.getWaitUtility().waitForElementPresent(EXPAND_COLLAPSE_VERIFICATION_TEXT_LOC);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(EXPAND_COLLAPSE_VERIFICATION_TEXT_LOC).isPresent(), "Engines and Clients page is not launched", "Engines and Clients page is launched");
	}
	
	public void expandAll()
	{
		driver.getWaitUtility().waitForElementPresent(EXPAND_ALL_LOC);
		new ExtendedWebElement(EXPAND_ALL_LOC).click();
		driver.getWaitUtility().waitForElementVisible(LOGIN_WITH_EXPIRED_PASSWORD_SELECT_LOC);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(LOGIN_WITH_EXPIRED_PASSWORD_SELECT_LOC).isDisplayed(), "Expand all button is not clicked", "Expand all button is clicked");
	}
	
	public void collapseAll()
	{
		driver.getWaitUtility().waitForElementPresent(COLLAPSE_ALL_LOC);
		new ExtendedWebElement(COLLAPSE_ALL_LOC).click();
		driver.getAssertionService().assertFalse(new ExtendedWebElement(LOGIN_WITH_EXPIRED_PASSWORD_SELECT_LOC).isDisplayed(), "Collapse all button is not clicked", "Collapse all button is clicked");
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

	public void selectLoginWithExpiredPassword(String value)
	{
		Select logLevelSelect=new Select(new ExtendedWebElement(LOGIN_WITH_EXPIRED_PASSWORD_SELECT_LOC));
		logLevelSelect.selectByValue(value);
		WebElement option=logLevelSelect.getFirstSelectedOption();
		driver.getAssertionService().assertTrue((option.getText()).equalsIgnoreCase(value), "Login with expired password is not set to "+value, "Login with expired password is set to "+value);
	}
	
	public void verifySavedValue(String value)
	{
		Select logLevelSelect=new Select(new ExtendedWebElement(LOGIN_WITH_EXPIRED_PASSWORD_SELECT_LOC));
		WebElement option=logLevelSelect.getFirstSelectedOption();
		driver.getAssertionService().assertTrue((option.getText()).equalsIgnoreCase(value), "Value is not saved to  "+value, "Value is saved to "+value);
	}
	
	public void verifyCancelledValue(String value)
	{
		Select logLevelSelect=new Select(new ExtendedWebElement(LOGIN_WITH_EXPIRED_PASSWORD_SELECT_LOC));
		WebElement option=logLevelSelect.getFirstSelectedOption();
		driver.getAssertionService().assertFalse((option.getText()).equalsIgnoreCase(value), "Value is saved to "+value, "Value is not saved to "+value);
	}
	
	public void collapseHeader()
	{
		new ExtendedWebElement(CLIENT_MANAGEMENT_HEADER_LOC).click();
		driver.getWaitUtility().waitForElementNotPresent(LOGIN_WITH_EXPIRED_PASSWORD_SELECT_LOC);
		driver.getAssertionService().assertFalse(new ExtendedWebElement(LOGIN_WITH_EXPIRED_PASSWORD_SELECT_LOC).isDisplayed(), "Collapse from header is not working", "Collapse from header is working fine");
	}
	
	public void expandHeader()
	{
		new ExtendedWebElement(CLIENT_MANAGEMENT_HEADER_LOC).click();
		driver.getWaitUtility().waitForElementVisible(LOGIN_WITH_EXPIRED_PASSWORD_SELECT_LOC);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(LOGIN_WITH_EXPIRED_PASSWORD_SELECT_LOC).isDisplayed(), "Expand from header is not working", "Expand from header is working fine");
	}
	
	public void verifyDescriptionTooltip()
	{
		driver.getWaitUtility().waitForElementPresent(CLIENT_TIMEOUT_DESCRIPTION_TOOLTIP);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(CLIENT_TIMEOUT_DESCRIPTION_TOOLTIP).isDisplayed(), "Tooltip for description is not present", "Tooltip for description is present");
	}
	
	public void verifyNumericDataTooltip()
	{
		driver.getWaitUtility().waitForElementPresent(CLIENT_TIMEOUT_TOOLTIP_LOC);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(CLIENT_TIMEOUT_TOOLTIP_LOC).isDisplayed(), "Tooltip for numeric data is not present", "Tooltip for numeric data is present");
	}
	
}
