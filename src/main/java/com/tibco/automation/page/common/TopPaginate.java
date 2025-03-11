package com.tibco.automation.page.common;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.HasInputDevices;
import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.page.common.Locators.ButtonsOnModal;
import com.tibco.automation.page.common.Locators.ColumnNames;

public class TopPaginate extends TemplatePage {
	public enum MoreActions {
		STACKPRECEDENCE("Stack Precedence"), PUBLISHUNPUBLISHEDSTACKS(
				"Publish Unpublished Stacks"), RUNALLCOMPONENTSINADHOC(
						"Run All Components in Ad Hoc Stack"), REMOVEALLCOMPONENTSFROMADHOC(
								"Remove All Components from Ad Hoc Stack"), PUBLISHUNPUBLISHEDCOMPONENTS(
										"Publish Unpublished Components"), UPDATEDEPLOYMENTFILES(
												"Update Deployment Files"), PUBLISHALLCHANGES(
														"Publish All Changes"), CANCELALLCHANGES(
																"Cancel All Changes"), RULEPRECEDENCE(
																		"Rule Precedence"), KILLALLENGINESONPAGE(
																				"Kill Engines",
																				"Kill All Engines on Page"), KILLALLENGINES(
																						"Kill Engines",
																						"Kill All Engines"), PURGEALLOFFLINEDAEMONS(
																								"Purge all Offline Daemons"), AUTOMODEFORALLDAEMONS(
																										"Auto Mode",
																										"Auto Mode for All Daemons"), AUTOMODEFORDAEMONSONPAGE(
																												"Auto Mode",
																												"Auto Mode for Daemons on Page"), AUTOMODEFORSELECTEDDAEMONS(
																														"Auto Mode",
																														"Auto Mode for Selected Daemons"), CONFIGUREALLDAEMONS(
																																"Configure",
																																"Configure All Daemons"), CONFIGUREDAEMONSONPAGE(
																																		"Configure",
																																		"Configure Daemons on Page"), CONFIGURESELECTEDDAEMONS(
																																				"Configure",
																																				"Configure Selected Daemons"), DISABLEALLDAEMONS(
																																						"Disable",
																																						"Disable All Daemons"), DISABLEDAEMONSONPAGE(
																																								"Disable",
																																								"Disable Daemons on Page"), DISABLESELECTEDDAEMONS(
																																										"Disable",
																																										"Disable Selected Daemons"), DRAINALLDAEMONS(
																																												"Drain",
																																												"Drain All Daemons"), DRAINDAEMONSONPAGE(
																																														"Drain",
																																														"Drain Daemons on Page"), DRAINSELECTEDDAEMONS(
																																																"Drain",
																																																"Drain Selected Daemons"), ENABLEALLDAEMONS(
																																																		"Enable",
																																																		"Enable All Daemons"), ENABLEDAEMONSONPAGE(
																																																				"Enable",
																																																				"Enable Daemons on Page"), ENABLESELECTEDDAEMONS(
																																																						"Enable",
																																																						"Enable Selected Daemons"), MANUALMODEFORALLDAEMONS(
																																																								"Manual Mode",
																																																								"Manual Mode for All Daemons"), MANUALMODEFORDAEMONSONPAGE(
																																																										"Manual Mode",
																																																										"Manual Mode for Daemons on Page"), MANUALMODEFORSELECTEDDAEMONS(
																																																												"Manual Mode",
																																																												"Manual Mode for Selected Daemons"), MIGRATEALLDAEMONS(
																																																														"Migrate",
																																																														"Migrate All Daemons"), MIGRATEDAEMONSONPAGE(
																																																																"Migrate",
																																																																"Migrate Daemons on Page"), MIGRATESELECTEDDAEMONS(
																																																																		"Migrate",
																																																																		"Migrate Selected Daemons"), SETPROPERTYFORALLDAEMONS(
																																																																				"Set Property",
																																																																				"Set Property for All Daemons"), SETPROPERTYFORDAEMONSONPAGE(
																																																																						"Set Property",
																																																																						"Set Property for Daemons on Page"), SETPROPERTYFORSELECTEDDAEMONS(
																																																																								"Set Property",
																																																																								"Set Property for Selected Daemons"), STOPDRAININGALLDAEMONS(
																																																																										"Stop Draining",
																																																																										"Stop Draining All Daemons"), STOPDRAININGDAEMONSONPAGE(
																																																																												"Stop Draining",
																																																																												"Stop Draining Daemons on Page"), STOPDRAININGSELECTEDDAEMONS(
																																																																														"Stop Draining",
																																																																														"Stop Draining Selected Daemons"), CLEARVMHISTORYOFONEHOUR(
																																																																																"Clear VM History",
																																																																																"Older Than 1 Hr"), CLEARVMHISTORYOFONEDAY(
																																																																																		"Clear VM History",
																																																																																		"Older Than 1 Day"), CLEARVMHISTORYOFONEWEEK(
																																																																																				"Clear VM History",
																																																																																				"Older Than 1 Week"), CLEARVMHISTORYOFONEMONTH(
																																																																																						"Clear VM History",
																																																																																						"Older Than 1 Month"), CLEARVMHISTORYOFALLTIME(
																																																																																								"Clear VM History",
																																																																																								"All"), EDITEMAILNOTIFICATIONTEMPLATE(
																																																																																										"Edit Email Notification Template"), VIEWUSEREVENTS(
																																																																																												"View User Events"), REMOVEALLSESSIONSONPAGE(
																																																																																														"Remove All Sessions on Page"), REMOVEALLSESSIONS(
																																																																																																"Remove All Sessions");

