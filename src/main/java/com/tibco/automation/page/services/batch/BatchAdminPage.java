package com.tibco.automation.page.services.batch;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.Locators;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.common.TopPaginate;

public class BatchAdminPage extends TemplatePage implements Locators,Locators.EngineAdminPageLocators{

	public DataGrid datagrid; // these are class references
	public ExtendedWebDriver driver;
	public String pageTitle ="Services";
	public TemplatePage templatePage;
	public TopPaginate topPaginate;
	public static String parentHandle;
	public BatchAdminPage()
	{
		super("Batch Admin", GSMenu.BatchAdmin);
		System.out.println("GSMenu..!!");
		datagrid = new DataGrid(); // as already defined above we are just intializing
		driver = getDriver();
		templatePage = new TemplatePage();
		topPaginate = new TopPaginate();
		System.out.println(" After GSMenu..!!");
	}
	public void verifyRefreshButton()
	{
		driver.getAssertionService().assertTrue((new ExtendedWebElement((REFRESHBUTTON)).isPresent()), "Refresh Button is not present on page", "Refresh Button is present on page");
	}
	
}
