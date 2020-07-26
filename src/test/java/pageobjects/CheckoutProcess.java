package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import step_definitions.BaseClass;

public class CheckoutProcess extends BaseClass {

    @FindBy(css="[title='Proceed to checkout']")
    public WebElement proceedToCheckoutononLayer;

    @FindBy(css=".standard-checkout")
    public WebElement procceedToCheckoutonSummary;

    @FindBy(css="button[type='submit']")
    public WebElement  submitorProceedToCheckout;

    @FindBy(id="cgv")
    public WebElement termsofServiceCheckbox;

    @FindBy(css=".cheque")
    public WebElement payByCheque;

    public CheckoutProcess(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
}