		String title;
		String parentAction;

		public String getTitle() {
			return title;
		}

		public String getParentAction() {
			return parentAction;
		}

		private MoreActions(String parentAction) {
			this.parentAction = parentAction;
		}

		private MoreActions(String parentAction, String title) {
			this.title = title;
			this.parentAction = parentAction;
		}

		public String getLevelOneActionItemLoc() {
			return String.format(GLOBAL_ACTION_LEVEL_ONE_ITEM_LOC, parentAction, parentAction);
		}

		public String getLevelTwoActionItemLoc() {
			return String.format(GLOBAL_ACTION_LEVEL_TWO_ITEM_LOC, parentAction, parentAction, title);
		}

	}

	public void verifyMoreButtonPresent() {
		ExtendedWebElement moreActionLoc = new ExtendedWebElement(By.xpath(MORE_BUTTON_LOC));
		if (moreActionLoc.isPresent()) {
			driver.getAssertionService().addAssertionLog("More button is present on the page.", MessageTypes.Pass);
		} else {
			driver.getAssertionService().addAssertionLog("More button is not present on the page.", MessageTypes.Pass);
		}
	}

	public void verifyMoreButtonNotPresent() {
		ExtendedWebElement moreActionLoc = new ExtendedWebElement(By.xpath(MORE_BUTTON_LOC));
		if (moreActionLoc.isPresent()) {
			driver.getAssertionService().addAssertionLog("More button is present on the page.", MessageTypes.Fail);
		} else {
			driver.getAssertionService().addAssertionLog("More button is not present on the page.", MessageTypes.Pass);
		}
	}

	public void clickMoreButton() {
		ExtendedWebElement moreActionLoc = new ExtendedWebElement(By.xpath(MORE_BUTTON_LOC));
		verifyMoreButtonPresent();
		moreActionLoc.click();
		driver.getWaitUtility().waitForElementPresent(By.xpath(MORE_BUTTON_LOC + "//ul[@class='dropdown-menu show']"));
	}

