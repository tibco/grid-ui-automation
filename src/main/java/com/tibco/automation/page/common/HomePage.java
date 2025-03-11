package com.tibco.automation.page.common;

import org.openqa.selenium.By;

import com.tibco.automation.common.components.ExtendedDropDown;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.common.framework.webdriver.WebDriverManager;

public class HomePage extends TemplatePage implements Locators.HomePageLocators {

	public String pageTitle = "Dashboard";
	public GSMenu menu;
	public ExtendedWebDriver driver;

	public HomePage() {
		super("Dashboard", GSMenu.Dashboard);
		ExtendedWebDriver driver = WebDriverManager.getDriver();
		this.driver = driver;
	}

	@Override
	public void launchPage(Object... object) {
		super.launchPage(object);
	}

	public void openComponentStatisticsModal() {
		ExtendedWebElement moreLinkForCompStats = new ExtendedWebElement(
				By.xpath(String.format(STATISTICS_MORE_LONK_LOC, "Component Statistics")));
		moreLinkForCompStats.click();
		driver.getWaitUtility()
				.waitForElementPresent(By.xpath(String.format(MODAL_HEADER_WITH_TITLE_LOC, "Component Statistics")));
	}

	public void openArchiveStatisticsModal() {
		ExtendedWebElement moreLinkForCompStats = new ExtendedWebElement(
				By.xpath(String.format(STATISTICS_MORE_LONK_LOC, "Archive Statistics")));
		moreLinkForCompStats.click();
		driver.getWaitUtility()
				.waitForElementPresent(By.xpath(String.format(MODAL_HEADER_WITH_TITLE_LOC, "Archive Statistics")));
	}

	public void openExternalStatisticsModal() {
		ExtendedWebElement moreLinkForCompStats = new ExtendedWebElement(
				By.xpath(String.format(STATISTICS_MORE_LONK_LOC, "External Statistics")));
		moreLinkForCompStats.click();
		driver.getWaitUtility()
				.waitForElementPresent(By.xpath(String.format(MODAL_HEADER_WITH_TITLE_LOC, "External Statistics")));
	}

	/*public void verifyComponentStatisticsPresentForComponent(String componentName, String... statisticNames) {
		openComponentStatisticsModal();
		ExtendedDropDown selectComp = new ExtendedDropDown(By.xpath(String
				.format(MODAL_HEADER_WITH_TITLE_LOC + "/following-sibling::div//select", "Component Statistics")));
		selectComp.select(componentName);
		for (String statisticName : statisticNames) {
ExtendedWebElement statisticLoc= new ExtendedWebElement(By.xpath(String.format(format, args)))
		}
	}*/

}
