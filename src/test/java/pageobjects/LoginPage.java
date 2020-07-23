package pageobjects;

import helpers.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import step_definitions.BaseClass;

public class LoginPage extends BaseClass {
    private Wait wait = new Wait();

    @FindBy(id = "email")
    public WebElement username;

    @FindBy(id = "isPasswd")
    public WebElement password;

    @FindBy(xpath = "//input[@value='Sign me in']")
    public WebElement signMeInButton;
    
    @FindBy(xpath = "//p[@class='error']")
    public WebElement invalidUserNamePasswordMessage;


    public LoginPage(WebDriver driver) {
        driver = this.driver;
        PageFactory.initElements(driver, this);
    }


    public LoginPage loginAs(String user, String pwd) {

        WebElement element = wait.waitAndReturnElement(username);
        element.sendKeys(user);
        password.sendKeys(pwd);
        signMeInButton.submit();
        return new LoginPage(driver);
    }
}

