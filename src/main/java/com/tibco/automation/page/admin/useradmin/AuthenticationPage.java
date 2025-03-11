package com.tibco.automation.page.admin.useradmin;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

import java.util.*;
import java.util.concurrent.TimeUnit;

import com.sun.corba.se.spi.orbutil.fsm.Action;
import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.Locators;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.common.TopPaginate;
import com.tibco.automation.page.common.TemplatePage.GSMenu;

//Punam 
public class AuthenticationPage extends TemplatePage implements Locators.AuthenticationPageLocators 

{
	public DataGrid datagrid;
	public ExtendedWebDriver driver;
	public String pageTitle = "Authentication";
	public TemplatePage templatePage;
	public TopPaginate topPaginate;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	 
	public AuthenticationPage() {
		
		super("Authentication", GSMenu.Authentication);
		System.out.print("AuthenticationPage..");
		datagrid = new DataGrid();
		driver = getDriver();
		templatePage = new TemplatePage();
		topPaginate = new TopPaginate();
		System.out.println(" After AuthenticationPage  GSMenu..!!");
		
	}

	@Override
	public boolean isPageActive(Object... object) {
		return super.verifyPageTitle(pageTitle);
		
	}

	@Override
	public void waitForPageToLoad() {
		super.waitForPageToLoad();
	}

