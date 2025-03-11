package com.tibco.automation.page.reports;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.common.TemplatePage.GSMenu;
import com.tibco.automation.page.common.TopPaginate;

public class UserActionsReports extends TemplatePage {
	public DataGrid datagrid;
	public ExtendedWebDriver driver;
	public String pageTitle = "Daemons";
	public TemplatePage templatePage;
	public TopPaginate topPaginate;

	public UserActionsReports() {
		super("Daemons", GSMenu.DaemonsReport);
		datagrid = new DataGrid();
		driver = getDriver();
		templatePage = new TemplatePage();
		topPaginate = new TopPaginate();
	}

	@Override
	public boolean isPageActive(Object... object) {
		return super.verifyPageTitle(pageTitle);
	}

	@Override
	public void waitForPageToLoad() {
		super.waitForPageToLoad();
	}
}
