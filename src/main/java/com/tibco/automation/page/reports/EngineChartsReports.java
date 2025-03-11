package com.tibco.automation.page.reports;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.common.TemplatePage.GSMenu;
import com.tibco.automation.page.common.TopPaginate;

public class EngineChartsReports extends TemplatePage {
	public DataGrid datagrid;
	public ExtendedWebDriver driver;
	public String pageTitle = "Engine Charts";
	public TemplatePage templatePage;
	public TopPaginate topPaginate;

	public EngineChartsReports() {
		super("Engine Charts", GSMenu.ComponentChartsReport);
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
