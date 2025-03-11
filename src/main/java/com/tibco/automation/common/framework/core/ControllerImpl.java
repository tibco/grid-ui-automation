package com.tibco.automation.common.framework.core;

import java.lang.reflect.ParameterizedType;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.WebDriverManager;

public abstract class ControllerImpl<P extends Controller> {

	protected Controller parent;

	public void setParent(Controller parent) {
		this.parent = parent;
	}

	public Controller getParent() {
		if (this.parent == null) {
			initParent();
		}
		return this.parent;
	}

	@SuppressWarnings("unchecked")
	protected void initParent() {
		System.out.println("Class : "+this.getClass().getName());
		try {
			Class<P> class1 = (Class<P>) ((ParameterizedType) this.getClass().getGenericSuperclass())
					.getActualTypeArguments()[0];
			System.out.println("parent class : "+class1.getName());
			if (!class1.isInterface()) {
				parent = class1.newInstance();
				System.out.println("parent class : "+parent.getClass().getName());
			}
		} catch (Exception e) {
			System.out.println("Unable to initialize parent class. ");
			e.printStackTrace();
		}
	}

	public boolean isPageActive(Object... object) {
		System.out.println("in controller isPageActive");
		return false;
	}

	public void openPage(Object... objects) {
		System.out.println("in controller openPage...");
	}

	public boolean verifyArgs(Object... objects) {
		return false;
	}
	
	public void afterLaunchPage(Object...object) {
		
	}
	
	

	public void launchPage(Object... object) {

		System.out.println("in controller launchPage.. "+this.getClass().getName());
		boolean isPageActive = false;
		boolean isArgs = false;
		parent = getParent();
		System.out.println("parent...!! "+parent);
		
		try {
			System.out.println("Inside Try");
			isPageActive = isPageActive(object);
			System.out.println("isPageActive"+isPageActive);
			isArgs = verifyArgs(object);
			System.out.println("isArgs"+isArgs);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (!(isPageActive && isArgs)) {
		System.out.println("parent.!!!!!!!!.!!");
			if (parent != null) {
				System.out.println("Inside IF..!!");
				parent.launchPage(object);
				System.out.println("Inside IF ******");
			}
			System.out.println("before openpage..!!!");
			openPage(object);
		}
	}

	public ExtendedWebDriver getDriver() {
		return WebDriverManager.getDriver();
	}

	public void waitForPageToLoad() {
		WebDriverManager.getDriver().getWaitUtility().waitForPageToLoad();
	}

}
