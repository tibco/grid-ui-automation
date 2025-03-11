package com.tibco.automation.test.gsui.diagnostics;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tibco.automation.page.diagnostics.ManagerDiagnostics_Page;


public class ManagerDiagnostics {
	
	
	public ManagerDiagnostics_Page managerdiagnostics;
@BeforeMethod
public void beforeMethod()
{
	managerdiagnostics = new ManagerDiagnostics_Page();
	managerdiagnostics.clickTopMenuItem("Diagnostics");
	managerdiagnostics.waitForPageToLoad();
	managerdiagnostics.clickManagerDiagnosticsLink();
	managerdiagnostics.waitForPageToLoad();
}


@Test(priority=1 ,description="Verify the functionality of Display button")
public void Grid_4635() throws InterruptedException 
	  {
	
		managerdiagnostics.verifyDisplayButton();
		
		managerdiagnostics.switchToMainWindow();
}


@Test(priority=2 ,description="Verify the functionality of Manager Logs checkbox")
public void Grid_4636() throws InterruptedException 
	  {
	
		managerdiagnostics.verifyManagerLogsCheckbox();
}

@Test(priority=3 ,description="Verify the functionality of Environment checkbox")
public void Grid_4637() throws InterruptedException 
	  {

	
		managerdiagnostics.verifyEnvLogsCheckbox();
}
@Test(priority=4 ,description="Verify the functionality of Task Queues checkbox")
public void Grid_4638() throws InterruptedException 
	  {
	
		managerdiagnostics.verifyTaskQueuesCheckbox();

}
@Test(priority=5 ,description="Verify the functionality of within last radio button")
public void Grid_4639() throws InterruptedException 
	  {
	
		managerdiagnostics.verifywithinlastButton();

}



@Test(priority=6 ,description="Verify the functionality of Display button after changing the logs to within last minutes")
public void Grid_4640() throws InterruptedException 
	  {
	
		managerdiagnostics.verifyManagerLogsWithinLastMin();
		managerdiagnostics.switchToMainWindow();

 }




@Test(priority=7 ,description="Verify the functionality of Display button after selecting Environment checkbox")
public void Grid_4646() throws InterruptedException 
	  {
	

		managerdiagnostics.verifyDisplayEnvButton();
		managerdiagnostics.switchToMainWindow();

		
 }

@Test(priority=8 ,description="Verify the functionality of Display button after selecting Task Queues checkbox only")
public void Grid_4648() throws InterruptedException 
	  {
	
	
		managerdiagnostics.verifyDisplayTaskQueuesButton();
		managerdiagnostics.switchToMainWindow();

		
	  }
@Test(priority=9 ,description="Verify the functionality of Display button after changing the value for the Max Log Lines to Display")
public void Grid_4645() throws InterruptedException 
	  {
	
	
		managerdiagnostics.verifyMaxLine();
		managerdiagnostics.switchToMainWindow();

		
 }
/*@Test(priority=10 ,description="Verify the functionality of Display button after changing the logs to within last hours")
public void Grid_4641() throws InterruptedException 
	  {
	

		managerdiagnostics.verifyManagerLogsWithinLastHr();

 }


@Test(priority=11 ,description="Verify the functionality of Download button after changing the logs within last years")
public void Grid_4643() throws InterruptedException 
	  {
	
		managerdiagnostics.verifyManagerLogsWithinLastYears();

 }
 */
/*@Test(priority=12 ,description="Verify the functionality of Download button")
public void Grid_4634() throws InterruptedException 
	  {
	
	managerdiagnostics.verifyDownloadButton();
	  } 


*@Test(priority=13 ,description="Verify the functionality of Download button after selecting Environment checkbox.")
public void Grid_4647() throws InterruptedException 
	  {
	
		managerdiagnostics.verifyDownloadEnvButton();
		
 }
@Test(priority=14 ,description="Verify the functionality of Download button after selecting Task Queues checkbox only")
public void Grid_4649() throws InterruptedException 
	  {
	
		managerdiagnostics.verifyDownloadTaskQueuesButton();
		
 }

*/


}