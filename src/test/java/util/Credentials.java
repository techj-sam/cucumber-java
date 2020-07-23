package util;

import helpers.Wait;
import pageobjects.LoginPage;
import step_definitions.BaseClass;
import step_definitions.LoginSteps;

import java.util.logging.Level;

public class Credentials extends BaseClass {
    String cred;
    public static String username;
    public LoginSteps loginSteps = new LoginSteps();
    public LoginPage loginPage = new LoginPage(driver);
    public Wait wait = new Wait();

    public String getCredentials() {
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
        cred = System.getProperty("CRED");
        if (cred == null) {
            cred = System.getenv("CRED");
            if (cred == null) {
                cred = "brightlinemanagerqa";
            }
        }
        System.out.println("The test is running on " + cred.toUpperCase() + " Credentials");
        switch (cred.toLowerCase()) {

            case "aman":
                username = "aman";
                loginSteps.loginWithCredentials(username, "123456");
                break;

            case "aman1":
                username = "aman";
                loginSteps.loginWithCredentials(username, "123456");
                break;
        }
        return username;
    }

    public void clientLogins(String clientName) {
        String password = "123456";

        switch (clientName) {
            case "aman":
                username = "aman";
                loginSteps.loginWithCredentials(username, password);
                break;

            case "aman1":
                username = "aman";
                loginSteps.loginWithCredentials(username, password);
                break;

        }

    }

    public static String userNameUsed() {
        return username;
    }
}
