package com.tibco.automation.page.gridcomponents.engines;

import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.page.common.CommonFunctions;
import com.tibco.automation.page.common.Locators;
import com.tibco.automation.page.common.Locators.RolePageLocators;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.common.TopPaginate;
import com.tibco.automation.page.common.TemplatePage.GSMenu;

public class EngineAdminPage extends TemplatePage implements Locators.EngineAdminPageLocators,RolePageLocators{  
	public ExtendedWebDriver driver;
	//public String pageTitle ="Role Admin";
	public TemplatePage templatePage;
	public TopPaginate topPaginate;
	public String winHandleBefore;
	public String parentWinHandle;
	public Select select;
	public JavascriptExecutor js = (JavascriptExecutor) driver;
	public CommonFunctions cf;
	
	public EngineAdminPage()
	{
		super("Engine Admin", GSMenu.EngineAdmin);
		driver = getDriver();
		templatePage = new TemplatePage();
		topPaginate = new TopPaginate();
	}
	
	@Override
	public void waitForPageToLoad() 
	{
	super.waitForPageToLoad();
	}	
	
	public void refreshButton()
	{
		driver.getAssertionService().assertTrue((new ExtendedWebElement((REFRESHBUTTON)).isPresent()), "Refresh Button is not present on page", "Refresh Button is present on page");
	}
	
	public void addColumnOption()
	{
		driver.getAssertionService().assertTrue((new ExtendedWebElement((ADD_COL_OPTION)).isPresent()), "Add column option is not present on page", "Add column option is present on page");
	}
	public void addEngineColumn()
	{
		driver.getWaitUtility().waitForElementPresent(ADD_COL_OPTION);
		driver.findElement(ADD_COL_OPTION).click();
		driver.getWaitUtility().waitForElementPresent(ADDNETFRAMEWORKCOL);
		//driver.findElement(ADDNETFRAMEWORKCOL).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", new ExtendedWebElement(ADDNETFRAMEWORKCOL));
        //js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.getWaitUtility().waitForElementPresent(ADDCOLUMNSAVE);
        driver.getWaitUtility().waitForElementPresent(ADDCOLUMNSAVE);
		driver.findElement(ADDCOLUMNSAVE).click();
	}
	public void verifyColumnAdded()
	{
		//JavascriptExecutor js = (JavascriptExecutor)driver; 
        //js.executeScript("window.scrollTo(0, document.body.scrollLeft)");
        //js.executeScript("document.getElementById('gvLocationHorizontalRail').scrollLeft += 250", "");
		driver.getAssertionService().assertTrue((new ExtendedWebElement((NETFRAMEWORK)).isPresent()), "NET Framework Version column is not present:column is not added ", "NET Framework Version column is present:column is added successfully");
		
	}
	public void revert()
	{
		driver.getWaitUtility().waitForElementPresent(ADD_COL_OPTION);
		driver.findElement(ADD_COL_OPTION).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    driver.getWaitUtility().waitForElementPresent(REVERT);
        driver.getWaitUtility().waitForElementPresent(REVERT);
		js.executeScript("arguments[0].click();", new ExtendedWebElement(REVERT));
        //js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    
		driver.findElement(REVERT).click();
		driver.findElement(ADDCOLUMNSAVE).click();
	}
	public void verifyColumnRevert()
	{
		driver.getWaitUtility().waitForElementPresent(NETFRAMEWORK);
		JavascriptExecutor js = (JavascriptExecutor)driver; 
        //js.executeScript("window.scrollTo(0, document.body.scrollLeft)");
		driver.getAssertionService().assertFalse((new ExtendedWebElement((NETFRAMEWORK)).isPresent()), "NET Framework Version column is present:Revert is not done", "NET Framework Version column is not present:Revert is done successfully");
		
	}
	public void verifySimpleSearch()
	{
		boolean X=new ExtendedWebElement(String.format(INVALID)).isPresent();
		driver.getAssertionService().assertTrue(X, "Simple search fail", "Performed simple search successfully");
		
	}
	public void VerifyQueryBuilderClose()
	{
		boolean X=new ExtendedWebElement(String.format(INVALID)).isPresent();
		driver.getAssertionService().assertTrue(X, "Query builder popup is not closed", "Query builder popup is closed successfully");
		

	}
	public void verifyPerformQuerySearch()
	{
		boolean X=new ExtendedWebElement(String.format(INVALID)).isPresent();
		driver.getAssertionService().assertTrue(X, "Query search fail", "Performed Query search successfully");
	}
	public void expandViewOfAll()
	{
		driver.getWaitUtility().waitForElementPresent(EXPANDVIEWALL);
		driver.findElement(EXPANDVIEWALL).click();
	}
	public void verifyExpandViewOfAll()
	{
		driver.getAssertionService().assertTrue((new ExtendedWebElement((VERIFYEXPANDVIEWALL)).isDisplayed()), "Engine Admin details is not dipslayed in Expanded format", "Engine Admin details is dipslayed in Expanded format ");
	}
	public void verifyCollapseViewOfAll()
	{
		driver.getAssertionService().assertFalse((new ExtendedWebElement((VERIFYEXPANDVIEWALL)).isPresent()), "Engine Admin details is not dipslayed in collapsed format", "Engine Admin details is dipslayed in collapsed format ");
	}
	public void clickGlobalAction()
	{
		driver.getWaitUtility().waitForElementPresent(GLOBAL_ACTION);
		driver.findElement(GLOBAL_ACTION).click();
	}
	public void selectCheckbox()
	{
		driver.getWaitUtility().waitForElementPresent(CHECKBOX_);
		WebElement option1 = driver.findElement(CHECKBOX_);
		option1.click();
		option1.click();
		option1.click();
		
	}
		public boolean isAlertPresent(){
		try{
			driver.getAssertionService().addAssertionLog("Alert is present", MessageTypes.Info);
		driver.switchTo().alert();
		return true;
		}catch(NoAlertPresentException ex){
		return false;
		}
		}
		public void clikNext()
		{
			driver.getWaitUtility().waitForElementPresent(NEXTSEARCH);
			if (new ExtendedWebElement(NEXTSEARCH).isEnabled())
			{
			driver.findElement(NEXTSEARCH).click();
			driver.getAssertionService().addAssertionLog("Next button is clicked", MessageTypes.Info);
			}
			else
				driver.getAssertionService().addAssertionLog("Next button is disabled", MessageTypes.Info);
		}

