package com.tibco.automation.page.common;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.HasInputDevices;
import com.tibco.automation.common.components.ExtendedDropDown;
import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.common.framework.webdriver.WebDriverManager;

public class StackBuilder extends TemplatePage implements Locators.TemplatePageLocators, Locators.StacksPageLocators {
	public ExtendedWebDriver driver;

	public StackBuilder() {
		ExtendedWebDriver driver = WebDriverManager.getDriver();
		this.driver = driver;
	}

	public enum RuleType {
		COMPONENTDEPENDENCY("Component Dependency"), ENABLEMENTCONDITION("Enablement Condition"), RESOURCEPREFERENCE(
				"Resource Preference"), THRESHOLDACTIVATION(
						"Threshold Activation"), ENGINEGROUPMINMAX("Engine Group Min/Max");
		String title;

		public String getTitle() {
			return title;
		}

		private RuleType(String title) {
			this.title = title;
		}
	}

	public enum ResourcePreferenceName {
		ENGINEID("Engine Id"), ENGINEGUID("Engine GUID"), ENGINEINSTANCE("Engine Instance"), IPADDRESS(
				"IP Address"), HOSTNAME("Host Name"), NUMBEROFCPU("Number of CPUs"), TOTALCPUPROCESSINGPOWER(
						"Total CPU Processing Power"), DOCKERENABLED("Docker Enabled"), DOCKERVERSIONINFO(
								"Docker Version Info"), TOTALMEMORYINKB("Total Memory (KB)"), FREEMEMORYINKB(
										"Free Memory (KB)"), FREEDISKSPACEINKB("Free Disk Space (MB)"), OSPLATFORM(
												"OS Platform"), OSVERSION("OS Version"), OSUSERNAME(
														"OS Username"), ENGINECONFIGNAME("Engine Config Name"), GROUP(
																"Group"), USERNAME("Username"), EC2AMIID(
																		"ec2AmiId"), LOCATION("Location"), VIMTEMPLATE(
																				"vimTemplate"), ASSETMANAGERID(
																						"AssetManagerId"), EC2INSTANCETYPE(
																								"ec2InstanceType"), DESCRIPTION(
																										"Description");
		String title;

		public String getTitle() {
			return title;
		}

		private ResourcePreferenceName(String title) {
			this.title = title;
		}
	}

	public enum ResourcePreferenceOperator {
		MATCHES("matches"), GREATERTHAN("greater than"), NOTMATCHES("not matches"), NOTEQUAL("not equal"), STARTSWITH(
				"starts with"), CONTAINS("contains"), EQUAL("equal"), LESSTHAN("less than"), GREATERTHANOREQUAL(
						"greater than or equal"), LESSTHANOREQUAL("less than or equal");
		String title;

		public String getTitle() {
			return title;
		}

		private ResourcePreferenceOperator(String title) {
			this.title = title;
		}
	}

	public enum ResourcePreferenceLevel {
		REQUIRED("Required"), STRONGLYPREFERRED("Strongly Preferred"), PREFERRED("Preferred"), NEUTRAL(
				"Neutral"), DISCOURAGED(
						"Discouraged"), STRONGLYDISCOURAGED("Strongly Discouraged"), PROHIBITED("Prohibited");
		String title;

		public String getTitle() {
			return title;
		}

		private ResourcePreferenceLevel(String title) {
			this.title = title;
		}
	}

	public void fillStackNameDisplayNameAndDescription(String stackName, String displayName, String stackDescription) {
		waitForPageToLoad();
		new ExtendedWebElement(By.xpath(STACK_BUILDER_NAME_INPUT_LOC)).sendKeys(stackName);
		new ExtendedWebElement(By.xpath(STACK_BUILDER_DESC_INPUT_LOC)).sendKeys(stackDescription);
		new ExtendedWebElement(By.xpath(STACK_BUILDER_DISPLAYNAME_INPUT_LOC)).sendKeys(displayName);
	}

	public void waitForPageToLoad() {
		driver.getWaitUtility().waitForElementVisible(BACK_LINK_LOC_ON_PAGES);
	}

