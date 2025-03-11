package com.tibco.automation.page.admin.systemadmin;

import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.Locators;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.common.TopPaginate;

public class SNMP_Event_Traps_Page extends TemplatePage implements Locators.SNMPEventTrapsLocators{

	public DataGrid datagrid; // these are class references
	public ExtendedWebDriver driver;
	public String pageTitle ="System Admin";
	public TemplatePage templatePage;
	public TopPaginate topPaginate;
	public static String parentHandle;
	public SNMP_Event_Traps_Page() {
		super(" SNMP Event Traps", GSMenu.SNMPEventTraps);
		System.out.println("GSMenu..!!");
		datagrid = new DataGrid(); // as already defined above we are just initializing
		driver = getDriver();
		templatePage = new TemplatePage();
		topPaginate = new TopPaginate();
		System.out.println(" After GSMenu..!!");
	}

	@Override
	public boolean isPageActive(Object... object) {
		System.out.println("isPageActive..!!");
		return super.verifyPageTitle(pageTitle);
		
		
	}

	@Override
	public void waitForPageToLoad() {
		super.waitForPageToLoad();
	}
	
	
	public void verifySNMPVersionIsSelected(String version)
	{
		Boolean isSelected=new ExtendedWebElement(String.format(SNMPVERSION_LOC, version)).isSelected();
		if (isSelected)
			driver.getAssertionService().addAssertionLog("SNMP Version "+version+" is selected", MessageTypes.Pass);
		else
			driver.getAssertionService().addAssertionLog("SNMP Version "+version+" is not selected", MessageTypes.Fail);
	}
	
	public void selectSNMPVersion(String version)
	{
		new ExtendedWebElement(String.format(SNMPVERSION_LOC, version)).click();
		driver.getAssertionService().addAssertionLog("SNMP version "+version+" is clicked", MessageTypes.Info);
	}
	
	public void addSNMPHost(String hostname,String port)
	{
		driver.getWaitUtility().waitForElementPresent(HOSTNAME_INPUT_LOC);
		new ExtendedWebElement(HOSTNAME_INPUT_LOC).sendKeys(hostname);
		driver.getAssertionService().addAssertionLog("Hostname is set to "+hostname, MessageTypes.Info);
		new ExtendedWebElement(PORT_INPUT_LOC).sendKeys(port);
		driver.getAssertionService().addAssertionLog("Port is set to "+hostname, MessageTypes.Info);
		new ExtendedWebElement(ADD_BUTTON_LOC).click();
		driver.getAssertionService().addAssertionLog("Add button is clicked", MessageTypes.Info);
	}
	
	public void editHostname(String oldHostname,String newHostname)
	{
		driver.getWaitUtility().waitForElementPresent(String.format(EDIT_HOSTNAME_INPUT_LOC, oldHostname));
		new ExtendedWebElement(String.format(EDIT_HOSTNAME_INPUT_LOC, oldHostname)).clear();
		new ExtendedWebElement(String.format(EDIT_HOSTNAME_INPUT_LOC, oldHostname)).sendKeys(newHostname);
		driver.getAssertionService().addAssertionLog("Hostname is set to "+newHostname, MessageTypes.Info);
		new ExtendedWebElement(UPDATE_BUTTON_LOC).click();
	}
	
	public void verifyHostPresent(String hostname)
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.getWaitUtility().waitForElementPresent(ADDED_HOST_LOC);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(String.format(ADDED_HOST_LOC, hostname)).isPresent(), "Host "+hostname+" is present");
	}
	
	public void verifyHostNotPresent(String hostname)
	{
		driver.getAssertionService().assertFalse(new ExtendedWebElement(String.format(ADDED_HOST_LOC, hostname)).isPresent(), "Host "+hostname+" is not present");
	}
	
	public void clickEditForHostName(String hostname)
	{
		driver.getWaitUtility().waitForElementPresent(String.format(EDIT_HOST_LOC, hostname));
		new ExtendedWebElement(String.format(EDIT_HOST_LOC, hostname)).click();
		driver.getAssertionService().addAssertionLog("Edit button for hostname "+hostname+" is clicked", MessageTypes.Pass);
	}
	
	public void removeHost(String hostname)
	{
		driver.getWaitUtility().waitForElementPresent(String.format(REMOVE_HOST_LOC, hostname));
		new ExtendedWebElement(String.format(REMOVE_HOST_LOC, hostname)).click();
		driver.getAssertionService().addAssertionLog("Remove button for hostname "+hostname+" is clicked", MessageTypes.Pass);
	}
	
	public void checkBrokerAddedEvent()
	{
		driver.getWaitUtility().waitForElementPresent(BROKERADDEDEVENT_CHECKBOX_LOC);
		new ExtendedWebElement(BROKERADDEDEVENT_CHECKBOX_LOC).click();
	}
	
	public void verifyBrokerAddedEventIsChecked()
	{
		if (new ExtendedWebElement(BROKERADDEDEVENT_CHECKBOX_LOC).isSelected())
			driver.getAssertionService().addAssertionLog("Broker added event is checked", MessageTypes.Pass);
		else
			driver.getAssertionService().addAssertionLog("Broker added event is not checked", MessageTypes.Fail);
	}
}
