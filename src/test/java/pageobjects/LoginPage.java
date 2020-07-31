package pageobjects;

import helpers.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import step_definitions.BaseClass;
import step_definitions.ObjectClass;

public class LoginPage extends BaseClass{
    private Wait wait = new Wait();

    @FindBy(id = "email")
    public WebElement username;

    @FindBy(css=".login")
    public WebElement signinLink;

    @FindBy(id = "passwd")
    public WebElement password;

    @FindBy(id = "SubmitLogin")
    public WebElement signinButton;
    
    @FindBy(xpath = "//*[@class='alert alert-danger']//li")
    public WebElement errorMessageDiv;

    @FindBy(css="[title$=\"shopping cart\"]")
    public WebElement myCart;

    @FindBy(id="SubmitCreate")
    public WebElement createAccount;

    public LoginPage(WebDriver driver) {
        driver = this.driver;
        PageFactory.initElements(driver, this);
    }

    public void loginWithCredentials(String arg0_Username, String arg1_Password) {
        wait.waitAndClick(signinLink);
        username.sendKeys(arg0_Username);
        wait.waitAndSendKeysByElement(password, arg1_Password);
        signinButton.click();
        wait.waitUntilIsPresent(driver.findElement(By.cssSelector(".logout")));
    }

    public LoginPage loginAs(String user, String pwd) {
        WebElement element = wait.waitAndReturnElement(username);
        element.sendKeys(user);
        password.sendKeys(pwd);
//        signMeInButton.submit();
        return new LoginPage(driver);
    }
}

