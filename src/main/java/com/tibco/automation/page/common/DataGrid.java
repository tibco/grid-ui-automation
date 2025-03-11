package com.tibco.automation.page.common;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.BeforeMethod;

import com.google.common.base.Function;
import com.tibco.automation.common.framework.core.Controller;
import com.tibco.automation.common.framework.core.ControllerImpl;
import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.common.framework.webdriver.WebDriverAssertions;
import com.tibco.automation.common.framework.webdriver.WebDriverManager;
import com.tibco.automation.common.utils.PropertiesUtil;
import com.tibco.automation.page.common.Locators.ColumnNames;

public class DataGrid implements Locators.TemplatePageLocators, Locators {
	public ExtendedWebDriver driver;
	public ExtendedWebElement element;

	public String GRID_TABLE_LOC = "//div[@class='dataTables_scroll']";
	public String GRID_TABLE_HEADER_ROW_LOC = GRID_TABLE_LOC + "//div[@class='dataTables_scrollHead']//thead/tr";
	public String GRID_TABLE_HEADER_COL_LOC = GRID_TABLE_HEADER_ROW_LOC + "/th[./div[(text()='%s')]]";
	public String GRID_TABLE_DATA_LOC = GRID_TABLE_LOC + "//div[@class='dataTables_scrollBody']//tbody";
	public String GRID_TABLE_DATA_ROW_LOC = GRID_TABLE_DATA_LOC + "/tr[./td[normalize-space(text())='%s']]";
	public String GRID_TABLE_DATA_ROW_ALL_LOC = GRID_TABLE_DATA_LOC + "/tr";
	public String ROW_LEVEL_ACTIONS_TRAY_LOC = GRID_TABLE_DATA_LOC + "/tr[%d]/td[@class='rowActionCell']";
	public String ROW_LEVEL_ACTION_ELLIPSES_LOC = ROW_LEVEL_ACTIONS_TRAY_LOC + "//img[@data-original-title='Actions']";
	public String ROW_LEVEL_ACTION_ITEMS_POPUP_DIV_LOC = "//div[@class='dijitPopup dijitMenuPopup rowActionDiv']";
	public String ROW_LEVEL_ACTION_REMOVE_LOC = ROW_LEVEL_ACTIONS_TRAY_LOC
			+ "//img[@src='/livecluster/admin/images/icons/ic-delete.svg']";
	public String ROW_LEVEL_ACTION_EDIT_LOC = ROW_LEVEL_ACTIONS_TRAY_LOC
			+ "//img[@src='/livecluster/admin/images/icons/ic-edit.svg']";

	public DataGrid() {
		ExtendedWebDriver driver = WebDriverManager.getDriver();
		this.driver = driver;
	}