	public void clickBack()
	{
		boolean fname = driver.findElement(BACKSEARCH).isEnabled();
		if(fname==true)
		{
			driver.getAssertionService().addAssertionLog("Back button on search log page is enabled..Clickig on it", MessageTypes.Info);
			driver.getWaitUtility().waitForElementPresent(BACKSEARCH);
			driver.findElement(BACKSEARCH).click();
		}
		else
			driver.getAssertionService().addAssertionLog("Back button on search log page is disabled..", MessageTypes.Info);
			
	}
	
	public void selectHour()
	{
		driver.getWaitUtility().waitForElementPresent(LOGDURATION);
		driver.findElement(LOGDURATION).click();
		driver.getAssertionService().addAssertionLog("Changing search log duration to one Hour", MessageTypes.Info);
		driver.getWaitUtility().waitForElementPresent(DAY);
		driver.findElement(HOUR).click();
		driver.getWaitUtility().waitForElementPresent(HOUR);
		driver.getAssertionService().assertTrue((new ExtendedWebElement((HOUR)).isDisplayed()), "Search log duration is not change ", "search log duration changed to hour");
		
	}
	public void selectDay()
	{
		driver.getWaitUtility().waitForElementPresent(LOGDURATION);
		driver.findElement(LOGDURATION).click();
		driver.getAssertionService().addAssertionLog("Changing search log duration to  one Day", MessageTypes.Info);
		driver.getWaitUtility().waitForElementPresent(DAY);
		driver.findElement(DAY).click();
		driver.getWaitUtility().waitForElementPresent(DAY);
		driver.getAssertionService().assertTrue((new ExtendedWebElement((DAY)).isDisplayed()), "Search log duration is not change ", "search log duration changed to day");
		
	}
	public void selectWeek()
	{
		driver.getWaitUtility().waitForElementPresent(LOGDURATION);
		driver.findElement(LOGDURATION).click();
		driver.getAssertionService().addAssertionLog("Changing search log duration to one Week", MessageTypes.Info);
		driver.getWaitUtility().waitForElementPresent(WEEK);
		driver.findElement(WEEK).click();
		driver.getWaitUtility().waitForElementPresent(WEEK);
		driver.getAssertionService().assertTrue((new ExtendedWebElement((WEEK)).isDisplayed()), "Search log duration is not change ", "search log duration changed to week");
		
	}
	public void selectMonth()
	{
		driver.getWaitUtility().waitForElementPresent(LOGDURATION);
		driver.findElement(LOGDURATION).click();
		driver.getAssertionService().addAssertionLog("Changing search log duration to  one Month", MessageTypes.Info);
		driver.getWaitUtility().waitForElementPresent(MONTH);
		driver.findElement(MONTH).click();
		driver.getWaitUtility().waitForElementPresent(MONTH);
		driver.getAssertionService().assertTrue((new ExtendedWebElement((MONTH)).isDisplayed()), "Search log duration is not change ", "search log duration changed to month");
		
	}
	public void selectYear()
	{
		driver.getWaitUtility().waitForElementPresent(LOGDURATION);
		driver.findElement(LOGDURATION).click();
		driver.getAssertionService().addAssertionLog("Changing search log duration to one year", MessageTypes.Info);
		driver.getWaitUtility().waitForElementPresent(YEAR);
		driver.findElement(YEAR).click();
		driver.getWaitUtility().waitForElementPresent(YEAR);
		driver.getAssertionService().assertTrue((new ExtendedWebElement((YEAR)).isDisplayed()), "Search log duration is not change ", "search log duration changed to year");
		
	}
	
