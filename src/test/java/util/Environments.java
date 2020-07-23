package util;

import step_definitions.BaseClass;

import java.util.logging.Level;

public class Environments extends BaseClass{

    public  Environments() throws InterruptedException {

        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");

        String env = System.getProperty("ENV");

            if (env==null){
                env = "qa";
        }

        System.out.println("The test is running on " + env.toUpperCase() + " environment");
        switch (env.toLowerCase()) {

            case "dev":
                driver.get("http://automationpractice.com/index.php");
                break;

            case "qa":
                driver.get("http://automationpractice.com/index.php");
                break;

        }
    }
}