	public void addComponentsToStack(String... components) {
		for (String component : components) {
			new ExtendedWebElement(By.xpath(STACK_COMPONENTS_EXPAND_LOC)).click();
			driver.getWaitUtility().waitForElementVisible(By.xpath(AVAILABLE_COMPONENTS_SELECT_LOC));
			new ExtendedWebElement(String.format(AVAILABLE_COMPONENTS_SELECT_LOC + "//a[text()='%s']", component))
					.click();
			if (isComponentsInAvailableList(component)) {
				driver.getAssertionService().addAssertionLog(
						"Component " + component + " is still present in available component list.", MessageTypes.Fail);
			} else {
				driver.getAssertionService().addAssertionLog(
						"Component " + component + " is added to selected component list.", MessageTypes.Pass);
			}
		}
		addStaticWait(1000);
	}

	public void removeComponentsFromStack(String... components) {
		for (String component : components) {
			driver.getWaitUtility().waitForElementVisible(By.xpath("//div[@id='cmpnsList']"));
			ExtendedWebElement selectedComponentsLoc = new ExtendedWebElement(
					String.format(SELECTED_COMPONENTS_ROW_LOC, component));
			((HasInputDevices) driver).getMouse().mouseMove(selectedComponentsLoc.getCoordinates());
			selectedComponentsLoc.click();
			if (isComponentsInSelectedList(component)) {
				driver.getAssertionService().addAssertionLog(
						"Component " + component + " is not successfully deleted from selected component list.",
						MessageTypes.Fail);
			} else {
				driver.getAssertionService().addAssertionLog(
						"Component " + component + " is successfully deleted from selected component list.",
						MessageTypes.Pass);
			}
		}
		addStaticWait(1000);
	}

	public boolean isComponentsInAvailableList(String component) {
		boolean isPresent = false;
		new ExtendedWebElement(By.xpath(STACK_COMPONENTS_EXPAND_LOC)).click();
		driver.getWaitUtility().waitForElementVisible(By.xpath(AVAILABLE_COMPONENTS_SELECT_LOC));
		ExtendedWebElement componentLoc = new ExtendedWebElement(
				String.format(AVAILABLE_COMPONENTS_SELECT_LOC + "//a[text()='%s']", component));
		if (componentLoc.isPresent()) {
			isPresent = true;
		}
		return isPresent;

	}

	public boolean isComponentsInSelectedList(String component) {
		boolean isPresent = false;
		driver.getWaitUtility().waitForElementVisible(By.xpath("//div[@id='cmpnsList']"));
		ExtendedWebElement selectedComponentsLoc = new ExtendedWebElement(
				String.format(SELECTED_COMPONENTS_ROW_LOC, component));
		if (selectedComponentsLoc.isPresent()) {
			isPresent = true;
		}
		return isPresent;

	}

	public void expandAccordion(String title) {
		if (isAccordionExpanded(title)) {
			driver.getAssertionService().addAssertionLog("Accordion is already expanded.", MessageTypes.Info);
		} else {
			ExtendedWebElement collapsed_loc = new ExtendedWebElement(
					By.xpath(String.format(COLLAPSED_ACCORDION_DIV_LOC + "//a[normalize-space(text())='%s']", title)));
			collapsed_loc.click();
		}
	}

	public void collapseAccordion(String title) {
		if (isAccordionCollapsed(title)) {
			driver.getAssertionService().addAssertionLog("Accordion is already collapsed.", MessageTypes.Info);
		} else {
			ExtendedWebElement collapsed_loc = new ExtendedWebElement(
					By.xpath(String.format(EXPANDED_ACCORDION_DIV_LOC + "//a[normalize-space(text())='%s']", title)));
			collapsed_loc.click();
		}
	}

	public boolean isAccordionExpanded(String title) {
		boolean isExpanded = false;
		ExtendedWebElement expanded_loc = new ExtendedWebElement(
				By.xpath(String.format(EXPANDED_ACCORDION_DIV_LOC + "//a[normalize-space(text())='%s']", title)));
		if (expanded_loc.isPresent()) {
			isExpanded = true;
		}
		return isExpanded;
	}

