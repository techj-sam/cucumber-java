package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.Wait;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import pageobjects.LoginPage;

public class LoginSteps extends BaseClass {
    LoginPage loginPage = new LoginPage(driver);
    static Wait wait = new Wait();
    Actions actions = new Actions(driver);

    public void loginWithCredentials(String username, String password) {
        loginPage.username.sendKeys(username);
        wait.waitAndSendKeysByElement(loginPage.password, password);
        wait.waitAndClick(loginPage.signMeInButton);
    }

    @Given("^I go to Home page$")
    public void iNavigateToHompage() throws Throwable {
        loginPage.navigateToLoginPage();
    }

	
	@And("^I click on 'SIGN ME IN' button$")
	public void iClickOnSIGNMEINButton()
	{
		loginPage.signMeInButton.click();
	}

	@Then("^I should still see login page$")
	public void iShouldStillSeeLoginPage() 
	{
		
	}

	@When("^I enter in 'Password' field value \"([^\"]*)\"$")
	public void iEnterInPasswordFieldValue(String password)
	{
		loginPage.password.sendKeys(password);
	}

	@Then("^I should get message \"([^\"]*)\"$")
	public void iShouldGetMessage(String message)
	{
		assertTrue("UserName Password Validation Failed",loginPage.invalidUserNamePasswordMessage.getText().equals(message));
	}

	@When("I navigate to login page")
	public void iNavigateToLoginPage() {
    	wait.waitAndReturnElement(driver.findElement(By.className("login"))).click();
	}

	@And("I enter username as {string}")
	public void iEnterUsernameAs(String username) {
    	wait.waitAndReturnElement(driver.findElement(By.id("Email"))).click();
	}

	@And("I enter password as {string}")
	public void iEnterPasswordAs(String password) {

	}
}