	//Creating the LDAP server  
	public void createldapserver()
	{	
		driver.getAssertionService().addAssertionLog("Creating the LDAP Server.", MessageTypes.Info); 
		//new ExtendedWebElement(By.xpath(SCROLLBAR)).click();
		new ExtendedWebElement(By.xpath(PROVIDERS_URL)).clear();
		new ExtendedWebElement(By.xpath(PROVIDERS_URL)).sendKeys("ldap://testldap.grid.datasynapse.com:389");
		new ExtendedWebElement(By.xpath(USERNAME_DN)).clear();
		new ExtendedWebElement(By.xpath(USERNAME_DN)).sendKeys("cn=Administrator,dc=qa-ldap,dc=datasynapse,dc=com");
		new ExtendedWebElement(By.xpath(PASSWORD)).clear();
		new ExtendedWebElement(By.xpath(PASSWORD)).sendKeys("datasynapse");
		new ExtendedWebElement(By.xpath(USER_SEARCH_STRING_FOR)).clear();
		
		new ExtendedWebElement(By.xpath(USER_SEARCH_STRING_FOR)).sendKeys("cn={0}");
		driver.findElement(By.xpath(USER_SEARCH_BASE)).clear();
		driver.findElement(By.xpath(USER_SEARCH_BASE)).sendKeys("ou=users,dc=qa-ldap,dc=datasynapse,dc=com");
	    Select subtree1= new Select(new ExtendedWebElement(By.xpath(USER_SEARCH_SUBTREE)));
		subtree1.selectByIndex(0);
		new ExtendedWebElement(By.xpath(GROUP_SEARCH_ATTRIBUTE)).clear();
		new ExtendedWebElement(By.xpath(GROUP_SEARCH_ATTRIBUTE)).sendKeys("cn");
		new ExtendedWebElement(By.xpath(GROUP_SEARCH_BASE)).clear();
		new ExtendedWebElement(By.xpath(GROUP_SEARCH_BASE)).sendKeys("ou=groups,dc=qa-ldap,dc=datasynapse,dc=com");
		new ExtendedWebElement(By.xpath(GROUP_SEARCH_FORMAT)).clear();
	    new ExtendedWebElement(By.xpath(GROUP_SEARCH_FORMAT)).sendKeys("memberUid={0}");
		
		Select subtree2= new Select(new ExtendedWebElement(By.xpath(GROUP_SEARCH_SUBTREE)));
		subtree2.selectByIndex(0);
	
			waitForPageToLoad();
			addStaticWait(1000);

	}
	
	
	//Selecting the LDAP Authentication mode 
	public  void selectldapmode()
	{
		new ExtendedWebElement(By.xpath(SCROLLBAR)).click();
		driver.getAssertionService().addAssertionLog("Selecting the LDAP mode.", MessageTypes.Info); 
        Select mode= new Select(new ExtendedWebElement(By.id(AUTH_MODE)));
        mode.selectByIndex(1);
		waitForPageToLoad();	
		
	}
	
	
	//Selecting the Windows mode 
	public  void selectwindowsmode()
	{
		driver.getAssertionService().addAssertionLog(".", MessageTypes.Info); 
       Select mode= new Select(new ExtendedWebElement(By.id(AUTH_MODE)));
        mode.selectByIndex(2);
    	waitForPageToLoad();	
        driver.getWaitUtility().waitForElementPresent(WINDOWS_DOMAIN);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(WINDOWS_DOMAIN).isPresent(), "Windows mode is selected", "Windows mode is not selected");
	
		
	}
	
	
	//Selecting the Internal DB Authentication mode (Grid-4682)
	public  void selectinternaldbmode()
	{ 
		driver.getAssertionService().addAssertionLog("Selecting the internal DB mode.", MessageTypes.Info); 
	    new ExtendedWebElement(By.xpath(SCROLLBAR)).click();
	    Select mode= new Select(new ExtendedWebElement(By.id(AUTH_MODE)));
        mode.selectByIndex(0);
		waitForPageToLoad();	
		
	}
	
	
	//Expanding the details on Internal DB page
	public void clickdbexpandAll()
	{  
		
		  driver.getAssertionService().addAssertionLog("Expanding the details on Internal DB page.", MessageTypes.Info); 
		 
		  new  ExtendedWebElement(By.xpath(EXPAND_ALL)).click();
		 
		  new ExtendedWebElement(By.xpath(TABLE_ARROW_DB_MODE)).click();
		  waitForPageToLoad(); 
		
	}
	
	//Expanding the details on LDAP DB page
	public void clickldapexpandAll() throws InterruptedException
	{ 
	
		  driver.getAssertionService().addAssertionLog("Expanding the details on LDAP page.", MessageTypes.Info); 
		  
		  Thread.sleep(60);
			
			waitForPageToLoad();
		  
			getDriver().getWaitUtility().waitForElementVisible(By.xpath(COMMON_LDAP_CONFIG_ARROW));
			new ExtendedWebElement(By.xpath(COMMON_LDAP_CONFIG_ARROW)).click();
		   
			getDriver().getWaitUtility().waitForElementVisible(By.xpath(CONNE_CONFIG_ARROW));
			new ExtendedWebElement(By.xpath(CONNE_CONFIG_ARROW)).click();
		   new ExtendedWebElement(By.xpath(GROUP_CONFIG_ARROW)).click();
		   new ExtendedWebElement(By.xpath(USER_CONFIG_ARROW)).click();
		   System.out.println("USER_CONFIG_ARROW---");
		   new  ExtendedWebElement(By.xpath(EXPAND_ALL)).click();
			waitForPageToLoad(); 
	}
	
	//Expanding the details on Windows page
	public void clickwindowsexpandAll()
	{ 
	
	
		   driver.getAssertionService().addAssertionLog("Expanding the details on Windows page.", MessageTypes.Info); 
		   new  ExtendedWebElement(By.xpath(EXPAND_ALL)).click();
		   new ExtendedWebElement(By.xpath(TABLE_ARROW_DB_MODE)).click();
			waitForPageToLoad(); 
	}
	
	
	
	//ollapsing the details on LDAP page
	public void clickcollapseAll()
	{
		driver.getAssertionService().addAssertionLog("Collapsing the details.", MessageTypes.Info); 
		new  ExtendedWebElement(By.xpath(EXPAND_ALL)).click();
		new  ExtendedWebElement(By.xpath(COLLAPSE_ALL)).click();
		waitForPageToLoad(); 
	}
	
	//collapsing the details on Internal db page
	public void clickdbcollapseAll()
	{
		driver.getAssertionService().addAssertionLog("Collapsing the details on Internal DB page.", MessageTypes.Info); 
		new  ExtendedWebElement(By.xpath(EXPAND_ALL)).click();
		new  ExtendedWebElement(By.xpath(COLLAPSE_ALL)).click();
		waitForPageToLoad(); 
	}
	
	//collapsing the details on windows page
	public void clickwindowscollapseAll()
	{
		driver.getAssertionService().addAssertionLog("Collapsing the details on windows page.", MessageTypes.Info); 
		new  ExtendedWebElement(By.xpath(EXPAND_ALL)).click();
		new  ExtendedWebElement(By.xpath(COLLAPSE_ALL)).click();
		waitForPageToLoad(); 
	}
	
	
	
	// Adding other ldap server Grid-4592
	public void addldapServer()
	{
		String mainWindowHandle = driver.getWindowHandle();
		driver.getAssertionService().addAssertionLog("Adding LDAP Server.", MessageTypes.Info);
		
		getDriver().getWaitUtility().waitForElementVisible(By.xpath(GLOBAL_ACTION));
		new ExtendedWebElement(By.xpath(GLOBAL_ACTION)).click();
		
		waitForPageToLoad();
		new ExtendedWebElement(By.xpath(ADD_LDAP_SERVER_LINK_LOC)).click();
	//	waitForPageToLoad();
	     Alert alt = driver.switchTo().alert();
		 alt.accept();
		 waitForPageToLoad(); 
		
	    for (String winHandle : driver.getWindowHandles()) {
	    	driver.switchTo().window(winHandle);
			// driver.manage().window().maximize();
				String uploadFileWindow = driver.getWindowHandle();
			}
	    	driver.switchTo().window(mainWindowHandle);
			driver.navigate().refresh();
	}


	// Removing the ldap server
	public void removeldapServer()
	{
		
		 String mainWindowHandle = driver.getWindowHandle();
		new ExtendedWebElement(By.xpath(SCROLLBAR)).click();
		
		driver.getAssertionService().addAssertionLog("Removing LDAP server.", MessageTypes.Info); 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(580,45)");
			Actions actions = new Actions(driver);
			new ExtendedWebElement(By.xpath("tr[37]//th[1]//i[1]")).click();	
	//	actions.moveToElement(new ExtendedWebElement(By.xpath(ACTION_LINK1)));
	// new ExtendedWebElement(By.xpath(ACTION_LINK1)).click();
				
		actions.perform();
		//new ExtendedWebElement(By.xpath(ACTION_LINK1)).click();
		WebElement myElement = driver.findElement(By.xpath(REMOVE_LDAP));
	
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", myElement);
	   js.executeScript("window.scrollBy(1280,607)", "");
		new ExtendedWebElement(By.xpath(REMOVE_LDAP)).click();
		
		  Alert alt = driver.switchTo().alert();
		  alt.accept();
		  waitForPageToLoad(); 
		  try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			
				String uploadFileWindow = driver.getWindowHandle();
			}
	    	driver.switchTo().window(mainWindowHandle);
			driver.navigate().refresh();
		
		
	}

	
	  public void testConnection() throws InterruptedException
	  {
		  
		  String mainWindowHandle = driver.getWindowHandle();
		   new ExtendedWebElement(By.xpath(PROVIDERS_URL)).clear();
			new ExtendedWebElement(By.xpath(PROVIDERS_URL)).sendKeys("ldap://testldap.grid.datasynapse.com:389");
			new ExtendedWebElement(By.xpath(USERNAME_DN)).clear();
			new ExtendedWebElement(By.xpath(USERNAME_DN)).sendKeys("cn=Administrator,dc=qa-ldap,dc=datasynapse,dc=com");
			new ExtendedWebElement(By.xpath(PASSWORD)).clear();
			new ExtendedWebElement(By.xpath(PASSWORD)).sendKeys("datasynapse");
			
			 new ExtendedWebElement(By.xpath(TEST_CONNECTION)).click();
			  String passmsg1=driver.findElement(By.xpath(CONNE_MSG)).getText();
			  driver.getAssertionService().assertEquals(passmsg1,"Connection Successful", "Conncetion established");
	        new ExtendedWebElement(By.xpath(CLOSE_BUTTON)).click();
	  }
	  
	//Clicking on property gear action
       public void clickproperty() throws InterruptedException
		 {
    	  driver.getAssertionService().addAssertionLog("Clicking on the Property gear action.", MessageTypes.Info);
    	  getDriver().getWaitUtility().waitForElementVisible(By.xpath(ACTION_LINK));
  		  new ExtendedWebElement(By.xpath(ACTION_LINK)).click();	 
  		  waitForPageToLoad();
  		  Thread.sleep(60);
       //  getDriver().getWaitUtility().waitForElementVisible(By.xpath(EXPAND_DETAILS));
  		// new ExtendedWebElement(By.xpath(EXPAND_DETAILS)).click();
  		 getDriver().getWaitUtility().waitForElementVisible(By.xpath(ACTION_LINK));
 		 new ExtendedWebElement(By.xpath(ACTION_LINK)).click();	 
  		 getDriver().getWaitUtility().waitForElementVisible(By.xpath(COLLAPSE_DETAILS));
  		 new ExtendedWebElement(By.xpath(COLLAPSE_DETAILS)).click();
  		getDriver().getWaitUtility().waitForElementVisible(By.xpath(ACTION_LINK));
		 new ExtendedWebElement(By.xpath(ACTION_LINK)).click();	
  		getDriver().getWaitUtility().waitForElementVisible(By.xpath(EXPAND_DETAILS));
 		 new ExtendedWebElement(By.xpath(EXPAND_DETAILS)).click();
  		 waitForPageToLoad();
  		 driver.navigate().refresh();
	 
		 }
		 

	//Clicking on the Cancel button  Grid-4591
	 public void clickCancel() throws InterruptedException
	 {
		 driver.getAssertionService().addAssertionLog("Cancel the changes.", MessageTypes.Info);
		 Thread.sleep(60);
		 getDriver().getWaitUtility().waitForElementVisible(By.xpath(CANCEL_BTN));
		 new ExtendedWebElement(By.xpath(CANCEL_BTN)).click();
			waitForPageToLoad();
		 
	 }
	
	//Clicking on the save button  Grid-4590
	public void clickSave()
	{ 
		String mainWindowHandle = driver.getWindowHandle();
		
		driver.getAssertionService().addAssertionLog("Save the details.", MessageTypes.Info);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		getDriver().getWaitUtility().waitForElementVisible(By.xpath(SAVE_BUTTON));
		new ExtendedWebElement(By.xpath(SAVE_BUTTON)).click();
       
		  Alert alt = driver.switchTo().alert();
		  alt.accept();
		  waitForPageToLoad(); 
		  for (String winHandle : driver.getWindowHandles()) 
		  {
				driver.switchTo().window(winHandle);
				// driver.manage().window().maximize();
				String uploadFileWindow = driver.getWindowHandle();
			}
	    	driver.switchTo().window(mainWindowHandle);
			driver.navigate().refresh();
		  
		
		 }
  
	 
	  public void negativevalueTest()
	  {
		  
		  String mainWindowHandle = driver.getWindowHandle();
		  new ExtendedWebElement(By.xpath(CACHE_TTL)).clear();
		 driver.getAssertionService().addAssertionLog("LDAP User Cache TTL (seconds)' must be specified.", MessageTypes.Warn); 
		   Alert alt = driver.switchTo().alert();
		  alt.accept();
		  
		  waitForPageToLoad(); 
		  for (String winHandle : driver.getWindowHandles()) 
		  {
				driver.switchTo().window(winHandle);
				// driver.manage().window().maximize();
				String uploadFileWindow = driver.getWindowHandle();
			}
	    	driver.switchTo().window(mainWindowHandle);
			driver.navigate().refresh();
	  }
	  
	  public void verifytooltip()
	  
			{
				driver.getWaitUtility().waitForElementPresent(CACHE_TTL_TOLLTIP);
				driver.getAssertionService().assertTrue(new ExtendedWebElement(CACHE_TTL_TOLLTIP).isDisplayed(), "Tooltip for LDAP User Cache TTL is not present", "Tooltip for LDAP User Cache TTL  is present");				
	        }
		  
		  
	  public void invalidPassConnectionTest()
	  {
		  
		  String mainWindowHandle = driver.getWindowHandle();
		   new ExtendedWebElement(By.xpath(PROVIDERS_URL)).clear();
			new ExtendedWebElement(By.xpath(PROVIDERS_URL)).sendKeys("ldap://testldap.grid.datasynapse.com:389");
			new ExtendedWebElement(By.xpath(USERNAME_DN)).clear();
			new ExtendedWebElement(By.xpath(USERNAME_DN)).sendKeys("cn=Administrator,dc=qa-ldap,dc=datasynapse,dc=com");
			new ExtendedWebElement(By.xpath(PASSWORD)).clear();
			new ExtendedWebElement(By.xpath(PASSWORD)).sendKeys("datasy");
			  new ExtendedWebElement(By.xpath(TEST_CONNECTION)).click();
			  String passmsg=driver.findElement(By.xpath(INVALIDE_PASS_CONNE_MSG)).getText();
		    driver.getAssertionService().assertEquals(passmsg,"Error: [LDAP: error code 49 - Invalid Credentials]", "Invalid password");
	        new ExtendedWebElement(By.xpath(CLOSE_BUTTON)).click();
	        
	  }
	  
	  
	  
	  }


