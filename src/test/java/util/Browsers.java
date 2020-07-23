package util;

import com.browserstack.local.Local;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class Browsers {

    public static final String USERNAME = "";
    public static final String AUTOMATE_KEY = "";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    private static String driverDirectory = System.getProperty("user.dir") + "/webDrivers/usr/bin";
    private static DesiredCapabilities caps = new DesiredCapabilities();
    public static WebDriver driver;
    private static Local l;

    public static WebDriver getPJSMacDriver() throws Exception {
        String[] cli_args = new String[]{"--ignore-ssl-errors=true"};
        System.out.println("Getting ready to start with Phantom JS Mac");
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, cli_args);
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                (driverDirectory + "/macPJS/phantomjs"));
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_PAGE_SETTINGS_PREFIX + "javascriptEnabled", true);
        WebDriver driver = new PhantomJSDriver(caps);
        driver.manage().window().setSize(new Dimension(1280, 1024));
        return driver;
    }


    public static WebDriver getPJSLinux() throws Exception {
        System.out.println("Getting ready to start with Phantom JS Linux");
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                (driverDirectory + "/linuxPJS/phantomjs"));
        WebDriver driver = new PhantomJSDriver(caps);
        return driver;
    }


    public static WebDriver getpjsWindows() throws Exception {

        System.out.println("Getting ready to start with Phantom JS Windows");
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                (driverDirectory + "/WindowsPJS/phantomjs.exe"));
        WebDriver driver = new PhantomJSDriver(caps);
        return driver;
    }



    public static WebDriver getIEGrid() throws Exception {
        String nodesURL = "http://10.211.55.3:5555/wd/hub";
        DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
        cap.setBrowserName("internet explorer");
        cap.setPlatform(Platform.WINDOWS);
        WebDriver driver = new RemoteWebDriver(new URL(nodesURL), cap);
        return driver;

    }

    public static WebDriver pjsWindowsGet(){
        WebDriver driver;
        DesiredCapabilities capabilities= DesiredCapabilities.phantomjs();
        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability("phantomjs.binary.path",
                driverDirectory+ "/WindowsPJS/phantomjs.exe");
        capabilities.setJavascriptEnabled(true);
        driver = new PhantomJSDriver(capabilities);
        return driver;
    }

    public static WebDriver getTrifleJS(){
        WebDriver driver;
        DesiredCapabilities capabilities= DesiredCapabilities.phantomjs();
        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability("phantomjs.binary.path",
                driverDirectory+ "/TrifleJS/TrifleJS.exe");
        capabilities.setJavascriptEnabled(true);
        driver = new PhantomJSDriver(capabilities);
        return driver;
    }

    public static WebDriver getBrowserStack(String browserName, String browserVersion,
                                            String operatingSystem, String osVersion) throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", browserName);
        caps.setCapability("browser_version", browserVersion);
        caps.setCapability("os", operatingSystem);
        caps.setCapability("os_version", osVersion);
        caps.setCapability("resolution", "1024x768");
        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        return driver;
    }

}






