	public enum Actions {
		VIEWCOMPONENT("View Component"), COPYCOMPONENT("Copy Component"), EDITCOMPONENT(
				"Edit Component"), ADDCOMPONENTTOUTILITIES("Add Component to Utilities"), ASSIGNCOMPONENTTOACCOUNT(
						"Assign Component to Account"), CLONECOMPONENTFORACCOUNT(
								"Clone Component for Account"), UNPUBLISHCOMPONENT(
										"Unpublish Component"), CHANGEENABLER("Change Enabler"), RUNADHOCSTACK(
												"Run In Ad Hoc Stack"), LOGURLLIST("Log URL List"), PUBLISHCOMPONENT(
														"Publish Component"), REMOVECOMPONENT(
																"Remove Component"), VIEWSTACK("View Stack"), EDITSTACK(
																		"Edit Stack"), COPYSTACK(
																				"Copy Stack"), ASSIGNSTACKTOACCOUNT(
																						"Assign Stack to Account"), CLONESTACKFORACCOUNT(
																								"Clone Stack for Account"), STOPSTACK(
																										"Stop Stack"), RUNSTACKINMANUALMODE(
																												"Run Stack in Manual Mode"), RUNSTACKINAUTOMODE(
																														"Run Stack in Auto Mode"), PUBLISHSTACK(
																																"Publish Stack"), UNPUBLISHSTACK(
																																		"Unpublish Stack"), CREATEANTSCRIPTPACKAGE(
																																				"Create Ant Script Package"), REMOVESTACK(
																																						"Remove Stack"), VIEWENABLER(
																																								"View Enabler"), EDITENABLER(
																																										"Edit Enabler"), COPYENABLER(
																																												"Copy Enabler"), CLONEENABLERFORACCOUNT(
																																														"Clone Enabler for Account"), REMOVEENABLER(
																																																"Remove Enabler"), ENGINEDETAILS(
																																																		"Engine Details"), KILLENGINE(
																																																				"Kill Engine"), CLEARFROMBLACKLISTS(
																																																						"Clear from Blacklists"), LOGSEARCH(
																																																								"Log Search"), RESTARTCOMPONENT(
																																																										"Restart Component"), AUTOMODE(
																																																												"Autom Mode"), DISABLEDAEMON(
																																																														"Disable Daemon"), DRAINDAEMON(
																																																																"Drain Daemon"), RESTARTDAEMON(
																																																																		"Restart Daemon"), CONFIGUREDAEMON(
																																																																				"Configure Daemon"), MIGRATEDAEMON(
																																																																						"Migrate Daemon"), EDITVIEWPROPERTIES(
																																																																								"Edit/View Properties"), DELETEREPOSITORYENTRY(
																																																																										"Delete Repository Entry"), GOTOSTATISTICSREPORT(
																																																																												"Go To Statistics Report"), STATUSPAGE(
																																																																														"Status Page"), VIRTUALROUTERPROPERTIES(
																																																																																"VirtualRouter Properties"), DISCONNECTVIRTUALROUTER(
																																																																																		"Disconnect VirtualRouter"), PUBLISHCHANGES(
																																																																																				"Publish Changes"), EDITUSER(
																																																																																						"Edit User"), CHANGEPASSWORD(
																																																																																								"Change Password"), EMAILUSER(
																																																																																										"Email User"), DELETEUSER(
																																																																																												"Delete User"), USERACTIONS(
																																																																																														"User Actions"), EDITACCOUNT(
																																																																																																"Edit Account"), DELETEACCOUNT(
																																																																																																		"Delete Account"), ROLEDETAILS(
																																																																																																				"Role Details"), EDITROLE(
																																																																																																						"Edit Role"), COPYROLE(
																																																																																																								"Copy Role"), REMOVEROLE(
																																																																																																										"Remove Role");

		String title;

		public String getTitle() {
			return title;
		}

		private Actions(String title) {
			this.title = title;
		}

		public String getActionItemLoc() {
			return String.format(ACTION_ITEM_POPUP_LOC, title);

		}

	}

	public int getRowIndexWithColData(String columnName, String colData) {
		int colIndex = getColumnHeaderIndex(columnName);
		return getRowIndexWithColIndex(colIndex, colData);
	}

	public int getRowIndexWithColIndex(int columnIndex, String colData) {
		String rowElement = String.format(GRID_TABLE_DATA_LOC + "/tr[./td[%d][normalize-space(text())='%s']]",
				columnIndex, colData);
		int rowIndex = getElementIndex(rowElement);
		return rowIndex;
	}

	public int getRowIndex(String... data) {
		StringBuilder strb = new StringBuilder();
		int rowPosition = 0;
		if (data != null && data.length > 0) {
			for (String text : data) {
				strb.append(String.format("[./td[normalize-space(text())='%s']]", text));
			}
		}
		String completeXpath = String.format(GRID_TABLE_DATA_LOC + "/tr%s", strb);
		if (driver.findElementByXPath(completeXpath).isDisplayed()) {
			By xpath = By.xpath(completeXpath + "/preceding-sibling::tr");
			if (driver.findElements(xpath).size() == 0) {
				rowPosition = rowPosition + 1;
			} else {
				rowPosition = driver.findElements(xpath).size() + 1;
			}
		} else {
			WebDriverAssertions.fail("Row with data is not present in table.");
		}
		return rowPosition;
	}

