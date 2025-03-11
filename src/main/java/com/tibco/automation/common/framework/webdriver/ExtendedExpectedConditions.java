package com.tibco.automation.common.framework.webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ExtendedExpectedConditions {

    private static final Logger log = Logger.getLogger(ExtendedExpectedConditions.class.getName());

    private ExtendedExpectedConditions() {
    }

    public static ExtendedExpectedCondition<ExtendedWebElement> presenceOfElementLocated(final By locator) {
        return new ExtendedExpectedCondition<ExtendedWebElement>() {
            public ExtendedWebElement apply(ExtendedWebDriver driver) {
                return ExtendedExpectedConditions.findElement(locator, driver);
            }

            public String toString() {
                return "presence of element located by: " + locator;
            }
        };
    }

    private static ExtendedWebElement findElement(By by, ExtendedWebDriver driver) {
        try {
            return (ExtendedWebElement) driver.findElement(by);
        } catch (NoSuchElementException var3) {
            throw var3;
        } catch (ExtendedWebDriverException var4) {
            log.log(Level.WARNING, String.format("WebDriverException thrown by findElement(%s)", by), var4);
            throw var4;
        }
    }

    public static ExtendedExpectedCondition<Alert> alertIsPresent() {
        return new ExtendedExpectedCondition<Alert>() {
            public Alert apply(ExtendedWebDriver driver) {
                try {
                    return driver.switchTo().alert();
                } catch (NoAlertPresentException var3) {
                    return null;
                }
            }

            public String toString() {
                return "alert to be present";
            }
        };
    }
}
