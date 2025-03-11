package com.tibco.automation.common.components;

import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import org.openqa.selenium.By;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.WebDriverManager;

public class ExtendedInputBox extends AbstractActions {

	public ExtendedInputBox(ExtendedWebDriver driver, By locator) {
		this(driver, null, locator);
	}

	public ExtendedInputBox(ExtendedWebDriver driver, ExtendedWebElement parent, By locator) {
		super(driver, parent, locator);
	}

	public ExtendedInputBox(ExtendedWebElement parent, By locator) {
		this(WebDriverManager.getDriver(), parent, locator);
	}

	public ExtendedInputBox(By locator) {
		this(WebDriverManager.getDriver(), null, locator);
	}

}
