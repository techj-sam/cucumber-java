package util;

import helpers.JunitParallel;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.LinkedList;

    @RunWith(JunitParallel.class)
    public class BrowserStackParallel {
    public static String platform;
    public static String browserName;
    public static String browserVersion;

    @Parameterized.Parameters
    public static LinkedList<String[]> getEnvironments() {
        LinkedList<String[]> env = new LinkedList<String[]>();
        env.add(new String[]{Platform.WINDOWS.toString(), "chrome", "71"});
        env.add(new String[]{Platform.WINDOWS.toString(), "firefox", "20"});

        //add more browsers here

        return env;
    }


    public BrowserStackParallel(String platform, String browserName, String browserVersion) {
        BrowserStackParallel.platform = platform;
        BrowserStackParallel.browserName = browserName;
        BrowserStackParallel.browserVersion = browserVersion;
    }

    @SuppressWarnings("unused")
	private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability("platform", platform);
        capability.setCapability("browser", browserName);
        capability.setCapability("browserVersion", browserVersion);
        capability.setCapability("build", "JUnit-Parallel");
        driver = new RemoteWebDriver(
                new URL("http://ip:port/wd/hub"),
                capability);
    }
}


