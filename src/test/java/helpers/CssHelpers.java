package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import step_definitions.BaseClass;

public class CssHelpers extends BaseClass {
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public void HideElement(WebElement webElement){
        js.executeScript("arguments[0].setAttribute('style', 'display:none;')",webElement);
    }

    public WebElement setAttribute(WebElement webElement, String attribute, String value){
        js.executeScript("arguments[0].setAttribute('"+attribute+"', '"+value+"')",webElement);
        return webElement;
    }
}
