package pageobjects;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import helpers.SelectElements;
import helpers.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import step_definitions.BaseClass;

import java.util.Locale;

public class CreateAccount extends BaseClass {

    FakeValuesService fakeValuesService=new FakeValuesService(new Locale("en-GB"), new RandomService());
    public String email = fakeValuesService.bothify("?????###@gmail4.com");
    public String password =  fakeValuesService.bothify("??????##*");
    Wait wait=new Wait();
    Faker faker=new Faker();
    SelectElements select=new SelectElements();

    @FindBy(id="email_create")
    public WebElement emailAddressCreateAccount;

    @FindBy(id="id_gender1")
    public WebElement genderMale;

    @FindBy(id="customer_firstname")
    public WebElement firstNameField;

    @FindBy(id="customer_firstname")
    public WebElement customerFirstName;

    @FindBy(id="customer_firstname")
    public WebElement customerlastname;

    @FindBy(id="customer_lastname")
    public WebElement lastNameField;

    @FindBy(id="passwd")
    public WebElement passwordField;

    @FindBy(id="address1")
    public WebElement address;

    @FindBy(id="days")
    public WebElement dayinDOB;

    @FindBy(id="months")
    public WebElement monthinDOB;

    @FindBy(id="years")
    public WebElement yearinDOB;

    @FindBy(id="id_country")
    public WebElement country;

    @FindBy(id="city")
    public WebElement city;

    @FindBy(id="id_state")
    public WebElement state;

    @FindBy(id="postcode")
    public WebElement zip;

    @FindBy(id="phone_mobile")
    public WebElement phone;

    @FindBy(id="alias")
    public WebElement otherAddress;

    @FindBy(id="submitAccount")
    public WebElement submitAccount;

    @FindBy(id="SubmitCreate")
    public WebElement createanAccount;

    public CreateAccount(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    /*
    This function will create account. it will enter email address first and then proceed ahead for account creation
    It will fill all mandatory fields and register it.

    */
    public void createUserAccount() throws InterruptedException {
        String firstName=faker.name().firstName();
        String lastName=faker.name().lastName();

        wait.waitAndSendKeysByElement(emailAddressCreateAccount,email);
        wait.waitAndClick(createanAccount);
        wait.waitAndClick(genderMale);
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        passwordField.sendKeys(password);
        select.selectByIndexNumbert(dayinDOB,10);
        select.selectByIndexNumbert(monthinDOB,6);
        select.selectByIndexNumbert(yearinDOB,30);

        customerFirstName.sendKeys(firstName);
        customerlastname.sendKeys(lastName);

        address.sendKeys(faker.address().fullAddress());
        city.sendKeys(faker.address().city());
        select.selectByVisibleText(state,"Alaska");
        zip.sendKeys("78905");

        select.selectByVisibleText(country,"United States");
        otherAddress.sendKeys(faker.address().secondaryAddress());

        phone.sendKeys(faker.phoneNumber().cellPhone());

        submitAccount.click();
    }
}