	public int getRowIndexWithMultiColData(String columnName1, String colData1, String columnName2, String colData2) {
		int colIndex1 = getColumnHeaderIndex(columnName1);
		int colIndex2 = getColumnHeaderIndex(columnName2);
		String rowElemet = String.format(
				GRID_TABLE_DATA_LOC
						+ "/tr[./td[%d][normalize-space(text())='%s'] and ./td[%d][normalize-space(text())='%s']]",
				colIndex1, colData1, colIndex2, colData2);
		int rowIndex = getElementIndex(rowElemet);
		return rowIndex;
	}

	public int getElementIndex(String xpath) {
		By xpathVariable = By.xpath(xpath + "/preceding-sibling::*");
		int colPosition = 0;
		if (driver.findElementByXPath(xpath).isDisplayed()) {
			if (driver.findElements(xpathVariable).size() == 0) {
				colPosition = colPosition + 1;
			} else {
				colPosition = driver.findElements(xpathVariable).size() + 1;
			}
		} else {
			WebDriverAssertions.fail("Element is not present in table.");
		}

		return colPosition;
	}

	public void clickRemoveIconFromRow(String dataInTheRow) {
		waitForDataTableToLoad();
		ExtendedWebElement rowLocation = new ExtendedWebElement(
				By.xpath(String.format(GRID_TABLE_DATA_ROW_LOC, dataInTheRow)));
		if (rowLocation.isPresent()) {
			int rowIndex = getRowIndex(dataInTheRow);
			ExtendedWebElement Delete = driver
					.findElement(By.xpath(String.format(ROW_LEVEL_ACTION_REMOVE_LOC, rowIndex)));
			((HasInputDevices) driver).getMouse().mouseMove(Delete.getCoordinates());
			Delete.click();
			addStaticWait(1000);
			if (isAlertPresent())
				driver.switchTo().alert().accept();
		} else {
			driver.getAssertionService().addAssertionLog("Row with data " + dataInTheRow + " is not present in table.",
					MessageTypes.Fail);
		}
	}

	public void clickEditIconFromRow(String dataInTheRow) {
		waitForDataTableToLoad();
		ExtendedWebElement rowLocation = new ExtendedWebElement(
				By.xpath(String.format(GRID_TABLE_DATA_ROW_LOC, dataInTheRow)));
		if (rowLocation.isPresent()) {
			int rowIndex = getRowIndex(dataInTheRow);
			ExtendedWebElement Edit = driver.findElement(By.xpath(String.format(ROW_LEVEL_ACTION_EDIT_LOC, rowIndex)));
			((HasInputDevices) driver).getMouse().mouseMove(Edit.getCoordinates());
			Edit.click();
			addStaticWait(1000);
			if (isAlertPresent())
				driver.switchTo().alert().accept();
		} else {
			driver.getAssertionService().addAssertionLog("Row with data " + dataInTheRow + " is not present in table.",
					MessageTypes.Fail);
		}
	}

	public int getColumnHeaderIndex(String columnName) {
		By xpath = By.xpath(String.format(GRID_TABLE_HEADER_COL_LOC + "/preceding-sibling::th", columnName));
		int colPosition = 0;
		if (driver.findElementByXPath(String.format(GRID_TABLE_HEADER_COL_LOC, columnName)).isDisplayed()) {
			if (driver.findElements(xpath).size() == 0) {
				colPosition = colPosition + 1;
			} else {
				colPosition = driver.findElements(xpath).size() + 1;
			}
		} else {
			WebDriverAssertions.fail("Column is not present in table header.");
		}
		return colPosition;
	}

