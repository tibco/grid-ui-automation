package com.tibco.automation.page.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.support.ui.Select;

import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriverException;
import com.tibco.automation.common.framework.webdriver.ExtendedWebElement;
import com.tibco.automation.common.utils.LocatorUtil;
import com.tibco.automation.common.utils.PropertiesUtil;
import com.tibco.automation.common.utils.WaitUtility;
import com.tibco.automation.page.common.Locators.ButtonsOnModal;
import com.tibco.automation.page.common.Locators.ModalHeader;
import com.tibco.automation.page.common.Locators.TemplatePageLocators;

public class TemplatePage extends LoginPage implements TemplatePageLocators {

    public WaitUtility waitUtility;
    public ExtendedWebDriver driver;
    ExtendedWebElement userProfileLink;
    private final static Logger logger = Logger.getLogger(TemplatePage.class);
    public String pageTitle;
    public GSMenu menuItem;

    public TemplatePage(String pageTitle, GSMenu menuItem) {
        System.out.print("TemplatePage..!!!....!!!");
        driver = getDriver();
        waitUtility = new WaitUtility();
        System.out.print("userProfileLink..**....***");
        userProfileLink = new ExtendedWebElement(LocatorUtil.getBy(String.format(USER_PROFILE_LINK_LOC,
                PropertiesUtil.getBundle().getPropertyValue("application.username"))));
        System.out.print("userProfileLink..!!!....!!!");
        this.pageTitle = pageTitle;
        this.menuItem = menuItem;
    }

    public TemplatePage() {
        // super();
        driver = getDriver();
        waitUtility = new WaitUtility();

    }

    @Override
    public boolean isPageActive(Object... object) {
        boolean flag = verifyPageTitle(this.pageTitle);
        return flag;
    }

    @Override
    protected void initParent() {
        parent = new LoginPage();
    }

    @Override
    public void openPage(Object... object) {
        // System.out.println("openpage in TemplatePage");
        openMenu(menuItem);
    }

    @Override
    public void launchPage(Object... object) {
        super.launchPage(object);
    }

