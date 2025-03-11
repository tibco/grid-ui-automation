package com.tibco.automation.page.admin.systemadmin;

import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.Locators;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.common.TopPaginate;
import com.tibco.automation.page.common.TemplatePage.GSMenu;

public class ManagerConfiguration_Hotfixes_Page extends TemplatePage implements Locators.ManagerConfiguration_HotfixesPageLocators{

	public DataGrid datagrid; // these are class references
	public ExtendedWebDriver driver;
	public String pageTitle ="System Admin";
	public TemplatePage templatePage;
	public TopPaginate topPaginate;

	public ManagerConfiguration_Hotfixes_Page() {
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

	public void launchHotfixesPage()
	{
		driver.getAssertionService().addAssertionLog("Launching Hotfixes page", MessageTypes.Info);
		new ExtendedWebElement(HOTFIXES_SIDE_MENU_LOC).click();
		driver.getWaitUtility().waitForElementPresent(EXPAND_ALL_LOC);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(EXPAND_ALL_LOC).isPresent(), "Hotfixes page is not launched", "Hotfixes page is launched");
	}
	
	public void expandAll()
	{
		driver.getWaitUtility().waitForElementPresent(EXPAND_ALL_LOC);
		new ExtendedWebElement(EXPAND_ALL_LOC).click();
		driver.getWaitUtility().waitForElementVisible(EXPAND_VERIFICATION);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(EXPAND_VERIFICATION).isDisplayed(), "Expand all button is not clicked", "Expand all button is clicked");
	}
	
	public void collapseAll()
	{
		driver.getWaitUtility().waitForElementPresent(COLLAPSE_ALL_LOC);
		new ExtendedWebElement(COLLAPSE_ALL_LOC).click();
		driver.getAssertionService().assertFalse(new ExtendedWebElement(COLLAPSE_VERIFICATION).isDisplayed(), "Collapse all button is not clicked", "Collapse all button is clicked");
	}
	
}
