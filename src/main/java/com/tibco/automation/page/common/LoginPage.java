package com.tibco.automation.page.common;

import org.apache.log4j.Logger;

import com.tibco.automation.common.components.ExtendedButton;
import com.tibco.automation.common.components.ExtendedInputBox;
import com.tibco.automation.common.framework.core.Controller;
import com.tibco.automation.common.framework.core.ControllerImpl;
import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriverException;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.common.utils.LocatorUtil;
import com.tibco.automation.common.utils.PropertiesUtil;
import com.tibco.automation.common.utils.WaitUtility;

public class LoginPage extends ControllerImpl implements Controller, Locators.LoginPageLocators {

	private ExtendedInputBox userNameTextBox;
	private ExtendedInputBox passwordTextBox;
	private ExtendedButton signInButton;
	private ExtendedWebElement userProfileLink;
	ExtendedWebDriver driver;
	WaitUtility waitUtility;
	private final static Logger logger = Logger.getLogger(LoginPage.class);

	public LoginPage() {
		userNameTextBox = new ExtendedInputBox(LocatorUtil.getBy(USERNAME_INPUT_LOC));
		passwordTextBox = new ExtendedInputBox(LocatorUtil.getBy(PASSWORD_INPUT_LOC));
		System.out.println("I m here for login...!!");
		signInButton = new ExtendedButton(LocatorUtil.getBy(SIGN_IN_INPUT_LOC));
		System.out.println("I m here for login. signInButton..!!"+signInButton);
		userProfileLink = new ExtendedWebElement(LocatorUtil.getBy(String.format(USER_PROFILE_LINK_LOC,
				PropertiesUtil.getBundle().getPropertyValue("appication.profile.username"))));
		System.out.println("userProfileLink===="+userProfileLink);
		driver = getDriver();
		waitUtility = getDriver().getWaitUtility();
	}

	@Override
	public boolean isPageActive(Object... object) {
		System.out.println("isPageActive in loginpage...!!!.");
		try {
			System.out.println("flag:::>>>");
			boolean flag = driver.findElement(LocatorUtil.getBy("//ul[@class='nav navbar-nav navbar-right']//li[@id='question-list']//span[@title='Help']")).isDisplayed();
			System.out.println("flag:::::: : HELP_LOCATOR"+flag);
			return flag;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public void launchPage(Object... object) {
		System.out.println("Login page launch Page method..!!");
		super.launchPage(object);
	}

	@Override
	public boolean verifyArgs(Object... objects) {
		//System.out.println("in template page verifyArgs");
		boolean args = verifyLoggedInCredentials(objects);
		//System.out.println("result verify args : "+args);
		return args;
	}

	public boolean verifyLoggedInCredentials(Object... objects) {
		if (objects != null && objects.length == 2) {
			if (PropertiesUtil.getBundle().getProperty("application.username").toString()
					.equalsIgnoreCase(objects[0].toString())
					&& PropertiesUtil.getBundle().getProperty("application.password").toString()
					.equalsIgnoreCase(objects[1].toString())) {
				return true;
			} else {
				if (objects[0] != null && objects[0] != "" && objects[1] != null && objects[1] != "") {
					if (isLoggedIn(objects)) {
						userProfileLink.isDisplayed();
						waitForPageToLoad();
					}
					PropertiesUtil.getBundle().setProperty("application.username", objects[0]);
					PropertiesUtil.getBundle().setProperty("application.password", objects[1]);
					return false;
				} else
					return false;
			}
		} else {
			return true;
		}
	}

	public boolean isLoggedIn(Object... objects) {
		try {
			driver.switchTo().defaultContent();
			if (userProfileLink.isPresent()) {
				waitForPageToLoad();
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public void openPage(String url) {
		System.out.println("openPage in loginpage");
		try {
			getDriver().get(url);
			logger.debug(
					"Opening URL : " + url);
			driver.getAssertionService().addAssertionLog(
					"Opening URL : " + url,
					MessageTypes.Info);
			waitUtility.waitForPageToLoad();
		} catch (ExtendedWebDriverException e) {
			driver.getAssertionService().assertFalse(isPageActive(), "Unable to open URL.");
		}

		login(PropertiesUtil.getBundle().getString("application.username"),
				PropertiesUtil.getBundle().getString("application.password"));
		logger.debug("Login to application using credentials : "
				+ PropertiesUtil.getBundle().getPropertyValue("application.username").toString() + " / "
				+ PropertiesUtil.getBundle().getPropertyValue("application.password").toString());

		waitUtility.waitForPageToLoad();

		driver.getAssertionService().assertTrue(isPageActive(),
				"Unable to loggedIn using credentials : "
						+ PropertiesUtil.getBundle().getPropertyValue("application.username").toString() + " / "
						+ PropertiesUtil.getBundle().getPropertyValue("application.password").toString(),
				"LoggedIn using credentials : "
						+ PropertiesUtil.getBundle().getPropertyValue("application.username").toString() + " / "
						+ PropertiesUtil.getBundle().getPropertyValue("application.password").toString()); 
	}

	
	@Override
	public void openPage(Object... objects) {
		System.out.println("openPage in loginpage");
		try {
			getDriver().get(PropertiesUtil.getBundle().getPropertyValue("application.url").toString());
			logger.debug(
					"Opening URL : " + PropertiesUtil.getBundle().getPropertyValue("application.url").toString());
			driver.getAssertionService().addAssertionLog(
					"Opening URL : " + PropertiesUtil.getBundle().getPropertyValue("application.url").toString(),
					MessageTypes.Info);
			waitUtility.waitForPageToLoad();
		} catch (ExtendedWebDriverException e) {
			driver.getAssertionService().assertFalse(isPageActive(), "Unable to open URL.");
		}

		login(PropertiesUtil.getBundle().getString("application.username"),
				PropertiesUtil.getBundle().getString("application.password"));
		logger.debug("Login to application using credentials : "
				+ PropertiesUtil.getBundle().getPropertyValue("application.username").toString() + " / "
				+ PropertiesUtil.getBundle().getPropertyValue("application.password").toString());

		waitUtility.waitForPageToLoad();

		driver.getAssertionService().assertTrue(isPageActive(),
				"Unable to loggedIn using credentials : "
						+ PropertiesUtil.getBundle().getPropertyValue("application.username").toString() + " / "
						+ PropertiesUtil.getBundle().getPropertyValue("application.password").toString(),
				"LoggedIn using credentials : "
						+ PropertiesUtil.getBundle().getPropertyValue("application.username").toString() + " / "
						+ PropertiesUtil.getBundle().getPropertyValue("application.password").toString()); 
	}

	public void login(String userName, String password) {
		System.out.println("inside Login...function...!!!");
		userNameTextBox.sendKeys(userName);
		passwordTextBox.sendKeys(password);
		System.out.println("Before clicking singinbutton");
		signInButton.click();
		waitForPageToLoad();
		System.out.println("after clicking singinbutton");
	}

}
