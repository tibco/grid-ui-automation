package com.tibco.automation.common.components;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import org.openqa.selenium.By;

import com.tibco.automation.common.framework.webdriver.WebDriverManager;

public class ExtendedChoiceButton extends AbstractActions {

	public ExtendedChoiceButton(ExtendedWebDriver driver, By locator) {
		this(driver, null, locator);
	}

	public ExtendedChoiceButton(ExtendedWebDriver driver, ExtendedWebElement parent, By locator) {
		super(driver, parent, locator);
	}

	public ExtendedChoiceButton(ExtendedWebElement parent, By locator) {
		this(WebDriverManager.getDriver(), parent, locator);
	}

	public ExtendedChoiceButton(By locator) {
		this(WebDriverManager.getDriver(), null, locator);
	}
}