    public enum GSMenu {
        Dashboard("Dashboard"),DashboardMenu(Dashboard,"Dashboard"),Overview(Dashboard,"Overview",1), Diagnostics("Diagnostics"),StackMenu("Stacks and Components"), Stacks(StackMenu, "Stacks", 2), Components(
                StackMenu, "Components", 2), Schedules(StackMenu, "Schedules", 2), Constraints(StackMenu, "Constraints",
                        2), ArchiveScaling(StackMenu, "Archive Scaling", 2), EnginesMenu("Engine Hosts"), Daemons(
                                EnginesMenu, "Daemons", 3), Engines(EnginesMenu, "Engines", 3), Properties(EnginesMenu,
                                        "Properties", 3), CloudVMs(EnginesMenu, "Cloud VMs", 3), Admin("Admin"),GridComponents("Grid Components"),Services("Services"),WebServices(
                                             GridComponents, "driver", "Web Services",
                                               1),GridLibraries(
                                                    Services, "services", "Grid Libraries",
                                                        2),CacheRegions(Services,"services","Cache Regions",9),CacheSchemas(Services,"services","Cache Schemas",8),
                                                        ServiceTest(Services,"services","Service Test",9),ServiceConditions(
                                                            Services, "services", "Service Conditions",3),ServiceSessionAdmin(
                                                                    Services, "services", "Service Session Admin",4),ServiceTypes(
                                                                            Services, "services", "Service Types",5),Report(
                                                                                    Services, "services", "Reports",10),BatchDefinitions(Services,"batch","Batch Definitions",1),ServiceRunner(Services,"batch","Service Runners",2),BatchSchedule(Services,"batch","Batch Schedule",3),BatchAdmin(Services,"batch","Batch Admin",4),DriverAdmin(
                                                                    GridComponents, "driver", "Driver Admin",
                                                                    3),BrokerConfiguration(GridComponents,"broker","Broker Configuration",1),BrokerRouting(GridComponents,"broker","Broker Routing",2),BrokerAdmin(GridComponents,"broker","Broker Admin",3),
                                                                        EngineConfiguration(GridComponents,"engine","Engine Configurations",1),DaemonAdmin(GridComponents,"engine","Daemon Admin",4),EngineProperties(GridComponents,"engine","Engine Properties",2),EngineAdmin(GridComponents,"engine","Engine Admin",3),
                                                                        Users(
                                                                                Admin, "useradmingroup", "useradmingroup","User Admin", 5), RunAs(

Admin, "useradmingroup","Run-As Credentials", 5),ManagerConfiguration(

                                                                                Admin, "sysadmingroup","Manager Configuration", 1), ManagerImportExport(
                                                                        Admin, "sysadmingroup","Manager Import/Export", 2),ManagerHooks(Admin, "sysadmingroup", "Manager Hooks", 3), Roles(Admin

                                                                                , "useradmingroup","Role Admin", 2),EmailNotification(
                                                                        Admin, "sysadmingroup","Email Notifications", 4),SNMPEventTraps(
                                                                                Admin, "sysadmingroup"," SNMP Event Traps", 5),LicenseInformation(
                                                                                        Admin, "sysadmingroup"," License Information", 6),ManagerReinstall(
                                                                                                Admin, "sysadmingroup"," Manager Reinstall", 7),Accounts(Admin, "User Admin", "Accounts", 4),
                                                    Sessions(Admin, "User Admin", "Sessions", 4), Departments(
                                                                Admin, "User Admin", "Departments", 4), Locations(Admin,
                                                                        "User Admin", "Locations", 4), Subscriptions(
                                                                                Admin, "User Admin", "Subscriptions",
                                                                                4), Authentication(Admin, "useradmingroup",
                                                                                        "Authentication",
                                                                                        4), Hooks(Admin, "System Admin",
                                                                                                "Hooks",
                                                                                                4), BrokerConfiguration_General(
                                                                                                        Admin,
                                                                                                        "System Admin",
                                                                                                        "Broker Configuration",
                                                                                                        "General",
                                                                                                        4), BrokerConfiguration_EngineClients(
                                                                                                                Admin,
                                                                                                                "System Admin",
                                                                                                                "Broker Configuration",
                                                                                                                "Engine and Clients",
                                                                                                                4), BrokerConfiguration_Admin(
                                                                                                                        Admin,
                                                                                                                        "System Admin",
                                                                                                                        "Broker Configuration",
                                                                                                                        "Admin",
                                                                                                                        4), BrokerConfiguration_Database(
                                                                                                                                Admin,
                                                                                                                                "System Admin",
                                                                                                                                "Broker Configuration",
                                                                                                                                "Database",
                                                                                                                                4), BrokerConfiguration_ResourceDeployment(
                                                                                                                                        Admin,
                                                                                                                                        "System Admin",
                                                                                                                                        "Broker Configuration",
                                                                                                                                        "Resource Deployment",
                                                                                                                                        4), BrokerConfiguration_Security(
                                                                                                                                                Admin,
                                                                                                                                                "System Admin",
                                                                                                                                                "Broker Configuration",
                                                                                                                                                "Security",
                                                                                                                                                4), BrokerConfiguration_Communication(
                                                                                                                                                        Admin,
                                                                                                                                                        "System Admin",
                                                                                                                                                        "Broker Configuration",
                                                                                                                                                        "Communication",
                                                                                                                                                        4), BrokerConfiguration_Logging(
                                                                                                                                                                Admin,
                                                                                                                                                                "System Admin",
                                                                                                                                                                "Broker Configuration",
                                                                                                                                                                "Logging",
                                                                                                                                                                4), EngineConfigurations(
                                                                                                                                                                        Admin,
                                                                                                                                                                        "System Admin",
                                                                                                                                                                        "Engine Configurations",
                                                                                                                                                                        4), AdminReconfiguration(
                                                                                                                                                                                Admin,
                                                                                                                                                                                "System Admin",
                                                                                                                                                                                "Admin Reconfiguration",
                                                                                                                                                                                4), SNMPConfiguration(
                                                                                                                                                                                        Admin,
                                                                                                                                                                                        "System Admin",
"SNMP Configuration",
                                                                                                                                                                                        4), Credentials(
                                                                                                                                                                                                Admin,
                                                                                                                                                                                                "System Admin",
                                                                                                                                                                                                "Credentials",
                                                                                                                                                                                                4), CloudConfigurations(
                                                                                                                                                                                                        Admin,
                                                                                                                                                                                                        "System Admin",
                                                                                                                                                                                                        "Cloud Configurations",
                                                                                                                                                                                                        4), VirtualRouter(
                                                                                                                                                                                                                Admin,
                                                                                                                                                                                                                "System Admin",
                                                                                                                                                                                                                "VirtualRouter",
                                                                                                                                                                                                                4), GridLibraryLocations(
                                                                                                                                                                                                                        Admin,
                                                                                                                                                                                                                        "System Admin",
                                                                                                                                                                                                                        "Grid Library Locations",
                                                                                                                                                                                                                        4), Assets(
                                                                                                                                                                                                                                Admin,
                                                                                                                                                                                                                                "System Admin",
                                                                                                                                                                                                                                "Assets",
                                                                                                                                                                                                                                4), Variables(
                                                                                                                                                                                                                                        Admin,
                                                                                                                                                                                                                                        "System Admin",
                                                                                                                                                                                                                                        "Variables",
                                                                                                                                                                                                                                        4), ExternalStats(
                                                                                                                                                                                                                                                Admin,
                                                                                                                                                                                                                                                "System Admin",
                                                                                                                                                                                                                                                "External Stats",
                                                                                                                                                                                                                                                4), Export(
                                                                                                                                                                                                                                                        Admin,
                                                                                                                                                                                                                                                        "System Admin",
                                                                                                                                                                                                                                                        "Export",
                                                                                                                                                                                                                                                        4), Import(
                                                                                                                                                                                                                                                                Admin,
                                                                                                                                                                                                                                                                "System Admin",
                                                                                                                                                                                                                                                                "Import",
                                                                                                                                                                                                                                                                4), Catalog(
                                                                                                                                                                                                                                                                        "Catalog"), Enablers(
                                                                                                                                                                                                                                                                                Catalog,
                                                                                                                                                                                                                                                                                "Enablers",
                                                                                                                                                                                                                                                                                5), Distributions(
                                                                                                                                                                                                                                                                                        Catalog,
                                                                                                                                                                                                                                                                                        "Distributions",
                                                                                                                                                                                                                                                                                        5), ComponentTypes(
                                                                                                                                                                                                                                                                                                Catalog,
                                                                                                                                                                                                                                                                                                "Component Types",
                                                                                                                                                                                                                                                                                                5), Reports(
                                                                                                                                                                                                                                                                                                        "Reports"), BrokersReport(
                                                                                                                                                                                                                                                                                                                Reports,
                                                                                                                                                                                                                                                                                                                "Brokers",
                                                                                                                                                                                                                                                                                                                6), DaemonsReport(
                                                                                                                                                                                                                                                                                                                        Reports,
"Daemons",
                                                                                                                                                                                                                                                                                                                        6), ComponentsReport(
                                                                                                                                                                                                                                                                                                                                Reports,
                                                                                                                                                                                                                                                                                                                                "Components",
                                                                                                                                                                                                                                                                                                                                6), UserActionsReport(
                                                                                                                                                                                                                                                                                                                                        Reports,
                                                                                                                                                                                                                                                                                                                                        "User actions",
                                                                                                                                                                                                                                                                                                                                        6), ExternalStatsReport(
                                                                                                                                                                                                                                                                                                                                                Reports,
                                                                                                                                                                                                                                                                                                                                                "External Stats",
                                                                                                                                                                                                                                                                                                                                                6), AlertsReport(
                                                                                                                                                                                                                                                                                                                                                        Reports,
                                                                                                                                                                                                                                                                                                                                                        "Alerts",
                                                                                                                                                                                                                                                                                                                                                        6), ActivationReport(
                                                                                                                                                                                                                                                                                                                                                                Reports,
                                                                                                                                                                                                                                                                                                                                                                "Activation",
                                                                                                                                                                                                                                                                                                                                                                6), AllocationReport(
                                                                                                                                                                                                                                                                                                                                                                        Reports,
                                                                                                                                                                                                                                                                                                                                                                        "Allocation",
                                                                                                                                                                                                                                                                                                                                                                        6), ComponentChartsReport(
                                                                                                                                                                                                                                                                                                                                                                                Reports,
                                                                                                                                                                                                                                                                                                                                                                                "Component Charts",
                                                                                                                                                                                                                                                                                                                                                                                6), EngineChartsReport(
                                                                                                                                                                                                                                                                                                                                                                                        Reports,
                                                                                                                                                                                                                                                                                                                                                                                        "Engine Charts",
                                                                                                                                                                                                                                                                                                                                                                                        6);

