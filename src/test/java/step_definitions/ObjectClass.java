package step_definitions;

import helpers.Wait;
import org.openqa.selenium.interactions.Actions;
import util.Credentials;

public class ObjectClass extends BaseClass {

    static Wait wait = new Wait();
    Actions actions = new Actions(driver);
}
