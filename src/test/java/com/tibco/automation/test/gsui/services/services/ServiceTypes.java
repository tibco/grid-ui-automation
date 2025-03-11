package com.tibco.automation.test.gsui.services.services;

import java.awt.AWTException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import com.tibco.automation.common.utils.RandomStringGenerator;
import com.tibco.automation.common.utils.RandomStringGenerator.RandomizerTypes;
import com.tibco.automation.page.common.CommonFunctions;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.TemplatePage;
import com.tibco.automation.page.services.services.ServiceConditionsPage;
import com.tibco.automation.page.services.services.ServiceSessionAdminPage;
import com.tibco.automation.page.services.services.ServiceTestPage;
import com.tibco.automation.page.services.services.ServiceTypesPage;

public class ServiceTypes extends WebDriverTestCase{
	
	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public TemplatePage templatepage;
	public ServiceSessionAdminPage servicesession;
	public CommonFunctions commonFunctions;
	
	ServiceTypesPage servicetype;
	public String servicetypeName;
	public String serviceType;
	public String classname;
	public String description;
	public String renameservicetype;
	public String copyservicetype;
	@BeforeMethod
	public void beforeMethod()
	{
		servicetype=new ServiceTypesPage();
		commonFunctions=new CommonFunctions();
		servicetype.launchPage();
		servicetype.waitForPageToLoad();
		servicetypeName=RandomStringGenerator.get(5, RandomizerTypes.MIXED);
		serviceType="servicetype"+servicetypeName;
		classname="classname"+servicetypeName;
		description="description"+servicetypeName;
		renameservicetype="rename"+servicetypeName;
		copyservicetype="copy"+servicetypeName;
		
	}

	
 @Test(priority=1 ,description="Verify functionality of Edit Service Type action on Service Types page") 
	public void Grid_3822() throws AWTException
	{
	 servicetype.getCurrentWindowHandle();
	 servicetype.provideServiceName(servicetypeName);
	 servicetype.waitForPageToLoad();
	  servicetype.clickOnAdd();
	    servicetype.switchToNewlyOpenedWindow();
	    servicetype.provideClassName(classname);
	    servicetype.waitForPageToLoad();
		servicetype.clickOnSaveButton();
	  servicetype.switchToNewlyOpenedWindow();
	  servicetype.waitForPageToLoad();
	  servicetype.verifyServiceTypeRegistryAdded(servicetypeName);
	  servicetype.waitForPageToLoad();
	  
	  servicetype.clickOnServiceTypesCheckbox(servicetypeName);
	  servicetype.getCurrentWindowHandle();
	  commonFunctions.selectLocalAction("Edit Service Type");
	   servicetype.switchToNewlyOpenedWindow();
	   servicetype.waitForPageToLoad();
		servicetype.editDescription(description);
		servicetype.waitForPageToLoad();
		servicetype.clickOnSaveButton();
		 servicetype.switchToNewlyOpenedWindow();
		 servicetype.waitForPageToLoad();
		servicetype.verifyDescriptionIsPresent(servicetypeName,description);
		servicetype.switchToNewlyOpenedWindow();
		servicetype.waitForPageToLoad();
	}
	
@Test(priority=2 ,description="Verify functionality of Rename Service Type action on Service Types page") 
	public void Grid_3823() throws AWTException
	{
	  servicetype.provideServiceName(servicetypeName);
	  servicetype.waitForPageToLoad();
	  servicetype.clickOnAdd();
	  servicetype.switchToNewlyOpenedWindow();
	  servicetype.waitForPageToLoad();
	  servicetype.provideClassName(classname);
	  servicetype.waitForPageToLoad();
	  servicetype.clickOnSaveButton();
	  servicetype.switchToNewlyOpenedWindow();
	  servicetype.waitForPageToLoad();
	  servicetype.verifyServiceTypeRegistryAdded(servicetypeName);
	  servicetype.waitForPageToLoad();  
	  servicetype.clickOnServiceTypesCheckbox(servicetypeName);
	  
	  servicetype.getCurrentWindowHandle();
	  commonFunctions.selectLocalAction("Rename Service Type");
	  servicetype.renameServiceType(renameservicetype);
	  servicetype.waitForPageToLoad();
	  servicetype.renameSave();
	  
	  servicetype.waitForPageToLoad();
	  servicetype.verifyServiceTypeRegistryAdded(renameservicetype);
	}



@Test(priority=3 ,description="Verify the functionality of Cancel button of Rename Service Type popup") 
public void Grid_3846() throws AWTException
{
  servicetype.provideServiceName(servicetypeName);
  servicetype.waitForPageToLoad();
  servicetype.clickOnAdd();
  servicetype.switchToNewlyOpenedWindow();
  servicetype.waitForPageToLoad();
  servicetype.provideClassName(classname);
  servicetype.waitForPageToLoad();
  servicetype.clickOnSaveButton();
  servicetype.switchToNewlyOpenedWindow();
  servicetype.waitForPageToLoad();
  servicetype.verifyServiceTypeRegistryAdded(servicetypeName);
  servicetype.waitForPageToLoad();  
  servicetype.clickOnServiceTypesCheckbox(servicetypeName);
  servicetype.getCurrentWindowHandle();
  commonFunctions.selectLocalAction("Rename Service Type");
  servicetype.waitForPageToLoad();
  servicetype.renameServiceType(renameservicetype);
  servicetype.waitForPageToLoad();
  servicetype.renameCancel();
  servicetype.waitForPageToLoad();
  servicetype.verifyServiceTypeRegistryNotAdded(renameservicetype);
}

