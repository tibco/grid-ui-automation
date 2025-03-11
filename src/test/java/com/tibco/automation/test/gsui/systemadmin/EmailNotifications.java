package com.tibco.automation.test.gsui.systemadmin;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.WebDriverTestCase;
import com.tibco.automation.common.utils.RandomStringGenerator;
import com.tibco.automation.common.utils.RandomStringGenerator.RandomizerTypes;
import com.tibco.automation.page.admin.systemadmin.EmailNotificationsPage;
import com.tibco.automation.page.common.CommonFunctions;
import com.tibco.automation.page.common.DataGrid;
import com.tibco.automation.page.common.TemplatePage;

public class EmailNotifications extends WebDriverTestCase{
	public ExtendedWebDriver driver;
	public DataGrid datagrid;
	public TemplatePage templatepage;
	public EmailNotificationsPage emailNotification;
	public String email;
	public String filter;
	public CommonFunctions commonFunctions;
	
	@BeforeMethod
	public void beforeMethod()
	{
		email="email"+RandomStringGenerator.get(4, RandomizerTypes.MIXED);
		filter="filter"+RandomStringGenerator.get(4, RandomizerTypes.MIXED);
		commonFunctions=new CommonFunctions();
		emailNotification=new EmailNotificationsPage();
		emailNotification.launchPage();
		emailNotification.waitForPageToLoad();
	}
	
	@Test(description="Verify the functionality of add columns option")
	public void Grid_4441()
	{
		emailNotification.clickAddColumn();
		emailNotification.removeColumn("E-Mail Address");
		emailNotification.clickSaveOnAddColumn();
		emailNotification.waitForPageToLoad();
		emailNotification.verifyColumnNotPresent("E-Mail Address");
		emailNotification.clickAddColumn();
		emailNotification.addNewColumn("E-Mail Address");
		emailNotification.clickSaveOnAddColumn();
		emailNotification.waitForPageToLoad();
		emailNotification.verifyColumnPresent("E-Mail Address");
	}

	
	@Test(description="Verify the functionality of revert button add columns popup")
	public void Grid_4443()
	{
		emailNotification.clickAddColumn();
		emailNotification.removeColumn("E-Mail Address");
		emailNotification.clickSaveOnAddColumn();
		emailNotification.waitForPageToLoad();
		emailNotification.verifyColumnNotPresent("E-Mail Address");
		emailNotification.clickAddColumn();
		emailNotification.clickRevertOnAddColumn();
		emailNotification.clickSaveOnAddColumn();
		emailNotification.waitForPageToLoad();
		emailNotification.verifyColumnPresent("E-Mail Address");
		emailNotification.verifyColumnPresent("Filter");
		emailNotification.verifyColumnPresent("Subscriptions");
	}
	
	
	@Test(description="Verify functionality of global action Create New Subscriber")
	public void Grid_4444()
	{
		emailNotification.getCurrentWindowHandle();
		commonFunctions.selectGlobalAction("Create New Subscriber");
		emailNotification.switchToNewlyOpenedWindow();
		commonFunctions.maximizeCurrentWindow();
		emailNotification.fillSubscriberDetails(email, filter);
		emailNotification.submitSubscriberDetails();
		emailNotification.switchToParentWindow();
		emailNotification.waitForPageToLoad();
		emailNotification.verifySubscriberPresent(email);
	}
	
	
	@Test(description="verify the functionality of Cancel button of Create New Subscriber popup")
	public void Grid_4446()
	{
		emailNotification.getCurrentWindowHandle();
		commonFunctions.selectGlobalAction("Create New Subscriber");
		emailNotification.switchToNewlyOpenedWindow();
		commonFunctions.maximizeCurrentWindow();
		emailNotification.fillSubscriberDetails(email, filter);
		emailNotification.clickCancelOnAddSubscriber();
		emailNotification.switchToParentWindow();
		emailNotification.waitForPageToLoad();
		emailNotification.verifySubscriberNotPresent(email);
	}
	