        GSMenu parent;
        String subParent;
        String subTitle;
        String title;
        int menuNumber;

        private GSMenu(String title) {
            this.title = title;
        }

        private GSMenu(GSMenu parent, String title) {
            this(title);
            this.parent = parent;
        }

        private GSMenu(GSMenu parent, String title, int menuNumber) {
            this(title);
            this.parent = parent;
            this.menuNumber = menuNumber;
            
        }

        private GSMenu(GSMenu parent, String subParent, String title, int menuNumber) {
            this(title);
            this.parent = parent;
            this.subParent = subParent;
            this.menuNumber = menuNumber;
        }

        private GSMenu(GSMenu parent, String subParent, String subTitle, String title, int menuNumber) {
            this(title);
            this.parent = parent;
            this.subParent = subParent;
            this.subTitle = subTitle;
            this.title = title;
            this.menuNumber = menuNumber;
        }

        public GSMenu getParentMenu() {
            return parent;
        }

        public String getTitle() {
            return title;
        }

        public String getSubparent() {
            return subParent;
        }

        public String getSubTitle() {
            return subTitle;

        }

        public String getLoc() {
            System.out.println("getLoc..!!");
            return String.format(MENU_ITEM_LOC_FORMAT, title);
        }

        public String getSubMenuLoc() {
            System.out.println("getSubMenuLoc..!!");
            //return String.format(SUB_MENU_ITEM_LOC, title);
return String.format(SUB_MENU_ITEM_LOC, subParent);
            
        }
        public String getChildSubMenuLoc() {
            System.out.println("getChildSubMenuLoc..!!");
            return String.format(CHILD_SUB_MENU_ITEM_LOC, title);
        }