	@Test(priority=4 ,description="Verify functionality of Copy Service Type action on Service Types page") 
	public void Grid_3824() throws AWTException
	{
	  servicetype.provideServiceName(servicetypeName);
	  servicetype.waitForPageToLoad();
	  servicetype.clickOnAdd();
	  servicetype.switchToNewlyOpenedWindow();
	  servicetype.waitForPageToLoad();
	  servicetype.provideClassName(classname);
	  servicetype.waitForPageToLoad();
	  servicetype.clickOnSaveButton();
	  servicetype.switchToNewlyOpenedWindow();
	  servicetype.waitForPageToLoad();
	  servicetype.verifyServiceTypeRegistryAdded(servicetypeName);
	  servicetype.waitForPageToLoad();  
	  servicetype.clickOnServiceTypesCheckbox(servicetypeName);
	  servicetype.getCurrentWindowHandle();
	  commonFunctions.selectLocalAction("Copy Service Type");
	  servicetype.renameServiceType(copyservicetype);
	  servicetype.waitForPageToLoad();
	  servicetype.renameSave();
	  servicetype.waitForPageToLoad();
	  servicetype.verifyServiceTypeRegistryAdded(copyservicetype);
	}

@Test(priority=5 ,description="Verify the functionality of Cancel button of Copy Service Type popup") 
public void Grid_3848() throws AWTException
{
  servicetype.provideServiceName(servicetypeName);
  servicetype.waitForPageToLoad();
  servicetype.clickOnAdd();
  servicetype.switchToNewlyOpenedWindow();
  servicetype.waitForPageToLoad();
  servicetype.provideClassName(classname);
  servicetype.waitForPageToLoad();
  servicetype.clickOnSaveButton();
  servicetype.switchToNewlyOpenedWindow();
  servicetype.waitForPageToLoad();
  servicetype.verifyServiceTypeRegistryAdded(servicetypeName);
  servicetype.waitForPageToLoad();  
  servicetype.clickOnServiceTypesCheckbox(servicetypeName);
  servicetype.getCurrentWindowHandle();
  commonFunctions.selectLocalAction("Copy Service Type");
  servicetype.renameServiceType(copyservicetype); 
  servicetype.waitForPageToLoad();
  servicetype.renameCancel();
  servicetype.waitForPageToLoad();
  servicetype.verifyServiceTypeRegistryNotAdded(copyservicetype);
  }
 
@Test(priority=6 ,description="Verify functionality of Remove Service Type action on Service Types page") 
public void Grid_3825() throws AWTException
{
  servicetype.provideServiceName(servicetypeName);
  servicetype.waitForPageToLoad();
  servicetype.clickOnAdd();
  servicetype.switchToNewlyOpenedWindow();
  servicetype.waitForPageToLoad();
  servicetype.provideClassName(classname);
  servicetype.waitForPageToLoad();
  servicetype.clickOnSaveButton();
  servicetype.switchToNewlyOpenedWindow();
  servicetype.waitForPageToLoad();
  servicetype.verifyServiceTypeRegistryAdded(servicetypeName);
  servicetype.waitForPageToLoad();  
  servicetype.clickOnServiceTypesCheckbox(servicetypeName);
  servicetype.getCurrentWindowHandle();
  commonFunctions.selectLocalAction("Remove Service Type");
  commonFunctions.acceptAlert();
  servicetype.waitForPageToLoad();
  servicetype.verifyServiceTypeRegistryNotAdded(servicetypeName);
  }

@Test(priority=7 ,description="Verify the functionality of Cancel button of Remove Service Type popup") 
public void Grid_3850() throws AWTException
{
 servicetype.provideServiceName(servicetypeName);
 servicetype.waitForPageToLoad();
 servicetype.clickOnAdd();
 servicetype.switchToNewlyOpenedWindow();
 servicetype.waitForPageToLoad();
 servicetype.provideClassName(classname);
 servicetype.waitForPageToLoad();
 servicetype.clickOnSaveButton();
 servicetype.switchToNewlyOpenedWindow();
 servicetype.waitForPageToLoad();
 servicetype.verifyServiceTypeRegistryAdded(servicetypeName);
 servicetype.waitForPageToLoad();  
 servicetype.clickOnServiceTypesCheckbox(servicetypeName);
 servicetype.getCurrentWindowHandle();
 commonFunctions.selectLocalAction("Remove Service Type");
 commonFunctions.dismissAlert();
 servicetype.waitForPageToLoad();
 servicetype.verifyServiceTypeRegistryAdded(servicetypeName);
 }