	@Test(description="Verify selecting a Subscriber enables the local action")
	public void Grid_4448()
	{
		emailNotification.getCurrentWindowHandle();
		commonFunctions.selectGlobalAction("Create New Subscriber");
		emailNotification.switchToNewlyOpenedWindow();
		commonFunctions.maximizeCurrentWindow();
		emailNotification.fillSubscriberDetails(email, filter);
		emailNotification.submitSubscriberDetails();
		emailNotification.switchToParentWindow();
		emailNotification.waitForPageToLoad();
		emailNotification.verifySubscriberPresent(email);
		emailNotification.selectSubscriber(email);
		emailNotification.selectSubscriber(email);
		emailNotification.selectSubscriber(email);
		commonFunctions.verifyLocalActionLinkIsPresent();
	}
	
	
	@Test(description="Verify deselecting a selected subscriber disables local action and enables global action.")
	public void Grid_4449()
	{
		emailNotification.getCurrentWindowHandle();
		commonFunctions.selectGlobalAction("Create New Subscriber");
		emailNotification.switchToNewlyOpenedWindow();
		emailNotification.fillSubscriberDetails(email, filter);
		emailNotification.submitSubscriberDetails();
		emailNotification.switchToParentWindow();
		commonFunctions.maximizeCurrentWindow();
		emailNotification.waitForPageToLoad();
		emailNotification.verifySubscriberPresent(email);
		emailNotification.selectSubscriber(email);
		commonFunctions.verifyLocalActionLinkIsPresent();
		emailNotification.selectSubscriber(email);
		commonFunctions.verifyGlobalActionLinkIsPresent();
	}
	
	
	@Test(description="Verify functionality of Edit Subscription local action")
	public void Grid_4450()
	{
		emailNotification.getCurrentWindowHandle();
		commonFunctions.selectGlobalAction("Create New Subscriber");
		emailNotification.switchToNewlyOpenedWindow();
		commonFunctions.maximizeCurrentWindow();
		emailNotification.fillSubscriberDetails(email, filter);
		emailNotification.submitSubscriberDetails();
		emailNotification.switchToParentWindow();
		emailNotification.waitForPageToLoad();
		emailNotification.verifySubscriberPresent(email);
		emailNotification.selectSubscriber(email);
		emailNotification.selectSubscriber(email);
		emailNotification.selectSubscriber(email);
		commonFunctions.selectLocalAction("Edit Subscription");
		emailNotification.switchToNewlyOpenedWindow();
		commonFunctions.maximizeCurrentWindow();
		emailNotification.updateSubscriberDetails(email);
		emailNotification.submitSubscriberDetails();
		emailNotification.switchToParentWindow();
		emailNotification.waitForPageToLoad();
		emailNotification.verifyUpdatedSubscriberDetails(email);
	}
	
	@Test(description="verify the functionality of Cancel button of Edit Subscription popup")
	public void Grid_4452()
	{
		emailNotification.getCurrentWindowHandle();
		commonFunctions.selectGlobalAction("Create New Subscriber");
		emailNotification.switchToNewlyOpenedWindow();
		commonFunctions.maximizeCurrentWindow();
		emailNotification.fillSubscriberDetails(email, filter);
		emailNotification.submitSubscriberDetails();
		emailNotification.switchToParentWindow();
		emailNotification.waitForPageToLoad();
		emailNotification.verifySubscriberPresent(email);
		emailNotification.selectSubscriber(email);
		emailNotification.selectSubscriber(email);
		emailNotification.selectSubscriber(email);
		commonFunctions.selectLocalAction("Edit Subscription");
		emailNotification.switchToNewlyOpenedWindow();
		commonFunctions.maximizeCurrentWindow();
		emailNotification.updateSubscriberDetails(email);
		emailNotification.clickCancelOnAddSubscriber();
		emailNotification.switchToParentWindow();
		emailNotification.waitForPageToLoad();
		emailNotification.verifySubscriberDetailsNotUpdated(email);
	}
	
	
	@Test(description="Verify functionality of Remove Subscription local action")
	public void Grid_4454()
	{
		emailNotification.getCurrentWindowHandle();
		commonFunctions.selectGlobalAction("Create New Subscriber");
		emailNotification.switchToNewlyOpenedWindow();
		commonFunctions.maximizeCurrentWindow();
		emailNotification.fillSubscriberDetails(email, filter);
		emailNotification.submitSubscriberDetails();
		emailNotification.switchToParentWindow();
		emailNotification.waitForPageToLoad();
		emailNotification.verifySubscriberPresent(email);
		emailNotification.selectSubscriber(email);
		emailNotification.selectSubscriber(email);
		emailNotification.selectSubscriber(email);
		commonFunctions.selectLocalAction("Remove Subscription");
		commonFunctions.acceptAlert();
		emailNotification.waitForPageToLoad();
		emailNotification.verifySubscriberNotPresent(email);
	}
	
	
	@Test(description="Verify the functionality of Cancel button button of Remove Subscription popup")
	public void Grid_4456()
	{
		emailNotification.getCurrentWindowHandle();
		commonFunctions.selectGlobalAction("Create New Subscriber");
		emailNotification.switchToNewlyOpenedWindow();
		commonFunctions.maximizeCurrentWindow();
		emailNotification.fillSubscriberDetails(email, filter);
		emailNotification.submitSubscriberDetails();
		emailNotification.switchToParentWindow();
		emailNotification.waitForPageToLoad();
		emailNotification.verifySubscriberPresent(email);
		emailNotification.selectSubscriber(email);
		emailNotification.selectSubscriber(email);
		emailNotification.selectSubscriber(email);
		commonFunctions.selectLocalAction("Remove Subscription");
		commonFunctions.dismissAlert();
		emailNotification.waitForPageToLoad();
		emailNotification.verifySubscriberPresent(email);
	}
	
	
	@Test(description="Verify simple search by using Email Address")
	public void Grid_4459()
	{
		emailNotification.getCurrentWindowHandle();
		commonFunctions.selectGlobalAction("Create New Subscriber");
		emailNotification.switchToNewlyOpenedWindow();
		commonFunctions.maximizeCurrentWindow();
		emailNotification.fillSubscriberDetails(email, filter);
		emailNotification.submitSubscriberDetails();
		emailNotification.switchToParentWindow();
		emailNotification.waitForPageToLoad();
		emailNotification.verifySubscriberPresent(email);
		commonFunctions.performSimpleSearch("E-Mail Address",email);
		emailNotification.waitForPageToLoad();
		emailNotification.verifySimpleSearchResult(email,"1");
		commonFunctions.clearSearchResults();
	}
	
