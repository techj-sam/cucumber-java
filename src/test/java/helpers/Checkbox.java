package helpers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import step_definitions.BaseClass;

import java.util.List;

public class Checkbox extends BaseClass {
    public void checkTheCheckbox(List<WebElement> webElements) {
        for (WebElement webElement : webElements) {
            Actions actions = new Actions(driver);
            actions.moveToElement(webElement);
            webElement.click();
            System.out.println("Task Checkbox checked");
            break;
        }
    }

    public void uncheckTheCheckbox(List<WebElement> webElements) {
        for (WebElement webElement : webElements) {
            Actions actions = new Actions(driver);
            actions.moveToElement(webElement);
            webElement.click();
            System.out.println("Task Checkbox unchecked");
            break;
        }
    }
}