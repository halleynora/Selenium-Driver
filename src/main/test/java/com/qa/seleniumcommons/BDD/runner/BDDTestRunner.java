package com.qa.seleniumcommons.BDD.runner;

import com.qa.seleniumcommons.BrowserDriver;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

/**
 * This class defines the glue that connects the feature files, the java Step Definitions and the configurations for the Cucumber Tags and Output format Use to
 * test grid
 *
 *
 */

@RunWith(Cucumber.class)
@CucumberOptions(format = { "pretty", "html:target/results",
        "json:target/results.json" }, features = "src/main/test/resources/com.qa.seleniumcommons", glue = { "src/main/test/java/com/qa/seleniumcommons/BDD/stepdefs" },
        // tags={"@new"}
        tags = { "@chrometest" })
public class BDDTestRunner {

    @BeforeClass
    public static void setup() {
        System.out.println("Ran the before");
    }

    @AfterClass
    public static void teardown() {
        System.out.println("Ran the after");
        if (BrowserDriver.whereToRun != null && BrowserDriver.whereToRun.equalsIgnoreCase("local")) {
            // BrowserDriverSteps.displayHtmlResult();
        }
    }
}
