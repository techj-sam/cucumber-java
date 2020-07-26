package pageobjects;

import helpers.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import step_definitions.BaseClass;
import step_definitions.ObjectClass;

public class HomePage extends BaseClass {

    @FindBy(css=".logout")
    public WebElement logout;

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    }
