package helpers;

import io.restassured.RestAssured;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import step_definitions.BaseClass;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class PageHelpers extends BaseClass {
    private Wait wait = new Wait();
    private ScrollTo scrollTo = new ScrollTo();
	private JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
    public static List<String> errorList = new ArrayList<String>();
    Actions actions = new Actions(driver);

    public void checkPageIsReady(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Check the dom to see if the page load is complete
        if (js.executeScript("return document.readyState").toString().equals("complete")) {
            System.out.println("Page is fully loaded.");
            return;
        }

        // This loop will rotate for 25 times to check If page Is ready after every 1 second.
        for (int i = 0; i < 25; i++) {
            try {
                System.out.println("Page is not fully loaded, trying again in 10 second.");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
            }

            // Break out of loop when we see the ready state is complete
            if (js.executeScript("return document.readyState").toString().equals("complete")) {
                break;
            }
        }
        throw new TimeoutException("DOM never returned readyState as complete after 25 tries.");
    }

    public int httpResponseCodeViaGet(String url) {
        return RestAssured.get(url).statusCode();
    }

    public int httpResponseCodeViaPost(String url) {
        return RestAssured.post(url).statusCode();
    }

    public void checkForBrokenLinks() {

        List<WebElement> links = driver.findElements(By.cssSelector("a"));
        int statusCode;


        String href;

        for (WebElement link : links) {
            href = link.getAttribute("href");
            statusCode = httpResponseCodeViaGet(href);

            if (200 != statusCode) {
                System.out.println(href + " gave a response code of " + statusCode);
            }
        }
    }
}