	public boolean isAccordionCollapsed(String title) {
		boolean isCollapsed = false;
		ExtendedWebElement collapsed_loc = new ExtendedWebElement(
				By.xpath(String.format(COLLAPSED_ACCORDION_DIV_LOC + "//a[normalize-space(text())='%s']", title)));
		if (collapsed_loc.isPresent()) {
			isCollapsed = true;
		}
		return isCollapsed;
	}

	public void setMinMaxEnginesForComponent(String componentName, int min, int max) {
		driver.getAssertionService().addAssertionLog("Setting min engines as " + min + " and max engines as " + max
				+ " for component with name " + componentName, MessageTypes.Info);
		new ExtendedWebElement(By.xpath(String.format(MIN_ENGINES_VALUE_LOC, componentName))).clear();
		addStaticWait(1000);
		if (isAlertPresent())
			driver.switchTo().alert().accept();
		new ExtendedWebElement(By.xpath(String.format(MIN_ENGINES_VALUE_LOC, componentName)))
				.sendKeys(Integer.toString(min));
		new ExtendedWebElement(By.xpath(String.format(MAX_ENGINES_VALUE_LOC, componentName))).clear();
		addStaticWait(1000);
		if (isAlertPresent())
			driver.switchTo().alert().accept();
		new ExtendedWebElement(By.xpath(String.format(MAX_ENGINES_VALUE_LOC, componentName)))
				.sendKeys(Integer.toString(max));
		addStaticWait(1000);
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

	public void addRuleForComponent(String componentName, RuleType ruleType) {
		if (new ExtendedWebElement(By.xpath(String.format(ADD_RULES_LINK_POLICIES_LOC, componentName))).isPresent()) {
			new ExtendedWebElement(By.xpath(String.format(ADD_RULES_LINK_POLICIES_LOC, componentName))).click();
		}
		driver.getWaitUtility()
				.waitForElementVisible(By.xpath(String.format(NEW_RULE_ADD_LINK_POLICIES_LOC, componentName)));
		new ExtendedWebElement(By.xpath(String.format(NEW_RULE_ADD_LINK_POLICIES_LOC, componentName))).click();
		driver.getWaitUtility()
				.waitForElementVisible(By.xpath(String.format(NEW_RULE_POPUP_LOC_FOR_POLICIES, componentName)));
		ExtendedWebElement ruleSelection = new ExtendedWebElement(driver,
				By.xpath(String.format(SELECT_RULE_TYPE_FOR_COMPONENT_LOC, componentName, ruleType.title)));
		ruleSelection.click();
		addStaticWait(1000);
		driver.getWaitUtility().waitForElementPresent(RULES_POPUP_MODAL_LOC);
	}

	public void removeAllRulesForComponent(String componentName) {
		if (!new ExtendedWebElement(By.xpath(String.format(POLICIES_RULE_TABLE_LOC, componentName))).isPresent()) {
			new ExtendedWebElement(By
					.xpath(String.format(COMPONENTS_LOC_IN_POLICIES_LOC + "/following-sibling::td[3]", componentName)))
							.click();
		}
		By ruleXpath = By.xpath(String.format(POLICIES_RULE_TABLE_REMOVE_LINK_LOC, componentName));
		driver.getWaitUtility().waitForElementPresent(ruleXpath);
		while (new ExtendedWebElement(ruleXpath).isPresent()) {
			ExtendedWebElement ruleElement = new ExtendedWebElement(ruleXpath);
			ruleElement.click();
			waitForPageToLoad();
		}
	}

	public void removeRuleForComponent(String componentName, RuleType ruleTypeToRemove) {
		if (!new ExtendedWebElement(By.xpath(String.format(POLICIES_RULE_TABLE_LOC, componentName))).isPresent()) {
			new ExtendedWebElement(By
					.xpath(String.format(COMPONENTS_LOC_IN_POLICIES_LOC + "/following-sibling::td[3]", componentName)))
							.click();
		}
		By ruleXpath = By.xpath(
				String.format(POLICIES_TABLE_RULE_TYPE_INDIVIDUAL_REMOVE_LOC, componentName, ruleTypeToRemove.title));
		driver.getWaitUtility().waitForElementPresent(ruleXpath);
		ExtendedWebElement ruleElement = new ExtendedWebElement(ruleXpath);
		if (ruleElement.isPresent()) {
			ruleElement.click();
			waitForPageToLoad();
		}
	}

	public void setComponentDependency(boolean shutdownDependency, boolean orderedDeactivation,
			boolean restartForNewRules, boolean packByHost, String... dependsOnComponents) {
		driver.getWaitUtility().waitForElementPresent(
				By.className("rule_editor domain_dependency ui-dialog-content ui-widget-content"));
		ExtendedDropDown dropDown = new ExtendedDropDown(driver,
				By.xpath("//select[@class='componentSelector domain_chooser']"));
		for (String component : dependsOnComponents) {
			dropDown.select(component);
			dropDown.sendKeys(Keys.SHIFT);
		}
		ExtendedWebElement input1 = new ExtendedWebElement(
				By.xpath(String.format(COMPONENT_DEPENDENCY_POPUP_BOOLEAN_VALUES_LOC, "Shutdown dependency")));
		ExtendedWebElement input2 = new ExtendedWebElement(
				By.xpath(String.format(COMPONENT_DEPENDENCY_POPUP_BOOLEAN_VALUES_LOC, "Ordered deactivation")));
		ExtendedWebElement input3 = new ExtendedWebElement(By.xpath(
				String.format(COMPONENT_DEPENDENCY_POPUP_BOOLEAN_VALUES_LOC, "Restart Component for new rules")));
		ExtendedWebElement input4 = new ExtendedWebElement(
				By.xpath(String.format(COMPONENT_DEPENDENCY_POPUP_BOOLEAN_VALUES_LOC, "Pack by host")));
		if (shutdownDependency) {
			if (!input1.isSelected()) {
				input1.click();
			}
		} else {
			if (input1.isSelected()) {
				input1.click();
			}
		}
		if (orderedDeactivation) {
			if (!input2.isSelected()) {
				input2.click();
			}
		} else {
			if (input2.isSelected()) {
				input2.click();
			}
		}
		if (restartForNewRules) {
			if (!input3.isSelected()) {
				input3.click();
			}
		} else {
			if (input3.isSelected()) {
				input3.click();
			}
		}
		if (packByHost) {
			if (!input4.isSelected()) {
				input4.click();
			}
		} else {
			if (input4.isSelected()) {
				input4.click();
			}
		}
		clickSaveOnPopUp();
	}

	public void setResourcePreference(ResourcePreferenceName property, ResourcePreferenceOperator operator,
			String value, ResourcePreferenceLevel preferencelevel) {
		String propertySelectLoc = SET_RESOURCE_PREFERENCE_DIV_LOC + "//select[@name='rp_property_chooser']";
		String operatorSelectLoc = SET_RESOURCE_PREFERENCE_DIV_LOC + "//select[@name='rp_operator_chooser']";
		String inputValueLoc = SET_RESOURCE_PREFERENCE_DIV_LOC + "//input[@name='rp_value']";
		String preferenceSelectLoc = SET_RESOURCE_PREFERENCE_DIV_LOC + "//select[@name='rp_preference_chooser']";
		new ExtendedDropDown(driver, By.xpath(propertySelectLoc)).select(property.getTitle());
		new ExtendedDropDown(driver, By.xpath(operatorSelectLoc)).select(operator.getTitle());
		new ExtendedWebElement(By.xpath(inputValueLoc)).clear();
		new ExtendedWebElement(By.xpath(inputValueLoc)).sendKeys(value);
		new ExtendedDropDown(driver, By.xpath(preferenceSelectLoc)).select(preferencelevel.getTitle());
		clickSaveOnPopUp();

	}

	public void clickSaveOnPopUp() {
		new ExtendedWebElement(By.xpath(String.format(STACK_CREATE_EDIT_PAGE_MODAL_BUTTONS_LOC, "Save"))).click();
		waitForPageToLoad();
	}

	public void clickCancelOnPopUp() {
		new ExtendedWebElement(By.xpath(String.format(STACK_CREATE_EDIT_PAGE_MODAL_BUTTONS_LOC, "Cancel"))).click();
		waitForPageToLoad();
	}
}