        public String getSubMenuParentLoc() {
            System.out.println("getSubMenuParentLoc..!!");
            return String.format(SUB_MENU_PARENT_ITEM_LOC, subParent);
            //return String.format(SUB_MENU_PARENT_ITEM_LOC, parent);
            
        }

        public String getSubTitleLoc() {
            System.out.println("SUB_MENU_PARENT_ITEM_LOC..!!");
            return String.format(SUB_MENU_PARENT_ITEM_LOC, subParent);
        }

    }

    public void openMenu(GSMenu menu) {

        System.out.println("inside OpenMenu functional Template page..!!");
        if (menu.parent != null) {
            ExtendedWebElement parentMenu = new ExtendedWebElement(By.xpath(menu.getParentMenu().getLoc()));
           // parentMenu.click();
            JavascriptExecutor executor = (JavascriptExecutor)driver;
    		executor.executeScript("arguments[0].click();", parentMenu);
        }
        waitForPageToLoad();
        if (menu.subParent != null) {
            ExtendedWebElement subParentMenu = new ExtendedWebElement(By.xpath(menu.getSubMenuParentLoc()));
            String subParentClass = subParentMenu.getAttribute("class");
            if (subParentClass.contains("collapsed")) {
                System.out.println("I m here to click subParentMenu ");
                JavascriptExecutor executor = (JavascriptExecutor)driver;
        		executor.executeScript("arguments[0].click();", subParentMenu);
                //subParentMenu.click();
            }
        }
        if (menu.subTitle != null) {
            ExtendedWebElement subTitleMenu = new ExtendedWebElement(By.xpath(menu.getSubTitleLoc()));
            String subTitleClass = subTitleMenu.getAttribute("class");
            if (subTitleClass.contains("collapsed")) {
            	JavascriptExecutor executor = (JavascriptExecutor)driver;
        		executor.executeScript("arguments[0].click();", subTitleMenu);
                //subTitleMenu.click();
            }
        }
        ExtendedWebElement subMenu = new ExtendedWebElement(By.xpath(menu.getSubMenuLoc()));
        ExtendedWebElement subMenuclild = new ExtendedWebElement(By.xpath(menu.getChildSubMenuLoc()));
        if (subMenu.isDisplayed()) {
        	JavascriptExecutor executor = (JavascriptExecutor)driver;
    		executor.executeScript("arguments[0].click();", subMenu);
           // subMenu.click();
            System.out.println("UserAdmin before");
           // subMenuclild.click();
            executor.executeScript("arguments[0].click();", subMenuclild);
            System.out.println("UserAdmin clicked");
        }
        /*
         * if (verifyPageTitle(menu.title)) {
         * driver.getAssertionService().verifyTrue(true, menu.title +
         * " is not present.", menu.title + " is present."); } else {
         * driver.getAssertionService().verifyTrue(false, menu.title +
         * " is not present.", menu.title + " is present."); }
         */
    }

    /*
     * @Override public void afterLaunchPage(Object... object) {
     *
     *
     * }
     */
    public boolean verifyPageTitle(String pagetitle) {
        try {
            System.out.println("Template Page verifyPageTitle functional call ");
            return (new ExtendedWebElement(By.xpath(String.format(PAGE_TITLE_LOC, pagetitle))).isPresent());
        } catch (ExtendedWebDriverException ex) {
            return false;
        }
    }

