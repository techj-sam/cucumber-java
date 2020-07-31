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

    @FindBy(xpath="//button/span[contains(text(),'Proceed to checkout')]")
    public WebElement proceedToCheckout;

    @FindBy(xpath="//button/span[contains(text(),'I confirm my order')]")
    public WebElement confirmMyOrder;

    @FindBy(xpath="//label[@for='cgv']")
    public WebElement termsofServiceCheckbox;

    @FindBy(css=".cheque")
    public WebElement payByCheque;

    @FindBy(css=".alert-success")
    public WebElement orderSuccessMessage;

    public CheckoutProcess(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
}
