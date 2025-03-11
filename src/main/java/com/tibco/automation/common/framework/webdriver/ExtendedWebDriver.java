package com.tibco.automation.common.framework.webdriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.tibco.automation.common.utils.WaitUtility;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.*;

import com.tibco.automation.common.utils.LocatorUtil;

public class ExtendedWebDriver extends RemoteWebDriver {

    private final static Logger logger = Logger.getLogger(ExtendedWebDriver.class);
    private WaitUtility waitUtil;
    private WebDriverAssertions assertionService;

    public ExtendedWebDriver(URL url, Capabilities capabilities) {
        super(url, capabilities);
        init();
    }

    public ExtendedWebDriver(CommandExecutor cmdExecutor, Capabilities capabilities) {
        super(cmdExecutor, capabilities);
        init();
    }

    @Override
    protected void setCommandExecutor(CommandExecutor executor) {
        super.setCommandExecutor(executor);
    }

    public ExtendedWebDriver(WebDriver driver) {
        this(((RemoteWebDriver) driver).getCommandExecutor(), ((RemoteWebDriver) driver).getCapabilities());
        if (this.getCapabilities().getBrowserName().toLowerCase().contains("internet")) {
            driver.close();
        }
    }

    private void init() {
        setElementConverter(new ExtendedWebElement.JsonConvertor(this));
        waitUtil = new WaitUtility(this);
        assertionService = new WebDriverAssertions(this);
    }

    public WebDriverAssertions getAssertionService() {
        return assertionService;
    }

    public WaitUtility getWaitUtility() {
        return waitUtil;
    }

	/*
     * public static ExtendedWebDriver getWebDriver(URL url, Capabilities
	 * capabilities) {
	 * 
	 * if (instance != null) { return instance; }
	 * 
	 * ExtendedWebDriver webDriverFactory = new ExtendedWebDriver(url,
	 * capabilities);
	 * 
	 * instance = webDriverFactory;
	 * 
	 * return instance; }
	 */

    public ExtendedWebElement findElement(String locator) {
        return new ExtendedWebElement(this, LocatorUtil.getBy(locator));
    }

    /*@Override
    public ExtendedWebElement findElement(By by) {
        ExtendedWebElement element = (ExtendedWebElement) super.findElement(by);
        element.setBy(by);
        return element;
    }*/

    public ExtendedWebElement findElement(By by) {
        ExtendedWebElement element = (ExtendedWebElement) super.findElement(by);
        element.setBy(by);
        return element;
    }

    public List<WebElement> findElements(By by) {
        return by.findElements(this);
    }

    private List<ExtendedWebElement> convertElements(List<WebElement> elements) {
        List<ExtendedWebElement> elements1 = new ArrayList<ExtendedWebElement>();

        for (WebElement ele : elements) {
            ExtendedWebElement ele1 = (ExtendedWebElement) ele;
            elements1.add(ele1);
        }
        return elements1;
    }

    public ExtendedWebElement createElement(By by) {
        return new ExtendedWebElement(this, by);
    }

    public ExtendedWebElement createElement(String locator) {
        return new ExtendedWebElement(locator);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        //if ((Boolean) getCapabilities().getCapability(CapabilityType.TAKES_SCREENSHOT)) {
            String base64Str = execute(DriverCommand.SCREENSHOT).getValue().toString();
            return target.convertFromBase64Png(base64Str);
        //}
        //return null;
    }

    public <T> T extractScreenShot(WebDriverException e, OutputType<T> target) {
        if (e.getCause() instanceof ScreenshotException) {
            String base64Str = ((ScreenshotException) e.getCause()).getBase64EncodedScreenshot();
            return target.convertFromBase64Png(base64Str);
        }
        return null;
    }

    // Wait service
    public Alert getAlert() {
        return new ExtendedWebDriverWait(this).until(ExtendedExpectedConditions.alertIsPresent());
    }

    @Override
    public ExtendedWebElement findElementByClassName(String using) {
        return (ExtendedWebElement) super.findElementByClassName(using);
    }

    @Override
    public ExtendedWebElement findElementByCssSelector(String using) {
        return (ExtendedWebElement) super.findElementByCssSelector(using);
    }

    @Override
    public ExtendedWebElement findElementById(String using) {
        return (ExtendedWebElement) super.findElementById(using);
    }

    @Override
    public ExtendedWebElement findElementByLinkText(String using) {
        return (ExtendedWebElement) super.findElementByLinkText(using);
    }

    //@Override
    public ExtendedWebElement findElementByName(String using) {
        return (ExtendedWebElement) super.findElementByName(using);
    }

    @Override
    public ExtendedWebElement findElementByPartialLinkText(String using) {
        return (ExtendedWebElement) super.findElementByPartialLinkText(using);
    }

    @Override
    public ExtendedWebElement findElementByTagName(String using) {
        return (ExtendedWebElement) super.findElementByTagName(using);
    }

    @Override
    public ExtendedWebElement findElementByXPath(String using) {
        return (ExtendedWebElement) super.findElementByXPath(using);
    }

