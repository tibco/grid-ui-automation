package com.tibco.automation.page.services.services;

import com.tibco.automation.page.common.Locators.CacheSchemaLocators;
import com.tibco.automation.page.common.Locators.RolePageLocators;
import com.tibco.automation.page.common.TemplatePage.GSMenu;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.common.TopPaginate;
import com.tibco.automation.page.admin.useradmin.RolePage;

public class CacheSchemaPage extends TemplatePage implements CacheSchemaLocators, RolePageLocators {
	public DataGrid datagrid; // these are class references
	public ExtendedWebDriver driver;
	
	public Select select;
	
	
	public CacheSchemaPage()
	{
		super("Cache Schemas", GSMenu.CacheSchemas);
		driver = getDriver();
	}
	public void waitForPageToLoad() 
	{
	super.waitForPageToLoad();
	}	
	
	public void addButton(String schemaName)
	{
		
		driver.getWaitUtility().waitForElementPresent(ADDBUTTON);
		WebElement toClear = driver.findElement(CACHENAME);
		toClear.sendKeys(Keys.CONTROL + "a");
		toClear.sendKeys(Keys.DELETE);
		driver.findElement(CACHENAME).sendKeys(schemaName);
		driver.findElement(ADDBUTTON).click();
	}
	public void clickSaveButton()
	{
		driver.findElement(SAVE_BUTTON1).click();
	}
	public void clickCancelButton()
	{
		driver.findElement(CANCELADDSCHEMA).click();
	}
	public void editSchema(String schemaName)
	{
		driver.getWaitUtility().waitForElementPresent(ADDBUTTON);	
		driver.findElement(String.format(ACTION,schemaName)).click();
		driver.findElement(EDITSCHEMA).click();	
	}
	public void removeSchema(String schemaName)
	{
		driver.getWaitUtility().waitForElementPresent(ADDBUTTON);	
		driver.findElement(String.format(ACTION,schemaName)).click();
		driver.findElement(REMOVESCHEMA).click();	
	}
	public void renameSchema(String schemaName)
	{
		driver.getWaitUtility().waitForElementPresent(ADDBUTTON);	
		driver.findElement(String.format(ACTION,schemaName)).click();
		driver.findElement(RENAMESCHEMA).click();	
	}
	public void renameSchema()
	{
		driver.findElement(ACTION_).click();
		driver.findElement(RENAMESCHEMA).click();
	}
	
	public void enterData_EditSchema()
	{
		driver.findElement(CACHEREGION).sendKeys("region");
	}
	
	public void copySchema()
	{
		driver.findElement(ACTION_).click();
		driver.findElement(COPYSCHEMA).click();
	}
	public void enterData(String schemaName)
	{
		WebElement toClear = driver.findElement(COPYSCHEMANAMEFIELD);
		toClear.sendKeys(Keys.CONTROL + "a");
		toClear.sendKeys(Keys.DELETE);
	    driver.findElement(COPYSCHEMANAMEFIELD).sendKeys(schemaName);
		
	}
	
	public void clickPopupSaveButton()
	{
		driver.findElement(SAVESCHEMA).click();
	}
	public void clickPopupCancelButton()
	{
		driver.findElement(CANCELCOPYSCHEMA).click();
	}

	public void verifyAddButton(String schemaName)
	{
		driver.getWaitUtility().waitForElementPresent(String.format(VERIFYADDSCHEMA, schemaName));
		driver.getAssertionService().assertTrue((new ExtendedWebElement(String.format(VERIFYADDSCHEMA, schemaName)).isDisplayed()), "Cache schema is not added", "Cache schema is added successfully.Added schema is: '"+schemaName+"'");

	}
	public void verifyCancelButton(String schemaName)
	{
		driver.getWaitUtility().waitForElementPresent(String.format(VERIFYADDSCHEMA, schemaName));
		driver.getAssertionService().assertFalse((new ExtendedWebElement(String.format(VERIFYADDSCHEMA, schemaName)).isPresent()), "Cache schema is added after clicking on Cancel Button", "Cache schema is not added after clicking on Cancel Button");
	}
	public void verifyDescriptionTooltip()
	{
		String TOOLTIP="//span[@data-toggle='tooltip' and contains(@data-title,'Specifies the region regular expression that will map regions to this schema')]";
		driver.getWaitUtility().waitForElementPresent(TOOLTIP);
		driver.getAssertionService().assertTrue(new ExtendedWebElement(TOOLTIP).isDisplayed(), "Tooltip for description is not present", "Tooltip for description is present");		
	}
	
	public void verifyEditSchema(String schemaName)
	{
		driver.getAssertionService().assertTrue((new ExtendedWebElement(VERIFYEDIT).isPresent()), "Schema is not edited", "Schema is edited succesfully");
	}
	public void verifyEditCancelSchema(String schemaName)
	{
		driver.getAssertionService().assertFalse((new ExtendedWebElement(VERIFYEDIT).isPresent()), "Schema is edited after clicking on cancel button", "Schema is not edited after clicking on cancel button");
	}
	public void verifyRemoveSchema(String schemaName)
	{
		driver.getWaitUtility().waitForElementPresent(ADDBUTTON);
		driver.getAssertionService().assertFalse((new ExtendedWebElement(String.format(VERIFYADDSCHEMA, schemaName)).isPresent()), "Schema is not removed", "Schema is removed succesfully");
	}
	public void verifyRemoveCancelSchema(String schemaName)
	{
		driver.getAssertionService().assertTrue((new ExtendedWebElement(String.format(VERIFYADDSCHEMA, schemaName)).isPresent()), "Schema is removed after clicking on Cancel button", "Schema is not removed after clicking on Cancel button");
	}
	public void log(String schemaName)
	{
		driver.getAssertionService().addAssertionLog("Deleting newly created schema: '"+schemaName+"' ", MessageTypes.Info);
	}
	public void verifyCopySchema(String schemaName)
	{
		driver.getWaitUtility().waitForElementPresent(String.format(VERIFYADDSCHEMA, schemaName));
		driver.getAssertionService().assertTrue((new ExtendedWebElement(String.format(VERIFYADDSCHEMA, schemaName)).isDisplayed()), "Cache schema is not copied", "Cache schema is copied successfully.Copied schema is: '"+schemaName+"'");

	}
	public void verifyCancelCopySchema(String schemaName)
	{
		driver.getWaitUtility().waitForElementPresent(ADDBUTTON);
		driver.getAssertionService().assertFalse((new ExtendedWebElement(String.format(VERIFYADDSCHEMA, schemaName)).isPresent()), "Cache schema is copied after clicking on Cancel Button", "Cache schema is not copied after clicking of cancel button");

	}
	public void verifyCancelRenameSchema(String schemaName)
	{
		driver.getWaitUtility().waitForElementPresent(ADDBUTTON);
		driver.getAssertionService().assertFalse((new ExtendedWebElement(String.format(VERIFYADDSCHEMA, schemaName)).isPresent()), "Cache schema is renamed after clicking on Cancel Button", "Cache schema is not renamed after clicking of cancel button");

	}
	public void verifyRenameSchema(String schemaName)
	{
		driver.getAssertionService().assertTrue((new ExtendedWebElement(String.format(VERIFYADDSCHEMA, schemaName)).isDisplayed()), "Cache schema is not renamed", "Cache schema is renamed successfully to: '"+schemaName+"'");

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
