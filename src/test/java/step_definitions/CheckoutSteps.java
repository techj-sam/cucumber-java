package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import pageobjects.CheckoutProcess;
import pageobjects.ListofItems;

import static org.junit.Assert.assertTrue;

public class CheckoutSteps extends ObjectClass{
    ListofItems listofItems=new ListofItems(driver);
    CheckoutProcess checkoutProcess=new CheckoutProcess(driver);

    @When("I navigate to {string} tab")
    public void iNavigateToTab(String tabName) {
        if(tabName.toLowerCase().equalsIgnoreCase("dresses")){
            actions.moveToElement(listofItems.dressestab).click().build().perform();
        }
    }

    @And("I select {string} as subcategory")
    public void iSelectAsSubcategory(String subcategory) {
        if(subcategory.toLowerCase().equalsIgnoreCase("evening dresses"))
        actions.moveToElement(wait.waitAndReturnElement(driver,By.linkText(subcategory))).click().build().perform();
    }


    @And("I select {string} item and add it to cart")
    public void iSelectItemAndAddItToCart(String nameofItem) {
        if(nameofItem.toLowerCase().equalsIgnoreCase("printed dress")){
            actions.moveToElement(listofItems.printedDressItem).build().perform();
            wait.waitUntilIsPresent(listofItems.addToCartonImage);
            listofItems.addToCartonImage.click();
        }
    }

    @Then("I proceed to checkout")
    public void iProceedToCheckout() throws InterruptedException {
        wait.waitUntilIsPresent(checkoutProcess.proceedToCheckoutononLayer);
        checkoutProcess.proceedToCheckoutononLayer.click();
    }

    @And("I see summary of order and proceed ahead")
    public void iSeeSummaryOfOrderAndProceedAhead() throws InterruptedException {
        wait.waitAndClick(checkoutProcess.procceedToCheckoutonSummary);
    }

    @And("I confirm address and proceed ahead")
    public void iConfirmAddressAndProceedAhead() {
        wait.waitAndClick(checkoutProcess.proceedToCheckout);
    }

    @And("I agree terms of service and proceed ahead")
    public void iAgreeTermsOfServiceAndProceedAhead() {
        wait.waitUntilIsPresent(checkoutProcess.termsofServiceCheckbox);
        checkoutProcess.termsofServiceCheckbox.click();
        wait.waitAndClick(checkoutProcess.proceedToCheckout);
    }


    @And("I confirm the amount to be paid and select payment option {string}")
    public void iConfirmTheAmountToBePaidAndSelectPaymentOption(String paymentMethod) {
        wait.waitAndClick(checkoutProcess.payByCheque);
    }

    @Then("I confirm my order")
    public void iConfirmMyOrder() {
        wait.waitAndClick(checkoutProcess.confirmMyOrder);
        }

    @And("I can see order completion message")
    public void iCanSeeOrderCompletionMessage() {
        assertTrue(wait.waitAndReturnElement(checkoutProcess.orderSuccessMessage).getText().contains("Your order on My Store is complete."));
    }

    @And("I see that cart is filled with {string} item")
    public void iSeeThatCartIsFilledWithItem(String itemName) {
        wait.waitUntilIsPresent(driver.findElement(By.xpath("//*[@class='cart-info']//a[contains(text(),'"+itemName+"')]")));
    }
}
