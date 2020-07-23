package helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import org.openqa.selenium.support.ui.WebDriverWait;
import step_definitions.BaseClass;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Wait extends BaseClass {

    private int waitTime = 60;
    private int longwaitTime = 150;
    private WebDriverWait webDriverWait = new WebDriverWait(driver, waitTime);
    private WebDriverWait longWebDriverWait = new WebDriverWait(driver, longwaitTime);
    private FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);

    public void waitAndClick(WebDriver driver, By by) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }

    public WebElement waitAndClick(WebElement element) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        return element;
    }

    public void waitAndRefresh(WebElement element) {

        org.openqa.selenium.support.ui.Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(40, SECONDS)
                .pollingEvery(5, SECONDS)
                .ignoring(NoSuchElementException.class);
        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                driver.navigate().refresh();
                return element;
            }
        });
    }

    public void waitForanElement(WebElement element) {

        org.openqa.selenium.support.ui.Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(2, SECONDS)
                .ignoring(NoSuchElementException.class);
        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return element;
            }
        });
    }

    public String waitAndGetText(WebDriver driver, By by) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        String text = driver.findElement(by).getText();
        return text;
    }

    public String waitAndGetText(WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        String text = element.getText();
        return text;
    }

    public Boolean waitUntilIsPresent(By by) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return null;
    }

    public Boolean waitUntilIsPresent(WebElement by) {
        webDriverWait.until(ExpectedConditions.visibilityOf(by));
        return null;
    }

    public WebElement waitUnitlIsPresent(WebElement element) {
        element = webDriverWait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public void frameIsPresentAndSwitch(By by) throws InterruptedException {
        Thread.sleep(3000);
        driver.getWindowHandles();
        webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("screeningDdiqFrame")));
    }

    public void iFrameAndSwitch(String frameName) throws InterruptedException {
        Thread.sleep(3000);
        driver.getWindowHandles();
        By by = By.id(frameName);

        try {
            webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
            //your actions on iframe here

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void waitUntilNotPresent(By by) {
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void longwaitUntilNotPresent(By by) {
        longWebDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public Boolean longWaitUntilIsPresent(By by) {
        longWebDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return null;
    }

    public void waitUntilNotPresent(WebElement element) {
        webDriverWait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void longWaitUntilNotPresent(WebElement element) {
        longWebDriverWait.until(ExpectedConditions.invisibilityOf(element));
    }


    public void waitUntilElementEnabled(WebElement element){
//        WebDriverWait wait = new WebDriverWait(driver, 30);

        webDriverWait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {

                if (element.isEnabled()) {
                    return true;
                } else
                    return false;
            }
        });
    }

    public void waitUntilTextVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                String enabled = element.getText();
//                System.out.println(enabled);
                if (!enabled.isEmpty()) {
//                    System.out.println("text ------ " + enabled);
                    return true;
                } else
                    return false;
            }
        });
    }

    public void untilNoPopUp() {
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("modalDialogConfirmButton")));
    }

    public void untilModalIsNotPresent() {
        webDriverWait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("modalDialog"))));
    }

    public void waitUntilSubjectLoadingNotPresent() {
        if (driver.findElements(By.cssSelector("[data-bind='visible: SubjectLoading']")).size() != 0) {
            webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated
                    (By.cssSelector("[data-bind='visible: SubjectLoading']")));
        }
    }

    public void waitAndSwitchToNewTab() {

        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
    }

    public void waitAndClickOnElement(WebDriver driver, WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public void waitUntilTextIs(WebElement element, String text) {
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(element, text));

    }

    public WebElement waitAndReturnElement(WebDriver driver, By by) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        WebElement element = driver.findElement(by);
        return element;
    }

    public WebElement longWaitAndReturnElement(WebDriver driver, By by) {
        longWebDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        WebElement element = driver.findElement(by);
        return element;
    }

    public WebElement waitAndReturnElement(WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public WebElement longWaitAndReturnElement(WebElement element) {
        longWebDriverWait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public void waitToGetTitle(String title) {
        webDriverWait.until(ExpectedConditions.titleIs(title));

    }

    public List<WebElement> waitAndReturnListElements(WebDriver driver, By by) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        List<WebElement> elements = driver.findElements(by);
        return elements;
    }

    public List<WebElement> waitUntilListIsPresent(List<WebElement> elements) {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(elements));
        return elements;
    }

    public void waitAndSendKeys(WebDriver driver, By by, String keys) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        driver.findElement(by).sendKeys(keys);
    }

    public void waitAndSendKeysByElement(WebElement element, String keys) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(keys);
    }

    public void waitAndSwitchToNewWindow(WebDriver driver, By by) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        if (driver.findElement(by).isDisplayed()) {
            driver.switchTo().activeElement();
        }
    }

    public void waitUntilElementListIsPresent(List<WebElement> elements) {
        int count = 0;
        while (elements.isEmpty() && count < 5)
            try {
                webDriverWait.until(ExpectedConditions.visibilityOfAllElements(elements));
            } catch (Exception e) {
                count++;
            }
    }

//    public void waitForElementToDisplay(WebDriver driver,WebElement element){
//
//                wait.withTimeout(40, SECONDS);
//                wait.pollingEvery(5, SECONDS);
//                wait.ignoring(NoSuchElementException.class);
//                wait.ignoring(ElementNotVisibleException.class);
//
//        boolean isElementFound = wait.until(new Function<WebDriver,Boolean>() {
//            @Override
//            public Boolean apply(WebDriver driver) {
//                return element.isDisplayed();
//            }
//        });
//    }

    public void waitForJQuery(WebDriver driver) {
        final Boolean until = webDriverWait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                JavascriptExecutor js = (JavascriptExecutor) d;
                return (Boolean) js.executeScript("return !!window.jQuery && window.jQuery.active == 0");
            }
        });
    }
}