	@Test(description="Verify query search using Subscription")
	public void Grid_4460()
	{
		emailNotification.getCurrentWindowHandle();
		commonFunctions.selectGlobalAction("Create New Subscriber");
		emailNotification.switchToNewlyOpenedWindow();
		commonFunctions.maximizeCurrentWindow();
		emailNotification.fillSubscriberDetails(email, filter);
		emailNotification.submitSubscriberDetails();
		emailNotification.switchToParentWindow();
		emailNotification.waitForPageToLoad();
		emailNotification.verifySubscriberPresent(email);
		commonFunctions.performQuerySearch("\"Subscriptions\" matches \"Engine Died\"");
		emailNotification.waitForPageToLoad();
		emailNotification.verifyQuerySearchResult("0");
		commonFunctions.clearSearchResults();
	}
	
	
	@Test(description="Verify query builder search using Filter")
	public void Grid_4461()
	{
		emailNotification.getCurrentWindowHandle();
		commonFunctions.selectGlobalAction("Create New Subscriber");
		emailNotification.switchToNewlyOpenedWindow();
		commonFunctions.maximizeCurrentWindow();
		emailNotification.fillSubscriberDetails(email, filter);
		emailNotification.submitSubscriberDetails();
		emailNotification.switchToParentWindow();
		emailNotification.waitForPageToLoad();
		emailNotification.verifySubscriberPresent(email);
		commonFunctions.performQueryBuilderSearch("Filter", "matches", filter);
		commonFunctions.clickSearchOnQueryBuilder();
		emailNotification.verifyQueryBuilderSearchResult("1");
	}
	
	
	@Test(description="Verify the functionality Close button of Query Builder popup")
	public void Grid_4462()
	{
		emailNotification.getCurrentWindowHandle();
		commonFunctions.selectGlobalAction("Create New Subscriber");
		emailNotification.switchToNewlyOpenedWindow();
		commonFunctions.maximizeCurrentWindow();
		emailNotification.fillSubscriberDetails(email, filter);
		emailNotification.submitSubscriberDetails();
		emailNotification.switchToParentWindow();
		emailNotification.waitForPageToLoad();
		emailNotification.verifySubscriberPresent(email);
		emailNotification.showingResults();
		commonFunctions.performQueryBuilderSearch("Filter", "matches", filter);
		commonFunctions.clickCloseOnQueryBuilder();
		emailNotification.waitForPageToLoad();
		emailNotification.showingResults();
	}
	
	
	@Test(description="Verify change in results per page value changes the number of rows in table")
	public void Grid_4466()
	{
		emailNotification.getCurrentWindowHandle();
		commonFunctions.selectGlobalAction("Create New Subscriber");
		emailNotification.switchToNewlyOpenedWindow();
		commonFunctions.maximizeCurrentWindow();
		emailNotification.fillSubscriberDetails(email, filter);
		emailNotification.submitSubscriberDetails();
		emailNotification.switchToParentWindow();
		emailNotification.waitForPageToLoad();
		emailNotification.verifySubscriberPresent(email);
		commonFunctions.updateAndVerifyResultsPerPage(1);
	}
	
	@Test(description="Verify functionality of next page button in pagination.")
	public void Grid_4467()
	{
		commonFunctions.updateAndVerifyResultsPerPage(1);
		emailNotification.waitForPageToLoad();
		commonFunctions.goToNextPage();
	}
	
	
	@Test(description=":Verify functionality of previous page button in pagination")
	public void Grid_4468()
	{
		commonFunctions.updateAndVerifyResultsPerPage(1);
		emailNotification.waitForPageToLoad();
		commonFunctions.goToNextPage();
		emailNotification.waitForPageToLoad();
		commonFunctions.goToPreviousPage();
	}
	
	@Test(description="Verify functionality of move to first page button.")
	public void Grid_4469()
	{
		commonFunctions.updateAndVerifyResultsPerPage(1);
		emailNotification.waitForPageToLoad();
		commonFunctions.goToNextPage();
		emailNotification.waitForPageToLoad();
		commonFunctions.goToNextPage();
		emailNotification.waitForPageToLoad();
		commonFunctions.goToFirstPage();
	}
	
	@Test(description="Verify functionality of move to last page button.")
	public void Grid_4470()
	{
		commonFunctions.updateAndVerifyResultsPerPage(1);
		emailNotification.waitForPageToLoad();
		commonFunctions.goToPreviousPage();
		emailNotification.waitForPageToLoad();
		commonFunctions.goToLastPage();
	}
}
