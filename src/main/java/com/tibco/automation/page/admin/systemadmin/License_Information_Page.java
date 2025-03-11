package com.tibco.automation.page.admin.systemadmin;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.page.common.CommonFunctions;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.Locators;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.common.TopPaginate;
import com.tibco.automation.page.common.TemplatePage.GSMenu;

public class License_Information_Page extends TemplatePage implements Locators.LicenseInformationLocators{

	public DataGrid datagrid; // these are class references
	public ExtendedWebDriver driver;
	public String pageTitle ="System Admin";
	public TemplatePage templatePage;
	public TopPaginate topPaginate;
	public static String parentHandle;
	public CommonFunctions commonFunctions=new CommonFunctions();
	public String filePath;
	public License_Information_Page() {
		super(" License Information", GSMenu.LicenseInformation);
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
	
	public void uploadLicense() throws AWTException
	{
		((JavascriptExecutor)driver).executeScript("scroll(0,250)");
		
		Robot robot = new Robot();
		WebElement ele = driver.findElement(By.xpath(CHOOSE_FILE_LOC));
		driver.getAssertionService().addAssertionLog("Choose file button is clicked", MessageTypes.Info);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
        robot.setAutoDelay(2000);
        filePath = (new File("resources\\data\\commonData\\TIBCO DataSynapse GridServer-license.ser").getAbsolutePath());
		StringSelection ss = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
		System.out.println("selection" +ss);
		robot.setAutoDelay(1000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
		new ExtendedWebElement(By.xpath(UPLOAD_LINK_LOC)).click();
		driver.getAssertionService().addAssertionLog("Upload license is clicked", MessageTypes.Info);
		commonFunctions.addStaticWait(3000);
		((JavascriptExecutor)driver).executeScript("scroll(0,250)");
	}
	
}