	public int getRowIndex(String rowData) {
		By xpath = By.xpath(String.format(GRID_TABLE_DATA_ROW_LOC + "/preceding-sibling::tr", rowData));
		int rowPosition = 0;
		if (driver.findElementByXPath(String.format(GRID_TABLE_DATA_ROW_LOC, rowData)).isDisplayed()) {
			if (driver.findElements(xpath).size() == 0) {
				rowPosition = rowPosition + 1;
			} else {
				rowPosition = driver.findElements(xpath).size() + 1;
			}
		} else

		{
			WebDriverAssertions.fail("Row is not present in table.");
		}

		return rowPosition;
	}

	public ExtendedWebElement getRowLoc(String rowData) {
		return new ExtendedWebElement(By.xpath(String.format(GRID_TABLE_DATA_ROW_LOC, rowData)));
	}

	public boolean isColumnPresentWithData(int columnIndex, String colData) {
		boolean isPresent = false;
		if (new ExtendedWebElement(By.xpath(
				String.format(GRID_TABLE_DATA_LOC + "/tr/td[%d][normalize-space(text())='%s']", columnIndex, colData)))
						.isPresent()) {
			isPresent = true;
		}
		return isPresent;
	}

	public boolean isColumnPresentWithData(String columnName, String colData) {
		boolean isPresent = false;
		int colIndex = getColumnHeaderIndex(columnName);
		if (isColumnPresentWithData(colIndex, colData)) {
			isPresent = true;
		}
		return isPresent;
	}

	public boolean isRowPresentWithData(String data) {
		boolean isRowPresent = false;
		if (new ExtendedWebElement(By.xpath(String.format(GRID_TABLE_DATA_ROW_LOC, data))).isPresent()) {
			isRowPresent = true;
		}
		return isRowPresent;
	}

	public boolean isRowPresentWithColumnData(String columnName, String colData) {
		boolean isRowPresent = false;
		int colIndex = getColumnHeaderIndex(columnName);
		new ExtendedWebElement(By.xpath(
				String.format(GRID_TABLE_DATA_LOC + "/tr[./td[%d][normalize-space(text())='%s']]", colIndex, colData)));
		if (new ExtendedWebElement(By.xpath(
				String.format(GRID_TABLE_DATA_LOC + "/tr[./td[%d][normalize-space(text())='%s']]", colIndex, colData)))
						.isPresent()) {
			isRowPresent = true;
		}
		return isRowPresent;
	}

	public boolean isRowPresentWithMultiColumnData(String columnName1, String colData1, String columnName2,
			String colData2) {
		boolean isRowPresent = false;
		int colIndex1 = getColumnHeaderIndex(columnName1);
		int colIndex2 = getColumnHeaderIndex(columnName2);
		if (new ExtendedWebElement(By.xpath(String.format(
				GRID_TABLE_DATA_LOC
						+ "/tr[./td[%d][normalize-space(text())='%s'] and ./td[%d][normalize-space(text())='%s']]",
				colIndex1, colData1, colIndex2, colData2))).isPresent()) {
			isRowPresent = true;
		}
		return isRowPresent;
	}

	public String getColumnData(int rowIndex, int columnIndex) {
		return new ExtendedWebElement(
				By.xpath(String.format(GRID_TABLE_DATA_LOC + "/tr[%d]/td[%d]", rowIndex, columnIndex))).getText();
	}

	public String getColumnData(int rowIndex, String columnName) {
		int colIndex = getColumnHeaderIndex(columnName);
		return getColumnData(rowIndex, colIndex);
	}

	public String getColumnData(String columnName, String rowData) {
		int colIndex = getColumnHeaderIndex(columnName);
		int rowIndex = getRowIndex(rowData);
		return getColumnData(rowIndex, colIndex);
	}

