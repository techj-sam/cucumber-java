package step_definitions;

import cucumber.api.java.en.When;
import org.openqa.selenium.interactions.Actions;
import pageobjects.ListofItems;


public class Checkout extends ObjectClass{
    ListofItems listofItems=new ListofItems(driver);

    @When("I navigate to {string} tab")
    public void iNavigateToTab(String tabName) {
        if(tabName.toLowerCase().equalsIgnoreCase("dresses")){
            actions.moveToElement(listofItems.dressestab).click().build().perform();
        }
    }


}