	public void clickBackToTopLink()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.getWaitUtility().waitForElementPresent(BACKTOTOP);
		driver.findElement(BACKTOTOP).click();
	}
	public void verifyEngineDetails()
	{
		driver.getAssertionService().assertTrue((new ExtendedWebElement((VERIFYEXPANDVIEWALL)).isPresent()), "Engine  details is not dipslayed", "Engine details is dipslayed successfully");
	}
	public void verifySearchLogs()
	{
		driver.getAssertionService().assertTrue((new ExtendedWebElement((VERIFYSEARCHLOGS)).isPresent()), "Log Search window is not displayed", "Log Search window is displayed");
	}

	public void verifyRemoteLog() 
	{
		driver.getAssertionService().assertTrue((new ExtendedWebElement((CLEARLOG)).isPresent()), "Remote Log Search is not displayed", "Remote Log  window is displayed");
	}
	public void clickSnapshot()
	{
		driver.findElement(SNAPSHOT).click();
		
	}
	public void verifyClickSnapshot()
	{
		driver.getWaitUtility().waitForElementPresent(VERIFYSNAPSHOT);
		driver.getAssertionService().assertTrue((new ExtendedWebElement((VERIFYSNAPSHOT)).isPresent()), "FAIL", "pass");
		
	}
	public void verifyClickClear()
	{
		if (new ExtendedWebElement(CLEARLOG).isPresent())
		{
			driver.getAssertionService().addAssertionLog("clear button is enabled, clicking on it", MessageTypes.Pass);
			new ExtendedWebElement(CLEARLOG).click();
		}	
	}
	public void verifyLogFiles()
	{
		addStaticWait(10000);
		driver.getWaitUtility().waitForElementPresent(LOGFILES);	
		driver.getAssertionService().assertTrue((new ExtendedWebElement((LOGFILES)).isPresent()), "Log files for the engine is not launched", "Log files for the engine is launched");
	}
	public void clickDownloadLogLink()
	{
		 
		driver.getWaitUtility().waitForElementPresent(DOWNLOAD);
		driver.getAssertionService().addAssertionLog("Download link button is enabled, clicking on it", MessageTypes.Pass);
		driver.findElement(DOWNLOAD).click();
		/*addStaticWait(10000);
		if (new ExtendedWebElement(DOWNLOAD).isPresent())
		{
		driver.getAssertionService().addAssertionLog("Download link button is enabled, clicking on it", MessageTypes.Pass);
		//driver.findElement(DOWNLOAD).click();
		}*/
	}
	

}