	public void clickRowActionFromEllipses(Actions action, String dataInTheRow) {
		clickActionsIconFromRow(dataInTheRow);
		if (isActionPresent(action)) {
			((HasInputDevices) driver).getMouse()
					.mouseMove(new ExtendedWebElement(By.xpath(action.getActionItemLoc())).getCoordinates());
			new ExtendedWebElement(By.xpath(action.getActionItemLoc())).click();
			addStaticWait(4000);
			if (isAlertPresent()) {
				driver.switchTo().alert().accept();
			}
		} else {
			driver.getAssertionService().addAssertionLog("Failing as " + action + " is not present for " + dataInTheRow,
					MessageTypes.Fail);
		}
	}

	public void clickRowActionFromEllipses(Actions action, int rowIndex) {
		clickActionsIconFromRow(rowIndex);
		if (isActionPresent(action)) {
			new ExtendedWebElement(By.xpath(action.getActionItemLoc())).click();
			addStaticWait(4000);
			if (isAlertPresent()) {
				driver.switchTo().alert().accept();
			}
		} else {
			driver.getAssertionService().addAssertionLog(
					"Failing as " + action + " is not present for row number" + rowIndex, MessageTypes.Fail);
		}
	}

	public void clickActionsIconFromRow(String dataInTheRow) {
		waitForDataTableToLoad();
		ExtendedWebElement rowLocation = new ExtendedWebElement(
				By.xpath(String.format(GRID_TABLE_DATA_ROW_LOC, dataInTheRow)));
		if (rowLocation.isPresent()) {
			int rowIndex = getRowIndex(dataInTheRow);
			ExtendedWebElement ellipsisLoc = driver
					.findElement(By.xpath(String.format(ROW_LEVEL_ACTION_ELLIPSES_LOC, rowIndex)));
			((HasInputDevices) driver).getMouse().mouseMove(ellipsisLoc.getCoordinates());
			ellipsisLoc.click();
			addStaticWait(1000);
			driver.getWaitUtility().waitForElementPresent(By.xpath(ROW_LEVEL_ACTION_ITEMS_POPUP_DIV_LOC));
		} else {
			driver.getAssertionService().addAssertionLog(
					"Ellipses representing actions link is not present for " + dataInTheRow + " in table.",
					MessageTypes.Fail);
		}
	}

