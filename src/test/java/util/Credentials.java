package util;

import helpers.Wait;
import pageobjects.LoginPage;
import step_definitions.BaseClass;
import step_definitions.LoginSteps;

import java.util.logging.Level;

public class Credentials extends BaseClass {
    String cred;
    public static String username;
    public LoginPage loginPage = new LoginPage(driver);
    public Wait wait = new Wait();

    public String getCredentials() {
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
        cred = System.getProperty("CRED");
        if (cred == null) {
            cred = System.getenv("CRED");
            if (cred == null) {
                cred = "Test1234";
            }
        }
        System.out.println("The test is running on " + cred.toUpperCase() + " Credentials");
        switch (cred.toLowerCase()) {

            case "neosoft":
                username = "samj@neosofttech.com";
                loginPage.loginWithCredentials(username, "123456");
                break;

            case "test1234":
                username = "Test12@gmail7.com";
                loginPage.loginWithCredentials(username, "automate1*");
                break;
        }
        return username;
    }

    public static String userNameUsed() {
        return username;
    }
}