	public void verifyActionPresentInMoreOption(MoreActions action) {
		ExtendedWebElement levelOneActionLoc = new ExtendedWebElement(By.xpath(action.getLevelOneActionItemLoc()));
		if (action.title != null) {
			((HasInputDevices) driver).getMouse().mouseMove(levelOneActionLoc.getCoordinates());
			ExtendedWebElement levelTwoActionLoc = new ExtendedWebElement(By.xpath(action.getLevelTwoActionItemLoc()));
			if (levelTwoActionLoc.isDisplayed()) {
				driver.getAssertionService().addAssertionLog(
						"Action with name " + action + " is present in More options.", MessageTypes.Pass);
			} else {
				driver.getAssertionService().addAssertionLog(
						"Action with name " + action + " is not present in More options.", MessageTypes.Fail);
			}
		} else {
			if (levelOneActionLoc.isDisplayed()) {
				driver.getAssertionService().addAssertionLog(
						"Action with name " + action + " is present in More options.", MessageTypes.Pass);
			} else {
				driver.getAssertionService().addAssertionLog(
						"Action with name " + action + " is not present in More options.", MessageTypes.Fail);
			}
		}
	}

	public void verifyActionNotPresentInMoreOption(MoreActions action) {
		ExtendedWebElement levelOneActionLoc = new ExtendedWebElement(By.xpath(action.getLevelOneActionItemLoc()));
		if (action.title != null) {
			((HasInputDevices) driver).getMouse().mouseMove(levelOneActionLoc.getCoordinates());
			ExtendedWebElement levelTwoActionLoc = new ExtendedWebElement(By.xpath(action.getLevelTwoActionItemLoc()));
			if (levelTwoActionLoc.isDisplayed()) {
				driver.getAssertionService().addAssertionLog(
						"Action with name " + action + " is present in More options.", MessageTypes.Fail);
			} else {
				driver.getAssertionService().addAssertionLog(
						"Action with name " + action + " is not present in More options.", MessageTypes.Pass);
			}
		} else {
			if (levelOneActionLoc.isDisplayed()) {
				driver.getAssertionService().addAssertionLog(
						"Action with name " + action + " is present in More options.", MessageTypes.Fail);
			} else {
				driver.getAssertionService().addAssertionLog(
						"Action with name " + action + " is not present in More options.", MessageTypes.Pass);
			}
		}
	}

	public void clickActionFromMoreOption(MoreActions action) {
		ExtendedWebElement levelOneActionLoc = new ExtendedWebElement(By.xpath(action.getLevelOneActionItemLoc()));
		if (action.title != null) {
			((HasInputDevices) driver).getMouse().mouseMove(levelOneActionLoc.getCoordinates());
			ExtendedWebElement levelTwoActionLoc = new ExtendedWebElement(By.xpath(action.getLevelTwoActionItemLoc()));
			if (levelTwoActionLoc.isDisplayed()) {
				levelTwoActionLoc.click();
				driver.getAssertionService().addAssertionLog(
						"Clicked on Action with name " + action + " from More options.", MessageTypes.Pass);
			} else {
				driver.getAssertionService().addAssertionLog(
						"Action with name " + action + " is not present in More options to click.", MessageTypes.Fail);
			}
		} else {
			if (levelOneActionLoc.isDisplayed()) {
				levelOneActionLoc.click();
				driver.getAssertionService().addAssertionLog(
						"Clicked on Action with name " + action + " from More options.", MessageTypes.Pass);
			} else {
				driver.getAssertionService().addAssertionLog(
						"Action with name " + action + " is not present in More options to click.", MessageTypes.Fail);
			}
		}
	}

	public void verifyColumnSelectorPresent() {
		ExtendedWebElement columnSelector = new ExtendedWebElement(By.xpath(COLUMNS_SELECTOR_BUTTON_LOC));
		if (columnSelector.isPresent()) {
			driver.getAssertionService().addAssertionLog("Column selector button is present on page.",
					MessageTypes.Pass);
		} else {
			driver.getAssertionService().addAssertionLog("Column selector button is not present on page.",
					MessageTypes.Fail);
		}
	}

	public void clickColumnSelectorButton() {
		ExtendedWebElement columnSelector = new ExtendedWebElement(By.xpath(COLUMNS_SELECTOR_BUTTON_LOC));
		columnSelector.click();
		driver.getWaitUtility().waitForElementPresent(By.xpath(COLUMNS_SELECTOR_POPUP_LOC));
	}

