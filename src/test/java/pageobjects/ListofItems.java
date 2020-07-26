package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import step_definitions.BaseClass;

public class ListofItems extends BaseClass {

    @FindBy(linkText = "Dresses")
    public WebElement dressestab;

    @FindBy(css="a[title='Evening Dresses']")
    public WebDriver eveningDresses;

    @FindBy(css="img[title='Printed Dress']")
    public WebDriver printedDresses;

    @FindBy(css=".ajax_add_to_cart_button")
    public WebElement addToCartonImage;

    @FindBy(css="[title='Proceed to checkout']")
    public WebElement proceedToCheckoutononLayer;

    @FindBy(css="button[type='submit']")
    public WebElement  submitorProceedToCheckout;

    @FindBy(id="cgv")
    public WebElement termsofServiceCheckbox;

    @FindBy(css=".cheque")
    public WebElement payByCheque;

    public ListofItems(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
}