    public void load(ExtendedWebElement... elements) {
        if (elements != null) {
            for (ExtendedWebElement element : elements) {
                final By by = element.getBy();
                element.setId(((ExtendedWebElement) new ExtendedWebDriverWait(this).ignore(NoSuchElementException.class,
                        StaleElementReferenceException.class)
                        .until(ExtendedExpectedConditions.presenceOfElementLocated(by))).getId());
            }
        }
    }

    @Override
    protected Response execute(String command) {
        System.out.println(command);
        return super.execute(command);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected Response execute(String driverCommand, Map<String, ?> parameters) {
        CommandTracker commandTracker = new CommandTracker(driverCommand, parameters);

        try {
            beforeCommand(this, commandTracker);
            // already handled in before command?
            if (commandTracker.getResponce() == null) {
                commandTracker.setResponce(super.execute(commandTracker.getCommand(), commandTracker.getParameters()));
            }
            afterCommand(this, commandTracker);
        } catch (RuntimeException wde) {
            commandTracker.setException(wde);
            onFailure(this, commandTracker);

        }
        if (commandTracker.hasException()) {
            throw commandTracker.getException();
        }
        return commandTracker.getResponce();
    }

    protected Response executeWitoutLog(String driverCommand, Map<String, ?> parameters) {
        return super.execute(driverCommand, parameters);
    }

    public void afterCommand(ExtendedWebDriver driver, CommandTracker commandTracker) {
        commandTracker.setStage(commandTracker.stage.executingAfterMethod);

    }

    // private boolean invokingListener;
    public void beforeCommand(ExtendedWebDriver driver, final CommandTracker commandTracker) {
        // if (!invokingListener) {
        commandTracker.setStage(commandTracker.stage.executingBeforeMethod);

    }

    public void onFailure(ExtendedWebDriver driver, CommandTracker commandTracker) {
        commandTracker.setStage(commandTracker.stage.executingOnFailure);
        if (commandTracker.getException() instanceof UnsupportedOperationException) {
            commandTracker.setException(null);
        }

    }

    /**
     * Under evaluation only
     *
     * @param using
     * @return
     */
    public ExtendedWebElement findElementBySizzleCss(String using) {
        List<ExtendedWebElement> elements = findElementsBySizzleCss(using);
        if (elements.size() > 0)
            return elements.get(0);
        return null;
    }

    /**
     * Under evaluation only
     *
     * @param using
     * @return
     */
    public List<ExtendedWebElement> findElementsBySizzleCss(String using) {
        injectSizzleIfNeeded();
        String javascriptExpression = createSizzleSelectorExpression(using);
        return (List<ExtendedWebElement>) executeScript(javascriptExpression);
    }

    private String createSizzleSelectorExpression(String using) {
        return "return Sizzle(\"" + using + "\")";
    }

    private void injectSizzleIfNeeded() {
        if (!sizzleLoaded())
            injectSizzle();
    }

    private Boolean sizzleLoaded() {
        Boolean loaded;
        try {
            loaded = (Boolean) executeScript("return Sizzle()!=null");
        } catch (WebDriverException e) {
            loaded = false;
        }
        return loaded;
    }

    private void injectSizzle() {
        executeScript(" var headID = document.getElementsByTagName(\"head\")[0];"
                + "var newScript = document.createElement('script');" + "newScript.type = 'text/javascript';"
                + "newScript.src = 'https://raw.github.com/jquery/sizzle/master/sizzle.js';"
                + "headID.appendChild(newScript);");
    }

    @Override
    public CommandExecutor getCommandExecutor() {
        return super.getCommandExecutor();
    }

    public static void main(String[] args) throws MalformedURLException {
    	 DesiredCapabilities capabilities;
    	 ExtendedWebDriver driver;
    	 ExtendedWebElement e;
        System.setProperty("webdriver.gecko.driver", "D:\\silverFabricWebDriverFramework\\server\\geckodriver.exe");
        capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("firefox");
        capabilities.setCapability("marionette", true);

        FirefoxOptions options = new FirefoxOptions();

        //ExtendedWebDriver driver = new ExtendedWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        //WebDriver driver = new FirefoxDriver(capabilities);
        driver = new ExtendedWebDriver(new FirefoxDriver(options));
        driver.get("https://www.google.co.in/");
         e = new ExtendedWebElement(driver, By.name("q"));
        //ExtendedWebElement e = driver.findElement(By.name("q"));
        e.sendKeys("test");
        driver.close();
        
        
        capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
       // capabilities.setCapability("marionette", true);

        ChromeOptions chroptions = new ChromeOptions();

        //ExtendedWebDriver driver = new ExtendedWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        //WebDriver driver = new FirefoxDriver(capabilities);
         driver = new ExtendedWebDriver(new ChromeDriver(chroptions));
        driver.get("https://www.google.co.in/");
        e = new ExtendedWebElement(driver, By.name("q"));
        //ExtendedWebElement e = driver.findElement(By.name("q"));
        e.sendKeys("test");
        driver.close();
    }

}