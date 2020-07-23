package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import step_definitions.BaseClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class SelectElements extends BaseClass {
    private Random random = new Random();
    Actions actions = new Actions(driver);

    public void selectRandomValueDropdown(String ID) {
        Select selectItem = new Select(driver.findElement(By.id(ID)));
        int optionIndex = random.nextInt(selectItem.getOptions().size() - 1);
        selectItem.selectByIndex(optionIndex++);
    }

    public void selectRandomOption(By by) {
        Select oSelect = new Select(driver.findElement(by));
        List<WebElement> allProducts = oSelect.getOptions();
        int randomProduct = random.nextInt(allProducts.size());
        allProducts.get(randomProduct).click();
    }

    public void selectRandomOption(WebElement webElement) {
        Select oSelect = new Select(webElement);
        List<WebElement> allProducts = oSelect.getOptions();
        int randomProduct = random.nextInt(allProducts.size());
        allProducts.get(randomProduct).click();
    }

    public void selectRandomOptionBesideFirst(By by) {
        Select oSelect = new Select(driver.findElement(by));
        List<WebElement> allProducts = oSelect.getOptions();
        for (int i = 0; i < allProducts.size(); i++) {

            int randomProduct = random.nextInt(allProducts.size());
            allProducts.get(randomProduct).click();
        }
    }

    public void selectByVisibleText(By by, String text) {
        new Select(driver.findElement(by)).selectByVisibleText(text);
    }

    public void selectByVisibleText(WebElement element, String text) {
        new Select(element).selectByVisibleText(text);
    }

    public void selectByIndexNumbert(By by, int indexNumber) {
        new Select(driver.findElement(by)).selectByIndex(indexNumber);
    }

    public void selectByIndexNumbert(WebElement element, int indexNumber) {
        new Select(element).selectByIndex(indexNumber);
    }

    public void deSelectByIndexNumbert(WebElement element, int indexNumber) {
        new Select(element).deselectByIndex(indexNumber);
    }

    public void selectJavaScriptItems(String selectID, String selectText) throws Exception {
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver).executeScript(String.format("$('#%s').attr('style','display:block;');", selectID));
            ((JavascriptExecutor) driver).executeScript(String.format("$('#%s option').attr('style','display:block;')", selectID));
        } else {
            throw new Exception("broken");
        }

        WebElement element = driver.findElement(By.id(selectID));
        Select select = new Select(element);
        select.selectByVisibleText(selectText);
    }

    public void selectJavaScriptItems(String selectID, int indexNumber) throws Exception {
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver).executeScript(String.format("$('#%s').attr('style','display:block;');", selectID));
            ((JavascriptExecutor) driver).executeScript(String.format("$('#%s option').attr('style','display:block;')", selectID));
        } else {
            throw new Exception("broken");
        }

        WebElement element = driver.findElement(By.id(selectID));
        Select select = new Select(element);
        select.selectByIndex(indexNumber);
    }

    public void selectRandomElement(WebElement element) {
        Select oSelect = new Select(element);
        List<WebElement> allProducts = oSelect.getOptions();
        int randomProduct = random.nextInt(allProducts.size());
        allProducts.get(randomProduct).click();
    }

    public String getPreselectedText(WebElement element) {
        String text;
        Select select = new Select(element);
        WebElement option = select.getFirstSelectedOption();
        return text = option.getText();
    }

    public void clickOnMultiSelectDropDown(WebElement element, String checkBoxValue) {
        selectByVisibleText(element, checkBoxValue);
    }

    public void clickFirstMultiSelectOption(String multiSelectBoxName) {
        actions.moveToElement(driver.findElement(By.id(multiSelectBoxName))).sendKeys(Keys.ENTER).sendKeys(Keys.TAB);
    }

    public void selectCustomDropDown(String customDropDownName, int indexNumber) {
        selectByIndexNumbert(driver.findElement(By.id(customDropDownName)), indexNumber);
    }

    public void typeInCustomFieldTextBox(String customTextBoxName, String textToInput) {
        driver.findElement(By.id(customTextBoxName)).sendKeys(textToInput);
    }


    public List<String> getAllOptions(WebElement element) {

        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        List<String> valuesInSelectElement = new ArrayList<String>();
        for (WebElement optionElement : options) {
            valuesInSelectElement.add(optionElement.getText());
        }
        return valuesInSelectElement;
    }

    public void selectanotherOption(WebElement element) {

        String preselectedValue;
        Select select = new Select(element);
        preselectedValue = getPreselectedText(element);

        List<String> allOptions = getAllOptions(element);

        for (String valueinDropdown : allOptions) {

            if ((!valueinDropdown.equalsIgnoreCase(preselectedValue)) && (!valueinDropdown.isEmpty())) {
                select.selectByVisibleText(valueinDropdown);
                break;
            }
        }
    }

    public void selectLastOption(WebElement element) {
        Select s = new Select(element);
        s.selectByIndex(s.getOptions().size() - 1);
    }

    public WebElement getSelectedOption(WebElement element) {
        Select s = new Select(element);
        return s.getFirstSelectedOption();
    }

    public void selectOtherOption(WebElement element) {
        Select s = new Select(element);
        String selectedElement = s.getFirstSelectedOption().getText();

        List<WebElement> elements = s.getOptions();
        for (int i = elements.size() - 1; i >= 0; i--) {
            s.selectByIndex(i);
            if (!selectedElement.equalsIgnoreCase(s.getFirstSelectedOption().getText()))
                break;
        }
    }

    public void selectAllOptionsFromMultiSelect(WebElement element) {
        Select select = new Select(element);
        List<WebElement> webElements = select.getOptions();

        for (WebElement webElement : webElements)
            webElement.click();

    }

    public List<WebElement> getAllOptionsFromDropdown(WebElement element) {
        Select select = new Select(element);
        return select.getOptions();
    }

    public void writeAndChooseOnEmptyBox(WebElement element, String stringToType) throws InterruptedException {

        element.sendKeys(stringToType);
        Thread.sleep(2000);
        List<WebElement> suggestions = driver.findElements(By.cssSelector(".tt-highlight"));

        for (WebElement option : suggestions) {
            assertTrue("Suggestions in serach box does not contain these chars", option.getText().equalsIgnoreCase(stringToType));
        }
        actions.moveToElement(suggestions.get(suggestions.size() - 1)).click().build().perform();
    }

    public boolean isDropdownMultiSelect(WebElement element) {
        Select select = new Select(element);
        return select.isMultiple();
    }

    public void selectFirstOption(WebElement element) {
        Select s = new Select(element);
        s.selectByIndex(s.getOptions().size() - s.getOptions().size());
    }

    public void selectDropdownOptionFromMultipleDropdowns(List<WebElement> webElements, String option) {
        loop:
        for (WebElement webElement : webElements)
            for (String webElementOption : getAllOptions(webElement))
                if (webElementOption.equalsIgnoreCase(option)) {
                    selectByVisibleText(webElement, option);
                    break loop;
                }
    }
}