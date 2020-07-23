package helpers;


import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import step_definitions.BaseClass;

import java.util.ArrayList;

import static org.junit.Assert.assertThat;

public class PopupWindow extends BaseClass {
    private Wait wait = new Wait();
    private Faker faker = new Faker();
    private Actions actions = new Actions(driver);

    @FindBy(id = "modalDialogConfirmButton")
    public WebElement modalDialogConfirmButton;

    public PopupWindow(WebDriver driver) {
        driver = this.driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean checkIfPopupWindowClosed() {

        int windowCount = driver.getWindowHandles().size();

        if (windowCount > 1) {

        }

        try {
            return (new WebDriverWait(driver, 20)).
                    until(new ExpectedCondition<Boolean>() {

                              @Override
                              public Boolean apply(WebDriver d) {
                                  return d.getWindowHandles().size() < 1;
                              }
                          }
                    );
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void getTitleOfNewPage(WebDriver driver, String newPageTitle) {

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        String title = driver.getTitle();
        System.out.println(title);
        assertThat(title, CoreMatchers.containsString(newPageTitle));
    }

    public void ifPopupClickContinue() throws InterruptedException {
        Thread.sleep(2000);
        if (driver.findElement(By.id("modalContent")).isDisplayed()) {
            String winHandleBefore = driver.getWindowHandle();
            for (String winHandle : driver.getWindowHandles()) {
                driver.switchTo().window(winHandle);
            }
            actions.moveToElement(driver.findElement(By.id("modalDialogConfirmButton"))).click().perform();
            Thread.sleep(2000);
        }
        if (driver.findElement(By.id("modalContent")).isDisplayed()) {
            if (driver.findElement(By.id("modalDailogXButton")).isDisplayed()) {
                actions.moveToElement(driver.findElement(By.id("modalDailogXButton"))).click().perform();
            } else {
                Thread.sleep(4000);
            }
        }
    }

    public void getTheHandleOf() {
        wait.waitUntilIsPresent(By.id("modalDialog"));
        driver.switchTo().activeElement();
    }

    public String editAnAffiliate() throws InterruptedException {
        Name name = faker.name();
        String fakeName = name.fullName();
        moveToNewFrame();
        Thread.sleep(3000);
        driver.findElement(By.id("Name")).clear();
        driver.findElement(By.id("Name")).sendKeys(fakeName);
        driver.findElement(By.id("modalDialogConfirmButton")).click();
        wait.waitUntilNotPresent(By.id("modalDialogConfirmButton"));
        return fakeName;
    }

    public void openNewTab() throws InterruptedException {
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver).executeScript("window.open();");
        }
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public void moveToNewWindow() throws InterruptedException {
        String winHandleBefore = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
            driver.manage().window().maximize();
        }
    }

    public void closeNewWindow() {
        String winHandleBefore = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
            driver.close();
        }
    }

    public void moveToNewFrame() {
        if (driver.findElement(By.id("modalDialog")).isDisplayed()) {
            String winHandleBefore = driver.getWindowHandle();
            for (String winHandle : driver.getWindowHandles()) {
                driver.switchTo().window(winHandle);
            }
        }
    }

    public void moveToNewFrame(String idOFtheFrame) {
        if (driver.findElement(By.id(idOFtheFrame)).isDisplayed()) {
            String winHandleBefore = driver.getWindowHandle();
            for (String winHandle : driver.getWindowHandles()) {
                driver.switchTo().window(winHandle);
            }
        }
    }

    public void moveToNewTab() {
        ArrayList<String> numberWindows = new ArrayList<String>(driver.getWindowHandles());
        if (numberWindows.size() > 1) {
            driver.switchTo().window(numberWindows.get(1));
        }
    }

    public void moveToRecentlyOpenedTab() {
        ArrayList<String> numberWindows = new ArrayList<String>(driver.getWindowHandles());
        int noofTabsOpen = numberWindows.size();
        driver.switchTo().window(numberWindows.get(noofTabsOpen - 1));
    }

    public void moveToDefaultTab() {
        ArrayList<String> numberWindows = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(numberWindows.get(0));
    }

    public void moveToIframe(String frameName) {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(frameName);
    }

    public void moveToMainWindow() {
        String mainWindow = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        driver.switchTo().window(mainWindow);
    }
}