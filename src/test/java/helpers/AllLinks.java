package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import step_definitions.BaseClass;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class AllLinks extends BaseClass {

    private static int linkCount;
    private static List<WebElement> allLinks;
    private Wait wait = new Wait();
    PageHelpers pageHelpers = new PageHelpers();

    public void getCountAllLinks() {

        allLinks = wait.waitAndReturnListElements(driver, By.tagName("a"));
        linkCount = allLinks.size();
        System.out.println("Total number of links in this page " + linkCount);

    }

    public void getAllLinks() throws InterruptedException {


        String[] links = new String[linkCount];
        System.out.println("List of links Available: ");
        // print all the links from webpage
        for (int i = 0; i < linkCount; i++) {
            links[i] = allLinks.get(i).getAttribute("href");
            System.out.println(allLinks.get(i).getAttribute("href"));

        }

    }

    public void navigateToAllLinks() throws InterruptedException {

        List<WebElement> allLinks = wait.waitAndReturnListElements(driver, By.tagName("a"));
        String[] links = new String[linkCount];
        for (int i = 0; i < allLinks.size(); i++) {
            links[i] = allLinks.get(i).getAttribute("href");
        }

        // navigate to each Link on the webpage
        for (int i = 0; i < allLinks.size(); i++) {

            try {
                driver.navigate().to(links[i]);
                int statusCode = pageHelpers.httpResponseCodeViaGet(driver.getCurrentUrl());
                System.out.println("The status code of " + "\"" + driver.getCurrentUrl() + "\""+ "  is: "+ statusCode);
                Thread.sleep(1000);
                assertEquals(200, statusCode);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void getAllLinksName() {

        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (int i = 0; i < links.size(); i++) {
            System.out.println(links.get(i).getText());

        }

    }
}
