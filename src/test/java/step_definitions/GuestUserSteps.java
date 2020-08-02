package step_definitions;

import com.github.javafaker.Faker;
import cucumber.api.java.en.And;
import pageobjects.CreateAccount;
import pageobjects.GuestUser;

public class GuestUserSteps extends ObjectClass{
    CreateAccount createAccount=new CreateAccount(driver);

    @And("I enter email address and complete create account process")
    public void iEnterFollowingEmailAddressAndStartCreateAccountProcess() throws InterruptedException {
        wait.waitAndSendKeysByElement(createAccount.emailAddressCreateAccount,createAccount.email);
        wait.waitAndClick(createAccount.createanAccount);
        createAccount.createUserAccount();
    }


}
