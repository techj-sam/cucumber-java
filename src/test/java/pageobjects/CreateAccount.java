package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccount {

    @FindBy(id="email_create")
    public WebElement emailAddressCreateAccount;

    public CreateAccount(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
}
