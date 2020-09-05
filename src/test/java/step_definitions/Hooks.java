package step_definitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import helpers.JunitParallel;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.runner.RunWith;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import util.BrowserStackParallel;
import util.Browsers;

import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

@RunWith(JunitParallel.class)
public class Hooks {

    public static WebDriver driver;
    private static String driverDirectory = System.getProperty("user.dir") + "/webDrivers/usr/bin";
    private ChromeOptions chromeOptions = new ChromeOptions();
    private FirefoxOptions firefoxOptions = new FirefoxOptions();
    private InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
    public static String downloadfolderPath = System.getProperty("user.dir") + "/testData/testDataOutput";
    private DesiredCapabilities capabilities = new DesiredCapabilities();
    private Browsers browsers = new Browsers();
    public static final String USERNAME = "";

    @Before
    public void openBrowser() throws Exception {

        String browser = System.getProperty("browser", "chromeheadless");

        switch (browser.toLowerCase().trim()) {
            case "chrome":
//                WebDriverBinaryDownloader.create().downloadLatestBinaryAndConfigure(BrowserType.CHROME);
//                WebDriverManager.chromedriver().version("83.0").setup();
                System.setProperty("webdriver.chrome.driver", driverDirectory + "/chrome/chromedriver.exe");
//                WebDriverManager.chromedriver().setup();
                System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
                chromeOptions.addArguments("window-size=1280x1024");
                driver = new ChromeDriver(chromeOptions);
                driver.manage().window().maximize();
                break;

            case "firefox"://
                System.setProperty("webdriver.gecko.driver", driverDirectory + "/geckoFirefox/geckodriver.exe");
                driver = new FirefoxDriver();
                break;

            case "chromeheadless":
                System.setProperty("webdriver.chrome.driver", driverDirectory + "/chrome/chromedriver.exe");
                System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
                chromeOptions.addArguments("headless");
                chromeOptions.addArguments("window-size=1280x1024");
                chromeOptions.addArguments("--no-sandbox");
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefoxheadless":
//                WebDriverBinaryDownloader.create().downloadLatestBinaryAndConfigure(BrowserType.FIREFOX);
                firefoxOptions.addArguments("-headless");
                firefoxOptions.addArguments("window-size=1280x1024");
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "grid":
//                System.setProperty("webdriver.chrome.driver", driverDirectory + "/chrome/chromedriver.exe");
                final String gridURL="http://localhost:4444/wd/hub";
                capabilities.setBrowserName("chrome");
                capabilities.setCapability("name","Automation Practice Tests");
                capabilities.setPlatform(Platform.WINDOWS);
                driver = new RemoteWebDriver(new URL(gridURL), capabilities);
                break;

            case "browserstack":
                final String USERNAME = "sameer238";
                final String AUTOMATE_KEY = "zhiDpozspJf7snxaEx4o";
                final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

                DesiredCapabilities caps = new DesiredCapabilities();

                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("browser", "Chrome");
                caps.setCapability("browser_version", "80");
                caps.setCapability("name", "Automation Practice Tests");

                driver = new RemoteWebDriver(new URL(URL), caps);
                break;
        }

        System.out.println("The Browser used for this test is: " + browser.toUpperCase());
    }


    @After
    public void embedScreenshot(Scenario scenario) throws Exception {
        System.out.println(scenario.getStatus() + "\t" + Arrays.asList(scenario.getSourceTagNames()).toString());
        if (scenario.isFailed()) {
            try {
                scenario.write("Current Page URL is " + new URL(driver.getCurrentUrl()));
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }
        }
        if (driver != null) {
            driver.quit();
        }
    }
}