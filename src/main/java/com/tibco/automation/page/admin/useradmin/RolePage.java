package com.tibco.automation.page.admin.useradmin;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;

import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.Locators;
import com.tibco.automation.page.common.Locators.UsersPageLocators;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.common.TopPaginate;
import com.tibco.automation.page.common.TemplatePage.GSMenu;
import com.tibco.automation.page.common.TopPaginate.MoreActions;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RolePage extends TemplatePage implements Locators.RolePageLocators  {
	public DataGrid datagrid; // these are class references
	public ExtendedWebDriver driver;
	public String pageTitle ="Role Admin";
	public TemplatePage templatePage;
	public TopPaginate topPaginate;
	public String winHandleBefore;
	public String parentWinHandle;
	public Select select;
	public JavascriptExecutor js = (JavascriptExecutor) driver;
	
	
			public RolePage()
			{
				//ADMIN --> ROLE ADMIN
				super("Roles", GSMenu.Roles);
				System.out.println("GSMenu..!!");
				datagrid = new DataGrid(); // as already defined above we are just initializing 
				driver = getDriver();
				templatePage = new TemplatePage();
				topPaginate = new TopPaginate();
				System.out.println(" After GSMenu..!!");
			}
			
				@Override
				public void waitForPageToLoad() {
				super.waitForPageToLoad();
				}
				
				//maximize current window
				public void maximizeCurrentWindow()
				{
					winHandleBefore = driver.getWindowHandle();
					for(String winHandle : driver.getWindowHandles()){
					driver.switchTo().window(winHandle);
					driver.manage().window().maximize();
					}
				}
				public void closeChildWindow()
				{
					 // To maximize browser
					 driver.manage().window().maximize();
					 // To open Naukri website with multiple windows
					// driver.get("http://www.naukri.com/");
					 // It will return the parent window name as a String
					 String mainWindow=driver.getWindowHandle();
					 // It returns no. of windows opened by WebDriver and will return Set of Strings
					 Set<String> set =driver.getWindowHandles();
					 // Using Iterator to iterate with in windows
					 Iterator<String> itr= set.iterator();
					 while(itr.hasNext()){
					 String childWindow=itr.next();
					    // Compare whether the main windows is not equal to child window. If not equal, we will close.
					 if(!mainWindow.equals(childWindow)){
					 driver.switchTo().window(childWindow);
					 System.out.println(driver.switchTo().window(childWindow).getTitle());
					 driver.close();
					 }
					 }
					 // This is to switch to the main window
					 driver.switchTo().window(mainWindow);
					 }
					 
				
				public void quit()
				{
					driver.close();
				}
				public void switchToParentWindow()
				{
					driver.switchTo().window(winHandleBefore);
				}
				
				public void waitt()
				{
					driver.getWaitUtility().waitForElementPresent(GLOBAL_ACTION);
				}
				//Verify add/remove column option is present
				public void addColumnPresent()
				{
					driver.getWaitUtility().waitForElementPresent(GLOBAL_ACTION);
					driver.getAssertionService().assertTrue((new ExtendedWebElement((ADDREMOVECOLUMN)).isPresent()), "Add/Remove columns option is not present on page", "Add/Remove columns option is present on page");
				}	
						
				//Remove column function
				public void removeColumn()
				{
					driver.findElement(ADDREMOVECOLUMN).click();
					driver.findElement(REMOVECOLUMN).click();
					driver.findElement(ADDCOLUMNSAVE).click();
					driver.getWaitUtility().waitForElementPresent(GLOBAL_ACTION);
				}
				
				//Verify column removed 
				public void verifyRemoveColumn()
				{
					driver.getAssertionService().assertFalse((new ExtendedWebElement((ROLENAME)).isPresent()), "Role Name column is present:column is not removed ", "Role Name column is not present:column is removed successfully");
				}
				
				//Add column function
				public void addColumn()
				{
					driver.findElement(ADDREMOVECOLUMN).click();
					driver.findElement(ADDCOLUMN).click();
					driver.findElement(ADDCOLUMNSAVE).click();
					driver.getWaitUtility().waitForElementPresent(GLOBAL_ACTION);
					
				}
				
				//Verify column added
				public void verifyAddColumn()
				{
					driver.getAssertionService().assertTrue((new ExtendedWebElement((ROLENAME)).isDisplayed()), "Role Name column is not present:column is not added ", "Role Name column is present:column is added successfully");
				}
		
				//revert button function
				public void revertButton()
				{
					driver.getWaitUtility().waitForElementPresent(GLOBAL_ACTION);
					driver.findElement(ADDREMOVECOLUMN).click();
					driver.findElement(REVERT).click();
					driver.findElement(ADDCOLUMNSAVE).click();
					driver.getWaitUtility().waitForElementPresent(GLOBAL_ACTION);
				}
				
				//Verify revert button function
				public void verifyRevertButton()
				{
					boolean X=new ExtendedWebElement(String.format(VERIFYREVERT)).isPresent();
					driver.getAssertionService().assertTrue(X, "Columns are not arranged in predefined format", "Columns are arranged in predefined format");
				}
		
				//CLICK ON GLOBAL ACTION -->CREATE NEW USER
				public void clickCreateNewRole() {
					waitForPageToLoad();
					driver.getWaitUtility().waitForElementPresent(GLOBAL_ACTION);
					driver.findElement(GLOBAL_ACTION).click();
					driver.getWaitUtility().waitForElementPresent(CREATE_NEW_ROLE_LINK_LOC);
					//parent window handle
					parentWinHandle = driver.getWindowHandle();
					driver.findElement(CREATE_NEW_ROLE_LINK_LOC).click();
				}
				
				public void verifyGlobalAction()
				{
					driver.getWaitUtility().waitForElementPresent(SAVE_BUTTON1);
					driver.getAssertionService().assertTrue(new ExtendedWebElement(SAVE_BUTTON1).isDisplayed(), "New popup is not displayed", "New popup is displayed ");
				}
				
				
				//GLOBAL ACTION "CREATE NEW ROLE"
				public void collapseAll()
				{
					driver.getWaitUtility().waitForElementPresent(COLLAPSEALL);
					driver.findElement(COLLAPSEALL).click();
				}
				
				public void expandAll()
				{
					driver.getWaitUtility().waitForElementPresent(EXPANDALL);
					driver.findElement(EXPANDALL).click();
				}
		
				public void cancelButton()
				{	
					driver.getWaitUtility().waitForElementPresent(CANCEL1);
					driver.findElement(CANCEL1).click();
					driver.switchTo().window(parentWinHandle);
					driver.getWaitUtility().waitForElementPresent(GLOBAL_ACTION);
					
					
				}
				
				public void verifyCancelButton(String roleName)
				{
					driver.getWaitUtility().waitForElementPresent(GLOBAL_ACTION);
					Boolean present=new ExtendedWebElement(String.format(ROLE,roleName)).isPresent();
					driver.getAssertionService().assertFalse(present, "Role is created:Click on Cancel button faild", "Role is not created:Click on Cancel button passed");
				}
				
				public void cancelButton2()
				{	
					driver.getWaitUtility().waitForElementPresent(CANCEL2);
					driver.findElement(CANCEL2).click();
					driver.switchTo().window(parentWinHandle);
				}
				public void saveButton()
				{
					
					driver.getWaitUtility().waitForElementPresent(SAVE_BUTTON1);
					driver.findElement(SAVE_BUTTON1).click();
					driver.switchTo().window(parentWinHandle);
					driver.getWaitUtility().waitForElementPresent(GLOBAL_ACTION);
				}
				//Verify new role is created 
				public void verifySaveButton(String roleName)
				{
					driver.getWaitUtility().waitForElementPresent(GLOBAL_ACTION);
					driver.getAssertionService().assertTrue((new ExtendedWebElement(String.format(ROLE, roleName)).isPresent()), "New role is not created", "New role "+roleName+" is created successfully");
				}
		
				public void insertData(String roleName,String Manger_List) 
				{
					driver.getWaitUtility().waitForElementPresent(ROLE_NAME);
					driver.findElement(ROLE_NAME).sendKeys(roleName);
					driver.findElement(MANAGER_LIST).sendKeys(Manger_List);
				}
				
				//Select Enabled Permission for Role
				public void enabledPermission() 
				{
					driver.getWaitUtility().waitForElementPresent(ENABLEPERMISSION);
					select = new Select(driver.findElement(ENABLEPERMISSION)); 
					select.selectByIndex(2);
				}
				
				//Global  Action:verify role is created with given enabled permission
				public void verifyEnabledPermission(String roleName)
				{
					driver.getWaitUtility().waitForElementPresent(SAVE_BUTTON1);
					driver.getAssertionService().assertTrue((new ExtendedWebElement((CHECKBOXENABLEPERMISSION)).isSelected()),"Role is not created with enabled permission","Role "+roleName+" is successfully created with enabled permission");
				}
				//Global Action:select Security role to copy
				public void copyRole()
				{
					JavascriptExecutor js = (JavascriptExecutor) driver;
			        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
					driver.getWaitUtility().waitForElementPresent(COPYROLE);
					select = new Select(driver.findElement(COPYROLE));
					select.selectByValue("Manage");
				}
		
				//Global Action: Verify copy security role  
				public void verifyCopySecurityRole(String roleName)
				{
					driver.getWaitUtility().waitForElementPresent(GLOBAL_ACTION);
					driver.getAssertionService().assertTrue((new ExtendedWebElement(String.format(ROLE3, roleName)).isDisplayed()), "Security Role is not copied", "Security Role is copied successfully copied role is: "+roleName+" ");
				}
		       //clickCloseOnQueryBuilder
				public void verifyClickCloseOnQueryBuilder()
				{
					driver.getAssertionService().assertTrue((new ExtendedWebElement((CONFIGUREROLE)).isDisplayed()), "Query Builder serach is performed:window is not closed", "Query Builder search is not performed: window is closed ");
					
				}
				
				//Global Action:Verify functionality of checkbox
				public void selectCheckboxFunction()
				{
					JavascriptExecutor js = (JavascriptExecutor) driver;
			        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			       
			        driver.getWaitUtility().waitForElementPresent(CHECK);
					WebElement option1 = driver.findElement(CHECK);
					if(option1.isSelected())
					{
						driver.getAssertionService().addAssertionLog("Checkbox is already Selected", MessageTypes.Info);
						driver.getAssertionService().addAssertionLog("Dselecting Checkbox to perform select checkbox function", MessageTypes.Info);
					    option1.click();
					    option1.click();
					}
					else
					{
						driver.getAssertionService().addAssertionLog("Checkbox is not selected...performing select checkbox function", MessageTypes.Info);
						option1.click();
					}
			     }
				public void deselectCheckboxFunction()
				{
					JavascriptExecutor js = (JavascriptExecutor) driver;
			        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			       
			        driver.getWaitUtility().waitForElementPresent(CHECK);
					WebElement option1 = driver.findElement(CHECK);
					if(option1.isSelected())
					{
						driver.getAssertionService().addAssertionLog("Checkbox is selected...performing deselect checkbox function", MessageTypes.Info);
					    option1.click();
					    
					}
					else
					{
						driver.getAssertionService().addAssertionLog("Checkbox is not selected...selecting checkbox to perform deselect checkbox function", MessageTypes.Info);
						option1.click();
						option1.click();
					}
			     }
				
				public void verifyCheckboxIsSelected()
				{
					boolean X=new ExtendedWebElement(String.format(CHECK)).isSelected();
					JavascriptExecutor js = (JavascriptExecutor) driver;
			        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			        driver.getAssertionService().assertTrue(X, "Checkbox is not selected", "Check box is selected");
					
			        
				}
				public void verifyCheckboxIsDeselected()
				{
					boolean X=new ExtendedWebElement(String.format(CHECK)).isSelected();
					JavascriptExecutor js = (JavascriptExecutor) driver;
			        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			        driver.getAssertionService().assertFalse(X, "Checkbox is not Deselected", "Check box is Deselected");
					
			        
				}
				//Click on sub-table header arrow for collapse table detail 
				public void sub_Table_Collapse()
				{
					driver.getWaitUtility().waitForElementPresent(SAVE_BUTTON1);
			
					driver.getWaitUtility().waitForElementPresent(SUBTABLEEXPANDCOLLAPSE);
					driver.findElement(SUBTABLEEXPANDCOLLAPSE).click();
					driver.findElement(SUBTABLEEXPANDCOLLAPSE1).click();
					driver.findElement(SUBTABLEEXPANDCOLLAPSE2).click();
					driver.findElement(SUBTABLEEXPANDCOLLAPSE3).click();
					driver.findElement(SUBTABLEEXPANDCOLLAPSE4).click();
					driver.findElement(SUBTABLEEXPANDCOLLAPSE5).click();
					driver.findElement(SUBTABLEEXPANDCOLLAPSE6).click();
					driver.findElement(SUBTABLEEXPANDCOLLAPSE7).click();
				}
		
				//Click on sub-table header arrow for expand table detail
				public void sub_Table_Expand()
				{
					driver.getWaitUtility().waitForElementPresent(SAVE_BUTTON1);
					driver.getWaitUtility().waitForElementPresent(SUBTABLEEXPANDCOLLAPSE);
					driver.findElement(SUBTABLEEXPANDCOLLAPSE).click();
					driver.findElement(SUBTABLEEXPANDCOLLAPSE).click();
				}
		
				//Verify after clicking on sub-table header arrow it will collapse information  
				public void verifyCollapse_Detail()
				{
					driver.getAssertionService().assertFalse((new ExtendedWebElement((PERMISSION)).isDisplayed()), "Table details is not dipslayed in collapsed format", "Table details is dipslayed in collapsed format ");
				}
		
				//Verify after clicking on sub-table header arrow it will collapse information 
				public void verifyExpand_Detail()
				{
					driver.getAssertionService().assertTrue((new ExtendedWebElement((PERMISSION)).isDisplayed()), "Table details is not dipslayed in Expanded format", "Table details is dipslayed in Expanded format ");
				}
				
				public void verifyEnableLocalAction()
				{
					driver.getAssertionService().assertTrue((new ExtendedWebElement((LOCALACTION)).isDisplayed()), "Local action is not enabled after selecting role", "Local action is enabled after selecting role");
				}
				public void verifyEnableGlobalAction()
				{
					driver.getAssertionService().assertTrue((new ExtendedWebElement((GLOBAL_ACTION)).isDisplayed()), "Global action is not enabled after after deselecting a selectd role", "Global action is enabled after deselecting a selectd role");
				}
				//LOCAL ACTION >View/Edit
				public void viewEditRole()
				{
					driver.getWaitUtility().waitForElementPresent(LOCALACTION);
					driver.findElement(LOCALACTION).click();
					parentWinHandle = driver.getWindowHandle();
					driver.findElement(VIEWEDIT).click();
				}
				
				//Verify functionality viewEditRole 
				public void verifyViewEditRole(String roleName)
				{
					driver.getWaitUtility().waitForElementPresent(GLOBAL_ACTION);
					driver.getAssertionService().assertTrue((new ExtendedWebElement(String.format(ROLE, roleName)).isDisplayed()), "Role is not Edited", "Role is Edited successfully description is changed to : '"+roleName+"'");
				}
				
				//verify functionality of cancel button of View/Edit role popup
				public void verifyViewEditRoleCancel(String roleName)
				{
					driver.getWaitUtility().waitForElementPresent(GLOBAL_ACTION);
					driver.getAssertionService().assertFalse((new ExtendedWebElement(String.format(ROLE, roleName)).isPresent()), "Role is Edited description is changed to : '"+roleName+"' Test case is failed" , "Role is Not Edited : description is not changed to : '"+roleName+"' Test case is passed");
					
				}
				public void localActionSave()
				{
					driver.findElement(SAVE_BUTTON2).click();
					driver.switchTo().window(parentWinHandle);
				}
		
				public void enterdata(String roleName)
				{
					WebElement toClear = driver.findElement(ENTERDESCRIPTION);
					toClear.sendKeys(Keys.CONTROL + "a");
					toClear.sendKeys(Keys.DELETE);
					driver.findElement(ENTERDESCRIPTION).sendKeys(roleName);
				}
		
				public void selectCheckbox()
				{


					//driver.navigate().refresh();
					driver.getWaitUtility().waitForElementPresent(CHECKBOX);
					WebElement option1 = driver.findElement(CHECKBOX);
					option1.click();
					option1.click();
					option1.click();
					driver.getAssertionService().addAssertionLog("Checkbox is selected ", MessageTypes.Info);
				}
		
				public void selectConfigRoleCheckbox()
				{
					driver.getWaitUtility().waitForElementPresent(GLOBAL_ACTION);
					WebElement option1 = driver.findElement(CONFIGUREROLE);
					option1.click();
					option1.click();
					option1.click();
				}
		
				//local action copy role
				public void copyRoleLocalAction()
				{
					driver.findElement(LOCALACTION).click();
					parentWinHandle = driver.getWindowHandle();
					driver.findElement(LOCALACTIONCOPY).click();
				}

				//Enter data for copy role
				public void enterData_CopyRole(String roleName)
				{
					//Enter new name for copied role
					WebElement toClear = driver.findElement(ROLE_NAME);
					toClear.sendKeys(Keys.CONTROL + "a");
					toClear.sendKeys(Keys.DELETE);
				    driver.findElement(ROLE_NAME).sendKeys(roleName);
					
				}

		
				//Verify Local Action:Copy Role
				public void verifyCopyRoleLocalAction(String roleName)
				{
					driver.getWaitUtility().waitForElementPresent(GLOBAL_ACTION);
					driver.findElement(String.format(ROLE,roleName)).click();
					driver.getAssertionService().assertTrue((new ExtendedWebElement(String.format(ROLE,roleName)).isDisplayed()), "Role is not Copied", "Role is Copied successfully Name of the copied role is: '"+roleName+"'");
				}
				//Verify Local Action:Cancel button of Copy Role
				public void verifyCancelCopyRoleLocalAction(String roleName)
				{
					driver.getWaitUtility().waitForElementPresent(GLOBAL_ACTION);
					driver.getAssertionService().assertFalse((new ExtendedWebElement(String.format(ROLE,roleName)).isPresent()), "Role is Copied  name of the copied role is '"+roleName+"' Test case is failed", "Role is Not Copied: '"+roleName+"' Test case is Passedd");
				}
		
				//Select Newly Added Role 
				public void selectRole(String roleName)
				{
					//driver.getWaitUtility().waitForElementPresent(GLOBAL_ACTION);
					driver.getWaitUtility().waitForElementPresent(CHECKBOX);
					WebElement option1 = driver.findElement(String.format(ROLE1,roleName));
					option1.click();
					option1.click();
					option1.click();
				}
				
				
				//Local Action_Delete:verify role is created to perform delete action		
				public void verifyRoleCreated(String roleName)
				{
					driver.getWaitUtility().waitForElementPresent(GLOBAL_ACTION);
					driver.getAssertionService().assertTrue((new ExtendedWebElement(String.format(ROLE,roleName)).isDisplayed()), "Role is not Copied", "Role is Copied successfully Name of the copied role is: '"+roleName+"'");
					driver.getAssertionService().addAssertionLog("Role is copied to perform delete action", MessageTypes.Info);
					driver.getAssertionService().addAssertionLog("Deleting newly copied role that is '"+roleName+"'", MessageTypes.Info);
					
				}
				//Local Action_Delete:Click on Global Action Delete
				public void deleteRoleLocalAction(String roleName)
				{
					driver.getWaitUtility().waitForElementPresent(LOCALACTION);
					driver.findElement(LOCALACTION).click();
					parentWinHandle = driver.getWindowHandle();
					driver.findElement(LOCALACTIONDELET).click();
					
				}
				
				//Local Action_Delete:Accept pop up
				public void acceptPopup()
				{
					Alert alt = driver.switchTo().alert();
					alt.accept();
				}
				//Local Action_Delete:Dissmiss pop up
				public void dismissPopup()
				{
					Alert alt = driver.switchTo().alert();
					alt.dismiss();
				}
				//Local Action_Delete:Verify Local action Delete
				
				public void verifyLocalActionDelete(String roleName)
				{
					driver.getWaitUtility().waitForElementPresent(GLOBAL_ACTION);
					driver.getAssertionService().assertFalse((new ExtendedWebElement(String.format(ROLE,roleName)).isPresent()), "Role '"+roleName+"' is not Deleted", "Role '"+roleName+"' is Deleted");
				
				}
				public void verifyLocalActionDeleteCancelButton(String roleName)
				{
					driver.getWaitUtility().waitForElementPresent(GLOBAL_ACTION);
					driver.getAssertionService().assertTrue((new ExtendedWebElement(String.format(ROLE,roleName)).isDisplayed()), "Role '"+roleName+"' is Deleted: Name of the role is  Test case is failed", "Role '"+roleName+"'  is not Deleted : Test case is Passed");
				
				}
				
				//Delete role Message
				public void deleteMessage(String roleName)
				{
					driver.getAssertionService().addAssertionLog("Newly created role '"+roleName+"' is deleted ", MessageTypes.Info);
				}
				
				//verify functionality of simple search
				public void verifySimpleSearch()
				{
					boolean X=new ExtendedWebElement(String.format(INVALID)).isPresent();
					driver.getAssertionService().assertTrue(X, "Simple search fail", "Performed simple search successfully");
					
				}
				//Click on clear search result
				public void clearSearch()
				{
					driver.getWaitUtility().waitForElementPresent(CLEAR);
					driver.findElement(CLEAR).click();
					
				}
		
				//Verify functionality of query search
				public void verifyPerformQuerySearch()
				{
					
					boolean X=new ExtendedWebElement(String.format(INVALID)).isPresent();
					driver.getAssertionService().assertTrue(X, "Query search fail", "Performed Query search successfully");
				
				}
		
		
		}


