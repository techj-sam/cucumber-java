package step_definitions;

import com.github.javafaker.Faker;
import helpers.Wait;
import org.openqa.selenium.interactions.Actions;
import util.Credentials;

public class ObjectClass extends BaseClass {

    static Wait wait = new Wait();
    Faker faker = new Faker();
    Actions actions = new Actions(driver);
}
