package com.tibco.automation.common.utils;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriverWait;
import com.tibco.automation.common.framework.webdriver.WebDriverManager;

public class WaitUtility {

	ExtendedWebDriver driver;

	public WaitUtility(ExtendedWebDriver driver) {
		this.driver = driver;
	}

	public WaitUtility() {
		this.driver = WebDriverManager.getDriver();
	}

	public boolean waitForPageToLoad() {
		FluentWait<ExtendedWebDriver> wait = new FluentWait<ExtendedWebDriver>(driver)
				.withTimeout(Long.valueOf(PropertiesUtil.getBundle().getProperty("webdriver.wait.timeout").toString()),
						TimeUnit.MILLISECONDS)
				.pollingEvery(10000, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);

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

	public boolean waitForFrameToLoad(final String frameId) {
		FluentWait<ExtendedWebDriver> wait = new FluentWait<ExtendedWebDriver>(driver)
				.withTimeout(Long.valueOf(PropertiesUtil.getBundle().getProperty("webdriver.wait.timeout").toString()),
						TimeUnit.MILLISECONDS)
				.pollingEvery(10000, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);

		return wait.until(new Function<ExtendedWebDriver, Boolean>() {
			public Boolean apply(ExtendedWebDriver driver) {
				try {
					driver.switchTo().frame(frameId);
					driver.switchTo().defaultContent();
					return true;
				} catch (Exception e) {
					return false;
				}
			}
		});
	};

	public boolean waitForWindow(final String windowId) {
		FluentWait<ExtendedWebDriver> wait = new FluentWait<ExtendedWebDriver>(driver)
				.withTimeout(Long.valueOf(PropertiesUtil.getBundle().getProperty("webdriver.wait.timeout").toString()),
						TimeUnit.MILLISECONDS)
				.pollingEvery(10000, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);

		boolean foo = wait.until(new Function<ExtendedWebDriver, Boolean>() {
			public Boolean apply(ExtendedWebDriver driver) {
				try {
					Set<String> allWindowHandles = driver.getWindowHandles();
					for (String windowHandle : allWindowHandles) {
						if (allWindowHandles.size() > 1 && windowId == windowHandle) {
							return true;
						}
					}
					return false;
				} catch (Exception e) {
					return false;
				}
			}
		});

		return foo;
	};

	public boolean waitForElementPresent(final By element) {
		try {
			ExtendedWebDriverWait webDriverWait = new ExtendedWebDriverWait(driver,
					Long.valueOf(PropertiesUtil.getBundle().getProperty("webdriver.wait.timeout").toString()));
			webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	};

	
	public void waitForElementPresent(final String element) {
		this.waitForElementPresent(LocatorUtil.getBy(element));
	};

	public boolean waitForElementNotPresent(final By locator) {
		ExtendedWebDriverWait webDriverWait = new ExtendedWebDriverWait(driver,
				Long.valueOf(PropertiesUtil.getBundle().getProperty("webdriver.wait.timeout").toString()));
		return webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public void waitForElementNotPresent(final String locator) {
		this.waitForElementNotPresent(LocatorUtil.getBy(locator));
	}

	public boolean waitForElementNotPresent(ExtendedWebElement... elements) {
		ExtendedWebDriverWait webDriverWait = new ExtendedWebDriverWait(driver,
				Long.valueOf(PropertiesUtil.getBundle().getProperty("webdriver.wait.timeout").toString()));
		return webDriverWait.until(ExpectedConditions.invisibilityOfAllElements(Arrays.<WebElement>asList(elements)));
	}

	public void waitForElementVisible(final By locator) {
		ExtendedWebDriverWait webDriverWait = new ExtendedWebDriverWait(driver,
				Long.valueOf(PropertiesUtil.getBundle().getProperty("webdriver.wait.timeout").toString()));
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void waitForElementVisible(final String locator) {
		this.waitForElementVisible(LocatorUtil.getBy(locator));
	}

	public void waitForTextPresent(By locator, String text) {
		ExtendedWebDriverWait webDriverWait = new ExtendedWebDriverWait(driver,
				Long.valueOf(PropertiesUtil.getBundle().getProperty("webdriver.wait.timeout").toString()));
		webDriverWait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	}

	public void waitForTextPresent(String locator, String text) {
		this.waitForTextPresent(LocatorUtil.getBy(locator), text);
	}

	public void waitForTextNotPresent(final By locator, final String text) {
		FluentWait<ExtendedWebDriver> wait = new FluentWait<ExtendedWebDriver>(driver)
				.withTimeout(Long.valueOf(PropertiesUtil.getBundle().getProperty("webdriver.wait.timeout").toString()),
						TimeUnit.MILLISECONDS)
				.pollingEvery(10000, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);

		wait.until(new Function<ExtendedWebDriver, Boolean>() {
			public Boolean apply(ExtendedWebDriver driver) {
				try {
					return !driver.findElement(locator).getText().equalsIgnoreCase(text);
				} catch (Exception e) {
					return true;
				}
			}
		});
	}

	public void waitForTextNotPresent(String locator, String text) {
		this.waitForTextPresent(LocatorUtil.getBy(locator), text);
	}

}