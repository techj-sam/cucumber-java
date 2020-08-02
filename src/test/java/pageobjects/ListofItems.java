package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import step_definitions.BaseClass;

public class ListofItems extends BaseClass {

    @FindBy(xpath = "(//a[@title='Dresses']/parent::*)[2]")
    public WebElement dressestab;

    @FindBy(css="a[title='Evening Dresses']")
    public WebElement eveningDresses;

    @FindBy(css="img[title='Printed Dress']")
    public WebElement printedDressItem;

    @FindBy(css=".ajax_add_to_cart_button")
    public WebElement addToCartonImage;

    @FindBy(css=".shopping_cart")
    public WebElement cartDetails;

    public ListofItems(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
}