	public void clickActionsIconFromRow(int rowIndex) {
		waitForDataTableToLoad();
		ExtendedWebElement rowLocation = new ExtendedWebElement(
				By.xpath(String.format(GRID_TABLE_DATA_ROW_ALL_LOC + "[%d]", rowIndex)));
		if (rowLocation.isPresent()) {
			ExtendedWebElement ellipsisLoc = driver
					.findElement(By.xpath(String.format(ROW_LEVEL_ACTION_ELLIPSES_LOC, rowIndex)));
			((HasInputDevices) driver).getMouse().mouseMove(ellipsisLoc.getCoordinates());
			ellipsisLoc.click();
			addStaticWait(1000);
			driver.getWaitUtility().waitForElementPresent(By.xpath(ROW_LEVEL_ACTION_ITEMS_POPUP_DIV_LOC));
		} else {
			driver.getAssertionService().addAssertionLog(
					"Ellipses representing actions link is not present for Row number" + rowIndex + " in table.",
					MessageTypes.Fail);
		}
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} // try
		catch (NoAlertPresentException Ex) {
			return false;
		} // catch
	}

	public boolean isActionPresent(String data, Actions action) {
		boolean isPresent = false;
		ExtendedWebElement actionItem = new ExtendedWebElement(By.xpath(action.getActionItemLoc()));
		driver.getWaitUtility().waitForElementPresent(By.xpath(
				"//div[@class='dijitPopup dijitMenuPopup rowActionDiv' and not(contains(@style,'display: none'))]"));
		if (actionItem.isPresent()) {
			isPresent = true;
		} else {
		}
		return isPresent;

	}

	public boolean isActionPresent(Actions action) {
		boolean isPresent = false;
		ExtendedWebElement actionItem = new ExtendedWebElement(By.xpath(action.getActionItemLoc()));
		driver.getWaitUtility().waitForElementPresent(By.xpath(
				"//div[@class='dijitPopup dijitMenuPopup rowActionDiv' and not(contains(@style,'display: none'))]"));
		if (actionItem.isPresent()) {
			isPresent = true;
		} else {
		}
		return isPresent;

	}

	public String getViewDetailsPropertyValue(String dataInTheRow, String propertyName) {
		waitForDataTableToLoad();
		ExtendedWebElement rowLoc = getRowLoc(dataInTheRow);
		String propertyValue = null;
		String viewComponentPropertyLoc = rowLoc + "/following-sibling::tr//td[text()='" + propertyName
				+ "']/following-sibling::td";
		ExtendedWebElement propertyWebElement = new ExtendedWebElement(viewComponentPropertyLoc);
		if (propertyWebElement.isPresent()) {
			driver.getAssertionService().addAssertionLog(
					"Property with name " + propertyName + " is present for component" + dataInTheRow,
					MessageTypes.Pass);
			propertyValue = propertyWebElement.getText();
		} else {
			driver.getAssertionService().addAssertionLog(
					"Property with name " + propertyName + " is not present for component" + dataInTheRow,
					MessageTypes.Fail);
		}
		return propertyValue;
	}

	public void verifyViewDetailsPropertyValue(String dataInTheRow, String propertyName, String propertyValue) {
		waitForDataTableToLoad();
		if (getViewDetailsPropertyValue(dataInTheRow, propertyName).equalsIgnoreCase(propertyValue))
			driver.getAssertionService().addAssertionLog("Property with name " + propertyName
					+ " is present for component" + dataInTheRow + " with value " + propertyValue, MessageTypes.Pass);
		else
			driver.getAssertionService().addAssertionLog("Property with name " + propertyName
					+ " is not present for component" + dataInTheRow + " with value " + propertyValue,
					MessageTypes.Fail);
	}

	public void verifyColumnValue(String dataInTheRow, String columnName, String columnValue) {
		waitForDataTableToLoad();
		if (getColumnData(columnName, dataInTheRow).equalsIgnoreCase(columnValue))
			driver.getAssertionService().addAssertionLog("Row with data " + dataInTheRow + " is present with value "
					+ columnValue + " in column name " + columnName, MessageTypes.Pass);
		else
			driver.getAssertionService().addAssertionLog("Row with data " + dataInTheRow + " is not present with value "
					+ columnValue + " in column name " + columnName, MessageTypes.Fail);
	}

	public void verifyRowPresent(String rowData) {
		waitForDataTableToLoad();
		if (new ExtendedWebElement(By.xpath(String.format(GRID_TABLE_DATA_ROW_LOC, rowData))).isPresent()) {
			driver.getAssertionService().addAssertionLog("Row is present with data " + rowData + " in the table.",
					MessageTypes.Pass);
		} else {
			driver.getAssertionService().addAssertionLog("Row is not present with data " + rowData + " in the table.",
					MessageTypes.Fail);
		}
	}

	public void verifyRowPresent(String columnName, String columnValue) {
		int columnIndex = getColumnHeaderIndex(columnName);
		if (new ExtendedWebElement(By.xpath(String
				.format(GRID_TABLE_DATA_LOC + "/tr[./td[%d][normalize-space(text())='%s']]", columnIndex, columnValue)))
						.isPresent()) {
			driver.getAssertionService().addAssertionLog(
					"Row is present with " + columnValue + " in column name as " + columnName, MessageTypes.Pass);
		} else {
			driver.getAssertionService().addAssertionLog(
					"Row is not present with " + columnValue + " in column name as " + columnName, MessageTypes.Fail);
		}
	}

	public void verifyRowNotPresent(String rowData) {
		waitForDataTableToLoad();
		if (new ExtendedWebElement(By.xpath(String.format(GRID_TABLE_DATA_ROW_LOC, rowData))).isPresent()) {
			driver.getAssertionService().addAssertionLog("Row is present with data " + rowData + " in the table.",
					MessageTypes.Fail);
		} else {
			driver.getAssertionService().addAssertionLog("Row is not present with data " + rowData + " in the table.",
					MessageTypes.Pass);
		}
	}

	public void verifyRowPresentWithMultiData(String... data) {
		StringBuilder strb = new StringBuilder();
		if (data != null && data.length > 0) {
			for (String text : data) {
				strb.append(String.format("[./td[normalize-space(text())='%s']]", text));
			}
		}
		String completeXpath = String.format(GRID_TABLE_DATA_LOC + "/tr%s", strb);
		By xpath = By.xpath(completeXpath);
		if (new ExtendedWebElement(xpath).isPresent()) {
			driver.getAssertionService().addAssertionLog("Row is present.", MessageTypes.Pass);
		} else {
			driver.getAssertionService().addAssertionLog("Row is not present.", MessageTypes.Fail);
		}
	}

	public void verifyRowNotPresent(String columnName, String columnValue) {
		int columnIndex = getColumnHeaderIndex(columnName);
		if (new ExtendedWebElement(By.xpath(String
				.format(GRID_TABLE_DATA_LOC + "/tr[./td[%d][normalize-space(text())='%s']]", columnIndex, columnValue)))
						.isPresent()) {
			driver.getAssertionService().addAssertionLog(
					"Row is present with " + columnValue + " in column name as " + columnName, MessageTypes.Fail);
		} else {
			driver.getAssertionService().addAssertionLog(
					"Row is not present with " + columnValue + " in column name as " + columnName, MessageTypes.Pass);
		}
	}

	public String getCurrentValueForComponentStat(String rowData) {
		int rowIndex = getRowIndex(rowData);
		return new ExtendedWebElement(By.xpath(String.format(GRID_TABLE_DATA_LOC + "/tr[%d]/td[5]", rowIndex)))
				.getText();
	}

	public boolean waitForColumnDataToPresent(int rowIndex, String columnName, String columnData) {
		int colIndex = getColumnHeaderIndex(columnName);
		ExtendedWebElement colValue = new ExtendedWebElement(By.xpath(String.format(
				GRID_TABLE_DATA_LOC + "/tr[%d]/td[%d][normalize-space(text())='%s']", rowIndex, colIndex, columnData)));
		FluentWait<ExtendedWebDriver> wait = new FluentWait<ExtendedWebDriver>(driver)
				.withTimeout(120, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);

		boolean foo = wait.until(new Function<ExtendedWebDriver, Boolean>() {
			public Boolean apply(ExtendedWebDriver driver) {
				try {
					if (colValue.isPresent())
						return true;
					else
						return false;
				} catch (Exception e) {
					return false;
				}
			}
		});

		return foo;

	}

	public boolean waitForDataTableToLoad() {
		addStaticWait(1000);
		FluentWait<ExtendedWebDriver> wait = new FluentWait<ExtendedWebDriver>(driver)
				.withTimeout(Long.valueOf(PropertiesUtil.getBundle().getProperty("webdriver.wait.timeout").toString()),
						TimeUnit.MILLISECONDS)
				.pollingEvery(2000, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);

		boolean foo = wait.until(new Function<ExtendedWebDriver, Boolean>() {
			public Boolean apply(ExtendedWebDriver driver) {
				try {
					if (((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"))
						return true;
					else
						return false;
				} catch (Exception e) {
					return false;
				}
			}
		});

		return foo;
	}

	public void addStaticWait(int waitTimeInMillis) {
		try {
			Thread.sleep(waitTimeInMillis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
