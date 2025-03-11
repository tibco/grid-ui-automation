package com.tibco.automation.common.framework.core;

public interface Controller {

	public boolean isPageActive(Object... objects);

	public void openPage(Object... objects);

	public void launchPage(Object... objects);
	
	//public void afterLaunchPage(Object... objects);

	public boolean verifyArgs(Object... objects);

}