	@Test(priority=8 ,description="Verify functionality of Add button on Service Types page") 
public void Grid_3826() throws AWTException
{
  servicetype.provideServiceName(servicetypeName);
  servicetype.waitForPageToLoad();
  servicetype.clickOnAdd();
    servicetype.switchToNewlyOpenedWindow();
    servicetype.provideClassName(classname);
	servicetype.clickOnSaveButton();
	servicetype.switchToNewlyOpenedWindow();
	servicetype.waitForPageToLoad();
	
	servicetype.verifyServiceTypeRegistryAdded(servicetypeName);
	
}

@Test(priority=9,description="Verify the functionality of Expand All button of Add service type popup") 
public void Grid_3836() 
{    
servicetype.provideServiceName(servicetypeName);
servicetype.waitForPageToLoad();
servicetype.clickOnAdd();  
 servicetype.switchToNewlyOpenedWindow();
servicetype.verifyExpandAllonAdd();
servicetype.waitForPageToLoad();
servicetype.clickOnCancel();
servicetype.switchToNewlyOpenedWindow();
servicetype.waitForPageToLoad();


}

@Test(priority=10 ,description="Verify the functionality of Collapse All button of Add Service Type popup.") 
public void Grid_3837() throws InterruptedException 
{


servicetype.provideServiceName(servicetypeName);
servicetype.waitForPageToLoad();
  servicetype.clickOnAdd();
servicetype.switchToNewlyOpenedWindow();
servicetype.verifyCollapseAllAdd();
servicetype.waitForPageToLoad();
servicetype.clickOnCancel();
servicetype.switchToNewlyOpenedWindow();
servicetype.waitForPageToLoad();

}



@Test(priority=11 ,description="Verify the functionality of Expand All button of Edit Service Type popup.") 
public void Grid_3842() 
{
servicetype.provideServiceName(servicetypeName);
servicetype.waitForPageToLoad();
servicetype.clickOnAdd();
servicetype.switchToNewlyOpenedWindow();
servicetype.waitForPageToLoad();
servicetype.provideClassName(classname);
servicetype.waitForPageToLoad();
servicetype.clickOnSaveButton();
servicetype.switchToNewlyOpenedWindow();
servicetype.waitForPageToLoad();
servicetype.verifyServiceTypeRegistryAdded(servicetypeName);
servicetype.waitForPageToLoad();

servicetype.clickOnServiceTypesCheckbox(servicetypeName);
servicetype.getCurrentWindowHandle();
commonFunctions.selectLocalAction("Edit Service Type");
servicetype.switchToNewlyOpenedWindow();
servicetype.verifyExpandAllonAdd();
servicetype.waitForPageToLoad();
servicetype.clickOnCancel();
servicetype.switchToNewlyOpenedWindow();
servicetype.waitForPageToLoad();

}

@Test(priority=12 ,description="Verify the functionality of Collapse All button of Edit Service Type popup.") 
public void Grid_3843() throws InterruptedException 
{
servicetype.provideServiceName(servicetypeName);
servicetype.waitForPageToLoad();
servicetype.clickOnAdd();
servicetype.switchToNewlyOpenedWindow();
servicetype.waitForPageToLoad();
servicetype.provideClassName(classname);
servicetype.waitForPageToLoad();
servicetype.clickOnSaveButton();
servicetype.switchToNewlyOpenedWindow();
servicetype.waitForPageToLoad();
servicetype.verifyServiceTypeRegistryAdded(servicetypeName);
servicetype.waitForPageToLoad();

servicetype.clickOnServiceTypesCheckbox(servicetypeName);
servicetype.getCurrentWindowHandle();
commonFunctions.selectLocalAction("Edit Service Type");
servicetype.switchToNewlyOpenedWindow();
servicetype.verifyCollapseAllAdd();
servicetype.waitForPageToLoad();
servicetype.clickOnCancel();

servicetype.switchToNewlyOpenedWindow();
servicetype.waitForPageToLoad();
}




@Test(priority=13 ,description="Verify local action is enabled as soon as user checks a service type checkbox") 
public void Grid_3829() throws AWTException
{
servicetype.provideServiceName(servicetypeName);
servicetype.waitForPageToLoad();
servicetype.clickOnAdd();
servicetype.switchToNewlyOpenedWindow();
servicetype.waitForPageToLoad();
servicetype.provideClassName(classname);
servicetype.waitForPageToLoad();
servicetype.clickOnSaveButton();
servicetype.switchToNewlyOpenedWindow();
servicetype.waitForPageToLoad();
servicetype.verifyServiceTypeRegistryAdded(servicetypeName);
servicetype.waitForPageToLoad();

servicetype.clickOnServiceTypesCheckbox(servicetypeName);
servicetype.clickOnLocalAction();

}

@Test(priority=14,description="Verify deselecting Service Type disables local action.") 
public void Grid_3851() throws AWTException
{
servicetype.provideServiceName(servicetypeName);
servicetype.waitForPageToLoad();
  servicetype.clickOnAdd();
  servicetype.switchToNewlyOpenedWindow();
  servicetype.provideClassName(classname);
  servicetype.clickOnSaveButton();
  servicetype.switchToNewlyOpenedWindow();
  servicetype.waitForPageToLoad();
  servicetype.verifyServiceTypeRegistryAdded(servicetypeName);
  servicetype.waitForPageToLoad();
  servicetype.clickOnServiceTypesCheckbox(servicetypeName);
  servicetype.clickOnServiceTypesCheckbox(servicetypeName);
servicetype.verifyLocalActionDisable();

}




@Test(priority=15 ,description="Verify tooltip is provided for Description on edit service type popup") 
public void Grid_3844() 
{
servicetype.provideServiceName(servicetypeName);
servicetype.waitForPageToLoad();
  servicetype.clickOnAdd();
  servicetype.switchToNewlyOpenedWindow();
  servicetype.provideClassName(classname);
  servicetype.clickOnSaveButton();
  servicetype.switchToNewlyOpenedWindow();
  servicetype.waitForPageToLoad();
  servicetype.verifyServiceTypeRegistryAdded(servicetypeName);
  servicetype.waitForPageToLoad();
  
  servicetype.clickOnServiceTypesCheckbox(servicetypeName);
  servicetype.getCurrentWindowHandle();
servicetype.clickOnLocalAction();
commonFunctions.selectLocalAction("Edit Service Type");
servicetype.switchToNewlyOpenedWindow();
servicetype.verifyTooltip();
  servicetype.closeWindow();
  servicetype.switchToParentWindow();
}

@Test(priority=16 ,description="Verify after clicking on side menu bar arrow side menu bar will show/hide.") 
public void Grid_3833() 
{
 
	servicetype.verifySidebar();
	
   }

}


	



