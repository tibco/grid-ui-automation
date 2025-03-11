package com.tibco.automation.test.gsui.systemadmin;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import com.tibco.automation.common.utils.RandomStringGenerator;
import com.tibco.automation.common.utils.RandomStringGenerator.RandomizerTypes;
import com.tibco.automation.page.admin.systemadmin.SNMP_Event_Traps_Page;
import com.tibco.automation.page.common.CommonFunctions;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.TemplatePage;

public class SNMP_Event_Traps extends WebDriverTestCase{
	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public TemplatePage templatepage;
	public CommonFunctions commonFunctions;
	public SNMP_Event_Traps_Page snmp;
	public String hostname;
	public String port;
	@BeforeMethod
	public void beforeMethod()
	{
		hostname="host"+RandomStringGenerator.get(4, RandomizerTypes.MIXED);
		port=""+RandomStringGenerator.get(4, RandomizerTypes.DIGITS_ONLY);
		snmp=new SNMP_Event_Traps_Page();
		snmp.launchPage();
		snmp.waitForPageToLoad();
	}
	
	@Test(description="Verify the functionality of SNMP Version")
	public void Grid_4717()
	{
		snmp.selectSNMPVersion("1");
		snmp.waitForPageToLoad();
		snmp.verifySNMPVersionIsSelected("1");
		snmp.waitForPageToLoad();
		snmp.selectSNMPVersion("2c");
		snmp.waitForPageToLoad();
		snmp.verifySNMPVersionIsSelected("2c");
	}
	
	@Test(description="Verify the functionality of Add button")
	public void Grid_4718()
	{
		snmp.addSNMPHost(hostname, port);
		snmp.waitForPageToLoad();
		snmp.verifyHostPresent(hostname);
	}
	
	@Test(description="Verify the functionality of Remove button")
	public void Grid_4719()
	{
		snmp.addSNMPHost(hostname, port);
		snmp.waitForPageToLoad();
		snmp.verifyHostPresent(hostname);
		snmp.removeHost(hostname);
		snmp.waitForPageToLoad();
		snmp.verifyHostNotPresent(hostname);
	}
	
	@Test(description="Verify the functionality of Edit button")
	public void Grid_4720()
	{
		String newHostname="host"+RandomStringGenerator.get(4, RandomizerTypes.MIXED);
		snmp.addSNMPHost(hostname, port);
		snmp.waitForPageToLoad();
		snmp.verifyHostPresent(hostname);
		snmp.clickEditForHostName(hostname);
		snmp.editHostname(hostname, newHostname);
		snmp.waitForPageToLoad();
		snmp.verifyHostPresent(newHostname);
	}
	
	@Test(description="verify the functionality of Checkbox for events")
	public void Grid_4721()
	{
		snmp.checkBrokerAddedEvent();
		snmp.verifyBrokerAddedEventIsChecked();
		snmp.checkBrokerAddedEvent();
	}
}
