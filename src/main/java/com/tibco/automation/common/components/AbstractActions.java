package com.tibco.automation.common.components;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import org.openqa.selenium.By;

public abstract class AbstractActions implements Actions {

	ExtendedWebDriver driver;
	ExtendedWebElement parent;
	By by;
	String description;

	public AbstractActions(ExtendedWebDriver driver, ExtendedWebElement parent, By by) {
		this.driver = driver;
		this.parent = parent;
		this.by = by;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public void click() {
		try {
			if (parent == null) {
				driver.getWaitUtility().waitForElementPresent(by);
				driver.findElement(by).click();
			} else {
				driver.getWaitUtility().waitForElementPresent(by);
				parent.findElement(by).click();
			}
			if (description != null && description != "")
				driver.getAssertionService().assertTrue(true, "Click on " + description);
		} catch (Exception e) {
			if (description != null && description != "")
				driver.getAssertionService().assertTrue(false, "Unable to click on " + description);
		}
	}

	@Override
	public void sendKeys(CharSequence... keysToSend) {
		try {
			if (parent == null) {
				driver.getWaitUtility().waitForElementPresent(by);
				driver.findElement(by).sendKeys(keysToSend);
			} else {
				driver.getWaitUtility().waitForElementPresent(by);
				parent.findElement(by).sendKeys(keysToSend);
			}
			if (description != null && description != "")
				driver.getAssertionService().assertTrue(true, "Click on " + description);
		} catch (Exception e) {
			if (description != null && description != "")
				driver.getAssertionService().assertTrue(false, "Unable to click on " + description);
		}
	}

	@Override
	public ExtendedWebElement getWebElement() {
		if (parent == null) {
			return driver.findElement(by);
		} else {
			return parent.findElement(by);
		}
	}

	@Override
	public boolean verifyPresent() {
		try {
			if (parent == null)
				return driver.findElement(by).isDisplayed();
			else
				return parent.findElement(by).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public By getBy() {
		return by;
	}

	@Override
	public void clear() {
		if (parent == null)
			driver.findElement(by).clear();
		else
			parent.findElement(by).clear();
	}

	@Override
	public boolean isSelected() {
		try {
			if (parent == null)
				return driver.findElement(by).isSelected();
			else
				return parent.findElement(by).isSelected();
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public boolean isEnabled() {
		try {
			if (parent == null)
				return driver.findElement(by).isEnabled();
			else
				return parent.findElement(by).isEnabled();
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public void waitForElementPresent() {
		try {
			if (parent == null)
				driver.getWaitUtility().waitForElementPresent(by);
		} catch (Exception e) {

		}
	}

}