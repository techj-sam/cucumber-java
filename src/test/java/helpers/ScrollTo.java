package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import step_definitions.BaseClass;

import static step_definitions.Hooks.driver;

public class ScrollTo {

    private JavascriptExecutor jse = (JavascriptExecutor) driver;

    public void scrollToView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

    }

    public void scrollUp() {
        jse.executeScript("scroll(0, -250);");

    }

    public void scrollDown() {
        jse.executeScript("scroll(0, 500);");
    }

    public void scrollToMiddle() {
        jse.executeScript("scroll(0, 200);");

    }

    public void scrollRight() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(2000,0)");
    }

    public void scrollToViewAndClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public void scrollToViewAndClickFalse(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
        element.click();
    }
}
