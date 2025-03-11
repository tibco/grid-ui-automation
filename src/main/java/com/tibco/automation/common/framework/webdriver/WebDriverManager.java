package com.tibco.automation.common.framework.webdriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import com.tibco.automation.common.utils.PropertiesUtil;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverManager {
	private static ThreadLocal<ExtendedWebDriver> webDriver = new ThreadLocal<ExtendedWebDriver>();

	private static DesiredCapabilities capabilities;

	private static DesiredCapabilities getCapabilities() {
		capabilities = new DesiredCapabilities();

		Properties props = System.getProperties();
		for (Object key : props.keySet()) {
			capabilities.setCapability(key.toString(), props.getProperty(key.toString()));
		}
		return capabilities;
	}

	private static DesiredCapabilities addCapability(String key, Object value) {
		capabilities = getCapabilities();
		capabilities.setCapability(key, value);
		return capabilities;
	}

	public static ExtendedWebDriver getDriver() {

		LoggingPreferences logs = new LoggingPreferences();
		logs.enable(LogType.BROWSER, Level.ALL);
		logs.enable(LogType.CLIENT, Level.ALL);
		logs.enable(LogType.DRIVER, Level.ALL);
		logs.enable(LogType.PERFORMANCE, Level.ALL);
		logs.enable(LogType.PROFILER, Level.ALL);
		logs.enable(LogType.SERVER, Level.ALL);

		if (webDriver.get() == null) {

			addCapability(CapabilityType.LOGGING_PREFS, logs);
			addCapability(CapabilityType.BROWSER_NAME, PropertiesUtil.getBundle().getString("browserName"));
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			ExtendedWebDriver driver = null;

			System.out.println("broserName : " + PropertiesUtil.getBundle().getString("browserName"));

			if (PropertiesUtil.getBundle().getString("browserName").toLowerCase().equalsIgnoreCase("firefox")) {
				System.out.println("firefox.bin : " + PropertiesUtil.getBundle().getString("webdriver.firefox.bin"));

				FirefoxOptions options = new FirefoxOptions();
				options.setBinary(PropertiesUtil.getBundle().getString("webdriver.firefox.bin"));
				options.merge(capabilities);

			} else if (PropertiesUtil.getBundle().getString("browserName").toLowerCase().equalsIgnoreCase("chrome")) {
				//if (getCapabilities().getCapability("chrome.binary") != null) {
					System.out.println("chrome.binary : " + PropertiesUtil.getBundle().getString("chrome.binary"));
					ChromeOptions chromeOptions = new ChromeOptions();
					chromeOptions.setBinary(PropertiesUtil.getBundle().getString("chrome.binary"));
					chromeOptions.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
				//}
			} else if (PropertiesUtil.getBundle().getString("browserName") == "internetExplorer") {
				addCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				addCapability(InternetExplorerDriver.INITIAL_BROWSER_URL,
						PropertiesUtil.getBundle().getString("application.url"));
			} else {
				System.err.println("Unable to get browserName.");
			}

			try {
				driver = new ExtendedWebDriver(new URL("http://" + PropertiesUtil.getBundle().getString("server.host")
						+ ":" + PropertiesUtil.getBundle().getString("server.port") + "/wd/hub"), capabilities);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			driver.manage().window().maximize();
			
			((JavascriptExecutor)driver).executeScript("document.body.style.zoom='90%';");
			driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);

			System.out.println("Started execution for " + PropertiesUtil.getBundle().getString("browserName"));

			setWebDriver(driver);
		}
		return webDriver.get();

	}

	public static void setWebDriver(ExtendedWebDriver driver) {
		webDriver.set(driver);
	}
}
