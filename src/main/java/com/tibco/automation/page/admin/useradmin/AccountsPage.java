package com.tibco.automation.page.admin.useradmin;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.common.TopPaginate;
import com.tibco.automation.page.common.TemplatePage.GSMenu;

public class AccountsPage extends TemplatePage {
	public DataGrid datagrid;
	public ExtendedWebDriver driver;
	public String pageTitle = "Accounts";
	public TemplatePage templatePage;
	public TopPaginate topPaginate;

	public AccountsPage() {
		super("Accounts", GSMenu.Accounts);
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
