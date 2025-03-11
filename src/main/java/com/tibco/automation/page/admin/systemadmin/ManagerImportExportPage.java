package com.tibco.automation.page.admin.systemadmin;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.awt.Toolkit;
import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.Locators;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.common.TopPaginate;
import com.tibco.automation.page.common.TemplatePage.GSMenu;

public class ManagerImportExportPage extends TemplatePage implements Locators.ManagerImportExport
{
	
	public DataGrid datagrid; // these are class references
	public ExtendedWebDriver driver;
	public String pageTitle ="System Admin";
	public TemplatePage templatePage;
	public TopPaginate topPaginate;
    public String file;
	public ManagerImportExportPage() {
		super("Manager Import/Export", GSMenu.ManagerImportExport);
		
		datagrid = new DataGrid(); // as already defined above we are just intializing
		driver = getDriver();
		templatePage = new TemplatePage();
		topPaginate = new TopPaginate();
	
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

	public void clickonCollapseAll()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.getWaitUtility().waitForElementPresent(COLLAPSE_ALL_BUTTON_LOC);
		
		new ExtendedWebElement(By.xpath(COLLAPSE_ALL_BUTTON_LOC)).click();
		
		driver.getWaitUtility().waitForElementVisible(By.xpath(ENGINE_CONFIG_LOC));
		
		
			driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(ENGINE_CONFIG_LOC))).isDisplayed(), "Collapse all button is not clicked", "Collapse all button is clicked");			
	}
	
	public void clickonExpandAll()
	{
		
		driver.getWaitUtility().waitForElementPresent(EXPAND_ALL_BUTTON_LOC);
		new ExtendedWebElement(By.xpath(EXPAND_ALL_BUTTON_LOC)).click();
		
		driver.getWaitUtility().waitForElementVisible(By.xpath(BROKER_CONFIG));
	
		driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(BROKER_CONFIG))).isDisplayed(), "Expand all button is not clicked", "Expand all button is clicked");
	}

	
	public void verifyAllCheckbox()
	{
		
		WebElement checkBox=driver.findElement(By.xpath(CONFIG_ALL_LOC));
		new ExtendedWebElement(By.xpath(CONFIG_ALL_LOC)).click();
		driver.getAssertionService().assertTrue(new ExtendedWebElement(By.xpath(DIRECTOR_REST_ALL_LOC)).isSelected(),"Check box is not selected","Check box is selected");
		driver.navigate().refresh();
	}

	public void verifyArrow()
	{
		driver.getWaitUtility().waitForElementPresent(CONFIG_ALL_ARROW_LOC);
		new ExtendedWebElement(By.xpath(CONFIG_ALL_ARROW_LOC)).click();
		waitForPageToLoad();
		//driver.getWaitUtility().waitForElementPresent(DIRECTOR_CONFIG_LOC);
	    driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(CONFIG_DOWN_ARROW_LOC))).isPresent(), "Sub header arrow is not clicked", "Sub header arrow is clicked");		
	    
	    driver.navigate().refresh();	
	}
	
	public void verifyExport()
	{
		
		new ExtendedWebElement(By.xpath(DIR_CONFIG_LOC)).click();
		new ExtendedWebElement(By.xpath(EXPORT_BUTTON_LOC)).click();
		driver.getWaitUtility().waitForElementVisible(By.xpath(EXPORT_BUTTON_LOC));
	    driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(EXPORT_BUTTON_LOC))).isDisplayed(), "Export button is not present", "Export button is present");		
	    
		String mainWindowHandle = driver.getWindowHandle();
		
		try {
		    WebDriverWait wait = new WebDriverWait(driver, 2);
		    wait.until(ExpectedConditions.alertIsPresent());
		    Alert alert = driver.switchTo().alert();
		    System.out.println(alert.getText());
		    alert.accept();
		    driver.getAssertionService().assertTrue(alert.getText().contains("GridServerExport.jar"), mainWindowHandle);
		} catch (Exception e) {
		    System.out.println(e);
		}
		 waitForPageToLoad(); 
		  for (String winHandle : driver.getWindowHandles()) 
		  {
				driver.switchTo().window(winHandle);
				String uploadFileWindow = driver.getWindowHandle();
			}
	    	driver.switchTo().window(mainWindowHandle);
			driver.navigate().refresh();
	}
	
	public void verifyBlankUpload()
	{
		new ExtendedWebElement(By.xpath(IMPORT_FILE_BUTTON_LOC)).click();
		new ExtendedWebElement(By.xpath(IMPORT_UPLOAD_LOC)).click();
		 driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(BLANK_IMPORT))).isDisplayed(), "File is specified", "No file specified");			
		
	}
	public void verifyUpload() throws AWTException
	{
		
		Robot robot=new Robot();
		driver.getAssertionService().addAssertionLog("Entering verifiyUpload Function", MessageTypes.Info);
        driver.manage().window().maximize();
       driver.getWaitUtility().waitForElementPresent(IMPORT_FILE_BUTTON_LOC);
        new ExtendedWebElement(By.xpath(IMPORT_FILE_BUTTON_LOC)).click();
        driver.getAssertionService().addAssertionLog("Clicked Import File Button", MessageTypes.Info);
        WebElement element = driver.findElement(By.xpath(CHOOSE_FILE_LOC));
       
        JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
        file= (new File("resources\\data\\commonData\\GridServerExport.jar").getAbsolutePath());
      
        StringSelection ss = new StringSelection(file);
		
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
		
		robot.setAutoDelay(1000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        driver.getWaitUtility().waitForElementPresent(IMPORT_UPLOAD_LOC);
	new ExtendedWebElement(By.xpath(IMPORT_UPLOAD_LOC)).click();
	driver.getAssertionService().addAssertionLog("Exiting verifiyUpload Function", MessageTypes.Info);
	
	}
	public void verifyImportWithoutJar() throws AWTException, InterruptedException
	{
		Robot robot=new Robot();
		verifyUpload();
		waitForPageToLoad();
		String mainWindowHandle = driver.getWindowHandle();
		driver.switchTo().window(mainWindowHandle);
		waitForPageToLoad();
		Thread.sleep(100);
		 driver.getWaitUtility().waitForElementPresent(JAR_IMPORT_LOC);
		
		driver.findElement(By.xpath(JAR_IMPORT_LOC));
		
		new ExtendedWebElement(By.xpath(JAR_IMPORT_LOC)).click();
	waitForPageToLoad();
		 driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(BLANK_IMPORT))).isDisplayed(), "File is specified", "No Element selected for import");			
	}
	public void verifyImportUpload() throws AWTException, InterruptedException
	{
		String mainWindowHandle = driver.getWindowHandle();
		Robot robot=new Robot();
		verifyUpload();
		waitForPageToLoad();
		Thread.sleep(5000);
		driver.switchTo().window(mainWindowHandle);
		//Thread.sleep(100);
		waitForPageToLoad();
		 driver.getWaitUtility().waitForElementPresent(By.xpath(ENGINE_CONFIG_IMPORT_ALL));
		driver.findElement(By.xpath(ENGINE_CONFIG_IMPORT_ALL)).click();
		driver.getAssertionService().addAssertionLog("Engine config Import All clicked", MessageTypes.Info);
		waitForPageToLoad();
		driver.getWaitUtility().waitForElementPresent(By.xpath(ENGINE_CONFIG_OVERWRITE_ALL_LOC));
		
		driver.findElement(By.xpath(ENGINE_CONFIG_OVERWRITE_ALL_LOC)).click();
		driver.getAssertionService().addAssertionLog("Engine config overwrite All clicked", MessageTypes.Info);
		waitForPageToLoad();
		driver.getAssertionService().addAssertionLog("Clicking import button on after upload page", MessageTypes.Info);
		driver.getWaitUtility().waitForElementPresent(JAR_IMPORT_LOC);
		new ExtendedWebElement(By.xpath(JAR_IMPORT_LOC)).click();
		
		 driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(SUCCESS_MSG_LOC))).isDisplayed(), "Jar is not successfully imported", "Jar is successfully imported");			
	}
	public void verifyCancleImport() throws AWTException, InterruptedException
	{
		Robot robot=new Robot();
		verifyUpload();
		String mainWindowHandle = driver.getWindowHandle();
		waitForPageToLoad();
		Thread.sleep(100);
		 driver.getWaitUtility().waitForElementPresent(By.xpath(CANCLE_BUTTON_LOC));
		driver.findElement(By.xpath(CANCLE_BUTTON_LOC)).click();
		waitForPageToLoad();
		 driver.getWaitUtility().waitForElementPresent(By.xpath(ENGINE_CONFIG_LOC));
		 driver.getAssertionService().assertTrue(new ExtendedWebElement((By.xpath(ENGINE_CONFIG_LOC))).isDisplayed(), "Cancel button not clicked", "Cancel button is clicked");		
		    
	}
	
	
	
	
}