    public void verifyUserLogin(String firstName) {
        String name = driver.findElement(By.xpath("//span[@class='tc-profile-name']")).getText().trim();
        if (firstName.equals(name)) {
            getDriver().getAssertionService().addAssertionLog("Login successful for new user", MessageTypes.Pass);
        } else {
            getDriver().getAssertionService().addAssertionLog("Failed to login by new user", MessageTypes.Pass);
        }
    }

    public void addStaticWait(int waitTimeInMillis) {
        try {
            Thread.sleep(waitTimeInMillis);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void changeResultsPerPage(int noOfResults) {
        ExtendedWebElement resultsPerPageElement = new ExtendedWebElement(By.xpath(RESULTS_PER_PAGE_INPUT_LOC));
        Select resultPerPage = new Select(resultsPerPageElement);
        resultPerPage.selectByValue(Integer.toString(noOfResults));
    }

    public void verifyModalTitle(String modalTitle) {
        String title = getModalTitle();
        driver.getAssertionService().addAssertionLog("Checking Modal Title.", MessageTypes.Pass);
        if (title.equals(modalTitle)) {
            driver.getAssertionService().addAssertionLog("Modal with title " + modalTitle + " is present on UI.",
                    MessageTypes.Pass);
        } else {
            driver.getAssertionService().addAssertionLog("Modal with title " + modalTitle + " is not present on UI.",
                    MessageTypes.Fail);
        }
    }

    public void clickButtonOnInteractiveModal(String buttonOnModal) {
ExtendedWebElement butonLocation = new ExtendedWebElement(
                By.xpath(String.format(MODAL_HEADER_LOC + "/following-sibling::div//button[text()='%s']", buttonOnModal)));
        driver.getAssertionService().addAssertionLog("Checking buttons on modal.", MessageTypes.Pass);
        if (butonLocation.isDisplayed()) {
            driver.getAssertionService().addAssertionLog(
                    buttonOnModal + " button is present on Modal with header " + getModalTitle() + " so clicking it.",
                    MessageTypes.Pass);
            butonLocation.click();
        } else {
            driver.getAssertionService().addAssertionLog(
                    buttonOnModal + " button is not present on Modal with header " + getModalTitle(), MessageTypes.Fail);
        }
    }

    public void closeModalPopup() {
        ExtendedWebElement butonLocation = new ExtendedWebElement(
                By.xpath(String.format(MODAL_TITLE_LOC + "/following-sibling::button[contains(@class,'close')]")));
        if (butonLocation.isDisplayed()) {
            driver.getAssertionService().addAssertionLog("Closing the modal popup with headername " + getModalTitle(),
                    MessageTypes.Pass);
            butonLocation.click();
        } else {
            driver.getAssertionService().addAssertionLog(
                    "Close icon is not present on Modal with header " + getModalTitle(), MessageTypes.Fail);
        }
        driver.switchTo().activeElement();
    }

    public String getModalTitle() {
        String title = driver.findElement(By.xpath(MODAL_TITLE_LOC)).getText();
        return title;
    }

    public String getPropertyValueFromDetailsModalPopup(String propertyName) {
        String propertyValue = null;
        ExtendedWebElement modalPropertyBodyLocation = new ExtendedWebElement(
                By.xpath(String.format(MODAL_READONLY_PROPERTIES_BODY_LOC, propertyName)));
        if (modalPropertyBodyLocation.isPresent()) {
            propertyValue = modalPropertyBodyLocation.getText();
        } else {
            driver.getAssertionService().addAssertionLog("Property is not present on Modal", MessageTypes.Fail);
        }
        return propertyValue;
    }

    public void inputPropertyValueOnInteractiveModal(String propertyName, String value) {
        ExtendedWebElement modalPropertyBodyLocation = new ExtendedWebElement(
                By.xpath(String.format(MODAL_ADD_EDIT_PROPERTIES_BODY_LOC, propertyName)));
        if (modalPropertyBodyLocation.isPresent()) {
            modalPropertyBodyLocation.sendKeys(value);
        } else {
            driver.getAssertionService().addAssertionLog("Property is not present on Modal.", MessageTypes.Fail);
        }
    }

    public boolean isPropertyPresentInDetailsModalPopup(String propertyName) {
        boolean isPresent = false;
        ExtendedWebElement modalPropertyBodyLocation = new ExtendedWebElement(By.xpath(String.format(
                MODAL_HEADER_LOC + "/following-sibling::div[@class='detail-modal-body modal-body']//div[text()='%s']",
                propertyName)));
        if (modalPropertyBodyLocation.isPresent()) {
            isPresent = true;
        }
        return isPresent;
    }

    public void refreshBrowser() {
        driver.navigate().refresh();
    }

}