	public void verifyNameInColumnSelectorPopup(ColumnNames columnName) {
		ExtendedWebElement columnNameLoc = new ExtendedWebElement(
				By.xpath(String.format(COLUMNS_SELECTOR_POPUP_LOC + "//li[text()='%s']", columnName)));
		if (columnNameLoc.isPresent()) {
			driver.getAssertionService().addAssertionLog("Name " + columnName + " is present in column selector popup.",
					MessageTypes.Pass);
		} else {
			driver.getAssertionService().addAssertionLog(
					"Name " + columnName + " is not present in column selector popup.", MessageTypes.Fail);
		}
	}

	public void verifyNameInSelectedColumnListFromPopup(ColumnNames columnName) {
		verifyNameInColumnSelectorPopup(columnName);
		ExtendedWebElement columnNameLoc = new ExtendedWebElement(
				By.xpath(String.format(COLUMNS_SELECTOR_POPUP_LOC + "//ol/li[text()='%s']", columnName)));
		if (columnNameLoc.isPresent()) {
			driver.getAssertionService().addAssertionLog(
					"Name " + columnName + " is present in selected column names list.", MessageTypes.Pass);
		} else {
			driver.getAssertionService().addAssertionLog(
					"Name " + columnName + " is not present in column selected column names list.", MessageTypes.Fail);
		}
	}

	public void verifyNameInAvailableColumnListFromPopup(ColumnNames columnName) {
		verifyNameInColumnSelectorPopup(columnName);
		ExtendedWebElement columnNameLoc = new ExtendedWebElement(
				By.xpath(String.format(COLUMNS_SELECTOR_POPUP_LOC + "//ul/li[text()='%s']", columnName)));
		if (columnNameLoc.isPresent()) {
			driver.getAssertionService().addAssertionLog("Name " + columnName + " is present in Add column names list.",
					MessageTypes.Pass);
		} else {
			driver.getAssertionService().addAssertionLog(
					"Name " + columnName + " is not present in Add column names list.", MessageTypes.Fail);
		}
	}

	public void addColumnToSelectedColumnNames(ColumnNames columnName) {
		clickColumnSelectorButton();
		ExtendedWebElement columnNameLoc = new ExtendedWebElement(
				By.xpath(String.format(COLUMNS_SELECTOR_POPUP_LOC + "//ul/li[text()='%s']", columnName)));
		if (columnNameLoc.isPresent()) {
			columnNameLoc.click();
			verifyNameInSelectedColumnListFromPopup(columnName);
		} else {
			driver.getAssertionService().addAssertionLog(
					"Name " + columnName + " is not present in Add column names list.", MessageTypes.Fail);
		}
	}

	public void removeColumnFromSelectedColumnNames(ColumnNames columnName) {
		clickColumnSelectorButton();
		ExtendedWebElement columnNameLoc = new ExtendedWebElement(
				By.xpath(String.format(COLUMNS_SELECTOR_POPUP_LOC + "//ol/li[text()='%s']", columnName)));
		if (columnNameLoc.isPresent()) {
			columnNameLoc.click();
			verifyNameInAvailableColumnListFromPopup(columnName);
		} else {
			driver.getAssertionService().addAssertionLog(
					"Name " + columnName + " is not present in Selected column names list.", MessageTypes.Fail);
		}
	}

	public void clickButtonFromColumnSelectorPopup(ButtonsOnModal button) {
		ExtendedWebElement columnNameLoc = new ExtendedWebElement(
				By.xpath(String.format(COLUMNS_SELECTOR_POPUP_LOC + "//button[text()='%s']", button)));
		columnNameLoc.click();
	}

	public void searchInTable(String searchString) {
		ExtendedWebElement searchInputLoc = new ExtendedWebElement(By.xpath("//input[@type='search']"));
		searchInputLoc.sendKeys(searchString);
		searchInputLoc.sendKeys(Keys.ENTER);
	}

	public void refreshPage() {
		By refreshButtonLoc = By
				.xpath("//div[normalize-space(@class)='topaginate']//div[@class='btn-group refreshButton']//img");
		driver.getWaitUtility().waitForElementPresent(refreshButtonLoc);
		new ExtendedWebElement(refreshButtonLoc).click();
	}
}
