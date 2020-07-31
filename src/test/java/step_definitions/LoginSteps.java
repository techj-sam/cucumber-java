package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.Wait;

import static org.junit.Assert.assertTrue;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import util.Credentials;

import java.util.List;

public class LoginSteps extends ObjectClass {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage=new HomePage(driver);
    Credentials credentials=new Credentials();

    @Given("^I go to Home page$")
    public void iNavigateToHompage() throws Throwable {
        loginPage.navigateToLoginPage();
    }

	@When("^I enter in 'Password' field value \"([^\"]*)\"$")
	public void iEnterInPasswordFieldValue(String password)
	{
		loginPage.password.sendKeys(password);
	}

	@Then("^I should get message \"([^\"]*)\"$")
	public void iShouldGetMessage(String message)
	{
//		assertTrue("UserName Password Validation Failed",loginPage.invalidUserNamePasswordMessage.getText().equals(message));
	}

	@When("I navigate to login page")
	public void iNavigateToLoginPage() {
		wait.waitAndClick(loginPage.signinLink);
	}

	@And("I enter username as {string}")
	public void iEnterUsernameAs(String username) {
    	wait.waitAndSendKeysByElement(loginPage.username,username);
	}

	@And("I enter password as {string}")
	public void iEnterPasswordAs(String password) {
    	wait.waitAndSendKeysByElement(loginPage.password,password);
	}

	@And("I click on Sign-in button")
	public void iClickOnSignInButton() {
    	wait.waitAndReturnElement(loginPage.signinButton).click();
	}

	@Then("I should be able login to the application")
	public void iShouldBeAbleLoginToTheApplication() {
    	wait.waitAndReturnElement(homePage.logout);
	}

	@Then("I should see following error message")
	public void iShouldSeeFollowingErrorMessage(DataTable errorMessages) {
    	List<List<String>> errors=errorMessages.cells();
    	assertTrue("This error message not found "+errors.get(0).get(0)
				,loginPage.errorMessageDiv.getText().contains(errors.get(0).get(0)));
	}

	@And("I should not able to login to the application")
	public void iShouldNotAbleToLoginToTheApplication() {
    	assertTrue("User might be log in to the application",
				loginPage.signinLink.isDisplayed());
	}

	@Given("I login with correct credentials")
	public void iLoginWithCorrectCredentials() throws InterruptedException {
		loginPage.navigateToLoginPage();
		credentials.getCredentials();
	}

	@Then("I can see sign-in section or create an account section")
	public void iCanSeeSignInSectionOrCreateAnAccountSection() {
		wait.waitAndReturnElement(loginPage.signinButton);
		wait.waitUntilIsPresent(loginPage.createAccount);
	}
}
